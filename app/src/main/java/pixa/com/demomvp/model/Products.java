package pixa.com.demomvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LynkMieu on 11/22/2016.
 */

public class Products {

    @SerializedName("id_product")
    public int idProduct;
    @SerializedName("product_name")
    public String productName;
    @SerializedName("decription")
    public String decription;
    @SerializedName("price")
    public String price;
    @SerializedName("thumnail")
    public String thumnail;

    public Products() {
    }

    public Products(int idProduct, String productName, String decription, String price, String thumnail) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.decription = decription;
        this.price = price;
        this.thumnail = thumnail;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }
}
