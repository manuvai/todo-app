package fr.lededoc.todo_app.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server localhostServer = new Server();
        localhostServer.setUrl("http://localhost:8080");
        localhostServer.setDescription("Development");

        Server renderServer = new Server();
        renderServer.setUrl("https://todo-app-qh6w.onrender.com/");
        renderServer.setDescription("Render");

        Contact myContact = new Contact();
        myContact.setName("Manuvai REHUA");
        myContact.setEmail("manuvai.rehua@gmail.com");

        Info information = new Info()
                .title("TODO API")
                .version("1.0")
                .description("This API exposes endpoints to manage todo lists.")
                .contact(myContact);
        return new OpenAPI()
                .info(information)
                .servers(List.of(localhostServer, renderServer));
    }
}