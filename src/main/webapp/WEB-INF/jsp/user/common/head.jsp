<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle }</title>
<head>
  <link rel="shortcut icon" href="/resource/images/favicon.ico">
  <!-- 테일윈드 불러오기 -->
  <!-- 노말라이즈, 라이브러리 -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.7/tailwind.min.css" />
  <!-- 데이지 UI -->
  <link href="https://cdn.jsdelivr.net/npm/daisyui@2.31.0/dist/full.css" rel="stylesheet" type="text/css" />
  <!-- 제이쿼리 불러오기 -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <!-- 폰트어썸 불러오기 -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
  <!-- 부트스트랩 아이콘 -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
  <link rel="stylesheet" href="/resource/common.css" />
  <script src="/resource/common.js" defer="defer"></script>  
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/evo-calendar@1.1.2/evo-calendar/css/evo-calendar.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/evo-calendar@1.1.2/evo-calendar/css/evo-calendar.min.css"/>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.7/tailwind.min.css" />
</head>
<style>
	.navbar {
		    background-color: #ABDEE6;
	}
</style>
<body>
  <div class="navbar">
  <div class="navbar-start">
    <div class="dropdown">
      <label tabindex="0" class="btn btn-ghost btn-circle text-white">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h7" /></svg>
      </label>
	      <ul tabindex="0" class="menu menu-compact dropdown-content mt-3 p-2 shadow bg-base-100 rounded-box w-52">
	        <li><a href="/user/member/doLogout">로그아웃</a></li>
	        <li><a href="/user/score/read">학점 관리</a></li>
	        <li><a href="/user/score/add">과목 추가</a></li>
	        <li><a href="/user/score/modify">학점 정보 수정</a></li>
	        <li><a href="/user/profile/create">프로필 생성</a></li>
	        <li><a href="/user/profile/modify?id=1">프로필 수정</a></li>
	      </ul>
    </div>
  </div>
  <div class="navbar-center">
	    <a class="btn btn-ghost text-2xl text-white" href="/">INTRODUCE</a>
  </div>
  <div class="navbar-end">
  </div>
</div>

  