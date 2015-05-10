<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  -->
<!DOCTYPE html>
    <base href="<%=basePath%>">
    
    <title>nyupinterest</title>
<!--    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 --> 
  
	<%-- <link href="../css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="../css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css">
	<link href="../css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../css/dbcommon.css" rel="stylesheet">
   	<script src="../js/jquery.min.js"></script>
   	<script src="../js/bootstrap.js"></script> --%>
 <script type="text/javascript">
 	$(function(){
  		 
 	
 	}) 
 </script>
<header>
    <div class=" Header Module" data-component-type="" id="header_module" style="background-color:white">
    	<div class="headerBackground" id="headerBackground" style="background-color:white">
    	</div>
    	<div class="headerContainer centeredWithinWrapper" id="headerContainer" style="background-color:white">
    		<div class="rightHeaderContent" style="background-color:white">
    			<div class="Module RightHeader" data-component-type=""> 
    				<button class="Button DropdownButton Module NotificationsConversationsButton btn notifs regular merged rounded" data-element-type=""
    					type="button" onclick="location.href='friendRequest.jsp'">
    					<!-- 
                        <em></em> -->
    					<!--<span class="accessibilityText">Notifications</span>-->
    					<!--<span class="buttonBadge"></span>-->
    					<!-- TODO a badge with the account of notifications. -->
                        <span class="glyphicon glyphicon-bell" style="font-size: 22px; color:gray" ></span>
    				</button>
    				<button class="Module UserNavigateButton merged" data-element-type=""
    					type="button" onclick="location.href='userAdminPage.jsp'">
    					<div class="usernameLink">
    						<div class="Image Module profileImage">
    							<div class="heightContainer">
    								<!-- 			 
    								<img src="https://s-passets-cache-ak0.pinimg.com/images/user/default_#0.png"></img>
    								 -->
    								<span class="glyphicon glyphicon-pushpin" style="font-size: 22px;color:gray"></span>
    							</div>
    						</div>
    					</div>
  						<span class="profileName" id="headerProfileName"><s:property value="#session.username"></s:property></span> <!-- To be modified to the real user name! -->
    				</button>
    			</div>
    		</div>
    		<div class="leftHeaderContent" style="background-color:white">
            	<a class="Button Module NavigateButton btn logoHeader leftRounded rounded" 
                	data-element-type="" data-force-refresh="1" href="index.jsp" type="button">            					
					<!--<em></em>-->
                    <span class="accessibilityText">Home</span>                    
                    <span class="glyphicon glyphicon-search" style="font-size:22px; color:gray"></span>                    
                </a>
                <!-- <div class="btn-group">  -->
                <button class="btn Button DropdownButton Module btn categoriesHeader dropdown-toogle" 
                	data-element-type=""  data-toggle="modal" data-target="#sortListDiv" type="button"> <!-- href TODO -->
        			<em></em>
					<span class="accessibilityText">Categories</span>
                    <span class="glyphicon  glyphicon-menu-hamburger" 
                    	style="font-size:18px;color:gray;"></span>
                    <span class="caret" style="color:gray;"></span>                                      
                </button> 
                 
                <!-- <ul class="dropdown-menu" role="menu"> Problem! not function now.
                	<li><a>About</a></li>
                	<li><a>Help</a></li>
                </ul>  -->  
                <!-- </div>         --> 
                <div class="Module SearchForm buttonOnRight guided tokenized" data-component-type="">
                	<form action="search.jsp" id="searchForm" method="POST" name="search">
                    	<div class="Module TypeaheadField buttonOnRight guided">
                        	<div class="tokenizedInputWrapper">
                            	<div class="Module TokenizedInput guided">
                                	<div class="scrollWrapper">
                                    	<!-- <ul class="tokensWrapper">
        									<li class="tokenizedItem inputToken">
            									<input autocomplete="off" class="Input Module field" data-element-type="227" 
                                                	name="q" placeholder="Search for Pins, Pinners or boards">
    										</li>
    									</ul> -->
    									<ul class="tokensWrapper">
        									<li class="tokenizedItem inputToken">
    									<input type="text" class="Input Module field" style="width:100%" placeholder="Search for Pins, Pinners or boards" name="keyword" id="keyword">
                                    	<!--  <button type="submit">search</button> -->
                                    	</li>
                                    	</ul>
                                    </div>
                                    <a class="removeAll">
                                    	<em></em>
                                    </a>
                                </div>
                            </div>
                            <div class="Module Typeahead buttonOnRight guided">
                            	<ul class="results" data-component-type=""></ul>
                            </div>
                        </div>
                    </form>
                </div>                    
    		</div>
    	</div>
    </div>
    <div id="sortListDiv" class="modal fade" role="dialog">
							<div class="modal-dialog">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title">Sort pins by:</h4>
							      </div>
							      <div class="modal-body">
							        <ul id="sortList">
							        	<li><a href="index.jsp">1. Fresh Pin Mode (Newest published pins first).</a></li>
										
										<li><a href="indexSortedByFollow.jsp">2. Recommend mode (Pins from followed boards and friends first).</a></li>
										<li>
											<a href="indexSortedByHot.jsp">3. Hot mode (Pins repined or liked more often show first).</a>
										</li>
										<li>
											<a onclick="pictureFirst()" type="button">4. Fresh Picture Mode (Pictures uploaded recently show first).</a>
										</li>
									</ul>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							        <!-- <button type="button" class="btn btn-primary">Save changes</button> -->
							      </div>
							    </div><!-- /.modal-content -->
							  </div><!-- /.modal-dialog -->
							
						</div>
 </header>
