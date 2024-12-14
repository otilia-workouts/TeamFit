package com.resourcemanagement.team_fit.model.basic;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName, firstName;
    private String email;
    private String address;
    private Integer age;
    private boolean married;

    public Person(String lastName, String firstName, String email, String address, Integer age, boolean married) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.married = married;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "Nume: " + lastName + ", Prenume: " + firstName + ", Varsta: " + age +
               ", Adresa: " + address + ", casatorita: " + married;
    }

    public String getIdentifier() {
        return firstName.toLowerCase().replaceAll(" ", "").replaceAll("-", "") + "_" + lastName.toUpperCase().replaceAll(" ", "").replaceAll("-", "");
    }

    public abstract String getResponsabilities();

}
