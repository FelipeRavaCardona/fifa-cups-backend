package com.piriurna.fifacups.config.firebase;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.piriurna.fifacups.exceptions.UnauthorizedException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FirebaseTokenFilter extends OncePerRequestFilter { 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token == null) {
            throw new UnauthorizedException("Missing Bearer Token");
        }
        token = token.split(" ")[1];
        
        FirebaseToken decodedToken = null;

        try {
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        } catch (FirebaseAuthException e) {
            throw new UnauthorizedException("Error: " + e.toString());
        }

        if (decodedToken == null) {
            throw new UnauthorizedException("Invalid Bearer Token");
        }

        String uid = decodedToken.getUid();
        String email = decodedToken.getEmail();

        request.setAttribute("uid", uid);
        request.setAttribute("email", email);
        
        chain.doFilter(request, response);
    }
}
