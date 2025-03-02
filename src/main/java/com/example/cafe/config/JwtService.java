package com.example.cafe.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static  final  String SECRET_KEY="0ae10662eafb66b9f375eb240e6b17e51077d4be209c66b0609508a1998657e12fb5c845279ea8a5c727f0f28567a9619fcd309108d948c985ee2f97c5d74342d5c462becd2dfe067ff5b3bad76b1e71b61f8b2ab83e3e3447c2875da1f44380942bd3d7ff96672a3b1c9f4100fa512dc626b1703c42723f5be8c7eddf18086a079a0899890e9cb1fc59b66628209d2f82af8fb405f5f9d72450d67e2a0abf0ef69a8bf7f393f14ccc5f71ba9eefbba1cb257bc8335c999033efdc942842b017209999ee2c441f6b8dc06fb2324201d8806bf4c2f097bcaeb0d486b0d213a260c79f31179917dfd6626e85d3730181abbc8442c66dc8eeb8c22c194b49343c09";

    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }
    public String generteToken(UserDetails userDetails,String role){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return generateToken(claims, userDetails);
    }
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiration
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String extractRole(String token) {
        return extractClaim(token, claims -> claims.get("role", String.class));
    }


    public  boolean isTokenValid(String token, UserDetails userDetails){
        final  String username=extractUsername(token);
        return  (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
