package model;

import java.util.ArrayList;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class DeclensionRules {

    @SerializedName("lastname")
    @Expose
    private ArrayList<Lastname> lastname = new ArrayList<Lastname>();
    @SerializedName("firstname")
    @Expose
    private ArrayList<Firstname> firstname = new ArrayList<Firstname>();
    @SerializedName("middlename")
    @Expose
    private ArrayList<Middlename> middlename = new ArrayList<Middlename>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeclensionRules() {
    }

    /**
     * 
     * @param firstname
     * @param middlename
     * @param lastname
     */
    public DeclensionRules(ArrayList<Lastname> lastname, ArrayList<Firstname> firstname, ArrayList<Middlename> middlename) {
        super();
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
    }

    public ArrayList<Lastname> getLastname() {
        return lastname;
    }

    public ArrayList<Firstname> getFirstname() {
        return firstname;
    }

    public ArrayList<Middlename> getMiddlename() {
        return middlename;
    }
}