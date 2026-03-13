package com.sidbi.vdf.config;

import com.sidbi.vdf.domain.UserAccount;
import com.sidbi.vdf.domain.enums.SidbiRole;
import com.sidbi.vdf.domain.enums.UserType;
import com.sidbi.vdf.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Profile("h2")
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userAccountRepository.count() == 0) {
            log.info("Seeding demo users...");
            
            String hashedPassword = passwordEncoder.encode("password");
            
            // Create demo users
            createUser("applicant@demo.com", UserType.applicant, null, hashedPassword);
            createUser("sidbi-maker@demo.com", UserType.sidbi, SidbiRole.maker, hashedPassword);
            createUser("sidbi-checker@demo.com", UserType.sidbi, SidbiRole.checker, hashedPassword);
            createUser("sidbi-convenor@demo.com", UserType.sidbi, SidbiRole.convenor, hashedPassword);
            createUser("sidbi-committee@demo.com", UserType.sidbi, SidbiRole.committee_member, hashedPassword);
            createUser("sidbi-approving@demo.com", UserType.sidbi, SidbiRole.approving_authority, hashedPassword);
            createUser("admin@demo.com", UserType.admin, null, hashedPassword);
            
            log.info("Demo users seeded successfully!");
        }
    }
    
    private void createUser(String email, UserType userType, SidbiRole sidbiRole, String hashedPassword) {
        UserAccount user = UserAccount.builder()
                .id(UUID.randomUUID())
                .email(email)
                .passwordHash(hashedPassword)
                .userType(userType)
                .sidbiRole(sidbiRole)
                .enabled(true)
                .build();
        
        userAccountRepository.save(user);
        log.info("Created user: {} ({})", email, userType);
    }
}