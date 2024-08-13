package br.com.zeroth.tusb.controller;

import br.com.zeroth.tusb.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void deveBuscarUmUsuarioPeloIdNaApi() {
        ResponseEntity<User> response = testRestTemplate.getForEntity("/api/users/1", User.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User X", response.getBody().getName());
    }

    @Test
    void deveCriarDeFatoUmUsuarioNaNossaBase() {

        User user = new User(6l, "User 6", "user6@gmail.net");

        ResponseEntity<User> response = testRestTemplate.postForEntity("/api/users", user, User.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("User 6", response.getBody().getName());
    }
}