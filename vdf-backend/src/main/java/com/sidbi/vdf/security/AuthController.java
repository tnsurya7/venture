package com.sidbi.vdf.security;

import com.sidbi.vdf.security.dto.AuthSessionDto;
import com.sidbi.vdf.security.dto.LoginRequest;
import com.sidbi.vdf.security.dto.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Authentication endpoints")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Authenticate with email and password, returns JWT and user session")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    @Operation(summary = "Current session", description = "Returns current user session (email, userType, sidbiRole)")
    public ResponseEntity<AuthSessionDto> me(@AuthenticationPrincipal String principal) {
        if (principal == null) {
            return ResponseEntity.status(401).build();
        }
        AuthSessionDto session = authService.sessionFromEmail(principal);
        return ResponseEntity.ok(session);
    }
}
