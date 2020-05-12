/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//next and perious question
//display First Question
var slideIndex = 1;
showDivs(slideIndex);

//display next or preious question


function plusDivs(n) {
    showDivs(slideIndex += n);
}

function showDivs(n) {
    var i;
    var x = document.getElementsByClassName("question"); //get all div question
    var btnNext = document.getElementById("btnnext");
    if(x.length==1){ //hident button next wwhen number of question = 1
        btnNext.classList.add("hidentQuestion");
    }
    if (n > x.length) { // display firrst question when click next in last question
        slideIndex = 1;
    }
    for (i = 0; i < x.length; i++) {
        x[i].classList.add("hidentQuestion");
        x[i].classList.remove("displayQuestion");//xoas ddi ddeer k add nhieeuf class displayQusetion

    }

    x[slideIndex - 1].classList.remove("hidentQuestion");
    x[slideIndex - 1].classList.add("displayQuestion");
    
    //Show submit button when in the last question
    var submit = document.getElementById("btnsubmit");// get button submit
    if (slideIndex === x.length) {
        submit.classList.add("displayQues");
        submit.classList.remove("hiddenQues");
    } else {
        submit.classList.add("hiddenQues");
        submit.classList.remove("displayQues");
    }
}



//time

function startTimer(duration, display) {
    var timer = duration;
    var minutes;
    var seconds;
    let timerId = setInterval(function () {
        minutes = parseInt(timer / 60);
        seconds = parseInt(timer % 60);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            document.getElementById("myForm").submit();
            clearInterval(timerId);
        }
     
    }, 1000);
}

window.onload = function () {//when web load all data
//    Context context;
//    var timeAQuestion = context.lookup("timeAQuestion").toString();
    var numberQuestion = document.getElementById("numberQuestion").value; //get number of question 
    var seconds = numberQuestion * 10;
    var displayTime = document.getElementById('time');
    startTimer(seconds , displayTime);
};





