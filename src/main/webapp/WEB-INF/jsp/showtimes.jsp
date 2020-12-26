<%@ include file="fragment/header.jspf"%>

<div style="text-align:center">
    <h3>Please select a showtime below</h3>

    <hr/>

    <div class="container">
        <table class="table table-hover table-dark">
            <thead>
                <tr>
                    <th>Show Time</th>
                    <th>Movie</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${showtimes}" var="showtime">
                    <tr>
                        <td>
                            <div style="padding:10px;"><a href="/seat/showtime/${showtime.id}" >${showtime.showTime}</a></div>
                        </td>
                        <td>
                            <div style="padding:10px;"><a href="/seat/showtime/${showtime.id}" >${showtime.movieName}</a></div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<%@ include file="fragment/footer.jspf"%>