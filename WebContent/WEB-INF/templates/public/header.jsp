<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>

		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!--Oswald Font -->
		<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="${defines.urlPublic }/css/tooltipster.css" />
		<!-- home slider-->
		<link href="${defines.urlPublic }/css/pgwslider.css" rel="stylesheet">
		<!-- Font Awesome -->
		<link rel="stylesheet" href="${defines.urlPublic }/css/font-awesome.min.css">
		<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
		<link href="${defines.urlPublic }/style.css" rel="stylesheet" media="screen">	
		<link href="${defines.urlPublic }/responsive.css" rel="stylesheet" media="screen" >	
		<script type="text/javascript" src="${defines.urlPublic }/js/jquery-1.8.3.min.js"></script>
		<style type="text/css">
			    #toTop {
		    position: fixed;
		    bottom: 20px;
		    right: 20px;
		    background: rgb(0, 0, 0);
		    background: rgba(0, 0, 0, 0.7);
		    width: 50px;
		    height: 50px;
		    display: block;
		    text-decoration: none;
		    -webkit-border-radius: 35px;
		    -moz-border-radius: 35px;
		    border-radius: 35px;
		    display: none;
		    -webkit-transition: all 0.3s linear;
		    -moz-transition: all 0.3s ease;
		    -ms-transition: all 0.3s ease;
		    -o-transition: all 0.3s ease;
		    transition: all 0.3s ease;
		}
		#toTop i {
		    color: #fff;
		    margin: 0;
		    position: relative;
		    left: 16px;
		    top: 13px;
		    font-size: 19px;
		    -webkit-transition: all 0.3s ease;
		    -moz-transition: all 0.3s ease;
		    -ms-transition: all 0.3s ease;
		    -o-transition: all 0.3s ease;
		    transition: all 0.3s ease;
		}
		#toTop:hover {
		    background: rgba(0, 0, 0, 0.9);
		}
		#toTop:hover i {
		    color: #fff;
		    top: 5px;
		}
		
    	</style>
	<body>
	
		<section id="header_area">
			<div class="wrapper header">
				<div class="clearfix header_top">
					<div class="clearfix logo floatleft">
						<a href="${pageContext.request.contextPath }/"><h1><span>C</span>Land</h1></a>
					</div>
					<div class="clearfix search floatright">
						<form action="${pageContext.request.contextPath }/search" method="post">
							<input type="text" name="search" placeholder="Search" value="${key }"/>
							<input type="submit" />
						</form>
					</div>
				</div>
				<div class="header_bottom">
					<nav>
						<ul id="nav">
							<li><a href="${pageContext.request.contextPath }/">Trang chủ</a></li>
							<li id="dropdown"><a href="javascript:void(0)">Bất động sản</a>
								<ul>
									<c:forEach items="${listCategory }" var="category">
										<c:set value="${pageContext.request.contextPath }/${slugUtil.makeSlug(category.cname) }-${category.cid }" var="urlCat" ></c:set>
										<li><a href="${urlCat}">${category.cname }</a></li>
									</c:forEach>
								</ul>
							</li>
							<!--  <li><a href="${pageContext.request.contextPath }/single">Giới thiệu</a></li> -->
							<li><a href="${pageContext.request.contextPath }/contact">Liên hệ</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</section>