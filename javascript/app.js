/* var s =10;
console.log(s);

// var b=a;
console.log(b);
b=20;
// console.log(a); */

console.log("=========================");

var person = {
    firstName: "ankur",
    lastName: "gupta",
    age:25,
    getFullName : function(){
        return this.firstName + " " + this.lastName;
    },

    address: {
        city : "Bangalore",
        state : "KA",
        pincode : "560078"
    },
    hobbies : ['sleeping', 'oversleeping', 'watching tv']
};
console.log("name= "+person.name);
console.log("city = "+ person.address.city)
console.log("full name = "+ person.getFullName())
console.log("hobbies = "+ person.hobbies)

var person1 = person;

console.log("p1 name "+person1.name);
person1.name = "sourabh";
console.log("p name=" +person.name);
console.log("p1.name="+person1.name);   

var library = [
    {
        id : 1,
        author : 'bill gates',
        name : 'bill'
    },
    {
        id : 2,
        author : 'steve jobs',
        name : 'steve'
    }
]
console.log(library[0].id);
console.log(library[1].name);

var hobbies = ['cricket', 'volleybal'];
hobbies['test'] = 'some text';
document.getElementById('demo').innerHTML = hobbies;

hobbies.forEach((val,index)=>{
    console.log("value ="+val);
    console.log("index="+index);
})

console.log("=========================");

console.time("forof");
for(var val of hobbies){
    console.log('hobbies ='+val);
}
console.timeEnd("forof");

console.log("=========================");

for(var index in hobbies){
    console.log('hobbies ='+hobbies[index]);
}

console.log("=========================");

console.time("forin");
for(var index in person){
    console.log('person ='+person[index]);
}
console.timeEnd("forin");

/* function alertMessage(val, number){
    alert(`this is named function value = ${val} number= ${number}`);
}

alertMessage(10, 30);

// ‘Immediately Invoked Function Expression
(function(){
    alert("this is IIFE");
}());

// ‘Immediately Invoked Function Expression
(function(){
    alert("this is IIFE1111");
})(); */

console.log("=========================");

function varKey(){
    a=20;
    console.log("inside function aaa = " +a);
}
// console.log("outside function aaa = "+a);

varKey();

function letKey(){
    let b=20;
    console.log("bbb = "+b);
}
console.log()

console.log("=========================");

var x = hobbies.includes("cricket");
console.log("includes "+x);

hobbies.push("kabbadi");
console.log("push ="+hobbies);

hobbies.pop();
console.log("pop ="+hobbies);

hobbies.shift();
console.log("shift ="+hobbies);

hobbies.unshift("new value");
console.log("unshift ="+hobbies);

var hobbies = ['cricket', 'volleybal','kabbadi'];
hobbies.splice(0,2,'ggg','hhhh');
console.log("splice ="+hobbies);

console.log(hobbies);
var hobbieName = hobbies.slice(0,2);
console.log("slice ="+hobbies);
console.log(hobbieName);

console.log(hobbies.join('--'));

console.log("=========================");

function first(){
    setTimeout(()=>{
        console.log("this is first");
    },0)
}

function second(){
    console.log("this is second");
}

first();
second();

console.log("=========================");

const items = [
    {
        name : 'ankur'
    },
    {
        name : 'aman'
    },
    {
        name : 'jyoti'
    }
]

console.log(items);

let mappedName = items.map((value)=>{
    return value.name;
}
);

console.log(mappedName);



let filteredValue = items.filter((value)=>{
    return value.name.length>4;
}
);

console.log(filteredValue);

console.log("=========================");
