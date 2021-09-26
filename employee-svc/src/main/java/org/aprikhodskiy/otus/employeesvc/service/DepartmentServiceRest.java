package org.aprikhodskiy.otus.employeesvc.service;

import lombok.extern.slf4j.Slf4j;
import org.aprikhodskiy.otus.employeesvc.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DepartmentServiceRest implements DepartmentService {
    @Value("${integration.department-svc}")
    private String depSvc;
    private RestOperations rest = new RestTemplate();

    @Cacheable("departments")
    @Override
    public DepartmentDTO findById(long id) {
        String url = depSvc + id;
        log.info("External Request for {}", url);
        return rest.getForObject(url, DepartmentDTO.class);
    }
}
