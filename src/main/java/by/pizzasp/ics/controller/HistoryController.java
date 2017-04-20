package by.pizzasp.ics.controller;

import by.pizzasp.ics.service.interfaces.HistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/")
public class HistoryController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private HistoryService historyService;
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value ="/history", method = RequestMethod.GET)
    Object getHistory() throws Exception{
        LOGGER.debug("getHistory");
        return historyService.getHistory();
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/history", method = RequestMethod.POST)
    void addOrderHistory() throws Exception {
        LOGGER.debug("addOrderHistory");
        historyService.addOrderHistory();
    }


}
