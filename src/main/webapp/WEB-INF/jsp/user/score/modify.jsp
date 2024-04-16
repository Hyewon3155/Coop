<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="학점 정보 추가" />
<%@ include file="../common/head.jsp" %>
<script>
    function join_submitForm(form) {
        form.name.value = form.name.value.trim();
        if (form.name.value.length == 0) {
            alert('교과목명을 입력해주세요.');
            form.name.focus();
            return;
        }
        
        let subject = $('#subject').val();

        if(!subject){
            alert("이수 구분을 선택해주세요.");
            $('#subject').focus();
            return false;
        }
        
        let semester = $('#semester').val();

        if(!semester){
            alert("학기를 선택해주세요.");
            $('#semester').focus();
            return false;
        }
        
        let credit = $('#credit').val();

        if(!credit){
            alert("학점을 선택해주세요.");
            $('#credit').focus();
            return false;
        }
        
        let rank = $('#rank').val();

        if(!rank){
            alert("등급을 선택해주세요.");
            $('#rank').focus();
            return false;
        }
        
        let grade = $('#grade').val();

        if(!grade){
            alert("평점을 선택해주세요.");
            $('#grade').focus();
            return false;
        }


        form.submit();
    }
</script>

 <nav class="pb-10 h-full">
 <div class="w-3/4 mx-auto">
     <h2 class="font-bold text-2xl mt-10">학점 정보 수정</h2>
     </div>
    <div class="w-3/4 mx-auto bg-white p-3 rounded-lg shadow-md mt-10">
           <form action="doModify" method="POST" onsubmit="join_submitForm(this); return false;">
    <div class="table-box-type-1">
				<table class="table w-full">
					<colgroup>
						<col width="200"/>
					</colgroup>
					<tbody>
						<tr>
							<th>교과목명</th>
							<td><input class="input input-bordered w-2/4 ml-2" type="text" name="name" placeholder="교과목명을 입력해주세요" value="${score.name}"/></td>
						</tr>
 						<tr>
							<th>이수구분</th>
							<td>
								<select class="select select-ghost w-full max-w-xs ml-2" id="subject">
								     <option disabled selected value="">이수구분</option>
								    <option value="교양필수">교양필수</option>
								    <option value="교양선택">교양선택</option>
								    <option value="전공필수">전공필수</option>
								    <option value="전공선택">전공선택</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>수강일시</th>
							<td><input class="input input-bordered w-32 ml-2" type="number" name="year" value="2024"/> 학년도 
							<select class="select select-ghost w-32 max-w-xs ml-2" id="semester">
									<option disabled selected value="">학기 선택</option>
								    <option value="1">1</option>
								    <option value="2">2</option>
								    <option value="여름">여름</option>
								    <option value="겨울">겨울</option>
								</select> 학기</td>
						</tr>
						<tr>
							<th>학점</th>
							<td>
							   <select class="select select-ghost w-32 max-w-xs ml-2" id="credit">
							   		<option disabled selected value="">학점 선택</option>
								    <option value="1">1</option>
								    <option value="2">2</option>
								    <option value="3">3</option>
							   </select> 학점
							</td>
						</tr>
						<tr>
							<th>등급</th>
							<td>
							   <select class="select select-ghost w-32 max-w-xs ml-2" id="rank">
							   		<option disabled selected value="">등급 선택</option>
								    <option value="A+">A+</option>
								    <option value="A">A</option>
								    <option value="B+">B+</option>
								    <option value="B">B</option>
								    <option value="C+">C+</option>
								    <option value="C">C</option>
								    <option value="F">F</option>
								    <option value="P">P</option>
							   </select>
							</td>
						</tr>
						<tr>
							<th>평점</th>
							<td>
							   <select class="select select-ghost w-32 max-w-xs ml-2" id="grade">
							   		<option disabled selected value="">평점 선택</option>
								    <option value="4.5">4.5</option>
								    <option value="4">4</option>
								    <option value="3.5">3.5</option>
								    <option value="3">3</option>
								    <option value="2.5">2.5</option>
								    <option value="2">2</option>
								    <option value="1.5">1.5</option>
								    <option value="0">0</option>
							   </select>
							</td>
						</tr>
					</tbody>
				</table>
				</div>
 <div class="flex mt-2 items-center justify-center">
	       <button class="btn btn-outline mr-2">수정</button>
	       <button class="btn-text-link btn btn-active " type="button" onclick="history.back();">취소</button>
	    </div>
	    </form>
  </div>
  </nav>
<%@ include file="../common/foot.jsp" %>