package br.unitins.games.repository;

import br.unitins.games.model.Game;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameRepository implements PanacheRepository<Game> {
    
}
