package com.schoolDb.schoolDesign.service;

import com.schoolDb.schoolDesign.DTO.CourseDTO;
import com.schoolDb.schoolDesign.DTO.StudentDTO;
import com.schoolDb.schoolDesign.model.Course;
import com.schoolDb.schoolDesign.model.Student;
import com.schoolDb.schoolDesign.repo.CourseRepo;
import com.schoolDb.schoolDesign.repo.StudentRepo;
import com.schoolDb.schoolDesign.wrapper.StudentWrapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    private CourseRepo courseRepo;
    public ResponseEntity<String> registerStudent(Student registerstudent) {

 try {
     Student student = new Student();
     student.setFirstname(registerstudent.getFirstname());
     student.setLastname(registerstudent.getLastname());
     student.setMiddlename(registerstudent.getMiddlename());
    student.setCourses(registerstudent.getCourses());

       //courseRepo.save(registerstudent.getCourses()) ;
     student.setAge(registerstudent.getAge());
     student.setAddress(registerstudent.getAddress());
     student.setPhone(registerstudent.getPhone());
     student.setDob(registerstudent.getDob());
     student.setEmail(registerstudent.getEmail());
     student.setStateOfOrigin(registerstudent.getStateOfOrigin());
     student.setClassRoom(registerstudent.getClassRoom());

     System.out.println(registerstudent);
     System.out.println(student.getAge());
     System.out.println(student);
     studentRepo.save(student);
     System.out.println(registerstudent);
     System.out.println(student.getFirstname());
     return new ResponseEntity<>("student registered", HttpStatus.OK);
 }catch(Exception ex){
     ex.printStackTrace();
 }

 return new ResponseEntity<>("student not registered", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteAllStudents() {
      try{
        studentRepo.deleteAll();
        return new ResponseEntity<>("all student record has been successfully deleteed",HttpStatus.OK);}
      catch (Exception ex){ex.printStackTrace();}

      return new ResponseEntity<>("check your request, something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Boolean> deleteStudent(Long studentId) {

        try{
          studentRepo.deleteById(studentId);
        }catch (Exception ex){ex.printStackTrace();}

        return new ResponseEntity<>(true,HttpStatus.NOT_FOUND);
    }

    public StudentDTO findStudent(Long id) {
        try{



         //Optional<Student> stu  =   studentRepo.findById(id);
                  Student  stu =  studentRepo.getById(id);
          return   studentToDTO(stu);
        }catch (Exception ex){

        }
        Student  stu =  studentRepo.getById(id);
        return new ResponseEntity<StudentDTO>(studentToDTO(stu) ,HttpStatus.OK).getBody();
    }


//    public ResponseEntity <List<Student>> findStudentByClassId(Long classRoomId) {
//        try{
//            System.out.println("find is service up");
//            //Optional<Student> stu  =   studentRepo.findById(id);
//           List <Student>  stu =  studentRepo.findByClassRoomId(classRoomId);
//
//            List<Student>s = new ArrayList<>();
//            for(Student r: stu){
//                s.add(r);
//            }
//           System.out.println(s);
//            System.out.println("find is service");
//            return new ResponseEntity<>(new ArrayList<>(s),HttpStatus.OK);
//        }catch (Exception ex){
//
//        }
//
//       // Student  stu =  studentRepo.getById(id);
//        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
//    }

    public ResponseEntity <List<StudentWrapper>> findStudentByClassId(Long classRoomId) {
        try{
            System.out.println("find is service up");
            //Optional<Student> stu  =   studentRepo.findById(id);
            List <StudentWrapper>  stu =  studentRepo.findByClassRoomId(classRoomId);


            List<StudentWrapper>s = new ArrayList<>();
            for(StudentWrapper r: stu){
                s.add(r);
            }
            System.out.println(s);
            System.out.println("find is service");
            return new ResponseEntity<>(new ArrayList<>(s),HttpStatus.OK);
        }catch (Exception ex){
                        ex.printStackTrace();
        }

        // Student  stu =  studentRepo.getById(id);
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public StudentDTO studentToDTO (Student st){

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(st.getStudentId());
        studentDTO.setAddress(st.getAddress());
        studentDTO.setAge(st.getAge());

       List<Course> courseDTOs = new ArrayList<>();
       List<Course>  course1 = new ArrayList<>();
        for (Course course : st.getCourses()){
            //CourseDTO courseDTO = new CourseDTO();
           // courseDTO.setCourseId(course.getCourseId());
            Course course2 = new Course();
            course2.setCourseId(course.getCourseId());
            course2.setCourseName(course.getCourseName());
            course2.setCourseCode(course.getCourseCode());
            course2.setCredit(course.getCredit());
            course1.add(course2);

         //   courseDTO.setCourseName(course.getCourseName());
           // courseDTOs.add(courseDTO);
        }

         studentDTO.setCourses(course1);
        studentDTO.setFirstname(st.getFirstname());
        return studentDTO;
    }
}


