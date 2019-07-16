package com.moovapps.quickstart.core.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.moovapps.quickstart.core.bean.User;
import com.moovapps.quickstart.core.infrastructure.database.DatabaseProvider;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceImplUTest {

  private UserServiceImpl userService;
  private DatabaseProvider databaseProvider;

  @BeforeEach
  void setUp() {
    this.databaseProvider = mock(DatabaseProvider.class);
    this.userService = new UserServiceImpl(databaseProvider);
  }

  @Test
  void findUserByEmail() {
    when(this.databaseProvider.findUserByEmail("fpicot@visiativ.com"))
        .thenReturn(Optional.of(new User("fpicot@visiativ.com", "Florent", "Picot")));
    Optional<User> optionalUser = this.userService.findUserByEmail("fpicot@visiativ.com");
    assertTrue(optionalUser.isPresent());
  }

  @Test
  void findUserByEmailNotFound() {
    when(this.databaseProvider.findUserByEmail("flucas@visiativ.com")).thenReturn(Optional.empty());
    Optional<User> optionalUser = this.userService.findUserByEmail("flucas@visiativ.com");
    assertFalse(optionalUser.isPresent());
  }

  @Test
  void findUserByEmailWithNull() {
    assertThrows(NullPointerException.class, () -> this.userService.findUserByEmail(null));
  }

  @Test
  void findUserByEmailWithBlank() {
    assertThrows(IllegalArgumentException.class, () -> this.userService.findUserByEmail(" "));
  }
}
