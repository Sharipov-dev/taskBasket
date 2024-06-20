package apples.demo.service;

import apples.demo.entity.Apple;
import apples.demo.entity.Basket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface  IAppleService {
    Basket addAppleToBasket(Long basketId, Apple apple);
    Basket removeAppleFromBasket(Long basketId, Long appleId);
    Apple getAppleFromBasket(Long basketId);
    List<Basket> getAllBaskets();
    Basket createBasket();
    Optional<Basket> getBasketById(Long basketId);
}
