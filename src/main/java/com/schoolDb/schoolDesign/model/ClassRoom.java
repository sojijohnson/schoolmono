package com.schoolDb.schoolDesign.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="classRoom")
@ToString

//@NamedQuery(name ="ClassRoom.getAll", query="select  u.classRoomId, u.classCode, u.capacity, u.student from ClassRoom u where u.capacity=:20")
   @NamedQuery(name="ClassRoom.getAll" ,query="select new com.schoolDb.schoolDesign.wrapper.ClassWrapper(u.classRoomId,u.classCode,u.capacity) from ClassRoom u where u.capacity=:capacity")
public class ClassRoom {
@Id
@SequenceGenerator(sequenceName = "class_sequence", name="class_sequence" )

@GeneratedValue(generator = "class_sequence", strategy= GenerationType.IDENTITY)
    private Long classRoomId;
    private String classCode;
    private int capacity;

@OneToMany( mappedBy = "classRoom", fetch = FetchType.LAZY)
//@OneToMany( mappedBy = "s")
//@JoinColumn(name="student_fcp", referencedColumnName = "classroomId")
//@JoinColumn(name="class_student")
private List<Student> student;


}
