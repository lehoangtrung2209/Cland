<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<div class="clearfix content">
						
						<h1>${news.lname }</h1>
						<div class="clearfix post-meta">
							<p><span><i class="fa fa-clock-o"></i> Địa chỉ: ${news.address }</span> <span><i class="fa fa-folder"></i> Diện tích: ${news.area}m2</span></p>
						</div>
						
						<div class="vnecontent">
							<p>${news.description}</p>
						</div>
					
					</div>
					
						<div class="more_themes">
							<h2>Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i></h2>
							<div class="more_themes_container">
								<c:forEach items="${newsOthers }" var="other">
								<c:set value="${pageContext.request.contextPath }/${slugUtil.makeSlug(other.cname) }/${slugUtil.makeSlug(other.lname) }-${other.lid }.htm" var="urlDetail"></c:set>
								<div class="single_more_themes floatleft">
									<img src="${pageContext.request.contextPath }/upload/${other.picture}" alt=""/>
									<a href="${urlDetail}"><h2>${other.lname}</h2></a>
								</div>
								</c:forEach>

							</div>
						</div>