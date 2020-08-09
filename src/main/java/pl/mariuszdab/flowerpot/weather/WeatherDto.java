package pl.mariuszdab.flowerpot.weather;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherDto {

    private Double temperature;
    private TemperatureScale temperatureScale;
}
