package model;

import java.util.ArrayList;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Middlename {

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("ending")
    @Expose
    private ArrayList<String> ending = new ArrayList<String>();
    @SerializedName("mods")
    @Expose
    private Mods mods;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Middlename() {
    }

    /**
     * 
     * @param ending
     * @param mods
     * @param gender
     */
    public Middlename(String gender, ArrayList<String> ending, Mods mods) {
        super();
        this.gender = gender;
        this.ending = ending;
        this.mods = mods;
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<String> getEnding() {
        return ending;
    }

    public Mods getMods() {
        return mods;
    }
}