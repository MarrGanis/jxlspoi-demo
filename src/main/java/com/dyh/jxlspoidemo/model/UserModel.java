package com.dyh.jxlspoidemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    private Integer id;

    private String nameType;

    private String firstName;

    private String lastName;

    private Map<String,String> resMap;

    public UserModel(Integer id, String nameType, String firstName, String lastName) {
        this.id = id;
        this.nameType = nameType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
