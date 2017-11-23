var homeTabTitle = '主页';
var contextPath = "/EasyUIProj";

/**
 * 添加选项卡到中部内容区域
 * @param title 选项卡的标题
 * @param url 选项卡所对应的url
 * @returns
 */
function addTab(title, url) {
    if ($('#tabs').tabs('exists', title)) { // 通过标题来判断选项卡是否存在
        $('#tabs').tabs('select', title); // 如果存在，则直接选中此选项卡
        var currTab = $('#tabs').tabs('getSelected');
        var url1 = $(currTab.panel('options').content).attr('src');
        if(url1 != undefined && currTab.panel('options').title != homeTabTitle) {
            $('#tabs').tabs('update',{ // 刷新选项卡的内容
                tab:currTab,
                options:{
                    content:createFrame(url1)
                }
            })
        }
    } else {
    	// 如果选项卡不存在，则添加一个选项
        $('#tabs').tabs('add', {
            title: title,
            content: createFrame(url), // 创建一个frame用于显示指定url的页面，把此frame窗口添加到选项的内容区域
            border: false,
            closable: true
        });
    }
    tabClose(); // 关闭选项卡
}

/**
 * 根据指定的url创建frame窗口，与选项卡内容区域的宽度及高度一致
 * @param url
 * @returns
 */
function createFrame(url) {
    return '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
}

/**
 * 关闭选项卡
 * @returns
 */
function tabClose() {
    $(".tabs-inner").dblclick(function(){
        var subtitle = $(this).children(".tabs-closable").text();
        $('#tabs').tabs('close', subtitle);
    })
    $(".tabs-inner").bind('contextmenu',function(e){ // 给选项卡绑定右键菜单 
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY
        });

        var subtitle =$(this).children(".tabs-closable").text();

        $('#mm').data("currtab", subtitle);
        $('#tabs').tabs('select', subtitle);
        return false;
    });
}

/**
 * 关闭事件
 * @returns
 */
function tabCloseEvent() {
    $('#mm-tabupdate').click(function(){ // 刷新事件
        var currTab = $('#tabs').tabs('getSelected');
        var url = $(currTab.panel('options').content).attr('src');
        if(url != undefined && currTab.panel('options').title != homeTabTitle) {
            $('#tabs').tabs('update',{
                tab:currTab,
                options:{
                    content:createFrame(url)
                }
            })
        }
    })
    $('#mm-tabclose').click(function(){ // 关闭
        var currtab_title = $('#mm').data("currtab");
        $('#tabs').tabs('close',currtab_title);
    })
    $('#mm-tabcloseall').click(function(){ // 关闭所有
        $('.tabs-inner span').each(function(i,n){
            var t = $(n).text();
            if(t != homeTabTitle) {
                $('#tabs').tabs('close',t);
            }
        });
    });
    $('#mm-tabcloseother').click(function(){ // 关闭其他 
        var prevall = $('.tabs-selected').prevAll();
        var nextall = $('.tabs-selected').nextAll();
        if(prevall.length>0){
            prevall.each(function(i,n){
                var t=$('a:eq(0) span',$(n)).text();
                if(t != homeTabTitle) {
                    $('#tabs').tabs('close',t);
                }
            });
        }
        if(nextall.length>0) {
            nextall.each(function(i,n){
                var t=$('a:eq(0) span',$(n)).text();
                if(t != homeTabTitle) {
                    $('#tabs').tabs('close',t);
                }
            });
        }
        return false;
    });
    $('#mm-tabcloseright').click(function(){
        var nextall = $('.tabs-selected').nextAll();
        if(nextall.length==0){
            alert('后边没有啦~~');
            return false;
        }
        nextall.each(function(i,n){
            var t=$('a:eq(0) span',$(n)).text();
            $('#tabs').tabs('close',t);
        });
        return false;
    });

    $('#mm-tabcloseleft').click(function(){
        var prevall = $('.tabs-selected').prevAll();
        if(prevall.length==0){
            alert('到头了，前边没有啦~~');
            return false;
        }
        prevall.each(function(i,n){
            var t=$('a:eq(0) span',$(n)).text();
            $('#tabs').tabs('close',t);
        });
        return false;
    });

    $("#mm-exit").click(function(){
        $('#mm').menu('hide');
    })
}

/**
 * 给所有选项卡绑定关闭事件
 */
$(function() {
    tabCloseEvent();
    // 给所有具有site-navi-tab的元素添加点击事件，一旦点击，则添加选项到选项卡中
    $('.site-navi-tab').click(function() {
        var $this = $(this);
        var href = $this.attr('src');
        var title = $this.text();
        addTab(title, href); 
    });
});

/**
 * 
 * @param tableId 哪个表格进行分页
 * @param pageSize 默认的pageSize
 * @returns
 */
var defaultPageSize = 20;
function setPagination(tableId, pageSize) {
    var ps = defaultPageSize;
    if (typeof pageSize === 'number') {
        ps = pageSize;
    }
    var p = $("#" + tableId).datagrid('getPager'); // getPager获取表格所对应的分页组件
    $(p).pagination({ // 设置分页组件的属性
        pageSize: ps,
        pageList: [20, 30, 40, 50, 60, 70],
        beforePageText: '第',
        afterPageText: '页    共 {pages} 页', // 引用 pages变量，用于总共有多少页
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', // 引用total变量，表示 总共多少条记录
        onBeforeRefresh: function () {
            $(this).pagination('loading');
            $(this).pagination('loaded');
        }
    });
}

/**
 * 表格的顶部加入搜索框，搜索框的form表单的值与datagrid的参数一同传递到后台
 * @param dataGridId
 * @param formId
 * @returns
 */
function getQueryParams(dataGridId, formId) {
    var fields =$('#' + formId).serializeArray();
    var params = $("#" + dataGridId).datagrid('options').queryParams; // 获取指定的数据表格的查询参数
    $.each( fields, function(i, field){ // 把表单的查询参数与表格分页的查询组合在一起
        params[field.name] = field.value;
    });
    return params;
}

function formatDate(value) {
    if (value == undefined || value == null || value == '') {
        return "";
    } else {
        var date = new Date(value); // 获取js的Date对象
        var year = date.getFullYear().toString();
        var month = (date.getMonth() + 1);
        var day = date.getDate().toString();
        var hour = date.getHours().toString();
        var minutes = date.getMinutes().toString();
        var seconds = date.getSeconds().toString();
        if (month < 10) {
            month = "0" + month;
        }
        if (day < 10) {
            day = "0" + day;
        }
        if (hour < 10) {
            hour = "0" + hour;
        }
        if (minutes < 10) {
            minutes = "0" + minutes;
        }
        if (seconds < 10) {
            seconds = "0" + seconds;
        }
        return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
    }
}

function validateForm(formId) {
	return $("#" + formId).form('enableValidation').form("validate")
}

/**
 * 显示窗口
 */
function openWin(winId) {
	$("#" + winId).window("open");
}

function closeWin(winId) {
	$("#" + winId).window("close");
}

function formatValid(value) {
	if (value == "Y") {
		return "是";
	} else {
		return "否";
	}
}

function showInfoAlert(message) {
	$.messager.alert("提示", message, "info");
}

function strToJSON(str) {
	return eval("(" + str + ")"); // 把一个JSON格式字符串转化成JSON对象
}
