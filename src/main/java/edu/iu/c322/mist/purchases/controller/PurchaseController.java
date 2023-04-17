package edu.iu.c322.mist.purchases.controller;


import edu.iu.c322.mist.purchases.model.CustomerProfile;
import edu.iu.c322.mist.purchases.model.Game;
import edu.iu.c322.mist.purchases.model.UserVerify;
import edu.iu.c322.mist.purchases.repository.GameListRepository;
import edu.iu.c322.mist.purchases.repository.UserListRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private UserListRepository userRepository;
    private GameListRepository gameRepository;

    public PurchaseController(UserListRepository userRepository, GameListRepository gameRepository){
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{gameId}")
    public void purchase(@PathVariable int gameId, @RequestBody UserVerify verify){
        CustomerProfile user = userRepository.getCustomerProfileByUsernameEqualsAndPasswordEquals(verify.username(), verify.password());
        if (user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "specified user does not exist");
        }
        Game game = gameRepository.findById(gameId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "specified game does not exist"));
        if (!user.getOwnedGames().contains(game)){
            user.getOwnedGames().add(game);
        }
    }


}
