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
public class Gallery {

    private int id;
    private String entryName;
    private String description;
    private String desPicture;

    public Gallery() {
    }

    public Gallery(int id, String entryName, String description, String desPicture) {
        this.id = id;
        this.entryName = entryName;
        this.description = description;
        this.desPicture = desPicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesPicture() {
        return desPicture;
    }

    public void setDesPicture(String desPicture) {
        this.desPicture = desPicture;
    }

    @Override
    public String toString() {
        return "Gallery{" + "id=" + id + ", entryName=" + entryName + ", description=" + description + ", desPicture=" + desPicture + '}';
    }
}
