package com.sync.microservices.spring.cloud.projet.departementservice.mapper;

import com.sync.microservices.spring.cloud.projet.departementservice.dto.DepartementDto;
import com.sync.microservices.spring.cloud.projet.departementservice.entity.DepartementEntity;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(
        withIoC = IoC.SPRING
)
public interface DepartementMapper {

    DepartementDto mapTodepartementDto(DepartementEntity departementEntity);

    @Maps( withIgnoreFields = {"id"})
    DepartementEntity mapTodepartement(DepartementDto departementDto);

}
