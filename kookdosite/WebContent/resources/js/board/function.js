function del(subject){
	de_subject = subject;
	d_mo.de_subject.value = de_subject;
}
function modal_de(){
	d_mo.method="POST";
	d_mo.submit();
}

function businesstripreport_write(){
	businesstripreport.submit();
}

function businesstripreport_list(){
	businesstripreport.submit();
}
























function test_data_insert(){
	$.ajax({
		url : "testdatainsert.do",
		dataType : "json",
		type : "get",
		async : false,
		data : queryString,
		success : function(responseData){
			var data = responseData.user;
			if(data == null){
				alert("아이디와 비밀번호를 확인해주세요.");
				return false;
			} else if ( data.user_state == 1){
				alert("비활성화된 계정입니다. \n로그인이 불가능 합니다.");
				return false;
			}
			$("#login").modal("hide");
			if( responseData.user.user_level == 2){
				location.href = "adminMain.do";
			} else {
				location.href="main.do";
			}
			if( responseData.user.tmppwd_tf == 1 ) {
				alert("임시비밀번호로 로그인하였습니다.\n비밀번호를 변경해주세요!");
				location.href = "userpwd.do";
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
	        alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
	    }
	});
	
}

// 엔터키로 로그인
$("#pwd").on("keypress", function (event) {
	if (event.keyCode == 13) {
		logincheck();
	}
});
$("#email").on("keypress", function (event) {
	if (event.keyCode == 13) {
		logincheck();
	}
});