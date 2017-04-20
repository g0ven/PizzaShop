package by.pizzasp.ics.dto;


import org.hibernate.validator.constraints.Length;

public class GoodPizzaDTO {
    Long id;
    @Length(max = 40,message = "pizza name is very long, max 40")
    String name;
    Long price;
    Long procValue;

    public GoodPizzaDTO(){}

    public GoodPizzaDTO(Long id, String name, Long price, Long procValue) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.procValue = procValue;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getProcValue() {
        return procValue;
    }

    public void setProcValue(Long procValue) {
        this.procValue = procValue;
    }

    @Override
    public String toString() {
        return "GoodPizzaDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", procValue=" + procValue +
                '}';
    }
}
