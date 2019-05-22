<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
		<section id="content_area">
			<div class="clearfix wrapper main_content_area">
			
				<div class="clearfix main_content floatleft">
				
					
					<div class="clearfix content">
						<div class="content_title"><h2>${category.cname }</h2></div>
						
						<div class="clearfix single_work_container">
							<c:forEach items="${listNews}" var="news">
							<c:set value="${pageContext.request.contextPath }/${slugUtil.makeSlug(news.cname) }/${slugUtil.makeSlug(news.lname) }-${news.lid }.htm" var="urlDetail"></c:set>
								<div class="clearfix single_work">
									<img class="img_top" src="${pageContext.request.contextPath }/upload/${news.picture}" alt=""/>
									<img class="img_bottom" src="${pageContext.request.contextPath }/upload/${news.picture}" alt=""/>
									<h2><a href="${urlDetail }">${news.lname }</a></h2>
									<c:set var = "description" value = "${fn:substring(news.description, 0, 100)}" />
									<a href="${urlDetail }"><p class="caption">${description}</p></a>
								</div>
							</c:forEach>
							
						</div>
						<c:set var="urlPage" value="${pageContext.request.contextPath }/${slugUtil.makeSlug(category.cname) }-${category.cid }"></c:set>
						<div class="pagination">
						   <nav>
						      <ul>
						         <c:if test="${not empty previous }">
						         	<li ><a href="${urlPage}/page/1">&lsaquo;&lsaquo;</a></li>
						            <li ><a href="${urlPage}/page/${previous}">&lsaquo;</a></li>
						         </c:if>
						         <c:forEach var="i" begin="${pageStart }" end="${pageEnd }">
						            <li 
						            <c:if test="${page == i }">style="font-weight:bold; font-size: 17px;"</c:if>
						            ><a href="${urlPage}/page/${i}">${i } </a></li>
						         </c:forEach>
						         <c:if test="${not empty next }">
						            <li ><a href="${urlPage}/page/${next}">&rsaquo;</a></li>
						            <li ><a href="${urlPage}/page/${sumPages}">&rsaquo;&rsaquo;</a></li>
						         </c:if>
						      </ul>
						   </nav>
						</div>
					</div>
					
				</div>
			</div>
		</section>
		
