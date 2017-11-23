<%@page import="javax.persistence.criteria.CriteriaBuilder.In"%>
<%@page import="org.apache.commons.lang3.ClassUtils.Interfaces"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<title>SaleHome</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="Cache-Control" content="no-transform" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<meta http-equiv="Content-language" content="zh-CN" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="applicable-device" content="pc">
		<meta name="mobile-agent"
			content="format=html5;url=https://m.lianjia.com/bj/">
		<link rel="alternate" media="only screen and (max-width: 640px)"
			href="https://m.lianjia.com/bj/">
		<link property='stylesheet' rel="stylesheet" href="https://s1.ljcdn.com/feroot/pc/asset/lianjiaIM/css/lianjiaim.css?_v=20170630110651">
		<link rel="stylesheet" href="<%=path%>/homecss/login.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
		<base target="_blank">
		<link href="/favicon.ico" type="image/x-icon" rel=icon>
		<link href="/favicon.ico" type="image/x-icon" rel="shortcut icon">
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet"
			href="https://s1.ljcdn.com/feroot/pc/asset/common.css?_v=20170630110651">
		<link rel="stylesheet" type="text/css"
			href="https://s1.ljcdn.com/feroot/pc/asset/index/css/main.css?_v=20170630110651">
		<style type="text/css">
			@media only screen and (max-width: 479px){
			    .form-horizontal .form-group{
			        padding: 0 25px;
			    }
			    .form-horizontal .form-group i{
			        left: 45px;
			    }
			    .form-horizontal .btn{
			        padding: 10px 20px;
			    }
			}
		</style>
	</head>
	<body>
		<div class="header" data-stellar-background-ratio="0.07">
			<div class="wrapper">
				<div class="fl">
					<a href="https://www.lianjia.com/" title="链家网"
						target="_self"><img src="<%=path%>/homeimage/logo.png"></a><span class="exchange"><i></i>北京</span>
				</div>
				<div class="city-change animated">
					<span class="close"></span>
					<div class="title">
						选择城市
						<span class="city-tab"><span class="code1">热门城市:</span><a
							href="//bj.lianjia.com/" title="北京房产网">北京</a><a
							href="http://sh.lianjia.com/" title="上海房产网">上海</a><a
							href="//gz.lianjia.com/" title="广州房产网">广州</a><a
							href="//sz.lianjia.com/" title="深圳房产网">深圳</a> </span>
					</div>
					<div class="title-line"></div>
					<div class="fc-main clear">
						<div class="fl citys-l">
							<ul>
								<li class="clear">
									<span class="code-title fl">B</span>
									<div class="city-enum fl">
										<a href="https://bj.lianjia.com/" title="北京房产网">北京</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">C</span>
									<div class="city-enum fl">
										<a href="https://cd.lianjia.com/" title="成都房产网">成都</a><a
											href="https://cq.lianjia.com/" title="重庆房产网">重庆</a><a
											href="https://cs.lianjia.com/" title="长沙房产网">长沙</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">D</span>
									<div class="city-enum fl">
										<a href="https://dl.lianjia.com/" title="大连房产网">大连</a><a
											href="https://dg.lianjia.com/" title="东莞房产网">东莞</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">F</span>
									<div class="city-enum fl">
										<a href="https://fs.lianjia.com/" title="佛山房产网">佛山</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">G</span>
									<div class="city-enum fl">
										<a href="https://gz.lianjia.com/" title="广州房产网">广州</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">H</span>
									<div class="city-enum fl">
										<a href="https://hz.lianjia.com/" title="杭州房产网">杭州</a><a
											href="https://hui.lianjia.com/" title="惠州房产网">惠州</a><a
											href="http://hk.lianjia.com/" title="海口房产网">海口</a><a
											href="https://hf.lianjia.com/" title="合肥房产网">合肥</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">J</span>
									<div class="city-enum fl">
										<a href="https://jn.lianjia.com/" title="济南房产网">济南</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">L</span>
									<div class="city-enum fl">
										<a href="http://ls.lianjia.com/" title="陵水房产网">陵水</a><a
											href="https://lf.lianjia.com/" title="廊坊房产网">廊坊</a>
									</div>
								</li>
							</ul>
						</div>
						<div class="fl citys-r">
							<ul>
								<li class="clear">
									<span class="code-title fl">N</span>
									<div class="city-enum fl">
										<a href="https://nj.lianjia.com/" title="南京房产网">南京</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">Q</span>
									<div class="city-enum fl">
										<a href="https://qd.lianjia.com/" title="青岛房产网">青岛</a><a
											href="http://qh.lianjia.com/" title="琼海房产网">琼海</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">S</span>
									<div class="city-enum fl">
										<a href="http://sh.lianjia.com/" title="上海房产网">上海</a><a
											href="https://sz.lianjia.com/" title="深圳房产网">深圳</a><a
											href="http://su.lianjia.com/" title="苏州房产网">苏州</a><a
											href="http://sjz.lianjia.com/" title="石家庄房产网">石家庄</a><a
											href="https://sy.lianjia.com/" title="沈阳房产网">沈阳</a><a
											href="http://san.lianjia.com/" title="三亚房产网">三亚</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">T</span>
									<div class="city-enum fl">
										<a href="https://tj.lianjia.com/" title="天津房产网">天津</a><a
											href="http://ty.lianjia.com/" title="太原房产网">太原</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">W</span>
									<div class="city-enum fl">
										<a href="https://wh.lianjia.com/" title="武汉房产网">武汉</a><a
											href="http://wc.lianjia.com/" title="文昌房产网">文昌</a><a
											href="http://wn.lianjia.com/" title="万宁房产网">万宁</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">X</span>
									<div class="city-enum fl">
										<a href="https://xm.lianjia.com/" title="厦门房产网">厦门</a><a
											href="http://xa.lianjia.com/" title="西安房产网">西安</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">Y</span>
									<div class="city-enum fl">
										<a href="https://yt.lianjia.com/" title="烟台房产网">烟台</a>
									</div>
								</li>
								<li class="clear">
									<span class="code-title fl">Z</span>
									<div class="city-enum fl">
										<a href="https://zs.lianjia.com/" title="中山房产网">中山</a><a
											href="https://zh.lianjia.com/" title="珠海房产网">珠海</a>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="fr">
					<div class="nav typeUserInfo">
						<div class="ti-hover">
							<div class="typeShowUser ">
								<i></i>
								<span class="welcome"> <a
									class="btn-login bounceIn actLoginBtn"
									href="javascript:void(0);" data-toggle="modal" data-target="#myModal"><span class="reg">登录</span>
								</a> <a href="<%=path%>/WEB-INF/face/zhuce.jsp"><span class="log">立即注册</span>
								</a>
								</span>
							</div>
						</div>
						<ul>
							<li>
								<a class="" href="https://bj.lianjia.com/ershoufang/">二手房</a>
							</li>
							<li>
								<a class="" href="http://bj.fang.lianjia.com/">新房</a>
							</li>
							<li>
								<a class="" href="https://bj.lianjia.com/zufang/">租房</a>
							</li>
							<li>
								<img class="icon-lvju"
									src="https://s1.ljcdn.com/feroot/pc/asset/img/home/lvju.png?_v=20170630110651">
								<a rel="nofollow" class="" href="http://you.lianjia.com/">旅居地产</a>
							</li>
							<li>
								<a class="" href="https://us.lianjia.com/">海外</a>
							</li>
							<li>
								<a class="" href="https://bj.lianjia.com/xiaoqu/">小区</a>
							</li>
							<li>
								<a class="" href="https://bj.lianjia.com/jingjiren/">经纪人</a>
							</li>
							<li class="hover">
								<a class="" href="https://bj.lianjia.com/wenda/">指南</a>
								<div class="nav-list">
									<dd>
										<i></i>
										<dl>
											<a href="https://bj.lianjia.com/wenda/">问答</a>
										</dl>
										<dl>
											<a href="https://news.lianjia.com/bj/baike/">百科</a>
										</dl>
									</dd>
								</div>
							</li>
							<li>
								<a class="" href="https://bj.lianjia.com/tool.html"
									target="_blank">工具</a>
							</li>
							<li class="hover">
								<a class="" href="https://news.lianjia.com/bj/jingyan/">经验</a>
								<div class="nav-list">
									<dd>
										<i></i>
										<dl>
											<a href="https://news.lianjia.com/bj/jingyan/">购房经验</a>
										</dl>
										<dl>
											<a href="https://news.lianjia.com/bj/jingyan/tougao">我要投稿</a>
										</dl>
									</dd>
								</div>
							</li>
							<li class="real">
								<i></i><a class="" href="https://bj.lianjia.com/yezhu/"
									target="_blank">业主</a>
							</li>
						</ul>
					</div>
				</div>
				<!--[if lte IE 8]><div class="old-browser-popup" id="old" >亲，您当前正在使用旧版本的IE浏览器，为了保证您的浏览体验，链家网建议您使用：<label class="chrome-borwser-ico"></label><a href="//rj.baidu.com/soft/detail/14744.html?ald" target="_blank">谷歌浏览器</a>&nbsp;或&nbsp;&nbsp;<label class="firefox-borwser-ico"></label><a href="//rj.baidu.com/soft/detail/11843.html?ald" target="_blank">火狐浏览器</a><span id="oldclose"></span></div><![endif]-->
				<div class="clear"></div>
				<div class="header-wrap">
					<div class="wrap-ico"></div>
					<div class="house-num">
						<ul>
							<li>
								北京链家真实在售二手房 23290 套
							</li>
							<li>
								北京链家真实租房 20332 套
							</li>
							<li>
								北京链家在售新房楼盘 227 个
							</li>
						</ul>
					</div>
					<div class="search-box-wrap" log-mod="search">
						<div class="search-box-con">
							<div class="menu">
								<ul>
									<li class="tab check" actData="channel=ershoufang"
										data-type="试试输入地铁线/站在地铁附近找房，如 13号线" formact="/ershoufang/rs">
										<span>找二手房</span>
									</li>
									<li class="tab " actData="channel=xinfang"
										data-type="请输入楼盘名称开始找房" formact="/loupan/rs">
										<span>找新房</span>
									</li>
									<li class="tab " actData="channel=zufang"
										data-type="请输入区域、商圈或小区名开始找房" formact="/zufang/rs">
										<span>找租房</span>
									</li>
									<li class="tab " actData="channel=xiaoqu"
										data-type="请输入小区名开始查找小区" formact="/xiaoqu/rs">
										<span>找小区</span>
									</li>
									<li class="tab " actData="channel=wenda"
										data-type="房产知识有疑问？来搜搜吧~" formact="/wenda/rs">
										<span>搜问答</span>
									</li>
								</ul>
								<i></i>
							</div>
							<div class="search clear">
								<div class="box">
									<div class="clear searchBox" data-action='/ershoufang/rs'>
										<input class="text left txt searchVal" name="keyword"
											autocomplete="off" placeholder="试试输入地铁线/站在地铁附近找房，如 13号线"
											id="keyword-box">
										<input class="btn home-ico ico-search left" id="findHouse"
											type="button" value="开始找房" daty-id="110000">
										<div id="userNews" class="savesearch"></div>
									</div>
									<div id="suggest-cont" class="suggest-wrap" data-bl="sug"
										data-el="sug"></div>
								</div>
								<div class="sug-tips">
									<ul id="ershoufang" data-bl="sug" data-el="history">
										<li class="hot-name">
											<span class="hot-tips">热门搜索</span><span class="del">清空</span>
										</li>
										<div class="list">
											<li>
												<a href="https://bj.lianjia.com/ershoufang/c1111027381003/"
													data-log_index="1" data-log_value="新龙城">新龙城</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/ershoufang/tiantongyuan/"
													data-log_index="2" data-log_value="天通苑">天通苑</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/ershoufang/c1111027375945/"
													data-log_index="3" data-log_value="北京新天地">北京新天地</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/ershoufang/c1111027382209/"
													data-log_index="4" data-log_value="远洋山水">远洋山水</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/ershoufang/wangjing/"
													data-log_index="5" data-log_value="望京">望京</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/ershoufang/sq45/"
													data-log_index="6" data-log_value="北京像素">北京像素</a>
											</li>
											<li>
												<a
													href="https://bj.lianjia.com/ditiefang/li46107350s46107204/"
													data-log_index="7" data-log_value="草房站附近房源">草房站附近房源</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/ditiefang/li652/"
													data-log_index="8" data-log_value="13号线地铁">13号线地铁</a>
											</li>
										</div>
									</ul>
									<ul id="loupan" data-bl="sug" data-el="history">
										<li class="hot-name">
											<span class="hot-tips">推荐搜索</span><span class="del">清空</span>
										</li>
										<div class="list"></div>
									</ul>
									<ul id="zufang" data-bl="sug" data-el="history">
										<li class="hot-name">
											<span class="hot-tips">热门搜索</span><span class="del">清空</span>
										</li>
										<div class="list">
											<li>
												<a
													href="https://bj.lianjia.com/zufang/rs%E5%8C%97%E4%BA%AC%E5%83%8F%E7%B4%A0"
													data-log_index="1" data-log_value="北京像素">北京像素</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/zufang/huilongguan2"
													data-log_index="2" data-log_value="回龙观">回龙观</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/zufang/mudanyuan"
													data-log_index="3" data-log_value="牡丹园">牡丹园</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/zufang/qinghe11/"
													data-log_index="4" data-log_value="清河">清河</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/ditiezufang/li649s20598/"
													data-log_index="5" data-log_value="天通苑">天通苑</a>
											</li>
											<li>
												<a
													href="https://bj.lianjia.com/ditiezufang/li46107350s46107139/"
													data-log_index="6" data-log_value="青年路">青年路</a>
											</li>
										</div>
									</ul>
									<ul id="xiaoqu" data-bl="sug" data-el="history">
										<li class="hot-name">
											<span class="hot-tips">热门搜索</span><span class="del">清空</span>
										</li>
										<div class="list">
											<li>
												<a href="https://bj.lianjia.com/xiaoqu/1111027382209/"
													data-log_index="1" data-log_value="远洋山水">远洋山水</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/xiaoqu/1111027375357/"
													data-log_index="2" data-log_value="后现代城">后现代城</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/xiaoqu/1111027378998/"
													data-log_index="3" data-log_value="荣丰2008">荣丰2008</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/xiaoqu/1111027380054/"
													data-log_index="4" data-log_value="天通西苑三区 ">天通西苑三区 </a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/xiaoqu/1111027378713/"
													data-log_index="5" data-log_value="苹果社区">苹果社区</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/xiaoqu/1111027375158/"
													data-log_index="6" data-log_value="华贸城">华贸城</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/xiaoqu/1111027380057/"
													data-log_index="7" data-log_value="天通苑中苑">天通苑中苑</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/xiaoqu/1111027375945/"
													data-log_index="8" data-log_value="北京新天地">北京新天地</a>
											</li>
										</div>
									</ul>
									<ul id="wenda" data-bl="sug" data-el="history">
										<li class="hot-name">
											<span class="hot-tips">热门搜索</span><span class="del">清空</span>
										</li>
										<div class="list">
											<li>
												<a href="https://bj.lianjia.com/wenda/liebiao/b2001"
													data-log_index="1" data-log_value="税费计算">税费计算</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/wenda/liebiao/b2004"
													data-log_index="2" data-log_value="过户流程">过户流程</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/wenda/liebiao/b1002"
													data-log_index="3" data-log_value="购房建议">购房建议</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/wenda/liebiao/b1003"
													data-log_index="4" data-log_value="购房资质">购房资质</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/wenda/liebiao/b5004"
													data-log_index="5" data-log_value="住房公积金">住房公积金</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/wenda/liebiao/b1005"
													data-log_index="6" data-log_value="二手房">二手房</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/wenda/liebiao/b5003"
													data-log_index="7" data-log_value="贷款流程">贷款流程</a>
											</li>
											<li>
												<a href="https://bj.lianjia.com/wenda/liebiao/b1001"
													data-log_index="8" data-log_value="房价行情">房价行情</a>
											</li>
										</div>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="wrap-video">
					<!--<div class="video-open"><img src="https://s1.ljcdn.com/feroot/pc/asset/img/home/icon_play.png?_v=20170630110651" alt="掌上链家, 开启移动找房之旅">链家APP, 开启移动找房之旅</div>-->
					<div class="pen">
						<a href="https://page.lianjia.com/subject/11276.html"
							rel="nofollow"><img
								src="https://image1.ljcdn.com/materials/list/2016-08-17/php3X11MP.png">关于仿冒我公司进行不正当竞争行为的郑重声明</a>
					</div>
					<div class="pen">
						<a href="https://page.lianjia.com/subject/8334.html"
							rel="nofollow"><img
								src="https://image1.ljcdn.com/materials/list/2016-06-29/phpAPdvEm.png">房地产中介诚信服务承诺及保证书</a>
					</div>
				</div>
			</div>
		</div>
		<div class="home-nav">
			<ul class="count-4">
				<li class="hvr-bob">
					<a href="/ershoufang/"><img
							src="https://image1.ljcdn.com/materials/list/2016-11-23/phpe022WE.png"><b>找二手房</b>
						<p>
							真实二手房源，链家承诺真实在售所见即真
						</p> </a>
				</li>
				<li class="hvr-bob">
					<a href="/xinfang/"><img
							src="https://image1.ljcdn.com/materials/list/2017-03-21/php6ifmLs.png"><b>找新房</b>
						<p>
							全新房屋，全新生活，给您满意的优质新盘
						</p> </a>
				</li>
				<li class="hvr-bob">
					<a href="/ditu/"><img
							src="https://image1.ljcdn.com/materials/list/2016-07-21/php4TtmtO.png"><b>地图找房</b>
						<p>
							为您精准定位，位置周边配套设施一览无余
						</p> </a>
				</li>
				<li class="hvr-bob">
					<a href="yezhu/gujia/"><img
							src="https://image1.ljcdn.com/materials/list/2017-02-16/phphnmv10.png"><b>房屋估价</b>
						<p>
							基于海量成交数据，帮您合理定价预估市值
						</p> </a>
				</li>
			</ul>
		</div>
		<div class="hand-lianjia">
			<div class="wrapper">
				<div class="fl">
					<div class="titles"></div>
					<p>
						集二手、新房、租房功能于一体，随时随地任性找房。IM匿名咨询让您放心，消息动态推送让您省心，服务承诺让您安心，数据百科锦囊让您感受贴心漫漫找房路，我们努力为您想更多。
					</p>
					<div class="download">
						<div class="hand-app">
							<a href="https://itunes.apple.com/cn/app/id405882753?mt=8"
								class="ios" target="_blank" rel="nofollow"></a><a
								href="https://m.lianjia.com/download/lianjia?utm_source=_lianjia_zhilian_pc&utm_medium=&platform=pc&cid="
								class="android" rel="nofollow"></a>
						</div>
						<div class="erweima" style="background: none;">
							<img style="width: 100%;"
								src="//ajax.api.lianjia.com/qr/getDownloadQr?location=site_middle&ljweb_channel_key=site_index">
						</div>
						<div class="video-img-btn" style="display: none;">
							<div class="video-img-btn-bg"></div>
							<div class="video-btn-normal"></div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="fr phone"></div>
			</div>
		</div>
		<div class="new-house">
			<div class="wrapper">
				<div class="fl">
					<div class="name"></div>
					<p>
						真实信息准确同步，楼盘动态一手掌握
						<a href="http://bj.fang.lianjia.com/loupan/" target="_blank">更多北京新房</a>
					</p>
				</div>
				<div class="newhose-list">
	                <ul>
	                   	<li>
	                      <a href="http://bj.fang.lianjia.com/loupan/p_ygcjzfabemd/">
	                            <img src="https://image1.ljcdn.com/xf-resblock/8303e53d-7bb0-411a-a986-53a51b8ff0b7.gif.510x300.jpg" alt="阳光城京兆府">
	                            <div class="bg"></div>
	                       		<div class="title">阳光城京兆府<span><label>1400</label>万/套</span></div>
	                            <div class="title01"><span title="潞西路与兴光二街交汇处">潞西路与兴光二街交汇处</span>/ 130平米-130平米</div>
	                            
	                      </a>
	                   </li>
	                   <li>
	                      <a href="http://bj.fang.lianjia.com/loupan/p_bkjthlchyzaawbe/">
                                <img src="https://image1.ljcdn.com/xf-resblock/0021e33e-6582-4f80-9e04-01eca9a90a6d.jpg.510x300.jpg" alt="北科建泰禾丽春湖院子">
                                <div class="bg"></div>
                                <div class="title">北科建泰禾丽春湖院子<span><label>68000</label>元/平</span></div>
                                <div class="title01"><span title="地铁沙河站向南800米处">地铁沙河站向南800米处</span>/ 379平米-800平米</div> 
	                      </a>
	                   </li>
	                   <li>
	                      <a href="http://bj.fang.lianjia.com/loupan/p_zjxstjabegy/">
                                <img src="https://image1.ljcdn.com/xf-resblock/9fa05f6d-87ca-4954-ad31-1ba147b95c27.jpg.510x300.jpg" alt="中骏西山天璟">
                                <div class="bg"></div>
                    			<div class="title">中骏西山天璟<span><label>70000</label>元/平</span></div>
                                <div class="title01"><span title="龙泉镇城子大街东侧">龙泉镇城子大街东侧</span>/ 102平米-155平米</div>
	                   	 </a>
	                   </li>
	                </ul>
				</div>
			</div>
		</div>
		<div class="ershoufang" style="display: block;">
			<div class="wrapper">
				<div class="fl">
					<div class="name"></div>
					<p>
						好房源那么多，我们为你精选，链家网会越来越懂你
						<a href="/ershoufang/">更多北京二手房</a>
					</p>
				</div>
				<div class="clear"></div>
				<ul>
					<li>
						<a href="https://bj.lianjia.com/ershoufang/101101728865.html"
							target="_blank"> <img
								src="https://image1.ljcdn.com/110000-inspection/27d55fd6-e8b8-48a9-9eed-258547796b4c.JPG.280x210.jpg"
								alt="商品房 塔楼电梯两居室 西南朝向"> <span class="price">420万</span>
							<div class="bottom">
								<p class="p01">
									商品房 塔楼电梯两居室 西南朝向
								</p>
								<div class="tips">
									<span class="ico"></span>
									<p>
										<span>商品房 塔楼电梯两居室 西南朝向</span>
										<span>2室1厅</span>
										<span>106.1平米</span>
									</p>
									<label></label>
								</div>
							</div> 
						</a>
					</li>
					<li>
						<a href="https://bj.lianjia.com/ershoufang/101101715462.html"
							target="_blank"> <img
								src="https://image1.ljcdn.com/110000-inspection/8e43b646-8d46-4b70-8e60-20c0a44f66ae.jpg.280x210.jpg"
								alt="南北通透 精装5+6复式 看房方便"> <span class="price">755万</span>
							<div class="bottom">
								<p class="p01">
									南北通透 精装5+6复式 看房方便
								</p>
								<div class="tips">
									<span class="ico"></span>
									<p>
										<span>南北通透 精装5+6复式 看房方便</span>
										<span>5室2厅</span>
										<span>229.73平米</span>
									</p>
									<label></label>
								</div>
							</div> </a>
					</li>
					<li>
						<a href="https://bj.lianjia.com/ershoufang/101101689637.html"
							target="_blank"> <img
								src="https://image1.ljcdn.com/110000-inspection/e6402c35-9141-4237-8f06-be0338d16b9b.JPG.280x210.jpg"
								alt="商品房  首付180万  通透两居  位置安静"> <span class="price">405万</span>
							<div class="bottom">
								<p class="p01">
									商品房 首付180万 通透两居 位置安静
								</p>
								<div class="tips">
									<span class="ico"></span>
									<p>
										<span>商品房 首付180万 通透两居 位置安静</span>
										<span>2室1厅</span>
										<span>83.38平米</span>
									</p>
									<label></label>
								</div>
							</div> </a>
					</li>
					<li>
						<a href="https://bj.lianjia.com/ershoufang/101101697803.html"
							target="_blank"> <img
								src="https://image1.ljcdn.com/110000-inspection/c9b21997-c89d-4fd0-afeb-fac45a90e9d9.jpg.280x210.jpg"
								alt="万象新天二区 小区中间板楼 南北通透 大三居 有钥匙"> <span class="price">864万</span>
							<div class="bottom">
								<p class="p01">
									万象新天二区 小区中间板楼 南北通透 大三居 有钥匙
								</p>
								<div class="tips">
									<span class="ico"></span>
									<p>
										<span>万象新天二区 小区中间板楼 南北通透 大三居 有钥匙</span>
										<span>3室2厅</span>
										<span>135.17平米</span>
									</p>
									<label></label>
								</div>
							</div> </a>
					</li>
					<div class="clear"></div>
				</ul>
			</div>
		</div>
		<div class="s-truth">
			<div class="wrapper">
				<div class="fl">
					<div class="truth-txt"></div>
				</div>
				<div class="truth-search">
					<p>
						真实存在，真实在售，真实价格，真实图片！
						<br>
						SaleHome郑重向用户承诺：真实房源，假一赔百元！
					</p>
					<div class="input-group">
						<input type="text" class="form-control input-lg"><span class="input-group-addon btn btn-primary">搜索</span>
					</div>
				</div>
			</div>
		</div>
		<div class="overlayBg"></div>
		<div class="footer">
			<div class="wrapper">
				<div class="f-title">
					<div class="fl">
						<ul>
							<li>
								<a href="https://www.lianjia.com/zhuanti/home/" rel="nofollow"
									target="_blank">了解链家</a>
							</li>
							<li>
								<a href="https://bj.lianjia.com/about/aboutlianjia/"
									rel="nofollow" target="_blank">关于链家</a>
							</li>
							<li>
								<a href="https://bj.lianjia.com/about/contactus/" rel="nofollow"
									target="_blank">联系我们</a>
							</li>
							<li>
								<a href="https://join.lianjia.com/" rel="nofollow"
									target="_blank">加入我们</a>
							</li>
							<li>
								<a href="https://www.lianjia.com/privacy/" rel="nofollow"
									target="_blank">隐私声明</a>
							</li>
							<li>
								<a href="https://bj.lianjia.com/sitemap/" target="_blank">网站地图</a>
							</li>
							<li>
								<a href="https://www.lianjia.com/notice/7.html" rel="nofollow"
									target="_blank">友情链接</a>
							</li>
							<li>
								<a href="https://agent.lianjia.com/" rel="nofollow"
									target="_blank">经纪人登录</a>
							</li>
						</ul>
					</div>
					<div class="fr">
						官方客服 176-0767-5702
					</div>
				</div>
				<div class="lianjia-link-box">
					<div class="fl">
						<div class="tab">
							<span class="hover">城市二手房</span><span>商圈二手房</span><span>商圈租房</span><span>商圈小区</span><span>热门小区</span><span>小区二手房</span><span>小区租房</span><span>新房</span><span>百科</span><span>租房</span><span>小区</span><span>问答</span><span>合作与友情链接</span>
						</div>
						<div class="link-list">
							<div>
								<dd>
									<a target="_blank" href="https://bj.lianjia.com/ershoufang/">北京二手房</a><a
										target="_blank" href="https://gz.lianjia.com/ershoufang/">广州二手房</a><a
										target="_blank" href="https://sz.lianjia.com/ershoufang/">深圳二手房</a><a
										target="_blank" href="https://tj.lianjia.com/ershoufang/">天津二手房</a><a
										target="_blank" href="https://cd.lianjia.com/ershoufang/">成都二手房</a><a
										target="_blank" href="https://nj.lianjia.com/ershoufang/">南京二手房</a><a
										target="_blank" href="https://hz.lianjia.com/ershoufang/">杭州二手房</a><a
										target="_blank" href="https://qd.lianjia.com/ershoufang/">青岛二手房</a><a
										target="_blank" href="https://dl.lianjia.com/ershoufang/">大连二手房</a><a
										target="_blank" href="https://xm.lianjia.com/ershoufang/">厦门二手房</a><a
										target="_blank" href="https://wh.lianjia.com/ershoufang/">武汉二手房</a><a
										target="_blank" href="https://cq.lianjia.com/ershoufang/">重庆二手房</a><a
										target="_blank" href="https://cs.lianjia.com/ershoufang/">长沙二手房</a><a
										target="_blank" href="https://jn.lianjia.com/ershoufang/">济南二手房</a><a
										target="_blank" href="https://fs.lianjia.com/ershoufang/">佛山二手房</a><a
										target="_blank" href="https://dg.lianjia.com/ershoufang/">东莞二手房</a><a
										target="_blank" href="https://yt.lianjia.com/ershoufang/">烟台二手房</a><a
										target="_blank" href="https://zs.lianjia.com/ershoufang/">中山二手房</a><a
										target="_blank" href="https://zh.lianjia.com/ershoufang/">珠海二手房</a><a
										target="_blank" href="https://hui.lianjia.com/ershoufang/">惠州二手房</a><a
										target="_blank" href="https://sy.lianjia.com/ershoufang/">沈阳二手房</a><a
										target="_blank" href="https://hf.lianjia.com/ershoufang/">合肥二手房</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank"
										href="https://bj.lianjia.com/ershoufang/dongcheng/">东城二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/xicheng/">西城二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/chaoyang/">朝阳二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/haidian/">海淀二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/fengtai/">丰台二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/shijingshan/">石景山二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/tongzhou/">通州二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/changping/">昌平二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/daxing/">大兴二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/yizhuangkaifaqu/">亦庄开发区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/shunyi/">顺义二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/fangshan/">房山二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/mentougou/">门头沟二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/pinggu/">平谷二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/huairou/">怀柔二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/miyun/">密云二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/yanqing/">延庆二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/yanjiao/">燕郊二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/pingguqita1/">平谷其它二手房</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank"
										href="https://bj.lianjia.com/zufang/dongcheng/">东城租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/xicheng/">西城租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/chaoyang/">朝阳租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/haidian/">海淀租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/fengtai/">丰台租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/shijingshan/">石景山租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/tongzhou/">通州租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/changping/">昌平租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/daxing/">大兴租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/yizhuangkaifaqu/">亦庄开发区租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/shunyi/">顺义租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/fangshan/">房山租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/mentougou/">门头沟租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/pinggu/">平谷租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/huairou/">怀柔租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/miyun/">密云租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/yanqing/">延庆租房</a><a
										target="_blank" href="https://bj.lianjia.com/zufang/yanjiao/">燕郊租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/pingguqita1/">平谷其它租房</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank"
										href="https://bj.lianjia.com/xiaoqu/dongcheng/">东城小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/xicheng/">西城小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/chaoyang/">朝阳小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/haidian/">海淀小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/fengtai/">丰台小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/shijingshan/">石景山小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/tongzhou/">通州小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/changping/">昌平小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/daxing/">大兴小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/yizhuangkaifaqu/">亦庄开发区小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/shunyi/">顺义小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/fangshan/">房山小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/mentougou/">门头沟小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/pinggu/">平谷小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/huairou/">怀柔小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/miyun/">密云小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/yanqing/">延庆小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/yanjiao/">燕郊小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/madian1/">马甸小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/haidianqita1/">海淀其它小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/anningzhuang1/">安宁庄小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/xiaoxitian1/">小西天小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/xibeiwang/">西北旺小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/erlizhuang/">二里庄小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/wanshoulu1/">万寿路小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/changpingqita1/">昌平其它小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/yiheyuan/">颐和园小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/weigongcun/">魏公村小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/xinjiekou2/">新街口小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/aolinpikegongyuan11/">奥林匹克公园小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/xizhimen1/">西直门小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/xisanqi1/">西三旗小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/haidianbeibuxinqu1/">海淀北部新区小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/mudanyuan/">牡丹园小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/liuliqiao1/">六里桥小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/changwa/">厂洼小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/baishiqiao1/">白石桥小区</a><a
										target="_blank" href="https://bj.lianjia.com/xiaoqu/xishan21/">西山小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/suzhouqiao/">苏州桥小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/zaojunmiao/">皂君庙小区</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027379008/">日光清城</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027377206/">久敬佳园二区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027374770/">贵园北里戊区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027377014/">嘉诚花园一期</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027382549/">紫荆园</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027377185/">加华印象街</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027382508/">珠江国际城八区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027377474/">金星小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027382044/">原生墅</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027377282/">京贸国际城东区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027375520/">鸿业兴园二区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027380846/">新华联家园北区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027378166/">龙兴园中区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027375275/">红狮家园</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027382518/">珠江骏景南区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027375178/">黄南苑</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027381626/">一幅画卷</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027373790/">东木樨园</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027381543/">益辰欣园</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027379471/">石榴园北里小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027376997/">金榜园</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027375772/">北店嘉园</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027378434/">梅园小区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027378991/">瑞都国际北区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027379371/">世纪星城三期</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027378379/">美然动力A1区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027378589/">南三环中路</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027374699/">格瑞雅居</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027376259/">北苑家园绣菊园南区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027378718/">苹果园小区一区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027375049/">慧华苑</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027379209/">四方景园二区</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027376258/">北苑家园绣菊园</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027379379/">双锦园</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027378372/">苗圃东里</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027375918/">北郊农场宿舍</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027382170/">迎曦园</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027379621/">水仙园</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027380820/">新华街六里</a><a
										target="_blank"
										href="https://bj.lianjia.com/xiaoqu/1111027373922/">德胜置业</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111040862971/">建安里小区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111051923036/">剧场东街二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027376515/">和平街东里二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027379600/">双兴东区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111045965035/">长景新园二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027382654/">中体奥林匹克花园三期二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027374435/">福苑小区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027379605/">顺鑫花语二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027378834/">前进花园石门苑二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027379160/">首都机场南路西里二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027378827/">清和园东区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111062908246/">融科千章墅二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027380626/">新潮嘉园二期二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111055267995/">东环路小区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111046524965/">万源北路7号院二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027378160/">龙禧苑二区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111046316550/">中铁花溪渡二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027375839/">滨河东里二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111041899696/">金隅丽景园二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027380624/">新翠景园二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027379015/">瑞海家园三区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027376566/">昌盛园三区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027378804/">群芳园二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111047836724/">金隅万科城悦嘉公寓二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027379774/">天赐良园二期二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027374503/">古城北路二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027378309/">名佳花园四区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027378111/">龙腾苑六区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027378659/">南苑北里二区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027381818/">云景西里南区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111046766909/">云立方二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027374915/">海德堡花园二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111054696058/">金隅观澜时代二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027375964/">巴克寓所二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027375618/">阿凯笛亚庄园二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027380607/">新城东里二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027374043/">东一时区二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027378398/">模式口东里二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027382759/">枣园尚城二手房</a><a
										target="_blank"
										href="https://bj.lianjia.com/ershoufang/c1111027379566/">三山新新家园二手房</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027382655/">中体奥林匹克花园一期租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111063222181/">格林云墅租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027375291/">鸿顺园东区租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111053028263/">城子西街1号院租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027379646/">双裕花园西区租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027381517/">样本租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111041779491/">燕城北苑租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111052080245/">桥东街小区租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111063030340/">南厂住宅中区租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027377819/">绿丰家园租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027381444/">兴政东里租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027379022/">润杰经典创新园租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111053082037/">城子大街132号院租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111053224604/">昌盛园四区租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027378060/">蓝山国际公寓租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111046029079/">双峪路小区租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027374977/">恒富中街6号院租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111055657244/">北关东路社区租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027373835/">都市芳园丽湖园租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111042960592/">康庄中巷4号院租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027380636/">兴城丽源租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111041140250/">果岭小镇租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111056054668/">宜山居租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027379799/">通达园租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027378112/">龙腾苑四区租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111053495276/">禾香雅园租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027378179/">丽园东里租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027377804/">龙鼎园租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027379468/">上林苑租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027381675/">阳光水岸租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027381936/">燕平家园租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027376036/">北平里租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027379826/">天恒花园租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027377476/">景欣园租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027379017/">瑞海家园一区租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027378114/">龙腾苑五区租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027375926/">北京人家租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027381234/">馨通家园租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027377304/">京贸中心租房</a><a
										target="_blank"
										href="https://bj.lianjia.com/zufang/c1111027381797/">云景里南大门租房</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank"
										href="https://bj.fang.lianjia.com/loupan/dongcheng/">东城楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/xicheng/">西城楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/chaoyang/">朝阳楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/haidian/">海淀楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/fengtai/">丰台楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/shijingshan/">石景山楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/tongzhou/">通州楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/changping/">昌平楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/daxing/">大兴楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/yizhuangkaifaqu/">亦庄开发区楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/shunyi/">顺义楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/fangshan/">房山楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/mentougou/">门头沟楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/pinggu/">平谷楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/huairou/">怀柔楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/miyun/">密云楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/yanqing/">延庆楼盘</a><a
										target="_blank"
										href="https://bj.fang.lianjia.com/loupan/yanjiao/">燕郊楼盘</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank" href="https://news.lianjia.com/bj/baike">北京百科</a><a
										target="_blank" href="https://news.lianjia.com/gz/baike">广州百科</a><a
										target="_blank" href="https://news.lianjia.com/sz/baike">深圳百科</a><a
										target="_blank" href="https://news.lianjia.com/tj/baike">天津百科</a><a
										target="_blank" href="https://news.lianjia.com/cd/baike">成都百科</a><a
										target="_blank" href="https://news.lianjia.com/nj/baike">南京百科</a><a
										target="_blank" href="https://news.lianjia.com/hz/baike">杭州百科</a><a
										target="_blank" href="https://news.lianjia.com/qd/baike">青岛百科</a><a
										target="_blank" href="https://news.lianjia.com/dl/baike">大连百科</a><a
										target="_blank" href="https://news.lianjia.com/xm/baike">厦门百科</a><a
										target="_blank" href="https://news.lianjia.com/wh/baike">武汉百科</a><a
										target="_blank" href="https://news.lianjia.com/cq/baike">重庆百科</a><a
										target="_blank" href="https://news.lianjia.com/cs/baike">长沙百科</a><a
										target="_blank" href="https://news.lianjia.com/jn/baike">济南百科</a><a
										target="_blank" href="https://news.lianjia.com/fs/baike">佛山百科</a><a
										target="_blank" href="https://news.lianjia.com/xa/baike">西安百科</a><a
										target="_blank" href="https://news.lianjia.com/sjz/baike">石家庄百科</a><a
										target="_blank" href="https://news.lianjia.com/yt/baike">烟台百科</a><a
										target="_blank" href="https://news.lianjia.com/hf/baike">合肥百科</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank" href="https://bj.lianjia.com/zufang/">北京租房</a><a
										target="_blank" href="https://gz.lianjia.com/zufang/">广州租房</a><a
										target="_blank" href="https://sz.lianjia.com/zufang/">深圳租房</a><a
										target="_blank" href="https://tj.lianjia.com/zufang/">天津租房</a><a
										target="_blank" href="https://cd.lianjia.com/zufang/">成都租房</a><a
										target="_blank" href="https://nj.lianjia.com/zufang/">南京租房</a><a
										target="_blank" href="https://hz.lianjia.com/zufang/">杭州租房</a><a
										target="_blank" href="https://qd.lianjia.com/zufang/">青岛租房</a><a
										target="_blank" href="https://dl.lianjia.com/zufang/">大连租房</a><a
										target="_blank" href="https://xm.lianjia.com/zufang/">厦门租房</a><a
										target="_blank" href="https://wh.lianjia.com/zufang/">武汉租房</a><a
										target="_blank" href="https://cq.lianjia.com/zufang/">重庆租房</a><a
										target="_blank" href="https://cs.lianjia.com/zufang/">长沙租房</a><a
										target="_blank" href="https://jn.lianjia.com/zufang/">济南租房</a><a
										target="_blank" href="https://fs.lianjia.com/zufang/">佛山租房</a><a
										target="_blank" href="https://dg.lianjia.com/zufang/">东莞租房</a><a
										target="_blank" href="https://yt.lianjia.com/zufang/">烟台租房</a><a
										target="_blank" href="https://zs.lianjia.com/zufang/">中山租房</a><a
										target="_blank" href="https://zh.lianjia.com/zufang/">珠海租房</a><a
										target="_blank" href="https://hui.lianjia.com/zufang/">惠州租房</a><a
										target="_blank" href="https://sy.lianjia.com/zufang/">沈阳租房</a><a
										target="_blank" href="https://hf.lianjia.com/zufang/">合肥租房</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank" href="https://bj.lianjia.com/xiaoqu/">北京小区二手房</a><a
										target="_blank" href="https://gz.lianjia.com/xiaoqu/">广州小区二手房</a><a
										target="_blank" href="https://sz.lianjia.com/xiaoqu/">深圳小区二手房</a><a
										target="_blank" href="https://tj.lianjia.com/xiaoqu/">天津小区二手房</a><a
										target="_blank" href="https://cd.lianjia.com/xiaoqu/">成都小区二手房</a><a
										target="_blank" href="https://nj.lianjia.com/xiaoqu/">南京小区二手房</a><a
										target="_blank" href="https://hz.lianjia.com/xiaoqu/">杭州小区二手房</a><a
										target="_blank" href="https://qd.lianjia.com/xiaoqu/">青岛小区二手房</a><a
										target="_blank" href="https://dl.lianjia.com/xiaoqu/">大连小区二手房</a><a
										target="_blank" href="https://xm.lianjia.com/xiaoqu/">厦门小区二手房</a><a
										target="_blank" href="https://wh.lianjia.com/xiaoqu/">武汉小区二手房</a><a
										target="_blank" href="https://cq.lianjia.com/xiaoqu/">重庆小区二手房</a><a
										target="_blank" href="https://cs.lianjia.com/xiaoqu/">长沙小区二手房</a><a
										target="_blank" href="https://jn.lianjia.com/xiaoqu/">济南小区二手房</a><a
										target="_blank" href="https://fs.lianjia.com/xiaoqu/">佛山小区二手房</a><a
										target="_blank" href="https://dg.lianjia.com/xiaoqu/">东莞小区二手房</a><a
										target="_blank" href="https://yt.lianjia.com/xiaoqu/">烟台小区二手房</a><a
										target="_blank" href="https://zs.lianjia.com/xiaoqu/">中山小区二手房</a><a
										target="_blank" href="https://zh.lianjia.com/xiaoqu/">珠海小区二手房</a><a
										target="_blank" href="https://hui.lianjia.com/xiaoqu/">惠州小区二手房</a><a
										target="_blank" href="https://sy.lianjia.com/xiaoqu/">沈阳小区二手房</a><a
										target="_blank" href="https://hf.lianjia.com/xiaoqu/">合肥小区二手房</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank" href="https://bj.lianjia.com/wenda/">北京问答</a><a
										target="_blank" href="https://gz.lianjia.com/wenda/">广州问答</a><a
										target="_blank" href="https://sz.lianjia.com/wenda/">深圳问答</a><a
										target="_blank" href="https://tj.lianjia.com/wenda/">天津问答</a><a
										target="_blank" href="https://cd.lianjia.com/wenda/">成都问答</a><a
										target="_blank" href="https://nj.lianjia.com/wenda/">南京问答</a><a
										target="_blank" href="https://hz.lianjia.com/wenda/">杭州问答</a><a
										target="_blank" href="https://qd.lianjia.com/wenda/">青岛问答</a><a
										target="_blank" href="https://dl.lianjia.com/wenda/">大连问答</a><a
										target="_blank" href="https://cq.lianjia.com/wenda/">重庆问答</a><a
										target="_blank" href="https://cs.lianjia.com/wenda/">长沙问答</a><a
										target="_blank" href="https://jn.lianjia.com/wenda/">济南问答</a><a
										target="_blank" href="https://fs.lianjia.com/wenda/">佛山问答</a><a
										target="_blank" href="https://hf.lianjia.com/wenda/">合肥问答</a>
								</dd>
							</div>
							<div>
								<dd>
									<a target="_blank" href="http://www.mayi.com">短租房</a><a
										target="_blank" href="https://news.lianjia.com/bj/baike/">北京房产百科</a><a
										target="_blank" href="https://news.lianjia.com/bj/">北京房产新闻</a><a
										target="_blank" href="https://bj.lianjia.com/wenda/liebiao/">北京最新房产问答</a><a
										target="_blank" href="https://news.lianjia.com">房地产资讯</a><a
										target="_blank" href="http://www.shangceng.com.cn/">北京别墅设计</a><a
										target="_blank" href="http://www.zx123.cn/">装修网</a><a
										target="_blank" href="http://www.jieju.cn/">中洁网</a><a
										target="_blank" href="http://beijing.anjuke.com/">北京房产网</a><a
										target="_blank" href="http://www.aiuw.com/">装修网</a><a
										target="_blank" href="http://club.meilele.com/">装修论坛</a><a
										target="_blank" href="http://www.leleju.com/">乐乐居装修网</a><a
										target="_blank" href="http://bj.house.sina.com.cn/">北京房产</a><a
										target="_blank" href="http://www.rong360.com/">贷款</a><a
										target="_blank" href="http://gz.ganji.com/">广州赶集网</a><a
										target="_blank" href="http://www.zhifang.com/">智房旅游地产</a><a
										target="_blank" href="http://hangzhou.fangtoo.com">杭州房产网</a><a
										target="_blank" href="http://bj.jiwu.com/">北京买房网</a><a
										target="_blank" href="http://beijing.tianqi.com/">北京天气</a><a
										target="_blank" href="http://www.bidcenter.com.cn/">中国采招网</a><a
										target="_blank" href="http://www.zxdyw.com/">装修网</a><a
										target="_blank" href="http://www.jc001.cn/">建材网</a><a
										target="_blank" href="http://www.17house.com/">家装</a><a
										target="_blank" href="http://home.fang.com/">北京装修</a><a
										target="_blank" href="http://sh.focus.cn/">上海房产</a><a
										target="_blank" href="http://www.bzw315.com/">装修</a><a
										target="_blank" href="http://jzb.com/bbs/bj/">北京家长帮</a><a
										target="_blank" href="http://www.homekoo.com/">家具网</a><a
										target="_blank" href="http://www.kujiale.com/">装修设计软件</a><a
										target="_blank" href="http://beijing.edeng.cn/">北京分类信息网</a><a
										target="_blank" href="http://www.jiuzheng.com/">家居</a><a
										target="_blank" href="http://jiaju.sina.com.cn/">装修</a><a
										target="_blank" href="http://www.jiancai365.cn">中国建材网</a><a
										target="_blank" href="http://www.qj.com.cn/">前景加盟网</a><a
										target="_blank" href="http://www.zjtcn.com/">工程造价</a><a
										target="_blank" href="http://shenzhen.qfang.com/">深圳房产网</a><a
										target="_blank" href="http://m.lianjia.com/">手机房产网</a><a
										target="_blank" href="http://www.xtuan.com/">装修网</a>
								</dd>
							</div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="bottom">
					<div class="copyright fl">
						北京链家房地产经纪有限公司 | 网络经营许可证 京ICP备11024601号-12 | © Copyright©2010-2017
						链家网Lianjia.com版权所有
					</div>
				</div>
			</div>
		</div>

		<!-- 视频入口浮层 -->
		<div class="video-box">
			<div class="video-bg"></div>
			<div class="video-embed">
				<div class="video-title">
					链家APP·开启移动找房之旅!
					<span class="video-app-download"><a
						href="//www.lianjia.com/client/" target="_blank" rel="nofollow"><img
								src="https://s1.ljcdn.com/feroot/pc/asset/img/video-entrance/video-logo-appV2.png?_v=20170630110651"
								class="video-logo-app"><span>马上去下载</span> </a> </span>
				</div>
				<embed src="//static.video.qq.com/TPout.swf?vid=k0172rnl5o4&auto=0"
					allowFullScreen="true" quality="high" width="650" height="455"
					align="middle" allowScriptAccess="always"
					type="application/x-shockwave-flash" flashvars="autoplay=1&amp;"></embed>
				<img class="video-close"
					src="https://s1.ljcdn.com/feroot/pc/asset/img/video-entrance/video-close.png?_v=20170630110651"
					alt="关闭" />
			</div>
		</div>
		<script
			src="https://s1.ljcdn.com/feroot/pc/asset/base/fe.js?_v=20170630110651"></script>
		<script
			src="https://s1.ljcdn.com/feroot/pc/asset/common/common.js?_v=20170630110651"></script>
		<div style="display: none">
			<script
				src="https://s1.ljcdn.com/feroot/dep/ljanalytics.js?_v=20170630110651"></script>
		</div>
		<div id="only" data-city="bj" data-page="site_index"></div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h3 class="modal-title" id="myModalLabel">
								用户登录
					</h3>
				</div>
				<div class="modal-body">
	                  <form class="form-horizontal">
						<div class="form-group" style="margin-left:280px">
						 	  <label class="text">还没有SaleHome账号？<a href="javascript:void(0);">忘记密码</a></label>
						</div>
	                      <div class="form-group">
	                          <input type="email" class="form-control" id="inputEmail3" placeholder="用户名或电子邮件">
	                          <i class="fa fa-user"></i>
	                      </div>
	                      <div class="form-group help">
	                          <input type="password" class="form-control" id="inputPassword3" placeholder="密　码">
	                          <i class="fa fa-lock"></i>
	                          <a href="#" class="fa fa-question-circle"></a>
	                      </div>
	                      <div class="form-group">
	                          <div class="main-checkbox">
	                              <input type="checkbox" value="None" id="checkbox1" name="check"/>
	                              <label for="checkbox1"></label>
	                          </div>
	                          <label class="text">记住密码</label>
	                          <button type="submit" class="btn btn-default">登录</button>
	                      </div>
	                  </form>
			    </div>
			</div>
		</div>
	</div>
		<script src="https://zz.bdstatic.com/linksubmit/push.js"></script>
		<script type="text/javascript" async=""
			src="https://s1.ljcdn.com/feroot/pc/asset/common/advert.js?_v=20170630110651"></script>
		<script type="text/javascript" async="" charset="utf-8"
			src="https://c.cnzz.com/core.php?web_id=1255633284&amp;t=q"></script>
		<script type="text/javascript" async="" charset="utf-8"
			src="https://c.cnzz.com/core.php?web_id=1254525948&amp;t=q"></script>
		<script type="text/javascript" async="" charset="utf-8"
			src="https://c.cnzz.com/core.php?web_id=1253477573&amp;t=q"></script>
		<script type="text/javascript" async=""
			src="https://static-ssl.mediav.com/mv.js"></script>
		<script type="text/javascript" async=""
			src="https://material-ssl.mediav.com/bjjs/mba.js"></script>
		<script type="text/javascript" async=""
			src="https://static-ssl.mediav.com/mvl.js"></script>
		<script async="" src="//www.google-analytics.com/analytics.js"></script>
		<script type="text/javascript" async=""
			src="https://cdnmaster.com/sitemaster/collect.js"></script>
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://s1.ljcdn.com/web-im-sdk/static/0.9/ljim-core.min.js?_v=20170706"></script>
		<script>
		var path = 'https://s1.ljcdn.com/feroot/pc/asset?_v=20170630110651'
				.split("?");
		require.config({
			baseUrl : path[0],
			paths : {
				'echarts' : '../../dep/echarts-1.4.1/build/echarts',
				'echarts/chart/bar' : '../../dep/echarts-1.4.1/build/echarts',
				'echarts/chart/line' : '../../dep/echarts-1.4.1/build/echarts',
				'echarts/chart/pie' : '../../dep/echarts-1.4.1/build/echarts',
				'echarts3' : '../../dep/echarts3/echarts3',
				'common' : 'common',
				'jquery-ui' : '../../dep/jquery-ui/jquery-ui.min',
				'zeroclipboard' : '../../dep/zeroclipboard-2.2.0/ZeroClipboard'
			},
			urlArgs : path[1]
		});
		var feData = {
			"cityName" : "北京",
			"getFavHouseUrl" : "/api/gethousefav",
			"setFavHouseUrl" : "/api/sethousefav",
			"getLastSearch" : "/api/getlastsearch",
			"getCommunityHistory" : "/api/getcommunityhistory",
			"verifyHouse" : "/api/verifyHouse",
			"getUser" : "/api/getUser",
			"verifyCode" : "/api/getVerifyCode",
			"complaint" : "/api/complaint",
			"getDecoration" : "/api/getDecoration",
			"trendData" : "/site/getpicinfo"
		}
	</script>
		<script type="text/javascript">
		require([ 'index/main' ], function(main) {
			main.init({

			});
		});
		require(
				[ 'common/backtopV3' ],
				function(main) {
					main({
						ucid : '',
						uuid : '4dcd5cdd-d217-4efb-bf71-8341de157183',
						loadingImg : 'https://s1.ljcdn.com/feroot/pc/asset/ershoufang/sellDetail/img/loading.gif?_v=20170630110651',
						qrImg : '//ajax.api.lianjia.com/qr/getDownloadQr'
					});
				});
		$(".video-img-btn").hover(function() {
			$(".video-btn-normal").css("opacity", "1");
		}, function() {
			$(".video-btn-normal").css("opacity", "0.7");
		})
		$(".video-open,.video-img-btn").on("click", function() {
			$(".video-box").fadeIn(200);
		})
		$(".video-close").on("click", function() {
			$(".video-box").fadeOut(200);
		});

		;
		+function() {
			$(document.body).on(
					"mousedown",
					".search [data-bl='sug'] [data-log_value]",
					function() {
						var $m = $(this);
						var actionId = $m.closest('[data-bl="sug"]').attr(
								"data-el") === 'history' ? '10004' : '10003';
						LjUserTrack.send({
							"ljweb_id" : actionId,
							"ljweb_mod" : "site_index_search",
							"ljweb_bl" : "search",
							"ljweb_el" : $.trim($m.attr("data-log_value")),
							"ljweb_index" : $m.attr("data-log_index"),
							"ljweb_value" : $.trim($("#keyword-box").val()),
							"ljweb_url" : $m.attr("href")
						});

					});
		}();
	</script>
		<script>
		require([ 'common/suggestion' ], function(suggestion) {
			window.defaultSuggest = suggestion.init({
				requestOptions : {
					cityId : '110000',
					cityName : '北京'
				},
				url : '/api/headerSearch?channel=site&q=',
				main : '#keyword-box-01',
				appendTo : '#suggest-cont-01',
				redirect : true
			});
		});
	</script>
		<script>
		require([ 'common/suggestion' ], function(suggestion) {
			window.defaultSuggest = suggestion.init({
				requestOptions : {
					cityId : '110000',
					cityName : '北京'
				},
				url : '/api/headerSearch?channel=site&q=',
				main : '#keyword-box',
				appendTo : '#suggest-cont',
				redirect : true
			});
		});
	</script>
	<script>
	ljConf = {
		city_id : '110000',
		city_abbr : 'bj',
		city_name : '北京',
		channel : 'site',
		page : 'site_index',
		pageConfig : {
			"ajaxroot" : "\/\/ajax.api.lianjia.com\/",
			"imAppid" : "LIANJIA_WEB_20160624",
			"imAppkey" : "6dfdcee27d78b1107fceeca55d80b7bd"
		},
		feroot : '//s1.ljcdn.com/feroot/',
		ucid : '',
		cdn : '1',
	};
</script>	
</body>
</html>
