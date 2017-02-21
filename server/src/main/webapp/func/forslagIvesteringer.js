
var populateList= function( fromServer ){
    $.each(fromServer, function( index, line ) {
        $("#possibleInvestments").append('<li><a href="/case?id=1">'+ line   +'</a></li>');
    })
}


$.ajax({
    url: "/api/getSuggestions",
    data: {
        zipcode: 97201
    },
    success: function( fromServer ) {
        populateList(fromServer);
    },
    error: function( jqXHR, textStatus, errorThrown ){
        window.alert(errorThrown);
    }
});


