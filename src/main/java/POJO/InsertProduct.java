package POJO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InsertProduct {

    private String title;
    private int price;
    private String description;
    private String image;
    private String category;

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }


}
