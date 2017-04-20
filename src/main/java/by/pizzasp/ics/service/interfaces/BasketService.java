package by.pizzasp.ics.service.interfaces;

import by.pizzasp.ics.dto.BasketDTO;

import java.util.List;

public interface BasketService {
    Long addPizzaIntoBasket(Long pizzaId) throws Exception;
    List<BasketDTO> getBasket() throws Exception;
    void delPizzaFromBasket(Long pizzaId) throws Exception;

}
