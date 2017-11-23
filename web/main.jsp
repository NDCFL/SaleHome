<%@page import="javax.persistence.criteria.CriteriaBuilder.In"%>
<%@page import="org.apache.commons.lang3.ClassUtils.Interfaces"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>SaleHome</title>
	<!-- Main CSS file -->
	<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css" />
	<link rel="stylesheet" href="<%=path %>/css/owl.carousel.css" />
	<link rel="stylesheet" href="<%=path %>/css/magnific-popup.css" />
	<link rel="stylesheet" href="<%=path %>/css/font-awesome.css" />
	<link rel="stylesheet" href="<%=path %>/css/style.css" />
	<link rel="stylesheet" href="<%=path %>/css/responsive.css" />
	<link rel="stylesheet" href="<%=path%>/homecss/login.css"/>
	<!-- Favicon -->
	<link rel="shortcut icon" href="<%=path %>/images/icon/favicon.png">
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=path %>/images/icon/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=path %>/images/icon/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=path %>/images/icon/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="<%=path %>/images/icon/apple-touch-icon-57-precomposed.png">
</head>
<body>
	<div id="st-preloader">
		<div id="pre-status">
			<div class="preload-placeholder"></div>
		</div>
	</div>
	<header id="header">
		<nav class="navbar st-navbar navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#st-navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
				    	<span class="icon-bar"></span>
				    	<span class="icon-bar"></span>
				    	<span class="icon-bar"></span>
					</button>
					<a href="<%=path %>/main.jsp" title="链家网"
						target="_self"><img src="<%=path%>/homeimage/logo.png"></a><span class="exchange" data-toggle="modal" data-target="#myModal1"><i></i>北京</span>
				</div>
				<div class="collapse navbar-collapse" id="st-navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
				    	<li><a href="#header">首页</a></li>
				    	<li><a class="" href="https://bj.lianjia.com/ershoufang/">二手房</a></li>
				    	<li><a href="#services">经验</a></li>
						<li><a class="" href="http://bj.fang.lianjia.com/">新房</a></li>
						<li><a class="" href="https://bj.lianjia.com/zufang/">租房</a></li>
						<li><a class="" href="https://us.lianjia.com/">海外</a></li>
						<li><a class="" href="https://bj.lianjia.com/xiaoqu/">小区</a></li>
						<li><a class="" href="https://bj.lianjia.com/jingjiren/">经纪人</a></li>
				    	<li><a href="https://bj.lianjia.com/tool.html?sub=0">工具</a></li>
				    	<li><a class="btn-login bounceIn actLoginBtn" href="javascript:void(0);" data-toggle="modal" data-target="#myModal"><span class="reg">登录</span></a> </li>
				    	<li><a href="<%=path%>/lr/gotoregirest"><span class="log">立即注册</span></a></li>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container -->
		</nav>
	</header>
	<!-- /HEADER -->


	<!-- SLIDER -->
	<section id="slider">
		<div id="home-carousel" class="carousel slide" data-ride="carousel">			
			<div class="carousel-inner">
				<div class="item active" style="background-image: url(<%=path %>/homeimage/bg1.jpg)">
					<div class="carousel-caption container">
						<div class="row">
							<div class="col-sm-7">
								<h1>You are entire </h1>
								<h2>creative world</h2>
								<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor. Aenean sollicitudin, lorem quis bibendum auctor.</p>
							</div>
						</div>
					</div>					
				</div>
				<div class="item" style="background-image: url(<%=path %>/homeimage/bg2.jpg)">
					<div class="carousel-caption container">
						<div class="row">
							<div class="col-sm-7">
								<h1>You are entire </h1>
								<h2>creative world</h2>
								<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor. Aenean sollicitudin, lorem quis bibendum auctor.</p>
							</div>
						</div>
					</div>					
				</div>
				<div class="item" style="background-image: url(<%=path %>/homeimage/bg4.jpg)">
					<div class="carousel-caption container">
						<div class="row">
							<div class="col-sm-7">
								<h1>You are entire </h1>
								<h2>creative world</h2>
								<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor. Aenean sollicitudin, lorem quis bibendum auctor.</p>
							</div>
						</div>
					</div>					
				</div>
				<div class="item" style="background-image: url(<%=path %>/homeimage/bg5.jpg)">
					<div class="carousel-caption container">
						<div class="row">
							<div class="col-sm-7">
								<h1>You are entire </h1>
								<h2>creative world</h2>
								<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor. Aenean sollicitudin, lorem quis bibendum auctor.</p>
							</div>
						</div>
					</div>					
				</div>
				<a class="home-carousel-left" href="#home-carousel" data-slide="prev"><i class="fa fa-angle-left"></i></a>
				<a class="home-carousel-right" href="#home-carousel" data-slide="next"><i class="fa fa-angle-right"></i></a>
			</div>		
		</div> <!--/#home-carousel--> 
    </section>
	<!-- /SLIDER -->

	
	<!-- SERVICES -->
	<section id="services">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-title">
						<h1>找房子</h1>
						<span class="st-border"></span>
					</div>
				</div>

				<div class="col-md-4 col-sm-6 st-service">
					<h2><i class="fa fa-desktop"></i> 环境优先</h2>
					<a href="javascipt:void(0);"><img class="img-responsive" src="<%=path %>/homeimage/1.jpg" alt=""></a>				</div>

				<div class="col-md-4 col-sm-6 st-service">
					<h2><i class="fa fa-cogs"></i>交通优先</h2>
					<a href="javascipt:void(0);"><img class="img-responsive" src="<%=path %>/homeimage/2.jpg" alt=""></a>				</div>

				<div class="col-md-4 col-sm-6 st-service">
					<h2><i class="fa fa-code"></i>低价优先</h2>
					<a href="javascipt:void(0);"><img class="img-responsive" src="<%=path %>/homeimage/3.jpg" alt=""></a>				</div>

				<div class="col-md-4 col-sm-6 st-service">
					<h2><i class="fa fa-dashboard"></i>教育优先</h2>
					<a href="javascipt:void(0);"><img class="img-responsive" src="<%=path %>/homeimage/4.jpg" alt=""></a>				</div>

				<div class="col-md-4 col-sm-6 st-service">
					<h2><i class="fa fa-life-ring"></i>精装房</h2>
					<a href="javascipt:void(0);"><img class="img-responsive" src="<%=path %>/homeimage/5.jpg" alt=""></a>				</div>

				<div class="col-md-4 col-sm-6 st-service">
					<h2><i class="fa fa-weixin"></i>裸房</h2>
					<a href="javascipt:void(0);"><img class="img-responsive" src="<%=path %>/homeimage/6.jpg" alt=""></a>				</div>
			</div>
		</div>
	</section>
	<!-- /SERVICES -->


	<!-- OUR WORKS -->
	<section id="our-works">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-title">
						<h1>新房新起航</h1>
						<span class="st-border"></span>
					</div>
				</div>

				<div class="portfolio-wrapper" >
					<div class="col-md-12">
						<ul class="filter">  			
							<li><a class="active" href="#" data-filter="*">楼盘一</a></li>	
							<li><a href="#" data-filter=".wordpress">楼盘一</a></li>
							<li><a href="#" data-filter=".html">楼盘一</a></li>
							<li><a href="#" data-filter=".graphic">楼盘一</a></li>
							<li><a href="#" data-filter=".php">楼盘一</a></li>
							<li><a href="#" data-filter=".bootstrap">楼盘一</a></li>
						</ul><!--/#portfolio-filter-->
					</div>
					
					<div class="portfolio-items">
						
						<div class="col-md-4 col-sm-6 work-grid wordpress graphic">
							<div class="portfolio-content">
								<img class="img-responsive" src="<%=path %>/homeimage/7.jpg" alt="">
								<div class="portfolio-overlay">
									<a href="images/works/portfolio-1.jpg"><i class="fa fa-camera-retro"></i></a>
									<h5>环境套房</h5>
									<p>卧室带阳台，卧室全南，交通方便，采光好</p>
									<span>南杨小区（长清路）</span>
									<span>1室1厅</span>
									<span>41.14平</span>
								</div>
							</div>	
						</div>
						
						<div class="col-md-4 col-sm-6 work-grid html php bootstrap">
							<div class="portfolio-content">
								<img class="img-responsive" src="<%=path %>/homeimage/8.jpg" alt="">
								<div class="portfolio-overlay">
									<a href="images/works/portfolio-2.jpg"><i class="fa fa-camera-retro"></i></a>
									<h5>环境套房</h5>
									<p>卧室带阳台，卧室全南，交通方便，采光好</p>
									<span>南杨小区（长清路）</span>
									<span>1室1厅</span>
									<span>41.14平</span>
								</div>
							</div>	
						</div>
						
						<div class="col-md-4 col-sm-6 work-grid wordpress graphic">
							<div class="portfolio-content">
								<img class="img-responsive" src="<%=path %>/homeimage/9.jpg" alt="">
								<div class="portfolio-overlay">
									<a href="images/works/portfolio-3.jpg"><i class="fa fa-camera-retro"></i></a>
									<h5>环境套房</h5>
									<p>卧室带阳台，卧室全南，交通方便，采光好</p>
									<span>南杨小区（长清路）</span>
									<span>1室1厅</span>
									<span>41.14平</span>
								</div>
							</div>	
						</div>
						
						<div class="col-md-4 col-sm-6 work-grid html php bootstrap">
							<div class="portfolio-content">
								<img class="img-responsive" src="<%=path %>/homeimage/10.jpg" alt="">
								<div class="portfolio-overlay">
									<a href="images/works/portfolio-4.jpg"><i class="fa fa-camera-retro"></i></a>
									<h5>环境套房</h5>
									<p>卧室带阳台，卧室全南，交通方便，采光好</p>
									<span>南杨小区（长清路）</span>
									<span>1室1厅</span>
									<span>41.14平</span>
								</div>
							</div>	
						</div>
						
						<div class="col-md-4 col-sm-6 work-grid wordpress graphic php">
							<div class="portfolio-content">
								<img class="img-responsive" src="<%=path %>/homeimage/3.jpg" alt="">
								<div class="portfolio-overlay">
									<a href="images/works/portfolio-5.jpg"><i class="fa fa-camera-retro"></i></a>
									<h5>环境套房</h5>
									<p>卧室带阳台，卧室全南，交通方便，采光好</p>
									<span>南杨小区（长清路）</span>
									<span>1室1厅</span>
									<span>41.14平</span>
								</div>
							</div>	
						</div>
						
						<div class="col-md-4 col-sm-6 work-grid html bootstrap graphic">
							<div class="portfolio-content">
								<img class="img-responsive" src="<%=path %>/homeimage/2.jpg" alt="">
								<div class="portfolio-overlay">
									<a href="images/works/portfolio-6.jpg"><i class="fa fa-camera-retro"></i></a>
									<h5>环境套房</h5>
									<p>卧室带阳台，卧室全南，交通方便，采光好</p>
									<span>南杨小区（长清路）</span>
									<span>1室1厅</span>
									<span>41.14平</span>
								</div>
							</div>	
						</div>
					</div>				
				</div>
			</div>
		</div>
	</section>
	<!-- /OUR WORKS -->

	
	<!-- PRICING -->
	<section id="pricing">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-title">
						<h1>贷款详情</h1>
						<span class="st-border"></span>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="st-pricing text-center">
						<h5>精装房/均价</h5>
						<h3>$30000/平米</h3>
						<div class="st-border"></div>
						<ul>
							<li>首付:20%</li>
							<li>分期:支持</li>
							<li>逾期:加收1%利息</li>
							<li>月供:房价的5%</li>
							<li>缴费方式:信用卡,第三方</li>
						</ul>
						<a href="" class="btn btn-send">详情</a>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="st-pricing text-center">
						<h5>裸房/均价</h5>
						<h3>$20000/平米</h3>
						<div class="st-border"></div>
						<ul>
							<li>首付:20%</li>
							<li>分期:支持</li>
							<li>逾期:加收1%利息</li>
							<li>月供:房价的5%</li>
							<li>缴费方式:信用卡,第三方</li>
						</ul>
						<a href="" class="btn btn-send">详情</a>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="st-pricing text-center">
						<h5>采光房/均价</h5>
						<h3>$20000/平米</h3>
						<div class="st-border"></div>
						<ul>
							<li>首付:20%</li>
							<li>分期:支持</li>
							<li>逾期:加收1%利息</li>
							<li>月供:房价的5%</li>
							<li>缴费方式:信用卡,第三方</li>
						</ul>
						<a href="" class="btn btn-send">详情</a>
					</div>
				</div>
				
			</div>
		</div>
	</section>
	<!-- /PRICING -->


	<!-- OUR TEAM -->
	<section id="our-team">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-title">
						<h1>热销房区</h1>
						<span class="st-border"></span>
					</div>
				</div>

				<div class="col-md-3 col-sm-6">
					<div class="team-member">
						<div class="member-image">
							<img class="img-responsive" src="<%=path %>/homeimage/11.jpg" alt="">
							<div class="member-social">
								<a href=""><i class="fa fa-facebook"></i></a>
								<a href=""><i class="fa fa-twitter"></i></a>
								<a href=""><i class="fa fa-google-plus"></i></a>
								<a href=""><i class="fa fa-linkedin"></i></a>
							</div>
						</div>
						<div class="member-info">
							<h4>飞龙岛</h4>
							<span><a href="javascript:void(0);">A栋</a>,<a href="javascript:void(0);">B栋</a>,<a href="javascript:void(0);">F栋</a>,<a href="javascript:void(0);">G栋</a></span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6">
					<div class="team-member">
						<div class="member-image">
							<img class="img-responsive" src="<%=path %>/homeimage/12.jpg" alt="">
							<div class="member-social">
								<a href=""><i class="fa fa-facebook"></i></a>
								<a href=""><i class="fa fa-twitter"></i></a>
								<a href=""><i class="fa fa-google-plus"></i></a>
								<a href=""><i class="fa fa-linkedin"></i></a>
							</div>
						</div>
						<div class="member-info">
							<h4>章江区</h4>
							<span><a href="javascript:void(0);">A栋</a>,<a href="javascript:void(0);">B栋</a>,<a href="javascript:void(0);">F栋</a>,<a href="javascript:void(0);">G栋</a></span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6">
					<div class="team-member">
						<div class="member-image">
							<img class="img-responsive" src="<%=path %>/homeimage/13.jpg" alt="">
							<div class="member-social">
								<a href=""><i class="fa fa-facebook"></i></a>
								<a href=""><i class="fa fa-twitter"></i></a>
								<a href=""><i class="fa fa-google-plus"></i></a>
								<a href=""><i class="fa fa-linkedin"></i></a>
							</div>
						</div>
						<div class="member-info">
							<h4>沙河区</h4>
							<span><a href="javascript:void(0);">A栋</a>,<a href="javascript:void(0);">B栋</a>,<a href="javascript:void(0);">F栋</a>,<a href="javascript:void(0);">G栋</a></span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6">
					<div class="team-member">
						<div class="member-image">
							<img class="img-responsive" src="<%=path %>/homeimage/14.jpg" alt="">
							<div class="member-social">
								<a href=""><i class="fa fa-facebook"></i></a>
								<a href=""><i class="fa fa-twitter"></i></a>
								<a href=""><i class="fa fa-google-plus"></i></a>
								<a href=""><i class="fa fa-linkedin"></i></a>
							</div>
						</div>
						<div class="member-info">
							<h4>中央公园开发区</h4>
							<span><a href="javascript:void(0);">A栋</a>,<a href="javascript:void(0);">B栋</a>,<a href="javascript:void(0);">F栋</a>,<a href="javascript:void(0);">G栋</a></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- /OUR TEAM -->


	<!-- ABOUT US -->
	<section id="about-us">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-6">
					<div class="about-us text-center">
						<h4>重点项目建设</h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Earum aliquid obcaecati deleniti minus quisquam quis magnam reprehenderit quaerat molestias rerum, excepturi autem fugiat corporis quidem a ipsum quos beatae! Ut!</p>
						<a href="" class="btn btn-send">去看看</a>
					</div>
				</div>
				<div class="col-sm-6 our-office">
					<div id="office-carousel" class="carousel slide" data-ride="carousel">			
						<div class="carousel-inner">
							<div class="item active">
								<img src="<%=path %>/homeimage/b1.jpg" alt="">
							</div>
							<div class="item">
								<img src="<%=path %>/homeimage/b2.jpg" alt="">			
							</div>
							<div class="item">
								<img src="<%=path %>/homeimage/b3.jpg" alt="">			
							</div>
							
							<a class="office-carousel-left" href="#office-carousel" data-slide="prev"><i class="fa fa-angle-left"></i></a>
							<a class="office-carousel-right" href="#office-carousel" data-slide="next"><i class="fa fa-angle-right"></i></a>
						</div>		
					</div> <!--/#office-carousel--> 
				</div>
			</div>
		</div>
	</section>
	<!-- TESTIMONIAL -->
	<section id="testimonial" style="background-image: url(<%=path %>/homeimage/l2.jpg)">
		<div class="container">
			<div class="row">
				<div class="overlay"></div>
				<div class="col-md-8 col-md-offset-2 col-sm-12">
					<div class="st-testimonials" >
						<div class="item active text-center">
							<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet dolore nesciunt natus ullam possimus quas obcaecati suscipit voluptate facilis cum"</p>
							<div class="st-border"></div>
							<div class="client-info">
								<h5>项目工程1</h5>
								<span>去看看</span>
							</div>
						</div>

						<div class="item text-center">
							<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet dolore nesciunt natus ullam possimus quas obcaecati suscipit voluptate facilis cumconsectetur adipisicing elit. Amet dolore"</p>
							<div class="st-border"></div>
							<div class="client-info">
								<h5>项目工程2</h5>
								<span>去看看</span>
							</div>
						</div>

						<div class="item text-center">
							<p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem autem possimus laborum, ducimus vel rerum asperiores delectus, suscipit voluptate mollitia, ullam perspiciatis voluptates!"</p>
							<div class="st-border"></div>
							<div class="client-info">
								<h5>项目工程3</h5>
								<span>去看看</span>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- /TESTIMONIAL -->



	<!-- FUN FACTS -->
	<section id="fun-facts">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-3">
					<div class="fun-fact text-center">
						<h3><i class="fa fa-thumbs-o-up"></i> <span class="st-counter">36500000</span></h3>
						<p>好评人数</p>
					</div>
				</div>
				<div class="col-sm-6 col-md-3">
					<div class="fun-fact text-center">
						<h3><i class="fa fa-briefcase fa-6"></i> <span class="st-counter">73987</span></h3>
						<p>成交量</p>
					</div>
				</div>
				<div class="col-sm-6 col-md-3">
					<div class="fun-fact text-center">
						<h3><i class="fa fa-coffee"></i> <span class="st-counter">297345</span></h3>
						<p>接待量</p>
					</div>
				</div>
				<div class="col-sm-6 col-md-3">
					<div class="fun-fact text-center">
						<h3><i class="fa fa-code"></i> <span class="st-counter">9823686</span></h3>
						<p>预期效果</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- /FUN FACTS -->

	
	<!-- CONTACT -->
	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-title">
						<h1>我要预约</h1>
						<span class="st-border"></span>
					</div>
				</div>
				<div class="col-sm-4 contact-info">
					<p class="contact-content">早一步拥有你的套房，赶快下手吧！提交信息，客服方便联系你</p>
					<p class="st-address"><i class="fa fa-map-marker"></i> <strong>江西赣州章贡区</strong></p>
					<p class="st-phone"><i class="fa fa-mobile"></i> <strong>176-0797-5702</strong></p>
					<p class="st-email"><i class="fa fa-envelope-o"></i> <strong>275300091@qq.comm</strong></p>
					<p class="st-website"><i class="fa fa-globe"></i> <strong>www.yourdomain.com</strong></p>
				
				</div>
				<div class="col-sm-7 col-sm-offset-1">
					<form action="php/send-contact.php" class="contact-form" name="contact-form" method="post">
						<div class="row">
							<div class="col-sm-6">
								<input type="text" name="name" required="required" placeholder="称呼">
							</div>
							<div class="col-sm-6">
								<input type="email" name="email" required="required" placeholder="邮箱">
							</div>
							<div class="col-sm-6">
								<input type="text" name="subject" placeholder="房区">
							</div>
							<div class="col-sm-6">
								<input type="text" name="website" placeholder="电话">
							</div>
							<div class="col-sm-12">
								<textarea name="message" required="required" cols="30" rows="7" placeholder="你的要求"></textarea>
							</div>
							<div class="col-sm-12">
								<input type="submit" name="submit" value="确认预约" class="btn btn-send">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<footer id="footer">
		<div class="container">
			<div class="row">
				<!-- SOCIAL ICONS -->
				<div class="col-sm-6 col-sm-push-6 footer-social-icons">
					<span>Follow us:</span>
					<a href=""><i class="fa fa-facebook"></i></a>
					<a href=""><i class="fa fa-twitter"></i></a>
					<a href=""><i class="fa fa-google-plus"></i></a>
					<a href=""><i class="fa fa-pinterest-p"></i></a>
				</div>
				<!-- /SOCIAL ICONS -->
				<div class="col-sm-6 col-sm-pull-6 copyright">
					<p>&copy; 2017 <a href="">桃源盛景</a>. 一个拥有数万套房屋的大咖 <a href="http://www.cssmoban.com/" target="_blank" title="桃源盛景">房王</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">你值得信赖</a></p>
				</div>
			</div>
		</div>
	</footer>
	<!-- /FOOTER -->
	<!-- Scroll-up -->
	<div class="scroll-up">
		<ul><li><a href="#header"><i class="fa fa-angle-up"></i></a></li></ul>
	</div>
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
<<<<<<< .mine
					  <ul id="myTab" class="nav nav-tabs">
							<li class="active"><a href="#login" data-toggle="tab">登录</a></li>
							<li><a href="#regirest" data-toggle="tab">注册</a></li>
							<li><a href="#er" data-toggle="tab">快速登录</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade in active" id="login">
								<form class="form-horizontal" role="form" id="form" action="<%=path %>/lr/loginsuccess">
									  <div class="form-group">
				                      </div>
				                      <div class="form-group">
				                          <input type="text" class="form-control" id="useraccount" name="useraccount" placeholder="请输入电子邮件/手机号码">
				                          <i class="fa fa-user"></i>
				                      </div>
				                      <div class="form-group help">
				                          <input type="password" class="form-control" id="inputPassword5" name="password" placeholder="请输入登录密码">
				                          <i class="fa fa-lock"></i>
				                          <button class="btn btn-primary btn-lg fa-question-circle glyphicon glyphicon-info-sign" style="margin-top:0px">忘记密码</button>
				                      </div>
				                      <div class="form-group">
				                          <div class="main-checkbox">
				                              <input type="checkbox" value="None" id="checkbox1" name="check"/>
				                              <label for="checkbox1"></label>
				                          </div>
				                          <label class="text">记住密码</label>
				                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;还没有SaleHome账号？<a href="javascript:void(0);">忘记密码</a></label>
				                          <div class="form-group">
				                      	  </div>
				                          <button type="submit" class="btn btn-default btn-primary btn-lg btn-block">登录</button>
				                      </div>
				                      <div class="member-social">
				                      		<label class="text" style="margin-left:50px">其他方式登录</label>
											<a href="javascript:void(0);" style="margin-left:30px"><i class="fa fa-facebook"></i></a>
											<a href="javascript:void(0);" style="margin-left:30px"><i class="fa fa-twitter"></i></a>
											<a href="javascript:void(0);" style="margin-left:30px"><i class="fa fa-google-plus"></i></a>
											<a href="javascript:void(0);" style="margin-left:30px"><i class="fa fa-linkedin"></i></a>
									  </div>
				                  </form>
							</div>
							<div class="tab-pane fade" id="regirest">
								<form class="form-horizontal" role="form" id="form">
			                      <div class="form-group">
			                      </div>
			                      <div class="form-group">
			                          <input type="number" class="form-control"name="registeraccount" id="inputEmail3" placeholder="请输入你的手机号">
			                          <i class="fa fa-user"></i>
			                      </div>
			                      <div class="form-group help">
		                          	  <input type="number" class="form-control" name="registeremail" id="inputPassword4" placeholder="验证码">
			                     	  <i class="fa fa-lock"></i>
			                          <button type="button" class="btn btn-primary btn-lg fa-question-circle glyphicon glyphicon-leaf" id="getcode" >获取验证码</button>
			                      </div>
			                      <div class="form-group">
			                          <input type="password" class="form-control" name="captcha" id="inputPassword3" placeholder="验证码">
			                          <i class="fa fa-lock"></i>
			                          <label class="col-lg-3 control-label fa fa-question-circle" id="captchaOperation"></label>
			                      </div>
			                      <div class="form-group">
			                          <label style="float:right">收不到验证码？<a href="javascript:void(0);">反馈问题</a></label>
			                          <div class="form-group">
				                      </div>
			                          <button type="submit" class="btn btn-primary btn-lg btn-block btn-danger">注册</button>
			                     </div>
			                 </form>							
				         </div>
				         <div class="tab-pane fade" id="er">
				         	<form class="form-horizontal" role="form" id="form">
			                      <div class="form-group">
			                      </div>
			                      <div class="form-group">
			                          <input type="number" class="form-control"name="fastuseraccount" id="fastuseraccount" placeholder="请输入你的手机号">
			                          <i class="fa fa-user"></i>
			                      </div>
			                      <div class="form-group help">
		                          	  <input type="number" class="form-control" name="fastcode" id="fastcode" placeholder="验证码">
			                     	  <i class="fa fa-lock"></i>
			                          <button type="button" class="btn btn-primary btn-lg fa-question-circle glyphicon glyphicon-leaf" id="getphonecode" >获取验证码</button>
			                      </div>
			                      <div class="form-group">
			                          <label style="float:right">收不到验证码？<a href="javascript:void(0);">反馈问题</a></label>
			                          <div class="form-group">
				                      </div>
			                          <button type="submit" class="btn btn-primary btn-lg btn-block btn-danger">快速登录</button>
			                     </div>
			                 </form>	
				         </div>
					</div>
