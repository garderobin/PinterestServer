$(document).ready(function(){
    $("#addPinMenuButton").click(function(){
        $("#addPinMenuContent").slideToggle();
    });
});


$(function(){

    $('#masonryContainer').imagesLoaded( function(){
    	$('#masonryContainer').masonry({
        itemSelector : '.masonryItem',
        columnWidth:236,
        gutterWidth:10,
        isFitWidth:true
//        isAnimated:true
      });
    });

//    $('#headerContainer').width($('#header_module').width());

    $('#masonrySmall').imagesLoaded( function(){
    	$('#masonrySmall').masonry({
        itemSelector : '.masonrySmallItem',
        columnWidth:70,
        gutterWidth:2,
        isFitWidth:true
//        isAnimated:true
      });
    });
    
//    $('#uploadPinForm').ajaxForm({
//		url:'script',
//		type:'POST',
//		dataType:'json',
//		success:function(data) {
//			showCreatePinForm(0,0,0);
//		}
//	})
    
//    $('#file').fileupload({
//    	url:'fileUploadAction.action',
//    	dataType:'json',
//    	done:function(e, data) {
//    		alert('file uploaded!');
//    		console.log("file uploaded");
//    	}
//    });
//    $('#file').uploadifive({  
//    	//'auto' : false,   //取消自动上传   
//    	'uploadScript' : 'fileUploadAction.action', //处理上传文件Action路径   
//    	'fileObjName' : 'imgUpload',        //文件对象  
//    	/* 'buttonText'   : '选择文件',   //按钮显示文字 */   
//    	'queueID'      : 'myModalLabel', //提示信息放置目标   
//    	'fileType'     : 'image/*',   //允许上传文件类型   
//    	'onUploadComplete' : function(file, data) { //文件上传成功后执行  
//    		alert("upload!"); 
//      		console.info('The file ' + file.name + ' uploaded successfully.');  
//    	}  
//	});  
    
});

//$(window).resize(function() {
//	$('#headerContainer').width($('#header_module').width());
//	$('#headerBackground').width($('#header_module').width());
//});

function showCreatePinForm(bid, pic, note) {
	alert('showCreatePinForm!');
}




