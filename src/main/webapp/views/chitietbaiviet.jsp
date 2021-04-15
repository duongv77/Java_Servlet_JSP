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
	<c:if test="${ updateTC == 1 }">
		<div class="alert alert-success" role="alert">
		  Cập nhập thành công !!
		</div>
	</c:if>
	<div class="row">
		<div class="col-1"></div>
		<div class="col-10">
			<div class="container-fluid padding m-5">
				<div class="row padding">
					<div class="col-md-12 col-lg-6">
						<div class="row">
						<div class="col-6">
							<h1>Mã bài viết : ${ video.id }</h1>
						</div>
						</div>
						
						<h2> ${ video.title }</h2>
						<p> ${ video.description } </p>
						
						<br>
					</div>
					<div class="col-lg-6">
						<!--  <div class="row">
							<img src=${ video.poster } class="img-fluid">
						</div>-->
						<div class="row img-fluid">
							${ video.linkvideo }
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-lg-3">
						<c:choose>
							<c:when test="${ user !=  null }">
								<a href="/ASSM/likevideo?id=${ video.id }" >
									<button type="button" class="btn btn-outline">
										<img alt="" src="./anh/like.png" height="20px">Like
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
				
					<div class="col-md-7 col-lg-6">
					<c:if test="${ user.id == ADMIN }">
						<a href="/ASSM/updatebaiviet?id=${ video.id }">
							<button type="button" class="btn btn-outline" >
								 Update
							</button>
						</a>
						<button type="button"  class="btn btn-primary btn-hover" data-toggle="modal"  data-target="#delete" >Delete</button>
						
					</c:if>	
					</div>
					
					<div class="modal fade" id="delete" role="dialog" aria-hidden="true">
					    <div class="modal-dialog modal-dialog-centered">
					        <div class="modal-content">
					        
					            <div class="modal-header">
					                <h5 class="modal-title">Bạn muốn xóa bài viết ?</h5>
					                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					                    <span aria-hidden="true">&times;</span>
					                </button>
					            </div>
					            <div class="modal-footer">
					                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
					                <a href="/ASSM/chitietbaiviet/xoabaiviet?id=${ video.id }">
										<button type="submit" class="btn btn-primary" >Tiếp tục</button>
									</a>
					                 
					            </div>
					            
					        </div>
					    </div>
					</div>
					
					
					<div class="col-md-1 col-lg-3">
						<p>${ video.views } Lượt xem</p>
					</div>
				</div>
				
			</div>
		</div>
		<div class="col-1"></div>
	</div>
</form>
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