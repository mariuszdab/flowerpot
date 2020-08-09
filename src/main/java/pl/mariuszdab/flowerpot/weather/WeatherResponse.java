package pl.mariuszdab.flowerpot.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class WeatherResponse {

    private String title;

    @JsonProperty("consolidated_weather")
    private List<WeatherDetails> details = new ArrayList<>();

    @Data
    static class WeatherDetails {
        @JsonProperty("the_temp")
        private Double currentTemp;

        @JsonProperty("min_temp")
        private Double minTemp;

        @JsonProperty("max_temp")
        private Double maxTemp;
    }

}
