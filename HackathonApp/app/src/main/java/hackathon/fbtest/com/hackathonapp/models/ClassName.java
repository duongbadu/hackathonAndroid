package hackathon.fbtest.com.hackathonapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class ClassName {
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;

    public ClassName(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
