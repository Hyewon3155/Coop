<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="프로젝트 생성" />
<%@ include file="../common/head.jsp" %>
<script>
      

      function submitForm(form) {
  		
  		form.title.value = form.title.value.trim();
  		if (form.title.value.length == 0) {
  			alert('프로젝트명을 입력해주세요');
  			form.title.focus();
  			return;
  		}
  		form.body.value = form.body.value.trim();
  		if (form.title.value.length == 0) {
  			alert('설명을 입력해주세요');
  			form.title.focus();
  			return;
  		}
  		form.startDate.value = form.startDate.value.trim();
  		if (form.startDate.value.length == 0) {
  			alert('시작날짜를 선택해주세요');
  			form.startDate.focus();
  			return;
  		}
  		form.endDate.value = form.endDate.value.trim();
  		if (form.endDate.value.length == 0) {
  			alert('종료날짜를 선택해주세요');
  			form.startDate.focus();
  			return;
  		}
  		if (form.startDate.value >= form.endDate.value) {
			alert('종료 날짜는 시작 날짜보다 커야 합니다.');
			form.endDate.focus();
	        return;
	    } 
 
  		  form.submit();
  	}
    	   
  	
 </script>
  <style>
    nav {
       height: 100vh;
       width: 100%:
    }
    
    body {
    overflow: hidden; /* 스크롤바를 숨깁니다. */
  }
 </style>
<nav class="bg-gray-200 py-10">
    <div class="max-w-2xl mx-auto bg-white p-8 rounded-lg shadow-md">
        <h1 class="text-2xl mb-4">새 프로젝트 만들기</h1>
		<form action="doCreate"  method="POST" onsubmit="submitForm(this); return false;">
            <!-- 프로젝트 이름 -->
            <label for="projectName" class="block mb-2 text-base font-bold">프로젝트 이름</label>
            <input type="text" name="title" class="w-full p-2 mb-4 border rounded" placeholder="프로젝트 이름을 입력해주세요">

            <!-- 템플릿 선택 -->
            <label for="templateChoice" class="block mb-2 text-base font-bold">프로젝트 설명</label>
            <input type="text" name="body" class="w-full p-2 mb-4 border rounded" placeholder="프로젝트 설명을 입력해주세요">

            <!-- 설명 -->
            <label for="description" class="block mb-2 text-base font-bold">날짜</label>
          <div class="flex justify-around">
           <!-- 설명 -->
            <label for="description" class="block mb-2 text-sm font-medium">시작일</label>
           <label for="description" class="block mb-2 text-sm font-medium">종료일</label>
          </div>
          
          <label class="flex">
          <input type="date" name="startDate" class="w-full p-2 mb-4 border rounded"/>-<input type="date" name="endDate" class="w-full p-2 mb-4 border rounded"/>
          </label>

<div class="flex justify-around mt-10">
         <button class="btn w-1/3 btn-warning font-bold text-base"> 뒤로가기</button> 
      <button class="btn w-1/3 p-2 border rounded btn-success font-bold text-base">프로젝트 생성</button> 
      </div>
      </form>    
</div>
</nav>
<%@ include file="../common/foot.jsp" %>