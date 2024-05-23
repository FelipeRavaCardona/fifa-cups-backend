package com.piriurna.fifacups.config.firebase;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;

@Configuration
public class FirebaseInitialization {
    @Value("${spring.credentials.firebase-credentials-path}")
    private String credentialsPath;

    @PostConstruct
    public void initializeFirebase() {
        try {
            InputStream serviceAccount = FirebaseInitialization.class.getResourceAsStream(credentialsPath);
            System.out.println(serviceAccount);
            FirebaseOptions option = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

            FirebaseApp.initializeApp(option);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
