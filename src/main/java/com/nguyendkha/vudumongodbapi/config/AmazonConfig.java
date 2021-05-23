package com.nguyendkha.vudumongodbapi.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Bean // to check and learn
    public AmazonS3 S3(){
        AWSCredentials awsCredentials = new BasicAWSCredentials("AKIA5B2FB6VMN3HAWVDA","bH2QvPkA/2hBjTG/mbhnUlX/pnKnYaP1MLBNRfrf");

        return AmazonS3ClientBuilder
                .standard()
                .withRegion("ca-central-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

}
