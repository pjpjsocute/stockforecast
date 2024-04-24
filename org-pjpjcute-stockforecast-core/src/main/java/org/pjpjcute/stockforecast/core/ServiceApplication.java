package org.pjpjcute.stockforecast.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

@SpringBootApplication(scanBasePackages = "org.pjpjcute.stockforecast")
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

}
