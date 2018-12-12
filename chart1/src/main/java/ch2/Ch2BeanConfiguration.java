package ch2;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class Ch2BeanConfiguration {

    @Bean(autowire = Autowire.BY_NAME)
    public AccountService accountService() {
        AccountServiceImpl bean = new AccountServiceImpl();
//        bean.setAccountDao(accountDao());
        return bean;
    }

    @Bean
    public AccountDao accountDao() {
        AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
        return bean;
    }

    @Bean
    public AccountDao accountDaoJdbc() {
        AccountDaoJdbcImpl bean = new AccountDaoJdbcImpl();
        return bean;
    }

    @Bean
    @Profile("dev")
    public Foo devFoo(@Value("${name}") String name) {
        Foo foo = new Foo();
        foo.setName("dev " + name);
        return foo;
    }

    @Bean
    @Profile("prod")
    public Foo prodFoo(@Value("${name}") String name) {
        Foo foo = new Foo();
        foo.setName("prod " + name);
        return foo;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
