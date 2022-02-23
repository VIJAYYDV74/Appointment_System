package peoplestrong.team7.appointmentApp.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long likeid;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "likedby")
    private User users;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "likedto")
    private Business business;

    public Likes() {
    }

    public Likes(User users, Business business) {
        this.users = users;
        this.business = business;
    }

    public long getLikeid() {
        return likeid;
    }

    public void setLikeid(long likeid) {
        this.likeid = likeid;
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
}
