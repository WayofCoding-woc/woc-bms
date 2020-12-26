<%@ include file="fragment/header.jspf"%>

<div style="text-align:center">
    <h3>Ticket Booking History</h3>
    <hr/>

    <div class="container">
        <table class="table table-hover table-dark table-responsive-xl" style="font-size: 14px;">
            <thead>
                <tr>
                    <th>Seat</th>
                    <th>Category</th>
                    <th>Ticket Number</th>
                    <th>Show Date</th>
                    <th>Show Time</th>
                    <th>Theatre Name</th>
                    <th>Movie Name</th>
                    <th>Booking Date</th>
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
                            <td>
                                <div><fmt:formatDate type="date" value="${tb.date}" /></div>
                            </td>
                            <td>
                                <div>${tb.showTime.showTime}</div>
                            </td>
                             <td>
                                <div>${tb.showTime.theatre.theatreName}</div>
                            </td>
                            <td>
                                <div>${tb.showTime.movieName}</div>
                            </td>
                            <td>
                                <div>
                                    <fmt:formatDate pattern="dd MMM yyyy hh:mm:ss a" value="${tb.createdDate}" />
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
        </table>
    </div>

</div>

<%@ include file="fragment/footer.jspf"%>