package gitscrumdemo.beer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.time.YearMonth;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Beer(long id, String name, @JsonProperty("tagline") String tagLine,
                   @JsonFormat(pattern = "MM/yyyy")
                   @JsonProperty("first_brewed") YearMonth firstBrewed, String description,
                   @JsonProperty("image_url") URL imageUrl, double abv) {
}
