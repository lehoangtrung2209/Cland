<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<form action="" method=post enctype="multipart/form-data">
                <div class="row">
                    <div class="col-md-12 panel-info">
                        <div class="content-box-header panel-heading">
                            <div class="panel-title ">Thêm tin</div>
                        </div>
                        <div class="content-box-large box-with-header">
                            <div>
                                <div class="row mb-10"></div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="name">Tên tin</label>
                                            <input type="text" name="name" class="form-control" placeholder="Nhập tên tin" value="${news.name}">
                                            <form:errors path="news.name" style="color:red;"></form:errors>
                                        </div>

                                        <div class="form-group">
                                            <label>Danh mục tin</label>
                                            <select name="cid" class="form-control">
                                            <c:forEach var="category" items="${listCategory }">
											   <option value="${category.id}">${category.name}</option>
											</c:forEach>
											</select>
                                        </div>

                                        <div class="form-group">
                                            <label>Thêm hình ảnh</label>
                                            <input type="file" name="hinhanh" class="btn btn-default" id="exampleInputFile1">
                                            <p class="help-block"><em>Định dạng: jpg, png, jpeg,...</em></p>
                                        </div>                                       
                                    </div>
                                    <div class="form-group col-sm-12">
                                            <label>Chi tiết tin</label>
                                            <textarea name="description" class="form-control description" id="description" rows="3">${news.description}</textarea>
                                        	<form:errors path="news.description" style="color:red;"></form:errors>
                                        </div>
										<script>
								           var editor = CKEDITOR.replace('description');
								           CKFinder.setupCKEditor(editor,  '<%=request.getContextPath()%>/templates/admin/js/ckfinder/');
										</script>
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
                <!-- /.row col-size -->
