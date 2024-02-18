package com.jack.projectdossier.dao.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.security.Permission;
import java.util.Collections;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(
            Collections.emptySet()
            // TODO: Edit permissions for ADMIN
    );

    private final Set<Permission> permissions;

}
