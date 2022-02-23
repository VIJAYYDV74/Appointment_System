package peoplestrong.team7.appointmentApp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationid;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "receiver")
    private User users;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sender")
    private Business business;

    @Column
    private String header;

    @Column
    private String body;

    @OneToOne
    @JoinColumn(name = "appointmentid")
    private Appointment appointment;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdTime;

    public Notifications() {
    }

    public Notifications(User users, Business business, String header,
                         String body, Appointment appointment, LocalDateTime createdTime) {
        this.users = users;
        this.business = business;
        this.header = header;
        this.body = body;
        this.appointment = appointment;
        this.createdTime = createdTime;
    }

    public long getNotificationid() {
        return notificationid;
    }

    public void setNotificationid(long notificationid) {
        this.notificationid = notificationid;
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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Notifications{" +
                "notificationid=" + notificationid +
                ", users=" + users +
                ", business=" + business +
                ", header='" + header + '\'' +
                ", body='" + body + '\'' +
                ", appointment=" + appointment +
                ", createdTime=" + createdTime +
                '}';
    }
}
