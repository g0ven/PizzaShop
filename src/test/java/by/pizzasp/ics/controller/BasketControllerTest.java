package by.pizzasp.ics.controller;

import by.pizzasp.ics.dto.BasketDTO;
import by.pizzasp.ics.service.interfaces.BasketService;
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
public class BasketControllerTest {

    public static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private BasketService basketService;


    @Test
    public void getBasketTest() throws Exception {

        LOGGER.info("getBasketTest started");

        BasketDTO first = new BasketDTO(new Long(1L),"name_pizza_1",new Long(11L));
        BasketDTO second = new BasketDTO(new Long(2L),"name_pizza_2",new Long(17L));
        BasketDTO third = new BasketDTO(new Long(3L),"name_pizza_3",new Long(27L));
        List<BasketDTO> all= Arrays.asList(first,second,third);

        List <BasketDTO> actualAll =basketService.getBasket();
        List<BasketDTO> notActual=Arrays.asList(first,second);
        for (int i=0; i<all.size();i++) {
            Assert.assertEquals(all.get(i).getGoodPizzaId(), actualAll.get(i).getGoodPizzaId());
            Assert.assertEquals(all.get(i).getNamePizza(), actualAll.get(i).getNamePizza());
            Assert.assertEquals(all.get(i).getPricePerPizza(), actualAll.get(i).getPricePerPizza());
        }
        Assert.assertNotEquals(actualAll,notActual);



        LOGGER.info("getBasketTest finished");


    }
    @Test
    public void addPizzaIntoBasketTest() throws Exception{

        LOGGER.info("addPizzaIntoBasketTest started");

        BasketDTO first = new BasketDTO(new Long(1L),"name_pizza_1",new Long(11L));

        basketService.addPizzaIntoBasket(first.getGoodPizzaId());
        int actual=basketService.getBasket().size();
        int notActual =3;
        Assert.assertEquals(4,actual);
        Assert.assertNotEquals(actual,notActual);

        LOGGER.info("addPizzaIntoBasketTest finished");
    }

    @Test
    public void delTest() throws Exception{

        LOGGER.info("delPizzaTest started");

        BasketDTO first = new BasketDTO(new Long(1L),"name_pizza_1",new Long(11L));
        BasketDTO second = new BasketDTO(new Long(2L),"name_pizza_2",new Long(17L));
        BasketDTO third = new BasketDTO(new Long(3L),"name_pizza_3",new Long(27L));
        List<BasketDTO> all= Arrays.asList(second,third);

        basketService.delPizzaFromBasket(first.getGoodPizzaId());
        List <BasketDTO> actualAll=basketService.getBasket();
        List<BasketDTO> notActual=Arrays.asList(first,second,third);
        Assert.assertEquals(all.toString(),actualAll.toString());
        Assert.assertNotEquals(actualAll.toString(),notActual.toString());

        LOGGER.info("delPizzaTest finished");
    }
}
