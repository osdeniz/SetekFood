package com.Food.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FOOD_TABLE")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="Id" )
    private Long id;

    @Column(name ="TITLE" )
    private String title;

    @Column(name ="DESCRIPTION" )
    private String description;

    @Column(name ="CREATEDATE" )
    private Date createDate;

    @Lob
    @Column(name ="FOODDETAILS" )
    private String foodDeails;



    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private UserEntity user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id",referencedColumnName = "id")
    private ImageEntity image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFoodDeails() {
        return foodDeails;
    }

    public void setFoodDeails(String foodDeails) {
        this.foodDeails = foodDeails;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }



    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }
}
