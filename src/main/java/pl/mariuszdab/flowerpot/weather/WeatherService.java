package pl.mariuszdab.flowerpot.weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherDto getCurrentWeather(String location) {
        log.info("Searching for weather for location {}", location);

        String locationId = getLocationId(location);
        WeatherResponse weatherResponse = restTemplate.getForObject(
                "https://www.metaweather.com/api/location/" + locationId,
                WeatherResponse.class);

        Double currentTemp = weatherResponse.getDetails()
                .stream()
                .findFirst()
                .map(WeatherResponse.WeatherDetails::getCurrentTemp)
                .orElseThrow();

        log.info("Current temp for {} is {}", location, currentTemp);

        return new WeatherDto(currentTemp, TemperatureScale.CELSIUS);
    }

    private String getLocationId(String location) {
        LocationResponse [] forObject = restTemplate.getForObject(
                "https://www.metaweather.com/api/location/search/?query=" + location,
                LocationResponse[].class);
        if (forObject.length == 0) {
            throw new RuntimeException();
        }
        return forObject[0].getId();
    }


}
