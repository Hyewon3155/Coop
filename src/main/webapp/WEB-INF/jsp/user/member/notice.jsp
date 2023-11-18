<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Notice" />
<%@ include file="../common/head.jsp" %>
  <div class="board-container max-w-4xl mx-auto p-6 bg-white shadow-md">
  <div>
  <div class="flex justify-center">
        <h1 class="text-2xl font-bold text-gray-800 mb-4">공지사항</h1>
        </div>
        <div class="flex justify-end">
        <a href="write">
        <button class="btn btn-success"><i class="bi bi-pencil-square mr-2"></i>글쓰기</button>
        </a>
        </div>
        </div>
        <div class="notice-board">
            <!-- 게시글 1 -->
            <div class="notice-item mb-6">
                <h2 class="notice-title text-xl font-semibold text-gray-900">사내 보안 교육 일정 안내</h2>
                <p class="notice-summary text-gray-600">다가오는 12월 1일, 모든 부서는 오후 2시부터 4시까지 진행되는 사내 보안 교육에 필참해야 합니다. 이번 교육은...</p>
                <p class="notice-info text-gray-500 text-sm mt-2">작성자: 홍길동 | 작성일: 2023-10-01</p>
            </div>

            <!-- 게시글 2 -->
            <div class="notice-item mb-6">
                <h2 class="notice-title text-xl font-semibold text-gray-900">2023년 연말 정산 안내</h2>
                <p class="notice-summary text-gray-600">2023년도 연말 정산 절차가 11월 25일부터 시작됩니다. 모든 직원은 관련 서류를 빠짐없이 준비하여, 기한 내에 제출해주시기 바랍니다...</p>
                <p class="notice-info text-gray-500 text-sm mt-2">작성자: 이순신 | 작성일: 2023-10-02</p>
            </div>

            <!-- 게시글 3 -->
            <div class="notice-item mb-6">
                <h2 class="notice-title text-xl font-semibold text-gray-900">회사 창립 기념일 행사 안내</h2>
                <p class="notice-summary text-gray-600">회사의 창립 기념일을 맞이하여, 오는 11월 30일에 기념 행사가 열립니다. 이번 행사는 사내 강당에서 오전 10시부터 시작되며...</p>
                <p class="notice-info text-gray-500 text-sm mt-2">작성자: 장보고 | 작성일: 2023-10-03</p>
            </div>

            <!-- 추가 게시글은 이곳에 -->

        </div>
        <!-- 페이지네이션 -->
        <div class="pagination flex justify-center space-x-2 mt-6">
            <button class="btn">1</button>
            <button class="btn btn-active">2</button>
            <button class="btn">3</button>
            <button class="btn">4</button>
        </div>
    </div>
 <%@ include file="../common/foot.jsp" %>
 
 
 
  
  