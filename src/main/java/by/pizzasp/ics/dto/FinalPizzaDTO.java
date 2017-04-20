package by.pizzasp.ics.dto;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import java.util.List;

public class FinalPizzaDTO {
    private Long goodPizzaId;
    @Length(max = 40,message = "pizza name is very long, max 40")
    private String name;
    private Long basisPizzaId;
    @Max(value = 100,message = "radius is very big, max 100")
    private Long radius;
    private List<IngredientsDTO> ingredientsDTO;
    private Long wage;
    private Long price;

    public FinalPizzaDTO() {}

    public FinalPizzaDTO(Long goodPizzaId, String name, Long basisPizzaId, Long radius, List<IngredientsDTO> ingredientsDTO, Long wage, Long price) {
        this.goodPizzaId = goodPizzaId;
        this.name = name;
        this.basisPizzaId = basisPizzaId;
        this.radius = radius;
        this.ingredientsDTO = ingredientsDTO;
        this.wage = wage;
        this.price = price;
    }

    public Long getGoodPizzaId() {
        return goodPizzaId;
    }

    public void setGoodPizzaId(Long goodPizzaId) {
        this.goodPizzaId = goodPizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBasisPizzaId() {
        return basisPizzaId;
    }

    public void setBasisPizzaId(Long basisPizzaId) {
        this.basisPizzaId = basisPizzaId;
    }

    public Long getRadius() {
        return radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
    }

    public List<IngredientsDTO> getIngredientsDTO() {
        return ingredientsDTO;
    }

    public void setIngredientsDTO(List<IngredientsDTO> ingredientsDTO) {
        this.ingredientsDTO = ingredientsDTO;
    }

    public Long getWage() {
        return wage;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FinalPizzaDTO{" +
                "goodPizzaId=" + goodPizzaId +
                ", name='" + name + '\'' +
                ", basisPizzaId=" + basisPizzaId +
                ", radius=" + radius +
                ", ingredientsDTO=" + ingredientsDTO +
                ", wage=" + wage +
                ", price=" + price +
                '}';
    }
}
