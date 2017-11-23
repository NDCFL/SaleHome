/*
hui 轮播组件
作者 : 深海 5213606@qq.com
官网 : http://www.hcoder.net/hui
*/
function huiSlide(selector){
	this.slider = hui(selector);
	if(this.slider.length != 1){return;}
	this.delay     = 5000;
	this.timer     = null;
	this.ul        = this.slider.find('ul').eq(0);
	this.total     = this.ul.find('li').size();
	this.slideBase = function(){
		this.sParent      = this.slider.dom[0].parentNode;
		this.sParentWidth = this.sParent.clientWidth;
		this.lists = this.slider.find('li');
		this.lists.css({width:this.sParentWidth+'px'});
		var ulWidth = (this.sParentWidth * (this.total + 2) + 500) + 'px';
		this.ul.css({width:ulWidth, display:'block'});
		var preDiv = this.slider.find('.HUI_SlidePrepare');
		if(preDiv.length){preDiv.remove();}
	}
	this.slideBase();
	this.lists    = this.ul.find('li');
	this.firstLi  = this.lists.first();
	this.lastLi   = this.lists.last();
	this.firstLi.clone().appendTo(this.ul);
	this.lastLi.clone().prependTo(this.ul);
	this.cIndex   = 1;
	this.points   = this.slider.find('.HUI_SliderPoint');
	if(this.points.length){this.points.remove();}
	var points    = document.createElement('div');
	points.setAttribute('class', 'HUI_SliderPoint');
	this.slider.dom[0].appendChild(points);
	this.points   = this.slider.find('.HUI_SliderPoint').first();
	var pointHtml = '';
	for(var i = 0; i < this.total; i++){pointHtml += '<div class="HUI_SliderPoints"></div>';}
	this.points.html('<div class="HUI_SliderPointIn" style="width:'+(12 * this.total + 3)+'px">'+pointHtml+'</div>');
	this.ul.css({'marginLeft':(this.sParent.clientWidth * -1)+'px'});
	this.points.find('.HUI_SliderPoints').first().addClass('HUI_SliderPointSed');
	var thisObj   = this;
	this.ul.swipeLeft(function(e){thisObj.sliding(thisObj.cIndex + 1);});
	this.ul.swipeRight(function(e){thisObj.sliding(thisObj.cIndex - 1);});
	this.timer    = setTimeout(function(){thisObj.sliding(2);}, thisObj.delay);
	
	this.sliding   = function(index, speed){
		if(!speed){speed = 500;} var moveVal = (index) * this.sParentWidth * -1, thisObj = this, currentVal = 0;
		this.ul.animate({marginLeft:moveVal+'px'}, speed, function(){
			clearTimeout(thisObj.timer);
			thisObj.points.find('.HUI_SliderPoints').removeClass('HUI_SliderPointSed');
			if(index < 1){
				thisObj.ul.css({marginLeft: (thisObj.total * thisObj.sParentWidth * -1)+'px'});
				thisObj.cIndex = thisObj.total;
				thisObj.points.find('.HUI_SliderPoints').eq(thisObj.total - 1).addClass('HUI_SliderPointSed');
			}else if(index > thisObj.total){
				thisObj.ul.css({marginLeft: (thisObj.sParentWidth * -1)+'px'});
				thisObj.points.find('.HUI_SliderPoints').eq(0).addClass('HUI_SliderPointSed');
				thisObj.cIndex = 1;
			}else{
				thisObj.cIndex = index; thisObj.points.find('.HUI_SliderPoints').eq(index - 1).addClass('HUI_SliderPointSed');
			}
			thisObj.timer = setTimeout(function(){thisObj.sliding(thisObj.cIndex+1)}, thisObj.delay);
		});
	}
}