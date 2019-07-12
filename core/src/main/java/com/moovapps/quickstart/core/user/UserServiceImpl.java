package com.moovapps.quickstart.core.user;

import static org.apache.commons.lang3.Validate.*;

import com.moovapps.quickstart.core.bean.User;
import com.moovapps.quickstart.core.infrastructure.database.DatabaseProvider;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserServiceImpl implements UserService {

  private DatabaseProvider databaseProvider;

  @Inject
  public UserServiceImpl(DatabaseProvider databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public Optional<User> findUserByEmail(String email) {
    return this.databaseProvider.findUserByEmail(notBlank(email));
  }
}
