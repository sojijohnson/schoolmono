package com.schoolDb.schoolDesign.wrapper;

import com.schoolDb.schoolDesign.model.ClassRoom;
import com.schoolDb.schoolDesign.model.Course;
import com.schoolDb.schoolDesign.model.Grade;
import com.schoolDb.schoolDesign.model.Recordd;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class StudentWrapper {

    private Long studentId;
    private String firstname;
    private String lastname;
    private String middlename;
    private int age;
    private String address;
    // @ManyToOne()

    // @ManyToMany(cascade = CascadeType.ALL,mappedBy ="student" )
  //  @OneToMany()
//    @JoinTable(name = "student_course",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "courseId"))
    // @JoinColumn(name="course_Id")
    //private Set<Course> courses;   ai
  //  private List<Course> courses;                                        ,,,,,,,,,,,,,,,,,,,,,,,,,
    //private Course courses;
    //@Embedded
    //@ManyToOne(cascade=CascadeType.ALL, targetEntity = ClassRoom.class)
    // @JoinColumn(name="class_Id")
    //@JoinColumn(name="class_room_id", referencedColumnName = "classRoomId")
    @ManyToOne()
//    @JoinTable(name = "student_course",
    //    @JoinColumn(name = "class_id")
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Long classRoom;
    //    @OneToMany(mappedBy = "student")
//    private List<Grade> grades;
    private String stateOfOrigin;
    private String email;
    private Date dob;

//    @OneToMany(mappedBy = "student")
//
//    private List<Grade> grade;

//    @OneToMany(mappedBy = "student")
//    private List<Recordd> recordd;

    //@NonNull
    private  String phone;

    public StudentWrapper() {
    }

    public StudentWrapper(Long studentId, String firstname, String lastname, String middlename, int age,Long classRoom) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.age = age;
        this.classRoom=classRoom;
    }

    public StudentWrapper(Long studentId) {
        this.studentId = studentId;
    }
}
