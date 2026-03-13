package com.sidbi.vdf.service;

import com.sidbi.vdf.domain.Registration;
import com.sidbi.vdf.domain.enums.RegistrationStatus;
import com.sidbi.vdf.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public List<Registration> list() {
        return registrationRepository.findAllByOrderBySubmittedAtDesc();
    }

    public Registration getById(UUID id) {
        return registrationRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Registration not found: " + id));
    }

    @Transactional
    public Registration create(Registration registration) {
        registration.setId(null);
        registration.setStatus(RegistrationStatus.pending);
        registration.setSubmittedAt(Instant.now());
        return registrationRepository.save(registration);
    }

    @Transactional
    public void updateStatus(UUID id, RegistrationStatus status) {
        Registration reg = getById(id);
        reg.setStatus(status);
        registrationRepository.save(reg);
    }
}
