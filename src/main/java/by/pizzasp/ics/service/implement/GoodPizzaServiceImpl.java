package by.pizzasp.ics.service.implement;


import by.pizzasp.ics.dto.GoodPizzaDTO;
import by.pizzasp.ics.exception.AccessDataError;
import by.pizzasp.ics.mybatis.AccessDataMapper;
import by.pizzasp.ics.mybatis.GoodPizzaMapper;
import by.pizzasp.ics.service.interfaces.GoodPizzaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodPizzaServiceImpl implements GoodPizzaService {
    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private GoodPizzaMapper goodPizzaMapper;
    @Autowired
    private AccessDataMapper accessDataMapper;

    public Long addNewGoodPizza(GoodPizzaDTO goodPizzaDTO) throws Exception{
        LOGGER.debug("addNewGoodPizza: goodPizzaDTO={}",goodPizzaDTO);
        goodPizzaMapper.addNewGoodPizza(goodPizzaDTO);
        return  goodPizzaDTO.getId();
    }

    public GoodPizzaDTO getGoodPizza(Long goodPizzaId) throws Exception{
        LOGGER.debug("getGoodPizza: goodPizzaId={}", goodPizzaId);
        if(!accessDataMapper.isExistGoodPizza(goodPizzaId))
            throw new AccessDataError("goodPizza with this id= "+goodPizzaId+" not exist");
        return goodPizzaMapper.getGoodPizza(goodPizzaId);
    }

    public List<GoodPizzaDTO> getAllGoodPizzas() throws Exception{
        LOGGER.debug("getAllGoodPizzas");
        return goodPizzaMapper.getAllGoodPizzas();
    }
}
