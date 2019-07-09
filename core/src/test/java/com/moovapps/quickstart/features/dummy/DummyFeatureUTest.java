package com.moovapps.quickstart.features.dummy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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