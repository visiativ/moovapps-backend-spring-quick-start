package com.moovapps.domain.api.features.dummy;

import javax.inject.Named;

@Named
public class DummyFeatureImpl implements DummyFeature {

  public String ping() {
    return "pong";
  }
}
