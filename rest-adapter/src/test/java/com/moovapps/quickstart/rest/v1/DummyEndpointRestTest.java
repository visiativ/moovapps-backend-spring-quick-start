package com.moovapps.quickstart.rest.v1;

import com.moovapps.quickstart.features.dummy.DummyFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class DummyEndpointRestTest {
	
	private DummyFeature dummyFeature;
	private DummyEndpoint dummyEndpoint;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		this.dummyFeature = mock(DummyFeature.class);
		this.dummyEndpoint = new DummyEndpoint(this.dummyFeature);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.dummyEndpoint).build();
		
	}
	
	@Test
	void ping() throws Exception {
		when(this.dummyFeature.ping()).thenReturn("pong");
		this.mockMvc.perform(get("/ping"))
			.andExpect(status().isOk())
			.andExpect(content().string("pong"));
	}
}