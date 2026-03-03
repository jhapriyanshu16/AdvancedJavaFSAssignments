package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

      ApplicationContext ioc =new AnnotationConfigApplicationContext(CustomConfig.class);

        Student sbean = ioc.getBean(Student.class);
        System.out.println(sbean);//bean means object

        System.out.println(sbean.getId());
        System.out.println(sbean.getName());
        Student sbean2 = ioc.getBean(Student.class);
        sbean2.setId(20);
        sbean2.setName("Divya");
        System.out.println(sbean2.getId());
        System.out.println(sbean2.getName());

        System.out.println(sbean==sbean2);


//        System.out.println( "Hello World!" );
    }
}
