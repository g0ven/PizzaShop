package by.pizzasp.ics.controller;

import by.pizzasp.ics.dto.GoodPizzaDTO;
import by.pizzasp.ics.service.interfaces.GoodPizzaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1.0/")
public class GoodPizzaController{

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    GoodPizzaService goodPizzaService;
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value ="/goodPizza", method = RequestMethod.GET)
    Object getAllOrOneGoodPizza(@RequestParam(value = "id", required = false) Long goodPizzaId) throws Exception{
        if(goodPizzaId==null) {
            LOGGER.debug("getAllGoodPizzas");
            return goodPizzaService.getAllGoodPizzas();
        }else{
            LOGGER.debug("getGoodPizza: goodPizzaId= {}", goodPizzaId);
            return goodPizzaService.getGoodPizza(goodPizzaId);
        }
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/goodPizza", method = RequestMethod.POST)
    Long addNewGoodPizza(@Valid @RequestBody GoodPizzaDTO goodPizzaDTO) throws Exception {
        LOGGER.debug("addNewGoodPizza: goodPizzaDTO= {}", goodPizzaDTO);
        return goodPizzaService.addNewGoodPizza(goodPizzaDTO);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/goodPizza/q", method = RequestMethod.GET)
    GoodPizzaDTO getGoodPizza(@RequestParam(value = "id") Long goodPizzaId) throws Exception {
        LOGGER.debug("getGoodPizza: goodPizzaId= {}", goodPizzaId);
        return goodPizzaService.getGoodPizza(goodPizzaId);
    }

}
