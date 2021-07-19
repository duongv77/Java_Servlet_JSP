<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>

<div id="slide" class="carousel slide" data-ride="carousel">
	<ul class="carousel-indicators">
		<li data-target="#slide" data-slide-to="0" class="active"></li>
		<li data-target="#slide" data-slide-to="1" ></li>
		<li data-target="#slide" data-slide-to="2" ></li>
		<li data-target="#slide" data-slide-to="3" ></li>
	</ul>
	<div class="carousel-inner" >
		<div class="carousel-item active">
			<img alt="" src="./anh/thanhtruot1.png">
		</div>
		<div class="carousel-item ">
			<img alt="" src="./anh/thanhtruot2.png">
		</div>
		<div class="carousel-item ">
			<img alt="" src="./anh/thanhtruot3.png">
		</div>
		<div class="carousel-item ">
			<img alt="" src="./anh/thanhtruot4.png">
		</div>
	</div>
</div>
<div class="container-fluid padding">
	<div class="row welcome text-center">
		<div class="col-12">
			<h1 class="display-4">Trang chủ</h1>
		</div>
		<!-- Horizontal Rule -->
		<hr> 
		
	</div>
</div>
<div class=" container">	
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
						<img src="imgs/${ ListVideo.poster }" class="img-fluid">
					</a>
						
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-11 col-lg-9">
						<c:choose>
							<c:when test="${ user !=  null }">
								<a href="/ASSM/likevideo?id=${ ListVideo.id }" >
								<button type="button" class="btn btn-outline">
									<img alt="" src="./anh/like.png" height="20px">Like
								</button>
									
								</a>
								<a href="/ASSM/sendmail?id=${ ListVideo.id }">
									<button type="button"  class="btn btn-primary btn-hover">
										<img alt="" src="./anh/share.png" height="20px">Share
									</button>
								</a>
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
					<div class="col-md-1 col-lg-3 ">
						<p>${ ListVideo.views } Lượt xem</p>
					</div>
				</div>
				
			</div>		
			<hr>	
	</c:forEach>
</div>
<div class="container">
	<ul class="pagination mx-auto">
	<c:if test="${ page>1 }">
		<li class="page-item ">
			<a href="/ASSM/home?page=${ page-1 }" class="btn btn-outline-secondary">&laquo;</a>
		</li>
	</c:if>
		
		<li class="page-item">
			<a class="btn btn-outline-secondary">${ page }</a>
		</li>
		<li class="page-item">
			<a  href="/ASSM/home?page=${ page+1 }" class="btn btn-outline-secondary">&raquo;</a>
		</li>
	</ul>	
</div>
<div class="modal fade" id="acount" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
        
            <div class="modal-header">
                <h5 class="modal-title">Bạn chưa đăng nhập</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            
            <div class="modal-body">
                Vui lòng đăng nhập để sử dụng chức năng này !!
            </div>
            
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                 <a class="btn btn-primary" href="/ASSM/dangnhap">Đăng nhập</a>
            </div>
            
        </div>
    </div>
</div>
</body>
</html>