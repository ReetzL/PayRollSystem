/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payrollsystem;

import java.util.Date;

/**
 *
 * @author behlt
 */
// Fig. 10.6: HourlyEmployee.java
// HourlyEmployee class extends Employee.
public class HourlyEmployee extends Employee {
   private double wage; // wage per hour
   private double hours; // hours worked for week
   private Date birthDate; // employee's birth date

   // constructor
   public HourlyEmployee(String firstName, String lastName,
      String socialSecurityNumber, double wage, double hours, Date birthDate) {
      super(firstName, lastName, socialSecurityNumber);
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");
      }

      this.wage = wage;
      this.hours = hours;
      this.birthDate = birthDate;
   } 

   // set wage
   public void setWage(double wage) {
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      this.wage = wage;
   } 

   // return wage
   public double getWage() {return wage;}

   // set hours worked
   public void setHours(double hours) {
      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");
      }

      this.hours = hours;
   } 

   // return hours worked
   public double getHours() {return hours;}

   // set birth date
   public void setBirthDate(Date birthDate) {
      this.birthDate = birthDate;
   }

   // return birth date
   public Date getBirthDate() {
      return birthDate;
   }

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {                                          
      if (getHours() <= 40) { // no overtime                           
         return getWage() * getHours();                                
      }                                                                
      else {                                                           
         return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;  
      }                                                                
   }                                                                   

   // return String representation of HourlyEmployee object              
   @Override                                                             
   public String toString() {                                            
      return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f; %s: %s", 
         super.toString(), "hourly wage", getWage(),                     
         "hours worked", getHours(), "birth date", getBirthDate());                                    
   }                                                                     
} 




/**
public class HourlyEmployee extends Employee {
   private double wage; // wage per hour
   private double hours; // hours worked for week

   // constructor
   public HourlyEmployee(String firstName, String lastName,
      String socialSecurityNumber, double wage, double hours) {
      super(firstName, lastName, socialSecurityNumber);
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");
      }

      this.wage = wage;
      this.hours = hours;
   } 

   // set wage
   public void setWage(double wage) {
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      this.wage = wage;
   } 

   // return wage
   public double getWage() {return wage;}

   // set hours worked
   public void setHours(double hours) {
      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");
      }

      this.hours = hours;
   } 

   // return hours worked
   public double getHours() {return hours;}

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {                                          
      if (getHours() <= 40) { // no overtime                           
         return getWage() * getHours();                                
      }                                                                
      else {                                                           
         return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;  
      }                                                                
   }                                                                   

   // return String representation of HourlyEmployee object              
   @Override                                                             
   public String toString() {                                            
      return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", 
         super.toString(), "hourly wage", getWage(),                     
         "hours worked", getHours());                                    
   }                                                                     
} 
**/



