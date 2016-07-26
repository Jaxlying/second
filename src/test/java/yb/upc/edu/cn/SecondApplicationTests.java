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

	@Autowired
	private YibanOAuth yibanOAuth;

	@Autowired
	private HttpSession httpSession;

	@Test
	public void contextLoads() {
	}

	@Autowired
	SecondConfig secondConfig;

	@Test
	public void getAcc() {
		String vq = "26558473ae085bde58ad05108f1c1a9d1351ef7ce268a58a576446ee165578ac68c2397751ce96a619db41880502950ddd699f239a941950be1fea2b017421a5da62a014c6e5ae82d3788494d084b1b5637e37da506f9d7f496bbbce6f5cdd10237b5b4f028ec9cd5bfa4576c1e4d3cfdc936d320d5f7e3bfc99d40d4179be4cef5b441ae046e30a28b7ed550ce3a2658858ab1008a62cf272402bcaad64649f2a7e6064ae370d0e224467ade7e42a29af7c5963e3cc1f3501f3b373452d9daf909f3c081caf56a47cd660eba722487f011c0e32cc5ec515bd737f5a1ff647a7";
		yibanOAuth.dealYibanOauth(vq,secondConfig.appid,secondConfig.appkey);
		YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo) httpSession.getAttribute("user");
		System.out.println(yibanBasicUserInfo.visit_oauth.access_token);
	}

	@Autowired
	YbInterfaceService ybInterfaceService;
	@Test
	public void ybuserinfo() throws IOException {
		ybInterfaceService.getYbUserInfo();
	}
}
