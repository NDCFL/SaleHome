function checkname(name){
	if(name==''){
		document.getElementById('nameString').style.display='block';
		$("#nameString").text("楼盘名称不能为空");
	}else if(name!=''){
		document.getElementById('nameString').style.display='none';
	}
}
function checkfile(name){
	if(name==''){
		document.getElementById('filename').style.display='block';
		$("#filename").text("楼盘logo不能为空");
	}else if(name!=''){
		document.getElementById('filename').style.display='none';
	}
}
function checkfloor(name){
	if(name==''){
		document.getElementById('floor').style.display='block';
		$("#floor").text("占地面积不能为空单位为（平米）");
	}else if(name!=''){
		document.getElementById('floor').style.display='none';
	}
}
function checkbuild(name){
	if(name==''){
		document.getElementById('build').style.display='block';
		$("#build").text("建筑面积不能为空");
	}else if(name!=''){
		document.getElementById('build').style.display='none';
	}
}
function checkarea(name){
	if(name==''){
		document.getElementById('area').style.display='block';
		$("#area").text("楼盘所属区域不能为空");
	}else if(name!=''){
		document.getElementById('area').style.display='none';
	}
}
function checkavgprice(name){
	if(name==''){
		document.getElementById('price').style.display='block';
		$("#price").text("楼盘均价不能为空");
	}else if(name!=''){
		document.getElementById('price').style.display='none';
	}
}
function checktel(name){
	if(name==''){
		document.getElementById('tel').style.display='block';
		$("#tel").text("楼盘售楼电话不能为空");
	}else if(name!=''){
		if(name.length!=11){
			document.getElementById('tel').style.display='block';
			$("#tel").text("请输入正确的售楼热线");
		}else{
			document.getElementById('tel').style.display='none';
		}
	}
}
function checkreception(name){
	if(name==''){
		document.getElementById('reception').style.display='block';
		$("#reception").text("楼盘接待客户地址不能为空");
	}else if(name!=''){
		document.getElementById('reception').style.display='none';
	}
}
function checkfee(name){
	if(name==''){
		document.getElementById('fee').style.display='block';
		$("#fee").text("楼盘物业费用不能为空");
	}else if(name!=''){
		document.getElementById('fee').style.display='none';
	}
}
function checkcompany(name){
	if(name==''){
		document.getElementById('company').style.display='block';
		$("#company").text("楼盘物业公司不能为空");
	}else if(name!=''){
		document.getElementById('company').style.display='none';
	}
}
function checkcar(name){
	if(name==''){
		document.getElementById('car').style.display='block';
		$("#car").text("楼盘车位总数不能为空");
	}else if(name!=''){
		document.getElementById('car').style.display='none';
	}
}
function checktraffic(name){
	if(name==''){
		document.getElementById('traffic').style.display='block';
		$("#traffic").text("楼盘周边交通不能为空");
	}else if(name!=''){
		document.getElementById('traffic').style.display='none';
	}
}
function checkequipments(name){
	if(name==''){
		document.getElementById('equipments').style.display='block';
		$("#equipments").text("楼盘周边配套不能为空");
	}else if(name!=''){
		document.getElementById('equipments').style.display='none';
	}
}
function checkinfo(name){
	if(name==''){
		document.getElementById('info').style.display='block';
		$("#info").text("楼盘简介不能为空");
	}else if(name!=''){
		document.getElementById('info').style.display='none';
	}
}
function checktotal(name){
	if(name==''){
		document.getElementById('total').style.display='block';
		$("#total").text("楼盘总套数不能为空（单位套）");
	}else if(name!=''){
		document.getElementById('total').style.display='none';
	}
}
function checkvalid(){
	var checkorder=false;
	if($("#loupan_logo").val()==''){
		document.getElementById('filename').style.display='block';
		$("#filename").text("楼盘logo不能为空");
		checkorder=false;
	}else if($("#loupan_logo").val()!=''){
		document.getElementById('filename').style.display='none';
	}
	if($("#loupan_nameString").val()==''){
		document.getElementById('nameString').style.display='block';
		$("#nameString").text("楼盘名称不能为空");
		checkorder=false;
	}else if($("#loupan_nameString").val()!=''){
		document.getElementById('nameString').style.display='none';
	}
	if($("#loupan_totalRoomsInt").val()==''){
		document.getElementById('total').style.display='block';
		$("#total").text("楼盘总套数不能为空（单位·套）");
		checkorder=false;
	}else if($("#loupan_totalRoomsInt").val()!=''){
		document.getElementById('total').style.display='none';
	}
	if($("#loupan_floorAreaString").val()==''){
		document.getElementById('floor').style.display='block';
		$("#floor").text("占地面积不能为空");
		checkorder=false;
	}else if($("#loupan_floorAreaString").val()!=''){
		document.getElementById('floor').style.display='none';
	}
	if($("#loupan_buildingAreaString").val()==''){
		document.getElementById('build').style.display='block';
		$("#build").text("建筑面积不能为空");
		checkorder=false;
	}else if($("#loupan_buildingAreaString").val()!=''){
		document.getElementById('build').style.display='none';
	}
	if($("#city").val()==''){
		document.getElementById('area').style.display='block';
		$("#area").text("楼盘所属区域不能为空");
		checkorder=false;
	}else if($("#city").val()!=''){
		document.getElementById('area').style.display='none';
	}
	if($("#loupan_avgPriceDouble").val()==''){
		document.getElementById('price').style.display='block';
		$("#price").text("楼盘均价不能为空");
		checkorder=false;
	}else if($("#loupan_avgPriceDouble").val()!=''){
		document.getElementById('price').style.display='none';
	}
	if($("#loupan_telString").val()==''){
		document.getElementById('tel').style.display='block';
		$("#tel").text("楼盘售楼电话不能为空");
		checkorder=false;
	}else if($("#loupan_telString").val()!=''){
		if($("#loupan_telString").val().length!=11){
			document.getElementById('tel').style.display='block';
			$("#tel").text("请输入正确的售楼电话");
			checkorder=false;
		}else{
			document.getElementById('tel').style.display='none';
		}
	}
	if($("#loupan_receptionAddressString").val()==''){
		document.getElementById('reception').style.display='block';
		$("#reception").text("楼盘接待客户地址不能为空");
		checkorder=false;
	}else if($("#loupan_receptionAddressString").val()!=''){
		document.getElementById('reception').style.display='none';
	}
	if($("#loupan_propertyFeeDouble").val()==''){
		document.getElementById('fee').style.display='block';
		$("#fee").text("楼盘物业费用不能为空");
		checkorder=false;
	}else if($("#loupan_propertyFeeDouble").val()!=''){
		document.getElementById('fee').style.display='none';
	}
	if($("#loupan_propertyCompany").val()==''){
		document.getElementById('company').style.display='block';
		$("#company").text("楼盘物业公司不能为空");
		checkorder=false;
	}else if($("#loupan_propertyCompany").val()!=''){
		document.getElementById('company').style.display='none';
	}
	if($("#loupan_carStationInt").val()==''){
		document.getElementById('car').style.display='block';
		$("#car").text("楼盘车位总数不能为空");
		checkorder=false;
	}else if($("#loupan_carStationInt").val()!=''){
		document.getElementById('car').style.display='none';
	}
	if($("#loupan_trafficString").val()==''){
		document.getElementById('traffic').style.display='block';
		$("#traffic").text("楼盘周边交通不能为空");
		checkorder=false;
	}else if($("#loupan_trafficString").val()!=''){
		document.getElementById('traffic').style.display='none';
	}
	if($("#loupan_equipmentsString").val()==''){
		document.getElementById('equipments').style.display='block';
		$("#equipments").text("楼盘周边配套不能为空");
		checkorder=false;
	}else if($("#loupan_equipmentsString").val()!=''){
		document.getElementById('equipments').style.display='none';
	}
	if($("#loupan_introString").val()==''){
		document.getElementById('info').style.display='block';
		$("#info").text("楼盘简介不能为空");
		checkorder=false;
	}else if($("#loupan_introString").val()!=''){
		document.getElementById('info').style.display='none';
		checkorder=true;
	}
}
