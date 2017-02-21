
var submitLoanRequest= function(){
    var dataToSend={
        email: $("#email").val(),
        requestLoanName: $("#requestLoanName").val(),
        amount: $("#amount").val()
    }

    $.ajax({
        method: "POST",
        url: "/api/postLoanRequest",
        data: JSON.stringify(dataToSend),
        success: function( fromServer ) {
            console.log(fromServer);

        },
        error: function( jqXHR, textStatus, errorThrown ){
            console.log(jqXHR);
        }
    });
}



$("#submit").click(submitLoanRequest);