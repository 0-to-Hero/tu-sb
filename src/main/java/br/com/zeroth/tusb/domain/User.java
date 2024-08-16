package br.com.zeroth.tusb.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.PersistenceConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull private String name;
    @NonNull private String email;

}
