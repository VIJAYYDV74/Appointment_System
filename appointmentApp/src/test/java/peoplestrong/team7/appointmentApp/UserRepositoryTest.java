package peoplestrong.team7.appointmentApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import peoplestrong.team7.appointmentApp.Models.User;
import peoplestrong.team7.appointmentApp.Repository.UserRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("alex@gmail.com");
        user.setPassword("alex@123");
        user.setFirstName("Alex");
        user.setLastName("Acorn");

        User savedUser = userRepository.save(user);
        User existUser = entityManager.find(User.class, savedUser.getUserid());

        assertThat(savedUser.getEmail()).isEqualTo(existUser.getEmail());
    }

    @Test
    public void findUserByEmail() {
        String email = "rohan@gmail.com";
        User user = userRepository.findByEmail(email).get();
        assertThat(user.getEmail()).isEqualTo(email);
    }
}
