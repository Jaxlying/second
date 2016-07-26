package yb.upc.edu.cn.publish;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import yb.upc.edu.cn.SecondApplication;
import yb.upc.edu.cn.model.Publish;
import yb.upc.edu.cn.repository.PublishRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SecondApplication.class)
@WebAppConfiguration
/**
 * Created by Jaxlying on 2016/7/26.
 */
public class PublishTest {

    @Autowired
    PublishRepository publishRepository;

    @Test
    public void seedPublish(){
        for(int i = 0;i<10; i++){
            Publish publish = new Publish("http://img02.fs.yiban.cn/5831449/avatar/user/200","title" +i,"detail" +i,"qq" +i,"telephone","price" + i, "species" + i,"degree" +i,i,"hehe","http://img02.fs.yiban.cn/5831449/avatar/user/200");
            publishRepository.save(publish);
        }
    }
}
