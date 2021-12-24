package com.sheetalkanago.tourismAPI.Controllers;

import com.sheetalkanago.tourismAPI.Exceptions.ResourceNotFoundException;
import com.sheetalkanago.tourismAPI.Models.Card;
import com.sheetalkanago.tourismAPI.Repositories.CardRepository;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
public class CardController {
    @Autowired
    CardRepository cardRepository;

    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getCards(){
        return ResponseEntity.status(HttpStatus.OK).body(cardRepository.findAll());
    }

    @GetMapping("/card/{cardID}")
    public ResponseEntity<Card> getCard(String cardID){
        return ResponseEntity.status(HttpStatus.OK).body(cardRepository.getById(parseInt(cardID)));
    }

    @PostMapping("/card")
    public ResponseEntity<String> addCard (@RequestBody Card card){
//        System.out.println(card);
        cardRepository.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).body("Card created");
    }

    @PatchMapping("/card/{requestedCardID}")
    public ResponseEntity<Card> patchCard (@PathVariable String requestedCardID, @RequestBody Map<String, Object> fields) throws ResourceNotFoundException {
        if(!cardRepository.existsById(parseInt(requestedCardID)))
        {
            throw new ResourceNotFoundException();
        }else{
            Card card = cardRepository.findById(parseInt(requestedCardID)).orElseThrow();

            BeanWrapper wrapper = new BeanWrapperImpl(card);
            wrapper.setPropertyValues(fields);
            card = (Card) wrapper.getWrappedInstance();

//            System.out.println(updatedCard);
            cardRepository.save(card);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Card Updated:", String.valueOf(requestedCardID))
                    .body(card);
        }
    }

    @DeleteMapping("/card/{cardID}")
    @Transactional
    public ResponseEntity<String> deleteCard(@PathVariable String cardID) throws ResourceNotFoundException {
         if(!cardRepository.existsById(parseInt(cardID)))
         {
             throw new ResourceNotFoundException();
         }else{
            cardRepository.deleteById(parseInt(cardID));
            return ResponseEntity.status(HttpStatus.GONE).body("Deleted Card : " + cardID);
         }
    }

}
