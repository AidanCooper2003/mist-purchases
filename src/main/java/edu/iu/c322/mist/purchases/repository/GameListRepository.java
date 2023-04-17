package edu.iu.c322.mist.purchases.repository;

import edu.iu.c322.mist.purchases.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<Game, Integer> {
    Game findGameById(int id);
}
