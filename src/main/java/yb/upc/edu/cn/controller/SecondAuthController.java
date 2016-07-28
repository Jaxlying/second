package yb.upc.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yb.upc.edu.cn.auth.YibanOAuth;
import yb.upc.edu.cn.config.SecondConfig;
import yb.upc.edu.cn.dto.YibanBasicUserInfo;
import yb.upc.edu.cn.repository.UserRepository;
import yb.upc.edu.cn.service.AdminService;
import yb.upc.edu.cn.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@RestController
@RequestMapping("/second")
public class SecondAuthController {

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private SecondConfig secondConfig;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/auth")
    public void doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, secondConfig.appid, secondConfig.appkey);
            int id =0;
            if(httpSession.getAttribute("user") != null) {
                id = ((YibanBasicUserInfo) httpSession.getAttribute("user")).visit_user.userid;
            }
            if (userService.isOurUser() == true) {
                httpSession.setAttribute("ouruser",userRepository.findByUserid(id));
            } else {
               userService.registe();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
