package com.woc.bms.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "ticket_booking")
public class TicketBooking implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "show_time_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ticket_booking_show_time_id"))
    private ShowTime showTime;

    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ticket_booking_seat_id"))
    private Seat seat;

    @Column(name = "ticket_reference_number")
    private String ticketReferenceNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ticket_booking_customer_id"))
    private Customer customer;

    @Column(name = "created_date")
    private Date createdDate;

    @Override
    public String toString() {
        return "TicketBooking{" +
                "id=" + id +
                ", date=" + date +
                ", showTime=" + showTime +
                ", seat=" + seat +
                ", ticketReferenceNumber='" + ticketReferenceNumber + '\'' +
                ", customerId=" + customer.getId() +
                ", createdDate=" + createdDate +
                '}';
    }
}
