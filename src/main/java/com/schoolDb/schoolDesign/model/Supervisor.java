package com.schoolDb.schoolDesign.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="supervisor")
@Data

  //username "no case is the varible from the rest class and postman and service class"

@NamedQuery(name ="Supervisor.findByUsername", query="select s from Supervisor s where s.userName=:username")
public class Supervisor {





    @Id
   @SequenceGenerator(sequenceName = "supervisor_sequence", name="supervisor_sequence" )
   // @SequenceGenerator( name = "student_id_sequence",sequenceName = "student_id_sequence")
    @GeneratedValue(generator = "supervisor_sequence", strategy= GenerationType.SEQUENCE)
    private Long supervisorId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    @Column(name="status")
    private String status;

    @Column(name="role")
    private String role;

}
