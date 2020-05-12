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
public class Info {
    private String mainPic;
    private String mainDescription;
    private String aboutMe;

    public Info() {
    }

    public Info(String mainPic, String mainDescription, String aboutMe) {
        this.mainPic = mainPic;
        this.mainDescription = mainDescription;
        this.aboutMe = aboutMe;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public String toString() {
        return "Info{" + "mainPic=" + mainPic + ", mainDescription=" + mainDescription + ", aboutMe=" + aboutMe + '}';
    }
    
}