||||||| .r20
					  <ul id="myTab" class="nav nav-tabs">
							<li class="active"><a href="#login" data-toggle="tab">登录</a></li>
							<li><a href="#regirest" data-toggle="tab">注册</a></li>
							<li><a href="#er" data-toggle="tab">快速登录</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade in active" id="login">
								<form class="form-horizontal" role="form" id="form" action="<%=path %>/lr/login">
									  <div class="form-group">
				                      </div>
				                      <div class="form-group">
				                          <input type="text" class="form-control" id="useraccount" name="useraccount" placeholder="请输入电子邮件/手机号码">
				                          <i class="fa fa-user"></i>
				                      </div>
				                      <div class="form-group help">
				                          <input type="password" class="form-control" id="inputPassword3" name="password" placeholder="请输入登录密码">
				                          <i class="fa fa-lock"></i>
				                          <button class="btn btn-primary btn-lg fa-question-circle glyphicon glyphicon-info-sign" style="margin-top:0px">忘记密码</button>
				                      </div>
				                      <div class="form-group">
				                          <div class="main-checkbox">
				                              <input type="checkbox" value="None" id="checkbox1" name="check"/>
				                              <label for="checkbox1"></label>
				                          </div>
				                          <label class="text">记住密码</label>
				                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;还没有SaleHome账号？<a href="javascript:void(0);">忘记密码</a></label>
				                          <div class="form-group">
				                      	  </div>
				                          <button type="submit" class="btn btn-default btn-primary btn-lg btn-block">登录</button>
				                      </div>
				                      <div class="member-social">
				                      		<label class="text" style="margin-left:50px">其他方式登录</label>
											<a href="javascript:void(0);" style="margin-left:30px"><i class="fa fa-facebook"></i></a>
											<a href="javascript:void(0);" style="margin-left:30px"><i class="fa fa-twitter"></i></a>
											<a href="javascript:void(0);" style="margin-left:30px"><i class="fa fa-google-plus"></i></a>
											<a href="javascript:void(0);" style="margin-left:30px"><i class="fa fa-linkedin"></i></a>
									  </div>
				                  </form>
							</div>
							<div class="tab-pane fade" id="regirest">
								<form class="form-horizontal" role="form" id="form">
			                      <div class="form-group">
			                      </div>
			                      <div class="form-group">
			                          <input type="number" class="form-control"name="registeraccount" id="inputEmail3" placeholder="请输入你的手机号">
			                          <i class="fa fa-user"></i>
			                      </div>
			                      <div class="form-group help">
		                          	  <input type="number" class="form-control" name="registeremail" id="inputPassword3" placeholder="验证码">
			                     	  <i class="fa fa-lock"></i>
			                          <button type="button" class="btn btn-primary btn-lg fa-question-circle glyphicon glyphicon-leaf" id="getcode" >获取验证码</button>
			                      </div>
			                      <div class="form-group">
			                          <input type="password" class="form-control" name="captcha" id="inputPassword3" placeholder="验证码">
			                          <i class="fa fa-lock"></i>
			                          <label class="col-lg-3 control-label fa fa-question-circle" id="captchaOperation"></label>
			                      </div>
			                      <div class="form-group">
			                          <label style="float:right">收不到验证码？<a href="javascript:void(0);">反馈问题</a></label>
			                          <div class="form-group">
				                      </div>
			                          <button type="submit" class="btn btn-primary btn-lg btn-block btn-danger">注册</button>
			                     </div>
			                 </form>							
				         </div>
				         <div class="tab-pane fade" id="er">
								<form class="form-horizontal" role="form" id="form">
			                      <div class="form-group">
			                      </div>
			                      <div class="form-group">
			                          <input type="email" class="form-control" name="registeraccount1" id="inputEmail3" placeholder="请输入你的手机号">
			                          <i class="fa fa-user"></i>
			                          <button type="button" class="btn btn-primary">获取验证码</button>
			                      </div>
			                      <div class="form-group help">
			                          <input type="password" class="form-control" name="registeremail" id="inputPassword3" placeholder="密　码">
			                          <i class="fa fa-lock"></i>
			                          <a href="#" class="fa fa-question-circle"></a>
			                      </div>
			                      <div class="form-group">
			                          <div class="main-checkbox">
			                              <input type="checkbox" value="None" id="checkbox3" name="check"/>
			                              <label for="checkbox1"></label>
			                          </div>
			                          <label class="text">记住密码</label>
			                          <label class="text" style="float:right">收不到验证码？<a href="javascript:void(0);">反馈问题</a></label>
			                          <button type="submit" class="btn btn-primary btn-lg btn-block btn-danger">注册</button>
			                     </div>
			                 </form>							
				         </div>
					</div>
