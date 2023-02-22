/**
 * 
 */


 function submitt() {
	 alert("버튼 누름");
	
	 
	 if(document.fform.pwd.value != document.fform.pwd_again.value){
		 document.fform.pwd.focus();
		 document.fform.pwd_again.select();
		 document.fform.pwd_again.value = "";
		 alert("패스워드 다름");
		 
	 }else if(document.fform.pwd.value == document.fform.pwd_again.value){
		 alert("에러 없음");
		 return true;
	}
 }