package peoplestrong.team7.appointmentApp.Models;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appointmentid;

    @Column(name = "bookeddate")
    private LocalDateTime bookedDate;

    @Column(name = "dateofappointment")
    private LocalDateTime appointmentDate;

    @Column(name = "begintime")
    private Time beginTime;

    @Column(name = "endtime")
    private Time endTime;

    @Column(name = "totalprice")
    private int totalPrice;

    @Column(name = "activestatus")
    private String status;

    @Column(columnDefinition = "bool default false", name = "iscancelld")
    private boolean isCancelled;

    @Column(name = "cancellationreason")
    private String cancellationReason;

    //@ManyToOne
    @Column(name = "userid")
    private Long usersId;

    //@ManyToOne
    @Column(name = "businessid")
    private Long businessId;

    //@ManyToOne
    @Column(name = "typeofservice")
    private Long servicesId;

    @Column(name = "servicename")
    private String serviceName;


    //@OneToOne
    @Column(name = "paymentid")
    private Long paymentsId;

    public Appointment() {
    }

    public Appointment(long appointmentid, LocalDateTime bookedDate, LocalDateTime appointmentDate, Time beginTime, Time endTime, int totalPrice, String status, boolean isCancelled, String cancellationReason, Long usersId, Long businessId, Long servicesId, String serviceName, Long paymentsId) {
        this.appointmentid = appointmentid;
        this.bookedDate = bookedDate;
        this.appointmentDate = appointmentDate;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.totalPrice = totalPrice;
        this.status = status;
        this.isCancelled = isCancelled;
        this.cancellationReason = cancellationReason;
        this.usersId = usersId;
        this.businessId = businessId;
        this.servicesId = servicesId;
        this.serviceName = serviceName;
        this.paymentsId = paymentsId;
    }

    public long getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(long appointmentid) {
        this.appointmentid = appointmentid;
    }

    public LocalDateTime getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(LocalDateTime bookedDate) {
        this.bookedDate = bookedDate;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getServicesId() {
        return servicesId;
    }

    public void setServicesId(Long servicesId) {
        this.servicesId = servicesId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getPaymentsId() {
        return paymentsId;
    }

    public void setPaymentsId(Long paymentsId) {
        this.paymentsId = paymentsId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentid=" + appointmentid +
                ", bookedDate=" + bookedDate +
                ", appointmentDate=" + appointmentDate +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", isCancelled=" + isCancelled +
                ", cancellationReason='" + cancellationReason + '\'' +
                ", usersId=" + usersId +
                ", businessId=" + businessId +
                ", servicesId=" + servicesId +
                ", serviceName='" + serviceName + '\'' +
                ", paymentsId=" + paymentsId +
                '}';
    }
}