=======
	                  <form class="form-horizontal">
						<div class="form-group" style="margin-left:251px">
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
>>>>>>> .r3
			    </div>
			</div>
		</div>
	</div>
<!-- 	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> -->
<!-- 		<div class="modal-dialog"> -->
<!-- 			<div class="modal-content"> -->
<!-- 				<div class="modal-header"> -->
<!-- 					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"> -->
<!-- 						&times; -->
<!-- 					</button> -->
<!-- 					<h3 class="modal-title" id="myModalLabel"> -->
<!-- 								选择地区 -->
<!-- 					</h3> -->
<!-- 				</div> -->
<!-- 				<div class="modal-body"> -->
<!-- 					<div class="city-change animated"> -->
<!-- 						<span class="close"></span> -->
<!-- 						<div class="title"> -->
<!-- 							选择城市 <span class="city-tab"><span class="code1">热门城市:</span><a -->
<!-- 								href="//bj.lianjia.com/" title="北京房产网">北京</a><a -->
<!-- 								href="http://sh.lianjia.com/" title="上海房产网">上海</a><a -->
<!-- 								href="//gz.lianjia.com/" title="广州房产网">广州</a><a -->
<!-- 								href="//sz.lianjia.com/" title="深圳房产网">深圳</a> </span> -->
<!-- 						</div> -->
<!-- 						<ul style="display: inline-block; list-style: none"> -->
<!-- 							<li class="clear"><h2>B&nbsp;&nbsp;&nbsp;<a -->
<!-- 									href="https://bj.lianjia.com/" title="北京房产网"><span class="label  label-success">北京</span></a></h2></li> -->
<!-- 							<li class="clear"><h2><span class="code-title fl">C</span> -->
<!-- 									<a href="https://cd.lianjia.com/" title="成都房产网"><span class="label  label-success">成都</span></a><a -->
<!-- 										href="https://cq.lianjia.com/" title="重庆房产网"><span class="label  label-success">重庆</span></a><a -->
<!-- 										href="https://cs.lianjia.com/" title="长沙房产网"><span class="label  label-success">长沙</span></a> -->
<!-- 									</h2> -->
<!-- 							</li> -->
<!-- 							<li class="clear"><h2><span class="code-title fl">D</span> -->
<!-- 									<a href="https://dl.lianjia.com/" title="大连房产网"><span class="label  label-success">大连</span></a><a -->
<!-- 										href="https://dg.lianjia.com/" title="东莞房产网"><span class="label  label-success">东莞</span></a> -->
<!-- 									</h2> -->
<!-- 							</li> -->
<!-- 							<li class="clear"><span class="code-title fl">F</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://fs.lianjia.com/" title="佛山房产网">佛山</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">G</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://gz.lianjia.com/" title="广州房产网">广州</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">H</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://hz.lianjia.com/" title="杭州房产网">杭州</a><a -->
<!-- 										href="https://hui.lianjia.com/" title="惠州房产网">惠州</a><a -->
<!-- 										href="http://hk.lianjia.com/" title="海口房产网">海口</a><a -->
<!-- 										href="https://hf.lianjia.com/" title="合肥房产网">合肥</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">J</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://jn.lianjia.com/" title="济南房产网">济南</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">L</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="http://ls.lianjia.com/" title="陵水房产网">陵水</a><a -->
<!-- 										href="https://lf.lianjia.com/" title="廊坊房产网">廊坊</a> -->
<!-- 								</div></li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 					<div class="fl citys-r"> -->
<!-- 						<ul> -->
<!-- 							<li class="clear"><span class="code-title fl">N</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://nj.lianjia.com/" title="南京房产网">南京</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">Q</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://qd.lianjia.com/" title="青岛房产网">青岛</a><a -->
<!-- 										href="http://qh.lianjia.com/" title="琼海房产网">琼海</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">S</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="http://sh.lianjia.com/" title="上海房产网">上海</a><a -->
<!-- 										href="https://sz.lianjia.com/" title="深圳房产网">深圳</a><a -->
<!-- 										href="http://su.lianjia.com/" title="苏州房产网">苏州</a><a -->
<!-- 										href="http://sjz.lianjia.com/" title="石家庄房产网">石家庄</a><a -->
<!-- 										href="https://sy.lianjia.com/" title="沈阳房产网">沈阳</a><a -->
<!-- 										href="http://san.lianjia.com/" title="三亚房产网">三亚</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">T</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://tj.lianjia.com/" title="天津房产网">天津</a><a -->
<!-- 										href="http://ty.lianjia.com/" title="太原房产网">太原</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">W</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://wh.lianjia.com/" title="武汉房产网">武汉</a><a -->
<!-- 										href="http://wc.lianjia.com/" title="文昌房产网">文昌</a><a -->
<!-- 										href="http://wn.lianjia.com/" title="万宁房产网">万宁</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">X</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://xm.lianjia.com/" title="厦门房产网">厦门</a><a -->
<!-- 										href="http://xa.lianjia.com/" title="西安房产网">西安</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">Y</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://yt.lianjia.com/" title="烟台房产网">烟台</a> -->
<!-- 								</div></li> -->
<!-- 							<li class="clear"><span class="code-title fl">Z</span> -->
<!-- 								<div class="city-enum fl"> -->
<!-- 									<a href="https://zs.lianjia.com/" title="中山房产网">中山</a><a -->
<!-- 										href="https://zh.lianjia.com/" title="珠海房产网">珠海</a> -->
<!-- 								</div> -->
<!-- 							</li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script><!-- jQuery -->
	<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script><!-- Bootstrap -->
	<script type="text/javascript" src="<%=path %>/js/jquery.parallax.js"></script><!-- Parallax -->
	<script type="text/javascript" src="<%=path %>/js/smoothscroll.js"></script><!-- Smooth Scroll -->
	<script type="text/javascript" src="<%=path %>/js/masonry.pkgd.min.js"></script><!-- masonry -->
	<script type="text/javascript" src="<%=path %>/js/jquery.fitvids.js"></script><!-- fitvids -->
	<script type="text/javascript" src="<%=path %>/js/owl.carousel.min.js"></script><!-- Owl-Carousel -->
	<script type="text/javascript" src="<%=path %>/js/jquery.counterup.min.js"></script><!-- CounterUp -->
	<script type="text/javascript" src="<%=path %>/js/waypoints.min.js"></script><!-- CounterUp -->
	<script type="text/javascript" src="<%=path %>/js/jquery.isotope.min.js"></script><!-- isotope -->
	<script type="text/javascript" src="<%=path %>/js/jquery.magnific-popup.min.js"></script><!-- magnific-popup -->
	<script type="text/javascript" src="<%=path %>/js/scripts.js"></script><!-- Scripts -->
