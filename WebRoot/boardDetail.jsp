<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>boardDetail</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/scss/bundle-desktop-main.65495e3e.css">
    <link rel="stylesheet" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/scss/bundle-desktop-2.32eb45a8.css">
	<link rel="subresource" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/sprites/webapp-common-above_the_fold-1x.20428f0e.png">
	<link rel="chrome-webstore-item" href="https://chrome.google.com/webstore/detail/gpdjojdkbbmdfjfahjcgigfpmkopogic">
	<link rel="apple-touch-icon" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/images/logo_trans_144x144.4d67817d.png">
    <link rel="icon" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/images/favicon.5d5f2dc6.png">
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="Pinterest">
    <link rel="publisher" href="https://plus.google.com/+pinterest">
	<link href="css/bundle-desktop-1_821b4580.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/dbcommon.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_442c9884.css" rel="stylesheet" type="text/css">
	<!-- <link href="css/bundle-desktop-1_7e764a10.css" rel="stylesheet" type="text/css"> -->
    
   	<script src="https://s-media-cache-ak0.pinimg.com/assets/js/dns.js" async="" defer=""></script>	
   	<script src="js/jquery.min.js"></script>
   	<script src="js/bootstrap.js"></script>
   	<script src="js/common.js"></script>
   	<script src="js/jquery.masonry.min.js"></script>
    <script src="js/modernizr-transitions.js"></script>
    <script src="js/jquery.form.min.js"></script>
    <script type="text/javascript">
    function editBoard(){
  			document.getElementById("editboardform").style.display="block";
  			//$("#editboardform").css("margin-top:-300px");
  		} 
  		
  		function saveChange(){
  			document.editboardform.action="editBoard";
  			document.editboardform.submit();
  		} 
  		function deleteBoard(){
  			document.editboardform.action="deleteBoard";
  			document.editboardform.submit();
  		}
    $(function(){
    	
    	var $bid = $("#bid").val(); 
    	/* var $isAuthor = ($("#curUser").text() === $("#username").val());
    	//$("#boardInfoBarWrapper").load("modules/authorBoardButtons.jsp");
    	$("#author").text("abcd");
    	var $curUser = $("#curUser").text();
    	var $author = $("#username").val();
    	console.log("isAuthor: " + $isAuthor + "; curUser = " + $curUser + "; username = " + $author);
    	 *//*if ($isAuthor) {
    		$("#boardInfoBarWrapper").load("modules/authorBoardButtons.jsp");
    	} else {
    		$("#boardInfoBarWrapper").load("modules/visitorBoardButtons.html");
    	} */
    	//setOperationBar($("#currentUser").text(), $("#author").text());
    	/* $.ajax({
			type:'GET',
			dataType:'json',
			url:'queryBoardStatistic.action',
			data:{username:$("#usernameSpan").text()},
			success: function(data, textStatus) {
				var $stat = data.boardStat;
				$("#pinCountSpan").text($stat.pinCount);
				$("#followerCountSpan").text($stat.followerCount);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {					console.error("stat error!");
			},
		}); */
		
		$.ajax({
			type:'GET',
			dataType:'json',
			url:'queryBoardByBidJson.action',
			data:{bid:$bid},
			success: function(data, textStatus) {
				$author = data.board.user.username;
				$curUser = $("#curUser").text();
				$("#author").text($curUser);
				var $isAuthor = ($curUser === $author);
				console.log("isAuthor: " + $isAuthor + "; curUser = " + $curUser + "; username = " + $author);
    					
				if (!$isAuthor) {
					$(".boardButtons").children().remove();
					$visitorBoardButtons = $(
"<form id='addFollowForm' method='GET' action='addFollow.action'><button class='NotAuthor BoardFollowButton Button FollowButton Module boardFollowUnfollowButton btn hasText notNavigatable primary rounded' type='submit'>"+ 
	"<span class='buttonText'>Follow board</span></button><em></em>" +
"<input type='text' name='stream' placeholder='(Stream)'></form>"					
					);
					$(".boardButtons").append($visitorBoardButtons);
					$("#addFollowForm").ajaxForm({
						url: 'addFollow.action',
						type: 'GET',
						dataType: 'json',
						data:{bid:$bid},
						success: function(data, textStatus) {
							alert("Add follow success!");//TODO
						},
						error: function(XMLHttpRequest, textStatus, errorThrown) {
							console.error("addFollow error!");
						},
						input: function(data, textStatus) {
							console.error("errorcode:" + data.idfollow);
						},
					});
				}    	
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				console.error("queryBoardByBidJson error!");
			},
		});
		
		
			
    	$.ajax({
			type:'GET',
			dataType:'json',
			url:'queryPinsByBid.action',
			data:{bid:$bid},
			success: function(data, textStatus) {
				var $container = $("#masonryContainer");
				$container.children().remove();
				$.each(data.pinList, function() {
					var $pinid = this.pinid;
					var $url = this.picture.url; console.log(this);
					var $note = this.note;
					var $bname = this.board.bname;
					var $bid = this.board.bid;
					
					var $element = $("<div class='masonryItem  ui-draggable ui-draggable-disabled ui-state-disabled' aria-disabled='true' style='margin-bottom: 10px;'>" + 
    "<div class='Module Pin summary' data-component-type='0'>" + 
        "<div class='pinWrapper'>" + 
            "<div class='bulkEditPinWrapper'></div>" + 
            "<div class='pinImageActionButtonWrapper'>" + 
                "<div class='repinSendButtonWrapper'>" + 
                    "<button class='Button Module ShowModalButton btn primary primaryOnHover repinSmall rounded' data-element-type='0' type='button'" + 
                    	"style='height:33px'>" +
                        "<span class='glyphicon glyphicon-pushpin'></span>" +
                        "<span class='buttonText'>Pin it</span>" +
                    "</button>" +
                    "<button class='Button DropdownButton Module btn hasText rounded sendSmall sendPinGrid' data-element-type='98' type='button'" +
                    	"style='height:33px'>" +
                        "<span class='glyphicon glyphicon-send'></span>" +
                        "<span class='buttonText'>Send</span>" +
                    "</button>" +
                "</div>" +
                "<div class='likeEditButtonWrapper'>" +                                                                            
                    "<button class='Button LikeButton Module PinLikeButton btn likeSmall rounded' data-element-type='1' data-source-interest-id='945391946569'" +
                   "data-text-like='Like' data-text-unlike='Unlike' type='button'  style='height:33px'>" +
                        "<span class='glyphicon glyphicon-heart-empty'></span>" +
                    "</button>" +
                "</div>" +
                "<a class='Button Module NavigateButton borderless hasText pinNavLink navLinkOverlay' data-element-type='162' " +
                    "href='http://havsandlabs.wordpress.com/havanese/' rel='nofollow' type='button'>" +        
                    "<em class='glyphicon glyphicon-leaf' style='color:white'></em>" +
                    "<span class='buttonText'>Learn more at havsandlabs.wordpress.com</span>" +        
                "</a>" +                                                                                                       
                "<div class='pinHolder'>" +
                    //"<a href='/pinDetail.jsp?pinid=" + $pinid +"&url=" + $url + "&author=" + $author + "' class='pinImageWrapper draggable' data-element-type='35' style='background: #5a1321;'>" +
                      "<a href='pinDetail.jsp?pinid=" + $pinid + "&bid=" + $bid + "&bname=" + $bname + "'class='pinImageWrapper draggable' data-element-type='35' style='background: #5a1321;'>" +                  
                        "<div class='pinDomain'>rosasenaturezas.tumblr.com></div>" +
                        "<div class='fadeContainer'>" +
                            "<div class='pinImageDim'>" +
                                "<div class='dimOverlay'></div>" +
                                "<div class='dimGradient'></div>" +
                            "</div>" +
                            "<div class='Image Module pinUiImage'>" +
                                "<div>" +
                                    "<img id='img_" + $pinid + "'src='" + $url + "' class='pinImg fullBleed loaded fade' style='' onload='' alt=''>" +
                                "</div>" +
                            "</div>" +
          				"</div>" +
                    "</a>" +
                "</div>" +
            "</div>" +

            "<div class='pinMeta '>" +
                "<p class='pinDescription'></p>" +
                "<div class='Module SocialIconsCounts'>" +
                    "<div class='pinSocialMeta'>" +
                    "<a class='socialItem' href='/pin/338895940687224815/repins/' data-element-type='174'>" +
                        "<em class='glyphicon glyphicon-share-alt'></em><em></em>" +
                        "<em class='socialMetaCount repinCountSmall' id='rcem_" + $pinid + "'></em>" +
                    "</a>" +
                    "<a class='socialItem likes' href='/pin/338895940687224815/likes/' data-element-type='175'>" +
                        "<em class='glyphicon glyphicon-heart'></em><em></em>" +
                        "<em class='socialMetaCount likeCountSmall' id='lcem_" + $pinid+  "'></em>" +
                    "</a>" +
                    "</div>" +
                "</div>" +
            "</div>" +

            "<div class='pinCredits'>" +
                "<div class='creditItem '>" +
                    "<a href='boardDetail.jsp?bname=" + $bname + "&bid=" + $bid + "&info=" + this.info + "'>" +
                        "<div class='Image Module creditImg'>" +
                            "<div>" +
                                "<img src='https://s-media-cache-ak0.pinimg.com/30x30/55/6f/9a/556f9afacbd32e1528c3b4d068324b59.jpg' style='' alt='Dresses' data-src='https://s-media-cache-ak0.pinimg.com/30x30/55/6f/9a/556f9afacbd32e1528c3b4d068324b59.jpg'>" +
                            "</div>" +
                        "</div>" +
                        "<div class='creditName'>Found in</div> " +
                        "<div class='creditTitle' id='bid_" + $bid + "'>" + $bname + "</div>" +
                    "</a>" +
                "</div>" +
            "</div>" 											
					);
					$container.append($element);
					//$container.imagesLoaded( function(){
					$container.masonry({
						itemSelector : ".masonryItem",
					    columnWidth:236,
					    gutterWidth:10,
					    isFitWidth:true
					});
				//});
				});
				
				$.each(data.pinStatList, function() {
					var $pinid = this.pinid;
					var $rc = this.repinCount;
					var $lc = this.likeCount;
					$("#rcem_" + $pinid).text(($rc)>0 ? $rc : "");
					$("#lcem_" + $pinid).text(($lc)>0 ? $rc : "");					
				});		
										
				$container.imagesLoaded( function(){
					$("#masonryContainer").masonry({
						itemSelector : '.masonryItem',
					    columnWidth:236,
					    gutterWidth:10,
					    isFitWidth:true
					});
				});
				
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				console.error("queryPinsByBid error!");
			},
		});
    })
    
    $(window).resize(function() {
			$('#headerContainer').width($('#headerBackground').width());
		})
    /* function setOperationBar(cuser, author) {
    	if (cuser == author) {
    		$(".IsAuthor").css("display", "none");
    		$(".NotAuthor").css("display", "block");
    	} else {
    		$(".IsAuthor").css("display", "block");
    		$(".NotAuthor").css("display", "none");
    	}
    }  */   
    </script>
    	

  </head>
  
  <body class="noTouch">
  	<jsp:include page="./modules/header.jsp" />
	<jsp:include page="./modules/footer.jsp"/>
  	
  	<div id="curUser" style="display:none"><s:property value='#session.username'></s:property></div>
  	<input type="hidden" id="username" value=<%= request.getParameter("username")%>>
