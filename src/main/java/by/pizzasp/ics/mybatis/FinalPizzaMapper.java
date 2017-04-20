package by.pizzasp.ics.mybatis;


import by.pizzasp.ics.dto.FinalPizzaDTO;
import by.pizzasp.ics.dto.IngredientsDTO;

import java.util.List;

public interface FinalPizzaMapper {
    Long addNewFinalPizza(Long goodPizzaId, Long basisPizzaId, IngredientsDTO ingredientsDTO);
    FinalPizzaDTO getFinalPizza(Long finalPizzaId);
    List<FinalPizzaDTO> getAllFinalPizzas();
}
