# 工程简介

jxls-poi开源EXCEL报表生成工具与使用

##  延伸阅读

记录下使用demo
双循环的方法，当表格中存在多变量时，即 横纵同时变化！

- 详细模板见：
resource/jxls/t2.xlsx

- 实现方法：
在ExcelUitls里定义provideData方法，传入横、纵变量；
在实体类中定义一个resMap其中：key值= 横+纵 value值=单元格需要填充的数值

- 待解决todo：
单元格内重复值的问题。

- 模板如下：
![image](https://user-images.githubusercontent.com/35026335/183253873-9a7d7a91-2322-457f-b90e-4a38e1458bee.png)



