package by.pizzasp.ics.controller;

import by.pizzasp.ics.dto.IngredientsDTO;
import by.pizzasp.ics.service.interfaces.IngredientsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/")
public class IngredientsController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private IngredientsService ingredientsService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value ="/ingredients", method = RequestMethod.GET)
    Object getAllOrOneIngredients(@RequestParam(value = "id", required = false) Long ingredientId) throws Exception{
        if(ingredientId==null) {
            LOGGER.debug("getAllIngredients");
            return ingredientsService.getAllIngredients();
        }else{
            LOGGER.debug("getIngredient: ingredientId= {}", ingredientId);
            return ingredientsService.getIngredient(ingredientId);
        }
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/ingredients", method = RequestMethod.POST)
    Long addNewIngredient(@Valid @RequestBody IngredientsDTO ingredientsDTO) throws Exception {
        LOGGER.debug("addNewIngredient: IngredientsDTO= {}", ingredientsDTO);
        return ingredientsService.addNewIngredient(ingredientsDTO);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/ingredients/q", method = RequestMethod.GET)
    IngredientsDTO getIngredient(@RequestParam(value = "id") Long ingredientId) throws Exception {
        LOGGER.debug("getIngredient: ingredientId= {}", ingredientId);
        return ingredientsService.getIngredient(ingredientId);
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/ingredients", method = RequestMethod.PUT)
    void changePricePerKg(@RequestParam("id") Long ingredientId,
                         @RequestParam("price") Long price) throws Exception {
        LOGGER.debug("changePricePerKg: ingredientId= {}, price= {}", ingredientId, price);
        ingredientsService.changePricePerKg(ingredientId,price);
    }


}
