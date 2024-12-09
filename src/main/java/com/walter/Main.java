package com.walter;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.net.URI;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        S3Client client = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(ProfileCredentialsProvider.create("development"))
                .endpointOverride(URI.create("https://s3.us-east-1.amazonaws.com"))
                .forcePathStyle(true)
                .build();


        //IntStream.rangeClosed(1,1000).parallel().forEach(i->uploadFileS3Bucket(client, file,String.format("romit-%s.html",i)));
        ListObjectsV2Request listObjectsV2Request = ListObjectsV2Request.builder().bucket("user-jtkalfuntlez").build();
        ListObjectsV2Response listObjectsV2Response = client.listObjectsV2(listObjectsV2Request);
        List<S3Object> contents = listObjectsV2Response.contents();
        System.out.println("Number of objects in the bucket: " + contents.size());
        contents.forEach(System.out::println);
        client.close();
    }
}
