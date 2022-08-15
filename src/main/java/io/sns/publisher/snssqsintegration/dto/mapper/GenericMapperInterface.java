package io.sns.publisher.snssqsintegration.dto.mapper;

import io.sns.publisher.snssqsintegration.dto.WorkFlowDTO;
import io.sns.publisher.snssqsintegration.model.WorkFlowMessageAttributes;
import io.sns.publisher.snssqsintegration.model.WorkFlowMessageBody;

public interface GenericMapperInterface {
    public WorkFlowDTO toWorkFlowDTO(WorkFlowMessageAttributes attributes, WorkFlowMessageBody body);

    public WorkFlowMessageAttributes toWorkFlowAttributes(WorkFlowDTO workFlowDTO);

    public WorkFlowMessageBody toWorkFlowBody(WorkFlowDTO workFlowDTO);
}
