package ch2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        applicationContext.register(Ch2BeanConfiguration.class);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        environment.setActiveProfiles("dev");
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addLast(new MapPropertySource("mapSource",
                Collections.singletonMap("name", (Object) "my foo")));
        applicationContext.refresh();

        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println(foo.getName());
    }

    private static void test2() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Configuration2.class, Configuration1.class);

        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println(foo.getName());
    }

    private static void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch2BeanConfiguration.class);

        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        System.out.println("Before money transfer");
        System.out.println("Account 1 balance: " + accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance: " + accountService.getAccount(2).getBalance());

        accountService.transferMoney(1, 2, 5.0);

        System.out.println("After money transfer");
        System.out.println("Account 1 balance: " + accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance: " + accountService.getAccount(2).getBalance());
    }

}
