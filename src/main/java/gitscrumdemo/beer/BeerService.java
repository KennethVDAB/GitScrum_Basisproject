package gitscrumdemo.beer;

import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    public List<Beer> getBeersByName(String name) {
        return beerRepository.findBeersByName(name);
    }

}
