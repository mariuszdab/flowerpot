package pl.mariuszdab.flowerpot.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByNick(String nick);

    List<User> findAllByNewsletter(Boolean check);

    User findByFirstName(String first);

    User findUserByEmail(String email);

}
