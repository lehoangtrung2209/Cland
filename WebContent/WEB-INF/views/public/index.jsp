<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>

<div class="clearfix slider">
                    <ul class="pgwSlider">
                        <li><img src="${defines.urlPublic }/images/thumbs/megamind_07.jpg" alt="Paris, France" data-description="Eiffel Tower and Champ de Mars" data-large-src="${defines.urlPublic }/images/slides/megamind_07.jpg" /></li>
                        <li><img src="${defines.urlPublic }/images/thumbs/wall-e.jpg" alt="Montréal, QC, Canada" data-large-src="${defines.urlPublic }/images/slides/wall-e.jpg" data-description="Eiffel Tower and Champ de Mars" /></li>
                        <li>
                            <img src="${defines.urlPublic }/images/thumbs/up-official-trailer-fake.jpg" alt="Shanghai, China" data-large-src="${defines.urlPublic }/images/slides/up-official-trailer-fake.jpg" data-description="Shanghai ,chaina">
                        </li>


                    </ul>
                </div>

                <div class="clearfix content">
                    <div class="content_title">
                        <h2>Bài viết mới</h2>
                    </div>
					<c:forEach items="${listNews}" var="news">
					<c:set value="${pageContext.request.contextPath }/${slugUtil.makeSlug(news.cname) }/${slugUtil.makeSlug(news.lname) }-${news.lid }.htm" var="urlDetail"></c:set>
                    <div class="clearfix single_content">
                        <div class="clearfix post_date floatleft">
                            <div class="date">
                                <h3><fmt:formatDate value="${news.date_create}" pattern="dd"/></h3>
                                <p>Tháng <fmt:formatDate value="${news.date_create}" pattern="M"/></p>
                            </div>
                        </div>
                        <div class="clearfix post_detail">
                            <h2><a href="${urlDetail}">${news.lname}</a></h2>
                            <div class="clearfix post-meta">
                                <p><span><i class="fa fa-clock-o"></i> Địa chỉ: ${news.address}</span> <span><i class="fa fa-folder"></i> Diện tích: ${news.area}m2</span></p>
                            </div>
                            <div class="clearfix post_excerpt">
                                <img src="${pageContext.request.contextPath }/upload/${news.picture}" alt="" />
                               	<p>${slugUtil.substringWord(news.description,200) }</p>
                            </div>
                            <a href="${urlDetail}">Đọc thêm</a>
                        </div>
                    </div>
				</c:forEach>
                </div>
				


                <div class="pagination">
				   <nav>
				      <ul>
				         <c:if test="${not empty previous }">
				         	<li ><a href="${pageContext.request.contextPath}/page/1">&lsaquo;&lsaquo;</a></li>
				            <li ><a href="${pageContext.request.contextPath}/page/${previous}">&lsaquo;</a></li>
				         </c:if>
				         <c:forEach var="i" begin="${pageStart }" end="${pageEnd }">
				            <c:url var="urlPage" value="${pageContext.request.contextPath}/page/${i}"></c:url>
				            <li 
				            <c:if test="${page == i }">style="font-weight:bold; font-size: 17px;"</c:if>
				            ><a href="${pageContext.request.contextPath}/page/${i}">${i } </a></li>
				         </c:forEach>
				         <c:if test="${not empty next }">
				            <li ><a href="${pageContext.request.contextPath}/page/${next}">&rsaquo;</a></li>
				            <li ><a href="${pageContext.request.contextPath}/page/${sumPages}">&rsaquo;&rsaquo;</a></li>
				         </c:if>
				      </ul>
				   </nav>
				</div>
