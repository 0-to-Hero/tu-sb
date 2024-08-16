package br.com.zeroth.tusb.service;

import br.com.zeroth.tusb.domain.User;
import br.com.zeroth.tusb.exception.ResourceNotFoundException;
import br.com.zeroth.tusb.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }

    @SneakyThrows
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @SneakyThrows
    @Secured("ROLE_ADMIN")
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
