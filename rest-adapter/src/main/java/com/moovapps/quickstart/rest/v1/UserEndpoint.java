package com.moovapps.quickstart.rest.v1;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.moovapps.quickstart.core.bean.User;
import com.moovapps.quickstart.core.user.UserService;
import com.moovapps.quickstart.features.dummy.DummyFeature;
import java.util.Optional;
import java.util.function.Function;
import javax.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserEndpoint {

  private UserService userService;

  // Always Inject using constructor it's more testable
  @Inject
  public UserEndpoint(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(path = "/findByEmail")
  public ResponseEntity<UserDTO> findByEmail(@RequestParam("email") String email) {
    Optional<User> userOptional = this.userService.findUserByEmail(email);
    return ResponseEntity.of(userOptional.map(this::toDto));
  }

  public UserDTO toDto(User user)  {
    return new UserDTO(user.getEmail(), user.getFirstName(), user.getLastName());
  }
}
