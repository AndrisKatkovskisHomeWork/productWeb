package productweb.productweb.dvd;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Dvd {

    @Id
    @Column(name = "id_dvd")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "dvd_name")
    private String dvdName;

    @Column(name = "dvd_price")
    private BigDecimal dvdPrice;

    @Column(name = "dvd_size")
    private String dvdSize;

    public Dvd() {
    }

    public Dvd(String dvdName, BigDecimal dvdPrice, String dvdSize) {
        this.dvdName = dvdName;
        this.dvdPrice = dvdPrice;
        this.dvdSize = dvdSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDvdName() {
        return dvdName;
    }

    public void setDvdName(String dvdName) {
        this.dvdName = dvdName;
    }

    public BigDecimal getDvdPrice() {
        return dvdPrice;
    }

    public void setDvdPrice(BigDecimal dvdPrice) {
        this.dvdPrice = dvdPrice;
    }

    public String getDvdSize() {
        return dvdSize;
    }

    public void setDvdSize(String dvdSize) {
        this.dvdSize = dvdSize;
    }
}

