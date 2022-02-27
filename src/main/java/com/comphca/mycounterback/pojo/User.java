package com.comphca.mycounterback.pojo;

public class User {
    private Long uid;

    private String password;

    private String status;

    private String createdate;

    private String createtime;

    private Integer modifydate;

    private Integer modifytime;

    public User(Long uid, String password, String status, String createdate, String createtime, Integer modifydate, Integer modifytime) {
        this.uid = uid;
        this.password = password;
        this.status = status;
        this.createdate = createdate;
        this.createtime = createtime;
        this.modifydate = modifydate;
        this.modifytime = modifytime;
    }

    public User() {
        super();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public Integer getModifydate() {
        return modifydate;
    }

    public void setModifydate(Integer modifydate) {
        this.modifydate = modifydate;
    }

    public Integer getModifytime() {
        return modifytime;
    }

    public void setModifytime(Integer modifytime) {
        this.modifytime = modifytime;
    }
}