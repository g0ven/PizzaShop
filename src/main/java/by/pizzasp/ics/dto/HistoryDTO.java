package by.pizzasp.ics.dto;


import java.sql.Timestamp;

public class HistoryDTO {
    Long goodPizzaId;
    String namePizza;
    Long pricePerPizza;
    Timestamp timeOrder;

    public HistoryDTO() {
    }

    public HistoryDTO(Long goodPizzaId, String namePizza, Long pricePerPizza, Timestamp timeOrder) {
        this.goodPizzaId = goodPizzaId;
        this.namePizza = namePizza;
        this.pricePerPizza = pricePerPizza;
        this.timeOrder = timeOrder;
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

    public Timestamp getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Timestamp timeOrder) {
        this.timeOrder = timeOrder;
    }

    @Override
    public String toString() {
        return "HistoryDTO{" +
                "goodPizzaId=" + goodPizzaId +
                ", namePizza='" + namePizza + '\'' +
                ", pricePerPizza=" + pricePerPizza +
                ", timeOrder=" + timeOrder +
                '}';
    }
}
