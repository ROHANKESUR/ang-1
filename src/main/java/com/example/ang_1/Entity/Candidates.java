package com.example.ang_1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity

public class Candidates {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   long userId;
   String username;

   public Candidates () {
   }

   public Candidates ( long userId, String username, String email, String password ) {
      this.userId = userId;
      this.username = username;
      this.email = email;
      this.password = password;
   }


   public long getUserId () {
      return userId;
   }

   public void setUserId ( long userId ) {
      this.userId = userId;
   }

   public String getUsername () {
      return username;
   }

   public void setUsername ( String username ) {
      this.username = username;
   }

   public String getEmail () {
      return email;
   }

   public void setEmail ( String email ) {
      this.email = email;
   }

   public String getPassword () {
      return password;
   }

   public void setPassword ( String password ) {
      this.password = password;
   }

   String email;
   String password;
}
