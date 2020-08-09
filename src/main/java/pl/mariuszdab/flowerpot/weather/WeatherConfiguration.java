package pl.mariuszdab.flowerpot.weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    WeatherService weatherService(RestTemplate restTemplate) {
        return new WeatherService(restTemplate);
    }

}
