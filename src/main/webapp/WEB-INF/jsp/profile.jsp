<%@ include file="fragment/header.jspf"%>

<div align="center" class="container">
    <h3>Profile Details</h3>
        <table class="table table-hover table-dark table-responsive-xl" style="font-size: 14px;">
            <tr>
                <th>Login Id:</th>
                <td><div id="userDisplayId"> ${customer.loginId}</div></td>
            </tr>
            <tr>
                <th>Name:</th>
                <td><div id="user_name">${customer.name}</div></td>
            </tr>
            <tr>
                <th>Email:</th>
                <td><div id="email">${customer.email}</div></td>
            </tr>
            <tr>
                <th>Mobile:</th>
                <td><div id="mobile">${customer.mobile}</div></td>
            </tr>
            <tr>
                <th>Created Date:</th>
                <td>
                    <div id="created_date">
                        <fmt:formatDate pattern="dd MMM yyyy hh:mm:ss a" value="${customer.createdDate}" />
                    </div>
                </td>
            </tr>
        </table>
</div>

<%@ include file="fragment/footer.jspf"%>