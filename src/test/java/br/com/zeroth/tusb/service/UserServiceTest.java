package br.com.zeroth.tusb.service;

import br.com.zeroth.tusb.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @WithMockUser(roles = "ADMIN")
    void ddeveDeletarUsario() throws ResourceNotFoundException {
        userService.deleteUser(1L);
    }


}