package org.cjpostma.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.cjpostma.shop.controller", "org.cjpostma.shop.repository"})
public class WebShopApp {

    public static void main(String... args) {
        SpringApplication.run(WebShopApp.class, args);
    }
}
