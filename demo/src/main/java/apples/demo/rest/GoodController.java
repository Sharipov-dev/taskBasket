package apples.demo.rest;


import apples.demo.dto.GoodDto;
import apples.demo.service.IGoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class GoodController {

    IGoodService iGoodService;

    @GetMapping("/buyApples")
    public ResponseEntity<Integer> getApples(@RequestBody
                                             GoodDto goodDto){

        Integer price = iGoodService
                .getGoodByName(goodDto.getName(), goodDto.getAmount());

        return ResponseEntity.ok(price);
    }

}
