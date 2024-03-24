package com.jack.projectdossier.repositories;

import com.jack.projectdossier.TestDataUtil;
import com.jack.projectdossier.dao.entities.UserEntity;
import com.jack.projectdossier.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceIntegrationTest {
    private final UserService underTest;
    @Autowired
    public UserServiceIntegrationTest(UserService userService) {
        this.underTest = userService;
    }

    @Test
    public void testThatUserPasswordIsCorrectlyEncodedAndSavedInRepository(){
        UserEntity user = TestDataUtil.createBasicTestUser();
        UserEntity result = underTest.createUser(user);
        assertThat(result).isEqualTo(user);
    }

}
