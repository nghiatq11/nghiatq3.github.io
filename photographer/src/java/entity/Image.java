/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author quang
 */
public class Image {
    private int id;
    private int idGallery;
    private String path;

    public Image() {
    }

    public Image(int id, int idGallery, String path) {
        this.id = id;
        this.idGallery = idGallery;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGallery() {
        return idGallery;
    }

    public void setIdGallery(int idGallery) {
        this.idGallery = idGallery;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Image{" + "id=" + id + ", idGallery=" + idGallery + ", path=" + path + '}';
    }
    
}
