<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="작업 할당" />
<%@ include file="../common/head.jsp" %>
<nav class="bg-gray-200 py-10">
    <div class="max-w-2xl mx-auto bg-white p-8 rounded-lg shadow-md">
        <h1 class="text-2xl mb-4">작업 할당</h1>
<form>
            <!-- 프로젝트 이름 -->
            <label for="projectName" class="block mb-2 text-base font-bold">작업명</label>
            <input type="text" id="projectName" class="w-full p-2 mb-4 border rounded" placeholder="프로젝트 이름을 입력해주세요">

            <!-- 템플릿 선택 -->
            <label for="templateChoice" class="block mb-2 text-base font-bold">작업 설명</label>
            <input type="text" id="templateChoice" class="w-full p-2 mb-4 border rounded" placeholder="프로젝트 설명을 입력해주세요">

            <!-- 설명 -->
            <label for="description" class="block mb-2 text-base font-bold">날짜</label>
          <div class="flex justify-around">
           <!-- 설명 -->
            <label for="description" class="block mb-2 text-sm font-medium">시작일</label>
           <label for="description" class="block mb-2 text-sm font-medium">종료일</label>
          </div>
          
          <label class="flex">
          <input type="date"   class="w-full p-2 mb-4 border rounded"/>-<input type="date"   class="w-full p-2 mb-4 border rounded"/>
          </label>

          <label for="field1" class="block mb-2 text-base font-bold">팀원 추가</label>
          <div class="join flex">
  <div class="mb-2">
    <div>
      <input class="input input-bordered join-item mr-2" placeholder="Search"/>
    </div>
  </div>
  <select class="select select-bordered join-item mr-2">
    <option disabled selected>부서명</option>
   <option>경영/전략 기획부</option>
  <option>인사/인재개발 부</option>
  <option>재무/회계부</option>
  <option>마케팅/영업부</option>
  <option>연구개발(R&D) / 기술부</option>
            <option>IT부</option>
  </select>
    <button class="btn join-item" id="insertHtml">Search</button>
</div>
  <div class="overflow-x-auto">
  <table class="table">
    <!-- head -->
    <thead>
      <tr>
        <th>
          <label>
            <input type="checkbox" class="checkbox" />
          </label>
        </th>
        <th>아이디</th>
        <th>이름</th>
        <th>부서</th>
        <th></th>
      </tr>
    </thead>
      <!-- row 1 -->
     <tr>
        <th>
          <label>
            <input type="checkbox" class="checkbox" />
          </label>
        </th>
       <th>5</th>
       <th>김혜원</th>
       <th>IT부</th>
      </tr>

  </table>
</div>
      <div  class="justify-center flex">
  <button class="btn btn-warning mt-2 ">추가하기</button>  
      </div>
      <label for="field1" class="block mb-2 text-base font-bold">우선순위</label>
      <div class="w-full flex text-white">
       <button class="task-person bg-blue-400">낮음</button>
        <button class="task-person bg-red-300">중간</button>
        <button class="task-person bg-red-400">높음</button>
      </div>
 <div class="flex justify-around mt-10">
         <button class="btn w-1/3 btn-warning font-bold text-base">뒤로가기</button> 
      <button class="btn w-1/3 p-2 border rounded btn-success font-bold text-base">작업 할당</button> 
      </div>
      </form>  
      </div>
      </nav>
      <%@ include file="../common/foot.jsp" %>
      
      