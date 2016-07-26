package yb.upc.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yb.upc.edu.cn.dto.YibanBasicUserInfo;
import yb.upc.edu.cn.model.Admin;
import yb.upc.edu.cn.repository.AdminRepository;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private HttpSession httpSession;

    public boolean isCommonAdmin(){
        if (httpSession.getAttribute("user") == null){
            return false;
        }
        YibanBasicUserInfo user = (YibanBasicUserInfo)httpSession.getAttribute("user");
        int Yibanid = user.visit_user.userid;
        Collection<Admin> commonAdmins = (Collection<Admin>) adminRepository.findByYibanid(Yibanid);
        if (commonAdmins.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

}
