<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
		<form action="" method="post">
                <div class="row">
                    <div class="col-md-12 panel-info">
                        <div class="content-box-header panel-heading">
                            <div class="panel-title ">Thêm người dùng</div>
                        </div>
                        <div class="content-box-large box-with-header">
                            <div>
                                <div class="row mb-10"></div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="username">Username</label>
                                            <input type="text" class="form-control" name="username" placeholder="Nhập vào tên người dùng">
                                            <form:errors path="user.username" style="color:red;"></form:errors><br />
                                            <label for="password">Password</label>
                                            <input type="password" class="form-control" name="password" placeholder="Nhập vào mật khẩu"><br />
                                            <label for="fullname">Fullname</label>
                                            <input type="text" class="form-control" name="fullname" placeholder="Nhập vào họ và tên"><br />
                                            <form:errors path="user.fullname" style="color:red;"></form:errors><br />
                                            <label for="phone">Phone</label>
                                            <input type="text" class="form-control" name="phone" placeholder="Nhập vào số điện thoại"><br />
                                            <label for="email">Email</label>
                                            <input type="text" class="form-control" name="email" placeholder="Nhập vào email"><br />
                                            <label for="address">Address</label>
                                            <input type="text" class="form-control" name="address" placeholder="Nhập vào địa chỉ"><br />
                                            <label for="role">Phân quyền</label>
                                            <select name="role_id" class="form-control">
                                            	<c:forEach items="${listRole}" var="role">
                                            		<option value="${role.role_id }" >${role.name }</option>
                                            	</c:forEach>
                                            </select>
                                        </div>
                               		</div>
                                </div>

                                <hr>

                                <div class="row">
                                    <div class="col-sm-12">
                                        <input type="submit" value="Thêm" class="btn btn-success" />
                                        <input type="reset" value="Nhập lại" class="btn btn-default" />
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
          </form>
