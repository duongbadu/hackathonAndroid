package hackathon.fbtest.com.hackathonapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mr.icetea on 7/31/16.
 */
public class User {

    private static User instance;

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("gender")
    private String gender;
    @SerializedName("picture")
    private PictureEntity picture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PictureEntity getPicture() {
        return picture;
    }

    public void setPicture(PictureEntity picture) {
        this.picture = picture;
    }

    public static class PictureEntity {

        @SerializedName("data")
        private DataEntity data;

        public DataEntity getData() {
            return data;
        }

        public void setData(DataEntity data) {
            this.data = data;
        }

        public static class DataEntity {
            @SerializedName("height")
            private int height;
            @SerializedName("is_silhouette")
            private boolean isSilhouette;
            @SerializedName("url")
            private String url;
            @SerializedName("width")
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public boolean isIsSilhouette() {
                return isSilhouette;
            }

            public void setIsSilhouette(boolean isSilhouette) {
                this.isSilhouette = isSilhouette;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }

    public static void setInstance(User instance) {
        User.instance = instance;
    }

    public static User getInstance() {
        return instance;
    }
}
