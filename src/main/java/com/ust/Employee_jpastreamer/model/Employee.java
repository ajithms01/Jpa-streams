package com.ust.Employee_jpastreamer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ustemp")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id")

    private int id;

    @Column(name = "Education")
    private String education;

    @Column(name = "JoiningYear")
    private int joiningYear;

    @Column(name = "City")
    private String city;

    @Column(name = "PaymentTier")
    private int paymentTier;

    @Column(name = "Age")
    private int age;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "EverBenched")
    private String everBenched;

    @Column(name = "ExperienceInCurrentDomain")
    private int experienceInCurrentDomain;

    @Column(name = "LeaveOrNot")
    private int leaveOrNot;
}
