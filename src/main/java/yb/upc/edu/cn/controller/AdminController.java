package yb.upc.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yb.upc.edu.cn.dto.JsonMes;
import yb.upc.edu.cn.model.Publish;
import yb.upc.edu.cn.repository.PublishRepository;
import yb.upc.edu.cn.service.AdminService;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@RestController
@RequestMapping("/second/admin")
public class AdminController {

    @Autowired
    private PublishRepository publishRepository;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/findall")
    public Object findAll(){
        if (adminService.isCommonAdmin() == false) return new JsonMes(-1, "您没有权限操作");
        return publishRepository.findByIsdelete(false);
    }

    @RequestMapping("/delete")
    public Object delete(int id){
        if (adminService.isCommonAdmin() == false) return new JsonMes(-1, "您没有权限操作");
        Publish publish = publishRepository.findOne(id);
        publish.delete();
        publishRepository.save(publish);
        return new JsonMes(1,"删除成功");

    }
}
