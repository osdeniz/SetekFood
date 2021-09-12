package com.Food.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "FIMAGE_TABLE")
public class ImageEntity {


    public ImageEntity(){

    }

    public ImageEntity(String fileName,String fileType,byte[] imageByte){
        this.fileName = fileName;
        this.fileType = fileType;
        this.imageByte = imageByte;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_TYPE")
    private String fileType;

    @Column(length = 1000)
    private byte[] imageByte;

    @OneToOne(mappedBy = "image")
    @JsonIgnore
    private FoodEntity food;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getImageByte() {
        return imageByte;
    }

    public void setImageByte(byte[] imageByte) {
        this.imageByte = imageByte;
    }

    public FoodEntity getFood() {
        return food;
    }

    public void setFood(FoodEntity food) {
        this.food = food;
    }
}
