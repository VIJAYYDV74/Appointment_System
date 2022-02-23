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

    @ManyToOne
    @JoinColumn(name = "userid")
    private User users;

    @ManyToOne
    @JoinColumn(name = "businessid")
    private Business business;

    @ManyToOne
    @JoinColumn(name = "typeofservice")
    private Services services;

    @OneToOne
    @JoinColumn(name = "paymentid")
    private Payments payments;

    public Appointment() {
    }

    public Appointment(LocalDateTime bookedDate, LocalDateTime appointmentDate,
                       Time beginTime, String status,
                       boolean isCancelled, String cancellationReason, User users,
                       Business business, Services services, Payments payments) {
        this.bookedDate = bookedDate;
        this.appointmentDate = appointmentDate;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.isCancelled = isCancelled;
        this.cancellationReason = cancellationReason;
        this.users = users;
        this.business = business;
        this.services = services;
        this.payments = payments;
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

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
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
                ", users=" + users +
                ", business=" + business +
                ", services=" + services +
                ", payments=" + payments +
                '}';
    }
}
