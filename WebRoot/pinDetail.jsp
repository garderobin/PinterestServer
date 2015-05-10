<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int pinid = Integer.parseInt(request.getParameter("pinid"));
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
<%--     <link href="css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_442c9884.css" rel="stylesheet" type="text/css">	
	<link href="css/bundle-desktop1_9f130f1f.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/dbcommon.css" rel="stylesheet" type="text/css">
   	<script src="js/jquery.min.js"></script>
   	<script src="js/bootstrap.js"></script>
   	<script src="js/common.js"></script>
   	<script src="js/jquery.masonry.min.js"></script>
    <script src="js/modernizr-transitions.js"></script> --%>
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
	    <script src="js/jquery.form.min.js"></script>
	    <script src="https://apis.google.com/js/platform.js" async defer></script>
	    <script>
window.twttr=(function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],t=window.twttr||{};if(d.getElementById(id))return;js=d.createElement(s);js.id=id;js.src="https://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);t._e=[];t.ready=function(f){t._e.push(f);};return t;}(document,"script","twitter-wjs"));
</script>
    <script type="text/javascript">
	    $(function(){
	    	//$(".currentUsername").text($("#username").text());
	    	$curuser = $("#username").text();
	    	$(".currentUsername").text("Alice");
	    	var $pinid = $("#pinid_editPin").val();  
	    	var $uploadByUser = false;
	    	$("#editPinSelectSpan").text($("#bname").text());
	    	//$("#changeBoard").click(getBoardList()); 
	    	getBoardList();
	    	$.ajax({
				type:"GET",
				dataType:"json",
				url:'queryPinSummaryByPinid.action',
				data:{pinid:$pinid},
				success: function(data, textStatus) {
					console.log("sourceUrl:");
					var $sourceUrl = data.pin.picture.sourceUrl;
					var $author = data.pin.board.user.username;
					console.log(data.pin.picture.sourceUrl);
					$(".pinImage").attr("src", data.pin.picture.url);
					$("#editPinPreviewImg").attr("src", data.pin.picture.url);
					$("#picnum").val(data.pin.picture.picnum);
					//$uploadByUser = ($sourceUrl.equals("Uploaded by user"));
					setDomain($sourceUrl); //TODO
					$("#domainNameTitle").text($author);
					$("#authorTitle").text($author);
					$("#sideBarAuthorLink").attr("href", "userPage.jsp?username=" + $author);
					/*$("#author").val(data.pin.board.user.username); */					
					$("#firstCommentByAuthorNote .commentDescriptionCreator").text($author);
					$("#firstCommentByAuthorNote .commentDescriptionTimeAgo").text(data.pin.time);
					$("#firstCommentByAuthorNote .noteDiv").text(data.pin.note);
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					console.error("queryPinSummaryByPinid error!");
				},
			});
			
			$.ajax({
				type:'GET',
				dataType:'json',
				url:'queryPinsByBid.action',
				data:{bid:$("#bid").val()},
				success: function(data, textStatus) {
					var $container = $("#masonrySmall");
					$container.children().remove();
					$.each(data.pinList, function() {
						//$("#author").val(this.board.user.username);
						var $pinid = this.pinid;
						var $url = this.picture.url; 
						var $note = this.note;
						var $bname = this.board.bname;
						var $bid = this.board.bid;
						var $element = $(
"<div class='masonrySmallItem  ui-draggable ui-draggable-disabled ui-state-disabled' tabindex='1' aria-disabled='true'>" + 
	"<div class='Module Pin boardPinsGrid' data-component-type='29'>" + 
		"<a href='pinDetail.jsp?pinid=" + $pinid + "&bid=" + $bid + "&bname=" + $bname + "' class='boardPinsGridPin' data-element-type='35'>" + 
			"<span class='hoverMask'></span>" + 
			"<img src='" + $url + "'>" + 
		"</a>" + 
    "</div>" + 
"</div>" 
						);
						$container.append($element);
					});
					
				},
			});
			
			$("#masonrySmall").imagesLoaded( function(){																
						$("#masonrySmall").masonry({
					        itemSelector : ".masonrySmallItem",
					        columnWidth:70,
					        gutterWidth:2,
					        isFitWidth:true
			      		});	
			});
			
			$.ajax({
				type:'GET',
				dataType:'json',
				url:'queryCommentByPinid.action',
				data:{pinid:$pinid},
				success: function(data, textStatus) {
					if(data===null || data.commentlist==null) {
					} 
					else {
						$(".PinCommentList").removeClass("empty");
							
						$.each(data.commentlist, function() {
							console.log("element in commentlist: ");
							console.log(this);
							$element=$(
"<li data-index='0' id='c_" + this.cid + "' style='min-height:70px;width:736px'>" + 
    "<div class='Module PinComment detailed'>" + 
        "<a class='InlineHoverButton Module PinDeleteCommentButton deleteComment' href='deleteComment.action?cid=" + this.cid + "'>" + //admin delete TODO
            "<em class='glyphicon glyphicon-remove'></em>" + 
            "<button class='Button Module btn deleteComment hasText rounded' type='button'>" + 
                "<span class='buttonText'>Delete Comment</span>" + 
                "<em></em>" + 
            "</button>" + 
        "</a>" + 
        "<div class='Module PinDescriptionComment detailed'>" + 
            "<div class='pinDescriptionComment detailed'>" + 
                "<a class='userThumbContainer' href='/liupenghuigarde/'>" + 
                    "<div class='Image Module userThumb'>" + 
                        "<div class='heightContainer'>" + 
                            "<img src='https://s-passets-cache-ak0.pinimg.com/images/user/default_150.png' style='' alt='Jasmine Liu' data-src='https://s-passets-cache-ak0.pinimg.com/images/user/default_150.png'>" + 
                        "</div>" + 
                    "</div>" + 
                "</a>" + 
                "<div class='commenterNameCommentText'>" + 
                    "<div class='commenterWrapper'>            " + 
                        "<a class='commentDescriptionCreator ' href='/liupenghuigarde/'>" + this.user.username + "</a>" + 
                            "<span class='commentDescriptionTimeAgo'> " + this.time + " </span>" + 
                    "</div>" + 
                    "<p class='commentDescriptionContent'>" + this.content + "</p>" + 
                "</div>" + 
            "</div>" + 
        "</div>" + 
    "</div>" + 
"</li>"					
					);
							$("#commentListModule").append($element);
						});						
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					console.error(errorThrown);
				}
			});
				
			
			$("#addCommentForm").ajaxForm({
				url: 'addComment.action',
				type: 'GET',
				dataType: 'json',
				data:{pinid:$pinid, content:$.trim($("#contentTextArea").val())},
				success: function(data){					
					var $element = $(
"<li data-index='0' id='c_" + data.idcomment + "' style='min-height:70px;width:736px'>" + 
    "<div class='Module PinComment detailed'>" + 
        "<a class='InlineHoverButton Module PinDeleteCommentButton deleteComment' href='deleteComment.action?cid=" + data.idcomment + "'>" + //admin delete TODO
            "<em class='glyphicon glyphicon-remove'></em>" + 
            "<button class='Button Module btn deleteComment hasText rounded' type='button'>" + 
                "<span class='buttonText'>Delete Comment</span>" + 
                "<em></em>" + 
            "</button>" + 
        "</a>" + 
        "<div class='Module PinDescriptionComment detailed'>" + 
            "<div class='pinDescriptionComment detailed'>" + 
                "<a class='userThumbContainer' href='/liupenghuigarde/'>" + 
                    "<div class='Image Module userThumb'>" + 
                        "<div class='heightContainer'>" + 
                            "<img src='https://s-passets-cache-ak0.pinimg.com/images/user/default_150.png' style='' alt='Jasmine Liu' data-src='https://s-passets-cache-ak0.pinimg.com/images/user/default_150.png'>" + 
                        "</div>" + 
                    "</div>" + 
                "</a>" + 
                "<div class='commenterNameCommentText'>" + 
                    "<div class='commenterWrapper'>            " + 
                        "<a class='commentDescriptionCreator ' href='/liupenghuigarde/'>" + $curuser + "</a>" + 
                            "<span class='commentDescriptionTimeAgo'> just now </span>" + 
                    "</div>" + 
                    "<p class='commentDescriptionContent'>" + data.content + "</p>" + 
                "</div>" + 
            "</div>" + 
        "</div>" + 
    "</div>" + 
"</li>"					
					);
					$(".PinCommentList").removeClass("empty");
					$("#commentListModule").append($element);
					//$("textarea[name='content']")
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					console.error(errorThrown);
				}
			});
/* 			$.ajax({
				type:'GET',
				dataType:'json',
				url:'queryPinsByBid.action',
				data:{bid:$("#bid").val()},
				success: function(data, textStatus) {},
			}); */
			/* $("#editPinForm").ajaxForm({
				url: 'editPin.action',
				type: 'GET',
				dataType: 'json',
				success: function(data){
					
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					console.error(errorThrown);
				}
			}); */
	    })
	    
	    function getBoardList() {
			$.ajax({
				type:"GET",
				dataType:"json",
				url:'queryBoardsByUsername.action',
				success: function(data, textStatus) {
					var $menuSelect = $('#changeBoard');
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
			//alert("itemChoose = " + this.id);
			//console.log(this.id);
			$("#selectedBoardNameDiv").text($("#" + this.id).text());
			$("#bid").val(this.id);
			//console.log(">>>>>>>>>>> In jsp, bid = " + $("#bid").val());
		}
		
		function setDomain(sourceUrl) {
			$uploadByUser = (sourceUrl=="Uploaded by user");				
			if ($uploadByUser) {
				$("#sourceFlagLink").text("Upload by user");
				$("#domainNameTitle").text($("#author").val());//TODO
			} else {
				$("#sourceFlagLink").text("Found on " + sourceUrl);
				$("#domainNameTitle").text(sourceUrl); //TODO
			}
			
		}
		
		$(window).resize(function() {
			$("#masonrySmall").imagesLoaded( function(){																
						$("#masonrySmall").masonry({
					        itemSelector : ".masonrySmallItem",
					        columnWidth:70,
					        gutterWidth:2,
					        isFitWidth:true
			      		});	
					});
			
		})
		
		
		
		function deleteComment(cid) {
			alert("cid: " +cid );
			$.ajax({
				type:"GET",
				dataType:"json",
				url:'deleteComment.action',
				data:{cid:cid},
				success: function(data, textStatus) {
					$("#c_" + cid).remove() ;
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					console.error("deleteComment wrong code!");
				}
			});
		}
    </script>

  </head>
  
  <body>
  <div id="username" style="display:none"><s:property value='#session.username'></s:property></div>
  <div id="bname" style="display:none"><%= request.getParameter("bname")%></div>
  <input type="hidden" name="author" id="author">
<div class="appendedContainer">
	<div class="Module Closeup canClose" style="min-height:624px;">
		<button class="Button borderless close visible" style="right: 14px;">
			<em class="glyphicon glyphicon-remove"></em>&nbsp;
		</button>
		<div class="closeupActionBarContainer" data-component-type="4">
			<div class="Module PinActionBar" style="top:0px;">
				<div class="repinLike">
					<button class="Button Module ShowModalButton btn medium primary primaryOnHover repin pinActionBarButton rounded" data-element-type="0" type="button">
						<!-- <em class="glyphicon glyphicon-pushpin"></em> -->						
						<!-- <span class="accessibilityText">Pin it</span> -->
						<!-- <em class="glyphicon glyphicon-pushpin"></em> -->
						<span class="glyphicon glyphicon-pushpin"></span>
                        <span class="buttonText">Pin it</span>
					</button>
					<button class="Button IncrementingNavigateButton Module NavigateButton btn hidden medium primary repinLikeNavigateButton pinActionBarButton rounded" data-element-type="174" type="button">&nbsp;
					</button>
					<button class="Button LikeButton Module PinLikeButton btn hasText like pinActionBarButton medium rounded" data-element-type="1" data-source-interest-id="" data-text-like="Like" data-text-unlike="Unlike" type="button">
						<em class="glyphicon glyphicon-heart"></em>
						<span class="buttonText">Like</span>        
    				</button>
					<button class="Button IncrementingNavigateButton Module NavigateButton btn hidden medium repinLikeNavigateButton like pinActionBarButton rounded" data-element-type="175" type="button">&nbsp;
					</button>
					<a class="Button Module NavigateButton btn hasText medium rounded website pinActionBarButton" data-element-type="162" href="http://www.barbaragateau.com/" rel="nofollow" type="button">
						<em class="glyphicon glyphicon-globe"></em>
						<span class="buttonText">Visit Site</span>
					</a>
				</div>
				<div class="shareGear">
					<button class="twitterdev Button DropdownButton Module btn hasText medium rounded send pinActionBarButton" data-element-type="98" type="button" data-toggle="modal" data-target="#shareModal">
						<span class="glyphicon glyphicon-send"></span>
                        <span class="buttonText">Send</span>
                        
					</button>
					<button id="editPinButton" class="Button EditButton Module btn facebookShare pinActionBarButton hasText medium rounded" type="button" data-toogle="modal" data-target="#editModal">
						<em  class="glyphicon glyphicon-pencil"></em>
						<span class="buttonText">Edit</span>
					</button>
					
    			</div>
    			
				
			</div>
		</div>
		<div class="closeupContainer">
			<%-- <jsp:include page="modules/closeupContent.html" />
			 --%>
			 <div class="CloseupContent Module">
	<div class="Module Pin detailed" data-component-type="">
		<div class="pinWrapper">
			<div class="closeupContentSection pinActionBarStickyContainer">
	  			<div class="pinImageSourceWrapper" data-element-type="35">
	    
	    			<div class="Module PaddedPin">
	      				<div class="visualLiveSearchOverlayOuterWrapper">
	        				<div class="visualLiveSearchOverlayInnerWrapper">
	          					<div class="visualLiveSearchOverlay"></div>
	        				</div>
	      				</div>
	      				<a href="http://www.barbaragateau.com/" class="paddedPinLink" rel="nofollow" onclick="event.preventDefault();" data-element-type="35">
	        				<div class="pinDomain pinCloseupSeoText hidden" style="width:570px;">barbaragateau.com</div>
	          				<div class="imageContainer">
	            				<div class="Image Module" style="width: 570px">
	              					<div class="heightContainer" style="padding-bottom: 150.350877%">
	                					<img id="pinImage" class="pinImage" src="userphotos/4b094aa8-1843-4578-a80f-f0d030510d57.png" class="pinImage" style="" alt="Spring flowers">
	              					</div>
	            				</div>
	          				</div>
	      				</a>
	      				<div class="visualSearchObjectOverlay" style="margin-left: -285px;"></div>      			
	    			</div>
	
	    			<div class="sourceFlagWrapper">
	      				<a id="sourceFlagLink" href="http://www.barbaragateau.com/" rel="nofollow" data-element-type="27"></a>
	        			<button class="Button Module ShowModalButton borderless pinFlag" data-element-type="176" type="button">
	          				<em></em>&nbsp;
	        			</button>
	    			</div>
	    			
	    			<div class="CloseupRichPinContent Module"></div>
	    			
				</div>
			</div>
			
			<div class="closeupContentSection">
	            <div class="pinDescription ">
					<div class="Module PinDescriptionComment detailed">
						<div class="pinDescriptionComment detailed">
							<a class="userThumbContainer" href="/evy37/">
	        					<div class="Image Module userThumb">
									<div class="heightContainer">
										<img src="https://s-passets-cache-ak0.pinimg.com/images/user/default_75.png" style="" alt="Evy Camacho" data-src="https://s-media-cache-ak0.pinimg.com/avatars/evy37_1429966149_150.jpg">
									</div>
								</div>
							</a>
							<div class="commenterNameCommentText" id="firstCommentByAuthorNote">
	        					<div class="commenterWrapper">
									<a class="commentDescriptionCreator " href="/evy37/">Evy Camacho</a>
	                				<span class="commentDescriptionTimeAgo">• 7 weeks ago </span>
								</div>
								<h1 class="commentDescriptionContent">
	            					<div class="pinDesc nonCanonicalDesc noteDiv">Spring flowers</div>
	            				</h1>
							</div>
						</div>
					</div>
	
	                <div class="Module PinCommentsPage detailed">
						<div class="Module PinCommentList detailed empty">
							<div class="commentsContainer ">
								<ul class="List Module" id="commentListModule"></ul>
							</div>												
						</div>
						<div class="pinDescriptionCommentItem pinUserCommentBox">
	        				<div class="Module PinDescriptionComment detailed">
								<div class="pinDescriptionComment detailed">
									<a class="userThumbContainer" href="/liupenghuigarde/">
	        							<div class="Image Module userThumb">
											<div class="heightContainer">
												<img src="https://s-passets-cache-ak0.pinimg.com/images/user/default_75.png" style="" alt="Jasmine Liu" data-src="https://s-passets-cache-ak0.pinimg.com/images/user/default_75.png">
											</div>
										</div>
	    							</a>
									<div class="commenterNameCommentText">
	        							<div class="commenterWrapper">
											<a class="commentDescriptionCreator currentUsername" href="/liupenghuigarde/">Jasmine Liu</a>
											<span class="commentDescriptionTimeAgo">• That's you! </span>
										</div>
										<form class="addCommentForm" method="post" id="addCommentForm">
	                						<%-- <input type="hidden" name="pinid" id="pinid_addComment" value=<%= pinid%>>
    		 --%>
	                						<div class="Field Module TextField">
												<textarea name="content" id="contentTextArea" class="content" placeholder="Add a comment..."></textarea>
											</div>
	                						<button class="Button Module addComment btn hasText primary rounded" data-element-type="2" type="submit" style="display:inline">
												<span class="buttonText">Comment</span>
											</button>
	            						</form>        
	    							</div>
								</div>
							</div>
	    				</div>
					</div>
				</div>
	        </div>
			<div class="closeupContentSection pinnerViaPinnerCredit">
				<div class="Module User hasText medium pinner thumb">
					<button class=" Button FollowButton Module UserFollowButton btn closeupBottomView hasText notNavigatable rounded" data-element-type="62" type="button">
						<span class="buttonText">Add Friend</span>
					</button>
					<a href="/evy37/" data-element-type="26">
						<div class="thumbImageWrapper">
							<img src="https://s-media-cache-ak0.pinimg.com/avatars/evy37_1429966149_150.jpg" alt="Evy Camacho" title="More from Evy Camacho">
	        			</div>
						<h3 class="title">Added by</h3>
						<h4 class="fullname">Evy Camacho</h4>
					 </a>
				</div>
				<div class="Module User hasText medium pinner thumb">
					<button class=" Button FollowButton Module UserFollowButton btn closeupBottomView hasText notNavigatable rounded" data-element-type="62" type="button">
						<span class="buttonText">Add Friend</span>    
					</button>
					<a href="/karendearness/" data-element-type="26">
						<div class="thumbImageWrapper">
							<img src="https://s-media-cache-ak0.pinimg.com/avatars/karendearness-1388369640_150.jpg" alt="Karen Dearness" title="More from Karen Dearness">
	        			</div>
						<h3 class="title">Via</h3>
						<h4 class="fullname">Karen Dearness</h4>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
			 
			 <jsp:include page="modules/closeupSidebar.jsp" />
		</div>
		<jsp:include page="modules/closeupBottom.html" />
		
	</div>	
</div>
	    
		
		<div class="modal fade" id="shareModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Share to</h4>
      </div>
      <div class="modal-body">
        <a class="twitter-share-button" href="https://twitter.com/share" data-related="twitterdev"
						  data-size="large"
						  data-count="none" style="padding-top:100%;height:100%"> Tweet
		</a>
		<div class="g-plusone" data-annotation="inline" data-width="300"></div>
		
      </div>
      
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<%-- <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="editModalLabel">Edit Pin</h4>
      </div>
      <div class="modal-body"> --%>
        <form class="standardForm" method="post" action="editPin" id="editPinForm">
	    	<input type="hidden" class="pinid" name="pinid" id="pinid_editPin" value=<%= request.getParameter("pinid")%>>
    		<input type="hidden" name="bid" id="bid" value=<%= request.getParameter("bid")%>>  
    		<input type="hidden" name="picnum" id="picnum">  
    		
    		<!-- <h1 class="pinFormHeader">Edit Pin</h1> -->
			<div class="Module PinPreview" align="center"
    				style="width:145px;height:145px;float:right;margin-right:20px;overflow-x:hidden; overflow-y:hidden;position:relative;
    				margin-bottom:0px;margin-left:0px;margin-top:25px;max-width:180px;max-height:250px;
    				border:2px gray solid;background-color:#eee;border-radius:3px">
            		<img class="pinPreviewImg pinImage" style="max-height:145px;max-width:145px;margin-left:auto auto" id="editPinPreviewImg">
            	</div>
			<ul>
                <%-- <li class="boardWrapper" >
            		<h3><label>Board</label></h3>
              		<div class="dropdown">
                		<button class=" BoardPickerDropdownButton Button DropdownButton Module btn primary rounded dropdown-toggle"  type="button" 
                			data-toogle="dropdown" aria-expanded="true" id="editPinChangeBoardButton" >
							<!-- <span class="downArrow"></span> -->        
							<div class="BoardLabel Module compact">
								<span class="nameAndIcons">
    								<div class="BoardIcons Module pinCreate3"></div>
    								<div class="name" id="selectedBoardNameDiv"><%= request.getParameter("bname")%></div>
								</span>
							</div>
						</button>
						<ul class="dropdown-menu" role="menu" aria-labelledby="editPinChangeBoardButton" id="changeBoard" style="position:relative;float:left;width:318px; min-height:300px" ></ul>            			
            		</div>
        		</li> --%>
        		<li class="boardWrapper" style="height:auto">
            			<h3 style="width:140px"><label>Board</label></h3>            			
            			<div class="dropdown" style="margin-top:15px;margin-bottom:10px;margin-left:0px">
                			<button class="  BoardPickerDropdownButton Button DropdownButton Module btn rounded dropdown-toggle" type="button"
                			 id="editPinPickBoardButton" data-toggle="dropdown" aria-expanded="true" >
								<%-- <span class="downArrow"></span> --%>
								<div class="BoardLabel Module compact">
									<span class="nameAndIcons">
    									<div class="name" id="editPinSelectSpan" style="height:16px;width:350px">Board name</div>
									</span>
								</div>
							</button>
							<ul class="dropdown-menu selectBoard" role="menu" aria-labelledby="editPinPickBoardButton" id="changeBoard" style="position:relative;float:left;width:318px"></ul>
            			</div>
       				</li>
        		<li>
            		<h3 style="width:140px"><label for="noteEdit">Description</label></h3>
            		<div style="margin-left:140px">
                		<div class="Field Module TextField">
							<textarea id="noteEdit" name="note" id="note" class="content     " placeholder="What's this Pin all about?">test</textarea>
						</div>
            		</div>
        		</li>
				<!-- <li>
                	<h3 style="width:140px"><label for="sourceUrlEdit">Source</label></h3>
                	<div>
                    	<input type="url" name="sourceUrl" id="sourceUrlEdit" value="">
                	</div>
            	</li> -->
			</ul>
			<div class="formFooter">
            	<div class="formFooterDelete">
                	<button class="Button Module btn deleteButton hasText rounded" type="button">    
						<span class="buttonText">Delete Pin</span>
        			</button>
            	</div>
				<div class="formFooterButtons">
                	<button class=" Button Module btn cancelButton hasText rounded" type="button">    
						<span class="buttonText">Cancel</span>
        			</button>
					<button class="Button Module btn hasText primary rounded savePinButton" type="submit">    
						<span class="buttonText">Save Changes</span>
        			</button>
        		</div>
    		</div>
		</form>
   	  <!-- </div>
      
    </div>/.modal-content
  </div>/.modal-dialog
</div>/.modal -->
  </body>
</html>
