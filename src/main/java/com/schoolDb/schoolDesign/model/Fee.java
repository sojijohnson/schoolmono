package com.schoolDb.schoolDesign.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Data
@Table(name="fee")
public class Fee {

    @Id
    @SequenceGenerator(sequenceName = "fee_sequence", name="fee_sequence" )
    // @SequenceGenerator( name = "student_id_sequence",sequenceName = "student_id_sequence")
    @GeneratedValue(generator = "fee_sequence", strategy= GenerationType.SEQUENCE)
    private Long feeId;
    private double amount;
    private Date date;
    private int studentId;

    private int classId;

    private String session;
    private String term;

}
