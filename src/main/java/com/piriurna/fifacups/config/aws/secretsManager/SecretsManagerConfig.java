package com.piriurna.fifacups.config.aws.secretsManager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Configuration
public class SecretsManagerConfig {
    @Value("${aws.secrets.manager.secretId}")
    private String secretId;

    private String region = "us-east-1";

    @Bean
    @SuppressWarnings("unchecked")
    public Map<String, String> getDatabaseCredentials() throws Exception {
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(Region.of(region))
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretId)
                .build();

        GetSecretValueResponse getSecretValueResponse = client.getSecretValue(getSecretValueRequest);

        String secretString = getSecretValueResponse.secretString();
        return new ObjectMapper().readValue(secretString, Map.class);
    }
}
