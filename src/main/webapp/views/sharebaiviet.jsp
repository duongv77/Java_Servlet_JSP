<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">       
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link href="./css/style.css" rel="stylesheet">
	<script src="https://use.fontawesome.com/036b4f2931.js"></script>
<title>Email</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-light sticky-top">
	<div class="container-fluid">
		<a class="navbar-branch" href="#" type="button" data-toggle="collapse" 
			data-target="#navbarResponsive2">
			<img alt="" src="imgs/${ user.avatar }" height="40">
			 
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" 
			data-target="#navbarResponsive">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<c:if test="${ user.admin==1 }">
					<li class="nav-item">
						<a class="nav-link active" href="/ASSM/thembaiviet">Thêm bài viết</a>
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
							<a class="nav-link" href="#" data-toggle="modal" data-target="#dangxuat">
		                         Đăng xuất
		                    </a>
						</li>
					</c:otherwise>
				</c:choose>
				
				
			</ul>
		</div>
	</div>
</nav>

	<div class="container" style="margin-top: 10px;">
		<div class="row"
			style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
			<div class="col-sm-12">
				<h2 class="myclass">Information</h2>
				<form action="/ASSM/sendmail" method="post">
					<div class="form-group">
						<div class="form-group">
							<label>Người gửi:</label> 
							<input type="text"
							class="form-control" name="nguoigui" placeholder="Enter Email">
						</div>
						<label>To:</label> 
						<input type="text"
						class="form-control" name="nguoinhan" placeholder="Enter Email">
					</div>
					
					<div class="form-group">
						<label>Subject:</label> 
						<input type="text" class="form-control" name="tieude" placeholder="Enter Subject">
					</div>
					<div class="form-group">
						<label for="content">Content:</label>
						<textarea class="form-control" rows="3"  name="noidung">${ video.linkvideo }</textarea>
					</div>
					<button type="submit" class="btn btn-primary">Send</button>
					<button type="reset" class="btn btn-primary">Cancel</button>
				</form>
			</div>
		</div>
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
<div class="modal fade" id="dangxuat" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
        
            <div class="modal-header">
                <h5 class="modal-title">Bạn muốn đăng xuất?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            
            <div class="modal-body">
                Chọn "Đăng xuất" bên dưới nếu bạn đã sẵn sàng kết thúc phiên hiện tại của mình.
            </div>
            
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                 <a class="btn btn-primary" href="/ASSM/dangxuat">Đăng xuất</a>
            </div>
            
        </div>
    </div>
</div>
</body>
</html>