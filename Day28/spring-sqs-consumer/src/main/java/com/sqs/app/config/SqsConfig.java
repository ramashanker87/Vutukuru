package com.sqs.app.config;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Profile("!component-test")
@Configuration
public class SqsConfig {

  @Value("${amazon.aws.sqs.maxNumberOfMessagesPerPoll:10}")
  private int maxNumberOfMessagesPerPoll;
  @Value("${amazon.aws.sqs.pollWaitTimeoutSeconds:10}")
  private int pollWaitTimeoutSeconds;
  @Value("${amazon.aws.sqs.pollBackoffTimeMillis:10000}")
  private long pollBackoffTimeMillis;

  @Bean
  public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient){
    return SqsTemplate.builder().sqsAsyncClient(sqsAsyncClient).build();
  }

  @Bean
  @Primary
  public SqsAsyncClient amazonSQSAsync(@Value("${SITE:eu-west-1}") String region
                                      ) {
      return SqsAsyncClient.builder()
        .region(Region.of(region))
        .build();
    }
  }

