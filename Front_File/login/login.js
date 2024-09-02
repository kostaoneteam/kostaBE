

function loginForm(){
    if(document.textForm.userid.value == ''){
        alert("아이디를 입력해주세요.");
        document.textForm.userid.focus();
        return false;
    }
    
    let passwd1 =document.textForm.password.value;

    if(passwd1 == ''){
        alert("비밀번호를 입력해주세요.");
        document.textForm.password.focus();
        return false;
    }
    document.textForm.action = '/.jsp';
    document.textForm.submit();
}