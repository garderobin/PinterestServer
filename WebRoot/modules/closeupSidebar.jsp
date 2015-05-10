<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
	<%-- <link href="../css/bundle-desktop1_9f130f1f.css" rel="stylesheet" type="text/css">
	<link href="../css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../css/dbcommon.css" rel="stylesheet" type="text/css">
   	<script src="../js/jquery.min.js"></script>
   	<script src="../js/bootstrap.js"></script>
   	<script src="../js/common.js"></script>
   	<script src="../js/jquery.masonry.min.js"></script>
    <script src="../js/modernizr-transitions.js"></script> --%>
    <!-- <script type="text/javascript">
    $(function(){     		   		
		$.ajax({
			type:'GET',
			dataType:'json',				
			url:'queryPictureByBoard.action',
			data:{username:$("#usernameSpan").text()},
			success: function(data, textStatus) {
    </script> -->
    
<div class="CloseupSidebar Module">
    <div class="boardPinsGridContainer">
        <div class="Board Module boardPinsGrid" data-component-type="29">
            <div class="boardHeader">
                <!-- <div class="BoardIcons Module pinCreate3"></div> -->
                <div class="Module User boardRepTitle hasText thumb" style="width:208px; height:39px">
                    <a href="" data-element-type="52" id="sideBarAuthorLink">
                        <div class="thumbImageWrapper">
                            <img src="https://s-passets-cache-ak0.pinimg.com/images/user/default_150.png" alt="Misty Creager" title="More from Misty Creager">
                        </div>
                        <h3 class="title" id="bnameTitle" style="margin-top:0px;margin-bottom:5px;text-align:left; float:left; width:128px">Yuna Kim</h3>
                        <h4 class="fullname" id="authorTitle" style="margin-top:0px;margin-bottom:5px;text-align:left;float:left;width:128px" id="boardAuthorTitle"></h4>
                    </a>
    
                </div>
            </div>
            <div class="pinGridWrapper">
                <div class="Grid Module">
                    <div class="GridItems Module padItems trackActiveItem variableHeightLayout masonrySmall" id="masonrySmall">
                        <div class="masonrySmallItem  ui-draggable ui-draggable-disabled ui-state-disabled" tabindex="1" aria-disabled="true">
                            <div class="Module Pin boardPinsGrid" data-component-type="29">
                                <a href="/pin/400961173051081029/" class="boardPinsGridPin" data-element-type="35">
                                    <span class="hoverMask"></span>
                                    <img src="https://s-media-cache-ak0.pinimg.com/70x/2f/59/d7/2f59d7478b8bd5770ae03c6e24592c29.jpg">
                                </a>
                            </div>
                        </div>
                    	<div class="masonrySmallItem ui-draggable ui-draggable-disabled ui-state-disabled"  tabindex="1" aria-disabled="true">
                        	<div class="Module Pin boardPinsGrid" data-component-type="29">
                            	<a href="/pin/400961173051080990/" class="boardPinsGridPin" data-element-type="35">
                                	<span class="hoverMask"></span>
                                    	<img src="https://s-media-cache-ak0.pinimg.com/70x/82/0f/2e/820f2e5cd89f91572b8d46fa90b26e35.jpg">
                            	</a>
                        	</div>
                    	</div>
                    	<div class="masonrySmallItem activeItem ui-draggable ui-draggable-disabled ui-state-disabled" tabindex="1" aria-disabled="true" >
                        	<div class="Module Pin boardPinsGrid" data-component-type="29">
                            	<a href="/pin/400961173051078636/" class="boardPinsGridPin" data-element-type="35">
                                	<span class="hoverMask"></span>
                                    	<img src="https://s-media-cache-ak0.pinimg.com/70x/4a/34/eb/4a34eb2416f53cc3b4206a03b79dabc5.jpg">
                            	</a>
                        	</div>
                    	</div>
                    	<div class="masonrySmallItem ui-draggable ui-draggable-disabled ui-state-disabled"  tabindex="1" aria-disabled="true">
                        	<div class="Module Pin boardPinsGrid" data-component-type="29">
                            	<a href="/pin/400961173051080990/" class="boardPinsGridPin" data-element-type="35">
                                	<span class="hoverMask"></span>
                                    	<img src="https://s-media-cache-ak0.pinimg.com/70x/82/0f/2e/820f2e5cd89f91572b8d46fa90b26e35.jpg">
                            	</a>
                        	</div>
                    	</div>
                    	<div class="masonrySmallItem activeItem ui-draggable ui-draggable-disabled ui-state-disabled" tabindex="1" aria-disabled="true" >
                        	<div class="Module Pin boardPinsGrid" data-component-type="29">
                            	<a href="/pin/400961173051078636/" class="boardPinsGridPin" data-element-type="35">
                                	<span class="hoverMask"></span>
                                    	<img src="https://s-media-cache-ak0.pinimg.com/70x/4a/34/eb/4a34eb2416f53cc3b4206a03b79dabc5.jpg" style="height:93px;width:70px;">
                            	</a>
                        	</div>
                    	</div>
                    	<div class="masonrySmallItem ui-draggable ui-draggable-disabled ui-state-disabled"  tabindex="1" aria-disabled="true">
                        	<div class="Module Pin boardPinsGrid" data-component-type="29">
                            	<a href="/pin/400961173051080990/" class="boardPinsGridPin" data-element-type="35">
                                	<span class="hoverMask"></span>
                                    	<img src="https://s-media-cache-ak0.pinimg.com/70x/82/0f/2e/820f2e5cd89f91572b8d46fa90b26e35.jpg">
                            	</a>
                        	</div>
                    	</div>
                    	<div class="masonrySmallItem activeItem ui-draggable ui-draggable-disabled ui-state-disabled" tabindex="1" aria-disabled="true" >
                        	<div class="Module Pin boardPinsGrid" data-component-type="29">
                            	<a href="/pin/400961173051078636/" class="boardPinsGridPin" data-element-type="35">
                                	<span class="hoverMask"></span>
                                    	<img src="https://s-media-cache-ak0.pinimg.com/70x/4a/34/eb/4a34eb2416f53cc3b4206a03b79dabc5.jpg">
                            	</a>
                        	</div>
                    	</div>
                    	<div class="masonrySmallItem  ui-draggable ui-draggable-disabled ui-state-disabled"  tabindex="1" aria-disabled="true">
                        	<div class="Module Pin boardPinsGrid" data-component-type="29">
                            	<a href="/pin/400961173051080990/" class="boardPinsGridPin" data-element-type="35">
                                	<span class="hoverMask"></span>
                                    	<img src="https://s-media-cache-ak0.pinimg.com/70x/82/0f/2e/820f2e5cd89f91572b8d46fa90b26e35.jpg">
                            	</a>
                        	</div>
                    	</div>
                    	<div class="masonrySmallItem activeItem ui-draggable ui-draggable-disabled ui-state-disabled" tabindex="1" aria-disabled="true">
                        	<div class="Module Pin boardPinsGrid" data-component-type="29">
                            	<a href="/pin/400961173051078636/" class="boardPinsGridPin" data-element-type="35">
                                	<span class="hoverMask"></span>
                                    	<img src="https://s-media-cache-ak0.pinimg.com/70x/4a/34/eb/4a34eb2416f53cc3b4206a03b79dabc5.jpg">
                            	</a>
                        	</div>
                    	</div>
					</div>
				</div>
			</div>
			<div class="BoardButtons Module">
				<button class="BoardFollowButton Button FollowButton Module btn followBoardButton hasText notNavigatable rounded" data-element-type="37" type="button">
					<span class="buttonText">Follow Board</span>
				</button>
			</div>
			
		</div>
	</div>
	
	<div id="domainContainer">
		<div class="Domain Module" data-component-type="30">
			<div class="domainWrapper" style="width:236px">
                <a href="/source/barbaragateau.com/" class="domainLinkWrapper" data-element-type="177" 
                data-aux="{ &quot;domain_url&quot;: &quot;/source/barbaragateau.com/&quot; }" 
                title="More from barbaragateau.com"  style="width:216px">
            		<h4 class="domainSubtitle">More from</h4>
            		<h3 class="domainName" id="domainNameTitle">barbaragateau.com</h3>
            		<div class="thumbContainer">
						<ul class="thumbRow">
							<li class="thumb">
                                <span class="hoverMask"></span>
                                <img src="https://s-media-cache-ak0.pinimg.com/136x136/65/2d/5d/652d5d076236a5b1285c74d85fb7d079.jpg" style="height:70px;width:70px;">
							</li>
                            <li class="thumb">
                                <span class="hoverMask"></span>
                                <img src="https://s-media-cache-ak0.pinimg.com/136x136/be/71/05/be7105cefcc349bf2c75543b87758388.jpg" style="height:70px;width:70px;">
                            </li>
                            <li class="thumb">
                                <span class="hoverMask"></span>
								<img src="https://s-media-cache-ak0.pinimg.com/136x136/d7/3f/eb/d73feb76562085a8487f4ef80f385b90.jpg" style="height:70px;width:70px;">
                            </li>
						</ul>
                        <ul class="thumbRow">
							<li class="thumb">
                                <span class="hoverMask"></span>
                                <img src="https://s-media-cache-ak0.pinimg.com/136x136/ab/f3/2f/abf32fd0161f4bae32c2096750943152.jpg" style="height:70px;width:70px;">
                            </li>
                            <li class="thumb">
                                <span class="hoverMask"></span>
                                <img src="https://s-media-cache-ak0.pinimg.com/136x136/e4/36/e4/e436e467d9392f6f2a6ddcfd7f6cf574.jpg" style="height:70px;width:70px;">
                            </li>
                            <li class="thumb">
                                <span class="hoverMask"></span>
                                <img src="https://s-media-cache-ak0.pinimg.com/136x136/ee/1c/8d/ee1c8d6f208cde3ec26d3afbb1364518.jpg" style="height:70px;width:70px;">
                            </li>
						</ul>
                        <ul class="thumbRow">
                        	<li class="thumb">
                                <span class="hoverMask"></span>
                                <img src="https://s-media-cache-ak0.pinimg.com/136x136/82/1a/fc/821afc51255e0ee47e7e4f8d88b6707a.jpg" style="height:70px;width:70px;">
                            </li>
                            <li class="thumb">
                                <span class="hoverMask"></span>
                                <img src="https://s-media-cache-ak0.pinimg.com/136x136/3d/48/f1/3d48f10d95b30b84699fed57e11a67ae.jpg" style="height:70px;width:70px;">
                            </li>
                            <li class="thumb">
                                <span class="hoverMask"></span>
                                <img src="https://s-media-cache-ak0.pinimg.com/136x136/b3/24/e5/b324e5a63b77175897238ca267432bfb.jpg" style="height:70px;width:70px;">
                            </li>
						</ul>
					</div>
        		</a>
    		</div>
		</div>
	</div>
	
	<div class="relatedRecipeContainer"></div>		
</div>
