package apples.demo.mapper;

import apples.demo.dto.GoodDto;
import apples.demo.entity.Good;

public class GoodMapper {

    private GoodMapper(){}

    public static GoodDto mapGoodToGoodDto (GoodDto goodDto, Good good) {

        goodDto.setAmount(good.getAmount());
        goodDto.setName(good.getName());
        goodDto.setPrice(good.getPrice());
        return goodDto;
    }

    public static Good mapGoodDtoToGood (Good good, GoodDto goodDto){

        good.setAmount(goodDto.getAmount());
        good.setName(goodDto.getName());
        good.setPrice(goodDto.getPrice());
        return good;
    }
}
