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
        Instant now = Instant.now();
        underTest.save(user);
        // Act
        Optional<UserEntity> result = underTest.findById(user.getId());
        // Assert
        //noinspection OptionalGetWithoutIsPresent
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        assertThat(result).isPresent();
        UserEntity dbUser = result.get();

        Instant dbCreationDate = dbUser.getCreatedAt().truncatedTo(ChronoUnit.SECONDS);
        Instant dbUpdateDate = dbUser.getUpdatedAt().truncatedTo(ChronoUnit.SECONDS);

        dbUser.setCreatedAt(now);
        dbUser.setUpdatedAt(now);

        assertThat(dbUser).isEqualTo(user);
//        assertThat(result.get().getId()).isEqualTo(user.getId());
//        assertThat(result.get().getName()).isEqualTo(user.getName());
//        assertThat(result.get().getSurname()).isEqualTo(user.getSurname());
//        assertThat(result.get().getEmail()).isEqualTo(user.getEmail());
//        assertThat(result.get().getPassword()).isEqualTo(user.getPassword());
    }
}
