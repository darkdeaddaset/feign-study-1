package ru.savin.feign.mapper;

import org.mapstruct.Mapper;
import ru.savin.feign.entity.Employee;
import ru.savin.feign.response.EmployeeResponse;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeResponse toResponse(Employee employee);
}
