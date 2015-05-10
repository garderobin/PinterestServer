<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en" class="en fixedsticky-withoutfixedfixed columns-3"><!--<![endif]--><head>
        <meta charset="utf-8">
        <meta http-equiv="x-dns-prefetch-control" content="on">
        <link rel="stylesheet" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/scss/bundle-desktop-main.65495e3e.css">
        <link rel="stylesheet" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/scss/bundle-desktop-1.821b4580.css">
        <link rel="stylesheet" href="https://s-passets-cache-ak0.pinimg.com/webapp/style/app/common/scss/bundle-desktop-2.32eb45a8.css">    
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
        

		<body class="noTouch noScroll" data-pinterest-extension-installed="cr1.37">
			<form class="standardForm" method="post" action="addBoard">    
    			<h1 class="createTitle">
       				 Create a Board
    			</h1>
    			<ul>        
            		<li>
                		<h3><label for="bname" class="hasError">Name</label></h3>                
               	    	<div>
                    		<input id="bname" name="bname" type="text" autofocus="" placeholder="Like “Places to Go” or “Recipes to Make.”" value=""><p class="formErrorMessage">Don't forget to name your board!</p>
                		</div>
           	    	</li>  
           	    	<li class="Wrapper">
                		<h3><label for="boardEditCategory">Stream</label></h3>
                		<div>
                    		<select class="CategoriesSelect Module Select" name="stream">
								<option value="other">
        							What kind of board is it?
								</option>
								<option value="animals">
        							Animals &amp; Pets
								</option>
								<option value="architecture">
        							Architecture
								</option>
								<option value="art">
        							Art
								</option>
								<option value="cars_motorcycles">
        							Cars &amp; Motorcycles
								</option>
								<option value="celebrities">
        							Celebrities
								</option>
								<option value="design">
        							Design
								</option>
								<option value="diy_crafts">
        							DIY &amp; Crafts
								</option>
								<option value="education">
        							Education
								</option>
								<option value="film_music_books">
        							Film, Music &amp; Books
								</option>
								<option value="food_drink">
        							Food &amp; Drink
        						</option>
								<option value="gardening">
        							Gardening
								</option>
								<option value="geek">
        							Geek
								</option>
								<option value="hair_beauty">
        							Hair &amp; Beauty
								</option>
								<option value="health_fitness">
        							Health &amp; Fitness
								</option>
								<option value="history">
        							History
								</option>
								<option value="holidays_events">
        							Holidays &amp; Events
								</option>
								<option value="home_decor">
        							Home Decor
								</option>
								<option value="humor">
        							Humor
								</option>
								<option value="illustrations_posters">
        							Illustrations &amp; Posters
								</option>
								<option value="kids">
        							Kids &amp; Parenting
								</option>
								<option value="mens_fashion">
        							Men's Fashion
								</option>
								<option value="outdoors">
        							Outdoors
								</option>
								<option value="photography">
        							Photography
								</option>
								<option value="products">
        							Products
								</option>
								<option value="quotes">
        							Quotes
								</option>
								<option value="science_nature">
        							Science &amp; Nature
								</option>
								<option value="sports">
        							Sports
								</option>
								<option value="tattoos">
        							Tattoos
								</option>
								<option value="technology">
        							Technology
								</option>
								<option value="travel">
        							Travel
								</option>
								<option value="weddings">
        							Weddings
								</option>
								<option value="womens_fashion">
        							Women's Fashion
								</option>
								<option value="other">
        							Other
								</option>
							</select>
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

