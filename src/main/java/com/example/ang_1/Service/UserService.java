package com.example.ang_1.Service;

import com.example.ang_1.Dao.CandRepository;
import com.example.ang_1.Entity.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   @Autowired
   CandRepository candRepository;

   @Autowired
   PasswordEncoder passwordEncoder;

   public Candidates register ( Candidates candidates ) {

      return candRepository.save( candidates );
   }

   public Candidates login ( Candidates candidates ) {
      Candidates cand = candRepository.findByUsername( candidates.getUsername() );
      if ( cand == null ||!passwordEncoder.matches( candidates.getPassword(), cand.getPassword() ) ) {
         throw new IllegalArgumentException( "invalid username and password" );
      }
      return cand;
   }
}
