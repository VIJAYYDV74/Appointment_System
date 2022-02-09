package peoplestrong.team7.appointmentApp.Models;

import javax.persistence.*;
import java.sql.Time;
@Entity
@Table(name = "BUSINESS")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int businessId;
    @Column(name = "ownerId",nullable = false,unique = true)
    public int ownerId;
    @Column(name = "BusinessName",nullable = false,unique = true)
    public String businessName;
    @Column(name = "BusinessDescription")
    public String businessDescription;
    @Column(name = "BusinessCategory",nullable = false)
    public int businessCategory;
    @Column(name = "BusinessNumber",nullable = false,unique = true,length = 13)
    public String businessNumber;
    @Column(name = "BusinessEmail",nullable = false,unique = true)
    public String businessEmail;
    @Column(name = "CancellationAvailable",nullable = false)
    public boolean cancellationAvailable;
    @Column(name = "OpeningTime",nullable = false)
    public Time openingTime;
    @Column(name = "ClosingTime",nullable = false)
    public Time closingTime;
    @Column(name = "GenderCategory",nullable = false)
    public String genderCategory;

    @ManyToOne
    public User user;


    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public int getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(int businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public boolean isCancellationAvailable() {
        return cancellationAvailable;
    }

    public void setCancellationAvailable(boolean cancellationAvailable) {
        this.cancellationAvailable = cancellationAvailable;
    }

    public Time getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
    }

    public Time getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Time closingTime) {
        this.closingTime = closingTime;
    }

    public String getGenderCategory() {
        return genderCategory;
    }

    public void setGenderCategory(String genderCategory) {
        this.genderCategory = genderCategory;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", ownerId=" + ownerId +
                ", businessName='" + businessName + '\'' +
                ", businessDescription='" + businessDescription + '\'' +
                ", businessCategory=" + businessCategory +
                ", businessNumber='" + businessNumber + '\'' +
                ", businessEmail='" + businessEmail + '\'' +
                ", cancellationAvailable=" + cancellationAvailable +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", genderCategory='" + genderCategory + '\'' +
                '}';
    }
}
