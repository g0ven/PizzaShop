package by.pizzasp.ics.mybatis;

import by.pizzasp.ics.dto.GoodPizzaDTO;

import java.util.List;

public interface GoodPizzaMapper {
    Long addNewGoodPizza(GoodPizzaDTO goodPizzaDTO);
    GoodPizzaDTO getGoodPizza(Long goodPizzaId);
    List<GoodPizzaDTO> getAllGoodPizzas();
}
