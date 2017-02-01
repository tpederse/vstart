
var populateList= function( fromServer ){
    $("#possibleInvestments").append('<li><a href="/case?id=1">'+ fromServer[0].displayText   +'</a></li>');
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
