package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Relation {
    @SerializedName("relationId")
    @Expose
    private Integer relationId;
    @SerializedName("relationName")
    @Expose
    private String relationName;

    /**
     * No args constructor for use in serialization
     */
    public Relation() {
    }

    /**
     * @param relationId
     * @param relationName
     */
    public Relation(Integer relationId, String relationName) {
        super();
        this.relationId = relationId;
        this.relationName = relationName;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    @Override
    public String toString() {
        return relationName;
    }
}
