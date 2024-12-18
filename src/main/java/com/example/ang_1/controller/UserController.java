package com.example.ang_1.controller;

import com.example.ang_1.Entity.Candidates;
import com.example.ang_1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ( "/api" )
public class UserController {

   @Autowired
   UserService userService;

   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

   @PostMapping ( "/register" )
   public Candidates register ( @RequestBody Candidates candidates ) {
      candidates.setPassword( encoder.encode( candidates.getPassword() ) );
      return userService.register( candidates );
   }

   @PostMapping ( "/login" )
   public Candidates login ( @RequestBody Candidates candidates ) {
      return userService.login( candidates );
   }
}
