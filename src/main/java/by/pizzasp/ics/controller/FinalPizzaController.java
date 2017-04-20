package by.pizzasp.ics.controller;

import by.pizzasp.ics.dto.FinalPizzaDTO;
import by.pizzasp.ics.service.interfaces.FinalPizzaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/")
public class FinalPizzaController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private FinalPizzaService finalPizzaService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value ="/finalPizza", method = RequestMethod.GET)
    Object getAllOrOneFinalPizza(@RequestParam(value = "id", required = false) Long finalPizzaId) throws Exception{
        if(finalPizzaId==null) {
            LOGGER.debug("getAllFinalPizza");
            return finalPizzaService.getAllFinalPizzas();
        }else{
            LOGGER.debug("getFinalPizza: finalPizzaId= {}", finalPizzaId);
            return finalPizzaService.getFinalPizza(finalPizzaId);
        }
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/finalPizza", method = RequestMethod.POST)
    Long addNewFinalPizza(@Valid @RequestBody FinalPizzaDTO finalPizzaDTO) throws Exception {
        LOGGER.debug("addNewFinalPizza: finalePizzaDTO= {}", finalPizzaDTO);
        return finalPizzaService.addNewFinalPizza(finalPizzaDTO);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/finalPizza/q", method = RequestMethod.GET)
    FinalPizzaDTO getFinalPizza(@RequestParam(value = "id") Long finalPizzaId) throws Exception {
        LOGGER.debug("getBasisPizza: basisPizzaId= {}", finalPizzaId);
        return finalPizzaService.getFinalPizza(finalPizzaId);
    }


}
