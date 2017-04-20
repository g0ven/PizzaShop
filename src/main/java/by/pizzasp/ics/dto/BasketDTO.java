package by.pizzasp.ics.dto;


public class BasketDTO {
    Long goodPizzaId;
    String namePizza;
    Long pricePerPizza;

    public BasketDTO() {
    }

    public BasketDTO(Long goodPizzaId, String namePizza, Long pricePerPizza) {
        this.goodPizzaId = goodPizzaId;
        this.namePizza = namePizza;
        this.pricePerPizza = pricePerPizza;
    }

    public Long getGoodPizzaId() {
        return goodPizzaId;
    }

    public void setGoodPizzaId(Long goodPizzaId) {
        this.goodPizzaId = goodPizzaId;
    }

    public String getNamePizza() {
        return namePizza;
    }

    public void setNamePizza(String namePizza) {
        this.namePizza = namePizza;
    }

    public Long getPricePerPizza() {
        return pricePerPizza;
    }

    public void setPricePerPizza(Long pricePerPizza) {
        this.pricePerPizza = pricePerPizza;
    }

    @Override
    public String toString() {
        return "BasketDTO{" +
                "goodPizzaId=" + goodPizzaId +
                ", namePizza='" + namePizza + '\'' +
                ", pricePerPizza=" + pricePerPizza +
                '}';
    }
}
