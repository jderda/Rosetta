package com.hubspot.rosetta.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.hubspot.rosetta.Rosetta;
import com.hubspot.rosetta.beans.PolymorphicInnerBeanA;
import com.hubspot.rosetta.beans.PolymorphicInnerBeanB;
import com.hubspot.rosetta.beans.PolymorphicStoredAsJsonBean;
import com.hubspot.rosetta.beans.StoredAsJsonBean;

public class PolymorphicStoredAsJsonTest {
  private PolymorphicStoredAsJsonBean bean;
  private PolymorphicInnerBeanA innerA;
  private PolymorphicInnerBeanB innerB;
  private final JsonNode innerJsonNode = Rosetta.getMapper().createObjectNode().set("stringProperty", TextNode.valueOf("value"));
  private final JsonNode expectedA = TextNode.valueOf("{\"a\":\"a value\"}");
  private final JsonNode expectedB = TextNode.valueOf("{\"b\":\"b value\"}");

  @Before
  public void setup() {
    bean = new PolymorphicStoredAsJsonBean();
    innerA = new PolymorphicInnerBeanA();
    innerA.setA("a value");
    innerB = new PolymorphicInnerBeanB();
    innerB.setB("b value");
  }

  @Ignore
  @Test
  public void testAnnotatedFieldSerialization() {
    bean.setAnnotatedField(innerA);

    assertThat(Rosetta.getMapper().valueToTree(bean).get("annotatedField")).isEqualTo(expectedB);
  }

  @Ignore
  @Test
  public void testAnnotatedFieldDeserialization() throws JsonProcessingException {
    ObjectNode node = Rosetta.getMapper().createObjectNode();
    node.put("annotatedField", expectedB);

    StoredAsJsonBean bean = Rosetta.getMapper().treeToValue(node, StoredAsJsonBean.class);
    assertThat(bean.getAnnotatedField().getStringProperty()).isEqualTo("value");
  }

}
