package yb.upc.edu.cn.repository;

import org.springframework.data.repository.CrudRepository;
import yb.upc.edu.cn.model.Review;

/**
 * Created by Jaxlying on 2016/7/26.
 */
public interface ReviewRepository extends CrudRepository<Review,Integer> {
    public Iterable<Review> findByPublishid(int publishid);
}
