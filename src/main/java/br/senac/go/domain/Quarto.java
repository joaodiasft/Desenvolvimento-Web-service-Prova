package br.senac.go.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "quarto")

public class Quarto extends BaseModel {
    private Integer numero;
    private Hotel hotel;

    public Quarto(Integer numero, Hotel hotel) {
        this.numero = numero;
        this.hotel = hotel;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Hotel setHotel() {
        return hotel;
    }

    public void setEndereco(Hotel hotel) {
        this.hotel = hotel;
    }

}
