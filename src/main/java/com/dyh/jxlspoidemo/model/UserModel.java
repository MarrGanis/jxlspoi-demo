package com.dyh.jxlspoidemo.model;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class UserModel {
    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    private String remark;

    private Date date;

    private String link;
}
