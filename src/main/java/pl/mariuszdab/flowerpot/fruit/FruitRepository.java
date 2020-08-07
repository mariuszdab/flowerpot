package pl.mariuszdab.flowerpot.fruit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    @Query("select f from  Fruit f join fetch f.user a where f.id = :idUser")
    Optional<Fruit> findFruitByIdUser(@Param("idUser") Long id);

}
