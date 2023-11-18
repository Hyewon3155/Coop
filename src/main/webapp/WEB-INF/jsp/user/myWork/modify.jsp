<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="작업 수정" />
<%@ include file="../common/head.jsp" %>
<nav class="bg-gray-200 py-10">
    <div class="max-w-2xl mx-auto bg-white p-8 rounded-lg shadow-md">
        <h1 class="text-2xl mb-4">할 일 수정</h1>
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

            <!-- 추가 필드들 -->
      <div  class="justify-center flex">
  <button class="btn btn-warning mt-2 ">선택</button>  
      </div>
      <label for="field1" class="block mb-2 text-base font-bold">우선순위</label>
      <div class="w-full flex text-white">
       <button class="task-person bg-blue-400">낮음</button>
        <button class="task-person bg-red-300">중간</button>
        <button class="task-person bg-red-400">높음</button>
      </div>
 <div class="flex justify-around mt-10">
         <button class="flex btn w-1/3 mr-2 btn-warning font-bold text-base">뒤로가기</button> 
      <button class="flex btn w-1/3 p-2 mr-2 border rounded btn-success font-bold text-base">수정</button> 
      <button class="flex btn w-1/3 p-2 border rounded btn-error font-bold text-base">삭제</button> 
      </div>
      </form>    
</div>
</nav>
<%@ include file="../common/foot.jsp" %>
