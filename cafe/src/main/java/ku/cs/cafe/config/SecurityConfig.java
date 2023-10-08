package ku.cs.cafe.config;
// 6410406878
// Sarunpawat Phosoi
import ku.cs.cafe.sevice.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableAspectJAutoProxy
public class SecurityConfig {
    @Autowired
    private UserDetailServiceImp userDetailServiceImp;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
              .authorizeHttpRequests((requests) -> requests
                      //เข้าถึงได้เลย
                      .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                      .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                      .requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
                      .requestMatchers(new AntPathRequestMatcher("/signup")).permitAll()
                      //เข้าถึงได้แค่ admin
                      .requestMatchers(
                              new AntPathRequestMatcher("/categories/add")).hasRole("ADMIN")
                      .requestMatchers(
                              new AntPathRequestMatcher("/menus/add")).hasRole("ADMIN")
                      .requestMatchers(
                              new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
                      .anyRequest().authenticated()
              )
              .formLogin((form) -> form
                      .loginPage("/login")
                      .defaultSuccessUrl("/", true)
                      .permitAll()
              )
              .logout((logout) -> logout
                      .logoutUrl("/logout")
                      .clearAuthentication(true)
                      .invalidateHttpSession(true)
                      .deleteCookies("JSESSIONID", "remember-me")
                      .permitAll()
              );

        //Builder patten
      return http.build();
  }
    // many encoder default = 10
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }


}
