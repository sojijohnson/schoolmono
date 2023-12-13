package com.schoolDb.schoolDesign.controller;

import com.schoolDb.schoolDesign.model.ClassRoom;
import com.schoolDb.schoolDesign.service.ClassService;
import com.schoolDb.schoolDesign.wrapper.ClassWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/classroom")
public class ClassRoomConttoller {
@Autowired
private ClassService classService;






    @PostMapping("/registerlass")
      public ResponseEntity<String> registerClass(@RequestBody(required = true) ClassRoom newclass) {
        ResponseEntity<String> dhd = null;
        try {
            dhd = classService.registerClass(newclass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return dhd;
        //  return new ResponseEntity<String>("sumthing went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }






    @GetMapping("/{classid}")
         public ResponseEntity<String> findClass(@PathVariable("classid") String classid) {
  try{
         classService.findClass(classid);
  }catch (Exception ex){ex.printStackTrace();}
return new ResponseEntity<String>("class not found",HttpStatus.INTERNAL_SERVER_ERROR);
//return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findall")
      public ResponseEntity<List> findAllClass(){

        return classService.findAllClass();

    }

    @GetMapping("/findall/{capacity}")
    public ResponseEntity<Set<ClassWrapper>> findAllClassbyCapcity(@PathVariable("capacity") int capacity){

        return classService.findAllClassbyCapcity(capacity);
    }

@PutMapping("/update")
public ResponseEntity<String> updateClass(@RequestBody ClassRoom classRoom){

        return classService.updateClassDetails(classRoom);

}

    @DeleteMapping("/delete")
       public ResponseEntity<String> deleteClass(@RequestParam(value = "id" ,required = false) Long id, @RequestParam(value = "code",required = false) String code){
        //try{

       return classService.deleteClass(id,code);



       // return new ResponseEntity<String>("classdeleted",HttpStatus.OK);
    }





}
