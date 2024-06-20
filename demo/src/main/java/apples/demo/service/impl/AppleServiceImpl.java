package apples.demo.service.impl;


import apples.demo.entity.Apple;
import apples.demo.entity.Basket;
import apples.demo.exception.NotEnoughApplesException;
import apples.demo.repo.AppleRepository;
import apples.demo.repo.BasketRepository;
import apples.demo.service.IAppleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppleServiceImpl implements IAppleService {

    BasketRepository basketRepository;

    AppleRepository appleRepository;

    @Override
    @Transactional
    public synchronized Basket addAppleToBasket(Long basketId, Apple apple) {

        Basket basket = basketRepository
                .findById(basketId)
                .orElseThrow(
                                () -> new RuntimeException("Basket not found"));

        basket.addApple(apple);

        appleRepository.save(apple);
        return basketRepository.save(basket);
    }
    @Override
    @Transactional
    public synchronized Basket removeAppleFromBasket(Long basketId, Long appleId) {
        Basket basket = basketRepository
                .findById(basketId)
                .orElseThrow(() -> new RuntimeException("Basket not found"));

        Apple apple = appleRepository
                .findById(appleId)
                .orElseThrow(() -> new RuntimeException("Apple not found"));

        basket.removeApple(apple);

        appleRepository.delete(apple);
        return basketRepository.save(basket);
    }

    @Override
    public synchronized Apple getAppleFromBasket(Long basketId) {
        Basket basket = basketRepository
                .findById(basketId)
                .orElseThrow(() -> new RuntimeException("Basket not found"));

        if (basket.getList().isEmpty()) {
            throw new NotEnoughApplesException("No apples in the basket");
        }
        Apple apple = basket
                .getList()
                .remove(0);

        appleRepository.delete(apple);
        basketRepository.save(basket);

        return apple;
    }

    @Override
    public List<Basket> getAllBaskets() {

        return basketRepository.findAll();
    }

    @Override
    @Transactional
    public Basket createBasket() {

        Basket basket = new Basket();
        basketRepository.save(basket);
    }

    @Override
    public Optional<Basket> getBasketById(Long basketId) {

        return basketRepository.findById(basketId);
    }
}
