package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.manappuram.twowheeler.BuildConfig;
public class ScoreSegment {
    @SerializedName("length")
    //@SerializedName("Length")//Uppercase for uat .check and uncomment all
    @Expose
    private String length;
    @SerializedName("scoreName")
    //@SerializedName("ScoreName")
    @Expose
    private String scoreName;
    @SerializedName("scoreCardName")
    //@SerializedName("ScoreCardName")
    @Expose
    private String scoreCardName;
    @SerializedName("scoreCardVersion")
    //@SerializedName("ScoreCardVersion")
    @Expose
    private String scoreCardVersion;
    @SerializedName("scoreDate")
   // @SerializedName("ScoreDate")
    @Expose
    private String scoreDate;
    @SerializedName("score")
    //@SerializedName("Score")
    @Expose
    private String score;
    @SerializedName("ReasonCode1FieldLength")
    @Expose
    private String reasonCode1FieldLength;
    @SerializedName("ReasonCode1")
    @Expose
    private String reasonCode1;
    @SerializedName("ReasonCode2FieldLength")
    @Expose
    private String reasonCode2FieldLength;
    @SerializedName("ReasonCode2")
    @Expose
    private String reasonCode2;
    @SerializedName("ReasonCode3FieldLength")
    @Expose
    private String reasonCode3FieldLength;
    @SerializedName("ReasonCode3")
    @Expose
    private String reasonCode3;

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    public String getScoreCardName() {
        return scoreCardName;
    }

    public void setScoreCardName(String scoreCardName) {
        this.scoreCardName = scoreCardName;
    }

    public String getScoreCardVersion() {
        return scoreCardVersion;
    }

    public void setScoreCardVersion(String scoreCardVersion) {
        this.scoreCardVersion = scoreCardVersion;
    }

    public String getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(String scoreDate) {
        this.scoreDate = scoreDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getReasonCode1FieldLength() {
        return reasonCode1FieldLength;
    }

    public void setReasonCode1FieldLength(String reasonCode1FieldLength) {
        this.reasonCode1FieldLength = reasonCode1FieldLength;
    }

    public String getReasonCode1() {
        return reasonCode1;
    }

    public void setReasonCode1(String reasonCode1) {
        this.reasonCode1 = reasonCode1;
    }

    public String getReasonCode2FieldLength() {
        return reasonCode2FieldLength;
    }

    public void setReasonCode2FieldLength(String reasonCode2FieldLength) {
        this.reasonCode2FieldLength = reasonCode2FieldLength;
    }

    public String getReasonCode2() {
        return reasonCode2;
    }

    public void setReasonCode2(String reasonCode2) {
        this.reasonCode2 = reasonCode2;
    }

    public String getReasonCode3FieldLength() {
        return reasonCode3FieldLength;
    }

    public void setReasonCode3FieldLength(String reasonCode3FieldLength) {
        this.reasonCode3FieldLength = reasonCode3FieldLength;
    }

    public String getReasonCode3() {
        return reasonCode3;
    }

    public void setReasonCode3(String reasonCode3) {
        this.reasonCode3 = reasonCode3;
    }

}