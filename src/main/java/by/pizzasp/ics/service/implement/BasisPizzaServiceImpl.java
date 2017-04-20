package by.pizzasp.ics.service.implement;


import by.pizzasp.ics.dto.BasisPizzaDTO;
import by.pizzasp.ics.exception.AccessDataError;
import by.pizzasp.ics.mybatis.AccessDataMapper;
import by.pizzasp.ics.mybatis.BasisPizzaMapper;
import by.pizzasp.ics.service.interfaces.BasisPizzaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BasisPizzaServiceImpl implements BasisPizzaService{

    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private BasisPizzaMapper basisPizzaMapper;
    @Autowired
    private AccessDataMapper accessDataMapper;

    public Long addNewBasisPizza(BasisPizzaDTO basisPizzaDTO) throws Exception{
        LOGGER.debug("addNewBasisPizza: basisPizzaDTO={}",basisPizzaDTO);
        basisPizzaMapper.addNewBasisPizza(basisPizzaDTO);
        return basisPizzaDTO.getId();
    }

    public BasisPizzaDTO getBasisPizza(Long basisPizzaId) throws Exception{
        LOGGER.debug("getBasisPizza: basisPizzaId={}",basisPizzaId);
        if(!accessDataMapper.isExistBasisPizza(basisPizzaId))
            throw new AccessDataError("basisPizza with this id= "+basisPizzaId+" not exist");

        return basisPizzaMapper.getBasisPizza(basisPizzaId);
    }

    public List<BasisPizzaDTO> getAllBasisPizzas() throws Exception{
        LOGGER.debug("getAllBasisPizzas");
        return basisPizzaMapper.getAllBasisPizzas();

    }

    public void changePriceBasisPizza(Long basisPizzaId, Long newPrice) throws Exception{
        LOGGER.debug("changePriceBasisPizza: basisPizzaId={}, newPrice={}",basisPizzaId,newPrice);
        if(!accessDataMapper.isExistBasisPizza(basisPizzaId))
            throw new AccessDataError("basisPizza with this id not exist");
        basisPizzaMapper.changePriceBasisPizza(basisPizzaId,newPrice);
    }
}
