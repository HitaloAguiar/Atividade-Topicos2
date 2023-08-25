package br.unitins.games.service;

import java.util.List;

import br.unitins.games.dto.GameDTO;
import br.unitins.games.model.Game;
import br.unitins.games.repository.GameRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GameImplService implements GameService {

    @Inject
    GameRepository gameRepository;

    @Override
    public List<Game> getAll() {
        
        return gameRepository.findAll().list();
    }

    @Override
    @Transactional
    public Game insert(GameDTO gameDto) {
        
        Game entity = new Game();

        entity.setNome(gameDto.nome());

        entity.setPlataforma(gameDto.plataforma());

        gameRepository.persist(entity);

        return entity;
    }
    
}
