package com.enova.enovasantebackend;

import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.repository.CategorieDocumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnovaSanteBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnovaSanteBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategorieDocumentRepository categorieDocumentRepository) {
        return args -> {
            CategorieDocument categorieDocument = CategorieDocument.builder()
                    .code("Code test")
                    .libelle("Label test")
                    .description("Description test")
                    .ordre(4)
                    .actif(true)
                    .hl7("HL7 test")
                    .build();
            categorieDocumentRepository.save(categorieDocument);
        };
    }

}
