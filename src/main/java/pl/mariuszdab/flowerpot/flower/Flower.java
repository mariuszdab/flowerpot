package pl.mariuszdab.flowerpot.flower;

import lombok.*;
import pl.mariuszdab.flowerpot.user.User;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flower")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String name;

    private Boolean oneYearFlower;

    @NotNull
    @NotBlank
    @Size(max = 11)
    private String monthToStart;

    @NotNull
    @NotBlank
    @Size(max = 600)
    private String description;

    @Min(1)
    @Max(150)
    private Integer height;

    @Min(1)
    @Max(10)
    private Integer level;

    @Min(10)
    @Max(40)
    private Integer temperature;

    @ManyToOne
    private User user;


}
