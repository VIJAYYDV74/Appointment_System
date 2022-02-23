package peoplestrong.team7.appointmentApp.Models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    @Column(columnDefinition = "varchar(255)", name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(columnDefinition = "varchar(255) not null",nullable = false, unique = true, name = "email")
    private String email;

    @Column(nullable = false, name = "userpassword")
    private String userPassword;

    @Column(nullable = false, name = "mobilenumber")
    private String mobileNumber;

    @Column(columnDefinition = "timestamp default current_timestamp", name = "createdtime")
    private LocalDateTime createdTime;

    @Column(columnDefinition = "boolean default false", name = "isblocked")
    private boolean isBlocked;

    @Column(name = "profileimage")
    private String profileImage;

    @Column(columnDefinition = "boolean default false", name = "emailverified")
    private boolean emailVerified;




    @Transient
    public List<Appointment> totalAppointmentDetails ;
    @Transient
    public List<Appointment> upcomingAppointmentDetails;

    @Transient
    public int totalAppointments;
    @Transient
    public int totalReviews;
    @Transient
    public int upcomingAppointments;
    @Transient
    public List<Services> saloonServices;
    @Transient
    public List<Services> doctorServices;
    @Transient
    public List<Services> restaurantServices;




    public User(){

    }

    public User(String firstname, String lastname, String email,
                String userPassword, String mobileNumber, String profileImage) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.userPassword = userPassword;
        this.mobileNumber = mobileNumber;
        this.profileImage = profileImage;
    }

    public User(String firstname, String lastname, String email,
                String userPassword, String mobileNumber,
                boolean hasBusiness, LocalDateTime createdTime,
                boolean isBlocked, String profileImage, boolean emailVerified) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.userPassword = userPassword;
        this.mobileNumber = mobileNumber;
        this.createdTime = createdTime;
        this.isBlocked = isBlocked;
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", createdTime=" + createdTime +
                ", isBlocked=" + isBlocked +
                ", profileImage='" + profileImage + '\'' +
                ", emailVerified=" + emailVerified +
                '}';
    }

    public long getUserId() {
        return userid;
    }

    public void setUserId(long userId) {
        this.userid = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

}
