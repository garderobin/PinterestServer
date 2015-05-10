<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'friendRequest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="description" content="This is my page">
	<link href="css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_442c9884.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-1_821b4580.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/dbcommon.css" rel="stylesheet" type="text/css">
   	<script src="https://s-media-cache-ak0.pinimg.com/assets/js/dns.js" async="" defer=""></script>	
   	<script src="js/jquery.min.js"></script>
   	<script src="js/bootstrap.js"></script>
   	<!-- <script src="js/common.js"></script> -->
    <script type="text/javascript">
    $(function(){    
    	$.ajax({
			type:"GET",
			dataType:"json",
			url:'queryRequestByAnsweror.action',
			//data:{keyword:$("keywordInput").val()},
			success: function(data, textStatus) {
				$.each(data.requests, function(){	
						
					$("#friendTableBody").append($(
//"<tr><th><a href='userPage.jsp?username=" + this.invitor.username +  "' >"+ this.invitor.username + "</a><button class='btn btn-primary' style='float:right;'>Accept</button></th></tr>"
	"<tr><th><a href='userPage.jsp?username=" + this.invitor.username +  "' >"+ this.invitor.username + "</a>" + "<form class='standardForm' name='deleterequest' method='post' action='deleteRequestByAnsweror'>"+
								"<div class='findPins'> <input type='hidden' id='invitor' name='invitor' value="+this.invitor.username+">"+								
									"<button class='Button Module btn hasText primary rounded' id='nextButton'type='submit'>"+
										"<span class='buttonText'>Decline</span>"+
									"</button>"+
								"</div>"+
							"</form>"+
							"<form class='standardForm' name='addfriend' method='post' action='addFriend'>"+
								"<div class='findPins'> <input type='hidden' id='friendname' name='friendname' value="+this.invitor.username+">"+								
									"<button class='Button Module btn hasText primary rounded' id='nextButton'type='submit'>"+
										"<span class='buttonText'>Accept</span>"+        
									"</button>"+
								"</div>"+
							"</form>" + "</th></tr>"
					
					));		
				});
			},
		});		
	}) 
	</script>

  </head>
  
  <body>
  <jsp:include page="./modules/header.jsp" />
	<jsp:include page="./modules/footer.jsp"/>	
  	<div class="appContent">
		<div class="mainContainer" style="background-color:#e9e9e9">
			<div class="Module Nags centeredWithinWrapper" style="height:54px"></div>
			<div class="HomePage Module" style="min-height:624px">
				<div class="AuthHomePage Module">
					<div class="HeroBasicWrapper Module"></div>
    	<table class="table" id="RequestTable">
      <caption>Friend Request</caption>
      <thead>
        <tr>
          <th>Username</th>          
        </tr>
      </thead>
      <tbody id="friendTableBody">
      </tbody>
    </table>
    </div>
    </div>
    </div>
    </div>
    
    <!-- <div class="Module Modal absoluteCenter show" tabindex="1">
    	
	</div>  -->
  </body>
</html>
