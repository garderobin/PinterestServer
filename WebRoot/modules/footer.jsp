<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
    <base href="<%=basePath%>">
 
	<%-- <link href="../css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="../css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css">
	<link href="../css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css">
	<link href="../css/bootstrap.css" rel="stylesheet">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<!-- <link href="../css/dbcommon.css" rel="stylesheet">  -->
   	<script src="../js/jquery.min.js"></script>
   	<script src="../js/bootstrap.min.js"></script>
   	<script src="../js/bootstrap.js"></script>
   	<script src="../js/navbar.js"></script> --%>
 	
<footer>   
	<div class="footerButtonsWrapper navbar navbar-fixed-bottom" style="position:fixed;">			
		<div class="FooterButtons Module visible navbar-right" style="padding-right:5%; padding-bottom:5%">
			<div class="buttonInoutWrapper addButtonWrapper">
				<button class="Button DropdownButton Module addPinFooter footerIcon borderless" 
					id="addPinMenuButton" data-element-type="18" type="button">
					<!-- <em></em><span class="accessibilityText">[object Object]</span> -->
					<span class="glyphicon glyphicon-plus" style="font-size:22px; color:gray"></span>
				</button> 				
			</div>			     		
    	</div>
	</div> 	
</footer>
<div class="navbar navbar-fixed-bottom slide-hidden" id="addPinMenuContent">    
    <div class="navbar-right Module Dropdown PositionModule positionModuleFixed positionFixed defaultCaret active positionModuleElement positionRight slide-in">
        <span class="positionModuleCaret" style="top:173px;"></span>
        <div class="AddPin Module isDropdown" data-component-type="">
        	<button type="button" class="Button Module ShowModalButton borderless hasText pinUpload addPinDropdown" 
        		onclick="location.href='testAddPin.jsp'">
        		<em class="glyphicon glyphicon-cloud-upload" style="color:gray;font-size:20px"></em>
        		<!-- <em></em>  -->
            	<span class="buttonText">Upload a Pin</a></span>
            </button>
            <button type="button" class="Button Module ShowModalButton borderless hasText pinUpload addPinDropdown" 
            	onclick="location.href='addPinFromWeb.jsp'">
            	<em class="glyphicon glyphicon-globe" style="color:gray;font-size:20px"></em>
            	<span class="buttonText">Pin from a website</span>
            </button>
            <button type="button" class="Button Module ShowModalButton borderless hasText pinUpload addPinDropdown" 
				onclick="location.href='createBoard.jsp'">
            	<em class="glyphicon glyphicon-blackboard" style="color:gray;font-size:20px"></em>
            	<span class="buttonText">Create a board</span>
            </button>
       </div> 
    </div>
</div>
