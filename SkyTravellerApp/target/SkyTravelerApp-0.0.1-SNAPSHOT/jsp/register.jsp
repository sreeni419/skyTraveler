

<!DOCTYPE html>
<html>
<head>
<title>sign-up Form</title>



<link href="/css/signup.css" rel="stylesheet" type="text/css" />

</head>

<body>


	<form action="signupService" method="POST"
		style="border: 1px solid #ccc">
		<div class="container">
			<h1>Sign Up</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>
			<label for="firstName"><b>First Name</b></label> <input type="text"
				placeholder="Enter your First Name" name="firstName" required>

			<label for="lastName"><b>Last Name</b></label> <input type="text"
				placeholder="Enter your last Name" name="lastName" required>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email" required> <label
				for="travelerid"><b>User Id</b></label> <input type="text"
				placeholder="Choose Any Name " name="travelerId" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required> <label
				for="psw-repeat"><b>Repeat Password</b></label> <input
				type="password" placeholder="Repeat Password" name="psw-repeat"
				required>
			<div class="clearfix">
				<button type="button" class="cancelbtn">Reset</button>
				<button type="submit" class="signupbtn">Sign Up</button>

			</div>
			<span class="login-box-options"> Already a member? <a
				href="./login" style="margin-left: 30px;">Login!</a>
			</span>
		</div>
	</form>
</body>
</html>






