package by.pizzasp.ics.controller;

import by.pizzasp.ics.dto.FinalPizzaDTO;
import by.pizzasp.ics.dto.IngredientsDTO;
import by.pizzasp.ics.service.interfaces.FinalPizzaService;
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
public class FinalPizzaControllerTest {

    public static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private FinalPizzaService finalPizzaService;


    @Test
    public void getAllOrOneFinalPizzaTest() throws Exception {

        LOGGER.info("getAllOrOneFinalPizzaTest started");

        FinalPizzaDTO first = new FinalPizzaDTO(new Long(1L), "name_pizza_1", new Long(1L), new Long(10L),
                Arrays.asList(new IngredientsDTO(new Long(1L),"name_ingredient_1",new Long(1L),new Long(1L))),
                new Long(11L),new Long(11L));

        FinalPizzaDTO second = new FinalPizzaDTO(new Long(2L), "name_pizza_2", new Long(2L), new Long(12L),
                Arrays.asList(new IngredientsDTO(new Long(1L),"name_ingredient_1",new Long(1L),new Long(1L)),
                        new IngredientsDTO(new Long(2L),"name_ingredient_2",new Long(2L),new Long(2L))),
                new Long(15L),new Long(17L));

        FinalPizzaDTO third = new FinalPizzaDTO(new Long(3L), "name_pizza_3", new Long(3L), new Long(13L),
                Arrays.asList(new IngredientsDTO(new Long(1L),"name_ingredient_1",new Long(1L),new Long(1L)),
                        new IngredientsDTO(new Long(2L),"name_ingredient_2",new Long(2L),new Long(2L)),
                        new IngredientsDTO(new Long(3L),"name_ingredient_3",new Long(3L),new Long(3L))),
                new Long(19L),new Long(27L));

        List<FinalPizzaDTO> all= Arrays.asList(first,second,third);

        LOGGER.info("getOneFinalPizzaTest started");

        FinalPizzaDTO actual =finalPizzaService.getFinalPizza(new Long(1L));
        FinalPizzaDTO notActual=finalPizzaService.getFinalPizza(new Long(2L));
        Assert.assertEquals(first.getGoodPizzaId(),actual.getGoodPizzaId());
        Assert.assertEquals(first.getName(),actual.getName());
        Assert.assertEquals(first.getRadius(),actual.getRadius());
        for (int i=0;i<first.getIngredientsDTO().size();i++) {
            Assert.assertEquals(first.getIngredientsDTO().get(i).getName(),actual.getIngredientsDTO().get(i).getName());
            Assert.assertEquals(first.getIngredientsDTO().get(i).getWage(),actual.getIngredientsDTO().get(i).getWage());
        }
        Assert.assertEquals(first.getWage(),actual.getWage());
        Assert.assertEquals(first.getPrice(),actual.getPrice());

        Assert.assertNotEquals(actual.toString(),notActual.toString());


        LOGGER.info("getAllFinalPizzaTest started");


        List<FinalPizzaDTO> actualAll=finalPizzaService.getAllFinalPizzas();
        for (int i=0; i<all.size();i++) {
            Assert.assertEquals(all.get(i).getGoodPizzaId(),actualAll.get(i).getGoodPizzaId());
            Assert.assertEquals(all.get(i).getName(),actualAll.get(i).getName());
            for (int j=0;j<all.get(i).getIngredientsDTO().size();j++) {
                Assert.assertEquals(all.get(i).getIngredientsDTO().get(i).getName(),actualAll.get(i).getIngredientsDTO().get(i).getName());
            }
            Assert.assertEquals(all.get(i).getPrice(),actualAll.get(i).getPrice());

        }
        Assert.assertNotEquals(actualAll.toString(), all.toString());


        LOGGER.info("getAllOrOneFinalPizzaTest finished");


    }
    @Test
    public void addNewFinalPizzaTest() throws Exception {

        LOGGER.info("addNewFinalPizzaTest started");

        FinalPizzaDTO first = new FinalPizzaDTO(new Long(4L), "name_pizza_4", new Long(3L), new Long(13L),
                Arrays.asList(new IngredientsDTO(new Long(1L), "name_ingredient_1", new Long(1L), new Long(1L)),
                        new IngredientsDTO(new Long(3L), "name_ingredient_3", new Long(3L), new Long(3L))),
                new Long(17L), new Long(23L));


        Long id = finalPizzaService.addNewFinalPizza(first);
        FinalPizzaDTO actual = finalPizzaService.getFinalPizza(id);
        FinalPizzaDTO notActual = finalPizzaService.getFinalPizza(3L);

        Assert.assertEquals(first.getGoodPizzaId(),actual.getGoodPizzaId());
        Assert.assertEquals(first.getName(),actual.getName());
        Assert.assertEquals(first.getRadius(),actual.getRadius());
        for (int i=0;i<first.getIngredientsDTO().size();i++) {
            Assert.assertEquals(first.getIngredientsDTO().get(i).getName(),actual.getIngredientsDTO().get(i).getName());
            Assert.assertEquals(first.getIngredientsDTO().get(i).getWage(),actual.getIngredientsDTO().get(i).getWage());
        }
        Assert.assertEquals(first.getWage(),actual.getWage());
        Assert.assertEquals(first.getPrice(),actual.getPrice());

        Assert.assertNotEquals(first.toString(), notActual.toString());

        LOGGER.info("addNewFinalPizzaTest finished");
    }
}

