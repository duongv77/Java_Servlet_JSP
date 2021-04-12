<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài viết</title>
<body>
<form action="POST" action="/home">
	<div class="row">
		<div class="col-1"></div>
		<div class="col-10">
			<div class="container-fluid padding m-5">
				<div class="row padding">
					<div class="col-md-12 col-lg-6">
						<h2> ${ video.title }</h2>
						<p> ${ video.description } </p>
						
						<br>
					</div>
					<div class="col-lg-6">
						<img src=${ video.poster } class="img-fluid">
					</div>
				</div>
				<button type="button" class="btn btn-outline" >
					<img alt="" src="./anh/like.png" height="20px">Like
				</button>
				<button type="button"  class="btn btn-primary btn-hover"><img alt="" src="./anh/share.png" height="20px">Share</button>
			</div>
		</div>
		<div class="col-1"></div>
	</div>
</form>
</body>
</html>