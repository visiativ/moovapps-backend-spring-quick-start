package com.moovapps.quickstart.rest.v1;

import com.moovapps.quickstart.features.dummy.DummyFeature;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyEndpoint {

  private DummyFeature dummyFeature;

  // Always Inject using constructor it's more testable
  @Inject
  public DummyEndpoint(DummyFeature dummyFeature) {
    this.dummyFeature = dummyFeature;
  }

  @GetMapping(path = "/ping")
  public String ping() {
    return this.dummyFeature.ping();
  }
}
