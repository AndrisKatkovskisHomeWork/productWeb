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

    private BigDecimal dvdPrice;

    public Dvd() {
    }

    public Dvd(String dvdName, BigDecimal dvdPrice) {
        this.dvdName = dvdName;
        this.dvdPrice = dvdPrice;
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
}

