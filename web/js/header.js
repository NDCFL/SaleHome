$(function($){
    var appId = "1008";
    var secretKey = "f51606329bc76e764e6c0d104d2bf3f0";
    if(typeof common_head_login_config != "undefined"){
        if( typeof common_head_login_config.appId != "undefined"){
            appId = common_head_login_config.appId;
        }
        if(typeof common_head_login_config.secretKey  != "undefined"){
            secretKey = common_head_login_config.secretKey;
        }
    }
    //鼠标移上去显示下拉菜单
    $('.pt-menu-list').mouseover(function(event){
        $('.pf-sub-menu',this).show();
        $(this).addClass('menu-current');
    });
    //鼠标移上去隐藏下拉菜单
    $('.pt-menu-list').mouseout(function(event){
        $('.pf-sub-menu',this).hide();
        $(this).removeClass('menu-current');
    });
    //登录
    var ru = window.location.href,
        isReload = true;
    //登录接口
    FCLogin.initilize({
        appId: appId,
        secretKey: secretKey,
        ru:ru,
        sc:function(ret){
            if(window._isReload==true){
                window.location.reload();
            }else{
                $(".user").html(ret.uniqname);
                $(".login-before").hide();
                $(".login-after").show();
                $.getScript('http://house.focus.cn/common/modules/passport/js/login_success.php?from=fpp', function(){
                    if(isReload){
                        window.location.reload();
                    }
                });
            }
        },
        fc:function(){

        }
    });

    //载入时判断登录状态
    FCLogin.checkUserStatus(function(ret){
        if(ret){
            $(".user").html(ret.nickName);
            $(".login_before").hide();
            $(".pt-login_after").show();
        }
    });
    //logout
    $(".logout").click(function(e){
        e.preventDefault();
        FCLogin.logout();
        $(".login_before").show();
        $(".pt-login_after").hide();
    });

    $(".login").click(function(e){
        e.preventDefault();
        FCLogin.open();
    });
});