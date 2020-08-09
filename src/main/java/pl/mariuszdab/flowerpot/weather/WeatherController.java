package pl.mariuszdab.flowerpot.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/{location}")
    WeatherDto getWeather(@PathVariable("location") String location) {

        return weatherService.getCurrentWeather(location);
    }
}
