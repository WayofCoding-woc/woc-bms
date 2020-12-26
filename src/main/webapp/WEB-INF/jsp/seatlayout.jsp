<%@ include file="fragment/header.jspf"%>

<div style="text-align:center;padding-bottom:35px;">
    <h3>Please choose seat(s)</h3>
    <hr/>
    <%@ include file="fragment/theatreShowDetails.jspf"%>

    <form action="/cartSummary" method="post" onsubmit="return validateData();">
        <div class="container">
                <table class="table table-hover table-dark">
                    <thead>
                        <tr>
                            <th>Show Date</th>
                            <th>Seat Category</th>
                            <th>Seat Number</th>
                            <th>Is Available?</th>
                            <th>Choose</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${seats}" var="s">
                            <tr>
                                <td>
                                    <fmt:formatDate type="date" value="${s.date}" />
                                </td>
                                <td>
                                    ${s.seat.seatCategory.categoryName}
                                </td>
                                <td>
                                    ${s.seat.seatNumber}
                                </td>
                                <td>
                                    ${s.available}
                                </td>
                                <td>
                                    <c:if test = "${s.available eq true}">
                                        <input type="checkbox" value="${s.id}" name="seat_choose" />
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </div>
        <div>
            <input type="hidden" id="seats_choosed" name="seats_choosed" value="" />
        </div>
        <div>
            <input type="submit" value="Proceed" />
        </div>
    </form>
</div>

<%@ include file="fragment/footer.jspf"%>

<script>
    function validateData(){
        let selectedSeats = [];
        $("input[name=seat_choose]").each(function(){
            if($(this).is(":checked")){
                selectedSeats.push($(this).val());
            }
        });

        if(selectedSeats.length === 0){
            alert('Please choose minimum one seat', 'Error');
            return false;
        }
        $('#seats_choosed').val(selectedSeats.toString());
        return true;
    }

</script>