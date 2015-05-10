<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Repin</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<!-- <script type="text/javascript" src="js/jquery-1.8.1.min.js"></script> -->
		<script src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.uploadifive.min.js"></script>
		<!-- <link rel="stylesheet" type="text/css" href="css/uploadifive.css"> -->
		<link href="css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
		<link href="css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css"> 
		<link href="css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css"> 
		<link href="css/bundle-desktop-2_442c9884.css" rel="stylesheet" type="text/css">
		<!-- <link href="css/bundle-desktop-1_7e764a10.css" rel="stylesheet" type="text/css"> -->
	    <link href="css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- <link href="css/bootstrap.css" rel="stylesheet"> -->
		<link href="css/dbcommon.css" rel="stylesheet" type="text/css">	   	
	   	<script src="js/bootstrap.min.js"></script>
	   	<script src="js/common.js"></script>
	   	<script src="js/jquery.masonry.min.js"></script>
	    <script src="js/modernizr-transitions.js"></script>
	</head>

	<body>			
		<form class="standardForm" method="post" action="repin">
			<input type="hidden" id="bid" name="bid"/>
			<input type="hidden" id="repin" name="repin" value=<%= request.getParameter("repin")%>>	
			<input type="hidden" id="picnum" name="picnum" value=<%= request.getParameter("picnum")%>>
    	<!-- <div class="Button Module btn hasText large leftRounded primary" type="button" style="position: relative; overflow: hidden; direction: ltr;">
		 -->	<!-- <span class="buttonText" id="chooseImageSpan">Choose Image</span> -->
		<!-- <div type="button" style="position: relative; overflow: hidden; direction: ltr; min-width:150px;">	 -->
			
		<!-- </div> -->
				
    			<h1 class="pinFormHeader">Repin</h1>
    			<div class="uploaderProgress" id="tip-queue" style="float:right;min-width:300px"></div>
    			<div class="Module PinPreview" 
    				style="float:right;margin-right:20px;overflow-x:hidden; overflow-y:hidden;position:relative;
    				margin-bottom:0px;margin-left:0px;margin-top:15px;max-width:180px;max-height:250px;
    				border:2px gray solid;background-color:#eee">
            		<img class="pinPreviewImg" id="pinPreviewImg" src=<%= request.getParameter("url")%>>
            	</div>
				<ul>
					<li class="boardWrapper" style="width:500px">
            			<h3 style="width:130px"><label>Board</label></h3>            			
            			<div class="dropdown"  style="margin-left:-90px;">
                			<button class=" BoardPickerDropdownButton Button DropdownButton Module btn primary rounded dropdown-toggle" type="button"
                			 id="addPinPickBoardButton" data-toggle="dropdown" aria-expanded="true">
								<%-- <span class="downArrow"></span> --%>
								<div class="BoardLabel Module compact">
									<span class="nameAndIcons">
    									<div class="name" style="float:right;min-width:290px;" id="selectSpan">Select a board</div>
									</span>
								</div>
							</button>
							<ul class="dropdown-menu selectBoard" role="menu" aria-labelledby="addPinPickBoardButton" id="selectBoard" style="position:relative;float:left;width:318px"></ul>
            			</div>
       				</li>
       				<li style="width:500px">
            			<h3 style="width:130px"><label for="pinFormDescription">Description</label></h3>
            			<div>
                			<div class="Field Module TextField" style="margin-left:-95px;">
								<textarea id="pinFormDescription" name="note" class="content " 
								 style="float:right"><%= request.getParameter("note")%></textarea>
							</div>
            			</div>
       	 			</li>
					<!-- <li style="width:500px">
                		<h3 style="width:130px"><label for="pinFormLink">Source</label></h3>
                		<div>
                    		<input type="url" name="sourceUrl" id="sourceUrl"  style="float:right; min-width:320px;">
                		</div>
            		</li> -->
				</ul>
				<div class="formFooter" id="formFooter">
					<div class="socialShareWrapper"></div>
					<div class="formFooterButtons">
						<button class=" Button Module btn cancelButton hasText rounded" type="button">
							<span class="buttonText">Close</span>
						</button>
						<button class="Button Module btn primary repinSmall pinIt rounded" type="submit" >
							<em class="glyphicon glyphicon-pushpin"></em>
							<span class="buttonText">Pin it</span>
						</button>
        			</div>
    			</div>
		</form>
	</body>
<script type="text/javascript">
  	$(function(){
  		 
  	    $("#addPinPickBoardButton").click(getBoardListForAddPin()); 
  	     	    
	})
	
	function getBoardListForAddPin() {		
		$.ajax({
			type:"GET",
			dataType:"json",
			url:'queryBoardsByUsername.action',
			success: function(data, textStatus) {
				var $menuSelect = $('#selectBoard');
				$.each(data.boardList, function() {
					var $bid  = this.bid;
					var $bname = this.bname;
					var $element = $("<li class='item' id=" + $bid + "><a>" + $bname + "</a></li>"); 
					//还没有跳转连接！
					$menuSelect.append($element);
					$element.bind("click", itemChoose); 
				});
			},
		});
	}
	
	function itemChoose() {
		$("#selectSpan").innerHTML= this.innerHTML;
		$("#bid").val(this.id);
	}
	
</script>
</html>