package yb.upc.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yb.upc.edu.cn.dto.YibanBasicUserInfo;
import yb.upc.edu.cn.dto.YibanUserInfo;
import yb.upc.edu.cn.model.Admin;
import yb.upc.edu.cn.model.User;
import yb.upc.edu.cn.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private YbInterfaceService ybInterfaceService;

    public boolean isOurUser(){
        YibanBasicUserInfo user = (YibanBasicUserInfo)httpSession.getAttribute("user");
        int Yibanid = user.visit_user.userid;
        User users = userRepository.findByUserid(Yibanid);
        if (users==null){
            return false;
        }else {
            return true;
        }
    }

    public Object registe() throws IOException {
        YibanUserInfo yibanUserInfo = ybInterfaceService.getYbUserInfo();
        User user = new User(yibanUserInfo.info.yb_userid,yibanUserInfo.info.yb_username,yibanUserInfo.info.yb_usernick,yibanUserInfo.info.yb_sex,yibanUserInfo.info.yb_userhead);
        userRepository.save(user);
        User ouruser = userRepository.findTopByOrderByCreatetimeDesc();
        httpSession.setAttribute("ouruser",ouruser);
        return ouruser;
    }
}
