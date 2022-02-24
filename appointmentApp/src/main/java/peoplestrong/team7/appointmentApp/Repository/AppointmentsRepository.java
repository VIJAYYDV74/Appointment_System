package peoplestrong.team7.appointmentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peoplestrong.team7.appointmentApp.Models.Appointment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment,Long> {

    @Query(value = "select * from appointment a where a.userid= ?1",nativeQuery = true)
    List<Appointment> TotalAppointmentByUserid(Long userId);

    @Query(value = "select * from appointment a where a.userid= ?1 and cast(bookeddate as Date) > cast( ?2 as Date)",nativeQuery = true)
      List<Appointment> getUpcomingAppointments(Long userId , LocalDateTime now);

    @Query(value = "select * from appointment",nativeQuery = true)
    List<Appointment> getAllAppointments();
}
