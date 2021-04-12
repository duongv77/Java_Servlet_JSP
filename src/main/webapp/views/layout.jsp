<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<!-- Import Boostrap css, js, font awesome here -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">       
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link href="./css/style.css" rel="stylesheet">
</head>
<body>
<form action="POST" action="/home">
	
<nav class="navbar navbar-expand-md navbar-light sticky-top">
	<div class="container-fluid">
		<a class="navbar-branch" href="#" type="button" data-toggle="collapse" 
			data-target="#navbarResponsive2">
			<img alt="" src="./anh/duong.png" height="50">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" 
			data-target="#navbarResponsive">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<c:if test="${ user.admin==1 }">
					<li class="nav-item">
						<a class="nav-link active" href="/ASSM/home">Thêm bài viết</a>
					</li>
				</c:if>
				<li class="nav-item">
					<a class="nav-link active" href="/ASSM/home">Trang chủ</a>
				</li>
				<c:if test="${ user.admin!=null }">
					<li class="nav-item">
						<a class="nav-link" href="/ASSM/yeuthich">Yêu thích</a>
					</li>
				</c:if>
				
				<c:choose>
					<c:when test="${ user.admin ==  null }">
						<li class="nav-item">
							<a class="nav-link" href="/ASSM/dangnhap">Đăng nhập</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item">
							<a class="nav-link" href="#" data-toggle="modal" data-target="#logoutModal">
		                         Đăng xuất
		                    </a>
						</li>
					</c:otherwise>
				</c:choose>
				
				
			</ul>
		</div>
	</div>
</nav>
<div >
	<jsp:include page="${ views }" />
</div>


<div class="container-fluid padding">	
	<div class="row text-center padding">
		<div class="col-12">
			<h2>Contact us</h2>
		</div>
		<div class="col-12 social padding">
			<a href="https://www.facebook.com/duongdao22042001/"><i class="fab fa-facebook"></i></a>
			<a href="#"><i class="fab fa-twitter"></i></a>
			<a href="#"><i class="fab fa-google-plus-g"></i></a>
			<a href="https://www.instagram.com/duongdaov/"><i class="fab fa-instagram"></i></a>
			<a href="#"><i class="fab fa-youtube"></i></a>
		</div>
	</div>
</div>	
<footer>
	<div class="container-fluid padding">	
		<div class="row text-center">
			<div class="col-md-4">
				<hr class="light">
				<img src="./anh/duong.png" height="30px">
				<hr class="light">
				<p>22-04-2001</p>
				<p>duongdvph11989@fpt.edu.vn</p>
				<p>FPT POLYTECHNIC</p>
			</div>
			<div class="col-md-4">				
				<hr class="light">
				<h5>Working hours</h5>
				<hr class="light">
				<p>Monday-Friday: 8am - 5pm</p>
				<p>Weekend: 8am - 12am</p>
			</div>
			<div class="col-md-4">				
				<hr class="light">
				<h5>Services</h5>
				<hr class="light">
				<p>Outsourcing</p>
				<p>Website development</p>
				<p>Mobile applications</p>
			</div>
			<div class="col-12">
				<hr class="light-100">
				<h5>&copy; Dưỡng Đào</h5>
			</div>
		</div>
	</div>
</footer>
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Bạn muốn đăng xuất?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Chọn "Đăng xuất" bên dưới nếu bạn đã sẵn sàng kết thúc phiên hiện tại của mình.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Từ chối</button>
                    <a class="btn btn-primary" href="/ASSM/dangxuat">Đăng xuất</a>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>