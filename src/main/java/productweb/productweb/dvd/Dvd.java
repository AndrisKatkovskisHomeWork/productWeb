package productweb.productweb.dvd;

import javax.persistence.*;

@Entity
public class Dvd {

    @Id
    @Column(name = "id_dvd")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "dvd_name")
    private String dvdName;

    public Dvd() {
    }

    public Dvd(String dvdName) {
        this.dvdName = dvdName;
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
}

