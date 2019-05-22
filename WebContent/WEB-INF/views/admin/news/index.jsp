<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<div class="content-box-large">
                    <div class="row">
                        <div class="panel-heading">
                            <div class="panel-title ">Quản lý tin tức</div>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-md-8">
                            <a href="${pageContext.request.contextPath }/admin/news/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

                        </div>
                    </div>
					<c:if test="${not empty msg }">
						<div class="alert alert-success">
	  						<strong>${msg}</strong>
						</div>
					</c:if>
					<c:if test="${not empty err }">
						<div class="alert alert-success">
	  						<strong>${err}</strong>
						</div>
					</c:if>
                    <div class="row">
                        <div class="panel-body">
                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên tin</th>
                                        <th>Ngày đăng</th>
                                        <th>Danh mục</th>
                                        <th>Hình ảnh</th>
                                        <th>Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${listNews }" var="news">
                                	<c:set var="editUrl" value="${pageContext.request.contextPath }/admin/news/edit/${news.id }"></c:set>
                                	<c:set var="delUrl" value="${pageContext.request.contextPath }/admin/news/del/${news.id }"></c:set>
	                                    <tr class="odd gradeX">
	                                        <td width="10%">${news.id }</td>
	                                        <td width="25%">${news.name }</td>
	                                        <td width="20%">
	                                        	<fmt:formatDate value="${news.date_create }" pattern="HH:mm:ss dd/MM/yyyy"/>
	                                        </td>
	                                        <td class="center" width="10%">${news.cname }</td>
	                                        <td class="center text-center" width="10%">
	                                        	<c:choose>
	                                        		<c:when test="${not empty  news.picture}">
	                                        			<img width="100px" height="auto" src="${pageContext.request.contextPath}/upload/${news.picture }" />
	                                        		</c:when>
	                                            	<c:otherwise>
	                                            		Không có hình ảnh
	                                            	</c:otherwise>
	                                            </c:choose>
	                                        </td>
	                                        <td class="center text-center" width="15%">
	                                            <a href="${editUrl }" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
	                                            <a href="${delUrl }" title="" onclick="return confirm('Bạn có chắn chắn muốn xóa?')" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
	                                        </td>
	                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                            <!-- Pagination -->
                            <c:set var="urlPage" value="${pageContext.request.contextPath }/admin/news"></c:set>
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