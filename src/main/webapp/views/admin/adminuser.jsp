<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lí user</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">       
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link href="./css/style.css" rel="stylesheet">
	<script src="https://use.fontawesome.com/036b4f2931.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	    <li class="nav-item active">
	        <a class="nav-link" href="/ASSM/admin">ADMIN</a>
	      </li>
	  	  <li class="nav-item home">
	        <a class="nav-link" href="/ASSM/admin/user">User</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="ASSM/admin/baiviet">Bài viết</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/ASSM/home">Home</a>
	      </li>
	    </ul>
	    <form class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="search" placeholder="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	    </form>
	  </div>
	</nav>
	<br>
	<div class="row">
		<div class="col-xl-3 col-md-4 mb-4">
	        <div class="card border-left-primary shadow h-100 py-2">
				<div class="card-body">
	                  <div class="row no-gutters align-items-center">
	                       <div class="col mr-2">
	                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
	                                 User admin :
	                            </div>
	                            <div class="h5 mb-0 font-weight-bold text-gray-800">${ user.fullname }</div>
	                       </div>
	                   </div>
	              </div>
	       </div>
	       <c:if test="${ deleteOke==1 }">
	       <div>
	            <div class="alert alert-success">
		                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
		                    ×</button>
		               <span class="glyphicon glyphicon-ok"></span> <strong>Success Delete</strong>
		                <hr class="message-inner-separator">
		                <p>
		                    Bạn đã xóa thành công.</p>
		            </div>
		        </div>
	       </c:if>
	   	</div>
   		<div class="col-xl-9 col-md-8">
   			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Tên</th>
			      <th scope="col">Email</th>
			      <th scope="col">Ảnh đại diện</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${ listUser }" var="listUser">
			  	<tr>
			      <th scope="row">${ listUser.id }</th>
			      <td>${ listUser.fullname }</td>
			      <td>${ listUser.email }</td>
			      <td>${ listUser.avatar }</td>
			      <td>
			      	<a href="/ASSM/admin/user/update?id=${ listUser.id }">
				      	<button type="button" class="btn btn-success">
							<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
						</button>
			      	</a>
					<a href="/ASSM/admin/user/delete?id=${ listUser.id }">
						<button type="button" class="btn btn-danger">
							<i class="fa fa-trash-o" aria-hidden="true"></i>
						</button>
					</a>
				 </td>
			    </tr>
			  </c:forEach>
			    
			  </tbody>
			</table>
   		</div>
	</div>
</body>
</html>