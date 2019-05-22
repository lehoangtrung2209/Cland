<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<div class="content-box-large">
                    <div class="row">
                        <div class="panel-heading">
                            <div class="panel-title ">Quản lý Block</div>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-md-8">
                            <a href="${pageContext.request.contextPath }/admin/blocks/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

                        </div>
                    </div>
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
                        <div class="panel-body">
                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên dự án</th>
                                        <th>Tên block</th>
                                        <th>Chức năng</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${listItem}" var="item">
                                <c:set var="editUrl" value="${pageContext.request.contextPath }/admin/blocks/edit/${item.id }"></c:set>
                                <c:set var="delUrl" value="${pageContext.request.contextPath }/admin/blocks/del/${item.id }"></c:set>
	                                <tbody>
	                                    <tr class="odd gradeX">
	                                        <td>${item.id }</td>
	                                        <td>${item.pname }</td>
	                                        <td>${item.blockname }</td>
	                                        <td class="center text-center" width="20%">
	                                            <a href="${editUrl }" title="Sửa" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
	                                            <a href="${delUrl }" title="Xóa" onclick="return confirm('Bạn có chắn chắn muốn xóa?')" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
	                                        </td>
	                                    </tr>
	                                </tbody>
                                </c:forEach>
                            </table>

                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.content-box-large -->