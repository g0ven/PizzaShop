package by.pizzasp.ics.service.interfaces;


import by.pizzasp.ics.dto.FinalPizzaDTO;

import java.util.List;

public interface FinalPizzaService {
    Long addNewFinalPizza(FinalPizzaDTO finalPizzaDTO) throws Exception;
    FinalPizzaDTO getFinalPizza(Long finalPizzaId) throws Exception;
    List<FinalPizzaDTO> getAllFinalPizzas() throws Exception;
}
