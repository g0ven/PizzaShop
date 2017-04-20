package by.pizzasp.ics.dto;


public class CouponsDTO {
    Long id;
    String code;
    Long used;
    Long countDiscont;

    public  CouponsDTO(){};

    public CouponsDTO(Long id, String code, Long used, Long countDiscont) {
        this.id = id;
        this.code = code;
        this.used = used;
        this.countDiscont = countDiscont;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getUsed() {
        return used;
    }

    public void setUsed(Long used) {
        this.used = used;
    }

    public Long getCountDiscont() {
        return countDiscont;
    }

    public void setCountDiscont(Long countDiscont) {
        this.countDiscont = countDiscont;
    }

    @Override
    public String toString() {
        return "CouponsDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", used=" + used +
                ", countDiscont=" + countDiscont +
                '}';
    }
}
