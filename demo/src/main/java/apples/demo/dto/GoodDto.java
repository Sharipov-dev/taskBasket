package apples.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class GoodDto {

    private String name;

    private int amount;

    private int price;

    public GoodDto(String name,
                   int price){
        this.name = name;
        this.price = price;
    }
}
