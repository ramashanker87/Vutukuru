package com.revanth.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.http.apache.ApacheHttpClient;

import java.net.URI;

@Configuration
@Profile("localstack") // Ensure "localstack" profile is active
public class AwsConfig {

    private static final String LOCALSTACK_ENDPOINT = "http://localhost:4566"; // Change if using AWS

    @Bean
    public SqsClient sqsClient() {
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create("test", "test"); // LocalStack uses "test"

        return SqsClient.builder()
                .region(Region.US_EAST_1) // Use correct AWS region
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .endpointOverride(URI.create(LOCALSTACK_ENDPOINT)) // LocalStack or AWS endpoint
                .overrideConfiguration(ClientOverrideConfiguration.builder().build())
                .build();
    }

    @Bean
    public DynamoDbClient dynamoDbClient() {
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create("test", "test"); // LocalStack uses "test"

        return DynamoDbClient.builder()
                .region(Region.US_EAST_1) // Use correct AWS region
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .endpointOverride(URI.create(LOCALSTACK_ENDPOINT))
                .build();
    }
}
