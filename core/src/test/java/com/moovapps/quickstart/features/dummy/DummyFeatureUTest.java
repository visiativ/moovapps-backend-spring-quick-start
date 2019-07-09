package com.moovapps.quickstart.features.dummy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DummyFeatureUTest {

  private DummyFeature dummyFeature;

  @BeforeEach
  void setUp() {
    this.dummyFeature = new DummyFeature();
  }

  @Test
  void ping() {
    assertEquals("pong", this.dummyFeature.ping());
  }
}
