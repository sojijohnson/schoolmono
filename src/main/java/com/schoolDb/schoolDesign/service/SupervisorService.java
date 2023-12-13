package com.schoolDb.schoolDesign.service;

import com.schoolDb.schoolDesign.model.Student;
import com.schoolDb.schoolDesign.model.Supervisor;
import com.schoolDb.schoolDesign.repo.StudentRepo;
import com.schoolDb.schoolDesign.repo.SupervisorRepo;
import com.schoolDb.schoolDesign.utils.CustomerUsersDetailsService;
import com.schoolDb.schoolDesign.utils.JwtRequestFilter;
import com.schoolDb.schoolDesign.utils.JwtUtils;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
//public class SupervisorService implements UserDetailsService {
public class SupervisorService {
    @Autowired
    private SupervisorRepo supervisorRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomerUsersDetailsService customerUsersDetailsService;
    @Autowired
    private StudentRepo studentRepo;
    private JwtRequestFilter jwtRequestFilter;
    @Autowired
    private JwtUtils jwtUtils;

    public ResponseEntity<String> createAdmin(Supervisor supervisor) {
   // String username = "yty";


        Supervisor super1 = new Supervisor();
        super1.setFirstName(supervisor.getFirstName());
        super1.setPassword(passwordEncoder.encode(supervisor.getPassword()));
        super1.setLastName(supervisor.getLastName());
        super1.setUserName(supervisor.getUserName());
        super1.setRole("Admin");
        super1.setStatus("true");

        supervisorRepo.save(super1);
        return new ResponseEntity<>("Admin created", HttpStatus.OK);
    }

    public String findStudentRecord(Long studentId) {

try {

    if(jwtRequestFilter.isAdmin()){
    Optional<Student> student = studentRepo.findById(studentId);
    //   student.filter(person-> );


    System.out.println(student);


    Optional<Supervisor> student1 = supervisorRepo.findById(studentId);
    Map<String, String> map = new HashMap<>();
    map.put("student1", String.valueOf(student1));
    map.put("supervisor", String.valueOf(student));
    // System.out.println(map);
    List<String> list1 = new ArrayList<>();

    list1.add(String.valueOf(student1));
    list1.add(String.valueOf(student));

    for (String p : list1)
        System.out.println(p);

    //  System.out.println(student1.toString());
    // System.out.println(student);
    // return student.toString();
    return list1.toString();}
    else {
        return "only admin can search";
    }
}catch (Exception ex){
    ex.printStackTrace();
}

return "permsiionsion not granted";
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Supervisor supervisor = supervisorRepo.findByUsername(username);
//        if (supervisor == null) {
//            throw new UsernameNotFoundException("user not found");
//        }
//        return new User(supervisor.getUserName(), supervisor.getPassword(), new ArrayList<>());
//    }

    public ResponseEntity<String> supervisorLogin(Map<String, String> responsemap) {
//        Supervisor supervisor = supervisorRepo.findByUserName(responsemap.get("username"));
//        Supervisor supervisor1 = new Supervisor();
//        System.out.println(supervisor);
//        log.info("ss");
//        responsemap.get("username");
//        responsemap.get("password");
        try {
            log.info("inside login2");
           // Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(responsemap.get("username"), responsemap.get("password")));
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(responsemap.get("username"), responsemap.get("password")));
            log.info("got here {}", customerUsersDetailsService.getUserDetail(responsemap.get("username")).getPassword());
            log.info("inside login2");
            log.info("auth value is {}", auth);
            if (auth.isAuthenticated()) {
                //username is the variable from postman, same from service class.
                if (customerUsersDetailsService.getUserDetail(responsemap.get("username")).getStatus().equalsIgnoreCase("true")) {

                    log.info("mail value is true");
                    System.out.println("print jwt1");

             // var jwt  =      jwtUtils.generateToken(responsemap.get("username"));
            //   System.out.println(jwt);
               System.out.println("print jwt2");
                    return new ResponseEntity<String>("{\"token\": \"" +

                            jwtUtils.generateToken(customerUsersDetailsService.getUserDetail(responsemap.get("username")).getUserName()
                          ,customerUsersDetailsService.getUserDetail(responsemap.get("username")).getRole()
                  ) + "\"}",
                           HttpStatus.OK);

                 //   return new ResponseEntity<>("u are logined",HttpStatus.OK);

//                    return new ResponseEntity<String>("{\"token\": \"" +
//
//                            jwtUtils.generateToken("yty"
//                                    , "Admin"
//                            ) + "\"}",
//                            HttpStatus.OK);

                } else {
                    return new ResponseEntity<String>("{\"message\": \"" + "wait for approal." + " \"}", HttpStatus.BAD_REQUEST);
                }


               // return new ResponseEntity<>("", HttpStatus.OK);
            }
        } catch (Exception ex) {
        }
        return new ResponseEntity<String>("{\"message\": \"" + "Not approve." + " \"}", HttpStatus.BAD_REQUEST);
    }
}