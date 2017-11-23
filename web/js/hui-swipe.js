/*
hui 轮播组件
作者 : 深海  5213606@qq.com
官网 : http://hui.hcoder.net/
*/
function huiSwpie(selector){
	this.swipe       = hui(selector);
	this.items       = this.swipe.find('.hui-swipe-item');
	this.itemSize    = this.items.length;
	this.height      = this.items.eq(0).height();
	this.loop        = true;
	var _selfObj     = this;
	var haveImg      = this.items.eq(0).find('img');
	_selfObj.swipe.css({height : this.height+'px'});
	var prev         = this.swipe.find('.hui-swipe-pre').eq(0);
	if(prev.length > 0){
		_selfObj.swipe.css({height : prev.height()+'px'});
		prev.find('img').dom[0].onload = function(){
			_selfObj.swipe.css({height : prev.height()+'px'});
		}
	}else{
		if(haveImg.length > 0){
			_selfObj.swipe.css({height : _selfObj.items.eq(0).height()+'px'});
			this.items.eq(0).find('img').dom[0].onload = function(){
				_selfObj.swipe.css({height : _selfObj.items.eq(0).height()+'px'});
			}
		}
	}
	this.width       = this.swipe.width();
	this.index       = 2;
	this.speed       = 500;
	this.delay       = 5000;
	this.timer       = null;
	this.indicatorOn = true;
	this.autoPlay    = true;
	var  lastItem    = this.items.last();
	this.items.eq(0).clone().appendTo(this.swipe);
	lastItem.clone().prependTo(this.swipe);
	this.items       = this.swipe.find('.hui-swipe-item');
	this.indicator  = this.swipe.find('.hui-swipe-indicator');
	if(this.indicator.length < 1){
		var indicatorDom = document.createElement('div');
		indicatorDom.setAttribute('class', 'hui-swipe-indicator');
		var html = '<div class="hui-fr">';
		for(var i = 0; i < this.itemSize; i++){html += '<div class="hui-swipe-indicators"></div>';}
		indicatorDom.innerHTML = html + '</div>';
		hui(indicatorDom).appendTo(this.swipe);
	}
	this.indicator  = this.swipe.find('.hui-swipe-indicator');
	this.indicator.find('.hui-swipe-indicators').eq(0).addClass('hui-swipe-indicator-active');
	this.change = function(){
		if(!_selfObj.loop){if(_selfObj.index > _selfObj.itemSize){return false;}}
		var i = 0;
		_selfObj.items.each(function(_item){
			_item.style.transform  = 'translate3d('+ ((i - _selfObj.index) * 100) +'%, 0px, 0px)';
			_item.style.transition = 'linear '+_selfObj.speed + 'ms';
			i++;
		});
		if(_selfObj.index > _selfObj.itemSize){
			_selfObj.changeIndicator(1);
			setTimeout(function(){
				var i = 0;
				_selfObj.items.each(function(_item){
					_item.style.transform  = 'translate3d('+ ((i - 1) * 100) +'%, 0px, 0px)';
					_item.style.transition = 'none';
					i++;
				});
			}, _selfObj.speed + 10);
			_selfObj.index = 2;
		}else{
			_selfObj.changeIndicator(_selfObj.index);
			_selfObj.index++;
		}
		if(_selfObj.autoPlay){_selfObj.timer = setTimeout(_selfObj.change, _selfObj.delay);}
	}
	var ii = 0;
	this.items.each(function(_item){
		_item.style.transform  = 'translate3d('+ ((ii - 1) * 100) +'%, 0px, 0px)';
		ii++;
	});
	this.items.show();
	this.changeIndicator = function(index){
		_selfObj.indicator.find('.hui-swipe-indicators').removeClass('hui-swipe-indicator-active');
		_selfObj.indicator.find('.hui-swipe-indicators').eq(index - 1).addClass('hui-swipe-indicator-active');
	};
	this.swpieMove = 0;
	this.swipe.touchMove(function (e){
		_selfObj.moveScale  = e.x / _selfObj.width * -1;
		_selfObj.swpieMove = (_selfObj.index - 1) + _selfObj.moveScale * 1.5;
		if(_selfObj.swpieMove  < 1){return false;}
		if(!_selfObj.loop){if(_selfObj.index > _selfObj.itemSize && e.x < 0){return false;}}
		clearTimeout(_selfObj.timer);
		var i = 0;
		_selfObj.items.each(function(_item){
			_item.style.transform  = 'translate3d('+ ((i - _selfObj.swpieMove) * 100) +'%, 0px, 0px)';
			_item.style.transition = 'none';
			i++;
		});
	});
	this.swipe.touchEnd(function(e){
		if(_selfObj.swpieMove < 1){return false;}
		if(!_selfObj.loop){if(_selfObj.index > _selfObj.itemSize && e.x < 0){return false;}}
		_selfObj.index = Math.round(_selfObj.swpieMove); _selfObj.change();
	});
	this.run = function(){
		if(this.autoPlay){
			this.timer = setTimeout(_selfObj.change, _selfObj.delay);
		}
		if(this.indicatorOn){
			this.indicator.show();
		}
	}
}