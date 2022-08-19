package main;

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
    }
}
