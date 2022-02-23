package peoplestrong.team7.appointmentApp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import peoplestrong.team7.appointmentApp.Models.BusinessWorkingHours;

public interface BusinessWorkingHoursRepository extends JpaRepository<BusinessWorkingHours, Long> {
}
