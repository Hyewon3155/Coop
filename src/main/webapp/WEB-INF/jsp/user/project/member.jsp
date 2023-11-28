<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="프로젝트 생성" />
<%@ include file="../common/head.jsp" %>
<script>
function searchMember(){
    var searchKeyword = document.getElementById('searchKeyword').value;
    var searchKeywordType = document.getElementById('searchKeywordType').value;

    $.get('searchMember', {
        searchKeywordType : searchKeywordType,
        searchKeyword : searchKeyword,
    }, function(data) {
        if (data.success) {
            var tableContent = "<table><tr><th>체크</th><th>번호</th><th>이름</th><th>부서</th></tr>";

             // c:forEach 대체
             data.data1.forEach(function(member) {
                 tableContent += "<tr><td><input type='checkbox' name='memberCheckbox' class='memberCheckbox' value='" + member.id + "'></td><td>" + member.id + "</td><td>" + member.name + "</td><td>" + member.depart + "</td></tr>";

             });

             tableContent += "</table>";
             document.getElementById('memberTable').innerHTML = tableContent;
         } else {
             alert(data.msg);
             return;
         }
    }, 'json');
  
}

function joinProjectMember() {
	var memberId = $("input:checkbox[name='memberCheckbox']:checked").val();
    var project_id = document.getElementById('projectId').value;

    alert(memberId);
    $.get('joinProjectMember', {// 올바른 URL을 사용합니다.
            memberId: memberId,
            project_id: project_id,

    }, function(data) {
           if (data.success) {
               alert('추가되었습니다');
            } else {
                alert(data.msg);
            }
        }, 'json');
}


</script>

 <style>
    nav {
       height: 100vh;
       width: 100%:
    }
 </style>
<nav class="bg-gray-200 py-10">
<input type="hidden" id="projectId" value="${project_id}" />

    <div class="max-w-2xl mx-auto bg-white p-8 rounded-lg shadow-md">
        <h1 class="text-2xl mb-4">팀원 추가하기</h1>
          <div class="join flex justify-center">
  <div class="mb-2">
    <div>
      <input class="input input-bordered join-item mr-2" id="searchKeyword"  placeholder="Search"  value="${searchKeyword }"/>
    </div>
  </div>
  <select data-value="${searchKeywordType }" class="select select-bordered join-item mr-2"  id="searchKeywordType">
    <option disabled selected>부서명</option>
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
    <button class="btn join-item" id="insertHtml" onclick="searchMember();">Search</button>
</div>
  <div class="overflow-x-auto" id="memberTable">
  </div>

<div class="flex justify-around mt-10">
         <button class="btn w-1/3 btn-warning font-bold text-base" onclick="history.back();"> 뒤로가기</button> 
      <button class="btn w-1/3 p-2 border rounded btn-success font-bold text-base" onclick="joinProjectMember();">추가하기</button> 
      </div>
      </div>
</nav>
<%@ include file="../common/foot.jsp" %>