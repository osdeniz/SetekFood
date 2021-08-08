package com.Food.model;

import java.util.ArrayList;
import java.util.List;


public class Food {

    private Integer id;

    private String title;

    private String description;

    private String createDate;

    private String lastModifiadDate;

    private List<String> list = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastModifiadDate() {
        return lastModifiadDate;
    }

    public void setLastModifiadDate(String lastModifiadDate) {
        this.lastModifiadDate = lastModifiadDate;
    }
}
