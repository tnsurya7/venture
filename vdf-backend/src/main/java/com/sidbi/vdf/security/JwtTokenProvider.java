package com.sidbi.vdf.security;

import com.sidbi.vdf.config.JwtProperties;
import com.sidbi.vdf.domain.enums.SidbiRole;
import com.sidbi.vdf.domain.enums.UserType;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    /** Single key instance for both signing and verification to avoid any encoding/derivation mismatch. */
    private SecretKey getSigningKey() {
        String secret = jwtProperties.getSecret();
        if (secret == null || secret.length() < 32) {
            throw new IllegalStateException("vdf.jwt.secret must be set and at least 32 characters (256-bit for HS256)");
        }
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String createAccessToken(String subject, String email, UserType userType, SidbiRole sidbiRole) {
        SecretKey key = getSigningKey();
        Date now = new Date();
        Date expiry = new Date(now.getTime() + jwtProperties.getAccessTokenValidityMinutes() * 60_000L);
        var builder = Jwts.builder()
            .subject(subject)
            .issuer(jwtProperties.getIssuer())
            .issuedAt(now)
            .expiration(expiry)
            .claim("email", email)
            .claim("userType", userType.name())
            .signWith(key);
        if (sidbiRole != null) {
            builder.claim("sidbiRole", sidbiRole.name());
        }
        return builder.compact();
    }

    public JwtClaims parseToken(String token) {
        SecretKey key = getSigningKey();
        Jws<Claims> jws = Jwts.parser()
            .verifyWith(key)
            .requireIssuer(jwtProperties.getIssuer())
            .build()
            .parseSignedClaims(token);
        Claims claims = jws.getPayload();
        String email = claims.get("email", String.class);
        String userTypeStr = claims.get("userType", String.class);
        String sidbiRoleStr = claims.get("sidbiRole", String.class);
        return new JwtClaims(
            claims.getSubject(),
            email != null ? email : claims.getSubject(),
            userTypeStr != null ? UserType.valueOf(userTypeStr) : UserType.applicant,
            sidbiRoleStr != null ? SidbiRole.valueOf(sidbiRoleStr) : null
        );
    }

    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public record JwtClaims(String sub, String email, UserType userType, SidbiRole sidbiRole) {}
}
