<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <title>authorBoardButtons.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=US-ASCII">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
    <div class="boardButtons" style="height:30px;">
		<button class="IsAuthor Button Module btn1 hasText movePinsButton rounded" data-element-type="400" type="button"  style="height:30px">
											<span class="buttonText">Move Pins</span>
	        							</button>
										<button id="editBoardButton" class="IsAuthor Button Module ShowModalButton boardEditButton btn1 hasText rounded" type="button" style="height:30px">
											<span class="buttonText">Edit Board</span>
										</button>
										
									</div>
	<div class="collaborators  showName">
	        							<div class="Module User hasText inline small thumbUserInfo">
											<a href="/liupenghuigarde/" data-element-type="64">
												<div class="thumbImageWrapper">
													<img src="https://s-passets-cache-ak0.pinimg.com/images/user/default_60.png" alt="Jasmine Liu" title="More from Jasmine Liu">
	        									</div>
												<h4 class="fullname" id="author">abcd</h4>
												<!-- <div class="fullname Label Module">Jasmine Liu</div> -->
											</a>
										</div>
	 									<button class="Button Module ShowModalButton boardAddCollaboratorsButton borderless primary" type="button"
	 										style="background-image:url('images/addFriend.png'); background-size: 30px 30px; background-position:0 0">
											<div class="Label Module">Invite</div>
										</button>
									</div>
									<h2 class="smallBoardName centeredWithinWrapper" style="opacity: 0; transform: translate(0px, 0px);">Test</h2>
									<div class="pinsAndFollowerCount " style="transform: translate(0px, 0px);">
	            						<ul>
	                						<li>
												<span class="value" id="pinCountSpan"><%= request.getParameter("pinCount") %></span> 
												<span class="label">Pins</span>
	    									</li>
											<li>
	                        					<button class="Button Module ShowModalButton borderless followerCount hasText" type="button">
													<em></em>
													<span class="buttonText">
														<span class="value" id="followerCountSpan"><%=request.getParameter("followerCount") %></span> 
														<span class="label">Followers</span>
													</span>        
												</button>
	                    					</li>
										</ul>
									</div>
  </body>
</html>
