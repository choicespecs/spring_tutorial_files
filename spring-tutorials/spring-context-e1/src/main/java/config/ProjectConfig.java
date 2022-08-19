package config;

import beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

//    @Bean("A")
//    @Primary
//    public MyBean myBean1() {
//        MyBean b = new MyBean();
//        b.setText("Hello");
//        return b;
//    }
//
//    @Bean("B")
//    public MyBean myBean2() {
//        MyBean b = new MyBean();
//        b.setText("World");
//        return b;
//    }
}
