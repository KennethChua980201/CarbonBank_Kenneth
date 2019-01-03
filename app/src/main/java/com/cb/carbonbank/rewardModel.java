package com.cb.carbonbank;

public class rewardModel {
    private int image;
    private String title;
    private String desc;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public rewardModel(int image, String title, String desc, String type) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.type = type;
    }

    public rewardModel() {

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