<div class="App AppBase Module full" data-component-type="17">                       
<div class="appContent">
    <div class="mainContainer">
    	<div class="Module Nags centeredWithinWrapper"></div>
		<div class="BoardPage Module fadeIn" style="min-height: 624px;">
				<div class="addPinAnchor"></div>
				<div class="locationBoardContentWrapperBackground"></div>
				<div class="locationBoardPageContentWrapper">
    				<div class="transformWrapper">
						<div class="BoardInvite Module hidden"></div>
						<div class="BoardHeader Module gridWidth">
							<div class="boardHeaderWrapper centeredWithinWrapper">
								<h1 class="boardName"><%= request.getParameter("bname") %></h1>
    								<p class="description"><%= request.getParameter("info") %></p>
									<div class="divider"><hr>
        							</div>
    						</div>
							<div class="BoardInfoBar Module boardHeaderBackground" data-component-type="69" style="padding-left:25px; padding-right:25px">
								<div id="boardInfoBarWrapper" class="infoBarWrapper gridWidth centeredWithinWrapper">				
	    							<div class="boardButtons" style="height:30px;">
	    								<button class="IsAuthor Button Module btn1 hasText movePinsButton rounded" data-element-type="400" type="button"  style="height:30px; ">
											<span class="buttonText">Move Pins</span>
	        							</button>
										<button id="editBoardButton" onclick="editBoard()" class="IsAuthor Button Module ShowModalButton boardEditButton btn1 hasText rounded" type="button" style="height:30px; ">
											<span class="buttonText">Edit Board</span>
										</button>										
									</div>
									<div class="collaborators  showName">
	        							<div class="Module User hasText inline small thumbUserInfo">
											<a href="/liupenghuigarde/" data-element-type="64">
												<div class="thumbImageWrapper">
													<img src="https://s-passets-cache-ak0.pinimg.com/images/user/default_60.png" alt="Jasmine Liu" title="More from Jasmine Liu">
	        									</div>
												<h4 class="fullname" id="author"><%= request.getParameter("username") %></h4>
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
												<span class="value" id="pinCountSpan">7</span> 
												<span class="label">Pins</span>
	    									</li>
											<li>
	                        					<button class="Button Module ShowModalButton borderless followerCount hasText" type="button">
													<em></em>
													<span class="buttonText">
														<span class="value" id="followerCountSpan">0</span> 
														<span class="label">Followers</span>
													</span>        
												</button>
	                    					</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="Grid Module hasFooter" style="background-color:#eee">
							<div class="GridItems Module centeredWithinWrapper padItems variableHeightLayout" id="masonryContainer" style="padding-top:10px">
								<div class="masonryItem  ui-draggable ui-draggable-disabled ui-state-disabled" aria-disabled="true" style="visibility:visible" >
									<a class="AddPinRep ModalTrigger Module" data-element-type="450" href="#">
										<i></i>
										<span>Add a Pin</span>
									</a>
								</div>
								<div class="masonryItem ui-draggable ui-draggable-disabled ui-state-disabled" aria-disabled="true"  style="visibility:visible">
									<div class="Module Pin summary" data-component-type="0">
										<div class="pinWrapper">
											<div class="bulkEditPinWrapper">
												<button class="Button Module btn1 bulkEditCheckbox rounded" type="button">
													<em></em>
													<span class="accessibilityText">Select Pin</span>
												</button>
											</div>
											<div class="pinImageActionButtonWrapper">
												<div class="repinSendButtonWrapper" style="font-size:13px">
													<button class="Button Module ShowModalButton btn1 primary primaryOnHover repinSmall rounded" data-element-type="0" type="button">
														<!-- <em class="glyphicon glyphicon-pushpin"></em>
														<span class="accessibilityText">Pin it</span> -->
														<span class="glyphicon glyphicon-pushpin" ></span>
														<span class="buttonText">Pin it</span>
													</button>
													<button class="Button DropdownButton Module btn1 hasText rounded sendSmall sendPinGrid" data-element-type="98" type="button">
														<em class="glyphicon glyphicon-send"></em>
														<span class="buttonText">Send</span>
        											</button>
												</div>
												<div class="likeEditButtonWrapper" style="font-size:13px">
													<button class="Button Module ShowModalButton btn1 editPin rounded" data-element-type="3" type="button">
														<em class="glyphicon glyphicon-edit"></em>
														<span class="accessibilityText">Edit</span>
													</button>
												</div>
												<div class="pinHolder">
													<a href="/pin/345932815104611648/" class="pinImageWrapper draggable" data-element-type="35" style="background: #aaa89a;">
														<div class="pinDomain hidden">etsy.com</div>
														<div class="fadeContainer">
															<div class="hoverMask"></div>
															<div class="Image Module pinUiImage" style="width: 236px">
																<div class="heightContainer" style="padding-bottom: 75.0000000%">
																	<img src="https://s-media-cache-ak0.pinimg.com/474x/fa/cb/88/facb888b13d3655ac510f3202429ca50.jpg" class="pinImg fullBleed loaded fade" style="" onload="" alt="Neon Hot Pink and Grey Chevron Dog Collar by JazzyJDesigns on Etsy, $18.00  www.jazzyjdesigns.com Jazzy J Designs">
																</div>
															</div>
														</div>
													</a>
												</div>
        									</div>
											<div class="richPinMeta">
												<a href="/pin/345932815104611648/" class="richPinMetaLink">
													<div class="richIconAndAttribution">
														<div class="Image Module richPinIcon">
															<div class="heightContainer">
																<img src="https://s-media-cache-ak0.pinimg.com/favicons/fb7d72f4731f6cfba3c3e3928fe9656703ed7deae75c5c897e8c060d.png?c1fcaf6756c82fcb372b575f38a43805" style="" alt="Etsy" data-src="https://s-media-cache-ak0.pinimg.com/favicons/fb7d72f4731f6cfba3c3e3928fe9656703ed7deae75c5c897e8c060d.png?c1fcaf6756c82fcb372b575f38a43805">
															</div>
														</div>                                
                                						<span class="richPinGridAttributionTitle">from Etsy</span>
                            						</div>
													<h3 class="richPinGridTitle">Neon Hot Pink and Grey Chevron Dog Collar</h3>
												</a>
											</div>
											<div class="pinMeta ">
												<p class="pinDescription">Neon Hot Pink and Grey Chevron Dog Collar by JazzyJDesigns on Etsy, $18.00  
													<a href="http://www.jazzyjdesigns.com" target="_blank" rel="nofollow">www.jazzyjdesigns...</a>
													 Jazzy J Designs
												</p>
												<div class="Module SocialIconsCounts">
													<div class="pinSocialMeta">
														<a class="socialItem" href="/pin/345932815104611648/repins/" data-element-type="174">
															<!-- <em class="repinIconSmall"></em>
            												<em class="socialMetaCount repinCountSmall">1</em> -->
									                        <em class="glyphicon glyphicon-share-alt"></em>
									                        <em class="socialMetaCount repinCountSmall">14</em>
        												</a>
        												<a class="socialItem likes" href="/pin/338895940687224815/likes/" data-element-type="175">
									                        <!-- <em class="likeIconSmall"></em>  -->
									                        <em class="glyphicon glyphicon-heart"></em>
									                        <em class="socialMetaCount likeCountSmall">11</em>
									                    </a>
													</div>
												</div>
											</div>
											<div class="pinCredits">
												<div class="creditItem ">
													<a href="/source/etsy.com/">
														<div class="creditName">Pinned from</div>
                            								<div class="creditTitle">etsy.com</div>                        
                            						</a>
												</div>
											</div>
										</div>
									</div>
								</div>
                     
        						<div class="masonryItem ui-draggable ui-draggable-disabled ui-state-disabled" aria-disabled="true" style="top: 447px; left: 250px; visibility: visible;">
									<div class="Module Pin summary" data-component-type="0">
										<div class="pinWrapper">
       										 <div class="bulkEditPinWrapper">
												<button class="Button Module btn1 bulkEditCheckbox rounded" type="button">
													<em></em>
													<span class="accessibilityText">Select Pin</span>
												</button>
											</div>
											<div class="pinImageActionButtonWrapper">
												<div class="repinSendButtonWrapper" style="font-size:13px">
													<button class="Button Module ShowModalButton btn1 primary primaryOnHover repinSmall rounded" data-element-type="0" type="button">
														<!-- <em class="glyphicon glyphicon-pushpin"></em>
														<span class="accessibilityText">Pin it</span> -->
														<span class="glyphicon glyphicon-pushpin" ></span>
														<span class="buttonText">Pin it</span>
													</button>
													<button class="Button DropdownButton Module btn1 hasText rounded sendSmall sendPinGrid" data-element-type="98" type="button">
														<em class="glyphicon glyphicon-send"></em>
														<span class="buttonText">Send</span>
        											</button>
												</div>
												<div class="likeEditButtonWrapper"  style="font-size:13px">
													<button class="Button Module ShowModalButton btn1 editPin rounded" data-element-type="3" type="button">
														<em class="glyphicon glyphicon-edit"></em>
														<span class="accessibilityText">Edit</span>
													</button>
												</div>
												<div class="pinHolder">
													<a href="/pin/345932815104575181/" class="pinImageWrapper draggable" data-element-type="35" style="background: #616161;">
														<div class="fadeContainer">
															<div class="hoverMask"></div>
															<div class="Image Module pinUiImage" style="width: 236px">
																<div class="heightContainer" style="padding-bottom: 75.0000000%">
																	<img src="https://s-media-cache-ak0.pinimg.com/474x/23/0c/b3/230cb3583baa4be227754dff15ca560d.jpg" class="pinImg fullBleed loaded fade" style="" onload="" alt="test2">
																</div>
															</div>                        
                    									</div>                
                    								</a>                
            									</div>
        									</div>
											 <div class="pinMeta ">
                
                
                    

                    
                    <p class="pinDescription">
                        
                            test2
                        

                    
                

                
    


                

                
                    </p><div class="Module SocialIconsCounts">










