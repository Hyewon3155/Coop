<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Home" />
<%@ include file="../common/head.jsp" %>
<div class="grid-container">
        <div class="item notice">
          <div class="card w-full h-full bg-base-100 shadow-xl">
  <div class="card-body">
    <h2 class="text-3xl font-bold">공지사항</h2>
   <c:forEach var="notice" items="${notices }">
    <ul style="list-style-type: disc;">
    <li>
		<span class="text-gray-500"><a class="hover:underline" href="../notice/detail?id=${notice.id }">${notice.title }</a></span>
	</li>
		</ul>
	</c:forEach>
  
    <div class="card-actions justify-end">
    <a href="../notice/check">
      <button class="btn btn-primary">
       바로가기
      </button>
      </a>
    </div>
  </div>
</div>
          </div>
      <div class="item">
        <div class="card w-96 bg-base-100 shadow-xl">
  <div class="card-body">
    <h2 class="card-title">To-do</h2>
   <ul style="list-style-type: disc;">
     <li><a>프로파일 페이지 디자인</a></li>
    </ul>
    <div class="card-actions justify-end">
      <button class="btn btn-primary">바로가기</button>
    </div>
  </div>
</div>
      </div>
        <div class="item">
           <div class="card w-96 bg-base-100 shadow-xl">
  <div class="card-body">
    <h2 class="card-title">Doing</h2>
    <ul style="list-style-type: disc;">
     <li><a>알림 및 피드백 요소 디자인</a></li>
    </ul>
    <div class="card-actions justify-end">
      <button class="btn btn-primary">바로가기</button>
    </div>
  </div>
</div>
        </div>
      <div class="item calendar border-none">
        <div class="card card-side bg-base-100 shadow-xl">
  <div class="card-body">
    <h2 class="text-3xl font-bold">프로젝트 현황</h2>
   <div class="task-container">
        <div class="task-header">
            <h3 class="font-bold">웹사이트 리뉴얼</h3>
            <span>🔔</span>
        </div>
     <div class="task-group">
        <span class="task-title">작업명</span>
        <span class="task-person">담당자</span>
        <span class="task-person">상태</span>
        <span class="task-person">우선순위</span>
    </div>
      <div class="task-group text-white shadow">
      <button class="task-title bg-gray-200 text-xl text-black">
        메인 페이지 디자인 수정
      </button>
      <button class="task-person bg-pink-300">홍길동</button>
      <button class="task-person bg-green-400">완료</button>
      <button class="task-person bg-blue-400">낮음</button>
      </div>
     
<div class="task-group text-white shadow">
      <button class="task-title bg-gray-200 text-xl text-black">
       로그인 페이지 오류 수정
      </button>
      <button class="task-person bg-pink-300">김철수</button>
      <button class="task-person bg-yellow-400">작업중</button>
      <button class="task-person bg-red-400">높음</button>
      </div>
     
<div class="task-group text-white shadow">
      <button class="task-title bg-gray-200 text-xl text-black">
        회원가입 폼 UX 개선
      </button>
      <button class="task-person bg-pink-300">김혜원</button>
      <button class="task-person bg-purple-400">검토 대기중</button>
      <button class="task-person bg-red-300">중간</button>
      </div>
  </div>
    <div class="card-actions justify-end">
      <button class="btn btn-primary">바로가기</button>
    </div>
  </div>
</div>
      </div>
      </div>
      <%@ include file="../common/foot.jsp" %>
      
      