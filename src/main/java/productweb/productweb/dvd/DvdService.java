package productweb.productweb.dvd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DvdService {

    @Autowired
    DvdRepository dvdRepository;

    public Dvd getDvd(int id) {
        return dvdRepository.findById(id).get();
    }

    public void addDvd(Dvd dvd) {
        dvdRepository.save(dvd);
    }

    public List<Dvd> getAllDvds() {
        List<Dvd> dvds = new ArrayList<>();
        dvdRepository.findAll().forEach(dvds::add);
        return dvds;
    }

}