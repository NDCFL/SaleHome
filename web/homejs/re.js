var curField=null;var relationHT=new Array();var relationQs=new Object();var 
relationNotDisplayQ=new Object();function 
setCookie(b,d,a,f,c,e){document.cookie=b+"="+escape(d)+((a)?"; 
expires="+a:"")+((f)?"; path="+f:"")+((c)?"; domain="+c:"")+((e)?"; 
secure":"");}var spChars=["$","}","^","|","<"];var 
spToChars=["ξ","｝","ˆ","¦","&lt;"];var prevInputControl=null;var 
isLoadingAnswer=false;var lastCostTime=0;var hasClickQ=false;var 
needGoOut=false;var hasShowTip=false;var 
jpkeyword=["株式会社","中日","日产","日系","动漫","日语","日本","漫画","日企","二次元","日式","空手道","三菱", 
"住友","日立","松下","三井","富士","本田","丰田","株式会社","会社","が","し","コ","グ","ば","ふ","ハ","ビ"," 
ぜ","と","ツ","ダ","ぼ"];var 
enkeyword=["外贸","进出口","进口","出口","贸易","国际","英语","海外","外企","跨国","驻外","外教","翻译","外销 
","报单","口译","外交","跨境","航空","空乘","乘务","the"];var 
enxiaokeyword=["小学","附小","一年级","二年级","三年级","四年级","五年级","六年级","少先队","少先大队","少儿"," 
孩子","夏令营","初中","初一","初二","初三","七年级","八年级","九年级","中考","中学","附中","高中","高一","高二","高 
三","高考","少年","附属","暑假","寒假","课外辅导","家长","小升初","初升高","幼小"];var 
enyoukeyword=["早教","幼儿园","大班","儿童","早教","启蒙","亲子","小学","附小","一年级","二年级","三年级","四 
年级","五年级","六年级","少先队","少先大队","少儿"];var 
enchukeyword=["中学","附中","初中","初一","初二","初三","七年级","八年级","九年级","夏令营","中考","青春期"]; 
var jpmatch=0;function replace_specialChar(c){for(var 
a=0;a<spChars.length;a++){var b=new 
RegExp("(\\"+spChars[a]+")","g");c=c.replace(b,spToChars[a]);}if(/^[A-Za-z\s\.,] 
+$/.test(c)){c=c.replace(/\s+/g," 
");}c=c.replace(/[^\x09\x0A\x0D\x20-\uD7FF\uE000-\uFFFD\u10000-\u10FFFF]/ig,""); 
return $.trim(c);}function pushHistory(){if(document.referrer){return;}var 
a={title:"title",url:"#"};window.history.pushState(a,"title","#");if(window.need 
HideShare==1||window.hideFriend==1){if(window.wx){wx.hideMenuItems({menuList:men 
us});}}}function 
clickJp(){if(window._czc){_czc.push(["_trackEvent","未完成填写","点击"]);}alert("提示：此活动 
仅限新用户领取，请按页面提示进行操作！");return true;}function 
show_zhezhao_tip(g){if(g){if($("#zhezhaotip")[0]){return;}var e="";var 
b=window.notFinishTip.split(";");if(b.length==2&&b[0].indexOf("http")==0){e="<di 
v style='width: 100%;height:80px; background-color: #e9f7ff; float: left;'><div 
style='float:left;margin-left:110px;font-size:14px; color: #6a696b; margin-top: 
17px; line-height: 1.5;'>先领取<a onclick='return clickJp();' href='"+b[0]+"' 
style='text-decoration: underline; font-weight: 
bold;'>"+b[1]+"</a><br/>注满能量，再来填写吧！</div></div>";}var h="<div style='width:100%; 
height:100px; background-color: #ffffff;float: left;'><div style='float: right; 
height: 100%; padding:15px;'><h1 style='font-size: 16px; color: #840615; 
line-height: 2.5;'>亲，你的意见很重要哦！</h1><div style='padding: 0 10px; 
background-color: #2c87f7; font-size: 16px; color: #fff; line-height: 2; float: 
left; border-radius: 6px;' onclick='show_zhezhao_tip(false);'>继续填写</div><div 
style='padding: 0 10px; background-color: #ababab; font-size: 16px; color: #fff; 
line-height: 2; float: left; border-radius: 6px; margin-left: 30px;' 
onclick='closeTipWindow(true);'>放弃</div></div></div>";var a="<div 
class='popuptip' style='width:300px;background:#fff;border-radius: 4px;margin: 
auto;position: absolute; z-index: 9999;overflow: 
hidden;height:180px;'>"+h+e+"<img src='/images/wjx/smile.png' alt='' width='80' 
style='position: absolute; top:20px; 
left:10px;'>";"</div>";$("body").append('<div style="z-index:999;top: 0px;left: 
0px;position: fixed;width: 100%;height: 100%;" id="zhezhaotip"><div 
style="position: absolute;top: 0px;left: 0px;width: 100%;height: 100%;opacity: 
0.5;background-color: #000;"></div>'+a+"</div>");var f=$("html").height();var 
c=$(window).height();var 
d=100;c>f?d=c:d=f;$("#zhezhaotip").height(d);$(".popuptip").css("left",($(window 
).width()-$(".popuptip").width())/2);$(".popuptip").css("top",($(window).height( 
)-$(".popuptip").height())/2);if(!hasShowTip){if(window._czc){_czc.push(["_track 
Event","未完成填写","加载"]);}}setLastPop();hasShowTip=true;}else{$("#zhezhaotip").remo 
ve();}}function closeTipWindow(b){var a="确认不再填写问卷吗？";if(langVer==1){a="Would you 
like to 
leave?";}if(window.WeixinJSBridge){if(b||confirm(a)){WeixinJSBridge.call("closeW 
indow");}}else{needGoOut=true;show_zhezhao_tip(false);if(window.close){window.cl 
ose();}window.history.back();}}function 
setLastPop(){if(!window.localStorage){return;}localStorage.setItem("wjxlastpopti 
me",new Date().getTime());}function 
checkCanPop(){if(!window.localStorage){return 
true;}if(localStorage.wjxuserpub){return 
false;}if(window.location.href.indexOf("?pvw=1")>-1||window.location.href.indexO 
f("&pvw=1")>-1){return false;}if(window.isVip){return 
false;}if(langVer==1){return false;}if(!window.notFinishTip){return false;}var 
b=localStorage.wjxlastpoptime;if(!b){return true;}var a=new Date().getTime();var 
c=(a-b)/(24*60*60*1000);if(c>7){return true;}return 
false;}$(function(){if(!$.support.leadingWhitespace){window.location.href=window 
.location.href.replace("/m/","/jq/");}if(!window.addEventListener){return;}windo 
w.addEventListener("popstate",function(a){if(!hasClickQ){return;}if(needGoOut){w 
indow.history.back();return;}pushHistory();var 
b=checkCanPop();if(window.notFinishTip&&b){show_zhezhao_tip(true);}else{closeTip 
Window();}},false);});String.prototype.format=function(){var a=arguments;return 
this.replace(/\{(\d+)\}/g,function(b,c){return a[c];});};var curfilediv=null;var 
isUploadingFile=false;var cur_page=0;var hasSkipPage=false;var 
prevControl=null;var pageHolder=null;var curMatrixFill=null;var 
curMatrixError=null;var imgVerify=null;var questionsObject=new Object();var 
allQArray=null;var shopArray=new Array();function 
setMatrixFill(){if(curMatrixError&&!curMatrixFill.fillvalue){return;}$("#divMatr 
ixRel").hide();}function 
setChoice(a){$(a.parentNode).find("span").html(a.options[a.selectedIndex].text); 
$(a.parentNode).prev("input").val(a.value);}function 
showMatrixFill(f,c){if(c){if(curMatrixError){return;}curMatrixError=f;}curMatrix 
Fill=f;var e=f.fillvalue||"";$("#matrixinput").val(e);var b=$(f).attr("req");var 
a="请注明...";var 
b=f.getAttribute("req");if(b){a="请注明...[必填]";}matrixinput.setAttribute("placehol 
der",a);var g=$(f).offset();var 
d=g.top-$(f).height()-15;$("#divMatrixRel").css("top",d+"px").css("left","0").sh 
ow();}function 
refresh_validate(){if(imgCode&&tCode.style.display!="none"&&imgCode.style.displa 
y!="none"){imgCode.src="/AntiSpamImageGen.aspx?q="+activityId+"&t="+(new 
Date()).valueOf();}if(submit_text){submit_text.value="";}if(imgVerify){imgVerify 
.onclick();}if(window.useAliVerify){ncCaptchaObj.reset();}}function 
processRadioInput(a,b){if(a.prevRadio&&a.prevRadio.itemText&&a.prevRadio!=b){a.p 
revRadio.itemText.pvalue=a.prevRadio.itemText.value;a.prevRadio.itemText.value=" 
";}if(b.itemText&&b!=a.prevRadio){b.itemText.value=b.itemText.pvalue||"";}a.prev 
Radio=b;}function 
addClearHref(b){if(window.isKaoShi){return;}if(b.hasClearHref){b.clearHref.style 
.display="";return;}var 
a=document.createElement("a");a.title=validate_info_submit_title2;a.style.color= 
"#999999";a.style.marginLeft="25px";a.innerHTML="["+type_radio_clear+"]";a.href= 
"javascript:void(0);";b.hasClearHref=true;$(".field-label",b).append(a);b.clearH 
ref=a;a.onclick=function(){clearFieldValue(b);referTitle(b);this.style.display=" 
none";jumpAny(false,b);saveAnswer(b);};}function 
referTitle(e,f){if(!e[0]._titleTopic){return;}var 
b="";if(f==undefined){$("input:checked",e).each(function(h){var 
g=$(this).parent().next().html();if(b){b+="&nbsp;";}b+=g;});}else{b=f;}for(var 
c=0;c<e[0]._titleTopic.length;c++){var a=e[0]._titleTopic[c];var 
d=document.getElementById("spanTitleTopic"+a);if(d){d.innerHTML=b;}}}function 
showImg(b){var 
a=$(b).attr("tpiao");if(!a){return;}$("img",b).bind("click",function(f){var 
d=this.parentNode.getAttribute("pimg");if(!d){return;}var 
c=document.createElement("img");c.onload=function(){var 
g=document.getElementById("divImgPop");if(!g){$("body").append("<div 
id='divImgPop' 
style='display:none;'></div>");g=document.getElementById("divImgPop");}var 
m=this.width;var k=this.height;var j=$(window).width();var 
l=$(window).height();var h,e;var 
n=0.9;if(k>l*n){e=l*n;h=e/k*m;if(h>j*n){h=j*n;}}else{if(m>j*n){h=j*n;e=h/m*k;}el 
se{h=m;e=k;}}g.innerHTML="<img src='"+d+"' style='width:"+h+"px' 
alt=''/>";openDialogByIframe(h,e,"divImgPop");};c.src=d;f.preventDefault();f.sto 
pPropagation();return 
false;});}$(function(){pageHolder=$("fieldset.fieldset");for(var 
w=0;w<pageHolder.length;w++){var 
C=$(pageHolder[w]).attr("skip")=="true";if(C){pageHolder[w].skipPage=true;hasSki 
pPage=true;}var a=$(".field",pageHolder[w]);pageHolder[w].questions=a;var 
s=0;for(var 
x=0;x<a.length;x++){a[x].indexInPage=s;a[x].pageIndex=w;if(hasSkipPage){a[x].pag 
eParent=pageHolder[w];}s++;}}$("#divMatrixRel").bind("click",function(k){k.stopP 
ropagation();});$(document).bind("click",function(){setMatrixFill();postHeight() 
;});$("#matrixinput").on("keyup blur focus",function(){if(curMatrixFill){var 
F=$("#matrixinput").val();curMatrixFill.fillvalue=F;if(window.needSaveJoin){var 
k=$(curMatrixFill).parents(".field");var 
q=k.attr("ischeck");saveMatrixFill(curMatrixFill,q);saveAnswer(k);}}});var 
b=false;var B=new Array();allQArray=$(".field");allQArray.each(function(){var 
N=$(this);var 
q=N.attr("type");N.bind("click",function(){if(this.removeError){this.removeError 
();}if(!hasClickQ){pushHistory();}hasClickQ=true;try{checkJpMatch(q,this);}catch 
(aa){}if(window.loadGeetest){window.loadGeetest();}if(window.scrollup){scrollup. 
Stop();}});var U=getTopic(N);questionsObject[U]=N;var 
W=N.attr("isshop");if(W){shopArray.push(this);}var 
J=N.attr("relation");if(J&&J!="0"){var G=J.split(",");var Z=G[0];var 
Q=G[1].split(";");for(var L=0;L<Q.length;L++){var 
H=Z+","+Q[L];if(!relationHT[H]){relationHT[H]=new 
Array();}relationHT[H].push(this);}if(!relationQs[Z]){relationQs[Z]=new 
Array();}relationQs[Z].push(this);relationNotDisplayQ[U]="1";}else{if(J=="0"){re 
lationNotDisplayQ[U]="1";}}var O=N.attr("titletopic");if(O){var 
X=questionsObject[O];if(X){if(!X[0]._titleTopic){X[0]._titleTopic=new 
Array();}X[0]._titleTopic.push(U);var 
M=N.find(".field-label")[0];if(M){M.innerHTML=M.innerHTML.replace("[q"+O+"]","<s 
pan id='spanTitleTopic"+U+"' 
style='text-decoration:underline;'></span>");}}}if(N.attr("hrq")=="1"){return 
true;}if(q=="1"){var R=$("input",N);R.on("keyup blur 
click",function(){verifyTxt(N,R);prevInputControl=this;window.hasAnswer=true;jum 
p(N,this);referTitle(N,this.value);saveAnswer(N);});if(window.needSaveJoin){R.ch 
ange(function(){saveAnswer(N);});}R.blur(function(){checkOnly(N,R);});var 
P=$("textarea",N);if(P[0]){var 
k=P.prev("a")[0];k.par=N[0];P[0].par=N[0];N[0].needsms=true;var 
Y=P.parent().find(".phonemsg")[0];N[0].mobileinput=R[0];N[0].verifycodeinput=P[0 
];k.onclick=function(){if(this.disabled){return;}var 
ac=this.par;if(!/^\d{11}$/.test(ac.mobileinput.value)){alert("请输入正确的手机号码");retur 
n;}if(ac.issmsvalid&&ac.mobile==ac.mobileinput.value){return;}if(this.isSending) 
{return;}if(!P[1]){return;}if(this.repeat&&!confirm("您输入的手机号码“"+ac.mobileinput.v 
alue+"”确认准确无误吗？")){return;}var ad="divVCode"+U;openDialogByIframe(300,70,ad);var 
aa=document.getElementById("yz_popdivData");var 
ae=aa.getElementsByTagName("textarea")[0];var 
ab=aa.getElementsByTagName("img")[0];if(ab.style.display=="none"){ab.onclick=fun 
ction(){this.src="/AntiSpamImageGen.aspx?t="+(new 
Date()).valueOf();};ab.style.display="";ab.onclick();}$(ae).on("keyup 
blur",function(){var 
af=/^[0-9a-zA-Z]{4}$/g;if(af.test(this.value)){k.sendActivitySms(this.value);thi 
s.value="";$("#yz_popTanChuClose").click();}});ae.focus();};k.sendActivitySms=fu 
nction(ad){this.isSending=true;this.disabled=true;var ac=this.par;var 
ab=this;var 
aa="/Handler/AnswerSmsHandler.ashx?q="+activityId+"&mob="+escape(ac.mobileinput. 
value)+"&valcode="+ad+"&t="+(new 
Date()).valueOf();$.ajax({type:"GET",url:aa,async:false,success:function(ae){var 
af="";if(ae=="true"){af="成功发送，每天最多发送5次。如未收到，请检查手机号是否正确！";ab.repeat=1;ab.resent() 
;}else{if(ae=="fast"){af="发送频率过快";ab.resent();}else{if(ae=="no"){af="发布者短信数量不够"; 
}else{if(ae=="fail"){af="短信发送失败，每天最多发送5次！";}else{if(ae=="error"){af="手机号码不正确";}e 
lse{if(ae=="nopub"){af="问卷未运行，不能填写";}else{af=ae;}}}}}}if(af.indexOf("图形验证码")>-1) 
{ab.disabled=false;}Y.innerHTML=af;ab.isSending=false;}});};k.resent=function(){ 
var ab=this;var aa=60;var 
ac=setInterval(function(){aa--;if(aa<57){ab.isSending=false;}if(aa>0){ab.innerHT 
ML="重发("+aa+"秒)";}else{ab.innerHTML="发送验证码";ab.disabled=false;clearInterval(ac); 
}},1000);};P[0].onchange=P[0].onblur=function(){var 
ac=this.value;if(ac.length!=6){Y.innerHTML="提示：请输入6位数字！";return;}if(!/^\d+$/.exe 
c(ac)){Y.innerHTML="提示：请输入6位数字！";return;}var 
ab=this.par;if(ab.issmsvalid&&ab.mobile==ab.mobileinput.value){return;}if(ab.pre 
vcode==ac){return;}ab.prevcode=ac;var 
aa="/Handler/AnswerSmsValidateHandler.ashx?q="+activityId+"&mob="+escape(ab.mobi 
leinput.value)+"&code="+escape(ac)+"&t="+(new 
Date()).valueOf();$.ajax({type:"GET",url:aa,async:false,success:function(ad){ab. 
issmsvalid=false;var 
ae="";if(ad=="true"){ab.issmsvalid=true;ab.mobile=ab.mobileinput.value;ae="成功通过验 
证";writeError(ab,"",1000);}else{if(ad=="send"){ae="请先发送验证码，每天最多发送5次！";}else{if(a 
d=="no"){ae="验证码输入错误超过5次，无法再提交";}else{if(ad=="error"){ae="验证码输入错误，连续输错5次将无法提交";} 
}}}Y.innerHTML=ae;}});};}}else{if(q=="2"){var R=$("textarea",N);R.on("keyup blur 
click",function(){verifyTxt(N,R);prevInputControl=this;window.hasAnswer=true;jum 
p(N,this);referTitle(N,this.value);saveAnswer(N);});R.blur(function(){checkOnly( 
N,R);});}else{if(q=="9"){var S=$("input",N);S.on("keyup blur 
change",function(){var 
aa=$(this);prevInputControl=this;msg=verifyTxt(N,$(this),true);jump(N,this);save 
Answer(N);});S.blur(function(){checkOnly(N,$(this));});}else{if(q=="8"){$("input 
",N).change(function(){jump(N,this);saveAnswer(N);});}else{if(q=="12"){$("input" 
,N).change(function(){var ab=null;var ae=$(N).attr("total");var 
af=$("input:visible",N);var ac=count=af.length;var 
ag=ae;af.each(function(ah){if(ah==ac-1){ab=this;}if($(this).val()){count--;ag=ag 
-$(this).val();}});if(count==1&&ab&&ag>0){$(ab).val(ag).change();ag=0;}msg="";if 
(ag!=0&&count==0){var 
ad=parseInt($(ab).val())+ag;if(ad>=0){if(ab!=this){$(ab).val(ad).change();ag=0;} 
else{if(af.length==2){var 
aa=ae-$(ab).val();$(af[0]).val(aa).change();ag=0;}}}else{msg="，<span 
style='color:red;'>"+sum_warn+"</span>";}}if(ag==0){af.each(function(ah){if(!$(t 
his).val()){$(this).val("0").change();}});}$(".relsum",N).html(sum_total+"<b>"+a 
e+"</b>"+sum_left+"<span 
style='color:red;font-bold:true;'>"+(ae-ag)+"</span>"+msg);jump(N,this);saveAnsw 
er(N);});}else{if(q=="13"){b=true;}else{if(q=="3"){var 
K=$("div.ui-radio",N);K.each(function(){if(window.hasTouPiao){var 
aa=this.getAttribute("htp");if(aa){var 
ab=document.getElementById("spanPiao"+U+"_"+aa);if(ab){ab.style.display="";}}}sh 
owImg(this);});K.bind("click",function(ad){var 
ab=$(this);if(N[0]&&N[0].hasConfirm){return;}var 
ac=ab.find("input[type='radio']")[0];if(ac.disabled){return;}window.hasAnswer=tr 
ue;$(N).find("div.ui-radio").each(function(){var 
ae=$(this);ae.find("input[type='radio']")[0].checked=false;ae.find("a.jqradio"). 
removeClass("jqchecked");});ac.checked=true;var 
aa=ab.find("input.OtherRadioText")[0];if(aa){ac.itemText=aa;}processRadioInput(N 
[0],ac);ab.find("a.jqradio").addClass("jqchecked");displayRelationByType(N,"inpu 
t[type=radio]",1);referTitle(N);jump(N,ac);if(N.attr("req")!="1"){addClearHref(N 
);}showAnswer(N,K,true);saveAnswer(N);if(ab.attr("desc")!=1){ad.preventDefault() 
;}});var 
V=N.attr("qingjing");if(V){B.push(N);}$("input.OtherRadioText",N).bind("click",f 
unction(ae){$(this.parentNode.parentNode.parentNode).find("div.ui-radio").each(f 
unction(){$(this).find("input[type='radio']")[0].checked=false;$(this).find("a.j 
qradio").removeClass("jqchecked");});prevInputControl=this;var 
aa=$(this).attr("rel");var ac=$("#"+aa)[0];ac.checked=true;var 
ab=$("#"+aa).parent().parent();ab.find("a.jqradio").addClass("jqchecked");ac.ite 
mText=this;var 
ad=$(this).parents("div.field");processRadioInput(ad[0],ac);displayRelationByTyp 
e(ad,"input[type=radio]",1);jump(ad,ac);saveAnswer(ad);ae.stopPropagation();ae.p 
reventDefault();});if(window.needSaveJoin){$("input.OtherRadioText",N).bind("blu 
r",function(aa){saveAnswer(N);});}}else{if(q=="7"){var 
I=$("select",N);I.bind("change",function(ab){$("span",this.parentNode).html(this 
.options[this.selectedIndex].text);displayRelationByType(N,"option",5);jump(N,th 
is.options[this.selectedIndex]);var 
aa=this.options[this.selectedIndex].text;if(this.value==-2){aa="";}referTitle(N, 
aa);saveAnswer(N);ab.preventDefault();});if(I[0].selectedIndex>0){$("span",I[0]. 
parentNode).html(I[0].options[I[0].selectedIndex].text);}}else{if(q=="10"){var 
T=N.attr("select")=="1";if(T){$("select",N).bind("change",function(){$("span",th 
is.parentNode).html(this.options[this.selectedIndex].text);jump(N,this);saveAnsw 
er(N);});}$("input",N).bind("change blur",function(){var af=$(this);var 
ae=af.val();prevInputControl=this;var ab=af.attr("isdigit");var 
ad=ab=="1"||ab=="2";if(ad){if(ab=="1"&&parseInt(ae)!=ae){af.val("");}else{if(ab= 
="2"&&parseFloat(ae)!=ae){af.val("");}else{var 
ac=af.attr("min");if(ac&&ae-ac<0){af.val("");}var 
aa=af.attr("max");if(aa&&ae-aa>0){af.val("");}}}}else{msg=verifyTxt(N,$(this),tr 
ue);}jump(N,this);saveAnswer(N);});}else{if(q=="5"){initRate(N);}else{if(q=="6") 
{initRate(N,true);}else{if(q=="4"){var 
F=$("div.ui-checkbox",N);F.each(function(){if(window.hasTouPiao){var 
aa=this.getAttribute("htp");if(aa){var 
ab=document.getElementById("spanPiao"+U+"_"+aa);if(ab){ab.style.display="";}}}sh 
owImg(this);});F.bind("click",function(ac){var 
ad=$(this);if(N[0]&&N[0].hasConfirm){return;}var 
ab=ad.find("input[type='checkbox']")[0];if(ab.disabled){return;}ab.checked=!ab.c 
hecked;window.hasAnswer=true;if(ab.checked){ad.find("a.jqcheck").addClass("jqche 
cked");}else{ad.find("a.jqcheck").removeClass("jqchecked");}checkHuChi(N,this);d 
isplayRelationByType(N,"input[type='checkbox']",2);verifyCheckMinMax(N,false,fal 
se,this);jump(N,ab);if(window.createItem){createItem(N);}var 
aa=ad.find("input.OtherText")[0];if(aa){if(!ab.checked){aa.pvalue=aa.value;aa.va 
lue="";}else{aa.value=aa.pvalue||"";}}referTitle(N);showAnswer(N,F);saveAnswer(N 
);ac.preventDefault();});$("input.OtherText",N).bind("click",function(af){var 
ab=$(this).attr("rel");var ac=$("#"+ab)[0];prevInputControl=this;var 
ae=$(this).parents("div.field");var aa=ae.attr("maxvalue");if(aa){var 
ag=$("input:checked",ae).length;if(ag>aa||(ag==aa&&!ac.checked)){$(this).blur(); 
af.stopPropagation();af.preventDefault();return;}}ac.checked=true;ac.itemText=th 
is;var 
ad=$("#"+ab).parents(".ui-checkbox");ad.find("a.jqcheck").addClass("jqchecked"); 
if(this.pvalue&&!this.value){this.value=this.pvalue;}checkHuChi(ae,ad[0]);displa 
yRelationByType(ae,"input[type=checkbox]",2);jump(ae,ac);verifyCheckMinMax(ae,fa 
lse);if(window.createItem){createItem(ae);}saveAnswer(ae);af.stopPropagation();a 
f.preventDefault();});if(window.needSaveJoin){$("input.OtherText",N).bind("blur" 
,function(aa){saveAnswer(N);});}}else{if(q=="21"){$(".shop-item",N).each(functio 
n(){var aa=$(".itemnum",this);var 
ab=$(".item_left",this);$(".add",this).bind("click",function(ad){var 
ag=false;var ac=0;if(ab[0]){ag=true;ac=parseInt(ab.attr("num"));}var 
af=parseInt(aa.val());if(ag&&af>=ac){var 
ae="库存只剩"+ac+"件，不能再增加！";if(ac<=0){ae="已售完，无法添加";}alert(ae);}else{aa.val(af+1);up 
dateCart(N);}ad.preventDefault();});aa.bind("focus",function(ac){if(aa.val()=="0 
"){aa.val("");}});aa.bind("blur 
change",function(ae){if(!aa.val()){aa.val("0");}var 
ah=parseInt(aa.val());if(!ah||ah<0){aa.val("0");updateCart(N);return;}var 
ag=false;var 
ad=0;if(ab[0]){ag=true;ad=parseInt(ab.attr("num"));}if(ag){if(ah>ad){var 
af="库存只剩"+ad+"件，不能超过库存！";if(ad<=0){af="已售完，无法添加";}alert(af);var 
ac=ad;if(ac<0){ac=0;}aa.val(ac);}}updateCart(N);ae.preventDefault();});$(".remov 
e",this).bind("click",function(ac){var 
ad=parseInt(aa.val());if(ad>0){aa.val(ad-1);updateCart(N);}ac.preventDefault();} 
);});}else{if(q=="11"){$("li.ui-li-static",N).bind("click",function(ac){var 
aa=$(this).find("input.OtherText")[0];if(!$(this).attr("check")){var 
ab=$(this.parentNode).find("li[check='1']").length+1;$(this).find("span.sortnum" 
).html(ab).addClass("sortnum-sel");$(this).attr("check","1");if(aa){aa.value=aa. 
pvalue||"";}}else{var 
ab=$(this).find("span").html();$(this.parentNode).find("li[check='1']").each(fun 
ction(){var 
ad=$(this).find("span.sortnum").html();if(ad-ab>0){$(this).find("span.sortnum"). 
html(ad-1);}});$(this).find("span.sortnum").html("").removeClass("sortnum-sel"); 
$(this).attr("check","");if(aa){aa.pvalue=aa.value;aa.value="";}}displayRelation 
ByType(N,"li.ui-li-static",3);verifyCheckMinMax(N,false,true,this);jump(N,this); 
if(window.createItem){createItem(N,true);}saveAnswer(N);ac.preventDefault();});$ 
("input.OtherText",N).bind("click",function(ae){ae.stopPropagation();ae.preventD 
efault();var aa=$(this).attr("rel");var 
ac=$("#"+aa).eq(0).parent("li.ui-li-static");var 
ab=ac.eq(0).parent("ul.ui-controlgroup");if(ac.attr("check")!=1){var 
ad=ab.find("li[check='1']").length+1;ac.find("span.sortnum").html(ad).addClass(" 
sortnum-sel");ac.attr("check","1");}displayRelationByType(N,"li.ui-li-static",3) 
;verifyCheckMinMax(N,false,true,this);jump(N,this);if(window.createItem){createI 
tem(N,true);}saveAnswer(N);ae.preventDefault();});if(window.needSaveJoin){$("inp 
ut.OtherText",N).bind("blur",function(aa){saveAnswer(N);});}}}}}}}}}}}}}}}});if( 
window.totalCut&&window.totalCut>0){for(var x=0;x<window.totalCut;x++){var 
g="divCut"+(x+1);var D=$("#"+g);var h=D.attr("relation");if(h&&h!="0"){var 
d=h.split(",");var E=d[0];var 
p=d[1].split(";");relationNotDisplayQ[D.attr("topic")]="1";for(var 
l=0;l<p.length;l++){var e=E+","+p[l];if(!relationHT[e]){relationHT[e]=new 
Array();}relationHT[e].push(D[0]);}if(!relationQs[E]){relationQs[E]=new 
Array();}relationQs[E].push(D[0]);}var o=D.attr("titletopic");if(o){var 
z=questionsObject[o];if(z){if(!z[0]._titleTopic){z[0]._titleTopic=new 
Array();}var v=D.attr("topic");z[0]._titleTopic.push(v);var 
m=D[0].childNodes[0];if(m){m.innerHTML=m.innerHTML.replace("[q"+o+"]","<span 
id='spanTitleTopic"+v+"' 
style='text-decoration:underline;'></span>");}}}}}for(var 
u=0;u<pageHolder.length;u++){var a=pageHolder[u].questions;for(var 
x=0;x<a.length;x++){var 
v=getTopic(a[x]);if(relationQs[v]){relationJoin(a[x]);}var 
y=$(a[x]).attr("refered");if(y&&window.createItem){createItem(a[x]);}}}for(var 
f=0;f<B.length;f++){var 
n=B[f];displayRelationByType(n,"input[type=radio]",1);}$("#ctlNext")!=null&&$("# 
ctlNext").on("click",function(){if(this.disabled){return;}if(window.divTip){aler 
t(divTip.innerHTML);return;}$("#action").val("1");var 
k=validate();if(!k){return;}if(window.useAliVerify){if(!isCaptchaValid){$(".ValE 
rror").html("请先通过滑动验证！");return;}}else{if(tCode&&tCode.style.display!="none"&&(s 
ubmit_text.value==""||submit_text.value==validate_info_submit_title3)){try{submi 
t_text.focus();submit_text.click();}catch(q){}alert(validate_info_submit1);retur 
n;}}groupAnswer(1);});setVerifyCode();initSlider();if(totalPage>1){$("#divSubmit 
").hide();$("#divNext")[0].style.display="";showProgress();}else{$("#divSubmit") 
.show();}if(window.hasPageTime){if(!window.divFengMian){processMinMax();}}fixBot 
tom();$(window).load(function(){fixBottom();});if(window.cepingCandidate){var 
r=cepingCandidate.split(",");var t=new Object();for(var A=0;A<r.length;A++){var 
c=r[A].replace(/(\s*)/g,"").replace(/&/g,"").replace(/\\/g,"");t[c]="1";}var 
j=$("#div1");$("input[type=checkbox]",j).each(function(){var 
F=$(this).parent().parent();var q=F.find(".label")[0];if(!q){return true;}var 
k=q.innerHTML;k=k.replace(/(\s*)/g,"").replace(/&amp;/g,"").replace(/\\/g,"");if 
(t[k]){this.checked=true;}});if(j[0]){createItem(j,false);j[0].style.display="no 
ne";j[0].isCepingQ="1";}}processAward();checkAnswer();});var 
hasConfirmBtn=false;function 
showAnswer(b,d){if(!window.isChuangGuan){return;}if(b.attr("ceshi")!="1"){return 
;}var a=$(b)[0];if(a.confirmButton){return;}var 
c=document.createElement("a");c.style.marginTop="5px";c.className="sumitbutton 
cancle";a.insertBefore(c,a.lastChild);a.confirmButton=c;c.innerHTML="确认";c.oncli 
ck=function(){if(!hasConfirmBtn){if(!confirm("确认后答案将无法修改，确认吗？")){return;}}a.hasC 
onfirm=true;hasConfirmBtn=true;var j=true;var h="";d.each(function(){var 
k=this.getAttribute("ans")=="1";var 
l=$("input",this)[0];if(k){if(!l.checked){j=false;}var 
m=$(".label",this).html();if(/^[A-Z]/.test(m)){m=m.substring(0,1);}if(h){h+=","; 
}h+=m;}else{if(l.checked){j=false;}}});if(!a.correctAnswer){var 
g=document.createElement("div");g.style.marginTop="10px";a.insertBefore(g,a.last 
Child);a.correctAnswer=g;}var e=j?"<span 
style='color:green;'>回答正确</span>":"<span 
style='color:red;'>回答错误，正确答案为："+h+"</span>";a.correctAnswer.innerHTML=e;var 
f=document.getElementById("divjx"+a.id.replace("div",""));if(f){f.style.display= 
"";}};}function restoreAnswer(){if(!window.localStorage){return null;}var 
c=localStorage.wjxtempanswerid;if(c!=activityId){return 
null;}if(window.randomMode){return;}var a="wjxtempanswer";var 
h=localStorage[a];if(!h){return null;}var 
b=localStorage.wjxtempanswerdat;if(!b){return null;}var 
j=window.qBeginDate||0;if(b-j<0){return null;}var f=h.split(spChars[1]);var 
g=new Array();for(var e=0;e<f.length;e++){var d=f[e].split(spChars[0]);var k=new 
Object();k._value=d[1];k._topic=d[0];g.push(k);}return g;}function 
saveAnswer(d){if(!window.localStorage){return;}if(!window.needSaveJoin){return;} 
if(window.randomMode){return;}try{var b="wjxtempanswer";var 
k=localStorage[b];var f=restoreAnswer();if(f==null){f=new Array();}var 
e=getTopic(d);var m=new Object();var 
j=$(d).attr("type");m._topic=e;m._value="";getAnswer(d,m,j,true);var 
h=false;for(var 
c=0;c<f.length;c++){if(f[c]._topic==m._topic){h=true;f[c]._value=m._value;break; 
}}if(!h){f.push(m);}f.sort(function(o,n){return o._topic-n._topic;});var 
l="";for(c=0;c<f.length;c++){if(c>0){l+=spChars[1];}l+=f[c]._topic;l+=spChars[0] 
;l+=f[c]._value;}saveSubmitAnswer(l);}catch(g){}}function 
saveSubmitAnswer(a){if(!window.localStorage){return;}localStorage.setItem("wjxte 
mpanswer",a);localStorage.setItem("wjxtempanswerid",activityId);localStorage.set 
Item("wjxtempanswerdat",new 
Date().getTime());localStorage.setItem("wjxfirstloadtime",fisrtLoadTime);localSt 
orage.setItem("wjxsavepage",cur_page);}function 
clearAnswer(){if(!window.localStorage){return;}localStorage.removeItem("wjxtempa 
nswer");localStorage.removeItem("wjxtempanswerid");localStorage.removeItem("wjxt 
empanswerdat");localStorage.removeItem("wjxfirstloadtime");localStorage.removeIt 
em("wjxlastcosttime");}function loadAnswer(){
	var g=restoreAnswer();
	if(g==null){return;}if(localStorage.wjxfirstloadtime){lastCost 
Time=localStorage.wjxtempanswerdat-localStorage.wjxfirstloadtime;if(localStorage 
.wjxlastcosttime){lastCostTime+=parseInt(localStorage.wjxlastcosttime);}localSto 
rage.setItem("wjxlastcosttime",lastCostTime);}isLoadingAnswer=true;var 
r=localStorage.wjxsavepage;for(var x=0;x<g.length;x++){var t=g[x]._topic;var 
C=g[x]._value;if(!C){continue;}var 
q=$("#div"+t);if(q[0].style.display=="none"){continue;}cur_page=q[0].pageIndex|| 
0;var 
A=$(q).attr("type");switch(A){case"1":$("input",q).val(C).trigger("blur");break; 
case"2":$("textarea",q).val(C).trigger("blur");break;case"3":var 
w=C.split(spChars[2]);$("input",q).each(function(){if(this.type=="radio"&&this.v 
alue==w[0]){if(w[1]){var 
a=$(this).attr("rel");if(a){$("#"+a).val(w[1]);}}q[0].prevRadio=this;$(this.pare 
ntNode.parentNode).trigger("click");}});break;case"4":var 
u=C.split(spChars[3]);$("input",q).each(function(){if(this.type!="checkbox"){ret 
urn true;}var E=this.value;for(var j=0;j<u.length;j++){var 
D=u[j].split(spChars[2]);if(D[0]==E){if(D[1]){var 
a=$(this).attr("rel");if(a){$("#"+a).val(D[1])[0].pvalue=D[1];}}$(this.parentNod 
e.parentNode).trigger("click");break;}}});break;case"5":$(".rate-off",q).each(fu 
nction(){if(this.getAttribute("val")==C){$(this).parent().trigger("click");}});b 
reak;case"7":$("select",q).val(C).trigger("change");break;case"11":var 
u=C.split(",");$("input",q).each(function(){if(this.type!="hidden"){return 
true;}var E=this.value;for(var j=0;j<u.length;j++){var 
D=u[j].split(spChars[2]);if(D[0]==E){if(D[1]){var 
a=$(this).attr("rel");if(a){$("#"+a).val(D[1])[0].pvalue=D[1];}}$(this.parentNod 
e).trigger("click");break;}}});break;case"8":var y=$("input",q);y.val(C);var 
b=q.attr("hasjump");if(b){$(y).trigger("change");}break;case"21":var 
u=C.split(spChars[3]);var h=$("input",q);for(var v=0;v<u.length;v++){var 
d=u[v].split(spChars[2]);var 
s=parseInt(d[0])-1;$(h[s]).val(d[1]);}updateCart(q);break;case"12":case"9":var 
e=C.split(spChars[2]);var k=new Object();for(var v=0;v<e.length;v++){var 
l=e[v].split(spChars[4]);if(l.length==2){k[l[0]]=l[1];}}var 
b=q.attr("hasjump");$("input",q).each(function(D){var a=$(this);var 
E=this.parentNode.parentNode.parentNode;if(window.hasReferClient){if(E&&E.style. 
display=="none"){return true;}}var 
F=a.attr("rowid");if(!F){a.val(e[D]);}else{var 
j=k[F];a.val(j);}$(a).trigger("change");});break;case"13":q[0].fileName=C||"";if 
(C){$(".uploadmsg",q).html("文件已经成功上传！");}break;case"10":var 
e=C.split(spChars[2]);var k=new Object();for(var v=0;v<e.length;v++){var 
l=e[v].split(spChars[4]);if(l.length==2){k[l[0]]=l[1];}}var o="input";var 
z=false;if(q.attr("select")=="1"){o="select";z=true;}var 
b=q.attr("hasjump");$("table",q).each(function(){var 
G=this;if(window.hasReferClient){var 
F=G.parentNode;if(F&&F.style.display=="none"){return true;}}var 
E=G.parentNode.getAttribute("rowid");var j=k[E];var D=j.split(spChars[3]);var 
a=0;$(o,this).each(function(){this.value=D[a]||"";if(z){$(this).trigger("change" 
);}else{if(b){$(this).trigger("change");}}a++;});});break;case"6":var 
e=C.split(",");var k=new Object();for(var v=0;v<e.length;v++){var 
l=e[v].split(spChars[4]);if(l.length==2){k[l[0]]=l[1];}}var 
B=$(q).attr("ischeck");var m=$("table.matrix-rating",q);var p=m[0].rows;for(var 
v=0;v<p.length;v++){var c=p[v];var 
f=c.getAttribute("tp");if(f!="d"){continue;}if(window.hasReferClient&&c.style.di 
splay=="none"){continue;}var n=parseInt(c.getAttribute("rowindex"))+1;var 
l=e[n];$(".rate-off",c).each(function(){var D=$(this).attr("dval");if(B){var 
E=k[n].split(";");for(var j=0;j<E.length;j++){var 
a=E[j].split(spChars[2]);if(D==a[0]){if(a[1]){this.fillvalue=a[1];}$(this).trigg 
er("click");}}}else{var 
E=k[n].split(spChars[2]);if(D==E[0]){if(E[1]){this.fillvalue=E[1];}$(this).trigg 
er("click");}}});}break;}}cur_page=0;if(r&&r>=cur_page+1){pageHolder[0].style.di 
splay="none";cur_page=r-1;localStorage.setItem("wjxsavepage",r);show_next_page() 
;}isLoadingAnswer=false;}function 
checkAnswer(){if(window.needSaveJoin){loadAnswer();}else{if(window.localStorage& 
&!window.divTip){var 
a=restoreAnswer();if(a){$("#divLoadAnswer").show();}}}}function 
hideAward(){if(!confirm("确认不再领取吗？")){return;}if(window.localStorage){vkey="award 
_"+activityId;localStorage.removeItem(vkey);localStorage.removeItem(vkey+"name") 
;localStorage.removeItem(vkey+"tip");}$("#divContent").show().prev().hide();init 
Slider();}function processAward(){var 
b="join_"+activityId;if(!document.cookie||document.cookie.indexOf(b+"=")==-1){re 
turn;}b="award_"+activityId;var d="";var 
a="";if(window.localStorage){d=localStorage[b];a=localStorage[b+"name"];}if(d&&d 
.indexOf("http")==0){var c=localStorage[b+"tip"];var f="";if(c){f=" 
onclick='alert(\""+c+"\");return true;' ";}var e="<div style='margin:10px 
12px;'>恭喜您抽中了"+a+"，如已领取请忽略！<br/><div style='text-align:center;'><a 
href='"+d+"'"+f+" class='button white' target='_blank' style='color:#fff; 
background:#e87814;'>立即领取</a></div><div 
style='margin-top:18px;text-align:center;'><a href='javascript:' 
onclick='hideAward();' 
style='color:#666;font-size:14px;'>不领取，重新填写问卷</a></div></div>";$("#divContent"). 
before(e);$("#divContent").hide();}}function 
postHeight(){if(window==window.top){return;}try{var 
c=parent.postMessage?parent:parent.document.postMessage?parent.document:null;if( 
c!=null){var a=$("body").height();return 
c.postMessage("heightChanged,"+a,"*");}}catch(b){}}function 
saveMatrixFill(b,a){if(!window.needSaveJoin){return;}var 
c=b.parentNode.parentNode;var e=c.getAttribute("fid");if(!e){return;}var 
d="";if(a){$(".rate-on",c).each(function(){if(d){d+=";";}d+=$(this).attr("dval") 
;if(this.fillvalue){var 
g=replace_specialChar(this.fillvalue).replace(/;/g,"；").replace(/,/g,"，");d+=spC 
hars[2]+g;}});}else{d=$(b).attr("dval");if(b.fillvalue){var 
f=replace_specialChar(b.fillvalue).replace(/;/g,"；").replace(/,/g,"，");d+=spChar 
s[2]+f;}}$("#"+e).val(d);}function saveLikert(a){var 
b=$("a.rate-on",a);if(b.length==0){$("input:hidden",a).val("");}else{$("input:hi 
dden",a).attr("value",$(b[b.length-1]).attr("val"));}}function 
initRate(a,b){$(".rate-off",a).parent().bind("click",function(l){var 
c=$(a).attr("ischeck");var f=$("a",this)[0];if(c){var h=true;var 
o=$(a).attr("maxvalue");if(o&&!$(f).hasClass("rate-on")){var 
n=$("a.rate-on",this.parentNode);if(o-n.length<=0){h=false;}}if(h){$(f).toggleCl 
ass("rate-on");$(f).toggleClass("rate-onchk");$(f).trigger("change");}}else{var 
g=$(this.parentNode).find("a.rate-off");g.removeClass("rate-on");var 
k=$(f).attr("mode");if(k){g.removeClass("rate-on"+k);var 
m=f;g.each(function(){$(this).toggleClass("rate-on");$(this).toggleClass("rate-o 
n"+k);if(this==m){return 
false;}});}else{$(f).toggleClass("rate-on");if(!$(f).text()){g.removeClass("rate 
-ontxt");$(f).toggleClass("rate-ontxt");}}$(f).trigger("change");}if($(f).hasCla 
ss("rate-on")){var k=$(f).attr("mode");if(!k){var 
j=$(f).attr("needfill");if(j&&!isLoadingAnswer){showMatrixFill(f);l.stopPropagat 
ion();}}}if(a.attr("type")=="5"){displayRelationByType(a,"a.rate-off",4);}jump(a 
,f);if(a.attr("req")!="1"){addClearHref(a);}$("span.error",a).is(":visible")&&va 
lidateQ(a);if(b){saveMatrixFill(f,c);}else{saveLikert(a,this);}saveAnswer(a);l.p 
reventDefault();});}function updateCart(c){var k=$("#divQuestion");var f="";var 
h=0;var j=0;var d=null;if(shopArray.length>0){var a="";for(var 
e=0;e<shopArray.length;e++){if(shopArray[e].style.display=="none"){continue;}var 
b=$(shopArray[e]).attr("id");if(a){a+=",";}a+="#"+b;}if(a){var 
g=$(a);d=$(".shop-item",g);}}else{d=$(".shop-item",k);}d.each(function(){var 
m=$(".itemnum",this);var p=parseInt(m.val());if(p==0){return true;}var 
q=$(".item_name",this).html();var n=$(".item_price",this).attr("price");var 
o=p*parseFloat(n);var l='<li class="productitem"><span 
class="fpname">'+q+'</span><span class="fpnum">'+p+'</span><span 
class="fpprice">￥'+toFixed0d(o)+"</span></li>";f+=l;h+=o;j+=p;});f="<ul 
class='productslist'>"+f+'<li class="productitem"><span 
class="fpname"></span><span class="fpnum" 
style="font-weight:bold;">'+j+'</span><span class="fpprice" 
style="font-weight:bold;">￥'+toFixed0d(h,2)+"</span></li></ul>";$("#shopcart").h 
tml(f);if(h>0){$("#shopcart").show();}else{$("#shopcart").hide();}saveAnswer(c); 
}function toFixed0d(a){return a.toFixed(2).replace(".00","");}function 
setVerifyCode(){if(tCode&&tCode.style.display!="none"){submit_text.value=validat 
e_info_submit_title3;submit_text.onblur=function(){if(submit_text.value==""){sub 
mit_text.value=validate_info_submit_title3;}};submit_text.onfocus=function(){if( 
submit_text.value==validate_info_submit_title3){submit_text.value="";}};imgCode. 
style.display="none";submit_text.onclick=function(){if(!needAvoidCrack&&imgCode. 
style.display=="none"){imgCode.style.display="";imgCode.onclick=refresh_validate 
;imgCode.onclick();imgCode.title=validate_info_submit_title1;}else{if(needAvoidC 
rack&&!imgVerify){var 
c=$("#divCaptcha")[0];c.style.display="";imgVerify=c.getElementsByTagName("img") 
[0];imgVerify.style.cursor="pointer";imgVerify.onclick=function(){var h=new 
Date();var e=h.getTime()+(h.getTimezoneOffset()*60000);var 
f=window.location.host||"www.sojump.com";var 
g="//"+f+"/botdetect/"+activityId+".aspx?get=image&c="+this.captchaId+"&t="+this 
.instanceId+"&d="+e;this.src=g;};var a=imgVerify.getAttribute("captchaid");var 
b=imgVerify.getAttribute("instanceid");imgVerify.captchaId=a;imgVerify.instanceI 
d=b;imgVerify.onclick();}}};}}function fixBottom(){postHeight();var 
a=$("body").height()-$(window).height();if(a<0){$(".logofooter").addClass("fixed 
bottom");}else{$(".logofooter").removeClass("fixedbottom");}}var 
firstError=null;var firstMatrixError=null;var needSubmitNotValid=false;function 
validate(){var 
b=true;firstError=null;firstMatrixError=null;curMatrixError=null;$(".field:visib 
le").each(function(){var e=pageHolder[cur_page].hasExceedTime;if(e){return 
true;}var 
d=$(this),a=validateQ(d);if(!a){b=false;}});if(!b){if(firstError){$("html, 
body").animate({scrollTop:$(firstError).offset().top},600);$(".scrolltop").show( 
);$(".scrolltop").click(function(){$("html, 
body").animate({scrollTop:$(document).height()},600);$(".scrolltop").hide();});} 
}else{}return b;}var txtCurCity=null;function 
openCityBox(g,f,d,h){txtCurCity=g;var e="";h=h||"";var b=400;if(f==3){var 
a=g.getAttribute("province");var 
c="";if(a){c="&pv="+encodeURIComponent(a);}e="/wjx/design/setcitycountymobo2.asp 
x?activityid="+activityId+"&ct="+f+c+"&pos="+h;b=300;}else{if(f==4){var 
a=g.getAttribute("province");var 
c="";if(a){c="&pv="+encodeURIComponent(a);}e="/wjx/design/school.aspx?activityid 
="+activityId+"&ct="+f+c+"&pos="+h;}else{if(f==5){e="/wjx/design/setmenusel.aspx 
?activityid="+activityId+"&ct="+f+"&pos="+h;}else{if(f==6){e="/wjx/join/amap.asp 
x?activityid="+activityId+"&ct="+f+"&pos="+h;if($(g).attr("needonly")=="1"){e+=" 
&nc=1";if(g.value){$(g.parentNode.parentNode).find(".errorMessage").html("提示：定位后 
无法修改。");return;}}}else{e="/wjx/design/setcitymobo2.aspx?activityid="+activityId+ 
"&ct="+f+"&pos="+h;b=250;}}}}openDialogByIframe(400,b,e);}function 
showItemDesc(c,j,b,d){var a=document.getElementById(b);var 
e=$.trim(a.innerHTML);if(e.indexOf("http")==0){openDialogByIframe(c,j,e,true);}e 
lse{a.style.display="";a.style.width=(Math.min($(window).width(),400)-50)+"px";v 
ar g=a.offsetHeight+20;a.style.display="none";var h=$(window).height()-30;var 
f=true;if(g<h&&g>30){j=g;f=false;}openDialogByIframe(c,j,b,f);}}function 
setCityBox(b){txtCurCity.value=b;$("#yz_popTanChuClose").click();if(window.needS 
aveJoin){var a=$(txtCurCity).parents(".field");saveAnswer(a);}}var 
startAge=0;var endAge=0;var rName="";var gender=0;var marriage=0;var 
education="";function 
getRname(d,b,g){if(rName){return;}if(d!="1"){if(d=="9"){var 
e=b[0].getElementsByTagName("th");for(var 
f=0;f<e.length;f++){if(e[f].innerHTML.indexOf("姓名")>-1){var 
c=e[f].parentNode.getElementsByTagName("input");if(c[0]){rName=c[0].value;}break 
;}}}return;}if(g.indexOf("姓名")==-1){return;}rName=$("input:text",b).val();}funct 
ion 
getGender(d,c,e,b){if(d!="3"){return;}if(e.indexOf("性别")==-1){return;}b.each(fun 
ction(a){if(this.checked){var 
f=$(this.parentNode.parentNode).find(".label").html();if(f.indexOf("男")>-1){gend 
er=1;}else{if(f.indexOf("女")>-1){gender=2;}}return false;}});}function 
getMarriage(d,c,e,b){if(d!="3"){return;}if(e.indexOf("婚姻")==-1){return;}if(marri 
age){return;}b.each(function(a){if(this.checked){var 
f=$(this.parentNode.parentNode).find(".label").html();if(f.indexOf("未婚")>-1){mar 
riage=1;}else{if(f.indexOf("已婚")>-1||f.indexOf("离异")>-1){marriage=2;}}return 
false;}});}function 
getEducation(d,c,e,b){if(d!="3"){return;}if(e.indexOf("学历")==-1&&e.indexOf("学位") 
==-1){return;}if(education){return;}b.each(function(a){if(this.checked){var 
f=$(this.parentNode.parentNode).find(".label").html();if(f.indexOf("硕士")>-1||f.i 
ndexOf("博士")>-1||f.indexOf("研究生")>-1){education=5;}else{if(f.indexOf("本科")>-1){e 
ducation=4;}else{if(f.indexOf("大专")>-1||f.indexOf("专科")>-1){education=3;}else{if 
(f.indexOf("高中")>-1||f.indexOf("中专")>-1||f.indexOf("职高")>-1){education=2;}else{i 
f(f.indexOf("初中")>-1||f.indexOf("小学")>-1){education=1;}}}}}return 
false;}});}function 
checkJpMatch(c,b){if(jpmatch){return;}if(b.hasCheck){return;}b.hasCheck=true;var 
f=$("div.field-label",b).html();var 
e=matchJp(f);if(e){jpmatch=e;return;}if(c!="3"&&c!="4"){return;}var 
d=$("div.label",b);d.each(function(g){var 
a=this.innerHTML;e=matchJp(a);if(e){jpmatch=e;return false;}});}function 
matchJp(c){for(var a=0;a<jpkeyword.length;a++){var 
b=jpkeyword[a];if(c&&c.indexOf(b)>-1){return 1;}}for(var 
a=0;a<enkeyword.length;a++){var b=enkeyword[a];if(c&&c.indexOf(b)>-1){return 
2;}}for(var a=0;a<enchukeyword.length;a++){var 
b=enchukeyword[a];if(c&&c.indexOf(b)>-1){return 5;}}for(var 
a=0;a<enyoukeyword.length;a++){var 
b=enyoukeyword[a];if(c&&c.indexOf(b)>-1){return 4;}}for(var 
a=0;a<enxiaokeyword.length;a++){var 
b=enxiaokeyword[a];if(c&&c.indexOf(b)>-1){return 3;}}return 0;}function 
getAge(j,h,f,k){if(j!="3"&&j!="7"){return;}if(f.indexOf("年龄")==-1){return;}var 
b="";var 
g=0;if(j==3){k.each(function(a){if(this.checked){b=$(this.parentNode.parentNode) 
.find(".label").html();g=a;return false;}});}else{if(j==7){var 
e=$("select",h)[0];b=e.options[e.selectedIndex].text;g=e.selectedIndex-1;}}if(!b 
){return;}var d=/[1-9][0-9]*/g;var 
c=b.match(d);if(!c||c.length==0){return;}if(c.length>2){return;}if(c.length==2){ 
startAge=c[0];endAge=c[1];}else{if(c.length==1){if(g==0){endAge=c[0];}else{start 
Age=c[0];}}}}function getAnswer(g,p,l,h){var 
m=0;switch(l){case"1":if(!h){p._value="(跳过)";if(g.attr("hrq")=="1"){p._value="Ⅳ" 
;}break;}var e=$("input",g);var 
c=e.val();if(c&&e[0].lnglat){c=c+"["+e[0].lnglat+"]";}p._value=replace_specialCh 
ar(c);break;case"2":if(!h){p._value="(跳过)";if(g.attr("hrq")=="1"){p._value="Ⅳ";} 
break;}var e=$("textarea",g);var 
c=e.val();if(c&&e[0].lnglat){c=c+"["+e[0].lnglat+"]";}p._value=replace_specialCh 
ar(c);break;case"3":if(!h){p._value="-3";if(g.attr("hrq")=="1"){p._value="-4";}b 
reak;}$("input[type='radio']:checked",g).each(function(q){p._value=$(this).val() 
;var 
a=$(this).attr("rel");if(a&&$("#"+a).val().length>0){p._value+=spChars[2]+replac 
e_specialChar($("#"+a).val().substring(0,3000));}return 
false;});break;case"4":if(!h){p._value="-3";if(g.attr("hrq")=="1"){p._value="-4" 
;}break;}var k=0;$("input:checked",g).each(function(){var 
q=this.parentNode.parentNode.style.display=="none";if(!q){if(k>0){p._value+=spCh 
ars[3];}p._value+=$(this).val();var 
a=$(this).attr("rel");if(a&&$("#"+a).val().length>0){p._value+=spChars[2]+replac 
e_specialChar($("#"+a).val().substring(0,3000));}k++;}});if(k==0){p._value="-2"; 
}break;case"21":if(!h){p._value="-3";break;}var k=0;$(".shop-item 
.itemnum",g).each(function(a){var 
q=$(this).val();if(q!="0"){if(k>0){p._value+=spChars[3];}p._value+=(a+1);p._valu 
e+=spChars[2]+q;k++;}});if(k==0){p._value="-2";}break;case"11":var d=new 
Array();$("li.ui-li-static",g).each(function(){var 
q=$(this).find("span.sortnum").html();var r=new Object();r.sIndex=q;var 
s=$(this).find("input:hidden").val();var 
a=$(this).find("input.OtherText");if(a.length>0&&a.val().length>0){s+=spChars[2] 
+replace_specialChar(a.val().substring(0,3000));}if(!h){s="-3";}else{if(!q){s="- 
2";}}r.val=s;if(!r.sIndex){r.sIndex=10000;}d.push(r);});d.sort(function(r,q){ret 
urn r.sIndex-q.sIndex;});for(var 
f=0;f<d.length;f++){if(f>0){p._value+=",";}p._value+=d[f].val;}break;case"5":if( 
!h){p._value="-3";break;}p._value=$("input:hidden",g).val();break;case"6":m=0;$( 
"input:hidden",g).each(function(a){if(m>0){p._value+=",";}var q=false;var 
r=(a+1);if(window.hasReferClient){var 
s=document.getElementById("drv"+p._topic+"_"+(a+1));if(s&&s.style.display=="none 
"){q=true;}else{if(!s&&questionsObject[p._topic]){q=true;}}}p._value+=r+spChars[ 
4];if(!h){p._value+="-3";}else{var 
t=$(this).val();if(!t){t="-2";}if(q){t="-4";}p._value+=t;}m++;});break;case"7":i 
f(!h){p._value="-3";break;}p._value=$("select",g).val();break;case"8":if(!h){p._ 
value="(跳过)";break;}p._value=$("input.ui-slider-input",g).val();break;case"9":m= 
0;if(!h&&g.attr("hrq")=="1"){p._value="Ⅳ";break;}var 
n=$("input",g);if(g.attr("randomrow")=="1"){var 
j=g.attr("topic");n=n.toArray().sort(function(s,r){var 
q=$(s).attr("id").replace("q"+j+"_","");var 
t=$(r).attr("id").replace("q"+j+"_","");return 
q-t;});}$(n).each(function(){if(m>0){p._value+=spChars[2];}var 
q=this.getAttribute("rowid");if(q){p._value+=q+spChars[4];}var 
s=$(this).val();var a=false;if(window.hasReferClient){var 
r=this.parentNode.parentNode.parentNode;if(r&&r.tagName=="TR"&&r.style.display== 
"none"){a=true;}}if(!h){s="(跳过)";}else{if(a){s="Ⅳ";}}if(s&&this.lnglat){s=s+"["+ 
this.lnglat+"]";}p._value+=replace_specialChar(s);m++;});break;case"12":m=0;$("i 
nput",g).each(function(){if(m>0){p._value+=spChars[2];}var 
a=false;if(window.hasReferClient){var 
s=this.parentNode.parentNode.parentNode;if(s&&s.style.display=="none"){a=true;}} 
var q=this.getAttribute("rowid");if(q){p._value+=q+spChars[4];}var 
r=$(this).val();if(!h){r="(跳过)";}else{if(a){r="Ⅳ";}}p._value+=r;m++;});break;cas 
e"13":if(!h){p._value="(跳过)";break;}p._value=$(g)[0].fileName||"";break;case"10" 
:m=0;var o="input";var 
b="(跳过)";if(g.attr("select")=="1"){o="select";b="-3";}$("table",g).each(function 
(){var t=this;if(m>0){p._value+=spChars[2];}var a=0;var 
q=false;if(window.hasReferClient){var 
s=t.parentNode;if(s&&s.style.display=="none"){q=true;}}var 
r=t.parentNode.getAttribute("rowid");if(r){p._value+=r+spChars[4];}$(o,this).eac 
h(function(){if(a>0){p._value+=spChars[3];}var u=this;var 
v=u.value;if(!h){v=b;}else{if(q){v="Ⅳ";}}if(v&&u.lnglat){v=v+"["+u.lnglat+"]";}p 
._value+=replace_specialChar(v);a++;});m++;});break;}}function 
groupAnswer(m){var b=new Array();var q=0;var k=new Object();var 
f=1;allQArray.each(function(){var B=$(this);var A=new Object();var 
x=B.attr("type");var 
w=this.style.display!="none";if(w&&hasSkipPage){if(this.pageParent&&this.pagePar 
ent.skipPage){w=false;}}if(this.isCepingQ){w=true;}A._value="";A._topic=getTopic 
(B);if(window.isKaoShi&&window.randomMode&&B.attr("nc")!="1"){k[A._topic]=f;f++; 
}b[q++]=A;try{var z=$("div.field-label",B).html();if(x=="3"||x=="7"){var 
e=null;if(x=="3"){e=$("input[type='radio']",B);}getAge(x,B,z,e);if(x=="3"){getGe 
nder(x,B,z,e);getMarriage(x,B,z,e);getEducation(x,B,z,e);}}getRname(x,B,z);}catc 
h(y){}getAnswer(B,A,x,w);});if(b.length==0){alert("提示：此问卷没有添加题目，不能提交！");return;} 
b.sort(function(w,e){return w._topic-e._topic;});var 
j="";for(i=0;i<b.length;i++){if(i>0){j+=spChars[1];}j+=b[i]._topic;j+=spChars[0] 
;j+=b[i]._value;}if(window.isKaoShi&&window.randomMode&&k&&window.localStorage&& 
window.JSON){var 
v="sortorder_"+activityId;localStorage.setItem(v,JSON.stringify(k));}var 
a=$("#form1").attr("action");if(a.indexOf("aliyun.sojump.com")>-1||a.indexOf("te 
mp.sojump.com")>-1){a=a.replace("aliyun.sojump.com",window.location.host).replac 
e("temp.sojump.com",window.location.host);}var 
d=a+"&starttime="+encodeURIComponent($("#starttime").val());var 
p=window.sojumpParm;if(!window.hasEncode){p=encodeURIComponent(p);}if(window.soj 
umpParm){d+="&sojumpparm="+p;}if(window.tparam){d+="&tparam=1&sojumpparmext="+en 
codeURIComponent(window.sojumpparmext);}if(window.Password){d+="&psd="+encodeURI 
Component(Password);}if(window.hasMaxtime){d+="&hmt=1";}if(window.initMaxSurveyT 
ime){d+="&mst="+window.initMaxSurveyTime;}if(tCode&&tCode.style.display!="none"& 
&submit_text.value!=""){d+="&validate_text="+encodeURIComponent(submit_text.valu 
e);}if(window.useAliVerify){d+="&nc_csessionid="+encodeURIComponent(nc_csessioni 
d)+"&nc_sig="+encodeURIComponent(nc_sig)+"&nc_token="+encodeURIComponent(nc_toke 
n)+"&nc_scene="+nc_scene+"&validate_text=geet";}if(window.cpid){d+="&cpid="+cpid 
;}if(window.guid){d+="&emailguid="+guid;}if(window.udsid){d+="&udsid="+window.ud 
sid;}if(window.isDingDing){d+="&isdd=1";if(window.ddnickname){d+="&ddnn="+encode 
URIComponent(window.ddnickname);}}if(nvvv){d+="&nvvv=1";}if(window.sjUser){d+="& 
sjUser="+encodeURIComponent(sjUser);}if(window.outuser){d+="&outuser="+encodeURI 
Component(outuser);if(window.outsign){d+="&outsign="+encodeURIComponent(outsign) 
;}}if(window.sourceurl){d+="&source="+encodeURIComponent(sourceurl);}else{d+="&s 
ource=directphone";}var 
t=window.alipayAccount||window.cAlipayAccount;if(t){d+="&alac="+encodeURICompone 
nt(t);}if(window.SJBack){d+="&sjback=1";}if(window.jiFen&&jiFen>0){d+="&jf="+jiF 
en;}if(m){d+="&submittype="+m;}if(m==3){d+="&zbp="+(cur_page+1);if(needSubmitNot 
Valid){d+="&nsnv=1";}}if(window.rndnum){d+="&rn="+encodeURIComponent(rndnum);}if 
(imgVerify){d+="&btuserinput="+encodeURIComponent(submit_text.value);d+="&btcapt 
chaId="+encodeURIComponent(imgVerify.captchaId);d+="&btinstanceId="+encodeURICom 
ponent(imgVerify.instanceId);}if(window.inviteid){d+="&inviteid="+encodeURICompo 
nent(inviteid);}if(window.access_token&&window.openid){d+="&access_token="+encod 
eURIComponent(access_token);if(window.isQQLogin){d+="&qqopenid="+encodeURICompon 
ent(openid);}else{d+="&openid="+encodeURIComponent(openid);}}if(window.wxUserId) 
{d+="&wxUserId="+window.wxUserId;}if(window.wxthird){d+="&wxthird=1";}if(lastCos 
tTime&&lastCostTime/1000){d+="&lct="+(parseInt(lastCostTime/1000));}if(window.is 
WeiXin){d+="&iwx=1";}d+="&t="+new 
Date().valueOf();if(window.cProvince){d+="&cp="+encodeURIComponent(cProvince.rep 
lace("'",""))+"&cc="+encodeURIComponent(cCity.replace("'",""))+"&ci="+escape(cIp 
);var l=cProvince+","+cCity;var 
n=window.location.host||"sojump.com";try{setCookie("ip_"+cIp,l,null,"/","",null) 
;}catch(s){}}$("#ctlNext").hide();var 
u="处理中......";if(langVer==1){u="Submiting......";}else{if(langVer==2){u="處理中..." 
;}}$(".ValError").html(u);if(m==3){$(".ValError").html("正在验证，请稍候...");}var 
c={submitdata:j};var h=false;var g=window.getMaxWidth||1800;var 
o=encodeURIComponent(j);if(window.submitWithGet&&o.length<=g){h=true;}try{saveSu 
bmitAnswer(j);}catch(r){}if(h){d+="&submitdata="+o;d+="&useget=1";}else{if(windo 
w.submitWithGet){window.postIframe=1;}}if(window.postIframe){postWithIframe(d,j) 
;}else{if(h){$.ajax({type:"GET",url:d,success:function(e){afterSubmit(e,m);}$("#ctlNext").show();re 
turn;}});}else{$.ajax({type:"POST",url:d,data:c,dataType:"text",success:function 
(e){afterSubmit(e,m);}$("#ctlNext").show();return;}});}}}function postWithIframe(b,c){var 
a=document.createElement("div");a.style.display="none";a.innerHTML="<iframe 
id='mainframe' name='mainframe' style='display:none;' > </iframe><form 
target='mainframe' data-ajax='false' id='frameform' action='' method='post' 
enctype='application/x-www-form-urlencoded'><input  value='' id='submitdata' 
name='submitdata' type='hidden'><input type='submit' value='提交' 
></form>";document.body.appendChild(a);document.getElementById("submitdata").val 
ue=c;var 
d=document.getElementById("frameform");d.action=b+"&iframe=1";d.submit();}var 
havereturn=false;var timeoutTimer=null;function 
processError(c,b,a){if(!havereturn){havereturn=true;$("#ctlNext").show();}if(timeoutTimer){clearTimeout(timeoutTimer);}}v 
ar nvvv=0;function afterSubmit(t,l){$(".ValError").html("");havereturn=true;var 
n=t.split("〒");var h=n[0];if(h==10){var g=n[1];var 
o=g.replace("complete.aspx","completemobile2.aspx").replace("?q=","?activity="). 
replace("&joinid=","&joinactivity=").replace("&JoinID=","&joinactivity=");if(win 
dow.isDingDing){o+="&dd_nav_bgcolor=FF5E97F6";if(window.ddcorpid){o+="&ddpid="+e 
ncodeURIComponent(ddcorpid);}}if(window.isYdb){o+="&ydb=1";}if(startAge){o+="&sa 
="+encodeURIComponent(startAge);}if(endAge){o+="&ea="+encodeURIComponent(endAge) 
;}if(gender){o+="&ge="+gender;}if(marriage){o+="&marr="+marriage;}if(education){ 
o+="&educ="+education;}if(jpmatch){o+="&jpm="+jpmatch;}if(rName){o+="&rname="+en 
codeURIComponent(rName);}if(inviteid){o+="&inviteid="+encodeURIComponent(invitei 
d);}if(window.sourceurl){o+="&source="+encodeURIComponent(sourceurl);}if(window. 
sjUser){o+="&sjUser="+encodeURIComponent(sjUser);}if(window.needHideShare){o+="& 
nhs=1";}if(window.isSimple){o+="&s=t";}if(window.sourcename){o+="&souname="+enco 
deURIComponent(sourcename);}if(!window.wxthird&&window.access_token&&window.hash 
b){o+="&access_token="+encodeURIComponent(access_token)+"&openid="+encodeURIComp 
onent(openid);}if(window.isWeiXin){var q=new 
Date();q.setTime(q.getTime()+(30*60*1000));setCookie("join_"+activityId,"1",q.to 
UTCString(),"/","",null);}if($("#shopcart")[0]&&$("#shopcart")[0].style.display! 
="none"){o+="&ishop=1";}clearAnswer();location.replace(o);return;}else{if(h==11) 
{var 
m=n[1];if(!m){m=window.location.href;}else{if(m.toLowerCase().indexOf("http://") 
==-1&&m.toLowerCase().indexOf("https://")==-1){m="http://"+m;}}m=m.replace("http 
://r.sojump.net.cn","http://r.sojump.cn");var v=n[3]||"";var k=n[4]||"";var 
s=false;if(m.indexOf("{output}")>-1){if(window.sojumpParm){m=m.replace("{output} 
",window.sojumpParm);}else{if(k){m=m.replace("{output}",k);}}s=true;}if(window.s 
ojumpParm||k){var j=v.split(",");var 
a="sojumpindex="+j[0];if(m.indexOf("?")>-1){a="&"+a;}else{a="?"+a;}if(j[1]){a+=" 
&totalvalue="+j[1];}if(m.toLowerCase().indexOf("sojumpparm=")==-1&&!s&&window.so 
jumpParm){a+="&sojumpparm="+window.sojumpParm;}if(m.toLowerCase().indexOf("pingz 
heng=")==-1&&!s&&k){a+="&pingzheng="+k;}m+=a;}if(window.wxthird&&window.openid){ 
if(m.indexOf("?")>-1){m+="&openid="+encodeURIComponent(openid);}else{m+="?openid 
="+encodeURIComponent(openid);}}if(m.indexOf("www.sojump.com")>-1){m=m.replace(" 
/jq/","/m/");}var r=n[2];var 
f=1000;if(r&&window.jiFenBao==0&&r!="不提示"&&!window.sojumpParm){$(".ValError").ht 
ml(r);f=2000;}clearAnswer();setTimeout(function(){location.replace(m);},f);retur 
n;}else{if(l==3){if(h==12){to_next_page();$("#ctlNext").show();return;}else{if(h 
==13){var d=n[1];var u=n[2]||"0";var 
g="/wjx/join/completemobile2.aspx?activity="+activityId+"&joinactivity="+d;g+="& 
v="+u;if(window.isWeiXin){setCookie("join_"+activityId,"1",null,"/","",null);}if 
(window.sjUser){g+="&sjUser="+encodeURIComponent(sjUser);}if(window.sourceurl){g 
+="&source="+encodeURIComponent(sourceurl);}clearAnswer();location.replace(g);re 
turn;}else{if(h==11){return;}else{if(h==5){alert(n[1]);return;}}}}}else{if(h==9| 
|h==16||h==23){var p=parseInt(n[1]);var c=(p+1)+"";var 
e=n[2]||"您提交的数据有误，请检查！";if(questionsObject[c]){writeError(questionsObject[c],e,3 
000);$(questionsObject[c])[0].scrollIntoView();}alert(e);$("#ctlNext").show();}e 
lse{if(h==2||h==21){alert(n[1]);window.submitWithGet=1;$("#ctlNext").show();}els 
e{if(h==4){alert(n[1]);$("#ctlNext").show();return;}else{if(h==19||h==5){alert(n 
[1]);$(".ValError").html(n[1]);return;}else{if(h==17||h==34){alert("密码冲突！在您提交答卷之 
前，此密码已经被另外一个用户使用了，请更换密码重新填写问卷！");return;}else{if(h==22){alert("提交有误，请输入验证码重新提交！" 
);if(!needAvoidCrack){tCode.style.display="";imgCode.style.display="";imgCode.on 
click=refresh_validate;imgCode.onclick();}nvvv=1;$("#ctlNext").show();return;}el 
se{if(h==7){alert(n[1]);if(!needAvoidCrack){tCode.style.display="";if(!imgCode.o 
nclick){imgCode.style.display="";imgCode.onclick=refresh_validate;}imgCode.oncli 
ck();}else{refresh_validate();}$("#ctlNext").show();return;}else{var 
b=n[1]||t;alert(b);$("#ctlNext").show();}}}}}}}}}}refresh_validate();}function 
clearFieldValue(c){if(isLoadingAnswer){return;}var 
d=$(c).attr("type");if(d=="3"){$("input[type='radio']:checked",$(c)).each(functi 
on(){this.checked=false;$(this).parent().parent().find("a.jqradio").removeClass( 
"jqchecked");});$("input.OtherRadioText",$(c)).each(function(){if(this.value){$( 
this).val("").blur();}});}else{if(d=="4"){$("input:checked",$(c)).each(function( 
){this.checked=false;$(this).parent().parent().find("a.jqcheck").removeClass("jq 
checked");});}else{if(d=="6"||d=="5"){$("a.rate-off",$(c)).each(function(){$(thi 
s).removeClass("rate-on");var 
a=$(this).attr("mode");if(a){$(this).removeClass("rate-on"+a);}else{$(this).remo 
veClass("rate-ontxt");}});if(d=="5"){saveLikert(c);}}else{if(d=="7"){if($("selec 
t",$(c)).val()!="-2"){$("select",$(c)).val("-2").trigger("change");}}else{if(d== 
"8"){var 
e=$("input",$(c));if(e.val()){e.val("").change();}}else{if(d=="9"){$("input.ui-s 
lider-input",$(c)).each(function(){if(this.value){$(this).val("").change();}});} 
else{if(d=="11"){$("li.ui-li-static",$(c)).each(function(){$(this).find("span.so 
rtnum").html("").removeClass("sortnum-sel");$(this).attr("check","");});}}}}}}}} 
function validateQ(o){var g=$(o).attr("req"),l=$(o).attr("type"),n=true;var 
k=$(o)[0];var f="";var e=$(o).attr("hasjump");if(l=="1"){var 
h=$("input",$(o));var 
d=$.trim(h.val());n=d.length==0?false:true;f=verifyTxt(o,h);}else{if(l=="2"){var 
h=$("textarea",$(o));var 
d=$.trim(h.val());n=d.length==0?false:true;f=verifyTxt(o,h);}else{if(l=="3"){n=f 
alse;$(o).find("input:checked").each(function(){n=true;if(this.getAttribute("jum 
pto")==-1){needSubmitNotValid=true;}var a=$(this).attr("rel");if(a){var 
b=$("#"+a);if(b.attr("required")&&b.val().length==0){f="文本框内容必须填写！";if(langVer== 
1){f="Please enter a value.";}writeError(o,f,3000);return 
false;}}});}else{if(l=="4"){n=false;var 
p=false;$(o).find("input:checked").each(function(){n=true;var 
a=$(this).attr("rel");if(a){var 
b=$("#"+a);if(b.attr("required")&&b.val().length==0){f="文本框内容必须填写！";if(langVer== 
1){f="Please enter a value.";}b.focus();writeError(o,f,3000);p=true;return 
false;}}});if(!p){f=verifyCheckMinMax($(o),true);}}else{if(l=="11"){n=$("li.ui-l 
i-static[check='1']",$(o)).length==0?false:true;var 
p=false;$("li.ui-li-static[check='1']",$(o)).each(function(){n=true;var 
a=$("input[type='hidden']",$(this)).eq(0).attr("id");if(a){var 
b=$("#tq"+a);if(b.attr("required")&&b.val().length==0){f="文本框内容必须填写！";if(langVer 
==1){f="Please enter a value.";}b.focus();writeError(o,f,3000);p=true;return 
false;}}});if(!p){f=verifyCheckMinMax($(o),true,true);}}else{if(l=="5"){n=valida 
teScaleRating($(o));}else{if(l=="6"){f=validateMatrix($(o),g);if(f){writeError(o 
,f,1000);return false;}}else{if(l=="7"){var 
j=$("select",$(o))[0];n=j.selectedIndex==0?false:true;if(n){if(j.options[j.selec 
tedIndex]&&j.options[j.selectedIndex].getAttribute("jumpto")==-1){needSubmitNotV 
alid=true;}}}else{if(l=="8"){n=$("input",$(o)).val().length==0?false:true;}else{ 
if(l=="9"){$("input",$(o)).each(function(){var a=$(this);var 
c=$.trim(a.val());if(window.hasReferClient){var 
b=this.parentNode.parentNode.parentNode;if(b&&b.style.display=="none"){return 
true;}}if(c.length==0){n=false;if(a.attr("isrequir")=="0"){n=true;}else{return 
false;}}f=verifyTxt(o,a,true);if(f){return false;}f=checkOnly(o,a);if(f){return 
false;}});}else{if(l=="12"){var m=$(o).attr("total");var 
q=m;$("input",$(o)).each(function(){var a=$(this);if(window.hasReferClient){var 
c=this.parentNode.parentNode.parentNode;if(c&&c.style.display=="none"){return 
true;}}var 
b=a.val();if(b.length==0){n=false;}if(b){q=q-b;}});if(q!=0){writeError(o,"",3000 
);return 
false;}}else{if(l=="13"){if(!$(o)[0].fileName){n=false;}}else{if(l=="10"){var 
s="input";if($(o).attr("select")=="1"){s="select";}var 
r=true;$("table",$(o)).each(function(){var 
a=$(this);if(window.hasReferClient){var 
b=this.parentNode;if(b&&b.style.display=="none"){return 
true;}}$(s,a).each(function(){var t=$(this);var u=t.val();var 
c=this.parentNode.parentNode;if(c&&c.style.display!="none"){if(u.length==0||(s== 
"select"&&u=="-2")){n=false;o.errorControl=this;return 
false;}f=verifyTxt(o,t,true);if(f){o.errorControl=this;r=false;return 
false;}}});if(!r){return 
false;}});}}}}}}}}}}}}}if(!n&&g=="1"){f="请回答此题";if(l=="1"||l=="2"){f="请输入内容";}el 
se{if(l=="3"||l=="4"||l=="7"){f="请选择选项";}else{if(l=="13"){f="请上传文件";}}}if(l=="6" 
&&$(o)[0].isMatrixFillError){f="请注明原因";}if(langVer==1){f="required";}writeError( 
o,f,1000);}else{$("span.error",$(o)).hide();$("div.field-label",$(o)).css("backg 
round","");}if(f){return false;}if(k.removeError){k.removeError();}return 
true;}function 
show_prev_page(){if(cur_page>0&&pageHolder[cur_page-1].hasExceedTime){alert("上一页 
填写超时，不能返回上一页");return;}var k=$("#divNext")[0];var 
b=$("#divPrev")[0];pageHolder[cur_page].style.display="none";k.style.display=""; 
$("#divSubmit").hide();cur_page--;for(var 
h=cur_page;h>=0;h--){if(pageHolder[h].skipPage){cur_page--;}else{break;}}var 
e=window.isKaoShi;for(var h=cur_page;h>=0;h--){var l=pageHolder[h].questions;var 
g=false;for(var f=0;f<l.length;f++){var 
a=l[f];if(a.style.display!="none"){g=true;break;}}var 
d=false;if(!g&&pageHolder[h].childNodes&&pageHolder[h].childNodes.length>0){var 
c=pageHolder[h].cuts;if(!c){c=pageHolder[h].cuts=$(".cutfield",pageHolder[h]);}f 
or(var 
f=0;f<c.length;f++){if(c[f].style.display!="none"){d=true;break;}}}if(!g&&!d&&cu 
r_page>0){cur_page--;}else{break;}}if(cur_page==0){b.style.display="none";}pageH 
older[cur_page].style.display="";pageHolder[cur_page].scrollIntoView();showProgr 
ess();}function show_next_page(){var a=$("#divNext 
a")[0];if(a&&a.disabled&&!isLoadingAnswer){return;}if(!validate()){return;}var 
b=$(pageHolder[cur_page]).attr("iszhenbie")=="true";if(needSubmitNotValid&&windo 
w.isRunning){$("#divNext").hide();groupAnswer(3);}else{if(b&&window.isRunning){$ 
("#divNext").hide();groupAnswer(3);}else{to_next_page();}}}function 
to_next_page(){var m=$("#divNext")[0];var 
b=$("#divPrev")[0];b.style.display=displayPrevPage;pageHolder[cur_page].style.di 
splay="none";cur_page++;if(cur_page==1){$("#divDesc").hide();}for(var 
k=cur_page;k<pageHolder.length;k++){if(pageHolder[k].skipPage){cur_page++;}else{ 
break;}}var e=window.isKaoShi;for(var k=cur_page;k<pageHolder.length;k++){var 
n=pageHolder[k].questions;var h=false;for(var f=0;f<n.length;f++){var 
a=n[f];if(a.style.display!="none"){h=true;break;}}var 
d=false;if(!h&&pageHolder[k].childNodes&&pageHolder[k].childNodes.length>0){var 
c=pageHolder[k].cuts;if(!c){c=pageHolder[k].cuts=$(".cutfield",pageHolder[k]);}f 
or(var 
f=0;f<c.length;f++){if(c[f].style.display!="none"){d=true;break;}}}if(!h&&!d&&cu 
r_page<pageHolder.length-1){cur_page++;}else{break;}}var g=true;for(var 
k=cur_page+1;k<pageHolder.length;k++){if(!pageHolder[k].skipPage){g=false;}}if(c 
ur_page>=pageHolder.length-1||g){m.style.display="none";$("#divSubmit").show();} 
if(cur_page<pageHolder.length-1){m.style.display="";}pageHolder[cur_page].style. 
display="";initSlider();var 
l=document.getElementById("divMaxTime");if(l&&l.style.display==""){$("body,html" 
).animate({scrollTop:0},100);}else{pageHolder[cur_page].scrollIntoView();}showPr 
ogress();if(window.hasPageTime){processMinMax();}fixBottom();}function 
initSlider(){if(window.hasSlider){$(pageHolder[cur_page].questions).each(functio 
n(){var b=$(this);var 
a=b.attr("type");if(a=="8"||a=="12"||a=="9"||a=="10"){setTimeout(function(){var 
c=$("input.ui-slider-input:visible",b);c.rangeslider({polyfill:false});},10);}}) 
;}}function 
initqSlider(a){if(!window.hasSlider){return;}if(a.hasInitSlider){return;}a.hasIn 
itSlider=true;var 
b=$("input.ui-slider-input:visible",a);b.rangeslider({polyfill:false});}function 
showProgress(){if(totalPage==1){return;}var 
c=cur_page+1;if(c>totalPage){c=totalPage;}var 
b=c+"/"+totalPage;$(".pagepercent").html(b+"页");var 
a=c*100/totalPage;$(".pagebar").width(a+"%");}function 
verifyCheckMinMax(a,c,k,e){var d=a.attr("minvalue");var h=a.attr("maxvalue");var 
g=a[0];if(d==0&&h==0){return"";}var 
f=0;if(k){f=$("li.ui-li-static[check='1']",a).length;}else{f=$("input:checked",a 
).length;}if(f==0&&!a.attr("req")){return;}var 
b="";if(langVer==0){b="&nbsp;&nbsp;&nbsp;您已经选择了"+f+"项";}var 
j=true;if(h>0&&f>h){if(e){if(langVer==0){alert("此题最多只能选择"+h+"项");}$(e).trigger(" 
click");return"";}if(langVer==0){b+=",<span 
style='color:red;'>多选择了"+(f-h)+"项</span>";}else{b=validate_info+validate_info_ch 
eck4+h+type_check_limit5;}j=false;}else{if(d>0&&f<d){if(langVer==0){b+=",<span 
style='color:red;'>少选择了"+(d-f)+"项</span>";}else{b=validate_info+validate_info_ch 
eck5+d+type_check_limit5;}j=false;if(!k&&f==1&&$("input:checked",a).parents(".ui 
-checkbox").hasClass("huchi")){j=true;}}}if(!g.errorMessage){g.errorMessage=$(". 
errorMessage",a)[0];}if(!j){if(!c){g.errorMessage.innerHTML=b;}else{writeError(a 
[0],b,3000);}return b;}else{g.errorMessage.innerHTML="";}return"";}function 
checkOnly(e,h){var k=$(h);var j=k[0];var 
m=k.attr("needonly");if(!m){return"";}if(k.attr("verify")=="地图"){return"";}var 
g=k.val();if(!g){return"";}if(g.length>50){return"";}var b=getTopic(e);var 
c=k.attr("rowid");if(c){b=parseInt(b)*10000+parseInt(c);}else{var 
a=k.attr("gapindex");if(a){b=parseInt(b)*10000+parseInt(a);}}var 
d="/Handler/AnswerOnlyHandler.ashx?q="+activityId+"&at="+encodeURIComponent(g)+" 
&qI="+b+"&o=true&t="+(new Date()).valueOf();var l=$(e)[0];var 
f="";if(!j.errorOnly){j.errorOnly=new 
Object();}if(j.errorOnly[g]){f=validate_only;if(l.verifycodeinput){l.verifycodei 
nput.parentNode.style.display="none";}if(!l.errorControl&&b-10000>0){l.errorCont 
rol=j;}writeError(l,f,3000);return 
f;}$.ajax({type:"GET",url:d,async:false,success:function(n){if(n=="false1"){f=va 
lidate_only;j.errorOnly[g]=1;if(l.verifycodeinput){l.verifycodeinput.parentNode. 
style.display="none";}if(!l.errorControl&&b-10000>0){l.errorControl=j;}writeErro 
r(l,f,3000);return f;}return"";}});}function verifyTxt(a,e,d){var 
c=$(e).val();var h=$(e).attr("verify");var j=$(e).attr("minword");var 
f=$(e).attr("maxword");var g=$(a)[0];var b="";if(!c){return 
b;}if(g.removeError){g.removeError();}b=verifyMinMax(c,h,j,f);if(!b){b=verifydat 
a(c,h);}if(b){if(!g.errorControl&&d){g.errorControl=$(e)[0];}writeError(g,b,3000 
);return 
b;}if(!b&&g.needsms&&!g.issmsvalid){b="提示：您的手机号码没有通过验证，请先验证";writeError(g,b,3000 
);}return b;}function validateMatrix(s,h){var 
j=$("table.matrix-rating",$(s)),t;var g="";$(s)[0].isMatrixFillError=false;var 
k=j[0].rows;for(var o=0;o<k.length;o++){var b=k[o];var 
f=b.getAttribute("tp");if(f!="d"){continue;}if(window.hasReferClient&&b.style.di 
splay=="none"){continue;}var 
p=$(b).attr("fid"),r=$("a.rate-on",$(b));t="";if(r.length==0){$("#"+p,$(s)).val( 
"");if(h=="1"){g="请回答此题";if(langVer==1){g="required";}$(s)[0].errorControl=$(b). 
prev("tr")[0];break;}else{continue;}}else{t=$(r[r.length-1]).attr("dval");var 
x=$(s).attr("ischeck");if(x){t="";var l=$(s).attr("minvalue");var 
n=$(s).attr("maxvalue");if(l&&r.length-l<0){g=validate_info+validate_info_check5 
+l+type_check_limit5;$(s)[0].errorControl=$(b).prev("tr")[0];break;}else{if(n&&r 
.length-n>0){g=validate_info+validate_info_check4+n+type_check_limit5;$(s)[0].er 
rorControl=$(b).prev("tr")[0];break;}}var 
v=true;$(r).each(function(){if(t){t+=";";}t+=$(this).attr("dval");var 
c=$(this).attr("needfill");if(c){var 
d=this.fillvalue||"";d=replace_specialChar(d).replace(/;/g,"；").replace(/,/g,"，" 
);t+=spChars[2]+d;var 
a=$(this).attr("req");if(a&&!d){g="请回答此题";if(langVer==1){g="required";}$(s)[0].i 
sMatrixFillError=true;showMatrixFill(this,1);v=false;return 
false;}}});if(!v){break;}}else{var w=$(r[r.length-1]).attr("mode");if(!w){var 
m=$(r[r.length-1]).attr("needfill");if(m){var 
q=r[r.length-1].fillvalue||"";q=replace_specialChar(q).replace(/;/g,"；").replace 
(/,/g,"，");t+=spChars[2]+q;var 
u=$(r[r.length-1]).attr("req");if(u&&!q){g="请回答此题";if(langVer==1){g="required";} 
$(s)[0].isMatrixFillError=true;showMatrixFill(r[r.length-1],1);break;}}}}$("#"+p 
,$(s)).attr("value",t);}}return g;}function validateScaleRating(d){var 
e=true,f=$("table.scale-rating",$(d));var 
f=$("a.rate-on",f);if(f.length==0){e=false;$("input:hidden",$(d)).val("");}else{ 
$("input:hidden",$(d)).attr("value",$(f[f.length-1]).attr("val"));if(f.attr("jum 
pto")==-1){needSubmitNotValid=true;}}return e;}function jump(c,e){var d=$(c);var 
f=d.attr("hasjump");if(f){var b=d.attr("type");var 
a=d.attr("anyjump");if(a>0){jumpAnyChoice(c);}else{if(a==0&&b!="3"&&b!="5"&&b!=" 
7"){jumpAnyChoice(c);}else{jumpByChoice(c,e);}}}}function jumpAnyChoice(c,f){var 
d=$(c);var b=d.attr("type");var 
a=false;if(b=="1"){a=$("input",d).val().length>0;}else{if(b=="2"){a=$("textarea" 
,d).val().length>0;}else{if(b=="3"){a=$("input[type='radio']:checked",d).length> 
0;}else{if(b=="4"){a=$("input[type='checkbox']:checked",d).length>0;}else{if(b== 
"5"){a=$("a.rate-on",d).length>0;}else{if(b=="6"){a=$("a.rate-on",d).length>0;}e 
lse{if(b=="7"){a=$("select",d).val()!=-2;}else{if(b=="8"){a=$("input",d).val().l 
ength>0;}else{if(b=="9"||b=="12"){$("input",d).each(function(){var 
g=$(this).val();if(g.length>0){a=true;}});}else{if(b=="10"){var 
e=d.attr("select")=="1";if(e){$("select",d).each(function(){var 
g=$(this).val();if(g!=-2){a=true;}});}else{$("input",d).each(function(){var 
g=$(this).val();if(g.length>0){a=true;}});}}else{if(b=="11"){a=$("li[check='1']" 
,d).length>0;}else{if(b=="13"){a=d[0].fileName?true:false;}}}}}}}}}}}}jumpAny(a, 
c,f);}function jumpByChoice(e,f){var d=$(e).attr("type");var 
c=$(e)[0];if(f.value=="-2"){processJ(c.indexInPage-0,0);}else{if(f.value=="-1"|| 
f.value==""){processJ(c.indexInPage-0,0);}else{if((d=="3"||d=="5"||d=="7")){var 
g=f.value||$(f).attr("val");if(parseInt(g)==g){var 
b=$(f).attr("jumpto");if(!b){b=0;}var 
a=b-0;processJ(c.indexInPage-0,a);}}}}}function jumpAny(c,e,g){var f=$(e);var 
d=f.attr("type");var h=f.attr("hasjump");var a=f.attr("anyjump")-0;var 
b=f[0];if(h){if(c){processJ(b.indexInPage-0,a,g);}else{processJ(b.indexInPage-0, 
0,g);}}}function processJ(p,d,e){var a=p+1;var b=cur_page;var 
f=d==1||d==-1;for(var k=cur_page;k<pageHolder.length;k++){var 
m=pageHolder[k].questions;if(f){b=k;}for(var h=a;h<m.length;h++){var 
l=getTopic(m[h]);if(l==d||f){b=k;}if(l<d||f){m[h].style.display="none";}else{if( 
relationNotDisplayQ[l]){var g=1;}else{m[h].style.display="";}var 
c=$(m[h]).attr("hasjump");if(c&&!e){clearFieldValue(m[h]);}}}if(!pageHolder[k].c 
uts){pageHolder[k].cuts=$(".cutfield",pageHolder[k]);}for(var 
h=0;h<pageHolder[k].cuts.length;h++){var o=pageHolder[k].cuts[h];var 
l=o.getAttribute("qtopic");if(!l){continue;}if(l<=a){continue;}if(l<d||f){o.styl 
e.display="none";}else{var 
n=o.getAttribute("topic");if(relationNotDisplayQ[n]){var 
g=1;}else{o.style.display="";}}}a=0;}fixBottom();}function 
GetBacktoServer(){str=window.location.pathname;index=str.lastIndexOf("/");page=s 
tr.substr(index+1,str.length-index);data=readCookie("history");if(data!=null&&da 
ta.toLowerCase()!=page.toLowerCase()){window.location.href=window.location.href; 
}}function readCookie(h){for(var 
k=h+"=",j=document.cookie.split(";"),f=0;f<j.length;f++){var 
g=j[f];while(g.charAt(0)==" 
"){g=g.substring(1,g.length);}if(g.indexOf(k)==0){return 
g.substring(k.length,g.length);}}return null;}function 
removeError(){if(this.errorMessage){this.errorMessage.innerHTML="";this.removeEr 
ror=null;this.style.border="solid 2px 
#f7f7f7";if(this.errorControl){this.errorControl.style.background="white";this.e 
rrorControl=null;}}}function writeError(a,c,b){a=$(a)[0];a.style.border="solid 
2px 
#ff9900";if(a.errorMessage){a.errorMessage.innerHTML=c;}else{a.errorMessage=$(". 
errorMessage",$(a))[0];a.errorMessage.innerHTML=c;}a.removeError=removeError;if( 
a.errorControl){a.errorControl.style.background="#FBD5B5";}if(!firstError){first 
Error=a;}return false;}function verifydata(d,c){if(!c){return"";}var 
a=null;if(c.toLowerCase()=="email"||c.toLowerCase()=="msn"){a=/^[a-z0-9!#$%&'*+/ 
=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9] 
)?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/i;if(!a.exec(d)){return 
validate_email;}else{return"";}}else{if(c=="日期"||c=="生日"||c=="入学时间"){return"";}e 
lse{if(c=="固话"){a=/^((\d{4}-\d{7})|(\d{3,4}-\d{8}))(-\d{1,4})?$/;if(!a.exec(d)){ 
return 
validate_phone.replace("，请注意使用英文字符格式","");}else{return"";}}else{if(c=="手机"){a=/^ 
\d{11}$/;if(!a.exec(d)){return 
validate_mobile.replace("，请注意使用英文字符格式","");}else{return"";}}else{if(c=="密码"){ret 
urn 
checkPassword(d);}else{if(c=="电话"){a=/(^\d{11}$)|(^((\d{4}-\d{7})|(\d{3,4}-\d{8} 
))(-\d{1,4})?$)/;if(!a.exec(d)){return 
validate_mo_phone.replace("，请注意使用英文字符格式","");}else{return"";}}else{if(c=="汉字"){a 
=/^[\u4e00-\u9fa5]+$/;if(!a.exec(d)){return 
validate_chinese;}else{return"";}}else{if(c=="姓名"){a=/^[\u4e00-\u9fa5]{2,4}$/;if 
(!a.exec(d)){return"姓名必须为2到4个汉字";}else{return"";}}else{if(c=="英文"){a=/^[A-Za-z]+ 
$/;if(!a.exec(d)){return 
validate_english;}else{return"";}}else{if(c=="网址"||c=="公司网址"){a=/^http:\/\/[A-Za 
-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;if(!a.exec(d)){retur 
n 
validate_reticulation;}else{return"";}}else{if(c=="身份证号"){a=/^\d{15}(\d{2}[A-Za- 
z0-9])?$/;if(!a.exec(d)){return 
validate_idcardNum;}else{return"";}}else{if(c=="学号"){a=/^\d+$/;if(!a.exec(d)){re 
turn 
validate_num.replace("，请注意使用英文字符格式","");}}else{if(c=="数字"){a=/^(\-)?\d+$/;if(!a. 
exec(d)){return 
validate_num.replace("，请注意使用英文字符格式","");}}else{if(c=="小数"){a=/^(\-)?\d+(\.\d+)?$ 
/;if(!a.exec(d)){return 
validate_decnum;}}else{if(c.toLowerCase()=="qq"){a=/^\d+$/;var 
b=/^\w+([-+.]\w+)*@\w+([-.]\\w+)*\.\w+([-.]\w+)*$/;if(!a.exec(d)&&!b.exec(d)){re 
turn validate_qq;}else{return"";}}}}}}}}}}}}}}}}return"";}function 
checkPassword(d){var c=/([a-zA-Z0-9!@#$%^&*()_?<>{}]){6,20}/;var 
b=/[a-zA-Z]+/;var 
a=/[0-9]+/;if(c.test(d)&&b.test(d)&&a.test(d)){return"";}else{if(!c.test(d)){ret 
urn"密码长度在6-20位";}else{if(!b.test(d)){return"密码中必须包含字母";}else{if(!a.test(d)){retu 
rn"密码中必须包含数字";}}}}return"";}function 
verifyMinMax(e,d,c,a){if(d=="数字"||d=="小数"){var 
b=/^(\-)?\d+$/;if(d=="小数"){b=/^(\-)?\d+(\.\d+)?$/;}if(!b.exec(e)){if(d=="小数"){re 
turn validate_decnum;}else{return 
validate_num.replace("，请注意使用英文字符格式","");}}if(e!=0){e=e.replace(/^0+/,"");}if(c!= 
""){if(d=="数字"&&parseInt(e)-parseInt(c)<0){return 
validate_num2+c;}else{if(d=="小数"&&parseFloat(e)-parseFloat(c)<0){return 
validate_num2+c;}}}if(a!=""){if(d=="数字"&&parseInt(e)-parseInt(a)>0){return 
validate_num1+a;}else{if(d=="小数"&&parseFloat(e)-parseFloat(a)>0){return 
validate_num1+a;}}}}else{if(a!=""&&e.length-a>0){return 
validate_info_wd3.format(a,e.length);}if(c!=""&&e.length-c<0){return 
validate_info_wd4.format(c,e.length);}}return"";}function getTopic(a){return 
$(a).attr("topic");}function relationJoin(b){if(b.style.display!="none"){var 
c=$(b);var 
a=c.attr("type");if(a=="3"){if($("input:checked",c).length>0){displayRelationByT 
ype(c,"input[type=radio]",1);}}else{if(a=="4"){if($("input:checked",c).length>0) 
{displayRelationByType(c,"input[type=checkbox]",2);}}else{if(a=="7"){if($("selec 
t",c)[0].selectedIndex>0){displayRelationByType(c,"option",5);}}}}}}function 
displayRelationByType(e,d,c){var 
b=getTopic(e);if(!relationQs[b]){return;}e.hasDisplayByRelation=new Object();var 
a=-1;if(c==4){var 
f=$("a.rate-on",e);if(f[0]&&$(f[0]).attr("mode")){a=f.length-1;}}$(d,e).each(fun 
ction(h){var j=false;var 
k="";if(c==1||c==2||c==5){k=this.value;}else{if(c==3){k=$("input[type=hidden]",t 
his).val();}else{if(c==4){k=$(this).attr("val");}}}var 
l=b+","+k;if(c==3&&$(this).attr("check")){j=true;}else{if(c==4){if(a==-1&&$(this 
).hasClass("rate-on")){j=true;}else{if(h==a){j=true;}}}else{if((c==1||c==2)&&thi 
s.checked){j=true;}else{if(c==5&&this.selected){j=true;}}}}displayByRelation(e,l 
,j);var 
g=b+",-"+k;if(relationHT[g]){displayByRelationNotSelect(e,g,j);}});fixBottom();} 
function displayByRelation(c,f,b){var d=relationHT[f];if(!d){return;}for(var 
a=0;a<d.length;a++){var 
e=getTopic(d[a]);if(c.hasDisplayByRelation[e]){continue;}if(!b&&d[a].style.displ 
ay!="none"){loopHideRelation(d[a]);}else{if(b){d[a].style.display="";if(d[a].get 
Attribute("isshop")=="1"){updateCart(d[a]);}initqSlider(d[a]);c.hasDisplayByRela 
tion[e]="1";if(relationNotDisplayQ[e]){relationNotDisplayQ[e]="";}}}}}function 
displayByRelationNotSelect(c,f,b){var d=relationHT[f];if(!d){return;}for(var 
a=0;a<d.length;a++){var 
e=getTopic(d[a]);if(c.hasDisplayByRelation[e]){continue;}if(b&&d[a].style.displa 
y!="none"){loopHideRelation(d[a]);}else{if(!b){d[a].style.display="";initqSlider 
(d[a]);c.hasDisplayByRelation[e]="1";if(relationNotDisplayQ[e]){relationNotDispl 
ayQ[e]="";}}}}}function loopHideRelation(a){var c=getTopic(a);var 
b=relationQs[c];if(b){for(var 
e=0;e<b.length;e++){loopHideRelation(b[e],false);}}clearFieldValue(a);var 
d=$(a)[0];d.style.display="none";if(d.getAttribute("isshop")=="1"){updateCart(d) 
;}if(relationNotDisplayQ[c]==""){relationNotDisplayQ[c]="1";}}function 
checkHuChi(c,e){var b=$(".huchi",c)[0];if(!b){return;}var 
f=$(e);if(!$("input:checked",f)[0]){return;}var a=$(".ui-checkbox",c);var 
d=f.hasClass("huchi");a.each(function(){if(this==e){return true;}var 
g=$(this);if(!$("input:checked",g)[0]){return 
true;}if(d){g.trigger("click");}else{var 
h=g.hasClass("huchi");if(h){g.trigger("click");}}});}function 
autoSubmit(c){if(hasSurveyTime){while(cur_page<totalPage-1){pageHolder[cur_page] 
.hasExceedTime=true;show_next_page();}}divMaxTime.style.display="none";$("body") 
.css("padding-top","0px");pageHolder[cur_page].hasExceedTime=true;var 
b=$("#divNext a")[0];if(b){b.disabled=false;}if(cur_page<totalPage-1){show_next_page();}else{p 
ageHolder[cur_page].style.display="none";if(b&&b.initVal){b.innerHTML=b.initVal; 
}if(hasSurveyTime&&tCode.style.display=="none"&&window.hasAnswer&&!c){groupAnswe 
r(1);}else{var a="提示：您的作答时间已经超过最长时间限制，请直接提交答卷！";if(langVer==1){a="Time is 
up,please submit!";}if(c){a=c;}$(".ValError").html(a);}}}$(function(){function 
g(){document.oncontextmenu=document.ondragstart=document.onselectstart=function( 
){return false;};var l=document.getElementsByTagName("input");var 
n=document.getElementsByTagName("textarea");for(var 
m=0;m<l.length;m++){l[m].onpaste=function(){return false;};}for(var 
m=0;m<n.length;m++){n[m].onpaste=function(){return false;};}}function 
e(){if(!window.localStorage){return;}localStorage.setItem("wjxlastanswer"+activi 
tyId,new Date().getTime());}function 
d(){hasSurveyTime=true;hasMaxtime=true;autoSubmit("由于您超过"+maxOpTime+"秒没有任何操作，系统为 
防止作弊不允许再作答！");}if(window.isKaoShi){g();if(window.maxOpTime){var 
c=false;if(window.localStorage){var 
b=localStorage["wjxlastanswer"+activityId];if(b){var k=new Date().getTime();var 
f=(k-b)/(60*1000);if(f<10){c=true;d();$("#divSubmit").hide();}}}if(!c){document. 
onclick=document.onkeyup=document.onmousemove=document.onscroll=function(l){h=ne 
w Date();};var a=null;var h=new Date();var j=setInterval(function(){var n=new 
Date();var l=parseInt((n-h)/1000);var 
m=maxOpTime-l;if(m<=0){clearInterval(j);e();d();}},1000);}}}});