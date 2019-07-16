package com.moovapps.quickstart.features.dummy;

import static org.junit.jupiter.api.Assertions.*;

import com.moovapps.domain.api.features.dummy.DummyFeatureImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DummyFeatureImplUTest {

  private DummyFeatureImpl dummyFeature;

  @BeforeEach
  void setUp() {
    this.dummyFeature = new DummyFeatureImpl();
  }

  @Test
  void ping() {
    assertEquals("pong", this.dummyFeature.ping());
  }
}
