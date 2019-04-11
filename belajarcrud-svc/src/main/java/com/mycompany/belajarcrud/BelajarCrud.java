package com.mycompany.belajarcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

/**
 *
 * @author leevydmalik
 */
@SpringBootApplication
public class BelajarCrud {

    public static void main(String[] args) {
        SpringApplication.run(BelajarCrud.class, args);
    }

    
    /**
     * IMPORTANT FOR HOLDING HIBERNATE SESSION IN SPRING BOOT
     * @return 
     */
    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

}
