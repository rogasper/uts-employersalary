package com.K3519074.employeesalary.dto;

public class OutputDto {
    private InputDto info;
    private AllowanceDto allowance;
    private String basicsalary;

    public InputDto getInfo() {
        return info;
    }

    public void setInfo(InputDto info) {
        this.info = info;
    }

    public AllowanceDto getAllowance() {
        return allowance;
    }

    public void setAllowance(AllowanceDto allowance) {
        this.allowance = allowance;
    }

    public String getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(String basicsalary) {
        this.basicsalary = basicsalary;
    }
}
