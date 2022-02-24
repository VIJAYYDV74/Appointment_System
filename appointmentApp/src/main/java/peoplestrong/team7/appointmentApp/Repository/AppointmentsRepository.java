package peoplestrong.team7.appointmentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peoplestrong.team7.appointmentApp.Models.Appointment;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment,Long> {

    @Query(value = "select * from appointment a where a.userid=:userId",nativeQuery = true)
    List<Appointment> TotalAppointmentByUserid(@Param("userId") Long userId);

    @Query(value = "select * from appointment a where a.userid=:userId ",nativeQuery = true)
      List<Appointment> getUpcomingAppointments(@Param("userId") Long userId );

    @Query(value = "select * from appointment",nativeQuery = true)
    List<Appointment> getAllAppointments();
}
