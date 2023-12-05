package com.example.jwt;

import com.example.security.CustomUserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    @Value("${ra.jwt.sercret}")
    private String JWT_SERCRET;
    @Value("${ra.jwt.expiration}")
    private Integer JWT_EXPIRATION;

    // tạo jwt token từ thông tin người đăng nhập
    public String generateToken(CustomUserDetail customUserDetail){
        Date now = new Date();
        Date dateExpired = new Date(now.getTime()+JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(customUserDetail.getMa())
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(SignatureAlgorithm.HS512,JWT_SERCRET)
                .compact();
    }

    // lấy thông tin người dùng dứ jwt

    public String getMaFromJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(JWT_SERCRET)
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    // validate token
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(JWT_SERCRET).parseClaimsJws(token);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
