package by.pizzasp.ics.controller;

import by.pizzasp.ics.service.interfaces.BasketService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/")
public class BasketController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private BasketService basketService;
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value ="/basket", method = RequestMethod.GET)
    Object getBasket() throws Exception{
            LOGGER.debug("getBasket");
            return basketService.getBasket();
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/basket", method = RequestMethod.POST)
    Long addPizzaIntoBasket(@RequestBody Long pizzaInBasket) throws Exception {
        LOGGER.debug("addPizzaIntoBasket: pizzaInBasket= {}", pizzaInBasket);
        return basketService.addPizzaIntoBasket(pizzaInBasket);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/basket", method = RequestMethod.DELETE)
    void d(@RequestParam("id") Long pizzaInBasket) throws Exception {
        LOGGER.debug("delPizza: pizzaInBasket={}", pizzaInBasket);
        basketService.delPizzaFromBasket(pizzaInBasket);
    }


}
