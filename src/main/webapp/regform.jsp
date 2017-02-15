<! DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./styles/fdm_blog.css">
<meta ="" charset="UTF8">
<title>regform</title>
</head>
<body>

	<h1>Create a new Account</h1>
	<form method="POST" action="SignUpController" class="form">
		<label>Email Address or User Name</label>
		<br>
		<input type="text" name="email" required class="inputbox" />
		<br>
		<label>Password</label>
		<br>
		<input type="password" name="password" required class="inputbox" />
		<br>
		<label>Confirm Password</label>
		<br>
		<input type="password" name="passwordcon" required class="inputbox" />
		<br>
		<label>Post Code</label>
		<br>
		<input type="text" name="postcode" required class="inputbox" />
		<br> 
		<label>House Number or Name</label>
		<br>
		<input type="text" name="house" required class="inputbox" /> 
		<br>
		<input type="submit" id="Create account" value="Create Account" />
	</form>
</body>

</html>