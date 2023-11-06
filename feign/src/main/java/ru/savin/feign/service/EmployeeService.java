package ru.savin.feign.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.savin.feign.entity.Employee;
import ru.savin.feign.feignclient.AddressClient;
import ru.savin.feign.mapper.EmployeeMapper;
import ru.savin.feign.repository.EmployeeRepository;
import ru.savin.feign.response.AddressResponse;
import ru.savin.feign.response.EmployeeResponse;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final AddressClient addressClient;

    public EmployeeResponse getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow();
        EmployeeResponse employeeResponse = employeeMapper.toResponse(employee);


        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressResponse(addressResponse.getBody());

        return employeeResponse;
    }
}