package by.pizzasp.ics.mybatis;


import by.pizzasp.ics.dto.IngredientsDTO;

import java.util.List;

public interface IngredientsMapper {
    Long addNewIngredient(IngredientsDTO ingredientsDTO);
    IngredientsDTO getIngredient(Long ingredientID);
    List<IngredientsDTO> getAllIngredients();
    void changePricePerKg(Long ingredientId, Long newPrice);
}
