package by.pizzasp.ics.controller;

import by.pizzasp.ics.dto.BasisPizzaDTO;
import by.pizzasp.ics.service.interfaces.BasisPizzaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/")
public class BasisPizzaController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private BasisPizzaService basisPizzaService;
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value ="/basisPizza", method = RequestMethod.GET)
    Object getAllOrOneBasisPizza(@RequestParam(value = "id", required = false) Long basisPizzaId) throws Exception{
        if(basisPizzaId==null) {
            LOGGER.debug("getAllBasisPizza");
            return basisPizzaService.getAllBasisPizzas();
        }else{
            LOGGER.debug("getBasisPizza: basisPizzaId= {}", basisPizzaId);
            return basisPizzaService.getBasisPizza(basisPizzaId);
        }
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/basisPizza", method = RequestMethod.POST)
    Long addNewBasisPizza(@Valid @RequestBody BasisPizzaDTO basisPizzaDTO) throws Exception {
        LOGGER.debug("addNewBasisPizza: basisPizzaDTO= {}", basisPizzaDTO);
        return basisPizzaService.addNewBasisPizza(basisPizzaDTO);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/basisPizza/q", method = RequestMethod.GET)
    BasisPizzaDTO getBasisPizza(@RequestParam(value = "id") Long basisPizzaId) throws Exception {
        LOGGER.debug("getBasisPizza: basisPizzaId= {}", basisPizzaId);
        return basisPizzaService.getBasisPizza(basisPizzaId);
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/basisPizza", method = RequestMethod.PUT)
    void changePriceBasisPizza(@RequestParam("id") Long basisPizzaId,
                          @RequestParam("price") Long price) throws Exception {
        LOGGER.debug("changePriceBasisPizza: basisPizzaId= {}, price= {}", basisPizzaId, price);
        basisPizzaService.changePriceBasisPizza(basisPizzaId,price);
    }


}
