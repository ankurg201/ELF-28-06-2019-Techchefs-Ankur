window.onload = function () {

};
function validateForm() {
    let myEmail = document.forms[0].email.value;
    console.log(myEmail);
    let myPass = document.forms[0].password.value;
    let myConfirm = document.forms[0].confirm.value;
    if (myEmail.length > 6 && myPass.length > 6 && myConfirm.length > 6 && myPass == myConfirm) {
        document.getElementById("button1").disabled = false;
    } else {
        document.getElementById("button1").disabled = true;
    }
}