package by.pizzasp.ics.service.implement;


import by.pizzasp.ics.dto.HistoryDTO;
import by.pizzasp.ics.mybatis.HistoryMapper;
import by.pizzasp.ics.service.interfaces.HistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService{

    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private HistoryMapper historyMapper;

    public void addOrderHistory() throws Exception{
        LOGGER.debug("addOrderHistory");
        historyMapper.addOrderHistory();
        historyMapper.cleanBasket();
    }
    public List<HistoryDTO> getHistory() throws Exception{
        LOGGER.debug("getHistory");
        return historyMapper.getHistory();
    }
}
