package by.pizzasp.ics.mybatis;


import by.pizzasp.ics.dto.BasisPizzaDTO;

import java.util.List;

public interface BasisPizzaMapper {
    Long addNewBasisPizza(BasisPizzaDTO basisPizzaDTO);
    BasisPizzaDTO getBasisPizza(Long basisPizzaId);
    List<BasisPizzaDTO> getAllBasisPizzas();
    void changePriceBasisPizza(Long basisPizzaId, Long newPrice);
}
