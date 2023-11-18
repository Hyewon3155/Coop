<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="작업 조회" />
<%@ include file="../common/head.jsp" %>
<style>
html, body {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
   
}
</style>
<div class="work-grid-container">
  <div class="item1">
    <div class="card w-full h-full bg-base-100 shadow-xl">
      <div class="card-body">
        <h2 class="text-3xl font-bold">Doing</h2>
        <div class="card w-full bg-base-100 shadow-xl">
          <div class="card-body">
            <h2 class="text-xl font-bold">웹사이트 리뉴얼</h2>
            <div class="task-container">
              <div class="task-group">
                <span class="task-title">작업명</span>
                <span class="task-person">상태</span>
                <span class="task-person">우선순위</span>
              </div>
              <div class="task-group text-white shadow">
      <button class="task-title bg-gray-200 text-xl text-black">
        메인 페이지 디자인 수정
      </button>
      <select class="task-person bg-red-400">
        <option class="bg-red-400" value="작업중">막힘</option>
        <option class="bg-yellow-400" value="막힘">작업 중</option>
        <option class="bg-green-400" value="완료">완료</option>
                </select>
      <button class="task-person bg-blue-400">낮음</button>
      </div>
            </div>
             <div class="mt-6 card-actions justify-end">
      <button class="btn btn-primary">보기</button>
    </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="item2">
    <div class="card w-full h-full bg-base-100 shadow-xl">
      <div class="card-body">
        <h2 class="text-3xl font-bold">Done</h2>
        <div class="card w-full bg-base-100 shadow-xl">
          <div class="card-body">
            <h2 class="text-xl font-bold">웹사이트 리뉴얼</h2>
            <div class="task-container">
              <div class="task-group">
                <span class="task-title">작업명</span>
                <span class="task-person">상태</span>
                <span class="task-person">우선순위</span>
              </div>
              <div class="task-group text-white shadow">
      <button class="task-title bg-gray-200 text-xl text-black">
        메인 페이지 디자인 수정
      </button>
      <select class="task-person bg-yellow-400">
        <option class="bg-green-400" value="작업중">완료</option>
        <option class="bg-red-400" value="막힘">막힘</option>
        <option class="bg-yellow-400" value="완료">작업 중</option>
                </select>
      <button class="task-person bg-blue-400">낮음</button>
      </div>
            </div>
            <div class="mt-6 card-actions justify-end">
      <button class="btn btn-primary">보기</button>
    </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="../common/foot.jsp" %>
