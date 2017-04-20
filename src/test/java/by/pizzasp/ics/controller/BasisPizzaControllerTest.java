package by.pizzasp.ics.controller;

import by.pizzasp.ics.dto.BasisPizzaDTO;
import by.pizzasp.ics.service.interfaces.BasisPizzaService;
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
public class BasisPizzaControllerTest {

    public static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private BasisPizzaService basisPizzaService;


    @Test
    public void getAllOrOneBasisPizzaTest() throws Exception {

        LOGGER.info("getAllOrOneBasisPizzaTest started");

        BasisPizzaDTO first = new BasisPizzaDTO(new Long(1L), new Long(10L),new Long(10L), new Long(10L));
        BasisPizzaDTO second = new BasisPizzaDTO(new Long(2L), new Long(12L),new Long(12L), new Long(12L));
        BasisPizzaDTO third = new BasisPizzaDTO(new Long(3L), new Long(13L),new Long(13L), new Long(13L));
        List<BasisPizzaDTO> all= Arrays.asList(first,second,third);

        LOGGER.info("getOneBasisPizzaTest started");

        BasisPizzaDTO actual =basisPizzaService.getBasisPizza(new Long(1L));
        BasisPizzaDTO notActual=basisPizzaService.getBasisPizza(new Long(2L));
        Assert.assertEquals(first.toString(),actual.toString());
        Assert.assertNotEquals(first.toString(),notActual.toString());

        LOGGER.info("getAllBasisPizzaTest started");

        List<BasisPizzaDTO> actualAll=basisPizzaService.getAllBasisPizzas();
        Assert.assertEquals(all.toString(),actualAll.toString());
        Assert.assertNotEquals(all.toString(), notActual.toString());

        LOGGER.info("getAllOrOneBasisPizzaTest finished");


    }
    @Test
    public void addNewBasisPizzaTest() throws Exception{

        LOGGER.info("addNewBasisPizzaTest started");

        BasisPizzaDTO first = new BasisPizzaDTO(new Long(1L), new Long(10L),new Long(10L), new Long(10L));

        Long id=basisPizzaService.addNewBasisPizza(first);
        BasisPizzaDTO actual=basisPizzaService.getBasisPizza(id);
        BasisPizzaDTO notActual =basisPizzaService.getBasisPizza(3L);
        Assert.assertEquals(first.toString(),actual.toString());
        Assert.assertNotEquals(first.toString(),notActual.toString());

        LOGGER.info("addNewBasisPizzaTest finished");
    }

    @Test
    public void changePriceBasisPizzaTest() throws Exception{

        LOGGER.info("changePriceBasisPizzaTest started");

        BasisPizzaDTO first = new BasisPizzaDTO(new Long(1L), new Long(10L),new Long(10L), new Long(10L));
        basisPizzaService.changePriceBasisPizza(first.getId(),first.getPrice());
        BasisPizzaDTO actual = basisPizzaService.getBasisPizza(first.getId());
        BasisPizzaDTO notActual =basisPizzaService.getBasisPizza(3L);
        Assert.assertEquals(first.getPrice(),actual.getPrice());
        Assert.assertNotEquals(first.getPrice(), notActual.getPrice());

        LOGGER.info("changePriceBasisPizzaTest finished");
    }
}
