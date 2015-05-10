<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>nyupinterest</title>
	
	<link href="css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_442c9884.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop1_9f130f1f.css" rel="stylesheet" type="text/css">
	<!-- <link href="css/bundle-desktop-1_7e764a10.css" rel="stylesheet" type="text/css"> -->
    <link href="css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- <link href="css/bootstrap.css" rel="stylesheet"> -->
	<link href="css/dbcommon.css" rel="stylesheet" type="text/css">
   	<script src="js/jquery.min.js"></script>
   	<script src="js/bootstrap.js"></script>
   	<script src="js/common.js"></script>
   	<script src="js/jquery.masonry.min.js"></script>
    <script src="js/modernizr-transitions.js"></script>

  </head>  
  <body>
  	<jsp:include page="./modules/header.jsp" />
	<jsp:include page="./modules/footer.jsp"/>
	<div class="appContent">
		<div class="mainContainer" style="background-color:#e9e9e9">
			<div class="Module Nags centeredWithinWrapper" style="height:54px"></div>
			<div class="HomePage Module">
				<div class="AuthHomePage Module">
					<div class="HeroBasicWrapper Module"></div>
					<div class="Grid Module hasFooter" style="background-color:#e9e9e9">
						<div class="GridItems Module centeredWithinWrapper padItems variableHeightLayout" id="masonryContainer">
							<!-- The height is not static. It seems to related to the screen condition. -->
							<jsp:include page="./pinSummary.jsp" />
						</div>
						<div class="GridFooter Module centeredWithinWrapper showGridLoading" style="display:block">
							<div class="gridError" style="display:none">
								<button class="Button btn rounded large">
									<span>Whoops! Something went wrong</span>
									"Try again."
								</button>
							</div>
							<div class="gridLoading">
								<span class="gridFooterLogoIcon"></span>
								<span class="gridFooterSpinner"></span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="appendedContainer"></div>
			<div class="Module Toasts"></div>
		</div>
		<jsp:include page="./modules/appendedContainer.html">
	</div>
    
  </body>
</html>
