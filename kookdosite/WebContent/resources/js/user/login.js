	$("#password").on("keypress", function (event) {
		if (event.keyCode == 13) {
			
			login();
		}
	});
	$("#userId").on("keypress", function (event) {
		if (event.keyCode == 13) {
			
			login();
		}
	});

	function login() {
	    if ($('#userId').val() == '') {
	        alert('계정(아이디)를 입력해 주세요.');
	        $('#userId').focus();
	        return false;
	    }
	    if ($('#password').val() == null ||$('#password').val() == ""  ) {
	        alert('비밀번호를 입력해 주세요.');
	        $('#password').focus();
	       return;
	    }
	    
	    
		 $.ajax({
		     url:"userLogin",
		     type:"post",
		     data:$("#loginData").serialize(),
		     success:function(data){
		         resultLogin(data.retType, data.retString);
		     }, error   :   function(data){
		         alert(data + "시스템 에러가 발생하였습니다.");
		     }
		 });
	}
	
	function resultLogin(retType, retString ) {

		if(retType == "5001") {
			alert(retString);
//			$("#loading").hide();
		} else if(retType == "5002") {
			alert(retString);
//	        $("#loading").hide();
		} else if(retType == "5003") {
			alert(retString);
//	        $("#loading").hide();
		} else if(retType == "0000") {
			console.log("retType===>"+retType);
//			var url = "<c:url value='/' />"+retString ;
//			console.log("url===>"+url);
			location.href="home.do";
		}
		
	}
	