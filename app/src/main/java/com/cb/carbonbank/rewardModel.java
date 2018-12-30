package com.cb.carbonbank;

public class rewardModel {
    private int image;
    private String title;
    private String desc;

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

    public rewardModel(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;

    }
}
