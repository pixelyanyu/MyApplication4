package com.example.yklianxi2.MyBean;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class LvBean {
    private String imageUrl;
    private String name;

    @Override
    public String toString() {
        return "LvBean{" +
                "imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LvBean(String imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }
}
