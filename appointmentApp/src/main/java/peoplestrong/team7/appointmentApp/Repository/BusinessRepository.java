package peoplestrong.team7.appointmentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peoplestrong.team7.appointmentApp.Models.Business;
@Repository
public interface BusinessRepository extends JpaRepository<Business,Long> {
}
