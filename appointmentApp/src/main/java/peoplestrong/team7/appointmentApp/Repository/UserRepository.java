package peoplestrong.team7.appointmentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peoplestrong.team7.appointmentApp.Models.User;
import peoplestrong.team7.appointmentApp.Models.Appointment;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * from users u WHERE u.email=?1",nativeQuery = true)
    Optional<User> findByEmail(String Email);

//    @Query("select u from User u where u.firstName+u.lastName=:name")
 //   public User getUserByUserName(@Param("name") String name);
    @Query(value = "select * from users",nativeQuery = true)
      List<User> getAllUser();
    @Query(value = "select count(*) from users",nativeQuery = true)
      int countTotalUser();
    @Query(value = "select count(*) from users ",nativeQuery = true)
      int countTotalUserByThisWeek();

}
