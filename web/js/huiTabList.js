/*
hui 选项卡组件
作者 : 深海 5213606@qq.com
官网 : http://www.hcoder.net/hui
*/
hui.tabList = function(domId){
	this.listAll  = hui(domId);
	if(this.listAll.length != 1){return;}
	this.parentObj   = this.listAll.dom[0].parentNode;
	this.barLine     = this.listAll.find('.HUI_TabBarLine').first();
	this.barLineIn   = this.barLine.find('div').first();
	this.content     = this.listAll.find('.HUI_TabBarContent').first();
	this.title       = this.listAll.find('.HUI_TabBarTitle').first();
	this.moveIndex   = 0;
	this.timer       = null;
	var thisObj      = this;
	this.title.find('div').each(function(obj){obj.onclick = function(){thisObj.tabListMove(this.index);}});
	hui.resize(function(){thisObj.tabListBase();});
	this.run = function(){
		this.pWidth = this.parentObj.clientWidth; this.total = this.listAll.find('ul').size();
		this.listAll.find('.HUI_List').css({width:(this.pWidth - 24)+'px'});
		this.listAll.find('.HUI_TabBarContentIn').css({width:(this.pWidth * this.total + 10)+'px'});
		this.barLineIn.css({width:(this.pWidth / this.total - 1)+'px'});
		this.title.find('div').css({'width':(this.pWidth / this.total - 1)+'px'});
		if(this.moveIndex != 0){this.tabListMove(this.moveIndex);}
	};
	this.tabListMove = function(index){
		this.content.dom[0].removeEventListener('scroll', this.tabListBaseMoving);
		this.moveIndex = index;
		this.title.find('div').removeClass('HUI_TabBarTitleActive').eq(index).addClass('HUI_TabBarTitleActive');
		this.content.dom[0].scrollLeft = this.pWidth * index;
		thisObj.barLineIn.css({'marginLeft':(this.content.dom[0].scrollLeft/thisObj.total)+'px'});
		setTimeout(function(){this.content.dom[0].addEventListener('scroll', this.tabListBaseMoving);}.bind(this), 100);
	};
	this.tabListBaseMoving = function(){
		if(thisObj.timer){clearTimeout(thisObj.timer);}
		var scLeft = this.scrollLeft;
		thisObj.barLineIn.css({'marginLeft':(scLeft/thisObj.total)+'px'});
		thisObj.timer = setTimeout(function(){var index = Math.round(scLeft / thisObj.pWidth); thisObj.tabListMove(index);}, 100);
	};
	this.content.dom[0].addEventListener('scroll', this.tabListBaseMoving);
};