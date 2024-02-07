package com.jack.projectdossier.repositories;

import com.jack.projectdossier.domain.entities.DossierEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DossierRepository extends CrudRepository<DossierEntity, String> {
    Optional<DossierEntity>  findAllByDossierId(Long dossierId);
    Optional<DossierEntity> findAllByDossierUser(String dossierUser);
}
