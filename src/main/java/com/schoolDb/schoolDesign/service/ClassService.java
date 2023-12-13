package com.schoolDb.schoolDesign.service;

import com.schoolDb.schoolDesign.model.ClassRoom;
import com.schoolDb.schoolDesign.model.Student;
import com.schoolDb.schoolDesign.repo.ClassRepo;
import com.schoolDb.schoolDesign.wrapper.ClassWrapper;
import lombok.NonNull;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@Service
public class ClassService {
    @Autowired
    private ClassRepo classRepo;
    public void findClass(String classid) {
    }

    public ResponseEntity<String> registerClass(ClassRoom newclass) {

        ClassRoom newclass1 = new ClassRoom();

        newclass1.setClassCode(newclass.getClassCode());
        newclass1.setStudent(newclass.getStudent());
        newclass1.setCapacity(newclass.getCapacity());




       // newclass1.setStudent(newclass.getStudent());
        classRepo.save(newclass1);
        return new ResponseEntity<>("class saved", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteClass(Long id, String code) {
       try{
        if (!Objects.isNull(id))
        {
        classRepo.deleteById(id);
        return new ResponseEntity<String>("class delected by id",HttpStatus.OK)

        ;}else
            if(!Objects.isNull(code)){
                //ClassRoom newclass = new ClassRoom();
          ClassRoom   classroom  =   classRepo.findByClassCode(code);

                classRepo.delete(classroom);
                return new ResponseEntity<String>("delected by classcode",HttpStatus.OK);
            }}catch (Exception ex){ex.printStackTrace();}

       return new ResponseEntity<String>("not deleted due to err", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List> findAllClass() {
        try{
                    // List<ClassRoom>   classRoom =classRepo.getAll(capacity);
           List<ClassRoom> classRoom =  classRepo.findAll();
           System.out.println(classRoom);
          System.out.println();
           System.out.println("find all classes");
        return new ResponseEntity<>(classRoom,HttpStatus.OK);
        } catch(Exception ex){
            ex.printStackTrace();

        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public ResponseEntity<Set<ClassWrapper>> findAllClassbyCapcity(int capacity) {
        try{
             List<ClassWrapper>   classRoom =classRepo.getAll(capacity);
           // List<ClassRoom> classRoom =  classRepo.findAll();

//             List<ClassWrapper>  cl = new ArrayList<>();
//                     for(ClassWrapper clas:classRoom){
//
//                         cl.add(clas);
//                     }






       Set cll    =          classRoom.stream().map(classRoo->classRoom).collect(Collectors.toSet());
            System.out.println(cll);
            System.out.println(classRoom.stream().map(classRoo->classRoom).collect(Collectors.toSet()));


            System.out.println("find all classes");
            return new ResponseEntity<>(cll,HttpStatus.OK);
        } catch(Exception ex){
            ex.printStackTrace();

        }
        return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public ResponseEntity<String> updateClassDetails(ClassRoom classRm){

        System.out.println(classRm);
        ClassRoom classRoom = new ClassRoom();
            ClassRoom updateClass=  classRepo.findByClassCode(classRm.getClassCode());

        System.out.println(updateClass);

      // if (classRm.getClassRoomId() !=null || classRm.g )
          int  capacity = classRm.getCapacity();
                 Long classId=  classRm.getClassRoomId();

                 String  classcode  =      classRm.getClassCode();
        if(Objects.nonNull(updateClass)) {
          if(Objects.nonNull(capacity) ||classRm.getClassRoomId() !=null || classcode.length()>0 ){
                   updateClass.setCapacity(classRm.getCapacity());

                   List<Student> st = new ArrayList<>();
                   for(Student student: classRm.getStudent()){
                       st.add(student);
                   }
              updateClass.setStudent(st);
                  // classRoom.setClassRoomId(classRm.getClassRoomId());
                //   classRoom.setClassCode(classcode);
System.out.println(updateClass);
          }

        classRepo.save(updateClass);
        }
        return new ResponseEntity<String>("class updated successfully",HttpStatus.OK);
    }
}
