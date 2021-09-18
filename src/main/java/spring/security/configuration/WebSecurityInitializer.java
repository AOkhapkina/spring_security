package spring.security.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//это пустой но очень важный класс, без которого не будет запрашиваться форма для аутентификации, где мы будем вводить username/password
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
