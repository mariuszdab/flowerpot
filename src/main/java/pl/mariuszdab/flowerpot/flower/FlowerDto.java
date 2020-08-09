package pl.mariuszdab.flowerpot.flower;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.mariuszdab.flowerpot.user.User;

@Data
@Builder
@AllArgsConstructor
public class FlowerDto {

    private Long id;
    private String name;
    private boolean oneYearFlower;
    private String monthToStart;
    private String description;
    private Integer level;
    private Integer temperature;

    public FlowerDto(){

    }


}
