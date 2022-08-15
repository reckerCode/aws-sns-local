package io.sns.publisher.snssqsintegration.dto.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.sns.publisher.snssqsintegration.dto.WorkFlowDTO;
import io.sns.publisher.snssqsintegration.model.WorkFlowMessageAttributes;
import io.sns.publisher.snssqsintegration.model.WorkFlowMessageBody;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkFlowMapper implements GenericMapperInterface {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public WorkFlowDTO toWorkFlowDTO(WorkFlowMessageAttributes attributes, WorkFlowMessageBody body) {

        WorkFlowDTO workFlowDTO = new WorkFlowDTO();

        WorkFlowMessageAttributes workFlowMessageAttributes = new WorkFlowMessageAttributes();
        workFlowMessageAttributes.setCity(attributes.getCity());
        workFlowMessageAttributes.setContinent(attributes.getContinent());
        workFlowMessageAttributes.setCountry(attributes.getCountry());
        workFlowMessageAttributes.setHouseNumber(attributes.getHouseNumber());
        workFlowMessageAttributes.setId(attributes.getId());
        workFlowMessageAttributes.setName(attributes.getName());
        workFlowMessageAttributes.setProvince(attributes.getProvince());
        workFlowMessageAttributes.setSomethingElse(attributes.getSomethingElse());
        workFlowMessageAttributes.setOneMoreThing(attributes.getOneMoreThing());
        workFlowMessageAttributes.setStreetNumber(attributes.getStreetNumber());
        workFlowDTO.workFlowMessageAttributes = workFlowMessageAttributes;



        WorkFlowMessageBody flowMessageBody = new WorkFlowMessageBody();
        flowMessageBody.setDetails(body.getDetails());
        workFlowDTO.flowMessageBody =  flowMessageBody;

        return workFlowDTO;
    }


    public WorkFlowDTO workFlowDTO1(WorkFlowMessageAttributes attributes, WorkFlowMessageBody body) throws JsonProcessingException {
        WorkFlowDTO workFlowDTO = objectMapper.readValue(body.toString(), WorkFlowDTO.class);
        return workFlowDTO;
    }

    @Override
    public WorkFlowMessageAttributes toWorkFlowAttributes(WorkFlowDTO workFlowDTO) {
        return null;
    }

    @Override
    public WorkFlowMessageBody toWorkFlowBody(WorkFlowDTO workFlowDTO) {
        return null;
    }
}
