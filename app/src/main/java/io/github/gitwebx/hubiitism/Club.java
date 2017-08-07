package io.github.gitwebx.hubiitism;

/**
 * Created by Manan on 7/1/2017.
 */

public class Club {
    private String name, category, fbID;
    private boolean isSelected;

    Club(String name, String category, String fbID) {
        this.name = name;
        this.category = category;
        this.fbID = fbID;
    }

    public String getClubName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getFbID() {
        return fbID;
    }
}
