/*
hui 表单元素初始及表单验证插件
作者 : 深海  5213606@qq.com
官网 : http://www.hcoder.net/hui
*/
hui.formInit = function(){hui.formInitBase(); hui.formTextClear(); hui.formPwdShow();};
hui.formInitBase = function(){
	var forms = document.getElementsByClassName('HUI_Inputs');
	if(forms.length < 1){return;}
	for(var i = 0; i < forms.length; i++){
		var inputC = forms[i].getElementsByClassName('HUI_Input');
		if(inputC.length >= 1){
			for(var ii = 0; ii < inputC.length; ii++){
				var pwidth = inputC[ii].clientWidth;
				var labelLeft = inputC[ii].getElementsByTagName('label');
				if(labelLeft.length >= 1){
					var lWidth = labelLeft[0].clientWidth;
					var inputR = inputC[ii].getElementsByTagName('input');
					if(inputR.length >= 1){if(inputR[0].type != 'button' && inputR[0].type != 'checkbox' && inputR[0].type != 'radio'){inputR[0].style.width = (pwidth - lWidth - 43) +'px';}}
					var HUI_Radios = inputC[ii].getElementsByClassName('HUI_Radios');
					if(HUI_Radios.length >= 1){
						HUI_Radios[0].style.width = (pwidth - lWidth - 3) +'px';
						HUI_Radios[0].style.marginTop = '10px';
						HUI_Radios[0].style.display = 'block';
					}
					var textR = inputC[ii].getElementsByTagName('textarea');
					if(textR.length >= 1){textR[0].style.width = (pwidth - lWidth - 3) +'px';}
					var HUI_Select = inputC[ii].getElementsByClassName('HUI_Select');
					if(HUI_Select.length >= 1){HUI_Select[0].style.width = (pwidth - lWidth - 3) +'px';}
				}
			}
		}
	}
};
hui.formTextClear = function(){
	var textClears = document.getElementsByClassName('HUI_Input_Clear');
	if(textClears.length < 1){return;}
	for(var i = 0; i < textClears.length; i++){
		textClears[i].onkeyup = function(){
			var HuiInputsClose = document.getElementById('HUI_Input_Clear_O');
			if(!HuiInputsClose){
				HuiInputsCloseDiv = document.createElement("div");
				HuiInputsCloseDiv.setAttribute("id", 'HUI_Input_Clear_O')
				HuiInputsCloseDiv.setAttribute("class", "HUI_Input_Close HUI_Icons");
				document.body.appendChild(HuiInputsCloseDiv);
			}
			HuiInputsClose = document.getElementById('HUI_Input_Clear_O');
			this.parentNode.appendChild(HuiInputsClose);
			var thisObj = this; HuiInputsClose.style.display = 'block';
			HuiInputsClose.onclick = function(){thisObj.value = ''; this.style.display = 'none';}
		}
	}
};
hui.formPwdShow = function(){
	var pwds = document.getElementsByClassName('HUI_Input_Pwd');
	if(pwds.length < 1){return;}
	for(var i = 0; i < pwds.length; i++){
		var domId = 'HUI_Input_Pwd_Show' + i,HuiInputsPwdDom = document.getElementById(domId);
		if(!HuiInputsPwdDom){
			var HuiInputsPwd = document.createElement("div"); HuiInputsPwd.setAttribute("id", domId);
			HuiInputsPwd.setAttribute("class", "HUI_Input_Pwd_Show HUI_Icons");
			pwds[i].parentNode.appendChild(HuiInputsPwd);
		}
		HuiInputsPwdDom = document.getElementById(domId);
		HuiInputsPwdDom.onclick = function(){
			var parent = this.parentNode;
			var pwdObj = parent.getElementsByClassName('HUI_Input_Pwd');
			if(pwdObj[0].type == 'password'){
				pwdObj[0].type ='text';
				pwdObj[0].disabled = 'disabled';
				this.style.color="#3283FA";
			}else{
				pwdObj[0].setAttribute('type','password'); 
				pwdObj[0].disabled = false;
				this.style.color = "#999999";
			}
		}
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
			var reg       = new RegExp('^.{'+checkData+'}$');
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
			if(checkVal != hui(checkData).val()){return huiFormCheckShowErrMsg(checkMsg);}
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