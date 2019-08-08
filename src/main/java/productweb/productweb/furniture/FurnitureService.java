package productweb.productweb.furniture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FurnitureService {

    @Autowired
    FurnitureRepository furnitureRepository;

    public Furniture getFurniture(int id) {
        return furnitureRepository.findById(id).get();
    }

    public void addFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    public List<Furniture> getAllFurnitures() {
        List<Furniture> furnitures = new ArrayList<>();
        furnitureRepository.findAll().forEach(furnitures::add);
        return furnitures;
    }

    public boolean deleteFurniture(int id) {
        try {
            furnitureRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}