<<<<<<< .mine
	<script type="text/javascript" src="<%=path%>/js/bootstrapValidator.js"></script>
    <script type="text/javascript" src="<%=path%>/js/zh_CN.js"></script>
	<script>
        $(function () {
        	 // Generate a simple captcha
            function randomNumber(min, max) {
                return Math.floor(Math.random() * (max - min + 1) + min);
            };
            $('#captchaOperation').html(['=', randomNumber(1, 100), '+',randomNumber(1, 100) ].join(' '));
            $('form').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    useraccount: {
                        message: '用户名验证失败',
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
                            },
                            stringLength: {
                                min: 11,
                                max: 11,
                                message: '用户名长度必须在11位'
                            },
                            threshold: 10,
                            remote: {
                            	url: '${pageContext.request.contextPath}/lr/checkuseraccount',
                                message: '用户不存在',
                                delay :  2000,
                                type: 'POST'
                            }
                        }
                    },
                    password: {
                        message: '密码验证失败',
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            },
                            stringLength: {
                                min: 6,
                                max: 18,
                                message: '密码长度必须在6到18位之间'
                            },
                            regexp: {
                                regexp: /^[a-zA-Z0-9_]+$/,
                                message: '密码只能包含大写、小写、数字和下划线'
                            },
                            threshold: 6,
                            remote: {
                                url: "${pageContext.request.contextPath}/lr/checkpassword",
                                data: function (validator) {
                                	return {
                                		useraccount: $("#useraccount").val(),
                                    	password: $("#password").val()
                                    };
                                    
                                },
                                message: '密码输入错误！',
                                delay:1000
                            }
                           
                        }
                    },
                    registeraccount: {
                        message: '注册账号验证失败',
                        validators: {
                        	notEmpty: {
                                message: '手机号码不能为空'
                            },
                            stringLength: {
                                min: 11,
                                max: 11,
                                message: '请输入11位手机号码'
                            },
                            regexp: {
                                regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                                message: '请输入正确的手机号码'
                            },
                            threshold :11 ,
                            remote: {
                                url: '${pageContext.request.contextPath}/lr/login',
                                message: '用户已存在',
                                delay :  2000,
                                type: 'POST'
                            }
                        }
                    },
                    registeremail: {
                        validators: {
                            notEmpty: {
                                message: '验证码不能为空'
                            }
                        }
                    },
                    captcha: {
                        validators: {
                            callback: {
                                message: '回答错误',
                                callback: function(value, validator) {
                                    var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[1]) + parseInt(items[3]);
                                    return value == sum;
                                }
                            }
                        }
                    },fastuseraccount: {
                        message: '用户名验证失败',
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
                            },
                            stringLength: {
                                min: 11,
                                max: 11,
                                message: '用户名长度必须在11位'
                            },
                            threshold: 10,
                            remote: {
                            	url: '${pageContext.request.contextPath}/lr/checkuseraccount',
                                message: '用户不存在',
                                delay :  2000,
                                type: 'POST'
                            }
                        }
                    },
                    fastphonecode: {
                        message: '密码验证失败',
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            },
                            stringLength: {
                                min: 6,
                                max: 18,
                                message: '密码长度必须在6到18位之间'
                            },
                            regexp: {
                                regexp: /^[a-zA-Z0-9_]+$/,
                                message: '密码只能包含大写、小写、数字和下划线'
                            },
                            threshold: 6,
                            remote: {
                                url: "${pageContext.request.contextPath}/lr/getcode",
                                data: function (validator) {
                                	return {
                                		useraccount: $("#useraccount").val()
                                    };
                                },
                                message: '密码输入错误！',
                                delay:1000
                            }
                           
                        }
                    }
                }
            });
        });
    </script>
    <script>
    	$(function(){
    		$("#lg").bind("click",function(){
    			$('#myTab li:eq(0) a').tab('show')
    		});
    		$("#re").bind("click",function(){
    			$('#myTab li:eq(1) a').tab('show')
    		});
    	});
    </script>
    <script>
    $(function() {
        $("#bt").click(function(){
        	$(this).button('loading').delay(1000).queue(function() {
                $(this).button('reset');
                $(this).dequeue(); 
            });
        });
    });  
    </script>
    <script>
    	$(function(){
    		var num=60;
    		$("#getcode").click(function(){
    			showtime();
    		});
    		function showtime(){
    			if(num>=0){
    				num--;
    				$("#getcode").html(num+"秒后重发");
//     				$.post(
//     					"",
//     					{
    						
//     					},
//     					function(data){
    						
//     					},
//     					"json"
//     				);
    			}else{
    				$("#getcode").html("重新发送");
    			}
    			setTimeout(showtime,1000);
    		}
    		$("#getphonecode").click(function(){
    			if($("#fastuseraccount").val()==""){
    				alert("请输入手机号");
    				return;
    			}	
    			showtimecode();
    		});
    		function showtimecode(){
    			if(num>=0){
    				num--;
    				$("#getphonecode").html(num+"秒后重发");
//     				$.post(
//     					"",
//     					{
    						
//     					},
//     					function(data){
    						
//     					},
//     					"json"
//     				);
    			}else{
    				$("#getphonecode").html("重新发送");
    			}
    			setTimeout(showtimecode,1000);
    		}
    	});
    </script>
