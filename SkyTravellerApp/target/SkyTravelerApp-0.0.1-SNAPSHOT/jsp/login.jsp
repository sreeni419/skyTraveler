
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">



<title>Login Page</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<h2>Login Form</h2>
	<form action="Travellogin" method="POST" style="border: 1px solid #ccc">
		<div class="container">
			<label for="travelerId"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="travelerId" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>
			<button type="submit">Login</button>
			
		</div>
		<span class="login-box-options"> New User? <a
			href="./signup" style="margin-left: 30px;">Sign-up!</a>
		</span>
<br><br>
		<span class="login-box-options"> 
			Home Page ?<a href="./" style="margin-left: 30px;">Cancel</a>
		</span>
		<br>
	</form>

</body>
</html>
