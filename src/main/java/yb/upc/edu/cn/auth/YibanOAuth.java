package yb.upc.edu.cn.auth;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yb.upc.edu.cn.dto.JsonMes;
import yb.upc.edu.cn.dto.YibanBasicUserInfo;
import yb.upc.edu.cn.util.MCrypt;

import javax.servlet.http.HttpSession;

/**
 * Created by skyADMIN on 16/7/7.
 */
@Service
public class YibanOAuth {

    @Autowired
    private HttpSession httpSession;

    public Object dealYibanOauth(String verify_request, String appid, String appkey) {
        MCrypt mCrypt = new MCrypt(appid, appkey);
        String res = null;
        try {
            res = new String(mCrypt.decrypt(verify_request));
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonMes(0, "error parse");
        }
        Gson gson = new Gson();
        try {
            YibanBasicUserInfo yibanBasicUserInfo = gson.fromJson(res, YibanBasicUserInfo.class);
            httpSession.setAttribute("user", yibanBasicUserInfo);
            System.out.println("认证成功");
            return yibanBasicUserInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonMes(0, "error parse");
        }
    }

}
