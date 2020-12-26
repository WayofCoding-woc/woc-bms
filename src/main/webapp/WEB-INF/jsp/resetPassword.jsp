<%@ include file="fragment/nonLoggedInUserHeader.jspf"%>

<form action="/customer/resetPassword" method="post" onsubmit="return processForm();">
    <div align="center" class="container">
            <h3>Reset Password</h3>
            <div style="font-weight: bold; color: red;">${msg}</div>
            <table class="table table-hover table-dark table-responsive-xl" >
                <tr>
                    <td>LoginId:</td>
                    <td><input type="text" name="loginId" id="loginId" /></td>
                </tr>
                <tr>
                    <td>Old Password:</td>
                    <td><input type="password" name="old_password" id="old_password" /></td>
                </tr>
                <tr>
                    <td>New Password:</td>
                    <td><input type="password" name="new_password" id="new_password" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Reset" /></td>
                </tr>
            </table>
    </div>
</form>

<%@ include file="fragment/footer.jspf"%>

<script>
    function processForm(){
        var loginId = $('#loginId').val();
        var old_password = $('#old_password').val();
        var new_password = $('#new_password').val();

        if($.trim(loginId).length == 0){
            alert('loginId should not be empty');
            return false;
        }

        if($.trim(old_password).length == 0){
            alert('old_password should not be empty');
            return false;
        }

        if($.trim(new_password).length == 0){
            alert('new_password should not be empty');
            return false;
        }

        if(old_password == new_password){
            alert('old_password and new_password should not be same');
            return false;
        }

        return true;
    }

</script>

