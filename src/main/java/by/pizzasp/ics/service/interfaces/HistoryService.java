package by.pizzasp.ics.service.interfaces;


import by.pizzasp.ics.dto.HistoryDTO;

import java.util.List;

public interface HistoryService {
    void addOrderHistory() throws Exception;
    List<HistoryDTO> getHistory() throws Exception;
}
