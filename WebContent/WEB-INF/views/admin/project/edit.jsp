<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<form action="" method="post" >
                <div class="row">
                    <div class="col-md-12 panel-info">
                        <div class="content-box-header panel-heading">
                            <div class="panel-title ">Sửa dự án</div>
                        </div>
                        <div class="content-box-large box-with-header">
                            <div>
                                <div class="row mb-10"></div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="name">Tên dự án</label>
                                            <input type="text" name="name" class="form-control" placeholder="Nhập tên dự án" value="${project.name}">
                                            <form:errors path="news.name" style="color:red;"></form:errors>
                                        </div>

                                         <div class="form-group">
                                            <label>Loại dự án</label>
                                            <select name="cid" class="form-control">
                                            <c:forEach var="category" items="${listCategory }">
											   <option <c:if test="${project.cid == category.id }">selected</c:if> value="${category.id}">${category.name}</option>
											</c:forEach>
											</select>
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-12">
                                            <label>Tổng quan</label>
                                            <textarea name="overview" class="form-control overview" id="overview" rows="3">${project.overview}</textarea>
                                        	<form:errors path="project.overview" style="color:red;"></form:errors>
                                    </div>
                                    <div class="form-group col-sm-12">
                                            <label>Vị trí</label>
                                            <textarea name="place" class="form-control place" id="place" rows="3">${project.place}</textarea>
                                        	<form:errors path="project.place" style="color:red;"></form:errors>
                                    </div>
										<script>
								           var editor1 = CKEDITOR.replace('overview');
								           CKFinder.setupCKEditor(editor1,  '<%=request.getContextPath()%>/templates/admin/js/ckfinder/');
								           var editor2 = CKEDITOR.replace('place');
								           CKFinder.setupCKEditor(editor2,  '<%=request.getContextPath()%>/templates/admin/js/ckfinder/');
										</script>
                                </div>
								  
                                <hr>

                                <div class="row">
                                    <div class="col-sm-12">
                                        <input type="submit" value="Sửa" class="btn btn-success" />
                                        <input type="reset" value="Nhập lại" class="btn btn-default" />
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
</form>
                <!-- /.row col-size -->
