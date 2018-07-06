package com.chaoliu1995.demo.entity;

import com.chaoliu1995.demo.util.Consts;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String name;
    private String password;
}
