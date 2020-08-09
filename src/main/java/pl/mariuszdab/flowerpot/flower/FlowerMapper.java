package pl.mariuszdab.flowerpot.flower;

import org.springframework.stereotype.Component;

@Component
public class FlowerMapper {

    public Flower EntityToDtoDb(Flower flower){

        return new Flower().builder()
                .id(flower.getId())
                .name(flower.getName())
                .oneYearFlower((flower.getOneYearFlower()))
                .monthToStart(flower.getMonthToStart())
                .description(flower.getDescription())
                .level(flower.getLevel())
                .temperature(flower.getTemperature())
                .user(flower.getUser())
                .build();
    }

    public FlowerDto EntityToDto(Flower flower){

        return new FlowerDto().builder()
                .id(flower.getId())
                .name(flower.getName())
                .oneYearFlower((flower.getOneYearFlower()))
                .monthToStart(flower.getMonthToStart())
                .description(flower.getDescription())
                .level(flower.getLevel())
                .temperature(flower.getTemperature())
                .build();

    }


}
