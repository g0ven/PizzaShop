package by.pizzasp.ics.mybatis;


import by.pizzasp.ics.dto.BasketDTO;

import java.util.List;

public interface BasketMapper {
    Long addPizzaIntoBasket(Long pizzaId) throws Exception;
    List<BasketDTO> getBasket() throws Exception;
    void delPizzaFromBasket(Long pizzaId) throws Exception;

}
