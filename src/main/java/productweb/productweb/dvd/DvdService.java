package productweb.productweb.dvd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}