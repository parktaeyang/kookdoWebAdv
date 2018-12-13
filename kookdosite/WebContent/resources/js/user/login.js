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
		     url:"Login.do",
		     type:"post",
		     data:$("#loginData").serialize(),
		     success:function(data){
		         resultLogin(data.code, data.message);
		     }, error   :   function(data){
		         alert(data.message + "시스템 에러가 발생하였습니다.");
		     }
		 });
	}
	
	function resultLogin(code, message ) {
		if(code == "404") {
			alert(message);
		} else if(code == "106") {
			alert(message)
		} else if(code == "200") {
			console.log("code===>"+code);
			location.href="index.do";
		}
		
	}
	