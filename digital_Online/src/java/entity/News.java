/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import utils.NewsFormat;

/**
 *
 * @author Nam
 */
public class News implements Serializable{
    private int id;
    private String title;
    private String writer;
    private String shortDescription;
    private String fullDescription;
    private Date publishedDate;
    private String image;
    
    public News() {
    }

    public News(int id, String title, String writer, String shortDescription, String fullDescription, Date publishedDate, String image) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.publishedDate = publishedDate;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

//    public Date getPublishedDate() {
//        return publishedDate;
//    }
    public String getPublishedDate() {
        return NewsFormat.formatDateToString(publishedDate);
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "News{" + "id=" + id + ", title=" + title + ", writer=" + writer + ", shortDescription=" + shortDescription + ", fullDescription=" + fullDescription + ", publishedDate=" + publishedDate + ", image=" + image + '}';
    }
    
    
}
