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
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.7/tailwind.min.css" />
</head>
<body>
 
 <div class="navbar shadow-xl rounded-xl font-bold bg-gray-100">
        <a href="/">Coop</a>

         <c:if test="${rq.getLoginedMemberId() != 0}">
        <div>
        <a href="../member/home">home</a>
            <div class="dropdown">
                <a href="#">게시판</a>
                <div class="dropdown-content">
                    <a href="../notice/check">공지사항</a>
                </div>
            </div>
           <div class="dropdown">
    <a href="#">프로젝트 관리</a>
    <div class="dropdown-content">
        <c:if test="${rq.loginedMember.position == 1}">
            <div class="nested-dropdown">
                <a href="#">프로젝트 생성</a>
                <div class="nested-dropdown-content">
                    <a href="../project/create">프로젝트 기본 정보 입력 및 생성</a>
                    <a href="../project/work_create">프로젝트 작업 할당</a>
                </div>
            </div>

            <a href="../project/modify">프로젝트 수정</a>
            <a href="../project/delete">프로젝트 삭제</a>
        </c:if>

        <a href="../project/check">프로젝트 조회</a>
    </div>
</div>
           
            <div class="dropdown">
                <a href="#">할 일 보기</a>
                <div class="dropdown-content">
                    <a href="../myWork/check">할 일 목록</a>
                    <a href="../myWork/create">할 일 추가</a>
                    <a href="../myWork/modify">할 일 수정</a>
                    <a href="../myWork/delete">할 일 삭제</a>
                </div>
            </div>
            <a href="/user/member/mypage">마이페이지</a>
            <a href="/user/member/doLogout">로그아웃</a>
        </div>
        </c:if>
         <c:if test="${rq.getLoginedMemberId() == 0  }">
         <div>
           <a href="/user/member/login">Login</a>
           <a href="/user/member/join">Join</a>
           </div>
           </c:if>
    </div>
  