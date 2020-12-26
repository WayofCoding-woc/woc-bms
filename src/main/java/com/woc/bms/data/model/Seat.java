package com.woc.bms.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "seat")
public class Seat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seat_number")
    private String seatNumber;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seat_category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_seat_category_id"))
    private SeatCategory seatCategory;

    @ManyToOne
    @JoinColumn(name="theatre_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_seat_theatre_id") )
    private Theatre theatre;

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatCategory=" + seatCategory +
                ", theatreId=" + theatre.getId() +
                '}';
    }
}
