<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
		<form action="" method="post">
                <div class="row">
                    <div class="col-md-12 panel-info">
                        <div class="content-box-header panel-heading">
                            <div class="panel-title ">Thêm block</div>
                        </div>
                        <div class="content-box-large box-with-header">
                            <div>
                                <div class="row mb-10"></div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="name">Tên block</label>
                                            <input type="text" class="form-control" name="blockname" placeholder="Nhập vào tên block">
                                        	<form:errors path="block.blockname" style="color:red;"></form:errors>
                                        </div>
                               		
                               		<div class="form-group">
                                            <label>Tên dự án</label>
                                            <select name="pid" class="form-control">
                                            <c:forEach var="project" items="${listProject }">
											   <option value="${project.id}">${project.name}</option>
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
