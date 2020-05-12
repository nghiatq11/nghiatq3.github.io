///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
//
//function checkSelect() {
//    var checkboxes = document.getElementsByClassName("ans"); //get all checkbox 
//    var btnMakeQ = document.getElementById("btnMakeQuiz");
//    var count = 0;
//    for (var i = 0, n = checkboxes.length; i < n; i++) {//check checkbox selectd
//        if (checkboxes[i].checked == true) {
//            count++;
//        }
//    }
//
//
//    var area = document.getElementsByClassName("ques");
//    var count2 = 0;
//    for (var i = 0, n = area.length; i < n; i++) {//check textarea null
//        if (area[i].value == '') {
//            count2++;
//            if (area[0].value == '') {
//                alert('Question not null');
//                return;
//            }
//            if (area[1].value == '') {
//                alert('Option 1 not null');
//                return;
//            }
//            if (area[2].value == '') {
//                alert('Option 2 not null');
//                return;
//            }
//            if (area[3].value == '') {
//                alert('Option 3 not null');
//                return;
//            }
//            if (area[4].value == '') {
//                alert('Option 4 not null');
//                return;
//            }
//        }
//    }
//    if (count2 > 0) {
//        btnMakeQ.type = "button";
//    } else if (count == 4) {
//        alert("k chọn 4 đáp án");
//        btnMakeQ.type = "button";
//    } else if (count == 0) {
//        alert("k để trống đáp án");
//        btnMakeQ.type = "button";
//    } else {
//        btnMakeQ.type = "submit";
//    }
//
//
//}