package pl.mariuszdab.flowerpot.flower;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlowerDto {

    private Long id;
    private String name;
    private boolean oneYearFlower;
    private String monthToStart;
    private String description;
    private Integer level;
    private Integer temperature;


}
