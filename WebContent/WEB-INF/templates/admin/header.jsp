<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>    

    
    <link rel="shortcut icon" type="image/ico" href="images/icon-180x180.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${defines.urlAdmin }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- styles -->
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
    <link href="${defines.urlAdmin }/css/style1.css" rel="stylesheet">
	<script src="${defines.urlAdmin }/js/jquery-3.2.1.min.js"></script>
	<script src="${defines.urlAdmin }/js/jquery.validate.min.js"></script>
	<script src="${defines.urlAdmin }/js/ckeditor/ckeditor.js"></script>
	<script src="${defines.urlAdmin }/js/ckfinder/ckfinder.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
	    #toTop {
			cursor: pointer;
		    position: fixed;
		    bottom: 20px;
		    right: 20px;
		    display:none;
		}
    </style>
  </head>
  <body>
  	
  	<div class="header">
	     <div class="container">
	        <div class="row">
	           <div class="col-md-5">
	              <!-- Logo -->
	              <div class="logo">
	                 <h1><a href="${pageContext.request.contextPath }/admin">BẤT ĐỘNG SẢN</a></h1>
	              </div>
	           </div>
	           <div class="col-md-5">
	              <div class="row">
	                <div class="col-lg-12"></div>
	              </div>
	           </div>
	           <c:if test="${not empty userLogin}">
	           <div class="col-md-2">
	              <div class="navbar navbar-inverse" role="banner">
	                  <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
	                    <ul class="nav navbar-nav">
	                      <li class="dropdown">
	                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${userLogin.fullname } <b class="caret"></b></a>
	                        <ul class="dropdown-menu animated fadeInUp">
	                         <li><a href="${pageContext.request.contextPath }/admin/profile">Profile</a></li>
	                          <li><a href="${pageContext.request.contextPath }/auth/logout">Logout</a></li>
	                        </ul>
	                      </li>
	                    </ul>
	                  </nav>
	              </div>
	           </div>
	           </c:if>
	        </div>
	     </div>
	</div>