package br.com.zeroth.tusb.repository;

import br.com.zeroth.tusb.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    
    @Autowired
    private UserRepository userRepository;

    @Test
    void deveEncontrarUsuarioPorId() {

        User user = new User("User 1", "user1@gmail.com");
        
        testEntityManager.persistAndFlush(user);

        User found = userRepository.findById(user.getId()).orElse(null);

        assertEquals(user.getName(), found.getName());
    }

    @Test
    void deveCriarUmUsuarioNaBaseDeDados() {
        User user = new User("User 1", "user1@gmail.com");
        User save = userRepository.save(user);

        assertNotNull(save.getId());
    }
}