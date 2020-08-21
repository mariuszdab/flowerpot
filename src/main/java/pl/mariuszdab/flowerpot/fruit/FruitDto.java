package pl.mariuszdab.flowerpot.fruit;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FruitDto {

    private Long id;
    private String name;
    private String monthToStart;
    private String monthToGetFruit;
    private String description;
    private Integer level;
    private Integer temperature;

}