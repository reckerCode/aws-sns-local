package io.sns.publisher.snssqsintegration.model;

import lombok.Data;

@Data
public class WorkFlowMessageAttributes {

    private String id;
    private String name;
    private String city;
    private String province;
    private String country;
    private String continent;
    private String streetNumber;
    private String houseNumber;
    private String somethingElse;
    private String oneMoreThing;

}
