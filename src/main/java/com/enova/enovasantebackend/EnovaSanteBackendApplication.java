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

}
