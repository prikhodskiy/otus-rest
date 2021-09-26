package org.aprikhodskiy.otus.employeesvc.service;
import io.vavr.CheckedFunction0;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aprikhodskiy.otus.employeesvc.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceRest implements DepartmentService {
    @Value("${integration.department-svc}")
    private String depSvc;
    private RestOperations rest = new RestTemplate();
    private final Resilience4JCircuitBreakerFactory resilience4JCircuitBreakerFactory;

    @Override
    public DepartmentDTO findById(long id) {
        String url = depSvc + id;
        log.info("External Request for {}", url);

        Resilience4JCircuitBreaker circuitBreaker = resilience4JCircuitBreakerFactory.create("department");
        Supplier<DepartmentDTO> dtoSupplier = () -> rest.getForObject(url, DepartmentDTO.class);
        return circuitBreaker.run(dtoSupplier, throwable ->  handleDepartmentInaccessible());
    }

    private DepartmentDTO handleDepartmentInaccessible(){
        return new  DepartmentDTO (-1L, "N/A");
    }
}
