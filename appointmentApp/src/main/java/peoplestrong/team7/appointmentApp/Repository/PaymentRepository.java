package peoplestrong.team7.appointmentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peoplestrong.team7.appointmentApp.Models.Payments;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payments,Long> {

    @Query(value = "select * from payments ",nativeQuery = true)
    List<Payments> getAllPayments();

    @Query(value = "select sum(amount) as totalRevenue from payments",nativeQuery = true)
    int countTotalRevenue();

    @Query(value = "select sum(amount) as lastWeekRevenue from payments ",nativeQuery = true)
    int countRevenueThisWeek();
}
