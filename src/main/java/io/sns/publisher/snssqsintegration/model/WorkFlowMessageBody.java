package io.sns.publisher.snssqsintegration.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class WorkFlowMessageBody {

    JsonNode details;

}
