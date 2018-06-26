
$(document).ready(function() {

    gosearchPage();
    changeBackgroundColor();

});

function gosearchPage() {
    $("#goSearchButton").click(function(){
        location.replace("index.jsp");
    });
}

function changeBackgroundColor() {
    $("#buttonClick").click(function(){
         $(this).html("Was clicked!");
         $("#body").css("background-color", "grey");

    });
    }





