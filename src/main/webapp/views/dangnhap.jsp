<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<!-- Custom fonts for this template-->
    <link href="./css/cssDN/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="./css/cssDN/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body  class="bg-gradient-primary">
    <div  class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <img alt="duong2" src="./anh/duong2.png" class="col-lg-6 d-none d-lg-block ">
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                    </div>
                                    <c:if test="${ checkCreateUserSuccess == 1  }">
                                    	<div class="alert alert-success" role="alert">
										  Đăng kí thành công !
										</div>
                                    </c:if>
                                    <c:if test="${ resetMK == 1 }">
	                                    <div class="alert alert-info" role="alert">
										  Mật khẩu của bạn đã được thay đổi. Bạn vui lòng đăng nhập vào gmail của mình để nhận lại mật khẩu.
										</div>
                                    </c:if>
                                    
                                    <form class="user" method="POST" action="/ASSM/dangnhap">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="email" name="email" aria-describedby="emailHelp"
                                                placeholder="Nhập email...">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="password" name="password" placeholder="Nhập mật khẩu...">
                                        </div>
                                        <c:if test="${ error == 1}">
	                                        <div class="alert alert-danger" role="alert">
											  Tài khoản hoặc mật khẩu không chính xác!
											</div>
                                        </c:if>
                                        <c:if test="${ checkForm == 1}">
	                                        <div class="alert alert-danger" role="alert">
											  Không được để trống !
											</div>
                                        </c:if>
                                        
                                        <button type="submit" class="btn btn-primary btn-user btn-block">
                                            Đăng nhập
                                        </button>
                                        
                                    </form>
                                    
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="/ASSM/khoiphucuser">Bạn quên mật khẩu?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="/ASSM/taotaikhoan">Đăng kí!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
</body>
</html>