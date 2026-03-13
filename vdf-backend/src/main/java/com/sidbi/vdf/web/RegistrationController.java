package com.sidbi.vdf.web;

import com.sidbi.vdf.domain.Registration;
import com.sidbi.vdf.domain.enums.RegistrationStatus;
import com.sidbi.vdf.service.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
@Tag(name = "Registrations", description = "Company registration (admin list/approve; applicant create)")
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "List registrations (admin)")
    public ResponseEntity<List<Registration>> list() {
        return ResponseEntity.ok(registrationService.list());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get registration by ID (admin)")
    public ResponseEntity<Registration> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(registrationService.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create registration")
    public ResponseEntity<Registration> create(@RequestBody Registration registration) {
        Registration created = registrationService.create(registration);
        return ResponseEntity.ok(created);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update registration status (admin)")
    public ResponseEntity<Void> updateStatus(@PathVariable UUID id, @RequestBody StatusUpdate status) {
        registrationService.updateStatus(id, status.getStatus());
        return ResponseEntity.noContent().build();
    }

    @lombok.Data
    public static class StatusUpdate {
        private RegistrationStatus status;
    }
}
