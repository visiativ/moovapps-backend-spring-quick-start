package com.moovapps.quickstart.rest.v1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.moovapps.quickstart.core.bean.User;
import com.moovapps.quickstart.core.user.UserService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class UserEndpointUTest {

  private UserService userService;
  private UserEndpoint userEndpoint;
  private MockMvc mockMvc;
  private User fpicot = new User("fpicot@visiativ.com", "Florent", "Picot");

  @BeforeEach
  void setUp() {
    this.userService = mock(UserService.class);
    this.userEndpoint = new UserEndpoint(this.userService);
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.userEndpoint).build();
  }

  @Test
  void findByEmail() throws Exception {
    when(this.userService.findUserByEmail("fpicot@visiativ.com"))
        .thenReturn(Optional.of(this.fpicot));

    this.mockMvc
        .perform(get("/users/findByEmail?email={email}", "fpicot@visiativ.com"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.email").value(this.fpicot.getEmail()))
        .andExpect(jsonPath("$.firstName").value(this.fpicot.getFirstName()))
        .andExpect(jsonPath("$.lastName").value(this.fpicot.getLastName()));
  }

  @Test
  void findByEmailNotFound() throws Exception {
    this.mockMvc
        .perform(get("/users/findByEmail?email={email}", "flucas@visiativ.com"))
        .andExpect(status().isNotFound());
  }

  @Test
  void toDto() {
    UserDTO dto = this.userEndpoint.toDto(fpicot);
    assertEquals(fpicot.getEmail(), dto.getEmail());
    assertEquals(fpicot.getFirstName(), dto.getFirstName());
    assertEquals(fpicot.getLastName(), dto.getLastName());
  }
}