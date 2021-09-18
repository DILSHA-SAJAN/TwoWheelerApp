package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class PostOfficeResponse  extends BaseResponse{
    @SerializedName("PostList")
    @Expose
    public ArrayList<PostList> PostList = null;

    public ArrayList<PostList> getPostList() {
        return PostList;
    }

    public void setPostList(ArrayList<PostList> postList) {
        PostList = postList;
    }

    public class PostList implements Serializable {

        @SerializedName("sr_number")
        @Expose
        public String sr_number;
        @SerializedName("post_office")
        @Expose
        public String post_office;

        public String getSr_number() {
            return sr_number;
        }

        public void setSr_number(String sr_number) {
            this.sr_number = sr_number;
        }

        public String getPost_office() {
            return post_office;
        }

        public void setPost_office(String post_office) {
            this.post_office = post_office;
        }
    }
}
