package com.three.zhongdian.author.entity;

import lombok.Data;

/**
 * Created by 任梦杭 on 2017/08/10.
 */
@Data
public class Author {

    private Integer aid;
    private String authorNname;
    private String newPassword;
    private String repeatPassword;
    private String email;
    private String QQ;
    private String realName;
    private String cardtype;
    private String cardId;
    private String tel_pre;
    private String province;
    private String address;
    private Integer productionCount;//作品数
    private Integer WordsCount;//累计字数
    private Integer writeDays;//创作天数
    private String grade;//作者等级
    private String authorintroduce;//作者介绍
    private String avatar;//作者头像
    private String sex;//作者性别
    private Integer attention;//关注
    private Integer fans;//粉丝
    private String designation;//称号
    private Integer uid;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAuthorNname() {
        return authorNname;
    }

    public void setAuthorNname(String authorNname) {
        this.authorNname = authorNname;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTel_pre() {
        return tel_pre;
    }

    public void setTel_pre(String tel_pre) {
        this.tel_pre = tel_pre;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getProductionCount() {
        return productionCount;
    }

    public void setProductionCount(Integer productionCount) {
        this.productionCount = productionCount;
    }

    public Integer getWordsCount() {
        return WordsCount;
    }

    public void setWordsCount(Integer wordsCount) {
        WordsCount = wordsCount;
    }

    public Integer getWriteDays() {
        return writeDays;
    }

    public void setWriteDays(Integer writeDays) {
        this.writeDays = writeDays;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAuthorintroduce() {
        return authorintroduce;
    }

    public void setAuthorintroduce(String authorintroduce) {
        this.authorintroduce = authorintroduce;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
