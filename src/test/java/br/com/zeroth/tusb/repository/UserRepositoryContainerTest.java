package br.com.zeroth.tusb.repository;

import br.com.zeroth.tusb.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@Testcontainers
@DataJpaTest
class UserRepositoryContainerTest {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User("John Doe", "john.doe@example.com");
        User savedUser = userRepository.save(user);

        assertNotNull(savedUser.getId());
        assertEquals("John Doe", savedUser.getName());
    }
}