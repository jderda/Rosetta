package com.hubspot.rosetta.beans;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, 
    include = JsonTypeInfo.As.PROPERTY, 
    property = "@type")
  @JsonSubTypes({
    @Type(value = PolymorphicInnerBeanA.class, name = "beanA"), 
    @Type(value = PolymorphicInnerBeanA.class, name = "beanB"), 
  })
public interface PolymorphicInnerBeanIF {
  
}
