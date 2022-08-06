package com.dyh.jxlspoidemo;

import com.dyh.jxlspoidemo.jxls.service.ExcelService;
import com.dyh.jxlspoidemo.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JxlsPoiDemoTests {

    @Autowired
    private ExcelService excelService;

    @Test
    public void contextLoads02() {
        Map<String, Object> outerMap = new HashMap();

        // 纵向循环
        List<UserModel> list = new ArrayList<>();
        list.add(new UserModel(1, "ChineseName","莉","丁"));
//
        list.add(new UserModel(2, "EnglishName","Jane","Martin"));
//
        list.add(new UserModel(3, "ChineseName","建国","川"));
//
        list.add(new UserModel(4, "ChineseName","建国","川"));

        list.add(new UserModel(7, "EnglishName","John","Martin"));
        list.add(new UserModel( 7, "ChineseName","荣耀","王"));

        // 横向循环
        List<String> nameTypes = new ArrayList<>();
        nameTypes.add("EnglishName");
        nameTypes.add("ChineseName");

        Map<String,String> tempMap = new HashMap<>();

        // 把list中的数据灌入到tempMap中
        // key1: 纵    key2: 横   key3： 横的条目
        for (UserModel model : list) {
            tempMap.put(model.getId()+model.getNameType()+"firstName",model.getFirstName());
            tempMap.put(model.getId()+model.getNameType()+"lastName",model.getLastName());
            //todo：去重的功能如何做？
            model.setResMap(tempMap);
        }

        outerMap.put("list", list);
        outerMap.put("nameTypes",nameTypes);

        excelService.getExcel("t2.xlsx", outerMap, new File("D:\\test06.xlsx"));
    }


}
