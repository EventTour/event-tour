package peddle;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.google.common.io.ByteStreams;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Store {
  final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
      .withCredentials(new AWSStaticCredentialsProvider(
          new BasicAWSCredentials(
              "AKIAJ3ART52MTZYTUEFQ",    // put your key from aws console
              "+R6T6WzJy44TJSgeoVv+2qfOM/iSPCmiRi31xzT5"))) // put your key from aws console
      .withRegion("us-west-2").build();



  private String load(String id) throws IOException {
    S3Object object = s3.getObject("eventtour", id);
    InputStream contentStream = object.getObjectContent();
    byte[] contentBytes = ByteStreams.toByteArray(contentStream);
    return new String(contentBytes);
  }

  private void save(String id, InputStream input) {
    PutObjectResult result = s3.putObject(
        "eventtour", // bucket name
        id, // key
        input,  // data
        new ObjectMetadata());
  }
}
