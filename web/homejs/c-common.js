//忘记密码的全局变量
var from_forget_psw = 0;
var four_zero_zero = four_zero_zero;
//专家点评全局变量
zhuanjia = '';
$(document).ready(function(){
    var footerHeight = $(".footer").height();
    $(".center").css("padding-bottom",footerHeight); 
    //tab切换
    var $div_li = $("div.tab-tit ul li");
    $div_li.hover(function () {
        $(this).addClass("selected")            //当前<li>元素高亮
            .siblings().removeClass("selected");  //去掉其他同辈<li>元素的高亮
        var index = $div_li.index(this);  // 获取当前点击的<li>元素 在 全部li元素中的索引。
        $("div.tab-con > .nrpart")      //选取子节点。不选取子节点的话，会引起错误。如果里面还有div
            .eq(index).show()   //显示 <li>元素对应的<div>元素
            .siblings(".nrpart").hide(); //隐藏其他几个同辈的<div>元素
        footerHeight = $(".footer").height();
        $(".center").css("padding-bottom",footerHeight);
    });

    var tab = $(".tab");
    tab.each(function () {
        var _item = $(this);
        var $div_li = _item.children(".tab-t").find("li");
        var $div_con = _item.children(".tab-c");
        var firstLiCls = $div_li.eq(0);
        $div_li.each(function () {
            if ($(this).hasClass("on")) {
                var index = $div_li.index(this);
                $div_con.find(".nrpart")
                    .eq(index)
                    .show()
                    .siblings(".nrpart")
                    .hide();
                    footerHeight = $(".footer").height();
                    $(".center").css("padding-bottom",footerHeight);
                $div_li.hover(function () {
                    $(this).addClass("on")
                        .siblings("li").removeClass("on");
                    index = $div_li.index(this);
                    $div_con.find(".nrpart")
                        .eq(index)
                        .show()
                        .siblings(".nrpart")
                        .hide();
                        footerHeight = $(".footer").height();
                        $(".center").css("padding-bottom",footerHeight);
                });
            }else if($(this).hasClass("t-sel")){
                var index = $div_li.index(this);
                $div_con.find(".nrpart")
                    .eq(index)
                    .show()
                    .siblings(".nrpart")
                    .hide();
                $div_li.click(function(){
                    $(this).addClass("t-sel")
                        .siblings("li").removeClass("t-sel");
                    index = $div_li.index(this);
                    $div_con.find(".nrpart")
                        .eq(index)
                        .show()
                        .siblings(".nrpart")
                        .hide();
                });

            }
        });
    });
});

function setCookie(name, value, tm){//设置cookie
    if(tm == null || tm < 59) tm = 60;
    var exp  = new Date();
    exp.setTime(exp.getTime() + tm*1000);
    document.cookie = name + "="+ escape (value) + ";path=/;expires=" + exp.toGMTString();
}
function getCookie(name)//取cookies函数
{
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
    if(arr != null) return unescape(arr[2]); return null;
}
function delCookie(name)//删除cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}



