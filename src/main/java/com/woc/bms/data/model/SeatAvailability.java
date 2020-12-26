package com.woc.bms.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "seat_availability")
public class SeatAvailability implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "availability_date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "show_time_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_seat_availability_show_time_id"))
    private ShowTime showTime;

    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_seat_availability_seat_id"))
    private Seat seat;

    @Column(name = "is_available")
    private Boolean available;

    @Version
    private Long version;

    @Override
    public String toString() {
        return "SeatAvailability{" +
                "id=" + id +
                ", date=" + date +
                ", showTime=" + showTime +
                ", seat=" + seat +
                ", available=" + available +
                ", version=" + version +
                '}';
    }
}
