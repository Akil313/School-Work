function verify(){

    var pass1 = document.getElementById("fPass").value;
    var pass2 = document.getElementById("cPass").value;
    var age = document.getElementById("regAge").value;

    if(!passMatch(pass1, pass2)){
        alert("Your passwords do not match.");
        return;
    }

    if(age < 18 || age > 150){
        alert("Your age is invalid.");
        return;
    }

    confirm("Is your information okay?");
}

window.onload = function start(){
    alert("This is the signup page for the newsettler for our special football magazine.");

    var name = prompt("What is your first and last name?");

    var regName = name.split(" ");

    document.getElementById("fName").value = regName[0];
    document.getElementById("lName").value = regName[1];

    document.getElementById("submit").addEventListener("click", verify);
}

function passMatch(pass1, pass2){
    return (pass1===pass2);
}