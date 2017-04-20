package by.pizzasp.ics.service.implement;


import by.pizzasp.ics.dto.IngredientsDTO;
import by.pizzasp.ics.exception.AccessDataError;
import by.pizzasp.ics.mybatis.AccessDataMapper;
import by.pizzasp.ics.mybatis.IngredientsMapper;
import by.pizzasp.ics.service.interfaces.IngredientsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientsServiceImpl implements IngredientsService{

    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private IngredientsMapper ingredientsMapper;
    @Autowired
    private AccessDataMapper accessDataMapper;


    public Long addNewIngredient(IngredientsDTO ingredientsDTO) throws Exception{
        LOGGER.debug("addNewIngredients: ingredientsDTO={}", ingredientsDTO);
        ingredientsMapper.addNewIngredient(ingredientsDTO);
        return ingredientsDTO.getId();
    }

    public  IngredientsDTO getIngredient(Long ingredientId) throws Exception{
        LOGGER.debug("getIngredient: ingredientId={}", ingredientId);
        if(!accessDataMapper.isExistIngredient(ingredientId)){
            LOGGER.debug("getIngredient: ingredientId={");
            throw new AccessDataError("ingredient with this id= "+ingredientId+" not exist");}
        return ingredientsMapper.getIngredient(ingredientId);
    }

    public List<IngredientsDTO> getAllIngredients() throws Exception{
        LOGGER.debug("getAllIngredients");

        return ingredientsMapper.getAllIngredients();
    }

    public void changePricePerKg(Long ingredientId, Long newPrice) throws Exception{
        LOGGER.debug("changePricePerKg: ingredientId={}, newPrice={}", ingredientId, newPrice);
        if(!accessDataMapper.isExistIngredient(ingredientId))
            throw new AccessDataError("ingredient with this id= "+ingredientId+" not exist");
        ingredientsMapper.changePricePerKg(ingredientId,newPrice);

    }
}
