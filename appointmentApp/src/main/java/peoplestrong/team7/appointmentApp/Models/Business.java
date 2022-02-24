package peoplestrong.team7.appointmentApp.Models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long businessid;

    @Column(columnDefinition = "varchar(255)", nullable = false, name = "businessname")
    private String businessName;

    @Column(columnDefinition = "text", nullable = false, name = "businessdescription")
    private String businessDescription;

    @Column(columnDefinition = "varchar(255)", nullable = false, name = "businesstitle")
    private String businessTitle;

    @Column(nullable = false, name = "businessnumber")
    private String businessMobileNumber;

    @Column(nullable = false, name = "businessemail")
    private String businessEmail;

    @Column(columnDefinition = "boolean default false", name = "cancellationavailable")
    private boolean cancellationAvailable;

    @Column(name = "slotduration")
    private int slotDuration;

    @Column(name = "gendercategory")
    private String genderCategory;

    @Column(columnDefinition = "boolean default false", name = "emailverified")
    private boolean emailVerified;

    @Column(columnDefinition = "timestamp default current_timestamp", name = "createdtime")
    private LocalDateTime createdTime;

    @Column(name = "businessimages")
    private String businessImages;

    @ManyToOne
    @JoinColumn(name = "businesscategory")
    private Categories categories;

    //@ManyToOne
    @Column(name = "userid", nullable = false)
    private Long userId;

    @OneToMany(mappedBy = "businessHours", targetEntity = BusinessWorkingHours.class)
    private List<BusinessWorkingHours> workingHours;

    @OneToOne
    @JoinColumn(name = "businessaddress")
    private BusinessAddress businessAddress;

    public Business(){

    }

    public Business(long businessid, String businessName, String businessDescription, String businessTitle, String businessMobileNumber, String businessEmail, boolean cancellationAvailable, int slotDuration, String genderCategory, boolean emailVerified, LocalDateTime createdTime, String businessImages, Categories categories, Long userId, List<BusinessWorkingHours> workingHours, BusinessAddress businessAddress) {
        this.businessid = businessid;
        this.businessName = businessName;
        this.businessDescription = businessDescription;
        this.businessTitle = businessTitle;
        this.businessMobileNumber = businessMobileNumber;
        this.businessEmail = businessEmail;
        this.cancellationAvailable = cancellationAvailable;
        this.slotDuration = slotDuration;
        this.genderCategory = genderCategory;
        this.emailVerified = emailVerified;
        this.createdTime = createdTime;
        this.businessImages = businessImages;
        this.categories = categories;
        this.userId = userId;
        this.workingHours = workingHours;
        this.businessAddress = businessAddress;
    }

    public long getBusinessid() {
        return businessid;
    }

    public void setBusinessid(long businessid) {
        this.businessid = businessid;
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

    public String getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public String getBusinessMobileNumber() {
        return businessMobileNumber;
    }

    public void setBusinessMobileNumber(String businessMobileNumber) {
        this.businessMobileNumber = businessMobileNumber;
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

    public int getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
    }

    public String getGenderCategory() {
        return genderCategory;
    }

    public void setGenderCategory(String genderCategory) {
        this.genderCategory = genderCategory;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getBusinessImages() {
        return businessImages;
    }

    public void setBusinessImages(String businessImages) {
        this.businessImages = businessImages;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<BusinessWorkingHours> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<BusinessWorkingHours> workingHours) {
        this.workingHours = workingHours;
    }

    public BusinessAddress getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(BusinessAddress businessAddress) {
        this.businessAddress = businessAddress;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessid=" + businessid +
                ", businessName='" + businessName + '\'' +
                ", businessDescription='" + businessDescription + '\'' +
                ", businessTitle='" + businessTitle + '\'' +
                ", businessMobileNumber='" + businessMobileNumber + '\'' +
                ", businessEmail='" + businessEmail + '\'' +
                ", cancellationAvailable=" + cancellationAvailable +
                ", slotDuration=" + slotDuration +
                ", genderCategory='" + genderCategory + '\'' +
                ", emailVerified=" + emailVerified +
                ", createdTime=" + createdTime +
                ", businessImages='" + businessImages + '\'' +
                ", categories=" + categories +
                ", userId=" + userId +
                ", workingHours=" + workingHours +
                ", businessAddress=" + businessAddress +
                '}';
    }
}

