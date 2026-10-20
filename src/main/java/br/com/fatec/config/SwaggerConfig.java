package br.com.fatec.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Ninjas",
                version = "1.0",
                description = "API REST desenvolvida com Spring Boot para gerenciamento de ninjas. Permite realizar operações de cadastro, consulta, atualização e exclusão de ninjas, facilitando o controle e a organização das informações por meio de endpoints HTTP.",
                contact = @Contact(
                        name = "Equipe de Desenvolvimento - Fatec Jales",
                        email = "devfatecjales@cps.sp.gov.br"
                )
        )
)

public class SwaggerConfig {
}
