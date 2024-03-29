package com.jack.projectdossier.repositories;

import com.jack.projectdossier.TestDataUtil;
import com.jack.projectdossier.dao.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryIntegrationTests {
    private final UserRepository underTest;

    @Autowired
    public UserRepositoryIntegrationTests(UserRepository userRepository) {
        this.underTest = userRepository;
    }

    @Test
    void testThatUserCanBeCreatedAndRecalled() {
        // Arrange
        UserEntity user = TestDataUtil.createBasicTestUser();
        underTest.save(user);
        Instant now = Instant.now();
        // Act
        Optional<UserEntity> result = underTest.findById(user.getId());
        // Assert
        user.setCreatedAt(now.truncatedTo(ChronoUnit.SECONDS));
        user.setUpdatedAt(now.truncatedTo(ChronoUnit.SECONDS));
        assertThat(result).isPresent();
        UserEntity dbUser = result.get();

        Instant dbCreationDate = dbUser.getCreatedAt().truncatedTo(ChronoUnit.SECONDS);
        Instant dbUpdateDate = dbUser.getUpdatedAt().truncatedTo(ChronoUnit.SECONDS);

        dbUser.setCreatedAt(dbCreationDate);
        dbUser.setUpdatedAt(dbUpdateDate);

        assertThat(dbUser).isEqualTo(user);
    }
}
