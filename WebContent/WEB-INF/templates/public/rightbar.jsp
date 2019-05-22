<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<div class="clearfix sidebar">
						<div class="clearfix single_sidebar category_items">
							<h2>Danh mục bất động sản</h2>
							<ul>
								<c:forEach items="${listCategory }" var="category">
									<c:set value="${pageContext.request.contextPath }/${slugUtil.makeSlug(category.cname) }-${category.cid }" var="urlCat" ></c:set>
									<li class="cat-item"><a href="${urlCat}">${category.cname }</a>()</li>
								</c:forEach>
							</ul>
						</div>

						<div class="clearfix single_sidebar">
							<div class="popular_post">
								<div class="sidebar_title"><h2>Xem nhiều</h2></div>
								<ul>
									<c:forEach items="${listCountView }" var="newsView">
										<c:set value="${pageContext.request.contextPath }/${slugUtil.makeSlug(newsView.cname) }/${slugUtil.makeSlug(newsView.lname) }-${newsView.lid }.htm" var="urlDetail"></c:set>
										<li><a href="${urlDetail}">${newsView.lname}</a></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>