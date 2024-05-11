package com.K3519074.employeesalary.controller;

import com.K3519074.employeesalary.dto.AllowanceDto;
import com.K3519074.employeesalary.dto.InputDto;
import com.K3519074.employeesalary.dto.OutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.K3519074.employeesalary.service.SalaryService;

@RestController
@RequestMapping("/api/payrollinfo")
public class SalaryController
{
    private Integer basicsalary = 4500;

    private InputDto inputDto;

    @Autowired
    @Qualifier("Service1")
    private SalaryService salaryService;

    @PostMapping("/ceo")
    public ResponseEntity<OutputDto> getCEOSalary(@RequestBody InputDto inputDto)
    {
        AllowanceDto allowanceDto = new AllowanceDto();
        Integer totalfamily = salaryService.calculateFamily(inputDto);
        Integer totalovertime = salaryService.calculateCEOOvertime(inputDto);
        Integer total = basicsalary * 8;
        String family = String.valueOf("$" + totalfamily);
        String overtime = String.valueOf("$"+ totalovertime);
        String totalSalary = String.valueOf("$"+total);

        allowanceDto.setFamily(family);
        allowanceDto.setOvertime(overtime);
        OutputDto outputDto = new OutputDto();
        outputDto.setInfo(inputDto);
        outputDto.setBasicsalary(totalSalary);
        outputDto.setAllowance(allowanceDto);
        return ResponseEntity.ok(outputDto);
    }

    @PostMapping("/manager")
    public ResponseEntity<OutputDto> getManagerSalary(@RequestBody InputDto inputDto)
    {
        AllowanceDto allowanceDto = new AllowanceDto();
        Integer totalfamily = salaryService.calculateFamily(inputDto);
        Integer totalovertime = salaryService.calculateManagerOvertime(inputDto);
        Integer total = basicsalary * 3;
        String family = String.valueOf("$" + totalfamily);
        String overtime = String.valueOf("$"+ totalovertime);
        String totalSalary = String.valueOf("$"+total);

        allowanceDto.setFamily(family);
        allowanceDto.setOvertime(overtime);
        OutputDto outputDto = new OutputDto();
        outputDto.setInfo(inputDto);
        outputDto.setBasicsalary(totalSalary);
        outputDto.setAllowance(allowanceDto);
        return ResponseEntity.ok(outputDto);
    }

    @GetMapping("/senioremp/{family}/{overtime}")
    public ResponseEntity<OutputDto> getSeniorSalary(@PathVariable("family") Integer fa, @PathVariable("overtime") Integer ov)
    {
        InputDto inputDto = new InputDto();
        inputDto.setFamily(fa);
        inputDto.setOvertime(ov);
        AllowanceDto allowanceDto = new AllowanceDto();
        Integer totalfamily = salaryService.calculateFamily(inputDto);
        Integer totalovertime = salaryService.calculateSeniorOvertime(inputDto);
        Integer total = basicsalary * 2;
        String family = String.valueOf("$" + totalfamily);
        String overtime = String.valueOf("$"+ totalovertime);
        String totalSalary = String.valueOf("$"+total);

        allowanceDto.setFamily(family);
        allowanceDto.setOvertime(overtime);
        OutputDto outputDto = new OutputDto();
        outputDto.setInfo(inputDto);
        outputDto.setBasicsalary(totalSalary);
        outputDto.setAllowance(allowanceDto);
        return ResponseEntity.ok(outputDto);
    }

    @GetMapping("/defaultemp/{family}/{overtime}")
    public ResponseEntity<OutputDto> getDefaultSalary(@PathVariable("family") Integer fa, @PathVariable("overtime") Integer ov)
    {
        InputDto inputDto = new InputDto();
        inputDto.setFamily(fa);
        inputDto.setOvertime(ov);
        AllowanceDto allowanceDto = new AllowanceDto();
        Integer totalfamily = salaryService.calculateFamily(inputDto);
        Integer totalovertime = salaryService.calculateBasicOvertime(inputDto);
        Integer total = basicsalary;
        String family = String.valueOf("$" + totalfamily);
        String overtime = String.valueOf("$"+ totalovertime);
        String totalSalary = String.valueOf("$"+total);

        allowanceDto.setFamily(family);
        allowanceDto.setOvertime(overtime);
        OutputDto outputDto = new OutputDto();
        outputDto.setInfo(inputDto);
        outputDto.setBasicsalary(totalSalary);
        outputDto.setAllowance(allowanceDto);
        return ResponseEntity.ok(outputDto);
    }
}
