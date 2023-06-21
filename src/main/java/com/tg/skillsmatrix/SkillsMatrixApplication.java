package com.tg.skillsmatrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.tg.skillsmatrix.entity")
@ComponentScan("com.tg.skillsmatrix.*")
@EnableJpaRepositories("com.tg.skillsmatrix.repository")
public class SkillsMatrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillsMatrixApplication.class, args);
    }


}
