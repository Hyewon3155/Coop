<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Main" />
<%@ include file="../common/head.jsp" %>
<style>
  /* body에 대한 스타일은 여기에서 재정의합니다. */
  body {
    overflow: hidden; /* 스크롤바를 숨깁니다. */
  }
</style>
	 <div class="main_bg_img">
        <div class="content">
          <h1 class="font-bold">새로운 협업 사이트로 초대합니다</h1>
          <a href="/user/member/join">
          	<button class="btn btn-warning"><i class="fas fa-search mx-2" style="color: #fffff"></i>Join</button>
          </a>
          
        </div>
        <div class="img-cover slide-in"></div>
          </div>
<%@ include file="../common/foot.jsp"%>