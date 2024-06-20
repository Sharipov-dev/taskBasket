package apples.demo.rest;


import apples.demo.dto.ResponseDto;
import apples.demo.entity.Apple;
import apples.demo.entity.Basket;
import apples.demo.service.IAppleService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ApplesController {

    IAppleService iAppleService;

    @GetMapping("/baskets")
    public ResponseEntity<List<Basket>> getAllBaskets() {

        List<Basket> baskets = iAppleService.getAllBaskets();

        return ResponseEntity.ok(baskets);
    }

    @PostMapping("/baskets")
    public ResponseEntity<ResponseDto> createBasket() {

        iAppleService.createBasket();

        ResponseDto responseDto = new ResponseDto("200", "Basket has been created successfully");

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/baskets/{basketId}/apples")
    public ResponseEntity<ResponseDto> addAppleToBasket(@PathVariable Long basketId,
                                                        @RequestBody Apple apple) {

       iAppleService.addAppleToBasket(basketId, apple);

        ResponseDto responseDto = new ResponseDto("200", "Apple has been added to the basket");

        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/baskets/{basketId}/apples/{appleId}")
    public ResponseEntity<ResponseDto> removeAppleFromBasket(@PathVariable Long basketId,
                                                             @PathVariable Long appleId) {

        iAppleService.removeAppleFromBasket(basketId, appleId);

        ResponseDto responseDto = new ResponseDto("200", "Apple has been removed the from the basket");

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/baskets/{basketId}/apples")
    public ResponseEntity<Apple> getAppleFromBasket(@PathVariable Long basketId) {

        Apple apple = iAppleService.getAppleFromBasket(basketId);

        return ResponseEntity.ok(apple);
    }
}

