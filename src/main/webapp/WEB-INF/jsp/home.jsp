<%@ include file="fragment/header.jspf"%>

<div style="text-align:center">
<h3>Please select you city</h3>

<hr/>

<c:forEach items="${cities}" var="city">
    <div style="padding:10px;"><a href="/theatres/city/${city.cityCode}" >${city.cityName}</a></div>
</c:forEach>

</div>

<%@ include file="fragment/footer.jspf"%>