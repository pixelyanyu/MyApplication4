package com.example.lianxi0510.view;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public interface View {
    //注册
    void regist(String user,String pass);
    //登录
    void login(String user,String pass);
    //密码正确
    void passtrue(String t);
    //密码错误
    void passfalse(Object o);
}
