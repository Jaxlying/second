package yb.upc.edu.cn.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@Entity
@Table(name = "second_review")
@JsonIgnoreProperties(value = {"isdelete", "createtime", "updatatime"})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int publishid;
    private int reviewid;
    private String detail;

    private String createtime;
    private String updatatime;
    private boolean isdelete = false;

    public Review(){}

    public Review(int publishid, int reviewid, String detail) {
        this.publishid = publishid;
        this.reviewid = reviewid;
        this.detail = detail;
        this.createtime = new Date().toString();
        this.updatatime = new Date().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublishid() {
        return publishid;
    }

    public void setPublishid(int publishid) {
        this.publishid = publishid;
    }

    public int getReviewid() {
        return reviewid;
    }

    public void setReviewid(int reviewid) {
        this.reviewid = reviewid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatatime() {
        return updatatime;
    }

    public void setUpdatatime(String updatatime) {
        this.updatatime = updatatime;
    }

    public boolean isdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }
}
