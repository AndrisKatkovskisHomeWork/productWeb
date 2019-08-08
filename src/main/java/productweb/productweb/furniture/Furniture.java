package productweb.productweb.furniture;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Furniture {

    @Id
    @Column(name = "id_furniture")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "furniture_name")
    private String furnitureName;

    @Column(name = "furniture_price")
    private BigDecimal furniturePrice;

    @Column(name = "furniture_height")
    private BigDecimal furnitureHeight;

    @Column(name = "furniture_width")
    private BigDecimal furnitureWidth;

    @Column(name = "furniture_length")
    private BigDecimal furnitureLength;
    //furnitureHeight, furnitureWidth and furnitureLength  - in MySQL change to ==>  decimal(10,1) ==> max value 999999999.9

    public Furniture() {
    }

    public Furniture(String furnitureName, BigDecimal furniturePrice, BigDecimal furnitureHeight,
                     BigDecimal furnitureWidth, BigDecimal furnitureLength) {
        this.furnitureName = furnitureName;
        this.furniturePrice = furniturePrice;
        this.furnitureHeight = furnitureHeight;
        this.furnitureWidth = furnitureWidth;
        this.furnitureLength = furnitureLength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public BigDecimal getFurniturePrice() {
        return furniturePrice;
    }

    public void setFurniturePrice(BigDecimal furniturePrice) {
        this.furniturePrice = furniturePrice;
    }

    public BigDecimal getFurnitureHeight() {
        return furnitureHeight;
    }

    public void setFurnitureHeight(BigDecimal furnitureHeight) {
        this.furnitureHeight = furnitureHeight;
    }

    public BigDecimal getFurnitureWidth() {
        return furnitureWidth;
    }

    public void setFurnitureWidth(BigDecimal furnitureWidth) {
        this.furnitureWidth = furnitureWidth;
    }

    public BigDecimal getFurnitureLength() {
        return furnitureLength;
    }

    public void setFurnitureLength(BigDecimal furnitureLength) {
        this.furnitureLength = furnitureLength;
    }
}