||||||| .r20
	<script type="text/javascript" src="<%=path%>/js/bootstrapValidator.js"></script>
    <script type="text/javascript" src="<%=path%>/js/zh_CN.js"></script>
	<script>
        $(function () {
        	 // Generate a simple captcha
            function randomNumber(min, max) {
                return Math.floor(Math.random() * (max - min + 1) + min);
            };
            $('#captchaOperation').html(['=', randomNumber(1, 100), '+',randomNumber(1, 100) ].join(' '));
            $('form').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    useraccount: {
                        message: '用户名验证失败',
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
                            },
                            stringLength: {
                                min: 11,
                                max: 11,
                                message: '用户名长度必须在11位'
                            },
                            threshold: 10,
                            remote: {
                                url: "${pageContext.request.contextPath}/lr/login",
                                data: function (validator) {
                                	return {
                                    	useraccount: $("#useraccount").val()
                                    };
                                    
                                },
                                message: '该登录名已被使用，请使用其他登录名',
                                delay:1000
                            }
                        }
                    },
                    password: {
                        message: '密码验证失败',
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            },
                            stringLength: {
                                min: 6,
                                max: 18,
                                message: '密码长度必须在6到18位之间'
                            },
                            regexp: {
                                regexp: /^[a-zA-Z0-9_]+$/,
                                message: '密码只能包含大写、小写、数字和下划线'
                            }
                        }
                    },
                    registeraccount: {
                        message: '注册账号验证失败',
                        validators: {
                        	notEmpty: {
                                message: '手机号码不能为空'
                            },
                            stringLength: {
                                min: 11,
                                max: 11,
                                message: '请输入11位手机号码'
                            },
                            regexp: {
                                regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                                message: '请输入正确的手机号码'
                            },
                            threshold :11 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
                            remote: {
                                url: '<%=path %>/lr/login',//验证地址
                                message: '用户已存在',
                                delay :  2000,
                                type: 'POST'
                            }
                        }
                    },
                    registeremail: {
                        validators: {
                            notEmpty: {
                                message: '验证码不能为空'
                            }
                        }
                    },
                    captcha: {
                        validators: {
                            callback: {
                                message: '回答错误',
                                callback: function(value, validator) {
                                    var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[1]) + parseInt(items[3]);
                                    return value == sum;
                                }
                            }
                        }
                    }
                }
            });
        });
    </script>
    <script>
    	$(function(){
    		$("#lg").bind("click",function(){
    			$('#myTab li:eq(0) a').tab('show')
    		});
    		$("#re").bind("click",function(){
    			$('#myTab li:eq(1) a').tab('show')
    		});
    		
    	});
    </script>
    <script>
    $(function() {
        $("#bt").click(function(){
        	$(this).button('loading').delay(1000).queue(function() {
	                $(this).button('reset');
	                $(this).dequeue(); 
                });
        });
    });  
    </script>
    <script>
    	$(function(){
    		var num=60;
    		$("#getcode").click(function(){
    			showtime();
    		});
    		function showtime(){
    			if(num>=0){
    				num--;
    				$("#getcode").html(num+"秒后重发");
//     				$.post(
//     					"",
//     					{
    						
//     					},
//     					function(data){
    						
//     					},
//     					"json"
//     				);
    			}else{
    				$("#getcode").html("重新发送");
    			}
    			setTimeout(showtime,1000);
    		}
    	});
    </script>
=======
>>>>>>> .r3
</body>
</html>