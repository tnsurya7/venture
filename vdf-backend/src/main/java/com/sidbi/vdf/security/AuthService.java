package com.sidbi.vdf.security;

import com.sidbi.vdf.domain.UserAccount;
import com.sidbi.vdf.domain.enums.SidbiRole;
import com.sidbi.vdf.domain.enums.UserType;
import com.sidbi.vdf.repository.UserAccountRepository;
import com.sidbi.vdf.security.dto.AuthSessionDto;
import com.sidbi.vdf.security.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponse login(String email, String password) {

        log.info("Login request received for email: {}", email);

        UserAccount user = userAccountRepository.findByEmailAndEnabledTrue(email)
            .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));

        log.info("User found: {}", user);

        log.info("Password hash: {}", user.getPasswordHash());
        log.info("Password: {}", password);
        
        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new BadCredentialsException("Invalid email or password");
        }
        String token = jwtTokenProvider.createAccessToken(
            user.getId().toString(),
            user.getEmail(),
            user.getUserType(),
            user.getSidbiRole()
        );
        return LoginResponse.builder()
            .accessToken(token)
            .user(AuthSessionDto.builder()
                .email(user.getEmail())
                .userType(user.getUserType())
                .sidbiRole(user.getSidbiRole())
                .build())
            .build();
    }

    public AuthSessionDto sessionFromEmail(String email) {
        UserAccount user = userAccountRepository.findByEmailAndEnabledTrue(email)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return AuthSessionDto.builder()
            .email(user.getEmail())
            .userType(user.getUserType())
            .sidbiRole(user.getSidbiRole())
            .build();
    }
}
