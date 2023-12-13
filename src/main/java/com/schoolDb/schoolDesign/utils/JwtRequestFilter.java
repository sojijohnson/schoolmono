package com.schoolDb.schoolDesign.utils;



    import com.schoolDb.schoolDesign.service.SupervisorService;
    import io.jsonwebtoken.Claims;
    import io.jsonwebtoken.ExpiredJwtException;
    import jakarta.servlet.FilterChain;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import lombok.NonNull;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
    import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
    import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

@Slf4j
    @Component
    public class JwtRequestFilter extends OncePerRequestFilter {
        Claims claims=null;
        private String userName;

        @Autowired

        private CustomerUsersDetailsService customerUsersDetailsService;
      // private final CustomerDetailService userDetailsService;
    //    private SupervisorService supervisorService;
        @Autowired
        private  JwtUtils jwtTokenUtil;
        private UserDetailsService userDetailsService;

//        public JwtRequestFilter(SupervisorService userDetailsService, JwtUtils jwtTokenUtil) {
//            this.userDetailsService = userDetailsService;
//            this.jwtTokenUtil = jwtTokenUtil;
//        }

       @Override
        protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain chain)
                throws ServletException, IOException {


//
//            if(request.getServletPath().matches("/supervisor/register|/student/registerStudent|/supervisor/findstudent/")){
//
//                chain.doFilter(request,response);
//            }
             String requestTokenHeader = request.getHeader("Authorization");
              System.out.println("i got here");
         //   log.info("sumthin on token here...{}",jwtToken);
            String username = null;
            String jwtToken = null;
             log.info("requesttoken ..{}" ,requestTokenHeader);
          if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                jwtToken = requestTokenHeader.substring(7);
                log.info("sumthin on token here...{}",jwtToken);
                try {
                    username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                } catch (ExpiredJwtException e) {
                    // Handle token expiration
                    e.printStackTrace();
                }
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.customerUsersDetailsService.loadUserByUsername(username);

                if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            chain.doFilter(request, response);
        }
        public boolean isAdmin(){

            return "admin".equalsIgnoreCase((String) claims.get("role"));
        }

        public boolean isUser(){

            return "user".equalsIgnoreCase((String) claims.get("role"));
        }

        public String getCurrentUser(){

            return userName;
        }

    }

