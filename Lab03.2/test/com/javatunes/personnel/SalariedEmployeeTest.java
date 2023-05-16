package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    //this is the business object under test, called a "fixture"
    private SalariedEmployee emp1;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
        emp1 = new SalariedEmployee("Mary", Date.valueOf("2020-10-10"), 1500.00);
        emp2 = new SalariedEmployee("Mary", Date.valueOf("2020-10-10"), 1500.00);
    }

    @Test
    public void equals_shouldReturn_False_differentName_sameHireDate_sameSalary() {
        emp2.setName("June");
        assertNotEquals(emp1,emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate((Date.valueOf("2022-09-10")));
        assertNotEquals(emp1,emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1,emp2);
    }

    @Test
    public void equals_ShouldFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(2000.00);
        assertNotEquals(emp1,emp2);
    }

    @Test
    public void testPay() {
        assertEquals(1500.0, emp1.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.0, emp1.payTaxes(), .001); // expected, actual, Delta - 30% of the salary
    }
}