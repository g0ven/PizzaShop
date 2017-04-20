package by.pizzasp.ics.service.interfaces;

import by.pizzasp.ics.dto.GoodPizzaDTO;
import by.pizzasp.ics.exception.AccessDataError;

import java.util.List;

public interface GoodPizzaService {
    Long addNewGoodPizza(GoodPizzaDTO goodPizzaDTO) throws Exception;
    GoodPizzaDTO getGoodPizza(Long goodPizzaId) throws Exception;
    List<GoodPizzaDTO> getAllGoodPizzas() throws Exception;
}
