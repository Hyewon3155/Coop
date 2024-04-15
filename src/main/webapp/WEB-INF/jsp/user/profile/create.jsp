<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="내 프로필 생성" />
<%@ include file="../common/head.jsp" %>
<script>
      function previewImage(event) {
        var reader = new FileReader();
        reader.onload = function() {
          var preview = document.getElementById("preview-image");
          preview.src = reader.result;
        }
        reader.readAsDataURL(event.target.files[0]);
      }
      
      function validateEmail(email) {
    	    // 이메일 형식을 검사하는 정규 표현식
    	    var re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    	    return re.test(email);
    	}
      
      function join_submitForm(form) {
    	
    	  form.photo.value = form.photo.value.trim();
    		if (form.photo.value.length == 0) {
    			alert('사진을 업로드해주세요');
    			return;
    		}
  		
  		form.name.value = form.name.value.trim();
  		if (form.name.value.length == 0) {
  			alert('이름을 입력해주세요');
  			form.name.focus();
  			return;
  		}
  		
  		form.school.value = form.school.value.trim();
  		if (form.school.value.length == 0) {
  			alert('학교를 입력해주세요');
  			form.school.focus();
  			return;
  		}
  		
  		form.depart.value = form.depart.value.trim();
  		if (form.depart.value.length == 0) {
  			alert('학과를 입력해주세요');
  			form.depart.focus();
  			return;
  		}
  		
  		form.phone1.value = form.phone1.value.trim();
  		form.phone2.value = form.phone2.value.trim();
  		form.phone3.value = form.phone3.value.trim();
  		

  		if (form.phone1.value.length == 0 || form.phone2.value.length == 0 || form.phone3.value.length == 0) {
  			alert('전화번호를 입력해주세요');
  			form.phone1.focus();
  			return;
  		}
  		

  		form.email.value = form.email.value.trim();
  		if (form.email.value.length == 0) {
  			alert('이메일을 입력해주세요');
  			form.email.focus();
  			return;
  		}
  		
  		 if (!validateEmail(form.email.value)) {
  	        alert('올바른 이메일 형식이 아닙니다');
  	        form.email.focus();
  	        return;
  	    }

  		
  		form.submit();
  	}
</script>
 <nav class="pb-10 h-full">
     <div class="w-3/4 mx-auto">
     <h2 class="font-bold text-2xl mt-10">프로필 생성</h2>
     </div>
    <div class="w-3/4 mx-auto p-3 rounded-lg shadow-md mt-10">
       <form action="doJoin" method="POST" enctype="multipart/form-data" onsubmit="join_submitForm(this); return false;">
    <div>
				<table class="table w-full">
					<colgroup>
						<col width="200"/>
					</colgroup>
					<tbody>
						<tr>
    <th>프로필 사진</th>
    <td>
        <div class="flex justify-start text-center ml-2">
            <div class="w-1/6 rounded-full overflow-hidden">
                <img id="preview-image" src="https://igender.snu.ac.kr/wp-content/uploads/sites/23/2022/03/%EB%B9%88-%ED%94%84%EB%A1%9C%ED%95%84.png" class="w-full h-full object-cover">
            </div>
       </div>
	    <div class="flex ml-2 cursor-pointer w-1/6 justify-center mt-2 border-2 items-center rounded border-black-200 p-1">
	            <label for="file" class="flex text-center p-1 cursor-pointer">
	                    <i class="bi bi-image pr-1"></i>
	                    사진 선택
	                <input type="file" id="file" name="photo" class="hidden" accept="image/*" onchange="previewImage(event)">
	            </label>
	    </div>
    </td>
</tr>

						<tr>
							<th>이름</th>
							<td><input class="input input-bordered w-2/6 ml-2" type="text" name="name" placeholder="이름을 입력해주세요" /></td>
						</tr>
 						<tr>
							<th>학교</th>
							<td><input class="input input-bordered w-20 ml-2" type="text" name="school"/> 대학교 <input class="input input-bordered w-32 ml-2" type="text" name="depart"/> 과</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input class="input input-bordered w-24 ml-2" type="text" name="phone1"/>-<input class="input input-bordered w-24" type="text" name="phone2"/>-<input class="input input-bordered w-24" type="text" name="phone3"/></td>
						</tr>
						<tr>
							<th>메일</th>
							<td><input class="input input-bordered w-2/6 ml-2" type="email" name="email" placeholder="메일을 입력해주세요" /></td>
						</tr>
					</tbody>
				</table>
				</div>
	    <div class="flex mt-2 items-center justify-center">
	       <button class="btn btn-outline mr-2">생성</button>
	       <button class="btn-text-link btn btn-active " type="button" onclick="history.back();">취소</button>
	    </div>
	    </form>
  </div>
  </nav>
<%@ include file="../common/foot.jsp" %>