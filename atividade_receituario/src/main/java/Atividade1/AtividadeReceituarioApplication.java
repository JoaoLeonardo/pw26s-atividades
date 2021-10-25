package Atividade1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtividadeReceituarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtividadeReceituarioApplication.class, args);
		System.out.println("\n\nAcesse localhost:8085/teste para executar um teste de CRUD!\n\n");
	}

}
