package com.bierbrauer.gametime.models.adventureMessage;

import com.google.gson.Gson;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name="AdventureMessage")
public class AdventureMessage {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true)
    public String message;

    public Integer rarity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setRarity(Integer rarity) { this.rarity = rarity; }

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
    public String toString() { return new Gson().toJson(this); }
}
