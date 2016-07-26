package yb.upc.edu.cn.model;

/**
 * Created by Jaxlying on 2016/7/26.
 */

import javax.persistence.*;


@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanid;

    public Admin(int yibanid) {
        this.yibanid = yibanid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYibanid() {
        return yibanid;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }
}
