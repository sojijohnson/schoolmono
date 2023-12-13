package com.schoolDb.schoolDesign.utils;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
    @Component
    public class JwtUtils {
//        @Value("${jwt.secret}")
//        private String secret;
    private String  secret = "125756778809090909090909345yyiylljlfdtddpokdgdgdlb5555t6echda6ys";
        @Value("${jwt.expiration}")
        private Long expiration;

        public String generateToken(String username, String role) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("role",role);
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(username)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() +1000*60*60*10 ))
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
        }

        public String getUsernameFromToken(String token) {
            return getClaimFromToken(token, Claims::getSubject);
        }

        public Date getExpirationDateFromToken(String token) {
            return getClaimFromToken(token, Claims::getExpiration);
        }

        public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
            final Claims claims = getAllClaimsFromToken(token);
            return claimsResolver.apply(claims);
        }

        private Claims getAllClaimsFromToken(String token) {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        }

        public Boolean validateToken(String token, UserDetails userDetails) {
            final String username = getUsernameFromToken(token);
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        }

        private Boolean isTokenExpired(String token) {
            final Date expiration = getExpirationDateFromToken(token);
            return expiration.before(new Date());
        }
    }

