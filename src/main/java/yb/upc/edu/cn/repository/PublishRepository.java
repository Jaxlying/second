package yb.upc.edu.cn.repository;

import org.springframework.data.repository.CrudRepository;
import yb.upc.edu.cn.model.Publish;

/**
 * Created by Jaxlying on 2016/7/26.
 */
public interface PublishRepository extends CrudRepository<Publish,Integer> {
    public Iterable<Publish> findByIsdelete(boolean isdelete);
    public Iterable<Publish> findByYbidAndIsdelete(int ybid,boolean isdelete);


}
