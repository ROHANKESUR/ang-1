package com.example.ang_1.Service;

import com.example.ang_1.Dao.CandRepository;
import com.example.ang_1.Entity.Candidates;
import com.example.ang_1.Entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class myUserDetailService implements UserDetailsService {

   @Autowired
   CandRepository candRepository;


   @Override
   public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
      Candidates candidates = candRepository.findByUsername( username );

      if ( candidates == null ) {
         throw new UsernameNotFoundException( "user not found" + username );
      }
      return new UserPrincipal( candidates );
   }
}
