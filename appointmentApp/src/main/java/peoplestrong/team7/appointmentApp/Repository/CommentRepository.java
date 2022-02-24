package peoplestrong.team7.appointmentApp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peoplestrong.team7.appointmentApp.Models.Comments;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Long> {
    @Query(value = "select count(*) from Comments c where c.userid=userId",nativeQuery = true)
    public int getTotalReviews(@Param("userId") Long userId);

    @Query(value = "select * from comments",nativeQuery = true)
    List<Comments> findAllratings();

    //@Query(value = "select count(*) from Comments c where c.userid=userId and c.ratings>3",nativeQuery = true)
    //public int getFavourites(@Param("userId") Long userId);
}
