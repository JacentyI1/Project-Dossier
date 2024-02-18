package com.jack.projectdossier;

import com.jack.projectdossier.dao.entities.DossierEntity;
import com.jack.projectdossier.dao.entities.UserEntity;

public class TestDataUtil {
    public TestDataUtil() {  }

    public static UserEntity createBasicTestUser() {
        return UserEntity.builder()
                .id(1L)
                .username("J4ck")
                .password("password")
                .email("testEmail@gmail.com")
                .name("Jacenty")
                .surname("Flowersky")
                .build();
    }
    public static DossierEntity createBasicTestDossier() {
        return DossierEntity.builder()
                .id(1L)
                .user(createBasicTestUser())
                .build();
    }
}
