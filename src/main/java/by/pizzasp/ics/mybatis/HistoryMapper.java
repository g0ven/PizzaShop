package by.pizzasp.ics.mybatis;


import by.pizzasp.ics.dto.HistoryDTO;

import java.util.List;

public interface HistoryMapper {
    void addOrderHistory();
    List<HistoryDTO> getHistory();
    void cleanBasket();
}
