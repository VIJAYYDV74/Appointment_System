package peoplestrong.team7.appointmentApp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import peoplestrong.team7.appointmentApp.Models.BusinessAddress;

public interface BusinessAddressRepository extends JpaRepository<BusinessAddress, Long> {
}
