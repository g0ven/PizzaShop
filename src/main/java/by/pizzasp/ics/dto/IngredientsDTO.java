package by.pizzasp.ics.dto;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;

public class IngredientsDTO {

    Long id;
    @Length(max=40, message = "ingredients name is very long, max 40")
    String name;
    Long pricePerKg;
    @Max(value = 100,message = "ingredient wage is very big, max 100")
    Long wage;

    public IngredientsDTO() {}

    public IngredientsDTO(Long id, String name, Long pricePerKg, Long wage) {
        this.id = id;
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.wage=wage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(Long pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public Long getWage() {
        return wage;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "IngredientsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerKg=" + pricePerKg + '}';
    }
}
