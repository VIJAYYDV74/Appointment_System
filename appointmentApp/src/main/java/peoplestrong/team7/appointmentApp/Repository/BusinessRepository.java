package peoplestrong.team7.appointmentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peoplestrong.team7.appointmentApp.Models.Business;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business,Long> {
    List<Business> findByUsersUserid(long userid);

    @Query(value = "select * from business ",nativeQuery = true)
    List<Business> getAllBusiness();

    @Query(value = "select count(*) from business",nativeQuery = true)
    int countTotalBusiness();


    @Query(value = "select count(*) from business b ",nativeQuery = true)
    int countBusinessesToday();
}
