package br.com.livraria.livrariaexemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LivrariaExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaExemploApplication.class, args);
	}

}
