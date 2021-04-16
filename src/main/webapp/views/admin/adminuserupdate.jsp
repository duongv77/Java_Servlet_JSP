<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="./css/style.css" rel="stylesheet">
<script src="https://use.fontawesome.com/036b4f2931.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="/ASSM/admin">ADMIN</a></li>
				<li class="nav-item home"><a class="nav-link"
					href="/ASSM/admin/user">User</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ASSM/admin/baiviet">Bài viết</a></li>
				<li class="nav-item"><a class="nav-link" href="/ASSM/home">Home</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<br>
	<div class = "row">
		<div class="col-xl-2 col-md-3 mb-4">
			<div class="card border-left-primary shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-primary text-uppercase mb-1">
								User admin :</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">${ user.fullname }</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xl-8 col-md-7 mb-12">
			<form action="/ASSM//admin/user/update">

				<div class="col-md-3"></div>
				<div class="col-md-9">
					<h4 class="">Thay đổi thông tin User</h4>
				</div>
				<hr>

				<div class="form-group">
					<label for="fullname">Họ và tên</label> <input type="text"
						value="${ entityUser.fullname }" class="form-control" id="fullname"
						name="fullname" aria-describedby="emailHelp"
						placeholder="Nhập họ tên. . . ">
				</div>
				<div class="form-group">
					<label for="password">Mật khẩu</label> <input type="password"
						value="${ entityUser.password }" class="form-control form-control-user"
						id="password" name="password" placeholder="Nhập mật khẩu...">
				</div>
				<div class="from-group">
					<label>Ảnh đại diện</label> <input class="form-control" type="file"
						name="avatar">
				</div>
				<br>
				<button type="submit" class="btn btn-outline btn-hover">
					Thay đổi</button>
				<div class="modal fade" id="thaydoiuser" role="dialog"
					aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">

							<div class="modal-header">
								<h5 class="modal-title">Xác nhận thay đổi?</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>

							<div class="modal-body">Sau khi thay đổi sẽ không thể khôi
								phục lại.Bạn vẫn muốn tiếp tục ??</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Đóng</button>
								<button type="submit" class="btn btn-primary">Tiếp tục</button>
							</div>

						</div>
					</div>
				</div>

		</form>
		</div>
	</div>
	
</body>
</html>