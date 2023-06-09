package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    // business objects unders test
    private Employee emp1;
    private Employee emp2;
    @Before
    public void setUp() {
        emp1 = getEmployee();
        emp2 = getEmployee();
//        emp1 = new DummyEmployee("Lucas", Date.valueOf("2000-01-01"));
//        emp2 = new DummyEmployee("Lucas", Date.valueOf("2000-01-01"));
    }

    private Employee getEmployee() {
        return new Employee("Lucas", Date.valueOf("2000-01-01")) {
            @Override
            public double pay() {return 0;}

            @Override
            public double payTaxes() {return 0;}
        };
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Peter");

        assertNotEquals(emp1,emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2021-10-10"));

        assertNotEquals(emp1,emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1,emp2); //does an equals() check for objects
        assertTrue(emp1.equals(emp2)); //alternative assertion;
    }

    // Member-Level Named inner classes
    private class DummyEmployee extends Employee {

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }

}