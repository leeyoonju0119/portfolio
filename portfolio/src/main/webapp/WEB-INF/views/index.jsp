<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <title>Pricing example · Bootstrap v4.6</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/pricing/">

    <%@ include file="/WEB-INF/views/include/config.jsp" %>

    


    <!-- Favicons 
<link rel="apple-touch-icon" href="/docs/4.6/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/4.6/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/4.6/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/4.6/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/4.6/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
<link rel="icon" href="/docs/4.6/assets/img/favicons/favicon.ico">
<meta name="msapplication-config" content="/docs/4.6/assets/img/favicons/browserconfig.xml">
-->
<meta name="theme-color" content="#563d7c">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
      
    </style>
	<script>
    
    	let msg = '${msg}';
    	if(msg == 'modify') {
    		alert("회원정보가 수정되었습니다.");
    	}
    
    </script>
    
    
  </head>
  <body>
     
      
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<%@ include file="/WEB-INF/views/include/categoryMenu.jsp" %>


<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">

  <p class="lead"> 깔끔하고 무난한 데일리룩 윤몰입니다 언제나 소비자를 우선시 생각합니다</p>
</div>

<div class="container">
  <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">좋은 품질</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">good quality <small class="text-muted"></small></h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>좋은 품질로</li>
          <li>고객분들께</li>
          <li>자신있게</li>
          <li>선보이겠습니다.</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-outline-primary">YOON MALL</button>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">착한 가격</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">good price<small class="text-muted"></small></h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>착한 가격으로</li>
          <li>고객분들께</li>
          <li>부담없이</li>
          <li>다가가겠습니다</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary">YOON MALL</button>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">넓은 사이즈</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">size<small class="text-muted"></small></h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>폭 넓은 사이즈로</li>
          <li>44부터 88인 고객분들 모두</li>
          <li>만족 시킬수있는</li>
          <li>윤몰이 되겠습니다</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary">YOON MALL</button>
      </div>
    </div>
  </div>

  <%@include file="/WEB-INF/views/include/footer.jsp" %>
</div>


    
  </body>
</html>