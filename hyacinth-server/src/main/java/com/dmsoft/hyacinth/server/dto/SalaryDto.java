package com.dmsoft.hyacinth.server.dto;

import com.dmsoft.bamboo.common.dto.AbstractValueObject;

public class SalaryDto extends AbstractValueObject {

   private  Long id;
   private String code;
   private String name;
    private float basic_salary	;
   private float overtime_wage;
   private float post_allowance;
    private float   performance_allowance;
    private float   total_contract_wages;
    private float   seniority_allowance;
    private float   meal_allowance;
    private float    other_allowance;
    private float   other_pre_tax_buckle;
    private float    total_payroll;
    private float   real_basic_salary;
    private float   real_overtime_allowance;
    private float   real_post_allowance;
    private float  real_performance_allwoance;
    private float  sick_pay ;
    private float  gross_pay ;
    private float  social_security ;
    private float  housing_fund ;
    private float  income_tax ;
    private float  hotel_expense ;
    private float  water_electricity ;
    private float    mutual_fund ;
    private float telephone_fare ;
    private float  networ_fee;
    private float deductions_after_tax;
    private float real_salary;
    private float real_allwoance;
    private float total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(float basic_salary) {
        this.basic_salary = basic_salary;
    }

    public float getOvertime_wage() {
        return overtime_wage;
    }

    public void setOvertime_wage(float overtime_wage) {
        this.overtime_wage = overtime_wage;
    }

    public float getPost_allowance() {
        return post_allowance;
    }

    public void setPost_allowance(float post_allowance) {
        this.post_allowance = post_allowance;
    }

    public float getPerformance_allowance() {
        return performance_allowance;
    }

    public void setPerformance_allowance(float performance_allowance) {
        this.performance_allowance = performance_allowance;
    }

    public float getTotal_contract_wages() {
        return total_contract_wages;
    }

    public void setTotal_contract_wages(float total_contract_wages) {
        this.total_contract_wages = total_contract_wages;
    }

    public float getSeniority_allowance() {
        return seniority_allowance;
    }

    public void setSeniority_allowance(float seniority_allowance) {
        this.seniority_allowance = seniority_allowance;
    }

    public float getMeal_allowance() {
        return meal_allowance;
    }

    public void setMeal_allowance(float meal_allowance) {
        this.meal_allowance = meal_allowance;
    }

    public float getOther_allowance() {
        return other_allowance;
    }

    public void setOther_allowance(float other_allowance) {
        this.other_allowance = other_allowance;
    }

    public float getOther_pre_tax_buckle() {
        return other_pre_tax_buckle;
    }

    public void setOther_pre_tax_buckle(float other_pre_tax_buckle) {
        this.other_pre_tax_buckle = other_pre_tax_buckle;
    }

    public float getTotal_payroll() {
        return total_payroll;
    }

    public void setTotal_payroll(float total_payroll) {
        this.total_payroll = total_payroll;
    }

    public float getReal_basic_salary() {
        return real_basic_salary;
    }

    public void setReal_basic_salary(float real_basic_salary) {
        this.real_basic_salary = real_basic_salary;
    }

    public float getReal_overtime_allowance() {
        return real_overtime_allowance;
    }

    public void setReal_overtime_allowance(float real_overtime_allowance) {
        this.real_overtime_allowance = real_overtime_allowance;
    }

    public float getReal_post_allowance() {
        return real_post_allowance;
    }

    public void setReal_post_allowance(float real_post_allowance) {
        this.real_post_allowance = real_post_allowance;
    }

    public float getReal_performance_allwoance() {
        return real_performance_allwoance;
    }

    public void setReal_performance_allwoance(float real_performance_allwoance) {
        this.real_performance_allwoance = real_performance_allwoance;
    }

    public float getSick_pay() {
        return sick_pay;
    }

    public void setSick_pay(float sick_pay) {
        this.sick_pay = sick_pay;
    }

    public float getGross_pay() {
        return gross_pay;
    }

    public void setGross_pay(float gross_pay) {
        this.gross_pay = gross_pay;
    }

    public float getSocial_security() {
        return social_security;
    }

    public void setSocial_security(float social_security) {
        this.social_security = social_security;
    }

    public float getHousing_fund() {
        return housing_fund;
    }

    public void setHousing_fund(float housing_fund) {
        this.housing_fund = housing_fund;
    }

    public float getIncome_tax() {
        return income_tax;
    }

    public void setIncome_tax(float income_tax) {
        this.income_tax = income_tax;
    }

    public float getHotel_expense() {
        return hotel_expense;
    }

    public void setHotel_expense(float hotel_expense) {
        this.hotel_expense = hotel_expense;
    }

    public float getWater_electricity() {
        return water_electricity;
    }

    public void setWater_electricity(float water_electricity) {
        this.water_electricity = water_electricity;
    }

    public float getMutual_fund() {
        return mutual_fund;
    }

    public void setMutual_fund(float mutual_fund) {
        this.mutual_fund = mutual_fund;
    }

    public float getTelephone_fare() {
        return telephone_fare;
    }

    public void setTelephone_fare(float telephone_fare) {
        this.telephone_fare = telephone_fare;
    }

    public float getNetwor_fee() {
        return networ_fee;
    }

    public void setNetwor_fee(float networ_fee) {
        this.networ_fee = networ_fee;
    }

    public float getDeductions_after_tax() {
        return deductions_after_tax;
    }

    public void setDeductions_after_tax(float deductions_after_tax) {
        this.deductions_after_tax = deductions_after_tax;
    }

    public float getReal_salary() {
        return real_salary;
    }

    public void setReal_salary(float real_salary) {
        this.real_salary = real_salary;
    }

    public float getReal_allwoance() {
        return real_allwoance;
    }

    public void setReal_allwoance(float real_allwoance) {
        this.real_allwoance = real_allwoance;
    }


}
