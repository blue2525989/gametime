package com.bierbrauer.gametime.models.AdventureMessage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class AdventureMessage {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    public String message;

    // will use scale 0-5 for rarity, least to highest
    public Integer rarity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdventureMessage)) return false;
        AdventureMessage that = (AdventureMessage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(message, that.message) &&
                Objects.equals(rarity, that.rarity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, rarity);
    }

    @Override
    public String toString() {
        return "AdventureMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", rarity=" + rarity +
                '}';
    }
}
