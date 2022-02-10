package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"service","service.dto","service.mapper","web.rest"})
@EntityScan("domain")
@EnableJpaRepositories("repository")
public class BlindsterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlindsterApplication.class, args);
	}

}
