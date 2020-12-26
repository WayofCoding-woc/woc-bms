<%@ include file="fragment/header.jspf"%>

<div style="text-align:center">
    <h3>Review your cart</h3>
    <hr/>
    <%@ include file="fragment/theatreShowDetails.jspf"%>

    <form action="/book" method="post">
        <div class="container">
            <table class="table table-hover table-dark">
                <thead>
                    <tr>
                        <th>Seat Number</th>
                        <th>Seat Category</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${seatAvailabilities}" var="sa">
                        <tr>
                            <td>
                                ${sa.seat.seatNumber}
                            </td>
                            <td>
                                ${sa.seat.seatCategory.categoryName}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div>
            <input type="hidden" id="customerId" name="customerId" value="${sessionScope.customerId}" />
            <input type="hidden" id="seats_choosed" name="seats_choosed" value="${seats_choosed}" />
        </div>
        <div>
            <input type="submit" value="Checkout" />
        </div>
    </form>
</div>

<%@ include file="fragment/footer.jspf"%>