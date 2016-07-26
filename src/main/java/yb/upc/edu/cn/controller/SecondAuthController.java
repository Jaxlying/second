package yb.upc.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yb.upc.edu.cn.auth.YibanOAuth;
import yb.upc.edu.cn.config.SecondConfig;
import yb.upc.edu.cn.service.AdminService;

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


    @RequestMapping("/auth")
    public void doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, secondConfig.appid, secondConfig.appkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
