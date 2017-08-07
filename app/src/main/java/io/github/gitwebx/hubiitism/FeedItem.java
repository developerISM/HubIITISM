package io.github.gitwebx.hubiitism;


public class FeedItem {
    String author, message, time, story, imgUrl, profilePic, id;

    FeedItem(String author, String profilePic, String message, String time, String story, String imgUrl, String id) {
        this.author = author;
        this.message = message;
        this.time = time;
        this.story = story;
        this.profilePic = profilePic;
        this.imgUrl = imgUrl;
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public String getStory() {
        return story;
    }

    public String getTime() {
        return time;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getId() {
        return id;
    }
}
