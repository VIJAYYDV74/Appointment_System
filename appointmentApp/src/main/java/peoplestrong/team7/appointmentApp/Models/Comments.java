package peoplestrong.team7.appointmentApp.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentid;

    @OneToOne
    @JoinColumn(name = "appointmentid")
    private Appointment appointment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "commentedby")
    private User users;

    @Column
    private String feedback;

    @Column
    private int rating;

    public Comments() {
    }

    public Comments(Appointment appointment, User users, String feedback, int rating) {
        this.appointment = appointment;
        this.users = users;
        this.feedback = feedback;
        this.rating = rating;
    }

    public long getCommentid() {
        return commentid;
    }

    public void setCommentid(long commentid) {
        this.commentid = commentid;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentid=" + commentid +
                ", appointment=" + appointment +
                ", users=" + users +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }
}
