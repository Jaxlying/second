package yb.upc.edu.cn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@Component
public class SecondConfig {

    @Value("${yibanoauth.second.APPID}")
    public String appid;

    @Value("${yibanoauth.second.APPkey}")
    public String appkey;

}
