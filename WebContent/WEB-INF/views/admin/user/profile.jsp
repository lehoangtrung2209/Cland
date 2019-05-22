<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
		<form action="" method="post">
                <div class="row">
                    <div class="col-md-12 panel-info">
                        <div class="content-box-header panel-heading">
                            <div class="panel-title ">Profile</div>
                        </div>
                        <div class="content-box-large box-with-header">
                            <div>
                                <div class="row mb-10"></div>
								<c:if test="${not empty msg }">
									<div class="alert alert-success">
				  						<strong>${msg}</strong>
									</div>
								</c:if>
								<c:if test="${not empty err }">
									<div class="alert alert-danger">
				  						<strong>${err}</strong>
									</div>
								</c:if>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="username">Username</label>
                                            <input type="text" class="form-control" name="username" value="${userLogin.username }" readonly>
                                            <label for="password">Password</label>
                                            <input type="password" class="form-control" name="password" placeholder="Nhập vào password mới">
                                            <label for="fullname">Fullname</label>
                                            <input type="text" class="form-control" name="fullname" value="${userLogin.fullname }">
                                            <form:errors path="user.fullname" style="color:red;"></form:errors><br />
                                        </div>
                               		</div>
                                </div>

                                <hr>

                                <div class="row">
                                    <div class="col-sm-12">
                                        <input type="submit" value="Cập nhật" class="btn btn-success" />
                                        <input type="reset" value="Nhập lại" class="btn btn-default" />
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
          </form>
