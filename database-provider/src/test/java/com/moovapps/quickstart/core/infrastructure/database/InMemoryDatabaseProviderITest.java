package com.moovapps.quickstart.core.infrastructure.database;

import static org.junit.jupiter.api.Assertions.*;

import com.moovapps.providers.core.infrastructure.database.InMemoryDatabaseProvider;
import com.moovapps.quickstart.core.bean.User;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InMemoryDatabaseProviderITest {

  private DatabaseProvider databaseProvider;

  @BeforeEach
  void setUp() {
    this.databaseProvider = new InMemoryDatabaseProvider();
  }

  @Test
  void findUserByEmail() {
    Optional<User> user = databaseProvider.findUserByEmail("famaridon@visiativ.com");
    assertTrue(user.isPresent(), "User is not found by email!");
    user.ifPresent(
        u -> {
          assertEquals("Florent", u.getFirstName());
          assertEquals("Amaridon", u.getLastName());
        });
  }
}
