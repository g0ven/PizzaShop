package by.pizzasp.ics.controller;

import by.pizzasp.ics.dto.GoodPizzaDTO;
import by.pizzasp.ics.service.interfaces.GoodPizzaService;
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
public class GoodPizzaControllerTest{

    public static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private GoodPizzaService goodPizzaService;


    @Test
    public void getAllOrOneGoodPizzaTest() throws Exception {

        LOGGER.info("getAllOrOneGoodPizzaTest started");

        GoodPizzaDTO first = new GoodPizzaDTO(new Long(1L),"name_pizza_1",new Long(0L),new Long(100L));
        GoodPizzaDTO second = new GoodPizzaDTO(new Long(2L),"name_pizza_2",new Long(0L),new Long(100L));
        GoodPizzaDTO third = new GoodPizzaDTO(new Long(3L),"name_pizza_3",new Long(0L),new Long(100L));
        List<GoodPizzaDTO> all= Arrays.asList(first,second,third);

        LOGGER.info("getOneGoodPizzaTest started");

        GoodPizzaDTO actual =goodPizzaService.getGoodPizza(new Long(1L));
        GoodPizzaDTO notActual=goodPizzaService.getGoodPizza(new Long(2L));
        Assert.assertEquals(first.toString(),actual.toString());
        Assert.assertNotEquals(first.toString(),notActual.toString());

        LOGGER.info("getAllGoodPizzaTest started");

        List<GoodPizzaDTO> actualAll=goodPizzaService.getAllGoodPizzas();
        Assert.assertEquals(all.toString(),actualAll.toString());
        Assert.assertNotEquals(all.toString(), notActual.toString());

        LOGGER.info("getAllOrOneGoodPizzaTest finished");


    }
    @Test
    public void addNewGoodPizzaTest() throws Exception{

        LOGGER.info("addNewGoodPizzaTest started");

        GoodPizzaDTO first = new GoodPizzaDTO(new Long(1L),"name_pizza_1",new Long(0L),new Long(100L));

        Long id=goodPizzaService.addNewGoodPizza(first);
        GoodPizzaDTO actual=goodPizzaService.getGoodPizza(id);
        GoodPizzaDTO notActual =goodPizzaService.getGoodPizza(3L);
        Assert.assertEquals(first.toString(),actual.toString());
        Assert.assertNotEquals(first.toString(),notActual.toString());

        LOGGER.info("addNewGoodPizzaTest finished");
    }
}
