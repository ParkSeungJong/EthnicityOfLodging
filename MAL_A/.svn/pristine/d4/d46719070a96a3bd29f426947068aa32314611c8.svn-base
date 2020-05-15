<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 2. 24.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.mal_a.cmn.StringUtil"%>
<%@page import="com.mal_a.code.CodeVO"%>
<%@page import="com.mal_a.cmn.SearchVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    errorPage="/cmn/error.jsp"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %> 
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>숙박의민족 - MAL_A</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i" rel="stylesheet">
    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/aos.css">
    <link rel="stylesheet" href="css/ionicons.min.css">
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
    
    <!-- 폰트 다운로드 -->
   <link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap&subset=korean" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css?family=Sunflower:300&display=swap" rel="stylesheet">
    <style>
       #font{
       	font-family: 'Sunflower' ;
       }
       #keywords{
        font-family: 'Sunflower' ;
       }
    </style>
    
  <body>

   <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="/MAL_A/roxandrea/start.jsp">숙박의민족</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> 메뉴
	      </button>

			
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	        <li class="nav-item"><a href="/MAL_A/roxandrea/log_in.jsp" class="nav-link">로그인</a></li>
	        <li class="nav-item"><a href="/MAL_A/roxandrea/sign_up.jsp" class="nav-link">회원가입</a></li>
	        </ul>
	      </div>
	      
	      
	    </div>
	  </nav>
    <!-- END nav -->
    
		<div class="hero">
			<div class="container-wrap d-flex justify-content-end align-items-end">
					<span class="ion-ios-play play"></span>
			</div>
	    <section class="home-slider owl-carousel">
	      <div class="slider-item" style="background-image:url(images/bg_1.jpg);">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row no-gutters slider-text align-items-center">
	          <div class="col-md-8 ftco-animate">
	          	<div class="text mb-5 pb-5">
		            <h1 class="mb-3">숙박의 민족</h1>
		            <h2>다양한 숙소를 베스트 요금으로 예약하세요!</h2>
	            </div>
	          </div>
	        </div>
	        </div>
	      </div>

	      <div class="slider-item" style="background-image:url(images/bg_2.jpg);">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row no-gutters slider-text align-items-center">
	          <div class="col-md-10 ftco-animate">
	          	<div class="text mb-5 pb-5">
		            <h1 class="mb-3">국내 최다 업체</h1>
		            <h2>2020년 사용자 평점 1위</h2>
	            </div>
	          </div>
	        </div>
	        </div>
	      </div>
	    </section>
	  </div>

		<section class="ftco-section ">
      <div class="container">
      	<div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
          	<span class="subheading">Welcome to 숙박의민족</span>
            <h2 class="mb-4" style="font-family:Sunflower;">BEST SERVICE FOR YOU</h2>
          </div>
        </div>  
        <div class="row d-flex">
          <div class="col-md pr-md-1 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services py-4 d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-reception-bell"></span>
              	</div>
              </div>
              <div class="media-body">
                <h3 class="heading mb-3">ALARM</h3>
              </div>
            </div>      
          </div>
          <div class="col-md px-md-1 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services py-4 d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-serving-dish"></span>
              	</div>
              </div>
              <div class="media-body">
                <h3 class="heading mb-3">FOOD</h3>
              </div>
            </div>    
          </div>
          <div class="col-md px-md-1 d-flex align-sel Searchf-stretch ftco-animate">
            <div class="media block-6 services py-4 d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-car"></span>
              	</div>
              </div>
              <div class="media-body">
                <h3 class="heading mb-3">PICK UP</h3>
              </div>
            </div>      
          </div>
          <div class="col-md px-md-1 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services py-4 d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-spa"></span>
              	</div>
              </div>
              <div class="media-body">
                <h3 class="heading mb-3">SERVICE</h3>
              </div>
            </div>      
          </div>
          <div class="col-md pl-md-1 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services py-4 d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="ion-ios-bed"></span>
              	</div>
              </div>
              <div class="media-body">
                <h3 class="heading mb-3">REST</h3>
              </div>
            </div>      
          </div>
        </div>
      </div>
    </section>

	<section class="ftco-section ">
			<div class="container">
				<div class="row no-gutters">
					<div class="col-md-3">
						<a class="services-wrap img align-items-end d-flex" style="background-image: url(images/room-3.jpg);">
							<div class="text text-center pb-2">
								<h3>Service</h3>
							</div>
						</a>
					</div>
					<div class="col-md-3">
						<a class="services-wrap img align-items-end d-flex" style="background-image: url(images/swimming-pool.jpg);">
							<div class="text text-center pb-2">
								<h3>leisure</h3>
							</div>
						</a>
					</div>
					<div class="col-md-3">
						<a class="services-wrap img align-items-end d-flex" style="background-image: url(images/resto.jpg);">
							<div class="text text-center pb-2">
								<h3>Restaurant</h3>
							</div>
						</a>
					</div>
					<div class="col-md-3">
						<a class="services-wrap img align-items-end d-flex" style="background-image: url(images/sleep.jpg);">
							<div class="text text-center pb-2">
								<h3>Rest</h3>
							</div>
						</a>
					</div>
				</div>
			</div>
		</section>


