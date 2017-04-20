package by.pizzasp.ics.dto;


import javax.validation.constraints.Max;

public class BasisPizzaDTO {
    Long id;
    @Max(value = 100,message = "radius is very big, max 100")
    Long radius;
    @Max(value = 100, message = "wage basis is very big, max 100")
    Long wage;
    Long price;

    public BasisPizzaDTO() {}

    public BasisPizzaDTO(Long id, Long radius, Long wage, Long price) {
        this.id = id;
        this.radius = radius;
        this.wage = wage;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRadius() {
        return radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
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
        return "BasisPizzaDTO{" +
                "id=" + id +
                ", radius=" + radius +
                ", wage=" + wage +
                ", price=" + price +
                '}';
    }
}
