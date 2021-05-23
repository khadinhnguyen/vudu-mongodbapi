package com.nguyendkha.vudumongodbapi.bucket;

public enum BucketName {

    PROFILE_IMAGE("khanguyen-vudu-clone-image");
    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
