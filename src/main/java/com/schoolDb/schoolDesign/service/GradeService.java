package com.schoolDb.schoolDesign.service;

import com.schoolDb.schoolDesign.DTO.GradeDTO;
import com.schoolDb.schoolDesign.model.ClassRoom;
import com.schoolDb.schoolDesign.model.Course;
import com.schoolDb.schoolDesign.model.Grade;
import com.schoolDb.schoolDesign.model.Recordd;
import com.schoolDb.schoolDesign.repo.GradeRepo;
import com.schoolDb.schoolDesign.repo.RecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class GradeService {

    @Autowired
    private GradeRepo gradeRepo;
    @Autowired
    private RecordRepo recordRepo;
    public ResponseEntity<String> createGrade(Grade grade) {

Grade grade1 = new Grade();
grade1.setGradeValue(grade.getGradeValue());
grade1.setGradeDate(grade.getGradeDate());
//        List<Course> list1=new ArrayList<>();
//        for(Course course: grade.getCourses()){
//            Course c = new Course();
//            c.setCourseId(course.getCourseId());
//            list1.add(c);
//        }
        //grade.getCourses().stream().map()
//        grade1.setCourses(list1);
grade1.setCourses(grade.getCourses());
grade1.setStudent(grade.getStudent());

           gradeRepo.save(grade1)    ;

return new ResponseEntity<>("saved", HttpStatus.OK);
    }

    public ResponseEntity<String> cGrade(Recordd grade) {

      //  Grade grade1 =new Grade();
        Recordd r = new Recordd();
        r.setStudent(grade.getStudent());
        r.setCourse(grade.getCourse());
        r.setTerm(grade.getTerm());
        r.setSession(grade.getSession());
      //  grade1.setGradeValue(grade.getGradeValue());
       // grade1.setGradeDate(grade.getGradeDate());
//        List<Course> list1=new ArrayList<>();
//        for(Course course: grade.getCourses()){
//            Course c = new Course();
//            c.setCourseId(course.getCourseId());
//            list1.add(c);
//        }
        //grade.getCourses().stream().map()
//        grade1.setCourses(list1);
       // grade1.setCourses(grade.getCourses());
       // grade1.setStudent(grade.getStudent());

        recordRepo.save(r);

        return new ResponseEntity<>("saved", HttpStatus.OK);
    }

    public ResponseEntity<String>deleteGrade(Long id, Long studentId){
        try{
            if (!Objects.isNull(id))
            {
                gradeRepo.deleteById(id);
                return new ResponseEntity<String>("class delected by id",HttpStatus.OK)

                        ;}else
            if(!Objects.isNull(studentId)){
                //ClassRoom newclass = new ClassRoom();
             //   Grade classroom  =   gradeRepo.findByStudentId(studentId);

             //   gradeRepo.delete(classroom);
                return new ResponseEntity<String>("delected by classcode",HttpStatus.OK);
            }}catch (Exception ex){ex.printStackTrace();}

        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<List<GradeDTO>> findGradeById(Long studentId){

                     List<GradeDTO> grades=   gradeRepo.findByStudentId(studentId);

              GradeDTO g= (GradeDTO) grades.stream().map(grade->grades).toList();
                System.out.println(g);
        return new ResponseEntity<>(grades,HttpStatus.OK);
    }
}


