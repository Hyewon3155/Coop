<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="${notice.title }" />
<%@ include file="../common/head.jsp" %>
<style>
  #title {
            width: 100%;
            padding: 10px;
            border: none;
            border-bottom: 2px solid #afafaf; /* 밑줄 스타일 지정 */
            outline: none; /* 포커스 시 기본 테두리 제거 */
            font-size: 2em;
        }
        
   nav.bg-gray-200 {
    width: 100%; /* 너비를 화면 전체로 설정 */
    height: 100%; /* 높이를 화면 전체로 설정 */
    position: fixed; /* 고정된 위치에 배치 */
    top: 0; /* 상단에서 시작 */
    left: 0; /* 왼쪽에서 시작 */
    z-index: -1; /* 다른 요소들이 위에 오도록 설정 */
  }
 
 </style>
 <nav class="bg-gray-200 py-10 h-full">
    <div class="w-3/4 mx-auto bg-white p-8 rounded-lg shadow-md mt-10">
    <div class="table-box-type-1">
				<table class="table w-full">
					<colgroup>
						<col width="200"/>
					</colgroup>
					<tbody>
						<tr>
							<th>작성자</th>
							<td><div class="badge">${notice.writerName }</div></td>
						</tr>
						<tr>
							<th>작성자 부서</th>
							<td><div class="badge">${notice.departName }</div></td>
						</tr>
						<tr>
							<th>작성일</th>
							<td><div class="badge">${notice.regDate }</div></td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${notice.title }</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>${notice.getForPrintBody() }</td>
						</tr>
					</tbody>
				</table>
				</div>
    <c:if test="${rq.loginedMemberId == notice.memberId }">
	    <div class="flex mt-2 w-full">
	       <a class="btn-warning p-2 font-semibold rounded-xl w-full mr-2 text-center" href="modify?id=${notice.id }">수정하기</a>
	       <a class="btn-error p-2 font-semibold rounded-xl w-full text-center" href="delete?id=${notice.id }">삭제하기</a>
	    </div>
    </c:if>
  <div class="mt-2 mx-auto">
    <div class="flex justify-start btns">
	    <button class="btn-text-link btn btn-active " type="button" onclick="history.back();">뒤로가기</button>
    </div>
  </div>
  </div>
  </nav>
<%@ include file="../common/foot.jsp" %>