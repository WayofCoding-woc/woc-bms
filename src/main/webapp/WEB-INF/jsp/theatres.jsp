<%@ include file="fragment/header.jspf"%>

<div style="text-align:center">
<h3>Please select a theatre</h3>

<hr/>

<c:forEach items="${theatres}" var="theatre">
    <div style="padding:10px;"><a href="/showtime/theatre/${theatre.theatreCode}" >${theatre.theatreName}</a></div>
</c:forEach>

</div>

<%@ include file="fragment/footer.jspf"%>