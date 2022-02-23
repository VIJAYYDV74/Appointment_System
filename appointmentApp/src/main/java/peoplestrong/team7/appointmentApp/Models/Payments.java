package peoplestrong.team7.appointmentApp.Models;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentid;

    @Column(name = "paymentmethod")
    private String paymentmethod;

    @Column(name = "paymentdate")
    private LocalDateTime paymentDate;

    @Column(name = "amount")
    private int amount;

    public Payments() {
    }

    public Payments(String paymentmethod, LocalDateTime paymentDate, int amount, Appointment appointment) {
        this.paymentmethod = paymentmethod;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "paymentid=" + paymentid +
                ", paymentmethod='" + paymentmethod + '\'' +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                '}';
    }
}
