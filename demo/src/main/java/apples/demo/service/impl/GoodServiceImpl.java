package apples.demo.service.impl;

import apples.demo.entity.Good;
import apples.demo.exception.NotEnoughGoodsException;
import apples.demo.repo.GoodRepository;
import apples.demo.service.IGoodService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoodServiceImpl implements IGoodService {

    GoodRepository goodRepository;

    @Override
    @Transactional
    public synchronized Integer getGoodByName(String name, int amount) {
        Good good = goodRepository
                .getGoodByName(name)
                .orElseThrow(
                () -> new RuntimeException(name + " is not found"));

        if(good.getAmount() < amount){
            throw new NotEnoughGoodsException(name, amount, good.getAmount());
        } else {
            good.setAmount(good.getAmount() - amount);
            Good savedGood = goodRepository.save(good);

            Integer totalCost = savedGood.getPrice() * amount;
            return totalCost;

        }


    }
}
