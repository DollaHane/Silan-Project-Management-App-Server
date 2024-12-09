package com.silan.projectmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class ProjectmanagerApplication {

  // @GetMapping is used to set an endpoint address.
  @GetMapping("/")
  public String home() {
    return "home"; // Returns the home.html template
  }

	public static void main(String[] args) {
		SpringApplication.run(ProjectmanagerApplication.class, args);
    
	}

}
