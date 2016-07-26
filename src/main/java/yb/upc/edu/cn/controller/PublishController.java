package yb.upc.edu.cn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yb.upc.edu.cn.dto.JsonMes;
import yb.upc.edu.cn.model.Publish;
import yb.upc.edu.cn.model.User;
import yb.upc.edu.cn.repository.PublishRepository;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@RestController
@RequestMapping("/second")
public class PublishController {

    private static final Logger log = LoggerFactory.getLogger(PublishController.class);

    public static final String ROOT = "imgdir";

    private final ResourceLoader resourceLoader;

    @Autowired
    public PublishController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Autowired
    private PublishRepository publishRepository;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/getallpublish")
    public Object getAllPublish(){
        return publishRepository.findByIsdelete(false);
    }
    @RequestMapping(value = "/publishfindone",method = RequestMethod.GET)
    public Object findOne(int id) {
        return publishRepository.findOne(id);
    }


    /**
     * 显示图片
     * @param filename
     * @return 图片
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {

        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 发布
     * @param file
     * @param redirectAttributes
     * @param title
     * @param detail
     * @param qq
     * @param telephone
     * @param price
     * @param species
     * @param degree
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/publish")
    public Object publish(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, String title, String detail, String qq,String telephone, String price, String species,String degree) {

        String imgname = new String();
        if (!file.isEmpty()) {
            try {
                imgname = System.currentTimeMillis() + file.getOriginalFilename();
                System.out.println(Paths.get(ROOT));
                Files.copy(file.getInputStream(), Paths.get(ROOT,imgname));
            } catch (IOException |RuntimeException e) {
                redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
        }
        System.out.println(imgname);
        User user = (User) httpSession.getAttribute("ouruser");
        System.out.println(user.getId());
        Publish publish = new Publish("http://localhost:8080/second/" + imgname,title,detail,qq,telephone,price,species,degree,user.getUserid(),user.getUsername(),user.getYbhead());
        publishRepository.save(publish);
        return new JsonMes(1,"发布成功");
    }


    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public Object edit(@RequestParam("file") MultipartFile file,
                          RedirectAttributes redirectAttributes, String title, String detail, String qq,String telephone, String price, String species,String degree,int publishiid,int isdeal) {

        String imgname = new String();
        if (!file.isEmpty()) {
            try {
                imgname = System.currentTimeMillis() + file.getOriginalFilename();
                System.out.println(Paths.get(ROOT));
                Files.copy(file.getInputStream(), Paths.get(ROOT,imgname));
            } catch (IOException |RuntimeException e) {
                redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
        }
        System.out.println(imgname);
        User user = (User) httpSession.getAttribute("ouruser");
        System.out.println(user.getId());
        Publish publish = publishRepository.findOne(publishiid);
        publish.updata("http://localhost:8080/second/" + imgname,title,detail,qq,telephone,price,species,degree,isdeal);
        return new JsonMes(1,"发布成功");
    }

}
