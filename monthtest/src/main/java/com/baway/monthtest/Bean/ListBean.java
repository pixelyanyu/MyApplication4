package com.baway.monthtest.Bean;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:bean类
 */
public class ListBean {
    private String imageUrl;
    private String name;

    @Override
    public String toString() {
        return "ListBean{" +
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

    public ListBean(String imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }
}
