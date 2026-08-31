package gitscrumdemo.beer;

import java.net.URL;
import java.util.List;

public interface BeerRepository {

    List<Beer> findAll();
    List<Beer> findBeersByName(String name);
}
