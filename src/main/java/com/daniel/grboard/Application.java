package com.daniel.grboard;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by daniel on 15. 4. 11.
 */
@Configurable
@EnableAutoConfiguration // 애플리케이션 실행시 스프링 부트가 resource 하위의 properties들을 찾는다.
@ComponentScan("com.daniel.grboard") //
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
