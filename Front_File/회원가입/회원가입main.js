
// 입력칸 텍스트 삭제
// function clearTextareaid() {
//     document.getElementById('membership_id').value = '';
//   }
// function clearTextareapw(){
//     document.getElementById('membership_pw').value ='';
// }
// function clearTextareapw2(){
//     document.getElementById('membership_pw2').value ='';
// }
// function clearTextareaname(){
//     document.getElementById('membership_name').value ='';
// }
// function clearTextareaemail(){
//     document.getElementById('membership_email').value ='';
// }

// 입력여부 확인
const join = () => {
    // 각 입력값 변수설정
    let userIdInput = document.querySelector('#membership_id');
    let passwordInput = document.querySelector('#membership_pw');
    let password2CheckInput = document.querySelector('#membership_pw2')
    let userNameInput = document.querySelector('#membership_name');
    let userEmailInput = document.querySelector('#membership_email');

    
    let check = true;

    // console.log(userIdInput.value)
    // console.log(passwordInput.value)
    // console.log(userNameInput.value)
    // console.log(userEmailInput.value)
    let userIdErrorMsg = document.querySelector('#userid-error-msg');

    if(userIdInput.value === ''){
        userIdErrorMsg.style.display ='block';
        document.form_membership.membership_id.focus();
        check = false;
    } else {
        userIdErrorMsg.style.display = 'none';
    }

    let passwordErrorMsg = document.querySelector('#password-error-msg');

    if(passwordInput.value === ''){
        passwordErrorMsg.style.display = 'block';
        document.form_membership.membership_pw.focus();

        check=false;
    } else{ 
        passwordErrorMsg.style.display = 'none';
    }
    
    let password2ErrorMsg2 = document.querySelector('#password2-error-msg');

    if(password2CheckInput.value === ''){
        password2ErrorMsg2.style.display = 'block';
        document.form_membership.membership_pw2.focus();

        check=false;
    } else{ 
        password2ErrorMsg2.style.display = 'none';
    }


    let userNameErrorMsg = document.querySelector('#name-error-msg')

    if (userNameInput.value === '') {
        userNameErrorMsg.style.display = 'block';
        document.form_membership.membership_name.focus();

        check = false;
    } else {
        userNameErrorMsg.style.display = 'none';
    }

    let emailErrorMsg= document.querySelector('#email-error-msg')

    if (userEmailInput.value === ''){
        emailErrorMsg.style.display = 'block';
        document.form_membership.membership_email.focus();

        check = false;
    } else {
        emailErrorMsg.style.display = 'none';
    }

    let passwordCheckErrMsg = document.querySelector('#password2-error-msg');

    if (passwordInput.value !== password2CheckInput.value){
        alert('비밀번호와 비밀번호 확인이 다릅니다')
        // passwordCheckErrMsg.textContent = '비밀번호와 비밀번호확인이 다릅니다.';
        check = false;
    } else {
        passwordCheckErrMsg.style.display = 'none';
    }

    if(check){
        alert('회원가입이 완료 되었습니다.');
    }
}


// 아이디형식 지정해주기
// 비밀번호 형식 지정해주기
// 이메일 형식  지정해주기
