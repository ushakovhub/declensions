package model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Mods {

    @SerializedName("genitive")
    @Expose
    private String genitive;
    @SerializedName("dative")
    @Expose
    private String dative;
    @SerializedName("accusative")
    @Expose
    private String accusative;
    @SerializedName("instrumental")
    @Expose
    private String instrumental;
    @SerializedName("prepositional")
    @Expose
    private String prepositional;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Mods() {
    }

    /**
     * 
     * @param dative
     * @param accusative
     * @param instrumental
     * @param genitive
     * @param prepositional
     */
    public Mods(String genitive, String dative, String accusative, String instrumental, String prepositional) {
        super();
        this.genitive = genitive;
        this.dative = dative;
        this.accusative = accusative;
        this.instrumental = instrumental;
        this.prepositional = prepositional;
    }

    public String getCase(String caseName){
        if(caseName == "genitive"){
            return genitive;
        }
        if(caseName == "dative"){
            return dative;
        }
        if(caseName == "accusative"){
            return accusative;
        }
        if(caseName == "instrumental"){
            return instrumental;
        }
        if(caseName == "prepositional"){
            return prepositional;
        }
        return "";
    }
}