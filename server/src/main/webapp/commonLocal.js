var simpleLogin= function(){
    var dataToSend={
        username: $("#username").val(),
    }

    $.ajax({
        method: "POST",
        url: "/api/login",
        data: JSON.stringify(dataToSend),
        success: function( fromServer ) {
            console.log(fromServer);

        },
        error: function( jqXHR, textStatus, errorThrown ){
            console.log(jqXHR);
        }
    });
}

var enableMenu= function(){
    $("#loginButton").click(simpleLogin);

}

$("#menu").load("/menu.html",enableMenu);
