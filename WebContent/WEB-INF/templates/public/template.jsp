<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
<title><tiles:getAsString name="title"/></title>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
		<section id="content_area">
			<div class="clearfix wrapper main_content_area">
				<div class="clearfix main_content floatleft">
					<tiles:insertAttribute name="body"></tiles:insertAttribute>
				</div>
				<div class="clearfix sidebar_container floatright">
					<tiles:insertAttribute name="rightbar"></tiles:insertAttribute>
				</div>
			</div>
		</section>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		
