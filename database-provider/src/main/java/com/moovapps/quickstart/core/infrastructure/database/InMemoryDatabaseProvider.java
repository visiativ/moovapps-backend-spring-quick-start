package com.moovapps.quickstart.core.infrastructure.database;

import com.moovapps.quickstart.core.bean.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Named;

@Named
public class InMemoryDatabaseProvider implements DatabaseProvider {

  private List<User> users = new ArrayList<>();

  public InMemoryDatabaseProvider() {
    this.users.add(new User("famaridon@visiativ.com", "Florent", "Amaridon"));
  }

  @Override
  public Optional<User> findUserByEmail(String email) {
    return users.stream().filter(u -> email.equals(u.getEmail())).findAny();
  }
}