<div class="pinSocialMeta">
    
        
        <a class="socialItem" href="/pin/345932815104575181/repins/" data-element-type="174">
            <!-- <em class="repinIconSmall"></em>
            <em class="socialMetaCount repinCountSmall">
                1
            </em> -->
            <!-- <em class="repinIconSmall"></em> -->
            <em class="glyphicon glyphicon-share-alt"></em>
            <em class="socialMetaCount repinCountSmall">14</em>
        </a>
    	<a class="socialItem likes" href="/pin/338895940687224815/likes/" data-element-type="175">
            <!-- <em class="likeIconSmall"></em>  -->
            <em class="glyphicon glyphicon-heart"></em>
            <em class="socialMetaCount likeCountSmall">11</em>
        </a>        
</div>
</div>
                
            </div>
        

        

        
            

            
            
            
            
            

            <div class="pinCredits">
                
                
                    
                    
                    

                    
                        
                    
                    

                    <div class="creditItem ">
                    
                        
                            <a href="/liupenghuigarde/">
                        
                            
                                
                                
                                    
                                
                                <div class="Image Module creditImg user">





    


<div class="heightContainer">
    
    

    <img src="https://s-passets-cache-ak0.pinimg.com/images/user/default_280.png" style="" alt="Jasmine Liu" data-src="https://s-passets-cache-ak0.pinimg.com/images/user/default_280.png">

