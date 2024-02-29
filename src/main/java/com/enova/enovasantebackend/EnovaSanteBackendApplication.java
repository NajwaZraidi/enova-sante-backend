package com.enova.enovasantebackend;

import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.dto.DTOCategorieDocumentRequest;
import com.enova.enovasantebackend.repository.CategorieDocumentRepository;
import com.enova.enovasantebackend.service.CategorieDocumentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class EnovaSanteBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnovaSanteBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategorieDocumentService service) {
        return args -> {
            DTOCategorieDocumentRequest save = DTOCategorieDocumentRequest.builder()
                    .code("code test")
                    .description("description test")
                    .ordre(5)
                    .actif(false)
                    .hl7("hl7 test")
                    .libelle("Libelle test")
                    .build();

            service.save(save);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the id: ");
            String id = sc.nextLine();
            System.out.println("Entered ID: " + id);
            service.delete(id);
        };
    }
}
