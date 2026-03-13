package com.sidbi.vdf.domain;

import com.sidbi.vdf.domain.enums.SidbiRole;
import com.sidbi.vdf.domain.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "user_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    @Column(name = "sidbi_role")
    private SidbiRole sidbiRole;

    @Column(nullable = false)
    @Builder.Default
    private boolean enabled = true;
}
