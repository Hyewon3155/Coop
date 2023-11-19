<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Modify" />
<%@ include file="../common/head.jsp" %>

<script>
	function handleSubmit() {
	    var selectElement = document.getElementById('position_level');
	    var selectedValue = parseInt(selectElement.value, 10); // 문자열을 정수로 변환
	
	    // 여기서 selectedValue를 사용하여 원하는 처리를 할 수 있습니다.
	    console.log("선택된 직급 값:", selectedValue);
	
	    // 폼 제출을 막기 위해 false를 반환합니다. 실제 사용시에는 필요에 따라 변경하세요.
	    return false;
	}
	
	function join_submitForm(form) {
		
		form.name.value = form.name.value.trim();
		if (form.name.value.length == 0) {
			alert('이름을 입력해주세요');
			form.name.focus();
			return;
		}
		
		form.company.value = form.company.value.trim();
		if (form.company.value.length == 0) {
			alert('회사명을 입력해주세요');
			form.company.focus();
			return;
		}
		
		form.cellphoneNum.value = form.cellphoneNum.value.trim();
		if (form.cellphoneNum.value.length == 0) {
			alert('전화번호를 입력해주세요');
			form.cellphoneNum.focus();
			return;
		}
		
		form.email.value = form.email.value.trim();
		if (form.email.value.length == 0) {
			alert('이메일을 입력해주세요');
			form.email.focus();
			return;
		}
		
		form.submit();
	}
</script>
<section class="mt-5 flex container mx-auto justify-center">
  <div class="mx-auto">
   <form action="doModify" method="POST" onsubmit="join_submitForm(this); return false;">
    <h1 class="block font-semibold mb-2">ID</h1>
      <i class="fas fa-user mr-2"></i>
      <span>${rq.loginedMember.loginId }</span>
      <hr class="mt-2">
      <h1 class="block font-semibold mb-2">가입일</h1>
      <i class="fa-solid fa-user-lock mr-2"></i>
      <span>${rq.loginedMember.regDate}</span>
      <hr class="mt-2">
      <h1 class="block font-semibold mb-2">회사</h1>
      <i class="fa-solid fa-people-group mr-2"></i>
      <input type="text" name="company" value=${rq.loginedMember.company }>
      <hr class="mt-2">
      <h1 class="block font-semibold mb-2">직급</h1>
	  <select class="select select-bordered select-sm w-full max-w-xs" id="position_level" name="position">
		  <option value=${rq.loginedMember.position } style="display: none;"selected>
		   <c:if test="${rq.loginedMember.position == 1  }">
		   		부장 이상
		   </c:if>
		   <c:if test="${rq.loginedMember.position == 0  }">
		   		부장 미만
		   </c:if>
          </option>
		  <option value="1">부장 이상</option>
		  <option value="0">부장 미만</option>
	  </select>
      <hr class="mt-2">
      <h1 class="block font-semibold mb-2">부서</h1>
      <select class="select select-bordered select-sm w-full max-w-xs" name="depart">
		  <option value=${rq.loginedMember.depart } style="display: none;" selected >${rq.loginedMember.depart }</option>
		  <option value="인사부">인사부</option>
	       <option value="재무부">재무부</option>
	       <option value="운영부">운영부</option>
	       <option value="마케팅부">마케팅부</option>
	       <option value="영업부">영업부</option>
	       <option value="IT부">IT부</option>
	       <option value="연구개발부">연구개발부</option>
	        <option value="생산부">생산부</option>
	        <option value="고객관리부">고객관리부</option>     
	</select>
      <hr class="mt-2">
      <h1 class="block font-semibold mb-2 mt-2">이름</h1>
      <i class="fas fa-user mr-2"></i>
      <input type="text" name="name" value=${rq.loginedMember.name }>
      <hr class="mt-2">
      <h1 class="block font-semibold mb-2 mt-2">닉네임</h1>
      <i class="fas fa-user mr-2"></i>
      <input type="text" name="nickname" value=${rq.loginedMember.nickname }>
      <hr class="mt-2">
      <h1 class="block font-semibold mb-2 mt-2">이메일</h1>
      <i class="fa-solid fa-envelope mr-2"></i>
      <input type="text" name="email" value=${rq.loginedMember.email }>
      <hr class="mt-2">
      <h1 class="block font-semibold mb-2 mt-2">전화번호</h1>
      <i class="fa-solid fa-mobile-screen mr-2"></i>
      <input type="text" name="cellphoneNum" value=${rq.loginedMember.cellphoneNum }>
      <hr class="mt-2">
      <br>
    <div class="btns mt-2 flex justify-between">
	  <button class="btn-text-link btn btn-active mr-2" type="button" onclick="history.back();">뒤로가기</button>
	  <div>
			<a class="btn btn-warning" href="passwordModify">비밀번호 변경</a>
			<button class="btn btn-success">수정</button>
	  </div>
    </div>
   </form>
  </div>
</section>
<%@ include file="../common/foot.jsp" %>