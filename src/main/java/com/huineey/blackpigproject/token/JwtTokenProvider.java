package com.huineey.blackpigproject.token;

import com.huineey.blackpigproject.model.Role;
import com.huineey.blackpigproject.service.CustomUserDetailService;
import com.huineey.blackpigproject.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private String secretKey = "secretKey-test-authorization-jwt-manage-token";
    //private Key key;

    private long tokenValidTime = 30 * 60 * 1000L;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // JWT Token 생성.
    public String createToken(String user){
        Claims claims = Jwts.claims().setSubject(user);
        //claims.put("roles", roles);
        Date date = new Date();
        return Jwts.builder()
                .setClaims(claims) // 발행 유저 정보
                .setIssuedAt(date) // 발행 시간
                .setExpiration(new Date(date.getTime() + tokenValidTime)) // 토큰 유효 시간
                .signWith(SignatureAlgorithm.HS256, secretKey) // 해싱 알고리즘 및 키
                //.signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

   /* public String createToken(String user, List<Role> roles){
        Claims claims = Jwts.claims().setSubject(user);
        claims.put("roles", roles);
        Date date = new Date();
        return Jwts.builder()
                .setClaims(claims) // 발행 유저 정보
                .setIssuedAt(date) // 발행 시간
                .setExpiration(new Date(date.getTime() + tokenValidTime)) // 토큰 유효 시간
                .signWith(SignatureAlgorithm.HS256, secretKey) // 해싱 알고리즘 및 키
                .compact();
    }*/

    // JWT 토큰에서 인증 정보 조회
  /*  public Authentication getAuthentication(String token) {
        UserDetails userDetails = customUserDetailService.loadUserByUsername(this.getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


    // 토큰에서 회원 정보 추출
    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }


    // "authorization" : "token'
    public String resolveToken(HttpServletRequest request) {
        if(request.getHeader("authorization") != null )
            return request.getHeader("authorization").substring(7);
        return null;
    }

    // 토큰의 유효성 확인
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }*/

}