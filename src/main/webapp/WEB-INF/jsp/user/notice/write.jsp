<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="루틴 그룹 생성" />
<%@ include file="../common/head.jsp" %>
<%@ include file="../common/toastUiEditorLib.jsp" %>
 <script>
      

      function submitForm(form) {
  		
  		form.title.value = form.title.value.trim();
  		if (form.title.value.length == 0) {
  			alert('제목을 입력해주세요');
  			form.title.focus();
  			return;
  		}
  		 const editor = $(form).find('.toast-ui-editor').data('data-toast-editor');
  		  const markdown = editor.getMarkdown().trim();

  		  if (markdown.length == 0) {
  		    alert('내용을 입력해주세요');
  		    editor.focus();
  		    return;
  		  }
  		  
  		  form.body.value = markdown;
  		  
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
    <h1 class="text-3xl font-bold mt-5">글쓰기</h1>
  <form action="doWrite"  method="POST" onsubmit="submitForm(this); return false;">
     <input type="hidden" name="body" />
         <div class="flex justify-center items-center mt-10">
      <input class="w-full ml-2" type="text" name="title" placeholder="제목을 입력해주세요" />
   	</div>
    <div class="mx-auto mt-5">
      <div class="toast-ui-editor bg-white">
        <script type="text/x-template"></script>
      </div>
    </div>
    <div class="mt-2 mx-auto text-center w-full">
       <button class="btn-success p-5 w-full font-semibold rounded-xl">올리기</button>
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