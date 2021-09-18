package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class OtherVerticalsResponse extends BaseResponse {
    @SerializedName("ProductList")
    @Expose
    public ArrayList<ProductList> ProductList = null;

    public ArrayList<ProductList> getProductList() {
        return ProductList;
    }

    public void setProductList(ArrayList<ProductList> productList) {
        ProductList = productList;
    }

    public class ProductList implements Serializable {

        @SerializedName("productId")
        @Expose
        public String productId;
        @SerializedName("productName")
        @Expose
        public String productName;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }


    }


}
