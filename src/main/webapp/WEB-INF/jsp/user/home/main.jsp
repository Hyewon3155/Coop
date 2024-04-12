<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Main" />
<%@ include file="../common/head.jsp" %>
<div id="name_font" class="grid grid-cols-2">
    <div class="relative h-screen bg-cover main_bg_img flex justify-center items-center">
        <div class="text-center">
            <div class="w-45 h-45 rounded-full overflow-hidden">
                <img src="/resource/images/KakaoTalk_20240411_191954306.jpg" class="w-full h-full object-cover">
            </div>
        </div>
    </div>
    <div class="relative h-screen flex flex-col justify-center items-center">
	        <h1 class="text-black text-center">
	            김혜원
	        </h1>
	        <br>
        <h1 class="text-black text-center text-xl mt-4">
            학교 : 서원대학교 컴퓨터공학과
        </h1>
        <h1 class="text-black text-center text-xl mt-4">
            전화번호 : 010-3028-6587
        </h1>
         <h1 class="text-black text-center text-xl mt-4">
            이메일 : kho3155@naver.com
        </h1>
    <a href="../group/create">
    <button class="btn btn-wide btn-outline mt-4"><i class="bi bi-plus-circle mr-2"></i>더보기</button>
</a>
 </div>
</div>

<%@ include file="../common/foot.jsp"%>