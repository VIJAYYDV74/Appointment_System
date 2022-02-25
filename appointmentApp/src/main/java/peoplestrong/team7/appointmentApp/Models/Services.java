package peoplestrong.team7.appointmentApp.Models;


import javax.persistence.*;

@Entity
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceid;

    @Column(name = "servicename")
    private String serviceName;

    @Column(name = "servicedesc")
    private String serviceDesc;

    @Column(name = "serviceprice")
    private int servicePrice;

    //@ManyToOne
    @Column(name = "businessid")
    private Long businessId;

    public Services() {
    }

    public Services(long serviceid, String serviceName, String serviceDesc, int servicePrice, Long businessId) {
        this.serviceid = serviceid;
        this.serviceName = serviceName;
        this.serviceDesc = serviceDesc;
        this.servicePrice = servicePrice;
        this.businessId = businessId;
    }

    public long getServiceid() {
        return serviceid;
    }

    public void setServiceid(long serviceid) {
        this.serviceid = serviceid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        return "Services{" +
                "serviceid=" + serviceid +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDesc='" + serviceDesc + '\'' +
                ", servicePrice=" + servicePrice +
                ", businessId=" + businessId +
                '}';
    }
}
