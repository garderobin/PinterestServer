<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
  <head>
    <title>uploadForm.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=US-ASCII">
    <link href="css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_442c9884.css" rel="stylesheet" type="text/css">
    <link href="css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/dbcommon.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="js/uploadifive.css">
	<link rel="stylesheet" type="text/css" href="css/bundle-desktop-main_db38bc94.css"> 
   	<%-- <script src="js/jquery.min.js"></script> --%>
   	<script src="js/jquery-1.8.1.min.js"></script>
   	<script src="js/bootstrap.js"></script>
   	<script src="js/common.js"></script>
   	<script src="js/jquery.masonry.min.js"></script>
    <script src="js/modernizr-transitions.js"></script>
	<%-- <script src="js/jquery.ui.widget.js"></script>
    <script src="js/jquery.iframe-transport.js"></script>   
    <script src="js/jquery.fileupload.js"></script> 
    --%>
	<script type="text/javascript" src="js/jquery.uploadifive.min.js"></script>

  </head>
 
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
<body>
<div class="navbar navbar-fixed-bottom" id="addPinMenuContent">    
    <div class="navbar-right Module Dropdown PositionModule positionModuleFixed positionFixed defaultCaret active positionModuleElement positionRight slide-in">
        <span class="positionModuleCaret" style="top:173px;"></span>
        <div class="AddPin Module isDropdown" data-component-type="">
        	<button type="button" class="Button Module ShowModalButton borderless hasText pinUpload addPinDropdown" data-toggle="modal" data-target="#uploadForm">
        		<em class="glyphicon glyphicon-cloud-upload" style="color:gray;font-size:20px"></em>
        		<!-- <em></em>  -->
            	<span class="buttonText">Upload a Pin</span>
            </button>

<!-- Modal -->
<!-- Button trigger modal -->
<!-- <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#uploadForm">
  Launch demo modal
</button> -->


       </div> 
    </div>
    
    <!-- <div class="modal fade" id="uploadForm" aria-labelledby="uploadLabel">
 		<form class="standardForm" method="post">
			    <h1 class="modal-title" id="uploadLabel">Upload a Pin</h1>
				<div class="ImageUploader Module modal-body">
					<div class="Button Module btn hasText large leftRounded primary" type="button" style="position: relative; overflow: hidden; direction: ltr;">
						<span class="buttonText">Choose Image</span>
			               <input type="file" name="file" style="position: absolute; right: 0px; top: 0px; font-family: Arial; font-size: 118px; margin: 0px; padding: 0px; cursor: pointer; opacity: 0;">
			           </div>
			         <div class="uploaderProgress"></div>
			      </div>
		</form>
	</div> -->
    
</div>
<%-- <div class="modal fade" id="uploadForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <form class="modal-content standardForm" id="uploadPinForm" >
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h1 class="modal-title" id="myModalLabel">Upload a pin</h1>
      </div>
      <div class="modal-body ImageUploader Module "> --%>
      	
		<!-- <div class="uploaderProgress"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary">
      </div>
    </form> -->
    <form class="standardForm" method="post">
    	<div class="Button Module btn hasText large leftRounded primary" type="button" style="position: relative; overflow: hidden; direction: ltr;">
			<span class="buttonText" id="chooseImageSpan">Choose Image</span>
			<input type="file" id="file" name="file" style="position: absolute; right:0px; top: 0px; font-family: Arial; font-size: 118px; margin: 0px; padding: 0px; cursor: pointer; opacity: 0;">
			<div class="uploaderProgress" id="tip-queue"></div>
		</div>
    			<h1 class="pinFormHeader">Pick a board</h1>
				<ul>
					<li class="boardWrapper">
            			<h3><label>Board</label></h3>
            			<div class="Module PinPreview">
            				<img src="images/add.png" class="pinPreviewImg">
            			</div>
            			<div>
                			<button class=" BoardPickerDropdownButton Button DropdownButton Module btn primary rounded" type="button">
								<span class="downArrow"></span>
								<div class="BoardLabel Module compact">
									<span class="nameAndIcons">
    									<div class="BoardIcons Module pinCreate3"></div>
    									<div class="name">Select a board</div>
									</span>
								</div>
							</button>
            			</div>
       				</li>
       				<li>
            			<h3><label for="pinFormDescription">Description</label></h3>
            			<div>
                			<div class="Field Module TextField">
								<textarea id="pinFormDescription" name="description" class="content " placeholder="What's this Pin all about?"></textarea>
							</div>
            			</div>
       	 			</li>
					<li>
                		<h3><label for="pinFormLink">Source</label></h3>
                		<div>
                    		<input type="url" name="link" id="pinFormLink" value="">
                		</div>
            		</li>
				</ul>
				<div class="formFooter">
					<div class="socialShareWrapper"></div>
					<div class="formFooterButtons">
						<button class=" Button Module btn cancelButton hasText rounded" type="button">
							<span class="buttonText">Close</span>
						</button>
						<button class="Button Module btn primary repinSmall pinIt rounded disabled" type="submit" disabled="">
							<em></em>
							<span class="accessibilityText">Pin it</span>
						</button>
        			</div>
    			</div>
		</form>
<!--   </div>
</div>  -->
</body>	 	
       <script type="text/javascript">
  	$(function(){
  		 $('#file_upload').uploadifive({
  			 //'auto' : false,   //取消自动上传 
  	        'uploadScript' : 'fileUploadAction.action',  //处理上传文件Action路径 
  	        'fileObjName' : 'file',        //文件对象
	  	    'buttonText'   : '选择文件',   //按钮显示文字 
	  	    'queueID'      : 'tip-queue', //提示信息放置目标 
	  	    'fileType'     : 'image/*',   //允许上传文件类型 
	  	    'onUploadComplete' : function(file, data) { //文件上传成功后执行 
  				  console.info('The file ' + file.name + ' uploaded successfully.');
	         }
  	    });
	})
</script>
    
</html>


