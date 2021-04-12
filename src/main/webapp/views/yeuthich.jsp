<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yêu thích</title>
</head>
<body>
        <div class="container-fluid padding m-5">
            <div class="row welcome text-center ">
                <div class="mx-auto">
                    <img src="${ user.avatar }" alt="avt" height="200px">
                </div>
                <div class="col-12">
                    <h1 class="display-4">${ user.fullname }</h1>
                </div>
                <!-- Horizontal Rule -->
                <hr> 
                
            </div>
        </div>
        <div class="container row">
            <div class="col-md-3">
                
            </div>
            <div class="col-md-9">
    	        <h1 class="">Bài viết đã yêu thích</h1>
            </div>
        </div>
        <hr>
</body>
</html>