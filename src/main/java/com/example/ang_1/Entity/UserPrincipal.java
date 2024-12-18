package com.example.ang_1.Entity;

import com.example.ang_1.Entity.Candidates;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

   private Candidates candidates;

   public UserPrincipal ( Candidates candidates ) {
      this.candidates = candidates;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities () {
      return List.of();
   }

   @Override
   public String getPassword () {
      return candidates.getPassword();
   }

   @Override
   public String getUsername () {
      return candidates.getUsername();
   }

   @Override
   public boolean isAccountNonExpired () {
      return true;
   }

   @Override
   public boolean isAccountNonLocked () {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired () {
      return true;
   }

   @Override
   public boolean isEnabled () {
      return true;
   }
}
