/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function CfDelete(){
    var btnDelete = document.getElementById("deleteQuiz");
    var cf = confirm("Do you want to delete");
    if(cf == true){
        btnDelete.type = 'submit';
    }
}
