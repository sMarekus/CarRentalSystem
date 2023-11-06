package com.example.carrentalservice.Jwt;
import com.example.carrentalservice.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jdk.jshell.spi.ExecutionControl;
import org.apache.el.lang.FunctionMapperImpl;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.web.client.HttpServerErrorException;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

public class JwtService {

    private static final String SECRET_KEY= "oursecretkeywhichhasmorethan16characters";

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimReslover)
    {
        final Claims claims = extractAllClaims(token);
        return claimReslover.apply(claims);
    }

    //public String generateToken(User )

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


    /*public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

     */
}