</div>
</div>
                            

                            <div class="creditName">Uploaded by</div>
                            
                                <div class="creditTitle">
                            
                                
                                Jasmine Liu
                            </div>
                        
                            </a>
                        
                    
                    
                    </div>

                    
                
            </div>
        

        

        
        
    </div>

</div>
            

            
        </div>
   
        						<div class="masonryItem ui-draggable ui-draggable-disabled ui-state-disabled" aria-disabled="true" style="visibility:visible">

            
            

            
            
                
                
                
                

                
                
                
                    
                    
                
                
                    
                
                

                <div class="Module Pin summary" data-component-type="0">













    






























































    <div class="pinWrapper">
        
        
        
        
            
            
        

        
        
        
        
        
        
        

        

        

        
        
        
        

        
            
            
            
                
            
            
            
            
        

        

        

        

        
        
        
        
        
            
            
            
            
            
            
            
        
        <div class="bulkEditPinWrapper">
            
                <button class="Button Module btn1 bulkEditCheckbox rounded" type="button">




    




<em></em>
<span class="accessibilityText">Select Pin</span>
</button>
            
        </div>
        
        <div class="pinImageActionButtonWrapper">
            
            
            
                <div class="repinSendButtonWrapper" style="font-size:13px">
													<button class="Button Module ShowModalButton btn1 primary primaryOnHover repinSmall rounded" data-element-type="0" type="button">
														<!-- <em class="glyphicon glyphicon-pushpin"></em>
														<span class="accessibilityText">Pin it</span> -->
														<span class="glyphicon glyphicon-pushpin" ></span>
														<span class="buttonText">Pin it</span>
													</button>
													<button class="Button DropdownButton Module btn1 hasText rounded sendSmall sendPinGrid" data-element-type="98" type="button">
														<em class="glyphicon glyphicon-send"></em>
														<span class="buttonText">Send</span>
        											</button>
												</div>
												<div class="likeEditButtonWrapper" style="font-size:13px">
													<button class="Button Module ShowModalButton btn1 editPin rounded" data-element-type="3" type="button">
														<em class="glyphicon glyphicon-edit"></em>
														<span class="accessibilityText">Edit</span>
													</button>
												</div>
            <div class="pinHolder">
                

                
                
                
                    
                
                
                    <a href="/pin/345932815104575084/" class="pinImageWrapper draggable" data-element-type="35" style="background: #746e6f;">
                
                    
                    <div class="fadeContainer">
                        
                            <div class="hoverMask"></div>
                        
                        
                        
                        
                        
                        
                        
                        
                            
                        

                        

                        
                            
                        
                        
                            <div class="Image Module pinUiImage" style="width: 236px">




    


    


    

