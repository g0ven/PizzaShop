package by.pizzasp.ics.service.implement;


import by.pizzasp.ics.dto.BasketDTO;
import by.pizzasp.ics.exception.AccessDataError;
import by.pizzasp.ics.mybatis.AccessDataMapper;
import by.pizzasp.ics.mybatis.BasketMapper;
import by.pizzasp.ics.service.interfaces.BasketService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BasketServiceImpl implements BasketService{

    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    BasketMapper basketMapper;
    @Autowired
    AccessDataMapper accessDataMapper;

    public Long addPizzaIntoBasket(Long pizzaId) throws Exception{
        LOGGER.debug("addPizzaIntoBasket: pizzaId={}",pizzaId);
        if(!accessDataMapper.isExistGoodPizza(pizzaId))
            throw new AccessDataError("pizza with this id= "+pizzaId+" not exist");
        Long id= basketMapper.addPizzaIntoBasket(pizzaId);
        return id;
    }

    public List<BasketDTO> getBasket() throws Exception{
        LOGGER.debug("getBasket");
        return basketMapper.getBasket();
    }

    public void delPizzaFromBasket(Long pizzaId) throws Exception{
        LOGGER.debug("delPizzaFromBasket: pizzaId={}",pizzaId);
        basketMapper.delPizzaFromBasket(pizzaId);
    }

}
