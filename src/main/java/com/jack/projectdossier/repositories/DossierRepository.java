package com.jack.projectdossier.repositories;

import com.jack.projectdossier.dao.entities.DossierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DossierRepository extends JpaRepository<DossierEntity, String> {
}