<div class="heightContainer" style="padding-bottom: 94.9152542%">
    
    

    <img src="https://s-media-cache-ak0.pinimg.com/474x/53/d8/38/53d838633c0479d13326e9238fb4f839.jpg" class="pinImg fullBleed loaded fade" style="" onload="" alt="test1">

</div>
</div>
                        
                    </div>
                
                    </a>
                
            </div>
        </div>

        
        
        
        
        
        
        
        
        
        
            

            
                
                
            

            

            

            
            

            <div class="pinMeta ">
                
                
                    

                    
                    <p class="pinDescription">
                        
                            test1
                        

                    
                

                
    


                

                
                    </p><div class="Module SocialIconsCounts hidden">









    


<div class="pinSocialMeta">
    
    
    
</div>
</div>
                
            </div>
        

        

        
            

            
            
            
            
            

            <div class="pinCredits">
                
                
                    
                    
                    

                    
                        
                    
                    

                    <div class="creditItem ">
                    
                        
                            <a href="/liupenghuigarde/">
                        
                            
                                
                                
                                    
                                
                                <div class="Image Module creditImg user">





    


<div class="heightContainer">
    
    

    <img src="https://s-passets-cache-ak0.pinimg.com/images/user/default_280.png" style="" alt="Jasmine Liu" data-src="https://s-passets-cache-ak0.pinimg.com/images/user/default_280.png">

