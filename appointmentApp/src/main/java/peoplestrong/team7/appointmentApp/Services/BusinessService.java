package peoplestrong.team7.appointmentApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peoplestrong.team7.appointmentApp.Models.Business;
import peoplestrong.team7.appointmentApp.Models.BusinessWorkingHours;
import peoplestrong.team7.appointmentApp.Models.Categories;
import peoplestrong.team7.appointmentApp.Models.User;
import peoplestrong.team7.appointmentApp.Repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class BusinessService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private CategoryRepository categoriesRepository;

    @Autowired
    private BusinessWorkingHoursRepository businessWorkingHoursRepository;

    @Autowired
    private BusinessAddressRepository businessAddressRepository;


    public List<Business> getBusineses(){
        List<Business> businesses = new ArrayList<>();
        businessRepository.findAll().forEach(businesses::add);
        return businesses;
    }

    public List<Business> getUserBusinesses(long userid){
        return businessRepository.findByUsersUserid(userid);
    }

    public String registerBusiness(Long userid, Business business) {
        // Get the user details
        try {
            User users = userRepository.findById(userid).get();
            System.out.println(users);

            System.out.println(business.getCategories());
            long id = business.getCategories().getCategoryId();
            System.out.println(id);

            Categories categories = categoriesRepository.findById(id).get();
            System.out.println(categories);

            business.setUsers(users);
            business.setCreatedTime(LocalDateTime.now());
            business.setBusinessAddress(business.getBusinessAddress());
            business.setCategories(categories);
            businessAddressRepository.save(business.getBusinessAddress());
            businessRepository.save(business);
            List<BusinessWorkingHours> l1 = business.getWorkingHours();
            for (BusinessWorkingHours businessWorkingHours: l1) {
                businessWorkingHours.setBusinessHours(business);
                businessWorkingHoursRepository.save(businessWorkingHours);
            }
        }
        catch (Exception e){
            return "Business Not registered";
        }
        return "business registered";
    }
}
