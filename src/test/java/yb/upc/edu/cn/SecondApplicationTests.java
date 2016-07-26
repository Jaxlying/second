package yb.upc.edu.cn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import yb.upc.edu.cn.auth.YibanOAuth;
import yb.upc.edu.cn.config.SecondConfig;
import yb.upc.edu.cn.dto.YibanBasicUserInfo;
import yb.upc.edu.cn.service.YbInterfaceService;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SecondApplication.class)
@WebAppConfiguration
public class SecondApplicationTests {

	@Test
	public void contextLoads() {
	}

}
