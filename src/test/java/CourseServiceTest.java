import com.developer.pst.personal_sport_trackerz.dto.CoursesDTO;
import com.developer.pst.personal_sport_trackerz.entity.Course;
import com.developer.pst.personal_sport_trackerz.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CourseServiceTest {

    @InjectMocks
    private CourseService courseService;

    @Test
    void findAllTest() {
        List<CoursesDTO> coursesDTOS = courseService.findAll();

        List<Course> expectedCourses = Arrays.asList(
                new Course(1L, "Localisation", LocalDate.now(), Boolean.TRUE, 5),
                new Course(2L, "Localisation2", LocalDate.now(), Boolean.TRUE, 10)
        );
        Assertions.assertEquals(expectedCourses, coursesDTOS);
    }


}
