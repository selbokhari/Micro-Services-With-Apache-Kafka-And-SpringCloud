package com.sync.microservices.spring.cloud.projet.employeeservice.mapper;


import com.sync.microservices.spring.cloud.projet.employeeservice.dto.EmployeeDto;
import com.sync.microservices.spring.cloud.projet.employeeservice.entity.EmployeeEntity;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface EmployeeMapper {

    EmployeeDto mapToEmployeeDto(EmployeeEntity employeeEntity);

    @Maps( withIgnoreFields = {"codeDepartement"})
    EmployeeDto mapToEmployeeDtoWithIgniorDepartementCode(EmployeeEntity employeeEntity);

    @Maps( withIgnoreFields = {"id"})
    EmployeeEntity mapToEmployeeEntity(EmployeeDto employeeEntity);

}
