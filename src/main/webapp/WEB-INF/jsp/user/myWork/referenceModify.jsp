<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="루틴 그룹 생성" />
<%@ include file="../common/head.jsp" %>
 <script>
         var project_id = document.getElementsByName('project_id')[0].value;
         console.log(project_id);
 
		 function updateFileName() {
		     var fileInput = document.getElementById('file');
		     var fileNameDisplay = document.getElementById('fileNameDisplay');
		
		     if (fileInput.files.length > 0) {
		         fileNameDisplay.textContent = fileInput.files[0].name;
		     }
		 }
 

      function submitForm(form) {
    	    		
  		form.title.value = form.title.value.trim();
  		if (form.title.value.length == 0) {
  			alert('제목을 입력해주세요');
  			form.title.focus();
  			return;
  		}
  		
  		 form.file.value = form.file.value.trim();
	  	  if (form.file.value.length == 0) {
	  			alert('작업물을 선택해주세요');
	  			form.file.focus();
	  			return;
	      }
	  	  
	  	form.body.value = body.value.trim();
	  	  if (form.body.value.length == 0) {
	  			alert('작업물을 선택해주세요');
	  			form.body.focus();
	  			return;
	      }
  		  form.submit();
  	}
    	   
  	
 </script>
 <style>
  input[type="text"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-bottom: 2px solid #afafaf; /* 밑줄 스타일 지정 */
            outline: none; /* 포커스 시 기본 테두리 제거 */
        }
        
        input::placeholder {
			  color: gray;
			  font-size: 2em;
		}
 </style>
 <nav class="bg-gray-200 py-10">
    <div class="max-w-2xl mx-auto bg-white p-8 rounded-lg shadow-md">
    <h1 class="text-3xl font-bold mt-5">작업물 수정하기</h1>
  <form action="doReferenceModify" id="myForm" enctype="multipart/form-data" method="POST" onsubmit="submitForm(this); return false;">
         <div class="flex justify-center items-center mt-10">
      <input class="w-full ml-2" type="text" name="title" placeholder="제목을 입력해주세요" value="${file.title }" />
   	</div>
   	  
<div class="flex font-semibold items-center justify-center mt-5">
    <label for="file" class="flex w-full text-center p-1 cursor-pointer border-2 items-center rounded">
        <span class="btn">파일 선택</span>
        <input type="file" id="file" name="file" style="display:none;" onchange="updateFileName()" /> 
        <span id="fileNameDisplay" class="ml-2"><a href="/file/download/${file.id}" class="text-blue-500 underline">${file.original_fileName }</a></span>
    </label>
</div>
        <input type="hidden" name="id" value="${file.id }"/>
        <input type="hidden" name="project_id" value="${project_id }"/>
      
    <div class="mx-auto mt-5">
            <textarea class="w-full ml-2" rows=10 cols=50  name="body" placeholder="내용을 입력해주세요">${file.body }</textarea>
     </div>
    <div class="mt-2 mx-auto text-center w-full">
       <button class="btn-success p-5 w-full font-semibold rounded-xl">수정하기</button>
    </div>
  </form>
  <div class="mt-2 mx-auto">
    <div class="flex justify-start btns">
	    <button class="btn-text-link btn btn-active " type="button" onclick="history.back();">뒤로가기</button>
    </div>
  </div>
  </div>
  </nav>
<%@ include file="../common/foot.jsp" %>