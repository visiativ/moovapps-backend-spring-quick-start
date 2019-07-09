package com.moovapps.quickstart.features.dummy;

import javax.inject.Named;

@Named
public class DummyFeature {

  public String ping() {
    return "pong";
  }
}
