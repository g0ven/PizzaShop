package by.pizzasp.ics.controller;

import by.pizzasp.ics.dto.HistoryDTO;
import by.pizzasp.ics.service.interfaces.HistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/resources/test.xml"})
@Sql(scripts = {"classpath:del-test-data.sql","classpath:test-data.sql"})
public class HistoryControllerTest {

    public static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private HistoryService historyService;


    @Test
    public void getHistoryTest() throws Exception {

        LOGGER.info("getHistoryTest started");

        HistoryDTO first = new HistoryDTO(new Long(1L),"name_pizza_1",new Long(11L), null);
        HistoryDTO second = new HistoryDTO(new Long(2L),"name_pizza_2",new Long(17L),null);
        HistoryDTO third = new HistoryDTO(new Long(3L),"name_pizza_3",new Long(27L),null);
        List<HistoryDTO> all= Arrays.asList(first,second,third);

        List <HistoryDTO> actualAll =historyService.getHistory();
        List<HistoryDTO> notActual=Arrays.asList(first,second);
        for (int i=0; i<all.size();i++) {
            Assert.assertEquals(all.get(i).getGoodPizzaId(), actualAll.get(i).getGoodPizzaId());
            Assert.assertEquals(all.get(i).getNamePizza(), actualAll.get(i).getNamePizza());
            Assert.assertEquals(all.get(i).getPricePerPizza(), actualAll.get(i).getPricePerPizza());
        }
        Assert.assertNotEquals(actualAll,notActual);



        LOGGER.info("getOrderTest finished");


    }


    @Test
    public void addOrderHistoryTest() throws Exception{

        LOGGER.info("addOrderHistoryTest started");

        HistoryDTO first = new HistoryDTO(new Long(1L),"name_pizza_1",new Long(11L), null);
        HistoryDTO second = new HistoryDTO(new Long(2L),"name_pizza_2",new Long(17L),null);
        HistoryDTO third = new HistoryDTO(new Long(3L),"name_pizza_3",new Long(27L),null);
        List<HistoryDTO> all= Arrays.asList(first,second,third,first,second,third);

        historyService.addOrderHistory();
        List <HistoryDTO> actualAll=historyService.getHistory();
        List<HistoryDTO> notActual=Arrays.asList(first,second,third);
        for (int i=0; i<all.size();i++) {
            Assert.assertEquals(all.get(i).getGoodPizzaId(), actualAll.get(i).getGoodPizzaId());
            Assert.assertEquals(all.get(i).getNamePizza(), actualAll.get(i).getNamePizza());
            Assert.assertEquals(all.get(i).getPricePerPizza(), actualAll.get(i).getPricePerPizza());
        }
        Assert.assertNotEquals(actualAll.toString(),notActual.toString());

        LOGGER.info("addOrderHistoryTest finished");
    }
}
