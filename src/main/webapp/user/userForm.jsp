<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- 우편번호 검색 api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(document).ready(function(){
		var msg = '${msg}';
		if(msg != ''){
			alert(msg);
			msg = '';
		}
		//주소찾기 버튼 이벤트 클릭 이벤트 핸들러
		$("#search").on("click", function(){
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            
		            // 주소 input value에 설정 data.roadAddress;
		            // 우편번호 input value에 설정 data.zonecode;
		            
		            console.log("주소 : " + data.roadAddress);
		            console.log("우편번호 : " + data.zonecode);
		         	$("#addr1").val(data.roadAddress);
		         	$("#zipcd").val(data.zonecode);
		        }
		    }).open();
		})
		//사용자 등록 버튼 클릭 이벤트 핸들러
		$("#userRegBtn").on("click", function(){
			//유효성 체크 지금은 넘어감
			
			//여기까지 도달하면 유효성 검사 완료(submit 할 차례)
			$("#frm").submit();
		});
		
		//개발용 데이터 초기화 함수 ***********추후 지울것
		dataInit();
	})
	
	function dataInit(){
		$("#userId").val("userTest");
		$("#name").val("대덕");
		$("#alias").val("빌딩");
		$("#addr1").val("대전광역시 중구 중앙로 76");
		$("#addr2").val("영민빌딩 2층 204호");
		$("#zipcd").val("34940");
		$("#birth").val("2019-05-31");
		$("#pass").val("userTest1234");
		
	}
</script>
<title>사용자 등록</title>
<%@include file="/common/basicLib.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<!-- left -->
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자 등록</h2>

						<form action = "${cp}/userForm"
							  id="frm" 
							  class="form-horizontal" 
							  role="form" 
							  method="post"
							  enctype="multipart/form-data">
							  
							<div class="form-group">
								<label for="filename" class="col-sm-2 control-label">사용자 사진</label>
								<div class="col-sm-10">
									<input type="file" id="profile"
									name="profile" placeholder="사용자 아이디">
								</div>
							</div>
							
							<div class="form-group">
								<label for="userId" class="col-sm-2 control-label">사용자ID</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="userId"
									name="userId" placeholder="사용자 아이디" value="${param.userId}">
								</div>
							</div>
							
							<div class="form-group">
								<label for="pass" class="col-sm-2 control-label">비밀번호</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="pass"
									name="pass" placeholder="비밀번호" value="${param.pass}">
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자	이름</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name"
									name="name" placeholder="이름" value="${param.name}">
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">별명</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="alias"
									name="alias" placeholder="별명" value="${param.alias}">
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">주소</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="addr1"
									name="addr1" placeholder="주소" readonly value="${param.addr1}">
								</div>
								<div class = "col-sm-1 ">
									<button id = "search" type = "button" class="btn btn-default pull-right">주소검색</button>
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">상세주소</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="addr2"
									name="addr2" placeholder="상세주소" value="${param.addr2}">
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">우편번호</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="zipcd"
									name="zipcd" placeholder="우편번호" readonly value="${param.zipcd}">
								</div>
							</div>

							<div class="form-group">
								<label for="birth" class="col-sm-2 control-label">생일</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="birth"
									name="birth" placeholder="생일" value="${param.birth}">
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id = "userRegBtn" type="button" class="btn btn-default">사용자 등록</button>
								</div>
							</div>
						</form>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>