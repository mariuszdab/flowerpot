package pl.mariuszdab.flowerpot.user;

import lombok.Getter;
import lombok.Setter;
import pl.mariuszdab.flowerpot.flower.Flower;
import pl.mariuszdab.flowerpot.fruit.Fruit;
import pl.mariuszdab.flowerpot.role.Role;
import pl.mariuszdab.flowerpot.vegetable.Vegetable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 20)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max = 10)
    @Column(unique = true)
    private String nick;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;

    @Email
    @NotNull
    @NotBlank
    //@EmailCheckInDB
    private String email;

    private Integer points;

    private Boolean newsletter;

    private Boolean active;

    @OneToMany(mappedBy = "user")
    private List<Flower> userFlowers = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Fruit> userFruits = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<Vegetable> userVegetables = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
