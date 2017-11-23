//
$(document).ready(function(){				  
	$(window).scroll(function(){
		var toTopHeight = $(window).scrollTop;
		//var toBottomHeight = $(".pro_cuxiao").offset().top; /*20131025j*/
		//if ($(window).scrollTop() >= toTopHeight && $(window).scrollTop() <= toBottomHeight-toHeight) {/*20131025j*/
		if ($(window).scrollTop() >130 ) { /*20131025j */
		  $(".nav_box").addClass("nav_fixed");
		} else{
		  $(".nav_box").removeClass("nav_fixed");
		};
	});

});
$(document).ready(function(){
	//$(".tab_box_top li").eq(0).addClass("tab_on")//绗竴涓珮浜�
	$(".tab_box_top li").click(function(){//鐐瑰嚮浜嬩欢 鍙互鎹㈡垚hover浜嬩欢
		$("#s"+$(this).attr("id")).show().siblings().hide();//杩欓噷鍙敤鍒颁簡鏄剧ず鍜岄殣钘忔晥鏋滐紝鍙互鎹㈡垚鍏朵粬鏁堟灉
		$(this).addClass("tab_on")//鑷繁楂樹寒
		.siblings().removeClass("tab_on");//鐩搁偦鍚岀骇鍏冪礌绉婚櫎楂樹寒
	});
});
window.onload=function(){for(var ii=0; ii<document.links.length; ii++)document.links[ii].onfocus=function(){this.blur()}}	
//椤甸潰棰勫姞杞�
$(function(){
	var pageid=$("#pageid").attr("value");
	var menuid=$("#menuid").attr("value");
	var catid=$("#childid").attr("value");
	$("#nav_"+menuid).addClass("on");
	$("#child_"+pageid).addClass("on");
	$("#childspan"+catid).addClass("onchildmenu");
	$("#tab"+pageid).addClass("tab_on");
});
//鐜版埧缃笟鍙傛暟
$(function(){
  $(".head_p_list h5").click(function(){
       var palt=$(this).attr("alt");
	   var pclass=$(this).attr("class");
	   var ptitle=$(this).attr("title");
	   $("#s_list"+pclass).attr("value",ptitle);
	   $("#pl"+pclass).attr("value",palt);
  });
});

$(document).ready(function(){
			$(".yx_lb li a").click(function(){
			$(".yx_lb li").removeClass("dyg");
			$(this).addClass("dyg");
			var src=$(this).find("img").attr("src");							
			$("#ProImg").attr("src",src);
			}, function(){
			$(this).removeClass("dyg");
			var src=$(this).find("img").attr("src");							
			$("#ProImg").attr("src",src);
			$(".yx_lb li:eq(0)").addClass("dyg");
			});											
						   
});

$(function(){
    var win_w=$(window).width();
	if(win_w<=1024){
		var bannerh=parseInt(win_w)/3;
		$(".kv").css("height",bannerh+"px");
		$(".slides li").css("height",bannerh+"px");
	}
    $("#menu_btn img").click(function(){
	    $(".nav_box").slideToggle(300);
	});   
});



//fancybox
$(function(){
	$('.fancybox').fancybox();
})


// JavaScript Document
//kv姝ｅ父鏄剧ず
$(document).ready(function(){
	$('.flexslider').flexslider({
		directionNav: true,
		pauseOnAction: false
	});
	$('.flexslidera').flexslider({//kv鍦ㄦ墜鏈轰笂鏄剧ず
		directionNav: true,
		pauseOnAction: false
	});
	//nav鎵嬫満鏄剧ず寮€濮�
	$("#nav").mousemove(function(){
		$(this).find("ul").fadeIn("fast");	
	});
	$("#nav").mouseleave(function(){
		$(this).find("ul").fadeOut("fast");
	});//nav鎵嬫満鏄剧ず缁撴潫
	

});




$(document).ready(function(){
	$(".jt_L").click(function(){//宸︾澶寸偣鍑�					
		if( !$(".jt_main ul").is(":animated") ){//鍙湁鍦ㄦ病鏈夊叾瀹冪Щ鍔ㄧ殑鎯呭喌涓嬫墠鑳芥墽琛屽涓嬩簨浠讹紝闃叉鍑虹幇娣蜂贡鐜拌薄
			$(".jt_main ul").find("li:last").prependTo(".jt_main ul");//鍏堝皢鏈€鍚庝竴涓Щ鍒扮涓€涓�
			$(".jt_main ul").css("left","-284px");//灏唘l鐨刲eft宸︾Щ76px銆佸嵆涓€涓猯i鐨勬€诲搴�
			$(".jt_main ul").animate({left:"0px"});	//鏁堟灉閫氳繃animate鏀瑰彉left,浠�-76px鍙樻垚0px
		 }
	});
	$(".jt_R").bind("click",jt_auto);//鍙崇澶寸粦瀹歫t_auto鍑芥暟浜嬩欢
	jt_t = setInterval("jt_auto()", 3000);//鑷姩鎵цjt_auto鍑芥暟锛岃繖閲屽懡鍚嶆槸涓轰簡鏂逛究涓嬮潰鍙栨秷鍑芥暟
	$(".jt_box").hover(function(){clearInterval(jt_t)}, //褰撻紶鏍囧湪杩欎竴鍧楃殑鏃跺€欏仠姝㈡墽琛岃嚜鍔ㄦ墽琛屽嚱鏁�
	function(){jt_t = setInterval("jt_auto()", 3000);});//榧犳爣绉诲紑鐨勬椂鍊欑户缁墽琛岃嚜鍔ㄦ墽琛屽嚱鏁�
});
function jt_auto(){
	if( !$(".jt_main ul").is(":animated") ){
		$(".jt_main ul").animate({left:"-284px"},function(){//鍏坅nimate宸︾Щ
		$(".jt_main ul").find("li:first").appendTo(".jt_main ul");//鍐嶅皢绗竴涓Щ鍒版渶鍚庝竴涓�
		$(".jt_main ul").css("left","0px");//灏嗗叾left杩樺師涓�0
		});
	}			
}
window.onload=function(){for(var ii=0; ii<document.links.length; ii++)document.links[ii].onfocus=function(){this.blur()}}	
