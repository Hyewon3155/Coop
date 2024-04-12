<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="학점 정보 추가" />
<%@ include file="../common/head.jsp" %>
 <nav class="pb-10 h-full">
 <div class="w-3/4 mx-auto">
     <h2 class="font-bold text-2xl mt-10">학점 정보 추가</h2>
     </div>
    <div class="w-3/4 mx-auto bg-white p-3 rounded-lg shadow-md mt-10">
    <div class="table-box-type-1">
				<table class="table w-full">
					<colgroup>
						<col width="200"/>
					</colgroup>
					<tbody>
						<tr>
							<th>교과목명</th>
							<td><input class="input input-bordered w-2/4 ml-2" type="text" name="name" placeholder="교과목명을 입력해주세요" /></td>
						</tr>
 						<tr>
							<th>이수구분</th>
							<td>
								<select class="select select-ghost w-full max-w-xs ml-2">
								     <option disabled selected>이수구분</option>
								    <option value="startDateAsc">교양필수</option>
								    <option value="startDateDesc">교양선택</option>
								    <option value="endDateAsc">전공필수</option>
								    <option value="endDateDesc">전공선택</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>수강일시</th>
							<td><input class="input input-bordered w-32 ml-2" type="number" name="year" value="2024"/> 학년도 
							<select class="select select-ghost w-32 max-w-xs ml-2">
								    <option value="startDateAsc">1</option>
								    <option value="startDateDesc">2</option>
								    <option value="endDateAsc">여름</option>
								    <option value="endDateDesc">겨울</option>
								</select> 학기</td>
						</tr>
						<tr>
							<th>학점</th>
							<td>
							   <select class="select select-ghost w-32 max-w-xs ml-2">
								    <option value="startDateAsc">1</option>
								    <option value="startDateDesc">2</option>
								    <option value="endDateAsc">3</option>
							   </select> 학점
							</td>
						</tr>
						<tr>
							<th>등급</th>
							<td>
							   <select class="select select-ghost w-32 max-w-xs ml-2">
								    <option value="startDateAsc">A+</option>
								    <option value="startDateDesc">A</option>
								    <option value="endDateAsc">B+</option>
								    <option value="endDateAsc">B</option>
								    <option value="endDateAsc">C+</option>
								    <option value="endDateAsc">C</option>
								    <option value="endDateAsc">F</option>
								    <option value="endDateAsc">P</option>
							   </select>
							</td>
						</tr>
						<tr>
							<th>평점</th>
							<td>
							   <select class="select select-ghost w-32 max-w-xs ml-2">
								    <option value="startDateAsc">4.5</option>
								    <option value="startDateDesc">4</option>
								    <option value="endDateAsc">3.5</option>
								    <option value="endDateAsc">3</option>
								    <option value="endDateAsc">2.5</option>
								    <option value="endDateAsc">2</option>
								    <option value="endDateAsc">1.5</option>
							   </select>
							</td>
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
  <div class="flex mt-2 items-center justify-center">
	       <a class="btn btn-outline mr-2" href="modify?id=${notice.id }">적용</a>
	       <button class="btn-text-link btn btn-active " type="button" onclick="history.back();">취소</button>
	    </div>
  </div>
  </nav>
<%@ include file="../common/foot.jsp" %>