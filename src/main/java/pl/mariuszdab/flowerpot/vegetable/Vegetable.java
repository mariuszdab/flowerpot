package pl.mariuszdab.flowerpot.vegetable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "vegetable")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String name;

    private boolean oneYearFlower;

    @NotNull
    @NotBlank
    @Size(max = 11)
    private String monthToStart;

    @NotNull
    @NotBlank
    @Size(max = 11)
    private String monthToGetVegetable;

    @NotNull
    @NotBlank
    @Size(max = 600)
    private String description;

    @Min(1)
    @Max(10)
    private Integer level;

    @Min(10)
    @Max(40)
    private Integer temperature;

    private Integer points;
}
