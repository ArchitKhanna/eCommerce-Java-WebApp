<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
  <h2>Register</h2>
  <form class="form-horizontal" action="MainPage">
    <div class="form-group">
      <label class="control-label col-sm-2" for="fName">Full Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="fName" placeholder="Enter Full Name">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uName">Username:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="uName" placeholder="Enter Username">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uMobile">Mobile:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="uMobile" placeholder="Enter Mobile Number">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uPassword">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="uPassword" placeholder="Enter Password">
      </div>
    </div>
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Register</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>