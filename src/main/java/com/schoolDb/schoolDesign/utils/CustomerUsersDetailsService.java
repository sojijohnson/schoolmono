package com.schoolDb.schoolDesign.utils;

import com.schoolDb.schoolDesign.model.Supervisor;
import com.schoolDb.schoolDesign.repo.SupervisorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;



    @Service
    @Configuration
    @EnableWebSecurity
    @Slf4j
    public class CustomerUsersDetailsService implements UserDetailsService {
        @Autowired
        //UserDao userDao;
        private SupervisorRepo supervisorRepo;



        //  @Autowired
    //    private com.inn.cafe.Model.User userDetail;

    //    private




      //  @Bean
        @Override
        public UserDetails loadUserByUsername(String email) throws
                //public User loadUserByUsername(String email) throws
                UsernameNotFoundException {
       log.info("inside loadusers function noe");



            Supervisor userDetail =  supervisorRepo.findByUsername(email);
            // User userDetails = userDao.findByName(email) ;
            log.info("userDetails from loadusername {}", userDetail.getUserName());
            if (!Objects.isNull(userDetail)) {

                log.info("userDetails from if object {}", userDetail.getPassword());
                return new org.springframework.security.core.userdetails.User(userDetail.getUserName(), userDetail.getPassword(), new ArrayList<>());
            }
            // return  userDetails;

            else
                throw new UsernameNotFoundException("user not found from loaduserbyusernmae");
            // return null;
        }


       // public Supervisor getUserDetail( String email){
       public Supervisor getUserDetail( String email){
            // public UserDetails getUserDetail(){
            System.out.println(email);
         Supervisor  userDetail =  supervisorRepo.findByUsername(email);
      System.out.println(userDetail);
            System.out.println("ddh");
            System.out.println(userDetail.getRole());
            System.out.println(userDetail.getUserName());
           return userDetail;
           // return new org.springframework.security.core.userdetails.User(userDetail.getUserName(), userDetail.getRole(), new ArrayList<>());
        }




        @Bean

        public PasswordEncoder passwordEncoder(){
            return NoOpPasswordEncoder.getInstance();
        }


        @Bean

        public AuthenticationProvider authenticationProvider(){
            DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider();

            authProvider.setUserDetailsService(this::loadUserByUsername);
            //   authProvider.setUserDetailsService();
            authProvider.setPasswordEncoder(passwordEncoder());
            return  authProvider;
        }



        @Bean(name= BeanIds.AUTHENTICATION_MANAGER)

        public AuthenticationManager authenticationManager(
                AuthenticationConfiguration authenticationConfiguration) throws Exception {
            return authenticationConfiguration.getAuthenticationManager();
            // return super.authenticationManagerBean()
        }



    }


