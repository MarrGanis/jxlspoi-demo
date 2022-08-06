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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JxlsPoiDemoTests {

    @Autowired
    private ExcelService excelService;

    @Test
    public void contextLoads() {
        Map<String, Object> params = new HashMap();
        List<UserModel> list = new ArrayList<>();
        list.add(new UserModel(1, "test01", "男", 25, "tttttttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(2, "test02", "男", 20, "tttttttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(3, "test04", "女", 25, "ttttddddasdadatttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(4, "test08", "男", 20, "ttttttdasdatttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(5, "test021", "女", 25, "ttttdatttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(7, "test041", "男", 25, "ttdadatttttttt",new Date(),"htpp://wwww.baidu.com"));

        params.put("list", list);
        excelService.getExcel("t1.xlsx", params, new File("D:\\test05.xlsx"));
    }


}
