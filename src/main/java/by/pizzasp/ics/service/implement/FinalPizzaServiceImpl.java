package by.pizzasp.ics.service.implement;

import by.pizzasp.ics.dto.FinalPizzaDTO;
import by.pizzasp.ics.dto.GoodPizzaDTO;
import by.pizzasp.ics.dto.IngredientsDTO;
import by.pizzasp.ics.exception.AccessDataError;
import by.pizzasp.ics.mybatis.AccessDataMapper;
import by.pizzasp.ics.mybatis.FinalPizzaMapper;
import by.pizzasp.ics.service.interfaces.FinalPizzaService;
import by.pizzasp.ics.service.interfaces.GoodPizzaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FinalPizzaServiceImpl implements FinalPizzaService{

    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private FinalPizzaMapper finalPizzaMapper;
    @Autowired
    private AccessDataMapper accessDataMapper;
    @Autowired
    private GoodPizzaService goodPizzaService;

    public Long addNewFinalPizza(FinalPizzaDTO finalPizzaDTO) throws Exception{
        LOGGER.debug("addNewFinalPizza: finalPizzaDTO={}",finalPizzaDTO);
        GoodPizzaDTO goodPizzaDTO=new GoodPizzaDTO();
        goodPizzaDTO.setName(finalPizzaDTO.getName());
        goodPizzaService.addNewGoodPizza(goodPizzaDTO);
        Long goodPizzaId=goodPizzaDTO.getId();
        if (!accessDataMapper.isExistBasisPizza(finalPizzaDTO.getBasisPizzaId())) {
            throw new AccessDataError("ingredient with this id= " + finalPizzaDTO.getBasisPizzaId() + " not exist");
        }
        for (IngredientsDTO newIngr: finalPizzaDTO.getIngredientsDTO()) {
            if(!accessDataMapper.isExistIngredient(newIngr.getId()))
                throw new AccessDataError("ingredient with this id= "+newIngr.getId()+" not exist");
            finalPizzaMapper.addNewFinalPizza(goodPizzaId,finalPizzaDTO.getBasisPizzaId(),newIngr);

        }
        return goodPizzaId;


    }

    public FinalPizzaDTO getFinalPizza(Long finalPizzaId) throws Exception{
        LOGGER.debug("getFinalPizza: finalPizzaId={}", finalPizzaId);
        if(!accessDataMapper.isExistGoodPizza(finalPizzaId))
            throw new AccessDataError("finalPizza with this id= "+finalPizzaId+" not exist");
        return finalPizzaMapper.getFinalPizza(finalPizzaId);
    }

    public List<FinalPizzaDTO> getAllFinalPizzas() throws Exception{
        LOGGER.debug("getAllFinalPizzaId");
        return finalPizzaMapper.getAllFinalPizzas();
    }
}