//项目详情页，搜索周边专用的获取URL中的值
function getDetailUrlParam() {
    var url = window.location.href;
    if(url != ''){
        var url_arr = url.split('/');
        if(url_arr != ''){
            var param = url_arr[url_arr.length - 1];
            if(param.indexOf('#')){
                var param_arr = param.split('#');
                param = param_arr[0];
            }
            return param;
        }
    }
    return;
}

Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),    //day
        "h+": this.getHours(),   //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
    (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(format))
        format = format.replace(RegExp.$1,
        RegExp.$1.length == 1 ? o[k] :
        ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

/**
 * popup 公用的弹窗函数
 * 
 * params
 *  html ：弹窗的内容
 *  type ：弹窗内容类型，暂定两种，1和2
 *              1：简单的文字提示信息
 *                      通过：tip_temp_start和tip_temp_end两个全局变量制定内容样式
 *              2：为DOM元素的内容，
 *                      html为全部的DOM内容，包括样式
 *  func ： 回调函数，作为弹窗内部调用
 *  data ：当做参数传递给回调函数
 */
function popup2(html, type, func, data, btnval) {
    var html_real_start = '';
    var para = '';
    if(data[1] != '' && data[1] != null){
        para = '&passOne='+data[1]+'&clickSource='+data[2];
    }
    var url = apply_popup_url+'/?id='+data[0]+para+'&btnvar='+btnval;
    // var url = apply_popup_url+'/?id='+data[0]+para;

    var area = ['670px','485px'];
    popLayer(2,url,area);
}


/**
 *  公用的预约报名函数
 * 
 * params：这些参数（除回调函数）主要是为没有登录的用户准备的，直接传递给通用的弹窗函数
 *  html ：弹窗的内容
 *                      html为全部的姓名和手机号的内容，包括样式
 *  func ： 回调函数，作为html内部的事件的调用。默认是see_house_ajax
 *  data ：当做参数传递给回调函数。默认是楼盘的ID
 *  btnval: 按钮上的文字，默认是：预约看房
 */

function popup_see_house(html, func, data, btnval) {
    var userid = $('#userid').html();//不是真实ID仅仅是判别，验证是否已经登录
    if($('.ga_btn_success').data('content') != '' && $('.ga_btn_success').data('content') != null)
    {
        googleAnalytics($('.ga_btn_success').data('content'));
    }
    if (userid == '1') {

        if (typeof (func) == 'function') {
            //func(data);
            //二期更改的统一的弹窗
            popup2(html, '2', func, data, btnval);

        }
    } else if (userid == '0') {
        popup2(html, '2', func, data, btnval);//如果没有登录，弹窗类型为2
    }

}
//ie8下placehold
function popup_apply_tip() {
    $.Custom.prompttext($('#teambuy_name'), '请输入姓名', 'rgb(123,123,123)');
    $.Custom.prompttext($('#teambuy_mobile'), '请输入手机号', 'rgb(123,123,123)');
}

//异步提交预约报名
function see_house_ajax(data) {
    //popup_apply_tip();
    var name;
    var mobile;
    var type = 2;
    var url = $('#user_see_create_url').val();
    var userid = $('#userid').html();//不是真实ID仅仅是判别
    var capture = data[3];
    if(capture != '' && capture != null)
    {
        googleAnalytics(capture);
    }
    if (userid == '1') {
        type = 1;
        $.ajax({
            type: 'POST',
            url: url,
            data: {
                user_id: userid,
                user_real_name: name,
                user_mobile: mobile,
                project_id: data[0],
                //project_name: data[1],
                type: type,
                status: 1
            },
            beforeSend: function () {
                $(this).attr('disabled', 'disabled');
            },
            success: function (rsp) {

                if (rsp == '1') {
                    alert('您已成功参团。请耐心等待砍价师与您联系，给您最棒体验的砍价服务！');
                } else if ( rsp == '21' ) {
                    msg_tip('您已参加此楼盘的组团砍价，请在个人中心“看房足迹”里查看');
                }  else if ( rsp == '22' ) {
                    alert('您已参加此楼盘的组团砍价，请耐心等待砍价师与您联系。或直接拨打'+four_zero_zero+'，获取最低折扣！');
                }
            },
            complete: function () {
                $(this).removeAttr('disabled');
            }
        });
    } else {
        $.getJSON(user_apply_no);
        $('.see_house').click(function () {
            $('.error_see_house_name').addClass('none');
            $('.error_see_house_mobile').addClass('none');
            if (userid == '0') {
                name = $(this).parent().parent().find('.teambuy_name').val();
                mobile = $(this).parent().parent().find('.teambuy_mobile').val();
            }
            if ((userid == '0') && name == "") {
                $('.error_see_house_name').removeClass('none');
                return false;
            }
            if ((userid == '0') && mobile == "") {
                $('.error_see_house_mobile').removeClass('none');
                return false;
            }
            if ( !checkTel(mobile) ) {
               $('.error_see_house_mobile').removeClass('none');
                return false;
            }
            $.ajax({
                type: 'POST',
                url: url,
                data: {
                    user_id: userid,
                    user_real_name: name,
                    user_mobile: mobile,
                    project_id: data[0],
                   // project_name: data[1],
                    type: type,
                    status: 1
                },
                beforeSend: function () {
                    $(this).attr('disabled', 'disabled');
                },
                success: function (rsp) {
                    if (rsp == '1') {
                    alert('您已成功参团。请耐心等待砍价师与您联系，给您最棒体验的砍价服务！');
                    //alert(rsp);
                    } else if ( rsp == '21' ) {
                        alert('您已参加此楼盘的组团砍价，请在个人中心“看房足迹”里查看');
                    }  else if ( rsp == '22' ) {
                    alert('您已参加此楼盘的组团砍价，请耐心等待砍价师与您联系。或直接拨打400-080-6715，获取最低折扣！');
                    }
                },
                complete: function () {
                    $(this).removeAttr('disabled');
                }
            });
        });
    }
}

//关注价格变动点击事件
$('.btnChangePrice').click(function () {
    if($('.ga_btn_success').data('content') != '' && $('.ga_btn_success').data('content') != null)
    {
        googleAnalytics($('.ga_btn_success').data('content'));
    }
    var _item = $(this);
    var _itemValue = _item.text();
    var capture = $(this).data('capture');
    addDisabled(_item);
    //真正的提交
    var phone =$('#attentionPhone').val();
    if( !checkTel( phone ) ){
        var area = ['660px','460px'];
        popLayer(1,freeCallFail,area);
        removeDisabled(_item,_itemValue);
    }else{
        var project_id = $('#global_project_id').val();
        var project_name =$('#global_project_name').val();
        $.ajax({
            type: "POST",
            url: attention_price_url,
            data: {
                phone: phone,
                project_id: project_id,
                project_name: project_name
            },
            beforeSend: function () {
                //$('#mobile_captcha').attr('disabled', 'disabled');
            },
            success: function (rs) {
                var area = ['660px','460px'];
                popLayer(1,freeCallSuccess,area);
                if(capture != '' && capture != null)
                {
                    googleAnalytics(capture);
                }
            },
            error: function (error) {

            },
            complete: function () {
            }
        });
    }

});

function free2_call_check_mobile_inner_html(mobile) {
        if (!checkTel(mobile)) 
        {

            $('.tsk-tips').html('您填写的手机号码不正确，请您核对后重新输入！');
            return false;
        }
        return true;
}

function free2_call_check_mobile_layer(mobile, freeCallFail) {
        if (!checkTel(mobile)) 
        {
            var area = ['660px','460px'];
            popLayer(1,freeCallFail,area);
            return false;
        }
        return true;
}

function free2_call_ajax_submit(mobile, clickSource, csrf, freeCallSuccess,layerOrNot, is_qudao,capture) {
    $.ajax({
            type: 'POST',
            url: free_call,
            data: {
                mobile: mobile,
                clickSource:clickSource,
                _csrf: csrf
            },
            beforeSend: function () {
            },
            success: function (rsp) {
                if(layerOrNot == 1 ){
                    var area = ['660px','460px'];
                    popLayer(1,freeCallSuccess,area);
                }else{
                    $('.tsk-tips').html(rsp);
                }
                if(capture != '' && capture != null)
                {
                    googleAnalytics(capture);
                }
            },
            complete: function () {
            }
        });
}

    //免费通话的事件响应，通用的一个类 class = 'make_call_for_free2'
    $(document).on('click','.make_call_for_free2',function () {
            if($(this).data('content') != '' && $(this).data('content') != null)
            {
                googleAnalytics($(this).data('content'));
            }
            var _item = $(this);
            if ( _item.attr('disabled') != undefined) {
                return false;
            } else  {
                addDisabled(_item);
            }
            var capture = $(this).data('capture');
            var csrf = $('[name=csrf-token]').attr('content');
            var mobile = $(this).siblings('input').val();
            var clickSource =$(this).attr('clickSource');
            var layerOrNot = 1;//是否弹层展示 1为是，2为否
            if(!free2_call_check_mobile_layer(mobile, freeCallFail))
            {
                removeDisabled(_item);
                return false;
            }
            free2_call_ajax_submit(mobile, clickSource, csrf, freeCallSuccess,layerOrNot,'',capture);
    });

    //免费通话的事件响应：class = 'button_free_call_comment' 带点评内容的弹出层
    $(document).on('click','.button_free_call_comment',function () {
        var freeCallTopHtml = '<div class=\"layer-changePrice\"><div class="changePriceHd"><div class="tipTitle"></div><div class=\"layer-closebt\"><img class="sign-closebt" src='+base_image_url+'/images/ico-all-close.png /></div></div>';
        var freeCallBottomHtml = '<div class="layerDesc">';
        freeCallBottomHtml +='<span>居理新房郑重承诺：</span>';
        freeCallBottomHtml +='<span>1，居理新房部分楼盘开展活动，会在认购时用服务费抵扣房款。</span>';
        freeCallBottomHtml +='<span>2，充分尊重用户意愿，提供一对一温馨服务，免受传统中介骚扰之苦。</span>';
        freeCallBottomHtml +='<span>3，保障用户信息安全，多重防护措施严格保护用户信息。</span>';
        freeCallBottomHtml +='</div>';
        freeCallBottomHtml +='</div>';

        var freeCallFail = freeCallTopHtml+ '<div class="change-price-warp"><div class="changePriceTipFail changePriceTip">您填写的<span>手机号码不正确</span><br>请您核对后重新输入</div><button class="btn-change-price failKnow">我 知 道 了</button></div>'+ freeCallBottomHtml;
        var freeCallSuccess = freeCallTopHtml+ '<div class="change-price-warp"><div class="changePriceTipSuccess changePriceTip"><span>报名成功</span><br>咨询师将用'+zero_one_zero_free_call_succ+'号码联系您，<br>免费专车带您看房！</div><button class="btn-change-price successGo">继 续 选 房</button></div>'+ freeCallBottomHtml;

        var _item = $(this);
        var csrf = $('[name=csrf-token]').attr('content');
        var mobile = '';
        if($('#book-house-tel-layer').val() != ''&& $('#book-house-tel-layer').val() != undefined){
            mobile = $('#book-house-tel-layer').val();
        }else if($('#book-house-tel').val() != ''||$('#book-house-tel').val() != undefined){
            mobile = $('#book-house-tel').val();
        }
        var clickSource =$(this).attr('clickSource');

        var layerOrNot = 2;//是否弹层展示 1为是，2为否
        $('.tsk-tips').html("");
        if(!free2_call_check_mobile_inner_html(mobile))
        {
            return false;
        }else{
            _item.addClass('disabled').attr('disabled','disabled');
            free2_call_ajax_submit(mobile, clickSource, csrf, freeCallSuccess,layerOrNot);
        }
    });

//button按钮提交后禁用
function addDisabled(obj){
    obj.attr({
        "disabled":"disabled"
    });
    // obj.text("提交中");
    obj.addClass("disabled");
}

//移除button按钮提交后禁用事件
function removeDisabled(obj){
    obj.removeClass("disabled");
    obj.removeAttr("disabled");
}

//a链接提交后禁用
function linkDisabled(obj){
    var _itemAttr = obj.get(0).attributes;
    if ( typeof _itemAttr['disabled'] != 'undefined') {
        return false;
    } else  {
        obj.attr('disabled', 'disabled');
        obj.text("提交中");
        obj.addClass("disabled");
    }
}

//google analytics 统计
// ga_action 字符串[目标,动作,标签]
function googleAnalytics(ga_action)
{
        var action = ga_action.split(',');
        _gaq.push(['_trackEvent',action[0],action[1],action[2]]);
}


//移除a链接提交后禁用事件
function removeLinkDisabled(obj,value){
    obj.removeAttr("disabled");
    obj.removeClass("disabled");
    obj.text(value);
}

//移除a链接提交后禁用事件
function subBtnTextReturn(obj,value){
    obj.text(value);
}


//首页居理新房服务四步点击填写手机 html
var layderDesc = '<span>居理新房郑重承诺：</span>';
    layderDesc += '<span>1，居理新房部分楼盘开展活动，会在认购时用服务费抵扣房款。</span>';
    layderDesc += '<span>2，充分尊重用户意愿，提供一对一温馨服务，免受传统中介骚扰之苦。</span>';
    layderDesc += '<span>3，保障用户信息安全，多重防护措施严格保护用户信息。</span>';
    $('.free_call_layer').click(function () {

        if($(this).data('content') != '' && $(this).data('content') != null)
        {
            googleAnalytics($(this).data('content'));
        }
        //ajax 记录点击的按钮的事件日志
        $.ajax({
            type: 'GET',
            url: common_click,
            success: function (rsp) {

            }
        });
        $('.xubox_shade').remove();//补丁
        $('.xubox_layer').remove();

        if($(this).hasClass('layerSelect')){
            var clickSource = 'clickSource_indexSelect';
            var layerClass = 'bgLayerSelect';
            var layerHdInfo = '<p>帮您选</p>';
                layerHdInfo += '<span>与纷繁复杂的数据、指标说拜拜。</span>';
                layerHdInfo += '<span>咨询师直接回电与您详细沟通购房需求，';
                layerHdInfo += '综合各方面因素为您推荐最佳备选楼盘。</span>';
        }else if($(this).hasClass('layerLook')){
            var clickSource = 'clickSource_indexLook';
            var layerClass = 'bgLayerLook';
            var layerHdInfo = '<p>带您看</p>';
                layerHdInfo += '<span>告别公交、地铁，告别瞎转乱看。</span>';
                layerHdInfo += '<span>咨询师与您电话确认带看时间行程，全程陪同坐专车看房，看得更全面，更仔细，更舒服。</span>';
        }else if($(this).hasClass('layerSpeak')){
            var clickSource = 'clickSource_indexSpeak';
            var layerClass = 'bgLayerSpeak';
            var layerHdInfo = '<p>给您讲</p>';
                layerHdInfo += '<span>听腻了开发商天花乱坠的营销套话。</span>';
                layerHdInfo += '<span>居理新房咨询师会站在第三方的角度，';
                layerHdInfo += '对楼盘户型的优缺点进行专业客观的点评，保证买的放心、用的舒心。</span>';
        }else if($(this).hasClass('layerBuy')){
            var clickSource = 'clickSource_indexBuy';
            var layerClass = 'bgLayerBuy';
            var layerHdInfo = '<p>陪您买</p>';
                layerHdInfo += '<span>居理新房密切关注楼盘价格走势，多渠道获取市场真实成交价格。</span>';
                layerHdInfo += '<span>视保障用户利益不受损害为我们的责任，';
                layerHdInfo += '以帮助用户买到称心如意的房产为我们的使命。</span>';
                layerHdInfo += '以帮助用户买到称心如意的房产为我们的使命。</span>';
        }else if($(this).hasClass('layerHeader')){
            var clickSource = 'clickSource_header';
            var layerClass = 'bgLayerHeader';
            var layerHdInfo = '';
                layerHdInfo +='<span class="proListHead">看房一定要听专业的分析！</span>';
                layerHdInfo +='<span class="proListHead">真实数据的楼盘分析，我们不止有底价。</span>';
                layerHdInfo += '<div class="freeCallPhoneStatic">预约电话：'+four_zero_zero+'</div>';
        }else if($(this).hasClass('layerHeaderHelp_qp')){
            var clickSource = 'pc_qingpu_view_help';
            var layerClass = 'bgLayerHeader';
            var layerHdInfo = '';
            layerHdInfo +='<span class="proListHead">看房一定要听专业的分析！</span>';
            layerHdInfo +='<span class="proListHead">真实数据的楼盘分析，我们不止有底价。</span>';
        }
        var freeCallTopHtml = '<div clickSource = \"'+ clickSource +'\" class=\"layer-changePrice freeCallLayer '+layerClass+'\"><div class="freeCallHd"></div>';
        var freeCallBottomHtml = '</div>';

        var freeCallHtml = freeCallTopHtml+ '<div class="change-price-warp freeCallBd"><div class="freeCallInfo"><div class="layerHdInfo">'+layerHdInfo+'</div><div class="mobileInput"><input type="text" value="请输入您的手机号，咨询师将在一小时内联系您" class="freeCallPhone"/><button class=" freeCallGo freeCallBtn" data-content="pc_success_yemian,tanchuliudian,124">立即预约</button><button class=" freeCallClose freeCallBtn">继续浏览</button><div class="clear"></div></div><div class="tipPhone"><div class="freeCallTip"></div><div class="clear"></div></div><div class="freeCallSuccessTip"></div></div><div class="layerDesc">'+layderDesc+'</div></div>'+ freeCallBottomHtml;
        //if($(this).hasClass('layerHeader'))
        //{
        //    freeCallHtml = input_temp;
        //}

        //设置弹层尺寸
        var area = ['660px','460px'];
        popLayer(1,freeCallHtml,area);
        $('.freeCallPhone').focus(function(){
            $('.freeCallTip').html('');
        });
        $('.freeCallGo').click(function () {
            if($(this).data('content') != '' && $(this).data('content') != null)
            {
                googleAnalytics($(this).data('content'));
            }
            var phone =$('.freeCallPhone').val();
            var csrf = $('[name=csrf-token]').attr('content');
            var _itemGo = $(this);
            var _itemGoValue = _itemGo.text();
            addDisabled(_itemGo);
            if( !checkTel( phone ) ){

                $('.freeCallTip').html('您填写的手机号码不正确，请您核对后再输入');
                removeDisabled(_itemGo);
            }else{
                var successTip = '预约成功，<br>咨询师将用'+zero_one_zero_free_call_succ+'号码联系您，<br>免费专车带您看房！';
                $.ajax({
                    type: 'POST',
                    url: free_call,
                    data: {
                        clickSource: clickSource,
                        mobile: phone,
                        _csrf: csrf
                    },
                    beforeSend: function () {
                    },
                    success: function (rsp) {
                        //alert(rsp);
                        $('.freeCallPhone').hide(0);
                        $('.freeCallPhoneStatic').hide(0);
                        $('.freeCallGo').hide(0);
                        $('.freeCallClose').show(0);
                        $('.layerHdInfo').html('<span>'+successTip+'</span>').css({'text-align':'center','padding-top':'60px','height':'100px'});
                        $('.freeCallBtn').css({'border-radius':'3px','margin':'0 179px','width':'142px'});
                        $('.freeCallClose').click(function(){
                            $(".layui-layer-shade").remove();
                            $(".layui-layer").remove();
                            $('.xubox_shade').remove();
                            $('.xubox_layer').remove();
                            return false;
                        });
                    },
                    complete: function () {
                        removeDisabled(_itemGo);
                    }
                });
            }
        });
    });



    //搜索页的搜索域名:
    var s_url = project_search_url;
    $("#keywords_submit").click(function () {
        var keywords = $("#keywords").val();
        s_url = s_url.replace(/need_replace_keywords/,keywords);
        location.href = s_url;
    });


    $("#keywords_submit_layer").click(function () {
            var keywords = $("#keywords_layer").val();
            s_url = s_url.replace(/need_replace_keywords/,keywords);
            location.href = s_url;
    });
    function keyEnter(e) {
        e = e || event;
        if(e.keyCode == 13) {
            if(document.activeElement.id=='keywords' || document.activeElement.id=='keywords_submit'){
                var keywords = $("#keywords").val();
                s_url = s_url.replace(/need_replace_keywords/,keywords);
                location.href = s_url;
            }
            else if(document.activeElement.id=='keywords_layer'){
                var keywords = $("#keywords_layer").val();
                s_url = s_url.replace(/need_replace_keywords/,keywords);
                location.href = s_url;
            }
            else if (document.activeElement.id=='login_name' ||
                        document.activeElement.id=='login_psw' ||
                        document.activeElement.id=='signupform-mobile' ||
                        document.activeElement.id=='signupform-mobile_captcha' ||
                        document.activeElement.id=='signupform-password' ||
                        document.activeElement.id=='signupform-password2' ||
                        document.activeElement.id=='teambuy_name' ||
                        document.activeElement.id=='teambuy_mobile'){
                            $('.common-btn2').trigger('click');
                        }
        }
    }
    document.onkeydown = keyEnter;
   
    //其他城市弹层
    var isCity = true;
    // var city_html = '<div class="city-tip-show">其他城市将陆续开放!</div>';
    $('.city-tip').mouseover(function () {        
        $(this).css('cursor', 'pointer');
        if(isCity){
            // $(this).append(city_html);
            $(this).children(".city-change-list").show();
        }
        isCity = false;
    }).mouseleave(function () {
        // $(this).children('.city-tip-show').remove();
        $(this).children(".city-change-list").hide();
        isCity = true;
    });

//定义按钮对象
$.Custom = {
    obj: window.object,

    /*鼠标悬浮改变属性,离开变回原属性,仅作用于本身
    obj->悬浮对象
    attrover->新属性
    attrleave->原属性 */
    mouseoverevent: function (obj, attrover, attrleave) {
        obj.mouseover(function () {
            $(this).css('cursor', 'pointer');
                $(this).attr(attrover);
        }).mouseleave(function () {
                $(this).attr(attrleave);
        });
    },
    /*鼠标悬浮控制其他元素显隐
   obj->悬浮对象
   attrover->新属性
   attrleave->原属性 */
    mouseovershowevent: function (obj, changeobj, time) {
        obj.mouseover(function () {
            $(this).css('cursor', 'pointer');
            changeobj.show(time);

        }).mouseleave(function () {
            changeobj.hide(time);

        });
    },
    /*文本框默认提示文字
    html5提供placeholder实现此效果，如对低版本浏览器兼容性无要求可使用html5属性
    obj->对象
    text->提示文字
    color->提示文字色*/
    prompttext: function (obj, text, color) {
        obj.css('color', color);
        obj.val(text);
        obj.focus(function () {
            obj.val('');
            obj.css('color', 'initial');
        }).blur(function () {
            if (obj.val() == '') {
                obj.css('color', color);
                obj.val(text);
            }
        });
    },
    /*点击导航切换div显隐
    obj->点击对象
    focusclass->选中焦点样式类
    changeclassobj->选中焦点对象
    toggleobj->显隐对象
    callback->回调函数
    */
    clickchangetap: function (obj, focusclass, changeclassobj, toggleobj, time, callback) {
        obj.click(function () {
            var indexNum = obj.index(this);
            changeclassobj.eq(indexNum).addClass(focusclass).siblings().removeClass(focusclass);
            toggleobj.eq(indexNum).show(time, function () {
                if (callback != undefined) {
                    callback();
                }
            }).siblings().hide();
        });

    }
};


//goHome函数
function goHome(){
    window.location.href = site_user_home;
}
//刷新页面
function reload(){
    window.location.reload();
}

//手机号码的校验
function checkTel(value) {
    var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
    var isMob = /^((\+?86)|(\(\+86\)))?(13[0123456789][0-9]{8}|15[012356789][0-9]{8}|1[78][0123456789][0-9]{8}|14[57][0-9]{8}|1349[0-9]{7})$/;
    if (isMob.test(value) || isPhone.test(value)) {
        return true;
    } else {
        return false;
    }
}

//动态弹出层输入框获取焦点提示文字清空，针对IE8及更低版本浏览器
$(document).on("focus","input[type='text']",function(){
    var $val = $(this).val();
    if(checkTel($val)){
        return false;
    }else if($val == this.defaultValue){
        $(this).val("");
    }
});
//动态弹出层输入框失去焦点展示默认提示文字，针对IE8及更低版本浏览器
$(document).on("blur","input[type='text']",function(){
    var $val = $(this).val();
    if($val == ""){
        $(this).val(this.defaultValue);
    }
});

$(document).on("focus","input[type='password']",function(){
    var $val = $(this).data('placeholder');
    if($val != ''){
        $(this).attr('placeholder','');
    }
});
$(document).on("blur","input[type='password']",function(){
    var $val = $(this).data('placeholder');
    if($val != ""){
        $(this).attr('placeholder',$val);
    }
});

 $(function(){
    //footer 微信单击
    $(".ser-wx").click(function(e){
        var tsk_qrcode2 = $(".tsk-qrcode2");
        if(tsk_qrcode2.is(":visible")){
            tsk_qrcode2.hide();
        }else if(tsk_qrcode2.is(":hidden")){
            tsk_qrcode2.show();
        }
        e.stopPropagation();
    });
    
    //获取增值服务流程最后一条右间距设置为0
    $(".list-service li:last").css("margin-right","0");
    
    //页面滚动后header悬浮
    if($(".page-menu").length == 0 && $(".header-outer").length == 0){
        $(window).scroll(function(){
            var height = $(document).scrollTop();
            var headerHeight = $(".header").height();
            if(height > headerHeight){
                $('.header2').fadeIn('slow',function(){
                    $(this).css('display','block');
                });
            }else{
                $('.header2').fadeOut('slow',function(){
                    $(this).css('display','none');
                });
            }
        });
    }

    //划过楼盘显示的放大渐变效果
    $(".media4-layer a").hover(function(){
        $(this).parents(".media4-layer").siblings(".media4-pic").children("a").children("img").css({
            "-webkit-transform": "scale(1.05)",
            "-moz-transform": "scale(1.05)",
            "-ms-transform": "scale(1.05)",
            "-o-transform": "scale(1.05)",
            "transform": "scale(1.05)"
        });
    },function(){
        $(this).parents(".media4-layer").siblings(".media4-pic").children("a").children("img").css({
            "-webkit-transform": "scale(1)",
            "-moz-transform": "scale(1)",
            "-ms-transform": "scale(1)",
            "-o-transform": "scale(1)",
            "transform": "scale(1)"
        });
    });
 })

$('.closeQuestion').click(function(){
    $('#questionnaire').remove();
});

//首页底部成交记录+成交记录页面
$('.commentItem.act').hover(function(){
    changeCommentItemBg($(this));
},function(){
    $(this).parent().children('.commentItem.act').removeClass('hover');
    //obj.addClass('hover');
});
$('.commentItem.act').click(function(){
    $('.commentDesc .commentInfo').css({'height':'145px'});
    $('.order_comment_info .commentDesc').css({'height':'200px'});
    changeCommentItem($(this));
});
$('.commentDesc .lookAllComment').click(function(){
    toggleCurComment($(this));
});


function toggleCurComment(obj){
    if(obj.hasClass('curOpen')){
        obj.removeClass('curOpen');
        obj.html('阅读全文');
        var cc = $('.commentItem.curComment').children('.commentCon').html();
        cc = cc.replace(/(^\s*)|(\s*$)/g, "");
        if(cc.length > 325){
            cc = cc.substring(0,325)+'...';
        }
        $('.commentDesc .commentInfo').css({'height':'145px'}).html(cc);
        $('.order_comment_info .commentDesc').css({'height':'200px'});
    }else{
        obj.addClass('curOpen');
        obj.html('收起');
        var cc = $('.commentItem.curComment').children('.commentCon').html();
        cc = cc.replace(/(^\s*)|(\s*$)/g, "");
        $('.commentDesc .commentInfo').css({'height':'auto'}).html(cc);
        $('.order_comment_info .commentDesc').css({'height':'auto'});
    }
}

function codeToDate(uData){
    var myDate = new Date(uData*1000);
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    var day = myDate.getDate();
    return year + '/' + month + '/' + day;
}

function changeCommentItem(obj){
    obj.siblings().removeClass('curComment');
    obj.addClass('curComment');
    $('.commentDesc .lookAllComment').removeClass('curOpen').html('阅读全文');
    var proName = obj.children('.commentBaseInfo').children('.proName').html();
    var proId = obj.children('.commentBaseInfo').children('.proName').attr('id');
    var tradeTime = obj.children('.commentBaseInfo').children('.tradeTime').html();
    var userName = obj.children('.commentBaseInfo').children('.userName').html();
    var commentCon = obj.children('.commentCon').html();
    var commentHeader = obj.children('.service-header').html();
    var originPic = obj.children('.listPic').children('.originPic').attr('src');
    var proLink = '/project/'+proId+'.html';

    commentCon = commentCon.replace(/(^\s*)|(\s*$)/g, "");

    if(commentCon.length > 325){
        commentCon = commentCon.substring(0,325)+'...';
        $('.commentDesc .lookAllComment').show(0).html('阅读全文');
    }else{
        $('.commentDesc .lookAllComment').hide(0);
    }
    $('.order_comment_info').children('.commentImg').children('img').attr('src',originPic);
    $('.order_comment_info').children('.commentDesc').children('.commentTitle').children('.proName').children('a').html(proName).attr('href',proLink);
    $('.order_comment_info').children('.commentDesc').children('.commentTitle').children('.tradeTime').html(tradeTime);
    $('.order_comment_info').children('.commentDesc').children('.commentTitle').children('.userName').html(userName);
    $('.order_comment_info').children('.commentDesc').children('.commentInfo').html(commentCon);
    if(commentHeader.length > 100){
        $('.order_comment_info').children('.commentDesc').children('.comment-server').children('.serv-cons').show().children('.service-list').html(commentHeader);
    }else{
        $('.order_comment_info').children('.commentDesc').children('.comment-server').children('.serv-cons').hide();
    }
    setEmotion();
}

function changeCommentItemBg(obj){
    obj.siblings().removeClass('hover');
    obj.addClass('hover');
}

//问卷调查弹窗
// $(function(){
//     if(getCookie('survey') == null){
//         var myDate = new Date();
//         var curTime = myDate.getTime();
//         if(getCookie('lifeTime') == null){
//             setCookie("lifeTime",curTime,"600");
//         }
//         setTimeout(checkHasCookie,1000);
//     }
// });


function checkHasCookie(){
    var cookieGlobalTime = getCookie('lifeTime');
    var curNewDate = new Date();
    var curTimeCode = curNewDate.getTime();
    if(curTimeCode - cookieGlobalTime >= (5*60*1000)){
        if(getCookie('survey') == null){
            delCookie('lifeTime');
            setCookie("survey","surveyLifeTime","86400");
            var dcTopHtml = '<div class=\"layer-changePrice layer-survey\"><div class="changePriceHd"><div class="tipTitle"></div></div>';
            var dcBottomHtml = '<div class="layerBtn">';
            dcBottomHtml +='</div>';
            dcBottomHtml +='</div>';
                 var dcHtml = dcTopHtml+'<a href="http://www.diaoyanbao.com/answer/load/comjia002" class="surveyBody">'+
            '<div class="survey-text">'+
                    '<p class="p1">鼠标点一点，</p>'+
                    '<p class="p2">居理新房跟您走，</p>'+
                    '<p class="p3">不信试试看！</p>'+
                    '<div class="comjia-ser">'+
                        '<p class="comjia-link">www.comjia.com</p>'+
                        '<p class="hotline">服务热线：' + four_zero_zero + '</p>'+
                    '</div>'+
                    '<div class="survey-enter">'+
                        '<p class="survey-tit">居理新房用户MINI问卷调研</p>'+
                        '<span class="enter-text">点击进入</span>'+
                    '</div>'+
            '</div>'+
         '</a>'+ dcBottomHtml;
            //设置弹层尺寸
            var area = ['660px','460px'];
            popLayer(1,dcHtml,area);
        }
    }
}


//最新的统一风格的弹窗  暂时用于一句话提示
//提交评论的弹窗
function msg_tip (content,func){
    var submit_con = "<div class='es-submit-done'><p class='tips'>"+content+"</p><a href='javascript:void(0);' class='es-goon btn' target='_self'>继续浏览</a>";
    var topHtml = '<div class="layer-wrapper layer-tip-normal">' +
        '<div class="layer-box">' +
        '<div class="hd">' +
        '</div>'+
        '<div class="bd">';

    var bottomHtml = ''+
        '</div>' +
        '</div>' +
        tip_footer_free_call+
        '</div>';
    var tip_layer = topHtml +submit_con + bottomHtml;
    //设置弹层尺寸
    var area = ['660px',''];
    if(typeof func == 'function'){
        popLayer(1,tip_layer,area,reload);
    }else{
        popLayer(1,tip_layer,area);
    }

}

//弹窗中有操作的情况，（目前用到的是弹窗中有上传文件操作）--使用页面：招聘落地页site/hr
function opation_tip (content,opation_name,func){
    var submit_con = "<div class='es-submit-done'><p class='tips'>"+content+"</p><a href='javascript:void(0);' class='btn opation-btn' target='_self'>"+opation_name+"</a>";
    var topHtml = '<div class="layer-wrapper layer-tip-normal">' +
        '<div class="layer-box resume-layer">' +
        '<div class="hd">' +
        '</div>'+
        '<div class="bd">';

    var bottomHtml = ''+
        '</div>' +
        '<div class="layer-footer"></div>'+
        '</div>' +
        '</div>';
    var tip_layer = topHtml +submit_con + bottomHtml;
    //设置弹层尺寸
    var area = ['660px','460px'];
    if(typeof func == 'function'){
        popLayer(1,tip_layer,area,func);
    }else{
        popLayer(1,tip_layer,area);
    }

}

var tip_footer_free_call =''+
    '<div class="tsk-footer">'+
        '<div class="ser-online">'+
            '<div class="consult-online">'+
                '<div class="hotline">'+
                    '热线电话：<strong>'+ four_zero_zero +'</strong>'+
                '</div>'+
                '<div class="online-ask" onclick="ViewAD();">在线咨询</div>'+
            '</div>'+
            '<div class="book-house">'+
                '<input class="ipt" placeholder="请输入您的手机号" value="" id="book-house-tel-layer">'+
                '<button class="btn btn-book button_free_call_comment">预约看房</button>'+
            '</div>'+
            '<div class="tsk-tips"></div>'+
        '</div>'+
    '</div>';
/**
 * 带注册框的提示弹窗
 * @param content
 */
function msg_tip_register (content){
    var tipRegister = '';
    //带注册引导的提示弹窗-提示部分页面结构
    var topHtml = '<div class="layer-wrapper layer-tip-register">' +
        '<div class="layer-box">' +
            '<div class="hd">' +
                '<div class="tipTitle">'+content+'</div>' +
                '<div class="tipMarks">注册一下，以后第一时间获得审核结果！</div>' +
            '</div>'+
        '<div class="bd">';

    var bottomHtml = '';
    bottomHtml +='</div>' +
        '</div>' +
        '</div>';
    //带注册引导的提示弹窗中的注册部分页面结构
    //结构内定义的事件方法在c-login-register.js文件中。
var user_register_info_html = ''+
    '<ul class="user-info user-reg">'+
        '<li>'+
            '<div class="ipt-area">'+
                '<input type="text" class="ipt" placeholder="请输入手机号" id="register-mobile" value=""/>'+
                '<button class="btn-send" id="register-get-captcha-btn" reset_flag="0">发送验证码</button>'+
            '</div>'+
            '<i class="ico-required">*</i>'+
            '<p class="tips-ipt" id="register-mobile-tip">手机号不能为空</p>'+
        '</li>'+
        '<li>'+
            '<div class="ipt-area">'+
                '<input type="text" class="ipt" placeholder="请输入短信验证码" id="register-captcha" value=""/>'+
            '</div>'+
            '<i class="ico-required">*</i>'+
            '<p class="tips-ipt" id="register-captcha-tip">验证码不能为空</p>'+
        '</li>'+
        '<li>'+
            '<div class="ipt-area">'+
                '<input class="ipt" type="password" placeholder="请输入密码" data-placeholder="请输入密码" id="register-password" value=""/>'+
            '</div>'+
            '<i class="ico-required">*</i>'+
            '<p class="tips-ipt" id="register-password-tip">密码不能为空</p>'+
        '</li>'+
    '</ul>'+
    '<div class="btn-area">'+
        '<a class="btn02 submit-register-btn" id="submit-register-btn" href="javascript:void(0)" target="_self">提交</a>'+
    '</div>';

    var bdHtml = user_register_info_html;
    tipRegister = topHtml + bdHtml + bottomHtml;
    var area = ['660px',''];//定义弹窗尺寸
    popLayer(1,tipRegister,area);
}

//点击查看更多点评
$('.media2-info-hover .more ,.go-check-info').click(function(e){
    $('.theme-popover-mask').show();
    $('.theme-popover-mask').height($(document).height());

    var current_data_id = $(this).prop("id");
    $('.theme-popover .bd').html(current_data_id);

    var project_comment_num = $(this).attr("data-num");
    $('#project_comment_num').html(project_comment_num);
    $('.tsk-tips').html('');//清空提示信息
    var data_url = $(this).attr("data-url");
    $('#data_url').attr('href', data_url);

    $('.theme-popover').slideDown(0);
    var popHeight = $(".theme-popover").height();
    $(".theme-popover").css("margin-top",-popHeight/2+50);
    e.stopPropagation();
});
$(document).on('click','.tsk-dp .close a',function(){
    $('.theme-popover-mask').hide();
    $('.theme-popover').slideUp(200);
    $('.theme-popover').removeClass().addClass('tsk-dp theme-popover tsk-no-bg tsk-width-7hundred');//关闭弹窗后恢复默认class
});
//点击页面空白处关闭窗口
$(document).mouseup(function(e){
    var _con = $(".theme-popover");   // 设置目标区域
    if(!_con.is(e.target) && _con.has(e.target).length === 0){ // Mark 1
        var popover = $(".theme-popover");
        var popoverMask = $(".theme-popover-mask");
        if(popover.is(":visible")){
            $('.theme-popover-mask').hide();
            $('.theme-popover').slideUp(200);
            $('.theme-popover').removeClass().addClass('tsk-dp theme-popover tsk-no-bg tsk-width-7hundred');//关闭弹窗后恢复默认class
        }
    }
});

//点评图片展示脚本
$(document).on('click','.es-pics-list li',function(){
    if($(this).hasClass('es-pics-cur')){
        $('.page-es-content').find('.es-pic-big-cur').hide();
        $('.es-pics-list').children('li').removeClass('es-pics-cur');
        $(this).siblings().removeClass('es-pics-cur');
    }else{
        $('.page-es-content').find('.es-pic-big-cur').hide();
        $('.es-pics-list').children('li').removeClass('es-pics-cur');
        $(this).addClass('es-pics-cur');
        $(this).siblings().removeClass('es-pics-cur');
        var es_pics_cur_big = $(this).children('.es-pic-big').attr('src');
        $(this).parent('ul').parent('.es-con-pics').children('.es-pic-big-cur').show().children('img').attr('src',es_pics_cur_big);
    }
});
$(document).on('click','.es-pic-big-cur',function(){
    $(this).hide();
    $('.es-pics-list').children('li').removeClass('es-pics-cur');
});
$(document).on('click','.slide-down-info',function(){
    if($(this).hasClass('es-up')){
        var es_info_text_short = $(this).attr('data-short');
        $(this).parent().parent().children('.es-info-text').html(es_info_text_short+'...');
        setEmotion();
        // $(this).parent().css({'height':'0px', 'float':'right'});
        $(this).removeClass('es-up').html("阅读全文");
    }else{
        var es_info_text = $(this).attr('id');
        $(this).parent().parent().children('.es-info-text').html(es_info_text);
        setEmotion();
        $(this).addClass('es-up').html("收起");
        // $(this).parent().css({'height':'25px', 'float':'none'});
    }
});
$('.header-double-pic-hover').hover(function(){
    $(this).children('.media-pic-funny').show();
    $(this).children('.media-pic-work').hide();
},function(){
    $(this).children('.media-pic-funny').hide();
    $(this).children('.media-pic-work').show();
});

//向他咨询   所有需要用得参数请自行拼接到url当中
function call_employee(url) {
    var area = ['670px','485px'];
    popLayer(2,url,area);
}

var free_call_mobile_ab_test = '';
function abtest(ab_key, ab_value, ab_url, ab_user, ab_data, ab_id)
{
      $.ajax({
            type: 'get',
            url: url_ab_test,
            data: {
                key: ab_key,
                value:ab_value,
                url:ab_url,
                user:ab_user,
                data:ab_data,
                id:ab_id
            },
            success: function (rsp) {
                free_call_mobile_ab_test = rsp;
                //$('body').append('<input type="hidden" value="'+free_call_mobile_ab_test+'" id="free_call_mobile_ab_test_id"/>');
                //$('#free_call_mobile_ab_test_id').attr('id',free_call_mobile_ab_test);
                setCookie('free_call_mobile_ab_test_id',free_call_mobile_ab_test,3600);
            }
        });
}

$(function(){
    //顶部导航右侧登录按钮，弹层登录
    $(document).on('click','#login_new',function(){
        var area = ['600px',''];//弹窗的宽度-向公用弹窗插件方法传递的参数
        //弹窗形式的登录页面结构
        var loginHtmlContent = ''+
            '<div class="layer-wrapper">' +
            '<div class="layer-box">' +
            '<div class="hd">' +
            '<h2>用户登录</h2>' +
            '<ul class="more" style="margin-top:0px;">' +
            '<li>还没有居理新房账号？</li>' +
            '<li class="btn-area">' +
            '<a href="/datainfo/register.jsp" class="layer-btn layer-btn-reg">马上注册</a>' +
            '</li>' +
            '</ul>' +
            '</div>' +
            '<div class="bd">' +
            '<ul class="user-info">' +
            '<li>' +
            '<div class="ipt-area ipt-mobile">' +
            '<input type="text" value="请输入手机号" class="ipt login-mobile-layers" value=""> ' +
            '</div>' +
            '<p class="tips-ipt login-mobile-tip-layers">手机号不能为空</p>' +
            '</li>' +
            '<li>' +
            '<div class="ipt-area ipt-pwd">' +
            '<input type="password" placeholder="请输入密码"  data-placeholder="请输入密码" value="" class="ipt login-password-layers">' +
            '</div>' +
            '<p class="tips-ipt login-password-tip-layers">密码不能为空</p>' +
            '</li>' +
            '<li>' +
            '<div class="chk">' +
            '<input type="checkbox" checked>下次自动登录' +
            '</div>' +
            '<a href="'+go_url_reset+'" class="link-fpwd" target="_self">找回密码</a>' +
            '</li>' +
            '</ul>' +
            '<div class="layer-btn-area">' +
            '<a class="btn4 submit-login-btn-layers" href="javascript:void(0)" target="_self">立即登录</a>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
        popLayer(1,loginHtmlContent,area);
    });
    //新版弹层关闭按钮，自定义按钮，模拟点击插件自带关闭按钮，实现关闭效果
    $(document).on('click','.layer-close-btn-layers',function(){
        close_layer();
    });

});


/**
 * 新版公用弹层(非iframe弹层)，作用只负责弹出弹层，弹层内部的事件请酌情在相应定义事件位置书写
 * 注意：只负责弹层效果。（如需要其他参数，后期可酌情添加）
 * 新版弹层全面使用后，尽量做到整个网站只有一个layer.open()方法，仅需调用popLayer()传递相关参数即可
 * @param htmlContent 弹层内部显示的结构
 * @param area_w 弹层的宽度(带单位)
 * @returns {*}
 */
var layer_hd = ''+
    '<div class="layer">' +
    '<div class="close">' +
    '<a href="javascript:void(0);" target="_self" class="layer-close-btn-layers">Close</a>' +
    '</div>' ;
var layer_bd = ''+
    '<div class="layer-wrapper">' +
    '<div class="layer-box">' +
    '<div class="hd">' +
    '<h2>用户登录</h2>' +
    '<ul class="more">' +
    '<li>还没有居理新房账号？</li>' +
    '<li class="btn-area">' +
    '<a href="#" class="layer-btn layer-btn-reg">马上注册</a>' +
    '</li>' +
    '</ul>' +
    '</div>' +
    '<div class="bd">' +
    '<ul class="user-info">' +
    '<li>' +
    '<div class="ipt-area ipt-mobile">' +
    '<input type="text" placeholder="请输入手机号" class="ipt">' +
    '</div>' +
    '<p class="tips-ipt">手机号不能为空</p>' +
    '</li>' +
    '<li>' +
    '<div class="ipt-area ipt-pwd">' +
    '<input type="password" placeholder="请输入密码"  data-placeholder="请输入密码" class="ipt">' +
    '</div>' +
    '<p class="tips-ipt">密码不能为空</p>' +
    '</li>' +
    '<li>' +
    '<div class="chk">' +
    '<input type="checkbox">下次自动登录' +
    '</div>' +
    '<a href="#" class="link-fpwd">找回密码</a>' +
    '</li>' +
    '</ul>' +
    '<div class="layer-btn-area">' +
    '<a class="btn4" href="#" id="btn-login">立即登录</a>' +
    '</div>' +
    '</div>' +
    '</div>' +
    '</div>' ;
var layer_foot = ''+
    '</div>';
/**
 * 新版弹层公用方法
 * 2015-12-10
 * @param layer_type 弹层类型
 * @param htmlContent 弹层页面结构
 * @param area 弹层尺寸
 * @param func
 * @param data func参数所需的数据，如果需要
 * @param commit_url  确认按钮的跳转url
 */
function popLayer(layer_type,htmlContent,area,func,data,commit_url){
    close_layer();//弹出新弹层之前先清理一下，避免弹出多个弹层
    var layer_html = '';
    //组合弹窗页面结构，其中layer_bd 为自定义结构（需要弹窗传参数就是这部分内容）
    if(layer_type == 1){//1代表页面弹层
        layer_html = layer_hd + htmlContent + layer_foot ;
    }else if(layer_type == 2){//2代表iframe层
        layer_html = htmlContent;
    }

    var layer_content = layer.open({
        type:layer_type,//弹层类型,必填， 默认0,可传入值：0：信息框，1：页面层，2：iframe层，3：加载层，4：tips层
        title:false,//是否显示title
        closeBtn:1,//是否显示关闭按钮（layer自带的按钮）--目前初始化设置为1，自定义了关闭按钮并模拟点击关闭自带关闭按钮
        area:area,
        shadeClose:1,//点击阴影区域是否关闭弹层
        shade:0.7,
        content:layer_html,
        success:function(){
            layer_func(func,data,commit_url);//弹层上的事件
        }
    });
    return layer_content;
}

function layer_func(func,data,commit_url){

    if(typeof commit_url != "undefined" && commit_url.length != 0){
        $(".btn-commit").on("click", function(){
            location.href = commit_url;
        });
    }
    if(typeof func != "undefined"){
        var res = func(data);
        //$(document).on("click",".btn-commit,.es-goon", function(){
        //    var res = func(data);
        //    if(res != false){
        //        layer.closeAll();
        //    }
        //});
    }


    if(typeof func == "undefined"){
        $(".layer > .close,.layer-btn-reset,.btn-commit").click(function(){
            //layer.close(index);
        });
    } else {
        $(".layer > .close,.layer-btn-reset").click(function(){
            layer.closeAll();
        });
    }
}

/**
 * 新版公用弹层 关闭弹层方法
 * 新版所有弹层公用关闭方法，模拟点击弹层插件自身关闭按钮（可以不用定义自己的关闭方法）
 */
function close_layer(){
    layer.closeAll();
    // $('.layui-layer-close').trigger('click');
}

$(document).on('click','.failKnow, .es-goon, .successGo',function () {
    close_layer();
});

//弹层底部"居理新房郑重承诺"部分公用结构变量
var layerBottomPromiseHtml = '<div class="layerDesc">'+
    '<span>居理新房郑重承诺：</span>'+
    '<span>1，居理新房部分楼盘开展活动，会在认购时用服务费抵扣房款。</span>'+
    '<span>2，充分尊重用户意愿，提供一对一温馨服务，免受传统中介骚扰之苦。</span>'+
    '<span>3，保障用户信息安全，多重防护措施严格保护用户信息。</span>'+
    '</div>'+'</div>'+'</div>'+
    '</div>';

//留电话入口弹窗提示结构
var freeCallTopHtml = '<div class="layer-wrapper layer-changePrice">' +
    '<div class="layer-box">' +
    '<div class="hd">'+
    '</div>'+
    '<div class="bd">';

var freeCallFail = freeCallTopHtml+
    '<div class="change-price-warp">' +
    '<div class="changePriceTipFail changePriceTip">您填写的<span>手机号码不正确</span><br>请您核对后重新输入</div>' +
    '<button class="btn-change-price failKnow">我 知 道 了</button>' +
    '</div>'+
    layerBottomPromiseHtml;

var freeCallSuccess = freeCallTopHtml+
    '<div class="change-price-warp">' +
    '<div class="changePriceTipSuccess changePriceTip">' +
    '<span>报名成功</span><br>咨询师将用'+zero_one_zero_free_call_succ+'号码联系您，<br>免费专车带您看房！' +
    '</div>' +
    '<button class="btn-change-price successGo">继 续 选 房</button>' +
    '</div>'+
    layerBottomPromiseHtml;


//联系我们微信公众号
 $(".share-wx a").hover(function(){
    $(this).siblings(".share-qrcode").fadeIn("slow");
 },function(){
    $(this).siblings(".share-qrcode").fadeOut("slow");
 });
//向他咨询
$(document).on("click",".link-header-now,.house-type-header-link,.go-ask-link,.go-to-link",function(){

    if($('.ga_btn_success').data('content') != '' && $('.ga_btn_success').data('content') != null)
    {
        googleAnalytics($('.ga_btn_success').data('content'));
    }
    var _item = $(this);
    var _itemValue = _item.text();
    var dataSrc = _item.attr("data-src");

    if(_item.hasClass("disabled")){
        return false;
    }else {
        _item.text("提交中");
        _item.addClass("disabled");
    }

    call_employee(dataSrc);
    removeLinkDisabled(_item,_itemValue);
});

/**
 * (目前10个专题页面使用)
 * 公用：预约看房
 * 1. 页面布局：左侧文本框，右侧预约看房按钮
 * 2. input必须有  id="free-call-input"
 * 3. button必须有 id="detail_tele_apply" 和 clicksource='common_free_call'
 * 
 *  <input class="tel" id="free-call-input" type="text" placeholder="请输入您的电话号码">
    <button class="btn tel-btn detail-tele-apply"  id="detail_tele_apply" tok="<?= Yii::$app->request->csrfToken ?>" 
            pro_id="132" clicksource="common_free_call">预约看房
    </button>

 */
$('.common-free-call-button').click(function(){
    var _item = $(this);
    var _itemValue = _item.text();
    var pro_id = _item.attr('pro_id');
    var phone = _item.prev('.common-free-call-input').val();
    var csrfToken = _item.attr('tok');
    var clickSource = _item.attr('clickSource');
    addDisabled(_item);
    if(checkTel(phone)){
        $.ajax({
            type: "POST",
            url: free_call_url,
            data: {
                clickSource: clickSource,
                user_mobile: phone,
                project_id: pro_id,
                _csrf: csrfToken
            },
            beforeSend: function(){
                //$(this).attr('disabled', 'disabled');
            },
            success: function(rsp){
                popup_see_house('',see_house_ajax,[pro_id,1,'view_group_pass_one']);
            },
            complete: function(){
            }
        });
    }else{
        var area = ['660px','460px'];
        popLayer(1,freeCallFail,area);
        removeDisabled(_item,_itemValue);
    }
});


/**
 * 公用
 * 户型弹出层里的向他咨询按钮
 * 向他咨询的点击事件
 * /user-see/call-employee?project_id=118&employee_id=170&employee_name=&click_position=house_type&house_type_text=
 * 
 */
$(document).on('click','.common_call_employee_ajax_click', function(){
    $('.common_call_employee_ajax_tips').hide();
    var phone = $(this).siblings('.common_call_employee_ajax_input').val();
    if(!checkTel(phone)){
        $('.common_call_employee_ajax_tips').html('您的手机号有误，请核对后重新输入！').show();
        return false;
    }
    var project_id = $(this).attr('project_id');
    var employee_id = $(this).attr('employee_id');
    var employee_name = $(this).attr('employee_name');
    var click_position = $(this).attr('click_position');
    var house_type_text = $(this).attr('house_type_text');
    var token = $(this).attr('token');
    var item = $(this);
    addDisabled(item);
    $.ajax({
        type: "POST",
        url: url_user_see_call_employee,
        data: {
            user_mobile: phone,
            project_id: project_id,
            _csrf: token,
            data:{
                user_mobile: phone,
                project_id: project_id,
                employee_id: employee_id,
                employee_name: employee_name,
                click_position: click_position,
                house_type_text: house_type_text,
                _csrf: token
            }
        },
        beforeSend: function(){
        },
        success: function(rsp){
            if(rsp == '1'){
                $('.common_call_employee_ajax_tips').html('提交成功，请耐心等待咨询师的联系').show();
                addDisabled(item);
            } else {
                $('.common_call_employee_ajax_tips').html('提交失败，请刷新网页重新提交').show();
            }
        },
        complete: function(){
            removeDisabled(item);
            item.siblings('.common_call_employee_ajax_input').val('预留电话，咨询师将会联系您');
        }
    });
});

//半角英文输入法只允许输入数字
function keyPress(event) {
    var keyCode = event.keyCode;
    if((keyCode >= 48 && keyCode <= 57)){
        event.returnValue = true;
    }else{
        event.returnValue = false;
    }
}
//关键位置统计方法
//区分位置 后面加顺序数区分 用 - 分割 CLICK_BANNER-1 banner第一个位置
$('.main_click_total').click(function(){
    var click_position = $(this).data('result');
    $.ajax({
        type: "POST",
        url: url_total_du_meter,
        data: {
            click_position: click_position
        }
    });
});

/**
 * 关注公众号的标识展示
 */

function qrcodeShow() {
    $(".qrcode-hide").show();
    $(".layer-qrcode,.layer-bg").hide();

}

/**
 * 关注公众号的标识展示
 */
function qrcodeHide() {
    $(".qrcode-hide").hide();
    $(".layer-qrcode,.layer-bg").show();
}

//关注公众号弹层展示
$(".qrcode-hide").click(function(){
    $(".layer-qrcode,.layer-bg").show();
    $(this).hide();
});

//关注公众号弹层展示
$(".layer-qrcode,.layer-bg").click(function(){
    $(".qrcode-hide").show();
    $(".layer-qrcode,.layer-bg").hide();
});
/*if ( qrcode_buy_show == "1")
{
    //首页 pc站增加吸引用户关注居理新房微信公众号的弹出层
    $(document).mouseup(function (e) {
        var _con = $(".layer-qrcode");   // 设置目标区域
        if (!_con.is(e.target) && _con.has(e.target).length === 0) { // Mark 1
        $(".layer-qrcode,.layer-bg").hide();
        qrcodeShow();
        }
    });

    $(".layer-qrcode .close").click(function(){
        $(".layer-qrcode,.layer-bg").hide();
        qrcodeShow();
    });

    if(getCookie('qrcode_lifeTime') == null){
        qrcodeHide();
    }else{
        qrcodeShow();
    }
    
    var myDate = new Date();
    var curTime = myDate.getTime();
    if(getCookie('qrcode_lifeTime') == null){
        setCookie("qrcode_lifeTime",curTime,30*24*60*60*1000);
    }
    $('.old_show').css('display','block');
}else */

/**
 * 点评或者评论有用没有的点击响应
 * @param type       1为咨询师点评， 2为网站前台用户点评, 3为带看之后的点评, 4为资讯详情页的点赞
 * @param id         表 ID
 * @param whether    1为有用，2为没用 ，对于用户的点评需要指定， 默认是有用
 * @param obj        按钮对象
 */

function whether_useful_login_befor(type,id,whether,_item,mobile,captcha){
    $.ajax({
        type: 'POST',
        url: comment_whether_useful_url,
        data: {
            type: type,
            id: id,
            whether: whether,
            mobile:mobile,
            input_code:captcha
        },
        dataType:'json',
        beforeSend: function(){
            _item.attr('disabled', 'disabled');
        },
        success: function(rsp){
            if(!rsp.code){
                if(type == 4){
                    var text = _item.children('.useText').children('.useNum').text();
//                    var old_num = text.match(/\d+/gi);
                    var new_text = text.replace(/\d+/gi, rsp.content);
                    _item.children('.useText').children('.useNum').text(rsp.content);
                    _item.addClass('clicked');
                }else{
                    // 版本迭代处理
                    if(_item.parent('div').hasClass('act-zan')){//最新结构
                        var text = _item.siblings('p').text();
//                        var old_num = text.match(/\d+/gi);
                        var new_text = text.replace(/\d+/gi, rsp.content);
                        _item.siblings('p').text(new_text);
                        _item.addClass('clicked');
                    }else{//旧的结构，（版本迭代中，更新完之后可以删除旧的结构）
                        var text = _item.text();
//                        var old_num = text.match(/\d+/gi);
                        var new_text = text.replace(/\d+/gi, rsp.content);
                        _item.text(new_text);
                        _item.addClass('clicked');
                    }
                }
        			$('#layer-close-btn-layers').click();
//        			$('.login-success').find('h2').text('点赞成功');
        			$('.login-success').find('.update_appdown').html('<p>恭喜您成功点赞</p><p>请下载APP查看最新详情</p>');
    	          var index=layer.open({
    	                type: 1,   //必填， 默认0,可传入值：0：信息框，1：页面层，2：iframe层，3：加载层，4：tips层
    	                area: ['600px','360px'],
    	                title: false,
    	                closeBtn: 0,
    	                content: $('.login-success').html(),
    	                success:function(layero, index){
    	                	var $close = layero.find('.ly-close');
    	                	$close.click(function(){
    	                		layer.close(index);
    	                		if( user_id == '' ){
    	                			location.reload(); 
    	                		}
    	                	});    
    	                }
    	            });
//                	
            }else{
//                msg_tip('评论失败，请您刷新网页之后重新提交');
            	$('.zan-captcha-err').show(0).html(rsp.msg);
            }
        },
        complete: function(){
            _item.removeAttr('disabled');
        }
    });
}

var _item;
var _type;
var _whether_id;
var _whether;
function whether_useful(type, id, whether, obj){
    zhuanjia = 'zhuanjia';
	_item = $(obj);
	_type = type;
	_whether_id = id;
	_whether = whether;
	$('.rapid_enrollment').find('.layer-btn-area').addClass('whether-useful-login');
	$('.rapid_enrollment').find('.layer-btn-area a').removeClass('submit-login-btn-layers');
	// 快速登录
    var rapidEnrollmentHtml = $('.rapid_enrollment').html();
    // 登录成功
    var loginSuccessHtml = $(".login-success").html();
    var area = ['600px', '360px'];
//  判断是否已经点击过
	if( user_id != '' ){
        //设置埋点
        var types = 'zj_dianzan';
        $.get(common_set_event, {
            type: types,
            spy_id: id,
        });
		$.post('/project/check-user-like',{'type':type,'id':id,'user_id':user_id},function(data){
			if( data ){
				common_mobile_popup_layer(2,common_free_mobile_url,"{'tel_input_type':'zaned-layer','tok':'"+_csrf+"'}");
				return false;
			}else{
				captcha = '';
				mobile = '';
				$('.login-success').find('h2').text('点赞成功');
		        whether_useful_login_befor(type,id,whether,_item,mobile,captcha);
			}
		},'json');
//		if($(obj).hasClass('clicked')){
//	        common_mobile_popup_layer(2,common_free_mobile_url,"{'tel_input_type':'zaned-layer','tok':'"+_csrf+"'}");
//	        return false;
//	    }
//	    //cookie 验证
//	    var cookie_index = 'whether_userful_'+ type +'_'+id;
//	    var useful_yet = getCookie(cookie_index);
//	    if(useful_yet != 'whether_userful_yet'){
//	        setCookie(cookie_index, 'whether_userful_yet', 7*24*3600);
//	    }else{
//
//	        common_mobile_popup_layer(2,common_free_mobile_url,"{'tel_input_type':'zaned-layer','tok':'"+_csrf+"'}");
//	        return false;
//	    }
//        if($(this).hasClass('opt-yz')){
//            return false;
//        }

	}else{
		layer_new(1, rapidEnrollmentHtml, area);
	}    
   
}
$(document).on('keydown', function (e) {
    e = e || event;
    if(e.keyCode==13){
        if($(document).find('.whether-useful-login')){
        	whether_comment_login();
        }
    }
});
function whether_comment_login(){
	var mobile = $('.layui-layer #zan-mobile').val();
	var captcha = $('.layui-layer .login-password-layers').val();
    if( mobile == '' ){
    	$('.login-mobile-tip-layers').show(0).html('请输入手机号');
    	return false;
    }
    if (!checkTel(mobile)) {
        $('.login-mobile-tip-layers').show(0).html('请输入正确的手机号');
        return false;
    }
    if( captcha == '' ){
    	$('.login-password-tip-layers').show(0).html('请输入验证码');
    	return false;
    }else{
    	whether_useful_login_befor(_type,_whether_id,_whether,_item,mobile,captcha);
    }
}
//咨询师点赞
$(document).on('click','.layui-layer .whether-useful-login',function(){
	whether_comment_login();
});



//新增公用留电话入口
/**
 * 必需类：按钮事件类common-free-mobile-btn，电话输入input类common-free-mobile-ipt
 * 必需属性：data-content 属性值json格式
 *      data-content 属性值说明：
 *          必需参数：tel_input_type，可用值：
 *                                  layer：     代表弹窗中填写手机号；
 *                                  no-layer    代表填写完手机号后展示弹窗；
 *                                  zaned-layer 代表已经点过赞给出的提示弹窗
 *          可选参数：clickSource 对应Oplog常量
 *                   ga_capture 需要谷歌统计必须的参数
 *                   tok 在页面中直接填写手机号的input结构tok是必须的，在弹窗中填写手机号的input结构tok不是必须的。
 *                   sendMsm 默认是没有这个参数的（即默认是发送短信的），如果后期需要某个留电话入口不需要发送短信，请加上sendMsm='no'这组参数即可，这样就可以保障此操作不发送短信
 *
 *
 */

//验证码有无配置数据
var common_captcha_config = eval('('+captcha_config+')');
$(document).on('click','.common-free-mobile-btn',function(){
    
    var data_content = $(this).data('content');
    var data_content_arr = eval( "(" + data_content + ")" );
    var clickSourceCheck = eval( "(" + data_content_arr['clickSource'] + ")" );
    if(clickSourceCheck.length !=2){
        alert('clickSource参数错误;正确格式[before_op,submit_op]例如：123,456');
        return false;
    }
    if(data_content_arr['tok'] == undefined || data_content_arr['tok'] == '' || data_content_arr['tok'] == null){
        if(_csrf != undefined && _csrf != ''){
            data_content_arr['tok'] = _csrf;
        }else{
            console.log('请正确设置_csrf的值');
            return false;
        }
    }
    var _item = $(this);
    var data = '{';
    var fields = {};
    var mobile = '';
    if(data_content_arr['tel_input_type'] == 'no-layer'){

        //多字段表单。如果存在表单数据，进行获取拼接
        if(_item.data('form-field') != undefined){
            var fields_json = get_form_field(_item);
            if(fields_json == false){
                return false;
            }else{
                fields = eval( "(" + fields_json + ")" );
                fields['has_form_field'] = 1;
            }
        }
        if(fields != false && fields['mobile'] != ''&& fields['mobile'] != undefined ){
            mobile = fields['mobile'];
        }else{
            mobile = _item.siblings('.common-free-mobile-ipt').val();
            data_content_arr['mobile'] = mobile;
        }

        if(checkTel(mobile)){
            for(var key in data_content_arr){
                data += '"'+key+'":"'+data_content_arr[key]+'",';
            }
            data = data.substr(0,data.length-1);
            data += '}';
            data = eval( "(" + data + ")" );
            $.extend(data,fields);//表单数据进行合并
            //判断当前op是否在常量验证码配置中，如果存在，显示验证码的留电，如果不存在，显示无验证码的留电
            var cur_captcha_is = 0;
            for(var k = 0; k < common_captcha_config.length; k++ ){
                if(common_captcha_config[k] == clickSourceCheck[1]){
                    cur_captcha_is = 1;
                }
            }

            if(cur_captcha_is){//有验证码

                //弹出填写验证码的窗口
                common_mobile_popup_layer(2,common_free_mobile_url,data);
            }else{//无验证码，直接提交表单
                common_free_mobile_sub_form(_item,data);
                addDisabled(_item);
            }

            // if(data['captcha'] != undefined && data['captcha'] != ''){//在表单中有验证码，特殊情况，不受统一验证码开关限制，特殊处理
            //     common_check_captcha(_item,data);
            // }else{
            //     if(cur_captcha_is){//有验证码
            //         common_mobile_popup_layer(2,common_free_mobile_url,data);
            //     }else{//无验证码，直接提交表单
            //         common_free_mobile_sub_form(_item,data);
            //         addDisabled(_item);
            //     }
            // }

            // 谷歌统计
            if (data_content_arr['ga_capture'] != '' && data_content_arr['ga_capture'] != null) {
                googleAnalytics(data_content_arr['ga_capture']);
            }
        } else {
            var area = ['660px', '460px'];
            // popLayer(1, freeCallFail, area);
            common_mobile_popup_layer(2,common_free_mobile_error_url,'{}');
        }
    }else if(data_content_arr['tel_input_type'] == 'layer'){
        for(var key in data_content_arr){
            data += '"'+key+'":"'+data_content_arr[key]+'",';
        }

        data = data.substr(0,data.length-1);
        data += '}';

        common_mobile_popup_layer(2,common_free_mobile_url,data);
        // 谷歌统计
        if (data_content_arr['ga_capture'] != '' && data_content_arr['ga_capture'] != null) {
            googleAnalytics(data_content_arr['ga_capture']);
        }
    }else if(data_content_arr['tel_input_type'] == '' || data_content_arr['tel_input_type'] == undefined){
        alert('缺少参数tel_input_type,因为此参数是必须的');
        return false;
    }
});



/**
 * 整站留电话表单提交按钮你事件
 *
 * 按钮属性说明：
 * 1，data-form-field
 *  表单中的input 属性类，以及取值元素类型的组合。
 *      例如：[{'class':'ipt-mobile','type':'input','rules':{'require':'必填项'}},{'class':'house-type','type':'select'}]
 *      重写原生的元素，使用 隐藏域作为取值元素 例如：<input type="hidden" name="area" class="ipt-area"/>
 *      重写的元素 基本包括 单选框radio 复选框checkbox 下拉列表select，需要单独写选中事件，将选中的值动态赋给对应的隐藏域input
 * 2,data-content
 *  后台处理中需要的其他字段参数 书写方式：
 *      例如 "{'project_id':'18','clickSource':'<?=OpLog::OP_TYPE_CLICK_FREE_CALL_VIEW_PASS_ONE?>'}"
 *      各个字段参数书写没有顺序限制
 */
$(document).on('click','.sub-button', function(){
    if($(this).attr('data-form-field') != '' && $(this).attr('data-form-field') != undefined){
        var content = $(this).attr('data-content');
        var fields = get_form_field($(this));
        if(fields != false){
            fields = eval( "(" + fields + ")" );
            var data  = eval( "(" + content + ")" );
            $.extend(data,fields);//表单数据进行合并
            common_free_mobile_sub_form($(this),data);
        }else{
            return false;
        }
    }
});
/**
 * 获取表单数据
 * 按钮属性添加表单类型和字段 添加方式
 * 属性 data-field="[{'输入框class类':'类型（input radio checkbox select ）'},{'输入框class类':'类型（input radio checkbox select ）'}]"
 * 例如：data-field="[{'class':'ipt-mobile','type':'input'},{'class':'house-type','type':'select'}]"
 *
 * 注意：重写的下拉列表，单选框，复选框，都要在元素附近添加隐藏的input 元素，选中后将对应的值动态添加到隐藏的input文本中，
 * 类似<input type="hidden" name="area" class="ipt-area"/>
 *
 * 暂不考虑原声的单选，复选，下拉情况（后续完善）
 */
function get_form_field(obj) {
    var res = "{";
    var form_field = obj.data('form-field');
    form_field = eval(form_field);
    if(form_field.length > 0){
        var field_name = '';
        var field_val = '';
        for(var i=0;i < form_field.length;i++){
            if(form_field[i]['type'] == 'input'){//输入框，（重写的下拉列表、单选框、多选框通过隐藏的输入框input保存数据）
                field_name = obj.parents('.form-box').find('.'+form_field[i]['class']).attr('name');
                field_val = obj.parents('.form-box').find('.'+form_field[i]['class']).val();
                if(form_field[i]['rules'] !=''&& form_field[i]['rules'] != undefined){
                    var form_field_rules = form_field[i]['rules'];
                    var field_tip = '';
                    //按照填写的数组顺序进行校验。
                    //例如 rules:'[{'require':'必填项','mail':'请填写正确的邮箱格式'}]'，这样书写就会先校验必填项require,然后在校验邮箱mail的格式
                    //字段必填校验，rules 参数有require,值如果为空展示默认的必填提示语，值不为空展示自定义的提示语
                    if(form_field_rules['require'] != undefined){
                        field_tip = '↑ 该项是必填项，请认真填写！';//默认必填校验提示语
                        field_tip = form_field_rules['require'] == ''? field_tip : form_field_rules['require'];
                        if(field_val == ''|| field_val == undefined){
                            var tip_obj = obj.parents('.form-box').find('.'+form_field[i]['class']+'-tip');
                            if(tip_obj.attr('class') != undefined){
                                obj.parents('.form-box').find('.'+form_field[i]['class']+'-tip').show(0).html(field_tip);
                            }else{
                                obj.parents('.form-box').find('.ipt-common-tip').show(0).html(field_tip);//没有找到字段对应的提示信息结构的话，在公共提示信息位置展示提示信息
                            }
                            return false;
                        }else{
                            obj.parents('.form-box').find('.'+form_field[i]['class']+'-tip').show(0).html('');
                        }
                    }
                }
            }else if(form_field[i]['type'] == 'select'){//原生的下拉列表
                return false;
            }else if(form_field[i]['type'] == 'checkbox'){//原生的多选框
                return false;
            }else if(form_field[i]['type'] == 'radio'){//原生的单选框
                return false;
            }

            if(i == (form_field.length-1)){
                res+="'"+field_name+"':'"+field_val+"'";
            }else{
                res+="'"+field_name+"':'"+field_val+"',";
            }
        }
    }
    res+="}";
    return res;
}

/**
 * 留电话表单提交方法
 * @param obj 提交按钮对象 提交按钮类sub-button
 * @param form_field 除了手机号和验证码以外的其他表单数据 格式类似 "[{'class':'ipt-area','type':'input'},{'class':'ipt-budget','type':'input'}]"
 * 表单结构
 * 必须的类
 *      form-box
 *          input 必须的属性，class name
 *          提示信息类 手机号错误提示：ipt-mobile-tip  例如 ：<p class="ipt-captcha-tip tips">验证码不正确</p>
 *                  验证码错误提示信息类 ：ipt-captcha-tip  例如 ：<p class="ipt-captcha-tip tips">验证码不正确</p>
 *                  表单提交成功提示信息类：ipt-captcha-tip  提示信息位置相同 例如 ：<p class="ipt-captcha-tip tips">验证码不正确</p>
 *                  备注：如果其他字段有验证信息的提示，在相应的输入框底部相应位置添加类似<p class="ipt-captcha-tip tips">验证码不正确</p> 的元素
 * 1,正常表单
 *  <div class="form-box">
 *      <div class="mobile-option">
 *          <input type="text" name="mobile" class="ipt-mobile" placeholder="填写手机号"/>
 *          <a href="javascript:void(0)">获取验证码</a>
 *      </div>
 *      <p class="ipt-mobile-tip tips">请填写正确格式的手机号码</p>
 *      <input type="text" name="captcha" class="ipt-captcha" placeholder="填写验证码"/>
 *      <p class="ipt-captcha-tip tips">验证码不正确</p>
 *      <button class="sub-button">提交</button>
 *  </div>
 * 2,页面填写手机号，点击后弹窗直接读秒并发送验证码的表单结构  使用隐藏的input 用来提供js取值
 *  <div class="form-box">
 *      <div class="mobile-option">
 *          <input type="hidden" name="mobile" value="17066666666">
 *          <span class="sentCaptcha" data-mobile="手机号码">中间四位星号的手机号码</span>
 *          <a href="javascript:void(0)">获取验证码</a>
 *      </div>
 *      <input type="text" name="captcha" class="ipt-captcha" placeholder="填写验证码"/>
 *      <p class="ipt-captcha-tip tips">验证码不正确</p>
 *      <button class="sub-button">提交</button>
 *  </div>
 *
 *  结构说明：
 *  并非完全按照以上结构 满足几个必须要素就可以
 *  1，表单最外层 类form-box
 *  2，每个字段input 必须有name class 属性
 *  3，如果需要文本提示信息，提示标签的类必须是input 类后面加上‘-tip’即可
 * @returns {boolean}
 */
function common_free_mobile_sub_form(obj,form_field) {
    var _item = obj;
    var data_content = '{}';
    if(typeof obj.data('content') == 'object'){
        data_content = obj.data('content');
    }else{
        data_content = eval( "(" + obj.data('content') + ")" );
    }

    if(typeof form_field != 'object'){
        form_field = eval( "(" + form_field + ")" );//需要手动选择的表单数据
    }
    if(data_content == '' || data_content == undefined){
        data_content = form_field;
    }else{
        $.extend(data_content,form_field);//表单数据进行合并
    }
    //多字段表单提交，补充参数
    if(data_content['tel_input_type'] == undefined || data_content['tel_input_type'] == ''){
        data_content['tel_input_type'] = 'no-layer';
    }
    if(!checkTel(data_content['mobile'])){
        _item.parents('.form-box').find('.ipt-mobile-tip').show(0).html('请输入正确格式的手机号');
        removeDisabled(_item);
        return false;
    }else{
        _item.parents('.form-box').find('.ipt-mobile-tip').show(0).html('');
    }
    //判断当前op是否在常量验证码配置中，如果存在，显示验证码的留电，如果不存在，显示无验证码的留电
    var clickSourceCheck = eval( "(" + data_content['clickSource'] + ")" );
    if(clickSourceCheck.length !=2){
        alert('clickSource参数错误;正确格式[before_op,submit_op]例如：123,456');
        return false;
    }
    var cur_captcha_is = 0;
    for(var k = 0; k < common_captcha_config.length; k++ ){
        if(common_captcha_config[k] == clickSourceCheck[1]){
            cur_captcha_is = 1;
        }
    }

    if(cur_captcha_is){
        //校验验证码的合法正确性，正确直接提交表单
        common_check_captcha(_item,data_content);
    }else{
        // 无验证码，直接提交表单
        common_mobile_sub(_item,data_content);
    }

}

$(document).on('DOMNodeRemoved','.layui-layer-shade',function(){
    window.parent.$('.common-free-mobile-btn').removeAttr('disabled').removeClass('disabled');
    window.parent.$('.btnChangePrice').removeAttr('disabled').removeClass('disabled');
    window.parent.$('.make_call_for_free2').removeAttr('disabled').removeClass('disabled');
    window.parent.$('.common-free-call-button').removeAttr('disabled').removeClass('disabled');
});

/**
 * 留电话入口表单提交前验证 验证码的正确性
 * @param _item 提交按钮 对象
 * @param data 所需要的数据，数组
 *      data中必须的数据：
 *          check_captcha_url ajax请求地址
 *          mobile 手机号
 *          captcha 验证码
 *          tok 表单提交需要的_csrf
 * @returns {*}
 */
function common_check_captcha(_item,data) {
    if(checkCaptcha(data['captcha'])){
        $.ajax({
            type: "POST",
            url: check_mobile_captcha_update,
            data: {
                mobile: data['mobile'],
                captcha:data['captcha'],
                _csrf:data['tok']
            },
            beforeSend: function () {
            },
            success: function (rsps) {
                if(rsps.length <= 0){
                    _item.parents('.form-box').find('.ipt-captcha-tip').show(0).html('验证码不正确 请重新输入');
                }else{
                    rsps = eval('(' + rsps + ')');
                    if(rsps.code == 2){
                        _item.parents('.form-box').find('.ipt-captcha-tip').show(0).html('验证码已过期，请重新获取');
                        removeDisabled(_item);
                        return false;
                    }else if(rsps.code == 3){
                        _item.parents('.form-box').find('.ipt-captcha-tip').show(0).html('验证码不正确 请重新输入');
                        removeDisabled(_item);
                        return false;
                    }else if(rsps.code == 1){
                        addDisabled(_item);
                        _item.parents('.form-box').find('.ipt-captcha-tip').show(0).html('');
                        common_mobile_sub(_item,data);//验证码验证正确，可以提交表单
                    }
                }
            },
            error: function (error) {
                return false;
            },
            complete: function () {
            }
        });
    }else{
        _item.parents('.form-box').find('.ipt-captcha-tip').show(0).html('验证码不正确 请重新输入');
        removeDisabled(_item);
        return false;
    }

}

/**
 * 留电话表单提交方法
 * @param _item 点击按钮对象
 * @param data 提交所需要的数据，数组
 *      data中必须的数据：
 *          sub_common_mobile_url ajax请求地址
 *          data_content action中需要的所有字段都会在这个属性中
 *          mobile 手机号
 *          tok 表单提交需要的_csrf
 *      非必须数据：
 *          capture Google GA 统计必须的数据，如果需要统计，可填写，
 */
function common_mobile_sub(_item,data) {
    if(data['tok'] == undefined || data['tok'] == ''){
        data['tok'] = _csrf;
    }
    //判断当前op是否在常量验证码配置中，如果存在，显示验证码的留电，如果不存在，显示无验证码的留电
    var clickSourceCheck = eval( "(" + data['clickSource'] + ")" );
    if(clickSourceCheck.length !=2){
        alert('clickSource参数错误;正确格式[before_op,submit_op]例如：123,456');
        return false;
    }
    var cur_captcha_is = 0;
    for(var k = 0; k < common_captcha_config.length; k++ ){
        if(common_captcha_config[k] == clickSourceCheck[1]){
            cur_captcha_is = 1;
        }
    }

    $.ajax({
        type: "POST",
        url: common_free_mobile_sub,
        data: {
            data_content: data,
            _csrf: data['tok']
        },
        beforeSend: function(){
        },
        success: function(rsp){
            var res = eval('('+ rsp +')');
            if(res['res'] == '1'){
                if(data['tel_input_type'] == 'no-layer'){
                    if(cur_captcha_is){
                        if($('#applar_step3').length>0){
                            $('#applar_step3').show().siblings('.free_mobile_captcha').hide();
                        }
                    }else{
                        data['form_sub_ed'] = 1;//表单已经提交的标记
                        common_mobile_popup_layer(2,common_free_mobile_url,data);
                        if($('#applar_step3').length>0){
                            $('#applar_step3').show().siblings('.free_mobile_captcha').hide();
                        }
                    }
                }else{
                    // 用以区分留电话成功后，是一句话提示还是更换弹窗内容进行提示。#applar_step3 所属部分是成功提示弹窗部分
                    if($('#applar_step3').length>0){
                        $('#applar_step3').show().siblings('.free_mobile_captcha').hide();
                    }else{
                        _item.parents('.form-box').find('.ipt-captcha-tip').html('预约成功,咨询师将用'+zero_one_zero_free_call_succ+'联系您');
                    }
                    if(data['capture'] != '' && data['capture'] != null)
                    {
                        googleAnalytics(data['capture']);
                    }

                }

            } else {
                alert(res['res']);
            }
        },
        complete: function(){
            var obj = $('.sub-button');
            removeDisabled(obj);//解除本页面的按钮禁用
            // var parentObj = window.parent.$('.common-free-mobile-btn');
            // parentObj.removeAttr('disabled');//弹窗提交成功后，解除父级window下的按钮禁用
        }
    });
}





$(document).on('click','.applay_button2, .applay_button', function(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
});

/**
 * 留电话公用的弹窗调用方式，（需要）
 * @param layerType 弹窗类别
 * @param url 模板地址
 * @param data 参数 array
 */
function common_mobile_popup_layer(layerType,url,data){
    var free_url = '';
    var params = '';
    var data_arr = '';
    if(data == '' || data == undefined){
        free_url = url;
    }else{
        if( typeof data  == 'object'){
            data_arr = data;
        }else{
            data_arr = eval("("+data+")");
        }
        for(var key in data_arr){
            params += key+'='+data_arr[key]+'&';
        }
        params = params.substr(0,params.length-1);
        free_url = url+'/?'+params;
    }
    var area = ['670px','485px'];
    popLayer(layerType,free_url,area);
}


/***验证获取验证码的手机是否有效
 *  无效给出错误提示，有效直接获取验证码
 * @returns {boolean}
 */
function get_captcha_click_captcha(obj) {
    var mobile = obj.parents('.form-box').find('.ipt-mobile').val();
    if (!checkTel(mobile)) {
        obj.parents('.form-box').find('.ipt-mobile-tip').html('请输入正确格式的手机号');
        return false;
    } else {
        obj.parents('.form-box').find('.ipt-mobile-tip').html('');
        /*获取验证码方法*/
        timeNumListen(30);
        get_captcha(mobile);
        if(obj.siblings('.mobile-option').children('input.ipt-mobile').attr('type') == 'text'){
            obj.parents('.form-box').find('.ipt-mobile-tip').html('已向您的手机发送验证码，请查收');
        }
    }
}
/**
 * 获取验证码方法
 * @param mobile 获取验证码的手机号码
 */
function get_captcha(mobile) {
    $.ajax({
        type: "GET",
        url: get_mobile_captcha_save,
        data: {
            mobile: mobile,
            _csrf: _csrf
        },
        cache:false,
        beforeSend: function () {
        },
        success: function (rsps) {
        },
        error: function (error) {
            return false;
        },
        complete: function () {
        }
    },'html');

}

/**
 * 验证码已经发送，按钮timenum 秒内不能点击
 * @param timenum int 监听秒数
 **/
function timeNumListen(timenum) {
    settimenum();
    function settimenum() {
        if (timenum > 0) {
            $('.send-mobile-captcha').text(timenum + '秒后可重发验证码').attr('disabled', 'disabled').css({'color': '#a5a5a5'});
            setTimeout(settimenum, 1000);
            timenum = timenum - 1;
        } else {
            $('.send-mobile-captcha').text('发送验证码').removeAttr('disabled').css({'color': '#333'});
        }
    }
}

/*短信验证码的校验*/
function checkCaptcha(value) {
    var captchaRule=/^[0-9]{4}$/;
    if (!captchaRule.exec(value)){
        return false;
    }else{
        return true;
    }
}

/*获取验证码*/
$(document).on('click', '.send-mobile-captcha', function () {
    get_captcha_click_captcha($(this));
    var obj = $('.sub-button');
    removeDisabled(obj);//解除本页面的留电提交按钮禁用
});




//帮您找房
$(function(){
    //筛选条件
    $(".input-area").each(function(){
        var _item = $(this);
        var _ipt = _item.children(".ipt");
        _ipt.click(function(){
            if(_ipt.next(".dropdown-list").is(":hidden")){
                _ipt.next(".dropdown-list").stop().slideDown();
                _ipt.parents(".input-area").parents(".tr").addClass("on");

                _ipt.next(".dropdown-list").children("li").click(function(){
                    var defaultValue = _ipt.next(".dropdown-list").children("li:first").text();
                    _ipt.parents(".input-area").parents(".tr").removeClass("on");
                    _ipt.text($(this).text());
                    var dataCapture = $(this).attr("data-capture");
                    var dataKey = $(this).parents(".dropdown-list").prev(".ipt").attr("data-key");
                    switch(dataKey)
                    {
                        case 'area':
                            _ipt.attr('data-area',dataCapture);
                            _ipt.siblings('.ipt-area').attr('value',dataCapture);
                            _ipt.parents('.form-box').find('.ipt-area-tip').hide(0).html('');
                            break;
                        case 'budget':
                            _ipt.attr('data-budget',dataCapture);
                            _ipt.siblings('.ipt-budget').attr('value',dataCapture);
                            _ipt.parents('.form-box').find('.ipt-budget-tip').hide(0).html('');
                            break;
                        case 'house':
                            _ipt.attr('data-house',dataCapture);
                            _ipt.siblings('.ipt-house').attr('value',dataCapture);
                            _ipt.parents('.form-box').find('.ipt-house-tip').hide(0).html('');
                            break;
                        case 'size':
                            _ipt.attr('data-size',dataCapture);
                            _ipt.siblings('.ipt-size').attr('value',dataCapture);
                            _ipt.parents('.form-box').find('.ipt-size-tip').hide(0).html('');
                            break;
                    }
                    if(_ipt.text() == defaultValue){
                        _ipt.css({
                            color: "#999"
                        });
                    }else{
                        _ipt.css({
                            color: "#333"
                        });
                    }

                    $(this).parents(".dropdown-list").slideUp("fast");
                });
            }else if(_ipt.next(".dropdown-list").is(":visible")){
                $(".dropdown-list").slideUp("fast");
                _ipt.parents(".input-area").parents(".tr").removeClass("on");
            }
        });

    });

    //点击空白区域关闭下拉选择框
    $(document).mouseup(function(e){
        var _con = $(".dropdown-list");   // 设置目标区域
        if(!_con.is(e.target) && _con.has(e.target).length === 0){ // Mark 1
            $(".dropdown-list").slideUp();
            _con.parents(".input-area").parents(".tr").removeClass("on");
        }
    });

    $('.click-option-more').click(function(){
        if($(this).hasClass('up')){
            $(this).removeClass('up').html('阅读全文');
            $(this).siblings('.simple').show();
            $(this).siblings('.detail').hide();
        }else{
            $(this).addClass('up').html('收起');
            $(this).siblings('.detail').show();
            $(this).siblings('.simple').hide();
        }
    });

    //表情
    $(document).on('click','.selectEmotion',function (event) {
        if (!$("#sinaEmotion").is(":visible")) {
            $(this).sinaEmotion($(this).parents('.modify_container').find('textarea'));
            var winWidth = $(window).width();
            var rowWidth = $('.row').width();
            var motionWidth = ((winWidth - rowWidth) / 2)+30;
            var pw = $(this).parent().parent().width();
            $("#sinaEmotion").css({'width':pw,'right':motionWidth});
            event.stopPropagation();
        }
    });

//表情的渲染
    setEmotion();

//footer 底部切换展示网站地图锚文本div
    $('.tab-con .show_sitemap_change').click(function(){
        if($(this).hasClass('show')){
            $(this).siblings('.nrpart').hide(0);
            $(this).removeClass('show');
        }else{
            $(this).siblings('.nrpart').show(0);
            $(this).addClass('show');
        }

        footerHeight = $(".footer").height();
        $(".center").css("padding-bottom",footerHeight);
    });
});

/**
 * sina_emotion 表情插件2.1版本 解析表情方法.
 * 在涉及到表情解析的元素上添加类 setEmotion ，异步加载需要解析表情的时候调用setEmotion()即可
 */
function setEmotion(){
    if($('.setEmotion').length > 0){
        $('.setEmotion').parseEmotion();
    }
}

$(function(){
    var url_field_notice = document.URL;
    var num_field_notice = url_field_notice.indexOf("#");
    if(num_field_notice > 0){
        var str_field_notice = url_field_notice.substr(num_field_notice + 1);
        if(str_field_notice){
            
            if($("#" + str_field_notice).length){
                $("html,body").animate({
                    scrollTop: $("#" + str_field_notice).offset().top - 140 + "px"  //设置锚点链接地址距离屏幕顶部的距离：150px
                }, {
                    duration: 500,
                    easing: "swing"
                });
                return false;
            }

        }
    }

});

window.onload = function () {//隐藏mac迅雷插件自动加载的代码结构
    $("embed[type='application/thunder_download_plugin']").css("display","none")
};