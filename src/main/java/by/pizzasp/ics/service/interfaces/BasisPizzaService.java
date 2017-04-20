package by.pizzasp.ics.service.interfaces;

import by.pizzasp.ics.dto.BasisPizzaDTO;

import java.util.List;

public interface BasisPizzaService {
    Long addNewBasisPizza(BasisPizzaDTO basisPizzaDTO) throws Exception;
    BasisPizzaDTO getBasisPizza(Long basisPizzaId) throws Exception;
    List<BasisPizzaDTO> getAllBasisPizzas() throws Exception;
    void changePriceBasisPizza(Long basisPizzaId, Long newPrice) throws Exception;
}
