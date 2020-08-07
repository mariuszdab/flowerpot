package pl.mariuszdab.flowerpot.fruit;

import lombok.*;
import pl.mariuszdab.flowerpot.user.User;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "fruit")
@AllArgsConstructor
public class Fruit {

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
    private String monthToGetFruit;

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

    @ManyToOne
    private User user;

    public Fruit() {
    }
}
