<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="내 정보 수정" />
<%@ include file="../common/head.jsp" %>
 <nav class="pb-10 h-full">
     <div class="w-3/4 mx-auto">
     <h2 class="font-bold text-2xl mt-10">프로필 수정</h2>
     </div>
    <div class="w-3/4 mx-auto p-3 rounded-lg shadow-md mt-10">
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
                <img src="/resource/images/KakaoTalk_20240411_191954306.jpg" class="w-full h-full object-cover">
            </div>
       </div>
        <div class="flex ml-2 cursor-pointer w-1/6 justify-center mt-2 border-2 items-center rounded border-black-200 p-1">
            <label for="file" class="flex text-center p-1 cursor-pointer">
                    <i class="bi bi-image pr-1"></i>
                    사진 선택
                <input type="file" id="file" name="profile-photo" class="hidden" accept="image/*" onchange="previewImage(event)">
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
							<td><input class="input input-bordered w-20 ml-2" type="text" name="school"/> 대학교 <input class="input input-bordered w-32 ml-2" type="text" name="school"/> 과</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input class="input input-bordered w-24 ml-2" type="text" name="phone"/>-<input class="input input-bordered w-24" type="text" name="phone"/>-<input class="input input-bordered w-24" type="text" name="phone"/></td>
						</tr>
						<tr>
							<th>메일</th>
							<td><input class="input input-bordered w-2/6 ml-2" type="email" name="email" placeholder="메일을 입력해주세요" /></td>
						</tr>
					</tbody>
				</table>
				</div>
	    <div class="flex mt-2 items-center justify-center">
	       <a class="btn btn-outline mr-2" href="modify?id=${notice.id }">적용</a>
	       <button class="btn-text-link btn btn-active " type="button" onclick="history.back();">취소</button>
	    </div>
  </div>
  </nav>
<%@ include file="../common/foot.jsp" %>