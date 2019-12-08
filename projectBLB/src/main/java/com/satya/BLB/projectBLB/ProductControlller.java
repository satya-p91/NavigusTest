package com.satya.BLB.projectBLB;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
@RestController
@RequestMapping("/api/v1")
public class ProductControlller {

    @Autowired
    private RestRepository restRepository;


    @GetMapping(value = "/products")
    public List<Beer> getAllBeers(){
        return (List<Beer>) restRepository.findAll();
    }


    @GetMapping("/search")
    public ResponseEntity<Beer> getBeerByName(@RequestParam("name") String name) throws ResourceNotFoundException{
        List<Beer> lst = (List<Beer>) restRepository.findAll();
        Beer beer = null;

        for (Beer b:lst) {
            if(b.getName().equalsIgnoreCase(name)){
                beer = b;
                break;
            }
        }
        if(beer!=null){
            return ResponseEntity.ok().body(beer);
        }else {
            return ResponseEntity.ok().body(null);
        }
    }


    @PostMapping(value = "/setfavourite", produces = "application/json", consumes = "application/json")
    public Map<String, String> update(@Valid  @RequestBody IdPojo id){
        if(id!= null){

            Beer beer = restRepository.findById(id.getId()).orElse(null);

            if(beer!= null){
                beer.setIsfav(true);
                restRepository.save(beer);
                Map < String, String > response = new HashMap<>();
                response.put("messages", "Beer is added as favourite.");
                response.put("status","success");
                return response;
            }else {
                Map < String, String > response = new HashMap<>();
                response.put("messages", "Beer with that id is not found.");
                response.put("status","failed");
                return response;
            }
        }else {
            Map < String, String > response = new HashMap<>();
            response.put("messages", "Request body is not compatible");
            response.put("status","false");
            return response;
        }
    }


    @GetMapping("/favourites")
    public List<Beer> getAllFavourites(){
        List<Beer> lst = (List<Beer>) restRepository.findAll();
        List<Beer> res = new ArrayList<Beer>();

        for (Beer b:lst) {
            if(b.getIsfav()){
                res.add(b);
            }
        }
        return res;
    }



}
