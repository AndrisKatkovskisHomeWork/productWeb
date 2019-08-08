package productweb.productweb.book;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Book {

    @Id
    @Column(name = "id_book")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_price")
    private BigDecimal bookPrice;

    @Column(name = "book_weight") // in MySQL change ==> book_weight decimal(12,3) ==> max value 999999999.999
    private BigDecimal bookWeight;

    public Book() {
    }

    public Book(String bookName, BigDecimal bookPrice, BigDecimal bookWeight) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookWeight = bookWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public BigDecimal getBookWeight() {
        return bookWeight;
    }

    public void setBookWeight(BigDecimal bookWeight) {
        this.bookWeight = bookWeight;
    }
}