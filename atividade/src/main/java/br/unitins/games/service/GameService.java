package br.unitins.games.service;

import java.util.List;

import br.unitins.games.dto.GameDTO;
import br.unitins.games.model.Game;

public interface GameService {
    
    List<Game> getAll();

    Game insert(GameDTO gameDto);
}
