package br.com.zeroth.tusb.controller;

import br.com.zeroth.tusb.domain.User;
import br.com.zeroth.tusb.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void deveCriarUmUsuario() throws Exception {

        User user = new User(1l, "Leona Paes", "user1@gmail.net");

        when(userService.createUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Leona Paes\", \"email\": \"user1@gmail.net\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Leona Paes"))
                .andExpect(jsonPath("$.email").value("user1@gmail.net"));
    }

    @Test
    void deveObterUsuarioPeloId() throws Exception {

        User user = new User(1L, "User 2", "user2@gmail.net");

        when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("User 2"))
                .andExpect(jsonPath("$.email").value("user2@gmail.net"));

    }
}
