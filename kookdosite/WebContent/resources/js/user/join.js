	function save() {
		
		if(!validCheck()) {
			return;
		}

	    
	}
	
	function validCheck() {
	    if ($('#userId').val() == '') {
	        alert('계정(아이디)를 입력해 주세요.');
	        $('#userId').focus();
	        return false;
	    }
	    if ($('#password').val() == null ||$('#password').val() == ""  ) {
	        alert('비밀번호를 입력해 주세요.');
	        $('#password').focus();
	       return false;
	    }
	    if ($('#mobile').val() == null ||$('#mobile').val() == ""  ) {
	        alert('휴대폰 번호를 입력해 주세요.');
	        $('#mobile').focus();
	       return false;
	    }
	    
	    $.ajax({
		     url:"idCheck.do",
		     type:"get",
		     data:$("#joinForm").serialize(),
		     success:function(data){
		         checkResult(data.code, data.message)
		     }, error   :   function(data){
		         alert(data.message + "시스템 에러가 발생하였습니다.");
		     }
		 });
	}
	
	function checkResult(code, message ) {
		if(code == "200") {
			join()
		} else if(code == "104") {
			alert(message);
		}
		
	}
	
	function join() {
		$.ajax({
		     url:"join.do",
		     type:"post",
		     data:$("#joinForm").serialize(),
		     success:function(data){
		         joinResult(data.code, data.message)
		     }, error   :   function(data){
		         alert(data.message + "시스템 에러가 발생하였습니다.");
		     }
		 });
	}
	
	function joinResult(code, message ) {
		if(code == "200") {
			alert(message);
			location.href="about.do";
		} else if(code == "500") {
			alert(message)
		}
		
	}