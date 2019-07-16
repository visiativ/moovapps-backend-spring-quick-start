package com.moovapps.domain.api.user;

import com.moovapps.quickstart.core.bean.User;
import java.util.Optional;

public interface UserService {

  public Optional<User> findUserByEmail(String email);
}
