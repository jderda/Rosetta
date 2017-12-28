package com.hubspot.rosetta.beans;

import com.hubspot.rosetta.annotations.StoredAsJson;

public class PolymorphicStoredAsJsonBean {

  @StoredAsJson
  private PolymorphicInnerBeanA annotatedField;

  public PolymorphicInnerBeanA getAnnotatedField() {
    return annotatedField;
  }

  public void setAnnotatedField(PolymorphicInnerBeanA annotatedField) {
    this.annotatedField = annotatedField;
  }

}
