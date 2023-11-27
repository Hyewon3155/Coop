 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="전체 프로젝트 조회" />
<%@ include file="../common/head.jsp" %> 
<style>
	.check-grid-container {
	            display: grid;
	            grid-template-columns: 1fr 1fr 1fr; /* 3개의 열 생성 */
	            grid-template-rows: 1fr 1fr; /* 2개의 행 생성 */
	            grid-gap: 10px; /* 그리드 아이템 간격 설정 */
	  			height:100%;
	  			width:100%;
	          
	        }
	
	.check-grid-item {
	    display: flex;
	    align-items: center;
	    font-size: 16px;
	}

</style>

  <div class="mt-5 text-xl font-semibold"><h2>총 : ${projectsCnt } 개</h2></div>

  <div class="check-grid-container">
  <c:forEach items="${projects}" var="project">
    <div class="check-grid-item">
      <div class="card w-full h-full bg-base-100 shadow-xl">
        <div class="card-body">
          <div class="mb-5">
          <h2 class="text-xl font-bold">${project.title }</h2> 
          </div>
          <ul style="list-style-type: disc;">
     <li>
       <span>설명:  ${project.body }</span>
            </li>
      <li>
        <span>날짜: ${project.startDate.substring(0, 10) }~${project.endDate.substring(0, 10) }</span>
            </li>
            </ul>
          <div class="mt-6 card-actions justify-end">
      <button class="btn btn-primary">바로가기</button>
    </div>
        </div>
      </div>
      
    </div>
        </c:forEach>
  </div>
  
  <div class="mt-2 flex justify-center">
	 <div class="btn-group">
		<c:set var="pageMenuLen" value="5" /> <!-- 한 화면에 출력할 페이지 번호 수 -->
		<c:set var="startPage" value="${page - pageMenuLen >= 1 ? page - pageMenuLen : 1 }" />
					<c:set var="endPage" value="${page + pageMenuLen <= pagesCount ? page + pageMenuLen : pagesCount }" />
									
					<c:if test="${page == 1 }">
						<a class="btn btn-sm btn-disabled">«</a>
						<a class="btn btn-sm btn-disabled">&lt;</a>
					</c:if>
					<c:if test="${page > 1 }">
						<a class="btn btn-sm" href="page=1">«</a>
						<a class="btn btn-sm" href="page=${page - 1 }">&lt;</a>
					</c:if>
					<c:forEach begin="${startPage }" end="${endPage }" var="i">
						<a class="btn btn-sm ${page == i ? 'btn-active' : '' }" href="?page=${i }" id="abc" onclick="test();">${i }</a>
					</c:forEach>
					<c:if test="${page < pagesCount }">
						<a class="btn btn-sm" href="page=${page + 1 }">&gt;</a>
						<a class="btn btn-sm" href="page=${pagesCount }">»</a>
					</c:if>
					<c:if test="${page == pagesCount }">
						<a class="btn btn-sm btn-disabled">&gt;</a>
						<a class="btn btn-sm btn-disabled">»</a>
					</c:if>
		</div>
	</div>
<%@ include file="../common/foot.jsp" %> 
