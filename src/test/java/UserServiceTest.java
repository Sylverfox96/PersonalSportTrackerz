import com.developer.pst.personal_sport_trackerz.dto.UsersDTO;
import com.developer.pst.personal_sport_trackerz.entity.User;
import com.developer.pst.personal_sport_trackerz.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    void findAllTest() {
        List<UsersDTO> userDTOS = userService.findAll();

        List<User> expectedUsers = Arrays.asList(
                new User(1L, "User", "user", "mohamed@gmail.com", 25, User.Role.USER),
                new User(2L, "Coach", "coach", "coach@gmail.com", 20, User.Role.COACH)
        );
        Assertions.assertEquals(expectedUsers, userDTOS);

    }

    @Test
    void addTest() {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setFirstName("User");
        usersDTO.setLastName("user");
        usersDTO.setEmail("user@gmail.com");
        usersDTO.setAge(25);
        usersDTO.setRole(User.Role.COACH.name());

        Long createdUserId = userService.create(usersDTO);

        Assertions.assertNotNull(createdUserId);
        Assertions.assertEquals(1L, createdUserId);
    }


}
