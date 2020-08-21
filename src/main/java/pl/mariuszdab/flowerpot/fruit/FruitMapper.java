package pl.mariuszdab.flowerpot.fruit;

import org.springframework.stereotype.Component;

@Component
public class FruitMapper {

    public FruitDto EntityToDto(Fruit fruit){

        return new FruitDto().builder()
                .id(fruit.getId())
                .name(fruit.getName())
                .monthToStart(fruit.getMonthToStart())
                .monthToGetFruit(fruit.getMonthToGetFruit())
                .description(fruit.getDescription())
                .level(fruit.getLevel())
                .temperature(fruit.getTemperature())
                .build();


    }

}