package com.example.corndetector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {
    @Id
    private int id;

    private Date createTime;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
}