</div>
</div>
                            

                            <div class="creditName">Uploaded by</div>
                            
                                <div class="creditTitle">
                            
                                
                                Jasmine Liu
                            </div>
                        
                            </a>
                        
                    
                    
                    </div>

                    
                
            </div>
        

        

        
        
    </div>

</div>
            

            
        </div>
								<div class="masonryItem ui-draggable ui-draggable-disabled ui-state-disabled" aria-disabled="true"  style="visibility:visible">
									<div class="Module Pin summary" data-component-type="0">
										<div class="pinWrapper">
											<div class="bulkEditPinWrapper">
												<button class="Button Module btn1 bulkEditCheckbox rounded" type="button">
													<em></em>
													<span class="accessibilityText">Select Pin</span>
												</button>
											</div>
											<div class="pinImageActionButtonWrapper">
												<div class="repinSendButtonWrapper" style="font-size:13px">
													<button class="Button Module ShowModalButton btn1 primary primaryOnHover repinSmall rounded" data-element-type="0" type="button">
														<!-- <em class="glyphicon glyphicon-pushpin"></em>
														<span class="accessibilityText">Pin it</span> -->
														<span class="glyphicon glyphicon-pushpin" ></span>
														<span class="buttonText">Pin it</span>
													</button>
													<button class="Button DropdownButton Module btn1 hasText rounded sendSmall sendPinGrid" data-element-type="98" type="button">
														<em class="glyphicon glyphicon-send"></em>
														<span class="buttonText">Send</span>
        											</button>
												</div>
												<div class="likeEditButtonWrapper" style="font-size:13px">
													<button class="Button Module ShowModalButton btn1 editPin rounded" data-element-type="3" type="button">
														<em class="glyphicon glyphicon-edit"></em>
														<span class="accessibilityText">Edit</span>
													</button>
												</div>
												<div class="pinHolder">
													<a href="/pin/345932815104611648/" class="pinImageWrapper draggable" data-element-type="35" style="background: #aaa89a;">
														<div class="pinDomain hidden">etsy.com</div>
														<div class="fadeContainer">
															<div class="hoverMask"></div>
															<div class="Image Module pinUiImage" style="width: 236px">
																<div class="heightContainer" style="padding-bottom: 75.0000000%">
																	<img src="https://s-media-cache-ak0.pinimg.com/474x/fa/cb/88/facb888b13d3655ac510f3202429ca50.jpg" class="pinImg fullBleed loaded fade" style="" onload="" alt="Neon Hot Pink and Grey Chevron Dog Collar by JazzyJDesigns on Etsy, $18.00  www.jazzyjdesigns.com Jazzy J Designs">
																</div>
															</div>
														</div>
													</a>
												</div>
        									</div>
											<div class="richPinMeta">
												<a href="/pin/345932815104611648/" class="richPinMetaLink">
													<div class="richIconAndAttribution">
														<div class="Image Module richPinIcon">
															<div class="heightContainer">
																<img src="https://s-media-cache-ak0.pinimg.com/favicons/fb7d72f4731f6cfba3c3e3928fe9656703ed7deae75c5c897e8c060d.png?c1fcaf6756c82fcb372b575f38a43805" style="" alt="Etsy" data-src="https://s-media-cache-ak0.pinimg.com/favicons/fb7d72f4731f6cfba3c3e3928fe9656703ed7deae75c5c897e8c060d.png?c1fcaf6756c82fcb372b575f38a43805">
															</div>
														</div>                                
                                						<span class="richPinGridAttributionTitle">from Etsy</span>
                            						</div>
													<h3 class="richPinGridTitle">Neon Hot Pink and Grey Chevron Dog Collar</h3>
												</a>
											</div>
											<div class="pinMeta ">
												<p class="pinDescription">Neon Hot Pink and Grey Chevron Dog Collar by JazzyJDesigns on Etsy, $18.00  
													<a href="http://www.jazzyjdesigns.com" target="_blank" rel="nofollow">www.jazzyjdesigns...</a>
													 Jazzy J Designs
												</p>
												<div class="Module SocialIconsCounts">
													<div class="pinSocialMeta">
														<a class="socialItem" href="/pin/345932815104611648/repins/" data-element-type="174">
															<!-- <em class="repinIconSmall"></em>
            												<em class="socialMetaCount repinCountSmall">1</em> -->
            												<!-- <em class="repinIconSmall"></em> -->
                        									<em class="glyphicon glyphicon-share-alt"></em>
                        									<em class="socialMetaCount repinCountSmall">14</em>
        												</a>
        												<a class="socialItem likes" href="/pin/338895940687224815/likes/" data-element-type="175">
									                        <!-- <em class="likeIconSmall"></em>  -->
									                        <em class="glyphicon glyphicon-heart"></em>
									                        <em class="socialMetaCount likeCountSmall">11</em>
									                    </a>
													</div>
												</div>
											</div>
											<div class="pinCredits">
												<div class="creditItem ">
													<a href="/source/etsy.com/">
														<div class="creditName">Pinned from</div>
                            								<div class="creditTitle">etsy.com</div>                        
                            						</a>
												</div>
											</div>
										</div>
									</div>
								</div>
    
    							<div class="masonryItem ui-draggable ui-draggable-disabled ui-state-disabled" aria-disabled="true"  style="visibility:visible">
									<div class="Module Pin summary" data-component-type="0">
										<div class="pinWrapper">
											<div class="bulkEditPinWrapper">
												<button class="Button Module btn1 bulkEditCheckbox rounded" type="button">
													<em></em>
													<span class="accessibilityText">Select Pin</span>
												</button>
											</div>
											<div class="pinImageActionButtonWrapper">
												<div class="repinSendButtonWrapper" style="font-size:13px">
													<button class="Button Module ShowModalButton btn1 primary primaryOnHover repinSmall rounded" data-element-type="0" type="button">
														<!-- <em class="glyphicon glyphicon-pushpin"></em>
														<span class="accessibilityText">Pin it</span> -->
														<span class="glyphicon glyphicon-pushpin" ></span>
														<span class="buttonText">Pin it</span>
													</button>
													<button class="Button DropdownButton Module btn1 hasText rounded sendSmall sendPinGrid" data-element-type="98" type="button">
														<em class="glyphicon glyphicon-send"></em>
														<span class="buttonText">Send</span>
        											</button>
												</div>
												<div class="likeEditButtonWrapper" style="font-size:13px">
													<button class="Button Module ShowModalButton btn1 editPin rounded" data-element-type="3" type="button">
														<em class="glyphicon glyphicon-edit"></em>
														<span class="accessibilityText">Edit</span>
													</button>
												</div>
												<div class="pinHolder">
													<a href="/pin/345932815104611648/" class="pinImageWrapper draggable" data-element-type="35" style="background: #aaa89a;">
														<div class="pinDomain hidden">etsy.com</div>
														<div class="fadeContainer">
															<div class="hoverMask"></div>
															<div class="Image Module pinUiImage" style="width: 236px">
																<div class="heightContainer" style="padding-bottom: 75.0000000%">
																	<img src="https://s-media-cache-ak0.pinimg.com/474x/fa/cb/88/facb888b13d3655ac510f3202429ca50.jpg" class="pinImg fullBleed loaded fade" style="" onload="" alt="Neon Hot Pink and Grey Chevron Dog Collar by JazzyJDesigns on Etsy, $18.00  www.jazzyjdesigns.com Jazzy J Designs">
																</div>
															</div>
														</div>
													</a>
												</div>
        									</div>
											<div class="richPinMeta">
												<a href="/pin/345932815104611648/" class="richPinMetaLink">
													<div class="richIconAndAttribution">
														<div class="Image Module richPinIcon">
															<div class="heightContainer">
																<img src="https://s-media-cache-ak0.pinimg.com/favicons/fb7d72f4731f6cfba3c3e3928fe9656703ed7deae75c5c897e8c060d.png?c1fcaf6756c82fcb372b575f38a43805" style="" alt="Etsy" data-src="https://s-media-cache-ak0.pinimg.com/favicons/fb7d72f4731f6cfba3c3e3928fe9656703ed7deae75c5c897e8c060d.png?c1fcaf6756c82fcb372b575f38a43805">
															</div>
														</div>                                
                                						<span class="richPinGridAttributionTitle">from Etsy</span>
                            						</div>
													<h3 class="richPinGridTitle">Neon Hot Pink and Grey Chevron Dog Collar</h3>
												</a>
											</div>
											<div class="pinMeta ">
												<p class="pinDescription">Neon Hot Pink and Grey Chevron Dog Collar by JazzyJDesigns on Etsy, $18.00  
													<a href="http://www.jazzyjdesigns.com" target="_blank" rel="nofollow">www.jazzyjdesigns...</a>
													 Jazzy J Designs
												</p>
												<div class="Module SocialIconsCounts">
													<div class="pinSocialMeta">
														<a class="socialItem" href="/pin/345932815104611648/repins/" data-element-type="174">
															<!-- <em class="repinIconSmall"></em>
            												<em class="socialMetaCount repinCountSmall">1</em> -->
            												<!-- <em class="repinIconSmall"></em> -->
									                        <em class="glyphicon glyphicon-share-alt"></em>
									                        <em class="socialMetaCount repinCountSmall">14</em>
        												</a>
        												<a class="socialItem likes" href="/pin/338895940687224815/likes/" data-element-type="175">
									                        <!-- <em class="likeIconSmall"></em>  -->
									                        <em class="glyphicon glyphicon-heart"></em>
									                        <em class="socialMetaCount likeCountSmall">11</em>
									                    </a>
													</div>
												</div>
											</div>
											<div class="pinCredits">
												<div class="creditItem ">
													<a href="/source/etsy.com/">
														<div class="creditName">Pinned from</div>
                            								<div class="creditTitle">etsy.com</div>                        
                            						</a>
												</div>
											</div>
										</div>
									</div>
								</div>
    
							</div>
							<div class="GridFooter Module centeredWithinWrapper" style="display: block;">



