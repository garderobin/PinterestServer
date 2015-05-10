<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Create A Board</title>
    
	<meta charset="utf-8">
        <meta http-equiv="x-dns-prefetch-control" content="on">
        <link rel="stylesheet" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/scss/bundle-desktop-main.65495e3e.css">
        <link rel="stylesheet" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/scss/bundle-desktop-1.821b4580.css">
        <link rel="stylesheet" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/scss/bundle-desktop-2.32eb45a8.css">    
        <script src="https://s-media-cache-ak0.pinimg.com/assets/js/dns.js" async="" defer=""></script>    
        <link rel="subresource" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/sprites/webapp-common-above_the_fold-1x.20428f0e.png">            
        <link rel="chrome-webstore-item" href="https://chrome.google.com/webstore/detail/gpdjojdkbbmdfjfahjcgigfpmkopogic">
        <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, user-scalable=no">  
        <link rel="apple-touch-icon" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/images/logo_trans_144x144.4d67817d.png">
        <link rel="icon" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/images/favicon.5d5f2dc6.png">
   	    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="Pinterest">
   		 <link rel="publisher" href="https://plus.google.com/+pinterest">
   		 <!--[if IE]><link rel="shortcut icon" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/images/favicon.57b7a4a4.ico"><![endif]-->
    	<meta name="application-name" content="Pinterest">
   	    <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/images/logo_trans_144x144.4d67817d.png">
        <meta name="theme-color" content="#cb2027">
        <meta name="referrer" content="origin">
        <meta property="fb:app_id" content="274266067164">
        <meta property="og:site_name" content="Pinterest">
        <title>Pinterest: Discover and save creative ideas</title>            
        <link rel="alternate" href="ios-app://429047995/pinterest/">
        <link rel="alternate" href="android-app://com.pinterest/pinterest/">
        <script type="text/javascript" async="" src="https://ssl.google-analytics.com/ga.js"></script><meta name="al:android:app_name" content="Pinterest"><meta name="al:android:package" content="com.pinterest"><meta name="al:android:url" content="pinterest://"><meta name="al:ios:app_name" content="Pinterest"><meta name="al:ios:app_store_id" content="429047995"><meta name="al:ios:url" content="pinterest://"><meta name="description" content="Pinterest is a visual discovery tool that you can use to find ideas for all your projects and interests."><meta name="og:description" content="Pinterest is a visual discovery tool that you can use to find ideas for all your projects and interests."><meta name="og:image" content="https://s-passets-cache-ak0.pinimg.com/images/facebook_share_image.png"><meta name="og:title" content="Pinterest"><meta name="og:type" content="website"><meta name="og:url" content="https://www.pinterest.com"><meta name="pinterest" content="nohover"><meta name="twitter:app:android" content="com.pinterest"><meta name="twitter:app:id:ipad" content="429047995"><meta name="twitter:app:id:iphone" content="429047995"><meta name="twitter:app:url:googleplay" content="pinterest://"><meta name="twitter:app:url:ipad" content="pinterest://"><meta name="twitter:app:url:iphone" content="pinterest://"><meta name="twitter:card" content="summary"><meta name="twitter:site" content="@pinterest"><meta name="description" content="Pinterest is a visual discovery tool that you can use to find ideas for all your projects and interests."><meta name="og:description" content="Pinterest is a visual discovery tool that you can use to find ideas for all your projects and interests."><meta name="og:image" content="https://s-passets-cache-ak0.pinimg.com/images/facebook_share_image.png"><meta name="og:title" content="Pinterest"><meta name="og:type" content="website"><meta name="og:url" content="https://www.pinterest.com"><meta name="pinterest" content="nohover"><meta name="twitter:app:android" content="com.pinterest"><meta name="twitter:app:id:ipad" content="429047995"><meta name="twitter:app:id:iphone" content="429047995"><meta name="twitter:card" content="summary"><meta name="twitter:site" content="@pinterest"></head>


		<body class="noTouch noScroll" data-pinterest-extension-installed="cr1.37">
			<form class="standardForm" method="post" action="addBoard">    
    			<h1 class="createTitle">
       				 Create a Board
    			</h1>
    			<ul>        
            		<li>
                		<h3><label for="boardEditName" class="hasError">Name</label></h3>                
               	    	<div>
                    		<input id="boardEditName" name="bname" type="text" autofocus="" placeholder="Like “Places to Go” or “Recipes to Make.”" value="" ><p class="formErrorMessage">Don't forget to name your board!</p>
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
        			<div class="formFooterButtons">
            			<button class=" Button Module btn cancelButton hasText rounded" type="button">
							<span class="buttonText">Cancel</span>
        				</button>
            			<button class="Button Module btn hasText primary rounded saveBoardButton" type="submit">
							<span class="buttonText">Create Board</span>
        				</button>
        	   		</div>
    			</div>
			</form>
			
		</body>
</html>
