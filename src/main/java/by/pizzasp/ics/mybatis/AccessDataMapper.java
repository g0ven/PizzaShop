package by.pizzasp.ics.mybatis;


public interface AccessDataMapper {
    Boolean isExistIngredient(Long ingredientId);
    Boolean isExistBasisPizza(Long basisPizzaId);
    Boolean isExistGoodPizza(Long goodPizzaId);
}