<form class="standardForm" id="editboardform" name="editboardform" method="post" action="" style="display:none" >    
    			<h1 class="createTitle">
       				 Edit Board
    			</h1>
    			<input type="hidden" name="bid" id="bid" value=<%= request.getParameter("bid")%>>
    			<ul>        
            		<li>
                		<h3><label for="boardEditName" class="hasError">Name</label></h3>                
               	    	<div>
                    		<input id="boardEditName" name="bname" type="text" autofocus="" value=<%= request.getParameter("bname") %> >
                		</div>
           	    	</li>  
           	    	<li class="Wrapper">
                		<h3><label for="boardInfo">Description</label></h3>
                		<div>
                    		<textarea id="boardInfo" name="info" ></textarea>
                		</div>
            		</li>         
    			</ul>   
    		<div class="formFooter">
				<div class="formFooterDelete" style="float:left;" >
                	<button class="Button Module btn deleteBoardButton hasText rounded" type="button" onclick="deleteBoard()">
						<span class="buttonText">Delete Board</span>
        			</button>
            	</div>
				<div class="formFooterButtons" style="float:right;" >
            		<button class=" Button Module btn cancelButton hasText rounded" type="button">
						<span class="buttonText">Cancel</span>
        			</button>
					<button class="Button Module btn hasText primary rounded saveBoardButton" type="button" onclick="saveChange()">
						<span class="buttonText">Save Changes</span>
					</button>
        		</div>
				
			</div>
			</form>
<div class="gridError">
    <button class="Button btn1 rounded large">
        <span>Whoops! Something went wrong.</span> Try again.
    </button>
</div>
<div class="gridLoadingWrapper">
    <hr>
    <div class="gridLoading">
        <span class="gridFooterLogoIcon"></span>
        <span class="gridFooterSpinner"></span>
    </div>
</div>
</div>

							</div>   
    					</div>
					</div>
				</div>
		</div>
    <div class="appendedContainer"></div>
</div>
<div class="ActiveConversations Module"></div>
<div class="Module Toasts"></div>

<!-- <div class="Module NagBase NagNoScript">



    <noscript>
                
                
        &lt;div class="message"&gt;Oh no! Pinterest doesn't work unless you &lt;a href="http://enable-javascript.com/" rel="nofollow"&gt;turn on JavaScript.&lt;/a&gt;&lt;/div&gt;
    
        
        &lt;style&gt;
            .NagBase {
                display: none;
            }
        &lt;/style&gt;
    </noscript>
</div>
</div>   -->
</div>          

			
<div id="at-view" class="at-view" style="display: none;"><ul id="at-view-ul"></ul>
</div>
</body>
</html>
