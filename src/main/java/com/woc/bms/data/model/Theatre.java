package com.woc.bms.data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "theatre")
public class Theatre implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "theatre_code")
    private String theatreCode;

    @Column(name = "theatre_name")
    private String theatreName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_theatre_city_id"))
    private City city;

    //@OneToMany(cascade = CascadeType.ALL, targetEntity = ShowTime.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatre")
    private List<ShowTime> showTimes;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatre")
    private List<Seat> seats;

    @Override
    public String toString() {
        return "Theatre{" +
                "id=" + id +
                ", theatreCode='" + theatreCode + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", city=" + city +
                ", showTimes=" + showTimes +
                ", seats=" + seats +
                '}';
    }

}
