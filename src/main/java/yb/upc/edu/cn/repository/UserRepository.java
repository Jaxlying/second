package yb.upc.edu.cn.repository;

import org.springframework.data.repository.CrudRepository;
import yb.upc.edu.cn.model.User;

/**
 * Created by Jaxlying on 2016/7/26.
 */
public interface UserRepository extends CrudRepository<User,Integer> {
    public User findByUserid(int userid);
    public User findTopByOrderByCreatetimeDesc();

}
