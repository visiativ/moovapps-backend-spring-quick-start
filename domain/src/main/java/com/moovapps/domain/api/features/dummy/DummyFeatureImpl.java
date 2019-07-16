package com.moovapps.domain.api.features.dummy;

import com.moovapps.quickstart.features.dummy.DummyFeature;
import javax.inject.Named;

@Named
public class DummyFeatureImpl implements DummyFeature {

  public String ping() {
    return "pong";
  }
}
