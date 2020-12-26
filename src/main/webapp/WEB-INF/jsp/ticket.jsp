<%@ include file="fragment/header.jspf"%>

<div style="text-align:center">
    <h3>Congratulation! Your tickets have been booked successfully.</h3>
    <hr/>
    <h3>Ticket Itinerary</h3>
    <%@ include file="fragment/theatreShowDetails.jspf"%>

    <div class="container">
        <table class="table table-hover table-dark">
            <thead>
                <tr>
                    <th>Seat Number</th>
                    <th>Seat Category</th>
                    <th>Ticket Number</th>
                </tr>
            </thead>
            <tbody>
                <tbody>
                    <c:forEach items="${ticketsBooking}" var="tb">
                        <tr>
                            <td>
                                ${tb.seat.seatNumber}
                            </td>
                            <td>
                                ${tb.seat.seatCategory.categoryName}
                            </td>
                            <td>
                                ${tb.ticketReferenceNumber}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
        </table>
    </div>

</div>

<%@ include file="fragment/footer.jspf"%>