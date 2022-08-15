package io.sns.publisher.snssqsintegration.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.AmazonSNSException;
import com.amazonaws.services.sns.model.PublishBatchRequest;
import com.amazonaws.services.sns.model.PublishBatchRequestEntry;
import com.amazonaws.services.sns.model.PublishBatchResult;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * publisher class with batch publisher for SNS
 */
@Slf4j
public class PublishBatchToFifoTopic {
    private static final int MAX_BATCH_SIZE = 10;

    public static void publishBatchToFifoTopic(AmazonSNS snsClient, String topicArn) {
        try {
            //Create the batch entries to send
            List<PublishBatchRequestEntry> entries = IntStream.range(0, MAX_BATCH_SIZE)
                    .mapToObj(i -> new PublishBatchRequestEntry().withId("id" + i)
                            .withMessage("message" + i)
                            .withMessageGroupId("groupId")
                            .withMessageDeduplicationId("deduplicationId" + i))
                    .collect(Collectors.toList());

            //Create the batch request
            if (entries.size() == MAX_BATCH_SIZE) {
                PublishBatchRequest batchRequest = new PublishBatchRequest()
                        .withTopicArn(topicArn)
                        .withPublishBatchRequestEntries(entries);
                //Publish the batch request
                PublishBatchResult publishBatchResult = snsClient.publishBatch(batchRequest);
                //Handle the successfully sent messages
                publishBatchResult.getSuccessful().forEach(i -> {
                    log.info("Batch ID for successful message:" + i.getId());
                    log.info("Message ID for successful message:" + i.getMessageId());
                    log.info("SequenceNumber for successful message:" + i.getSequenceNumber());
                });
                publishBatchResult.getFailed().forEach(i -> {
                    log.error("Batch ID for failed message:" + i.getId());
                    log.error("Code for failed message:" + i.getCode());
                    log.error("Sender Fault for failed message" + i.getSenderFault());
                    log.error("Failure message for failed message" + i.getMessage());
                });
            }
        } catch (AmazonSNSException e) {
            // Handle any exceptions from the request
            log.error(e.getMessage());
            System.exit(1);
        }
    }

}
