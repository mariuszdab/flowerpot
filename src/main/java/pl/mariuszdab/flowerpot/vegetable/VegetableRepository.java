package pl.mariuszdab.flowerpot.vegetable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
}
