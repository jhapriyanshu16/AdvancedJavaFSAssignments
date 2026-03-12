package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//public class AppConfig {
//    @Bean
//    public Address address() {
//        return new Address("Delhi", "India", 110001L);
//    }
//
//    @Bean
//    public Student student() {
//        return new Student("Rahul", "Sharma", 25, address());
//    }
//}


@Configuration
@ComponentScan("org.example")
public class AppConfig {

}