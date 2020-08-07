package pl.mariuszdab.flowerpot.fruit;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mariuszdab.flowerpot.exception.UserNotFoundException;
import pl.mariuszdab.flowerpot.exception.UserNotFoundExceptionWhenUpdate;
import pl.mariuszdab.flowerpot.user.User;
import pl.mariuszdab.flowerpot.user.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FruitService {

    private final UserRepository userRepository;
    private final FruitRepository fruitRepository;
    private  final FruitMapper fruitMapper;

    public FruitService(UserRepository userRepository, FruitRepository fruitRepository, FruitMapper fruitMapper) {
        this.userRepository = userRepository;
        this.fruitRepository = fruitRepository;
        this.fruitMapper = fruitMapper;
    }

    public Fruit addFruitWithUser(Fruit fruit) {
        Optional<User> user = userRepository.findByEmail(fruit.getUser().getEmail());
        try{
            fruit.setUser(user.orElseThrow(() -> new NotFoundException("")));
        }catch (NotFoundException e){
            log.info("Podano błędny adres email!");
            return null;
        }
        return fruit;
    }

    public void save(Fruit fruit){
        if (addFruitWithUser(fruit) == null) {
            throw new UserNotFoundException();
        }
        fruitRepository.save(fruit);
    }

    public List<FruitDto> findAll(){
        List<FruitDto> fruitListDto = fruitRepository.findAll().stream()
                .map(fruitMapper::EntityToDto)
                .collect(Collectors.toList());

        return fruitListDto;
    }

    public void delete(Long id){
        fruitRepository.deleteById(id);
    }

    public Optional<Fruit> findUpdateFruitByUserId(Long id){
        Optional<Fruit> fruit = fruitRepository.findFruitByIdUser(id);
        return fruit;
    }

    public void update(Long id, Fruit fruit){
        fruit.setId(id);
        if (addFruitWithUser(fruit) == null) {
            throw new UserNotFoundExceptionWhenUpdate();
        }
        fruitRepository.save(fruit);
    }

    public List<String> listOfMonths(){
        List<String> listOfMonths = List.of("Styczen", "Luty", "Marzec", "Kwiecien", "Maj", "Czerwiec", "Lipiec", "Sierpien", "Wrzesien", "Pazdziernik", "Listopad", "Grudzien");
        return listOfMonths;
    }


}
