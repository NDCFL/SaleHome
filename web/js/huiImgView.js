/*
hui 图片预览组件
作者 : 深海 5213606@qq.com
官网 : http://www.hcoder.net/hui
*/
hui.imgView = function(seletor){
	var hammertime, Pan, Pinch,	deltaX = 0, deltaY = 0, winInfo = hui.winInfo();
	var winInfo = hui.winInfo();
	hui(document).on('click', seletor, function(thisObj){
		var imgs = hui(seletor);
		var totalImgs = imgs.dom.length;
		hui.maskShow();
		hui('#HUI_Mask').click(function(){hui.closeImgView();});
		hui('#HUI_Mask').css({background:'rgba(0,0,0,1)'});
		var HUI_ImgView = hui('#HUI_ImgView');
		if(HUI_ImgView.length){HUI_ImgView.remove();}
		HUI_ImgView = document.createElement('div');
		HUI_ImgView.setAttribute('id', 'HUI_ImgView');
		document.body.appendChild(HUI_ImgView);
		HUI_ImgView = document.getElementById('HUI_ImgView');
		HUI_ImgView.innerHTML = '<div id="HUI_ImgViewText">'+(thisObj.index + 1)+'/'+totalImgs+'</div><div id="HUI_ImgViewImgIn"><img src="'+imgs.dom[thisObj.index].src+'" HUIIMGINDEX="'+thisObj.index+'" style="width:100%;" /></div>';
		var imgWrap = document.getElementById('HUI_ImgViewImgIn');
		imgWrap.style.maxHeight = (winInfo.height - 180)+'px';
		var img     = imgWrap.getElementsByTagName('img');
		img         = img[0];
		hammertime  = new Hammer(img);
		hammertime.sl  = 0;
		hammertime.st  = 0;
		hammertime.get('pinch').set({enable:true});
		hammertime.on('doubletap',function(){if(img.style.width == '100%'){img.style.width = '200%';}else{img.style.width = '100%';}});
		hammertime.on("pinchout", function (e){
			var width = img.style.width;
			width = Number(width.substr(0, width.length - 1)) + 2;
			if(width >= 300){width = 300;}
			img.style.width = width + '%';
			imgWrap.scrollLeft = (img.clientWidth - winInfo.width) / 2;
		});
		hammertime.on("pinchin", function (e){
			var width = img.style.width;
			width = Number(width.substr(0, width.length - 1));
			if(width <= 100){width = 100;}else{width -= 2}
			img.style.width = width+'%';
			imgWrap.scrollLeft = (img.clientWidth - winInfo.width) / 2;
		});
		hammertime.on('panstart', function(e){hammertime.sl = imgWrap.scrollLeft; hammertime.st = imgWrap.scrollTop;});
		hammertime.on('panmove', function(e){
		    var dX = deltaX + e.deltaX, dY = deltaY + e.deltaY;
		    imgWrap.scrollLeft = dX * -1 + hammertime.sl;
		    imgWrap.scrollTop  = dY * -1 + hammertime.st;
		});
		hammertime.on('swiperight',function(){
			var index = Number(img.getAttribute('HUIIMGINDEX'));
			if(index <= 0){return;} index -= 1;
			img.setAttribute('HUIIMGINDEX', index); img.style.width = '100%'; img.src = imgs.dom[index].src;
			hui('#HUI_ImgViewText').html((index + 1) + ' / '+totalImgs);
			hui(img).animate({'marginLeft':winInfo.width+'px'}, 50, function(){
				img.src = imgs.dom[index].src;
				hui(img).css({marginLeft:(winInfo.width*-1)+'px'});
				hui(img).animate({'marginLeft':'0px'}, 200);
			});
		});
		hammertime.on('swipeleft',function(){
			var index = Number(img.getAttribute('HUIIMGINDEX'));
			if(index + 1 >= totalImgs){return;}
			index += 1; img.setAttribute('HUIIMGINDEX', index); img.style.width = '100%';
			hui(img).animate({'marginLeft':'-80px'}, 50, function(){
				img.src = imgs.dom[index].src;
				hui(img).css({marginLeft:winInfo.width+'px'});
				hui(img).animate({'marginLeft':'0px'}, 200);
			});
			hui('#HUI_ImgViewText').html((index + 1) + ' / '+totalImgs);
		});
	});
};
hui.closeImgView = function(){hui.maskHide(); var HUI_ImgView = hui('#HUI_ImgView'); if(HUI_ImgView){HUI_ImgView.remove();}};