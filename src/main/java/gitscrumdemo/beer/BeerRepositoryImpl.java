package gitscrumdemo.beer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Repository
public class BeerRepositoryImpl implements BeerRepository {

    private final List<Beer> beers;

    public BeerRepositoryImpl(ObjectMapper mapper) {
        try {
            var resource = new ClassPathResource("beers.json");
            beers = mapper.readValue(resource.getInputStream(),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException("Kon beers.json niet inlezen", e);
        }
    }

    @Override
    public List<Beer> findAll() {
        return beers;
    }

    @Override
    public List<Beer> findBeersByName(String name) {
        return beers.stream()
                .filter(beer -> beer.name().toLowerCase()
                        .contains(name.toLowerCase()))
                .toList();
    }
}
