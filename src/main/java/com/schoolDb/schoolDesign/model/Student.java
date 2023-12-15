package com.schoolDb.schoolDesign.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@Table(name="student")
@AllArgsConstructor
@NoArgsConstructor
@ToString

@NamedQuery(name ="Student.findByClassRoomId", query="select new com.schoolDb.schoolDesign.wrapper.StudentWrapper(s.studentId,s.firstname,s.lastname,s.middlename,s.age,s.classRoom.classRoomId) from Student s where s.classRoom.classRoomId=:classRoomId")
//@NamedQuery(name="Product.getCategory", query = "select new com.inn.cafe.wrapper.ProductWrapper(p.id,p.name) from Product p where p.category.id=:id and p.status='true'")

//@NamedQuery(name ="Student.findByClassRoomId", query="select new Student(s.studentId,s.firstname) from Student s where s.classRoom.classRoomId=:classRoomId")
//@NamedQuery(name ="Student.findByClassRoomId", query="select s from Student s where s.classRoom.classRoomId=:classRoomId")
public class Student {

@Id

       @SequenceGenerator( name = "student_id_sequence",sequenceName = "student_id_sequence")
      @GeneratedValue(generator = "student_id_sequence", strategy= GenerationType.AUTO)
    private Long studentId;
    private String firstname;
    private String lastname;
    private String middlename;
    private int age;
    private String address;
  // @ManyToOne()

   // @ManyToMany(cascade = CascadeType.ALL,mappedBy ="student" )
  @OneToMany()
//    @JoinTable(name = "student_course",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "courseId"))
  // @JoinColumn(name="course_Id")
    //private Set<Course> courses;   ai
   private List<Course> courses;
    //private Course courses;
    //@Embedded
    //@ManyToOne(cascade=CascadeType.ALL, targetEntity = ClassRoom.class)
   // @JoinColumn(name="class_Id")
    //@JoinColumn(name="class_room_id", referencedColumnName = "classRoomId")
    @ManyToOne()
//    @JoinTable(name = "student_course",
        //    @JoinColumn(name = "class_id")
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private ClassRoom classRoom;
//    @OneToMany(mappedBy = "student")
//    private List<Grade> grades;
    private String stateOfOrigin;
    private String email;
    private Date dob;

    @OneToMany(mappedBy = "student")

    private List<Grade> grade;

    @OneToMany(mappedBy = "student")
private List<Recordd> recordd;

    //@NonNull
    private  String phone;
    @ManyToOne()
    private Parent parent;

public Student(Long studentId,String firstname){

    super();
    this.studentId=studentId;
    this.firstname=firstname;
   // this.classRoom = classRoomId;
}



//,s.classRoom.classRoomId
}
// this.studentId = studentId;
//         this.firstname = firstname;
//         this.lastname = lastname;
//         this.middlename = middlename;
//         this.age = age;