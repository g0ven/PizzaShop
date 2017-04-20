package by.pizzasp.ics.controller;

import by.pizzasp.ics.dto.IngredientsDTO;
import by.pizzasp.ics.service.interfaces.IngredientsService;
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
public class IngredientsControllerTest {

    public static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private IngredientsService ingredientsService;


    @Test
    public void getAllOrOneIngredientsTest() throws Exception {

        LOGGER.info("getAllOrOneIngredientsTest started");

        IngredientsDTO first = new IngredientsDTO(new Long(1L),"name_ingredient_1",new Long(1L),null);
        IngredientsDTO second=new IngredientsDTO(new Long(2L),"name_ingredient_2",new Long(2L),null);
        IngredientsDTO third=new IngredientsDTO(new Long(3L),"name_ingredient_3",new Long(3L),null);
        List<IngredientsDTO> all= Arrays.asList(first,second,third);

        LOGGER.info("getOneIngredientsTest started");

        IngredientsDTO actual =ingredientsService.getIngredient(new Long(1L));
        IngredientsDTO notActual=ingredientsService.getIngredient(new Long(2L));
        Assert.assertEquals(first.toString(),actual.toString());
        Assert.assertNotEquals(first.toString(),notActual.toString());

        LOGGER.info("getAllIngredientsTest started");

        List<IngredientsDTO> actualAll=ingredientsService.getAllIngredients();
        Assert.assertEquals(all.toString(),actualAll.toString());
        Assert.assertNotEquals(all.toString(), notActual.toString());

        LOGGER.info("getAllOrOneIngredientsTest finished");


    }
    @Test
    public void addNewIngredientTest() throws Exception{

        LOGGER.info("addNewIngredientsTest started");

        IngredientsDTO first = new IngredientsDTO(new Long(4L),"name_ingredient_4",new Long(4L),null);

        Long id=ingredientsService.addNewIngredient(first);
        IngredientsDTO actual=ingredientsService.getIngredient(id);
        IngredientsDTO notActual =ingredientsService.getIngredient(3L);
        Assert.assertEquals(first.toString(),actual.toString());
        Assert.assertNotEquals(first.toString(),notActual.toString());

        LOGGER.info("addNewIngredientsTest finished");
    }

    @Test
    public void changePricePerKgTest() throws Exception{

        LOGGER.info("changePricePerKgTest started");

        IngredientsDTO first = new IngredientsDTO(new Long(1L),"name_ingredient_1",new Long(15L),null);
        ingredientsService.changePricePerKg(first.getId(),first.getPricePerKg());
        IngredientsDTO actual = ingredientsService.getIngredient(first.getId());
        IngredientsDTO notActual =ingredientsService.getIngredient(3L);
        Assert.assertEquals(first.getPricePerKg(),actual.getPricePerKg());
        Assert.assertNotEquals(first.getPricePerKg(), notActual.getPricePerKg());

        LOGGER.info("changePricePerKgTest finished");
    }
}
