package com.jack.projectdossier.repositories;

import com.jack.projectdossier.dao.entities.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TokenRepository  extends JpaRepository<TokenEntity, Long> {

    @Query(
           value = """
                SELECT t FROM TokenEntity t INNER JOIN UserEntity u\s
                ON t.user.id = u.id\s
                WHERE u.id = :id AND (t.revoked = FALSE AND t.expired = FALSE )\s
            """
    )
    List<TokenEntity> findAllValidTokenByCustomer(Long id);
    Optional<TokenEntity> findByToken(String token);
}
