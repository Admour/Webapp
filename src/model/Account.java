package model;

import java.time.LocalDateTime;
import java.util.Date;

public class Account {
    public String getAcount() {
        return acount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    private Integer id;
    private String acount;
    private LocalDateTime create_at;
    private double amount;

}
