package main;

import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        /**
         * XML
         * Annotations
         */

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            // Bean by Type
            MyBean b1 = context.getBean(MyBean.class);
            MyBean b2 = context.getBean(MyBean.class);
            MyBean b3 = context.getBean(MyBean.class);

            // Bean by Name
//            MyBean b1 = context.getBean("A", MyBean.class);
//            MyBean b2 = context.getBean("B", MyBean.class);
//            MyBean b3 = context.getBean("A", MyBean.class);


            System.out.println(b1.getText());
            System.out.println(b2.getText());
            System.out.println(b3.getText());


        }
    }
}
