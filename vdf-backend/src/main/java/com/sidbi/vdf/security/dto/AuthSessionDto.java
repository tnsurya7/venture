package com.sidbi.vdf.security.dto;

import com.sidbi.vdf.domain.enums.SidbiRole;
import com.sidbi.vdf.domain.enums.UserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthSessionDto {
    private String email;
    private UserType userType;
    private SidbiRole sidbiRole;
}
