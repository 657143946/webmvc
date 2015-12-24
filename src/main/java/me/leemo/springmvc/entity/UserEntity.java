package me.leemo.springmvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Leemo on 15-12-24
 */
@Entity
@Table(name="user")
public class UserEntity {

    /**
     * 主键，id，uuid自动生成
     */
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    private int id;

    /**
     * 创建时间，默认当前时间
     */
    @Column(name = "create_time", nullable = true, updatable = false)
    private Date createTime=new Date(System.currentTimeMillis());


    /**
     * 用户名
     */
    @Column(name = "user", unique = true, nullable = false)
    private String user;

    /**
     * 密码
     */
    @Column(name = "password", nullable = false)
    private String password;
}
