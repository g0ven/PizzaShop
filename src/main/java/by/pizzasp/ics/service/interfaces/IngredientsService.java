package by.pizzasp.ics.service.interfaces;

import by.pizzasp.ics.dto.IngredientsDTO;

import java.util.List;

public interface IngredientsService {

    Long addNewIngredient(IngredientsDTO ingredientsDTO) throws Exception;
    IngredientsDTO getIngredient(Long ingredientId) throws Exception;
    List<IngredientsDTO> getAllIngredients() throws Exception;
    void changePricePerKg(Long ingredientId, Long newPrice) throws Exception;
}
