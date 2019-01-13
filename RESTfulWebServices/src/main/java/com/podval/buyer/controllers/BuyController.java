package com.podval.buyer.controllers;

import com.podval.buyer.models.Buyer;
import com.podval.buyer.services.BuyerService;
import com.podval.buyer.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.ws.rs.PathParam;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("buyer")
public class BuyController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping(produces = "application/json")
    public ResponseEntity list(){
        List<Buyer> buyers = buyerService.findAll();
        if(buyers.isEmpty())
            return new ResponseEntity<Status>(Status.NO_CONTENT, HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Buyer>>(buyers, HttpStatus.OK);
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity get(@PathVariable("id") Integer id){
        Buyer buyer = buyerService.findById(id);
        if(buyer == null)
            return new ResponseEntity<Status>(Status.NO_CONTENT, HttpStatus.NO_CONTENT);
        return new ResponseEntity<Buyer>(buyer, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity add(@RequestBody Buyer buyer){
        buyerService.save(buyer);
        return new ResponseEntity<Status>(Status.CREATED, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}", produces = "application/json")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        Boolean result = buyerService.deleteById(id);
        if(!result)
            return new ResponseEntity<Status>(Status.NOT_FOUND, HttpStatus.NOT_FOUND);
        return new ResponseEntity<Status>(Status.NO_CONTENT, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(produces = "application/json")
    public ResponseEntity deleteAll(){
        Integer result = buyerService.deleteAll();
        if(result > 0)
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
        return new ResponseEntity<Status>(Status.NOT_MODIFIED, HttpStatus.NOT_MODIFIED);
    }

}
