package com.jack.projectdossier.repositories;

import com.jack.projectdossier.dao.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<Object> findByEmail(String mail);
}
