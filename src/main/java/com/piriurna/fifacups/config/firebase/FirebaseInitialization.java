package com.piriurna.fifacups.config.firebase;

import java.io.InputStream;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;

@Configuration
public class FirebaseInitialization {
    @PostConstruct
    public void initializeFirebase() {
        try {
            InputStream serviceAccount = FirebaseInitialization.class.getResourceAsStream("/firebase-service-credentials.json");
            FirebaseOptions option = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

            FirebaseApp.initializeApp(option);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
