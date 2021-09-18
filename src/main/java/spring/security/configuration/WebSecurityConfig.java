package spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
// помечаем класс, как ответственный за security, эта аннотация является конфигурацией, уже не нужно писать аннотацию @Configuration, Spring и так понимает это
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // Alt+Insert и выбрать Override methods, выбираем
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //создаем временный объект для дефоkтного шифрования паролей in memory в самом проекте, используем устаревший метод для отработки
        //затем будем сохранять пароли и данные в БД в шифрованном состоянии
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder
                        .username("Ivan")
                        .password("ivan")
                        .roles("EMPLOYEE"))
                .withUser(userBuilder
                        .username("Elena")
                        .password("elena")
                        .roles("HR"))
                .withUser(userBuilder
                        .username("Oleg")
                        .password("oleg")
                        .roles("MANAGER", "HR"));
    }

    // Alt+Insert и выбрать Override methods, выбираем
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR","MANAGER")
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info/**").hasRole("MANAGER")
                .and().formLogin().permitAll(); // /manager_info/** доступ на любой адрес, начинающийся с /manager_info/
    }
}
