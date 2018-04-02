package com.miao.PoJo;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
    private Integer id;

    private String appid;

    private String secrt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getSecrt() {
        return secrt;
    }

    public void setSecrt(String secrt) {
        this.secrt = secrt == null ? null : secrt.trim();
    }
}