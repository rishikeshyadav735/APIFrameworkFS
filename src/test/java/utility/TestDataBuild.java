package utility;

import POJO.InsertProduct;

public class TestDataBuild {

    public InsertProduct insertProductPayload(String title){

        InsertProduct product = new InsertProduct();

        product.setTitle(title);
        product.setCategory("footwear");
        product.setDescription("Great shoes");
        product.setImage("https://i.pravatar.cc");
        product.setPrice(2100);
        return product;
    }
}
