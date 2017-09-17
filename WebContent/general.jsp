<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Realtimes</title>
		<!-- Bootstrap CSS CDN -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- Our Custom CSS -->
		<link rel="stylesheet" href="css/realtimes.css">
		<link rel="stylesheet" href="jqcloud/jqcloud.min.css">
	</head>
	<body>
		<div class="wrapper">
            <!-- Sidebar Holder -->
            <nav id="sidebar">
                <div class="sidebar-header">
                    <!-- <h3>Realtimes</h3> -->
                    <a href="index.jsp"><img id="realtimes-logo" src="img/realtimes.png"></a>
                </div>

                <ul class="list-unstyled components">
                		<c:choose>
						<c:when test="${sessionScope.username!=null}">
							<li style="text-align:center;"> login as : ${sessionScope.username} </li>
						<ul class="list-unstyled CTAs">
		                    <li><a href="index.jsp" class="logout_button">로그아웃</a></li>
		                </ul>
						</c:when>
						<c:otherwise>
						<ul class="list-unstyled CTAs">
		                    <li><a href="#" data-toggle="modal" data-target="#login-modal">로그인</a></li>
		                </ul>
						</c:otherwise>
					</c:choose>
                    <li>
                        <a href="recommend.jsp">맞춤 뉴스</a>
                    </li>
                    <li>
                        <a href="general.jsp">일반 뉴스</a>
                    </li>
                    <li>
                        <a href="issue.jsp">이슈 모음</a>
                    </li>
                    <li>
                        <a href="#settingsSubmenu" data-toggle="collapse" aria-expanded="false">설정</a>
                        <ul class="collapse list-unstyled" id="settingsSubmenu">
                            <li><a href="#">채널 관리</a></li>
                            <li><a href="#">테마 설정</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">공지사항</a>
                    </li>
                </ul>
            </nav>

            <!-- Page Content Holder -->
            <div id="content">

                <nav class="navbar navbar-default">
                    <div class="container-fluid">

                        <div class="navbar-header">
                            <button type="button" id="sidebarCollapse" class="navbar-btn">
                                <span></span>
                                <span></span>
                                <span></span>
                            </button>
                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="recommend.jsp">맞춤 뉴스</a></li>
                                <li><a href="general.jsp">일반 뉴스</a></li>
                                <li><a href="issue.jsp">이슈 모음</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
					<div class="index_content">
						<ul class="nav nav-tabs" role="tablist" id ="generalTabs">
							<li role="presentation" class="active"><a href="#politics" aria-controls="politics" role="tab" data-toggle="tab">정치</a></li>
							<li role="presentation"><a href="#economy" aria-controls="economy" role="tab" data-toggle="tab">경제</a></li>
							<li role="presentation"><a href="#social" aria-controls="social" role="tab" data-toggle="tab">사회</a></li>
							<li role="presentation"><a href="#it" aria-controls="it" role="tab" data-toggle="tab">IT/과학</a></li>
							<li role="presentation"><a href="#entertainments" aria-controls="entertainments" role="tab" data-toggle="tab">연예</a></li>
							<li role="presentation"><a href="#sports" aria-controls="sports" role="tab" data-toggle="tab">스포츠</a></li>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="politics">
							</div>
							<div role="tabpanel" class="tab-pane active" id="economy">
							</div>
							<div role="tabpanel" class="tab-pane active" id="social">
							</div>
							<div role="tabpanel" class="tab-pane active" id="it">
							</div>
							<div role="tabpanel" class="tab-pane active" id="entertainments">
							</div>
							<div role="tabpanel" class="tab-pane active" id="sports">
							</div>
						</div>
					</div>
		             <div class="line"></div>
            		</div>
        		</div>
        </div>
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  		<div class="modal-dialog">
				<div class="loginmodal-container">
					<h1>Login to Realtimes</h1><br>
				  <form action="member" method="post">
					<input type="text" name="user" placeholder="아이디">
					<input type="password" name="pass" placeholder="비밀번호">
					<!-- <input type="submit" name="login" class="login loginmodal-submit" value="로그인"> -->
					<input name="login" class="login loginmodal-submit login_button" value="로그인">
					<!-- <input type="hidden" name="command" value="login"> -->
				  </form>
					
				  <div class="login-help">
					<a href="#">Register</a> - <a href="#">Forgot Password</a>
				  </div>
				</div>
			</div>
		  </div>
        	  <div class="modal fade" id="article-modal" tabindex="-1" role="dialog" aria-labelledby="articleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="articleModalLabel">Realtimes</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      	<div class = "row" style="margin:0px;">
			      		<span class="modal_article_badge badge"></span>
			        		<span class="modal_article_time"></span>
			      	</div>
			      	<div class="row" style="margin:0px;">
			      		<div class="modal_article_title"></div>
			      	</div>
			      	<div class="row" style="margin:0px;">
			      		<div class="col-md-2"></div>
			      		<div class="col-md-8">
			      			<img id="modal_article_img" src="img/realtimes.png">
			      		</div>
			      		<div class="col-md-2"></div>
			      	</div>
			        <div class="modal_article_content"></div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
        
        <!-- jQuery CDN -->
         <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
         <!-- Bootstrap Js CDN -->
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
         <script src="jqcloud/jqcloud.min.js"></script>

         <script type="text/javascript">
			$(document).ready(function () {				
				// sidebar
				$('#sidebarCollapse').on('click', function () {
					$('#sidebar').toggleClass('active');
					$(this).toggleClass('active');
				});
				// login
				$('.login_button').on('click', function() {
					$.ajax({
						url: "member",
						data: {
							user: $("input[name=user]").val(),
							pass: $("input[name=pass]").val(),
							command: "login"
						},
						method: "post",
						dataType: "json",
						success: function(result) {
							$('#login-modal').modal('hide');
							if (result.result == 0) {
								location.reload();
							} else {
								alert(result.content);	
							}
						}
					})
				});
				// logout
				$('.logout_button').on('click', function() {
					$.ajax({
						url: "member",
						data: {
							command: "logout"
						},
						method: "post",
						dataType: "json"
					});
				});
				
				var assign = function(news_code, topic, section, title, writing_time, company, img, content) {
					var article_card = 
					    "<div class ='article-cards' news_code='"+news_code+"' topic='"+topic+"' section='"+section+"' >"+
						"<div class='row'>"+
							"<div class='col-sm-3' style='border-right:1px solid #ddd;'>"+
								"<img class='article-cards-img' src='"+img+"'>"+
							"</div>"+
							"<div class='col-sm-9'>"+
								"<div>"+
									"<span class='article-cards-section badge'>"+company+"</span>"+
									"<span class='article-cards-time'>"+writing_time+"</span>"+
								"</div>"+
								"<div class='article-cards-title'>"+
									title+
								"</div>"+
								"<div class='article-cards-contents'>"+
									content
								"</div>"+
							"</div>"+
						"</div>"+
					"</div>";
					
					return article_card;
				};
				
				$.ajax({
						url: "news",
						data: {
							command: "getGeneralNews",
							section: 'politics'
						},
						method: "get",
						dataType: "json",
						success: function(result) {
							if (result && result.result == 0) {
								var json_list = JSON.parse(result.list);
								for (var i = 0; i < json_list.length; i++) {
									$('#politics').append(assign(
											json_list[i].news_code,
											json_list[i].topic_name,
											json_list[i].section,
											json_list[i].title,
											json_list[i].writing_time,
											json_list[i].company,
											json_list[i].img,
											json_list[i].content));
								}
							} else {
								alert(result.content);
							}
						}
				});
				
				// tab event
				$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
				    var target = $(e.target).attr("href");
				    $(target).html("");
				    var section = target.substr(1);
				    console.log(section);

					// if (section !== 'politics') return;
				    
					$.ajax({
							url: "news",
							data: {
								command: "getGeneralNews",
								section: section
							},
							method: "get",
							dataType: "json",
							success: function(result) {
								if (result && result.result == 0) {
									var json_list = JSON.parse(result.list);
									for (var i = 0; i < json_list.length; i++) {
										$(target).append(assign(
												json_list[i].news_code,
												json_list[i].topic_name,
												json_list[i].section,
												json_list[i].title,
												json_list[i].writing_time,
												json_list[i].company,
												json_list[i].img,
												json_list[i].content));
									}
								} else {
									alert(result.content);
								}
							}
					});
				});
				// news modal
				var clicked_news = null; // 뉴스 코드
				var clicked_topic = null; // 토픽 번호
				var clicked_section = null; // 뉴스 종류
				var viewing_start_time = null;
				var viewing_end_time = null;

				$(document).on('click', '.article-cards', function() {
					console.log('clicked')
					clicked_news = $(this).attr('news_code');
					clicked_topic = $(this).attr('topic');
					clicked_section = $(this).attr('section');
					$('#article-modal').modal('show');
				});
				// article modal
				$('#article-modal').on('show.bs.modal', function (e) {
					viewing_start_time = Date.now();
					console.log("start viewing: ", clicked_news, clicked_topic, clicked_section);
					var img_src =  $('.article-cards[news_code='+clicked_news+'] .article-cards-img').attr('src');
					var title =  $('.article-cards[news_code='+clicked_news+'] .article-cards-title').text();
					var content =  $('.article-cards[news_code='+clicked_news+'] .article-cards-contents').text();
					var section = $('.article-cards[news_code='+clicked_news+'] .article-cards-section').html();
					var time =  $('.article-cards[news_code='+clicked_news+'] .article-cards-time').html();
					
					$('.modal_article_badge').text(section);
					$('.modal_article_time').text(time);
					$('.modal_article_title').text(title);
					$('.modal_article_content').text(content);
					$('#modal_article_img').attr('src', img_src);
					
					// get content of clicked_news and fill modal
				});
				$('#article-modal').on('hide.bs.modal', function (e) {
					viewing_end_time = (Date.now() - viewing_start_time) / 1000;
					console.log("end viewing: ", clicked_news, viewing_end_time);
					
					$.ajax({
						url: "log",
						data: {
							command: "addLog",
							news_code: clicked_news,
							topic: clicked_topic,
							viewing_time: viewing_end_time
						},
						method: "post",
						dataType: "json"
					});
					
					clicked_news = null;
					clicked_topic = null;
					cliecked_section = null;
					viewing_start_time = null;
					viewing_end_time = null;
				});
			});	
         </script>
	</body>
</html>