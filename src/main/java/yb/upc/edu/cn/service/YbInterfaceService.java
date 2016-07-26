package yb.upc.edu.cn.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yb.upc.edu.cn.dto.YibanBasicUserInfo;
import yb.upc.edu.cn.dto.YibanUserInfo;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@Service
public class YbInterfaceService {

    @Autowired
    private HttpSession httpSession;

    public YibanUserInfo getYbUserInfo() throws IOException {
        String access_token = ((YibanBasicUserInfo)httpSession.getAttribute("user")).visit_oauth.access_token;
        String url = "https://openapi.yiban.cn/user/me?access_token=";
        String charset = "UTF-8";
        URLConnection connection = new URL(url + access_token).openConnection();
        connection.setRequestProperty("Accept-Charset",charset);
        InputStream response = connection.getInputStream();
        StringBuilder sb=new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(response));
        String read;
        while((read=br.readLine()) != null) {
            sb.append(read);
        }
        br.close();
        Gson gson = new Gson();
        YibanUserInfo yibanUserInfo = gson.fromJson(sb.toString(),YibanUserInfo.class);
        httpSession.setAttribute("ybuser",yibanUserInfo);
        System.out.println(sb.toString());
        return  yibanUserInfo;
    }
}
