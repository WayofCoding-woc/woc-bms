package com.woc.bms.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "show_time")
public class ShowTime implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "show_time")
    private String showTime;

    @Column(name = "movie_name")
    private String movieName;

    @ManyToOne
    @JoinColumn(name = "theatre_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_show_time_theatre_id"))
    private Theatre theatre;

    @Override
    public String toString() {
        return "ShowTime{" +
                "id=" + id +
                ", showTime='" + showTime + '\'' +
                ", movieName='" + movieName + '\'' +
                ", theatreId=" + theatre.getId() +
                '}';
    }

}
