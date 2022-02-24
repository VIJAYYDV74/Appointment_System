package peoplestrong.team7.appointmentApp.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentid;



    @JoinColumn(name = "appointmentid")
    private Long appointmentId;



    @JoinColumn(name = "userid")
    private Long usersId;

    @Column
    private String feedback;

    @Column
    private int rating;

    public Comments() {
    }


    public Comments(long commentid, Long appointmentId, Long usersId, String feedback, int rating) {
        this.commentid = commentid;
        this.appointmentId = appointmentId;
        this.usersId = usersId;
        this.feedback = feedback;
        this.rating = rating;
    }

    public long getCommentid() {
        return commentid;
    }

    public void setCommentid(long commentid) {
        this.commentid = commentid;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
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
                ", appointmentId=" + appointmentId +
                ", usersId=" + usersId +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }
}
