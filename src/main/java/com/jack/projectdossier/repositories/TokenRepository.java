package com.jack.projectdossier.repositories;

import com.jack.projectdossier.dao.entities.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository  extends JpaRepository<TokenEntity, Long> {

    @Query(
           value = """
                select t from TokenEntity t inner join UserEntity u\s
                on t.user.id = u.id\s
                where u.id = :id and (t.revoked = false and t.expired = false )\s
            """
    )
    List<TokenEntity> findAllValidTokenByCustomer(Long id);
    Optional<TokenEntity> findByToken(String token);
}