<section class="ftco-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
          	<span class="subheading">READ REVIEWS</span>
            <h2>BEST REVIEWS</h2>
          </div>
        </div>
        <div class="row d-flex">
          <div class="col-md-4 d-flex ftco-animate">
            <div class="blog-entry align-self-stretch">
              <a class="block-20" style="background-image: url('images/image_1.jpg');">
              </a>
              <div class="text mt-3 text-center">
              	<div class="meta mb-2" style="font-family:Sunflower;">
                  <div><a >March 03, 2019</a></div>
                  <div><a >박☆☆</a></div>
                  <div><a class="meta-chat"><span class="icon-chat"></span> 5</a></div>
                </div>
                <h3 class="heading" style="font-family:Sunflower;"><a>깨끗하고 경치 좋고 빠지는 거 하나 없는 아주좋은 휴양이었습니다.</a></h3>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
            <div class="blog-entry align-self-stretch">
              <a class="block-20" style="background-image: url('images/image_2.jpg');">
              </a>
              <div class="text mt-3 text-center">
              	<div class="meta mb-2" style="font-family:Sunflower;">
                  <div><a>April 16, 2019</a></div>
                  <div><a>임☆☆</a></div>
                  <div><a class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                </div>
                <h3 class="heading" style="font-family:Sunflower;"><a>가족들과 함께한 여행 저에겐 최고의 선물</a></h3>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
            <div class="blog-entry align-self-stretch">
              <a class="block-20" style="background-image: url('images/image_3.jpg');">
              </a>
              <div class="text mt-3 text-center">
              	<div class="meta mb-2" style="font-family:Sunflower;">
                  <div><a>June 02, 2019</a></div>
                  <div><a>김☆☆</a></div>
                  <div><a class="meta-chat"><span class="icon-chat"></span> 7</a></div>
                </div>
                <h3 class="heading" style="font-family:Sunflower;"><a>익사이팅한 즐길거리까지 잊지못할추억!</a></h3>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>


		<section class="ftco-section ftco-no-pt ftco-no-pb px-0">
			<div class="container-fluid px-0">
				<div class="row no-gutters justify-content-end">
					<div class="col-md-12">
						<div id="home" class="video-hero" style="height: 800px; background-image: url(images/bg_1.jpg); background-size:cover; background-position: center center;">
							<a class="player" data-property="{videoURL:'https://www.youtube.com/watch?v=ism1XqnZJEg',containment:'#home', showControls:false, autoPlay:true, loop:true, mute:true, startAt:0, opacity:1, quality:'default'}"></a>
							<div class="container">
								<div class="row justify-content-start d-flex align-items-end height-text ">
									<div class="col-md-8">
										<div class="text">
											<h1>Most Recommend</h1>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

    <section class="instagram">
      <div class="container-fluid">
        <div class="row no-gutters justify-content-center pb-5">
          <div class="col-md-7 text-center heading-section ftco-animate">
          	<span class="subheading"></span>
          </div>
        </div>
        <div class="row no-gutters">
          <div class="col-sm-12 col-md ftco-animate">
            <a href="images/store_01.jpg" class="insta-img image-popup" style="background-image: url(images/store_01.jpg);">
              <div class="icon d-flex justify-content-center">
                <span class="icon-instagram align-self-center"></span>
              </div>
            </a>
          </div>
          <div class="col-sm-12 col-md ftco-animate">
            <a href="images/insta-5.jpg" class="insta-img image-popup" style="background-image: url(images/insta-5.jpg);">
              <div class="icon d-flex justify-content-center">
                <span class="icon-instagram align-self-center"></span>
              </div>
            </a>
          </div>
          <div class="col-sm-12 col-md ftco-animate">
            <a href="images/insta-4.jpg" class="insta-img image-popup" style="background-image: url(images/insta-4.jpg);">
              <div class="icon d-flex justify-content-center">
                <span class="icon-instagram align-self-center"></span>
              </div>
            </a>
          </div>
          <div class="col-sm-12 col-md ftco-animate">
            <a href="images/store_05.jpg" class="insta-img image-popup" style="background-image: url(images/store_05.jpg);">
              <div class="icon d-flex justify-content-center">
                <span class="icon-instagram align-self-center"></span>
              </div>
            </a>
          </div>
          <div class="col-sm-12 col-md ftco-animate">
            <a href="images/store_10.jpg" class="insta-img image-popup" style="background-image: url(images/store_10.jpg);">
              <div class="icon d-flex justify-content-center">
                <span class="icon-instagram align-self-center"></span>
              </div>
            </a>
          </div>
        </div>
      </div>
    </section>
    
    <section class="ftco-section bg-light ftco-room">
    	<div class="container-fluid px-0">
    	<div class="row no-gutters justify-content-end">
    			<div class="col-md-12">
    				<div class="room-wrap">
    					<div class="img d-flex align-items-center" style="background-image: url(images/bg_3.jpg);">
    						<div class="text text-center px-4 py-4" style="font-family:Sunflower;">
    							<h2><a>숙박의 민족</a></h2>
    							<p>숙박의 민족에는 당신이 상상하지 못한 많은 여행의 재미를 보실 수 있습니다.</p>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</div>
    </section>
    
<%@ include file="/cmn/footer.jsp" %>

<script type="text/javascript">

</script>
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/jquery.mb.YTPlayer.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <!-- // <script src="js/jquery.timepicker.min.js"></script> -->
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>