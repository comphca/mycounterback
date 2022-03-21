package com.comphca.mycounterback.pojo;

import lombok.AllArgsConstructor;


public class Stock {
    private String code;

    private String name;

    private String abbrname;

    private String status;

    public Stock(String code, String name, String abbrname, String status) {
        this.code = code;
        this.name = name;
        this.abbrname = abbrname;
        this.status = status;
    }

    public Stock(String code, String name, String abbrname){
        this.code = code;
        this.name = name;
        this.abbrname = abbrname;
    }

    public Stock() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAbbrname() {
        return abbrname;
    }

    public void setAbbrname(String abbrname) {
        this.abbrname = abbrname == null ? null : abbrname.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}