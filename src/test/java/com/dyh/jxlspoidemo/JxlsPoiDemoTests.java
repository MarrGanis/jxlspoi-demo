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
import java.util.Iterator;
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

    @Test
    public void test02(){
        List<UserModel> list = new ArrayList<>();

        List<UserModel> list1 = new ArrayList<>();
        list1.add(new UserModel(2,"100",null,null));

        List<UserModel> list2 = new ArrayList<>();
        list2.add(new UserModel(2,null,"100",null));
        list2.add(new UserModel(5,"","200",null));


        // 始终是 1 2 5 , 外层循环可以固定
        Integer[] corpType = new Integer[]{1,2,5};

        // 先算交集部分 需要add，余下的部分
        for (Integer i : corpType) {
            // 若两个全空，list也为空；
            list.addAll(list1!=null && list1.size()>0 ? list1 : list2);
            // 两个list全空
            if(list==null || list.size()==0){
                list.add(new UserModel(i,null,null,null));
            }
            // list1不空
            else if(list1!=null && list1.size()>0 && (list2==null || list2.size()==0)){
                for (UserModel u1 : list1) {
                    if(!u1.getId().equals(i)){
                        list.add(new UserModel(i,null,null,null));
                    }
                }
            }
            // list2不空
            else if(list2!=null && list2.size()>0 && (list1==null || list1.size()==0)){
                for (UserModel u2 : list2) {
                    if(!u2.getId().equals(i)){
                        list.add(new UserModel(i,null,null,null));
                    }
                }
            }
            // 都不空 (list已经加入了list1，对于list2共同的部分重设值，对于list2没有的部分重新添加)
            else{
                // 找到共同的部分
                for (UserModel u : list1) {
                    for (UserModel u2 : list2) {
                        if (u.getId().equals(u2.getId())) {
                            u.setFirstName(u2.getFirstName());
                        }
                    }
                }
                // 移除l2中与l1重复的元素
                Iterator<UserModel> iter = list2.iterator();
                while (iter.hasNext()){
                    UserModel it = iter.next();
                    if (list.contains(it.getId())) {
                        iter.remove();
                    }
                }

                // 添加list2没有的部分
                if(list2!=null&&list2.size()>0){
                    list.addAll(list2);
                }
                // 添加i值
                Iterator<UserModel> iter2 = list.iterator();
                while (iter2.hasNext()){
                    if (!list.contains(i)) {
                        list.add(new UserModel(i,null,null,null));
                    }
                }
            }
        }

        // 输出list
        list.toArray();
        System.out.println(list.toString());
    }


}
