package peoplestrong.team7.appointmentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peoplestrong.team7.appointmentApp.Models.Payments;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payments,Long> {

    @Query(value = "select * from payments ",nativeQuery = true)
    List<Payments> getAllPayments();

    @Query(value = "select sum(amount) as totalRevenue from payments",nativeQuery = true)
    int countTotalRevenue();

    @Query(value = "select sum(amount) as lastWeekRevenue from payments paymentdate=2022/02/23 ",nativeQuery = true)
    int countRevenueThisWeek();
}
