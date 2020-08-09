package pl.mariuszdab.flowerpot.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class LocationResponse {

    @JsonProperty("woeid")
    private String id;

}
