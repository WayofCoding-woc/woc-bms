<%@ include file="fragment/nonLoggedInUserHeader.jspf"%>

<form action="/customer/register" method="post" onsubmit="return processForm();">
    <div align="center" class="container">
            <h3>Sign Up</h3>
            <table class="table table-hover table-dark table-responsive-xl" >
                <tr>
                    <td>LoginId:</td>
                    <td><input type="text" name="loginId" id="loginId" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" id="password" /></td>
                </tr>
                <tr>
                    <td>Confirm Password:</td>
                    <td><input type="password" name="confirm_password" id="confirm_password" /></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" name="name" id="user_name" /></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" id="email" /></td>
                </tr>
                <tr>
                    <td>Mobile:</td>
                    <td><input type="text" name="mobile" id="mobile" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
    </div>
</form>

<%@ include file="fragment/footer.jspf"%>


<script>
    function processForm(){
        var loginId = $('#loginId').val();
        var password = $('#password').val();
        var confirm_password = $('#confirm_password').val();

        if($.trim(loginId).length == 0){
            alert('loginId should not be empty');
            return false;
        }

        if($.trim(password).length == 0){
            alert('password should not be empty');
            return false;
        }

        if($.trim(confirm_password).length == 0){
            alert('confirm_password should not be empty');
            return false;
        }

        if(password != confirm_password){
            alert('password and confirm_password should match');
            return false;
        }

        if($.trim($('#user_name').val()).length == 0){
            alert('user_name should not be empty');
            return false;
        }
        if($.trim($('#email').val()).length == 0){
            alert('email should not be empty');
            return false;
        }
        if($.trim($('#mobile').val()).length == 0){
            alert('mobile should not be empty');
            return false;
        }

        return true;
    }

</script>

