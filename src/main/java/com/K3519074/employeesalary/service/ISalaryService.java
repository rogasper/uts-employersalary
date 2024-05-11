package com.K3519074.employeesalary.service;

import com.K3519074.employeesalary.dto.InputDto;

public interface ISalaryService {
    Integer calculateFamily(InputDto inputDto);
    Integer calculateCEOOvertime(InputDto inputDto);
    Integer calculateManagerOvertime(InputDto inputDto);
    Integer calculateSeniorOvertime(InputDto inputDto);
    Integer calculateBasicOvertime(InputDto inputDto);
}
