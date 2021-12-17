package com.sheetalkanago.tourismAPI.Controllers;

import com.sheetalkanago.tourismAPI.Models.Card;
import com.sheetalkanago.tourismAPI.Repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {
    @Autowired
    CardRepository cardRepository;

    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getCards(){
        return ResponseEntity.status(HttpStatus.OK).body(cardRepository.findAll());
    }
    @PostMapping("/card")
    public ResponseEntity<String> addCard (@RequestBody Card card){
        System.out.println(card);
        cardRepository.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).body("Card created");
    }
}
