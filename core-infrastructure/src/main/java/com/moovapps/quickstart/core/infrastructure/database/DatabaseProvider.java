package com.moovapps.quickstart.core.infrastructure.database;

import com.moovapps.quickstart.core.bean.User;
import java.util.Optional;

public interface DatabaseProvider {

  public Optional<User> findUserByEmail(String email);
}
