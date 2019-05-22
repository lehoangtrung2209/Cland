<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<div class="content-box-large">
                    <div class="row">
                        <div class="panel-heading">
                            <div class="panel-title ">Quản lý liên hệ</div>
                        </div>
                    </div>
                    <hr>
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
                                        <th>Tên người liên hệ</th>
                                        <th>Email</th>
                                        <th>Chủ đề</th>
                                        <th>Liên hệ</th>
                                        <th>Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${listContact }" var="contact">
                                	<c:set var="delUrl" value="${pageContext.request.contextPath }/admin/contact/del/${contact.cid}"></c:set>
	                                    <tr class="odd gradeX">
	                                        <td width="10%">${contact.cid }</td>
	                                        <td width="20%">${contact.fullname }</td>
	                                        <td class="center" width="10%">${contact.email }</td>
	                                        <td class="center" width="10%">${contact.subject }</td>
	                                        <td class="center" width="35%">${contact.content }</td>
	                                        <td class="center text-center" width="15%">
	                                            <a href="${delUrl }" title="" class="btn btn-danger" onclick="return confirm('Bạn có chắn chắn muốn xóa?')"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
	                                        </td>
	                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                            <!-- Pagination -->
                            <c:url var="urlPage" value="/admin/contact"></c:url>
                            <nav class="text-center" aria-label="...">
                            <div class="pagination">
							   <nav>
							      <ul>
							         <c:if test="${not empty previous }">
							         	<li ><a href="${urlPage}/1">&lsaquo;&lsaquo;</a></li>
							            <li ><a href="${urlPage}/${previous}">&lsaquo;</a></li>
							         </c:if>
							         <c:forEach var="i" begin="${pageStart }" end="${pageEnd }">
							            <li 
							            <c:if test="${page == i }">style="font-weight:bold; font-size: 17px;"</c:if>
							            ><a href="${urlPage}/${i}">${i } </a></li>
							         </c:forEach>
							         <c:if test="${not empty next }">
							            <li ><a href="${urlPage}/${next}">&rsaquo;</a></li>
							            <li ><a href="${urlPage}/${sumPages}">&rsaquo;&rsaquo;</a></li>
							         </c:if>
							      </ul>
							   </nav>
							</div>
							</nav>
                            <!-- /.pagination -->

                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.content-box-large -->