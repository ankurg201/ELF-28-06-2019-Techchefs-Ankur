/* let name = document.getElementById('name');
console.log(name);

console.log(name.textContent);
name.style.color="brown";

var classCollection = document.getElementsByClassName("demo");
console.log(classCollection);
classCollection[0].style.fontSize = '30px';
// classCollection[1].style.display

// document.getElementById("button1").className = "button";
document.getElementById("myButton").classList=["button button1"]

var querySelect = document.querySelectorAll(".demo");
console.log(querySelect);

let input = document.createElement("input");
document.body.appendChild(input);

var demoClass = document.getElementById("pele").className = "blue";

console.log("number of element with query selectorAll =" +demoClass.length);
console.log("number of element with getelementbyclassname = "+demoClass.length); */

let button = document.getElementById('myButton');
/* button.onclick = function createNewElement(){
    document.getElementById('div1').innerHTML = '<a href="https://www.google.com">Anchor tag</a>';
} */

window.onload = function(){
    document.getElementById('myButton').textContent = 'Dont Click';
};

button.addEventListener('click',()=>{
    document.getElementById('div1').innerHTML = '<a href="https://www.google.com">Anchor tag</a>';
});

