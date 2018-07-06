package com.chaoliu1995.demo.entity;

import com.chaoliu1995.demo.util.Consts;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author: ChaoLiu
 * @Description:
 * @Date: 2018/4/25 13:45
 */
@Data
@NoArgsConstructor
public class User implements Serializable{

    private static final long serialVersionUID = Consts.SERIAL_VERSION_UID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
}
