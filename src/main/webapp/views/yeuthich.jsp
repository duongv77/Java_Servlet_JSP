<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
	<div class= "container">
		<c:forEach items="${ ListVideo }" var="ListVideo">
			<div class="container-fluid padding">
				<div class="row padding">
					<div class="col-md-12 col-lg-6">
						<h2> ${ ListVideo.title }</h2>
						<p> ${ ListVideo.description } </p>
						<p>Id bài viết : ${ ListVideo.id } </p>
						<br>
					</div>
					<div class="col-lg-6">
					<a href="/ASSM/chitietbaiviet?id=${ ListVideo.id }">
						<img src=${ ListVideo.poster } class="img-fluid">
					</a>
						
					</div>
				</div>
				<c:choose>
					<c:when test="${ user !=  null }">
						<a href="/ASSM/likevideo?id=${ ListVideo.id }" >
						<button type="button" class="btn btn-outline">
							<img alt="" src="./anh/like.png" height="20px">DisLike
						</button>
							
						</a>
						<button type="button"  class="btn btn-primary btn-hover" >
							<img alt="" src="./anh/share.png" height="20px">Share
						</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-outline" data-toggle="modal" data-target="#acount">
							<img alt="" src="./anh/like.png" height="20px">Like
						</button>
						<button type="button"  class="btn btn-primary btn-hover" data-toggle="modal" data-target="#acount">
							<img alt="" src="./anh/share.png" height="20px">Share
						</button>
					</c:otherwise>
				</c:choose>
			</div>		
			<hr>	
		</c:forEach>	
	</div>
</body>
</html>