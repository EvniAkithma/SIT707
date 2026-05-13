<html>
<body>

<h2>Login</h2>

<div>${message}</div><br/><br/>

<form action="/login" method="post">

  <label for="username">User name:</label><br>
  <input type="text" id="username" name="username"><br>

  <label for="passwd">Password:</label><br>
  <input type="password" id="passwd" name="passwd"><br>

  <label for="dob">DoB:</label><br>
  <input type="date" id="dob" name="dob"><br><br>

  <input type="submit" id="loginBtn" value="Login">

</form>

</body>
</html>