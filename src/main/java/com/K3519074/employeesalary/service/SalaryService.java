package com.K3519074.employeesalary.service;

import com.K3519074.employeesalary.dto.InputDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("Service1")
public class SalaryService implements ISalaryService{

    @Override
    public Integer calculateFamily(InputDto inputDto) {
        return inputDto.getFamily() * 30;
    }

    @Override
    public Integer calculateCEOOvertime(InputDto inputDto) {
        return inputDto.getOvertime() * 20;
    }

    @Override
    public Integer calculateManagerOvertime(InputDto inputDto) {
        return inputDto.getOvertime() * 10;
    }

    @Override
    public Integer calculateSeniorOvertime(InputDto inputDto) {
        return inputDto.getOvertime() * 5;
    }

    @Override
    public Integer calculateBasicOvertime(InputDto inputDto) {
        return inputDto.getOvertime() * 4;
    }
}
