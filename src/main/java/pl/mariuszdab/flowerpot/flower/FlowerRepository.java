package pl.mariuszdab.flowerpot.flower;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FlowerRepository extends JpaRepository<Flower, Long> {

    @Query("select f from Flower f join fetch f.user a where f.id = :idUser")
    Optional<Flower> findFlowerByIdUser(@Param("idUser") Long id);

}
