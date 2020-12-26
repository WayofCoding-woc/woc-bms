<%@ include file="fragment/nonLoggedInUserHeader.jspf"%>

    <div style="text-align:center">
        <hr/>

        <div style="padding:10px;">
            <div style="margin-top:40px; font-weight: bold; color: green;">${msg}</div>
            <div style="margin-top:40px;">Existing Users? <a href="/login">SignIn</a></div>
            <div style="margin-top:40px;">New Users? <a href="/customer/signup">SignUp</a></div>
            <div style="margin-top:40px;">Forgot Password? <a href="/customer/resetPassword">Reset Password</a></div>
        </div>
    </div>

<%@ include file="fragment/footer.jspf"%>