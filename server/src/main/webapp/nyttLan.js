
var submitLoanRequest= function(){

    $.ajax({
        method: "POST",
        url: "/api/postLoanRequest",
        data: {
            email: $("#email").val(),
            requestLoanName: $("#requestLoanName").val(),
            amount: $("#amount").val()
        },
        success: function( fromServer ) {
            console.log(fromServer);

        },
        error: function( jqXHR, textStatus, errorThrown ){
            console.log(jqXHR);

        }
    });
}



$("#submit").click(submitLoanRequest);