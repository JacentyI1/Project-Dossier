package com.jack.projectdossier.mappers.impl;

import com.jack.projectdossier.dao.dtos.DossierDto;
import com.jack.projectdossier.dao.entities.DossierEntity;
import com.jack.projectdossier.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DossierMapper implements Mapper<DossierEntity, DossierDto> {
    private ModelMapper modelMapper;


    @Override
    public DossierDto mapTo(DossierEntity dossierEntity) {
        return modelMapper.map(dossierEntity, DossierDto.class);
    }

    @Override
    public DossierEntity mapFrom(DossierDto dossierDto) {
        return modelMapper.map(dossierDto, DossierEntity.class);
    }
}
