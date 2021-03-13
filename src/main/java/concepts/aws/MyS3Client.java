package concepts.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.Region;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyS3Client {

    public static void main(String[] args) {
        Region region = Region.US_East_2;

        AmazonS3 s3client = AmazonS3ClientBuilder.defaultClient(); //client creation

        log.info(s3client.getRegionName());
        printAllBucketName(s3client);

    }

    private static void printAllBucketName(AmazonS3 s3client) {
        for(Bucket bucket : s3client.listBuckets()) {
            log.info(bucket.toString());
        }
    }
}
