package com.schoolDb.schoolDesign.DTO;

import jakarta.persistence.Column;

public class SupervisorDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    @Column(name="status")
    private String status;

    @Column(name="role")
    private String role;

}
