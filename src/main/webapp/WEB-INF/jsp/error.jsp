<%@ include file="fragment/header.jspf"%>

<div style="text-align:center">
<h3>Error Page</h3>

<hr/>

    <div style="padding:10px; color:red;">
        ${msg}
    </div>
    <div>
        ${exception}
    </div>
    <div>
        ${url}
    </div>

</div>

<%@ include file="fragment/footer.jspf"%>