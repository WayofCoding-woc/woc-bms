package com.woc.bms.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "city")
public class City implements Serializable {
    private static final long serialVersionUID = 669197807587541661L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "city_name")
    private String cityName;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
