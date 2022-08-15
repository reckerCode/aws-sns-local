package io.sns.publisher.snssqsintegration.dto;

import io.sns.publisher.snssqsintegration.model.WorkFlowMessageAttributes;
import io.sns.publisher.snssqsintegration.model.WorkFlowMessageBody;
import lombok.Data;

@Data
public class WorkFlowDTO {
    public WorkFlowMessageAttributes workFlowMessageAttributes;
    public WorkFlowMessageBody flowMessageBody;
}
