function viewPassword()
{
  var passwordInput = document.getElementById('password');
  var passStatus = document.getElementById('pass-status');
 
  if (passwordInput.type == 'password'){
    passwordInput.type='text';
    passStatus.className='fa fa-eye-slash';
    
  }
  else{
    passwordInput.type='password';
    passStatus.className='fa fa-eye';
  }
}

//document.getElementById("myForm").addEventListener("submit", validateForm());

function validateForm() {
  console.log("hello");
  var myEmail = document.getElementById("email");
  var myPass = document.getElementById("password");
  console.log(myEmail);

  if (myEmail.length < 6 || myPass.length < 6) {
    document.getElementById("error").innerHTML("email and password lenght must be greater than 6");
}
}

