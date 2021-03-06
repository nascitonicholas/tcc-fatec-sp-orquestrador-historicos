package br.com.fatec.sp.tcc.orquestadrorhistorico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrquestadrorHistoricoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestadrorHistoricoApplication.class, args);
	}

}
