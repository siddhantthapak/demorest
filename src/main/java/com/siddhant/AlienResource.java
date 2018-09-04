package com.siddhant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/aliens")
public class AlienResource {

    AlienRepository alienRepository = new AlienRepository();

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Alien> getAliens(){
        return alienRepository.getAliens();
    }

    @GET
    @Path("alien/{name}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien getAlien(@PathParam("name") String name){
        return  alienRepository.getAlien(name);
    }

    @POST
    @Path("alien")
    public Alien createAlien(Alien alien){
        alienRepository.createAlien(alien);
        return alien;
    }

}
