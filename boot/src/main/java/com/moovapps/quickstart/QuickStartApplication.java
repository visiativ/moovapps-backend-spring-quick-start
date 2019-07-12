package com.moovapps.quickstart;

import com.moovapps.quickstart.core.infrastructure.database.DatabaseProvider;
import com.moovapps.quickstart.core.infrastructure.database.InMemoryDatabaseProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.moovapps")
public class QuickStartApplication {

  public static void main(String[] args) {
    SpringApplication.run(QuickStartApplication.class, args);
  }

//  public DatabaseProvider buildDatabaseProvider(){
//    return new InMemoryDatabaseProvider();
//  }
}
