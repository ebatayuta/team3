package lec03.team3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Sample3AuthConfiguration {

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    UserDetails user1 = User.withUsername("user1")
        .password("{bcrypt}$2y$05$ch5zb.UzB1mYuYAbmGlPJeHjAywHZcz2Ehwwe2MuVbSG3FnIebzi6").roles("ADMIN").build();
    UserDetails user2 = User.withUsername("user2")
        .password("{bcrypt}$2y$05$Odtd7kgpdkDqqAaSwU2ZGerMadFHQYJFHd7J2oHCW0b3sycs1IJgO").roles("USER").build();

    return new InMemoryUserDetailsManager(user1, user2);
  }

}
