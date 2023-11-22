# Security

```
username: user
passwort: password
```

Warum failen die Tests?

Korrigiere den Code!

Austausch gegen anderen login?

# Lösung
```
  @Bean
  protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            auth ->
                auth.requestMatchers("/", "/home", "/login")
                    .permitAll()
                    .anyRequest()
                    .authenticated())                    
        .logout(Customizer.withDefaults())
        .formLogin(
            (formLogin) ->
                formLogin
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginPage("/login"))    
    ;
    return http.build();
```
