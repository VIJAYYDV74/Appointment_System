package peoplestrong.team7.appointmentApp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peoplestrong.team7.appointmentApp.Models.Services;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Services,Long> {
    @Query(value = "select * from services s where s.serviceName= ?1 " ,nativeQuery = true)
    List<Services> getByServiceNameOrderByServicePriceAsc(String serviceName);

}
