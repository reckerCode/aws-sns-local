package io.sns.publisher.snssqsintegration;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.Message;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SQSTest {

    private final String queue = UUID.randomUUID().toString()+"_sqsQueue";

    @Autowired
    private AmazonSQSAsync amazonSQSAsync;

    private String queueUrl;

    private Message message;

    void testCreateQueue(){

    }

//    CreateQueueRequest createQueueRequest = new CreateQueueRequest();
//        createQueueRequest.setQueueName(queue);
//        amazonSQSAsync.createQueue(createQueueRequest);
//    GetQueueUrlRequest getQueueUrlRequest = new GetQueueUrlRequest();
//        getQueueUrlRequest.setQueueName();
//    GetQueueUrlResponse getQueueUrlResponse =
//            amazonSQSAsync.getQueueUrl();
//    queueUrl = getQueueUrlResponse.queueUrl();



}
