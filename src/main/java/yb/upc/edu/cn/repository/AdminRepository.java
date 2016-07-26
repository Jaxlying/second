package yb.upc.edu.cn.repository;

import org.springframework.data.repository.CrudRepository;
import yb.upc.edu.cn.model.Admin;

/**
 * Created by Jaxlying on 2016/7/26.
 */
public interface AdminRepository extends CrudRepository<Admin,Integer>{
    public Iterable<Admin> findByYibanid(int Yibanid);
}
