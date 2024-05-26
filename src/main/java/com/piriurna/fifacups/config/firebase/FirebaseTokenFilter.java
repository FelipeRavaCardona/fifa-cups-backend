package com.piriurna.fifacups.config.firebase;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

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
            sendErrorResponse(response, "Missing Bearer Token");
            return;
        }
        token = token.split(" ")[1];
        
        FirebaseToken decodedToken = null;

        try {
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        } catch (FirebaseAuthException e) {
            sendErrorResponse(response, "Error: " + e.getMessage());
            return;
        }

        if (decodedToken == null) {
            sendErrorResponse(response, "Invalid Bearer Token");
            return;
        }

        String uid = decodedToken.getUid();
        String email = decodedToken.getEmail();

        request.setAttribute("uid", uid);
        request.setAttribute("email", email);
        
        chain.doFilter(request, response);
    }

    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"message\": \"" + message + "\"}");
    }
}
