/*
hui 表单元素初始及表单验证插件
作者 : 深海  5213606@qq.com
官网 : http://www.hcoder.net/hui
*/
hui.formInit = function(){hui.formTextClear(); hui.formPwdEye();};
hui.formTextClear = function(){
	var textClears = document.getElementsByClassName('hui-input-clear');
	if(textClears.length < 1){return;}
	for(var i = 0; i < textClears.length; i++){
		textClears[i].onkeyup = function(){
			var HuiInputsClear = document.getElementById('hui-input-clear');
			if(!HuiInputsClear){
				HuiInputsClearDiv = document.createElement("div");
				HuiInputsClearDiv.setAttribute("id", 'hui-input-clear')
				document.body.appendChild(HuiInputsClearDiv);
			}
			HuiInputsClear = document.getElementById('hui-input-clear');
			this.parentNode.appendChild(HuiInputsClear);
			var thisObj = this; HuiInputsClear.style.display = 'block';
			HuiInputsClear.onclick = function(){thisObj.value = ''; this.style.display = 'none';}
		}
	}
};
hui.formPwdEye = function(){
	var eyes = document.getElementsByClassName('hui-pwd-eye');
	if(eyes.length < 1){return;}
	for(var i = 0; i < eyes.length; i++){
		var eye = document.createElement('div');
		eye.setAttribute('class', 'hui-pwd-eyes');
		eye.setAttribute('onclick', 'hui.eyesChange(this);');
		document.body.appendChild(eye);
		hui(eye).appendTo(hui(eyes[i]).parent());
	}
};
hui.eyesChange = function(o){
	var _selfDom = hui(o), _inputDom = _selfDom.parent().find('.hui-input').eq(0);
	if(_selfDom.hasClass('hui-pwd-eyes-sed')){
		_selfDom.removeClass('hui-pwd-eyes-sed');
		_inputDom.dom[0].type     = 'password';
		_inputDom.dom[0].disabled = false;
	}else{
		_selfDom.addClass('hui-pwd-eyes-sed');
		_inputDom.dom[0].setAttribute('type', 'text');
		_inputDom.dom[0].setAttribute('disabled', true);
	}
};
function huiFormCheck(selector){
	var formIn  = hui(selector);
	if(formIn.length != 1){return true;}
	var inputs = formIn.find('input'), selects = formIn.find('select'), textareas = formIn.find('textarea'); res = true;
	for(var i = 0; i < inputs.dom.length; i++){res = huiFormCheckBase(inputs.dom[i]); if(!res){break;}}
	if(res){for(var i = 0; i < selects.dom.length; i++){res = huiFormCheckBase(selects.dom[i]); if(!res){break;}}}
	if(res){for(var i = 0; i < textareas.dom.length; i++){res = huiFormCheckBase(textareas.dom[i]); if(!res){break;}}}
	if(typeof(huiFormCheckAttach) != 'undefined' && res){if(!huiFormCheckAttach()){return false;}}
	return res;
}
function huiFormCheckBase(obj){
	var checkType  = obj.getAttribute('checkType');
	if(!checkType){return true;}
	var checkData  = obj.getAttribute('checkData');
	var checkMsg   = obj.getAttribute('checkMsg');
	if(!checkMsg){return true;}
	var checkVal   = obj.value;
	switch(checkType){
		case 'string' : 
			checkVal = checkVal.trim();
			var reg  = new RegExp('^.{'+checkData+'}$');
			if(!reg.test(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'int' :
			var reg  = new RegExp('^\-?[0-9]{'+checkData+'}$');
			if(!reg.test(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
			var reg2 = new RegExp('^\-?0+[0-9]+$');
			if(reg2.test(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'between' : 
			if(!huiFormCheckNumber(checkVal, checkData, checkMsg)){return false;}
		break;
		case 'betweenD' : 
			var reg  = new RegExp('^\-?[0-9]+$');
			if(!reg.test(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
			if(!huiFormCheckNumber(checkVal, checkData, checkMsg)){return false;}
		break;
		case 'betweenF' : 
			var reg  = new RegExp('^\-?[0-9]+\.[0-9]+$');
			if(!reg.test(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
			if(!huiFormCheckNumber(checkVal, checkData, checkMsg)){return false;}
		break;
		case 'same' : 
			if(checkVal != checkData){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'sameWithId' : 
			if(checkVal != hui('#'+checkData).val()){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'notSame' : 
			if(checkVal == checkData){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'notSameWithId' :
			if(checkVal == hui(checkData).val()){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'email' : 
			var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if(!reg.test(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'phone' :
			var reg = /^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/;
			if(!reg.test(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'url'  :
			var reg = /^(\w+:\/\/)?\w+(\.\w+)+.*$/;
			if(!reg.test(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'zipcode'  :
			var reg = /^[0-9]{6}$/;
			if(!reg.test(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'reg'  : 
			var reg = new RegExp(checkData);
			if(!reg.test(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
		break;
		case 'fun'  : 
			eval('var res = '+checkData+'("'+checkVal+'");');
			if(!res){return huiFormCheckShowErrMsg(checkMsg);}
		break;
	}
	return true;
}
function huiFormCheckNumber(checkVal, checkData, checkMsg){
	checkVal = Number(checkVal); if(isNaN(checkVal)){return huiFormCheckShowErrMsg(checkMsg);}
	checkDataArray = checkData.split(',');
	if(checkDataArray[0] == ''){
		if(checkVal > Number(checkDataArray[1])){return huiFormCheckShowErrMsg(checkMsg);}
	}else if(checkDataArray[1] == ''){
		if(checkVal < Number(checkDataArray[0])){return huiFormCheckShowErrMsg(checkMsg);}
	}else{
		if(checkVal < Number(checkDataArray[0]) || checkVal > Number(checkDataArray[1])){return huiFormCheckShowErrMsg(checkMsg);}
	}
	return true;
}
function huiFormCheckShowErrMsg(checkMsg){hui.toast(checkMsg); return false;}