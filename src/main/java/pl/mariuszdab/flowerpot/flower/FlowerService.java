package pl.mariuszdab.flowerpot.flower;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mariuszdab.flowerpot.exception.UserNotFoundException;
import pl.mariuszdab.flowerpot.exception.UserNotFoundExceptionWhenUpdate;
import pl.mariuszdab.flowerpot.user.User;
import pl.mariuszdab.flowerpot.user.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlowerService {

    private final UserRepository userRepository;
    private final FlowerRepository flowerRepository;
    private final FlowerMapper flowerMapper;

    public void save(Flower flower){
        if (addFlowerWithUser(flower) == null) {
            throw new UserNotFoundException();
        }
        Flower flowerDto = flowerMapper.EntityToDtoDb(flower);
        flowerRepository.save(flowerDto);
        log.info("Kwiat o nazwie: {} zapisany w bazie danych", flowerDto.getName());
    }

    public void update(Long id, Flower flower){
        flower.setId(id);
        if (addFlowerWithUser(flower) == null) {
            throw new UserNotFoundExceptionWhenUpdate();
        }
        flowerRepository.save(flower);
        log.info("Kwiat o id: {} otrzymał update", flower.getId());
    }

    public List<FlowerDto> findAll(){
        List<FlowerDto> flowerListDto = flowerRepository.findAll().stream()
                .map(flowerMapper::EntityToDto)
                .collect(Collectors.toList());
        return flowerListDto;
    }

    public void delete(Long id){
        flowerRepository.deleteById(id);
    }

    public Optional<Flower> findUpdateFlowerByUserId(Long id){
        Optional<Flower> flower = flowerRepository.findFlowerByIdUser(id);
        return flower;
    }

    public Flower addFlowerWithUser(Flower flower) {
        Optional<User> user = userRepository.findByEmail(flower.getUser().getEmail());
        try{
            flower.setUser(user.orElseThrow(() -> new NotFoundException("")));
        }catch (NotFoundException e){
            log.info("Podano błędny adres email!");
            return null;
        }
        return flower;
    }

    public List<String> listOfMonths(){
        return List.of("Styczen", "Luty", "Marzec", "Kwiecien", "Maj", "Czerwiec", "Lipiec", "Sierpien", "Wrzesien", "Pazdziernik", "Listopad", "Grudzien", "Dowolny");
    }


}
