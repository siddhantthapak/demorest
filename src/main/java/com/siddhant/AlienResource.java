package com.siddhant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/aliens")
public class AlienResource {

    AlienRepository alienRepository = new AlienRepository();

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Alien> getAliens() {
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
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien createAlien(Alien alien){
        alienRepository.createAlien(alien);
        return alien;
    }

    @PUT
    @Path("alien")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien updateAlien(Alien alien){
        String name = alien.getName();
        if(alienRepository.getAlien(name)==null){
            alienRepository.createAlien(alien);
        }else{
           alienRepository.updateAlien(alien);
        }
        return alien;
    }

    @DELETE
    @Path("alien/{name}")
    public Alien deleteAlien(@PathParam("name") String name){
        Alien alien = alienRepository.getAlien(name);
        if(alien.getName()!= null){
            alienRepository.deleteAlien(alien);
        }
        return alien;
    }

}
