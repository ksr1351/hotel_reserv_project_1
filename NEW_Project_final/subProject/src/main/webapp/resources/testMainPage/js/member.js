/* ------------------------------------ Click on login and Sign Up to  changue and view the effect
---------------------------------------
*/

function cambiar_login() {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
document.querySelector('.cont_form_login').style.display = "block";
document.querySelector('.cont_form_sign_up').style.opacity = "0";               

setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);  
  
setTimeout(function(){    
document.querySelector('.cont_form_sign_up').style.display = "none";
},200);  
  }

function cambiar_sign_up(at) {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
  document.querySelector('.cont_form_sign_up').style.display = "block";
document.querySelector('.cont_form_login').style.opacity = "0";
  
setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
},100);  

setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
},400);  


}    



function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  
  
  }


  function id_check() {
    alert('준비중입니다.')
  }

  function sign_up() {

    if (!$('#id').val()) {
      alert('아이디를 입력하세요.')
      return;
    }
    
    if (!chkPW($('#password').val())) {
      return;
    }

    
    if (!$('#name').val()) {
      alert('이름을 입력하세요.')
      return;
    }

    
    if (!$('#tel').val()) {
      alert('전화번호를 입력하세요.')
      return;
    }

    
    if (!$('#email').val()) {
      alert('이메일을 입력하세요.')
      return;
    }

    alert('완료')
    location.href = './signup_finish.html'
  }


  function biz_sign_up() {

    if (!$('#bizId').val()) {
      alert('아이디를 입력하세요.')
      return;
    }
    
    
    if (!chkPW($('#bizPassword').val())) {
      return;
    }

    
    if (!$('#bizName').val()) {
      alert('기업명을 입력하세요.')
      return;
    }

    
    if (!$('#bizNumber').val()) {
      alert('사업자 번호를 입력하세요.')
      return;
    }

    
    if (!$('#bizEmail').val()) {
      alert('이메일을 입력하세요.')
      return;
    }

    alert('완료')

  }

  function chkPW(pw){
    var num = pw.search(/[0-9]/g);
    var eng = pw.search(/[a-z]/ig);
    var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
   
    if(pw.length < 8 || pw.length > 20){
   
     alert("비밀번호는 8자리 ~ 20자리 이내로 입력해주세요.");
     return false;
    }else if(pw.search(/\s/) != -1){
     alert("비밀번호는 공백 없이 입력해주세요.");
     return false;
    }else if(num < 0 || eng < 0 || spe < 0 ){
     alert("비밀번호는 영문,숫자, 특수문자를 혼합하여 입력해주세요.");
     return false;
    }else {
     console.log("통과"); 
       return true;
    }
   
   }