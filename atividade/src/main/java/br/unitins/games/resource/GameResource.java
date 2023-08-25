package br.unitins.games.resource;

import java.util.List;

import br.unitins.games.dto.GameDTO;
import br.unitins.games.model.Game;
import br.unitins.games.service.GameService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {
    
    @Inject
    GameService gameService;

    @GET
    public List<Game> getAll() {

        return gameService.getAll();
    }

    @POST
    public Response insert(GameDTO gameDTO) {

        return Response
                    .status(Status.CREATED) // 201
                    .entity(gameService.insert(gameDTO))
                    .build();
    }
}
