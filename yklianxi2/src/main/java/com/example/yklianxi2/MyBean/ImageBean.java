package com.example.yklianxi2.MyBean;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class ImageBean {
    private String imageUrl;

    @Override
    public String toString() {
        return "ImageBean{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImageBean(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
