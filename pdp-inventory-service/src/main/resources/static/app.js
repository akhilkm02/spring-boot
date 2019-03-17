var stompClient = null;
var myName="Anonymous";

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#userinfo").html("");
}

function connect() {
	var name=$("#name").val();
	if(""==name ){
	   alert("plese enter your name.....");	
	}else if (!(name.indexOf('Dony') !=-1 || name.indexOf('Pooja')!=-1 || name.indexOf('Venki')!=-1||name.indexOf('Akhil')!=-1)){
		 alert("Only Pooja Dony Venki Akhil can chat...");	
	}else{
		myName=name;
		$('#startChat').show();        
        var socket = new SockJS('/inventoryService');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/inventory/user', function (greeting) {
                showGreeting(JSON.parse(greeting.body).content);
            });
        });
	}


}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/inv/user", {}, JSON.stringify({'name': $("#message").val()+"              ~"+myName}));
    $("#message").val("");
}

function showGreeting(message) {
    $("#userinfo").append("<tr><td>" + message + "</td></tr>");
}


function connectInv() {
	var socket = new SockJS('/inventoryService');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/inventory/'+$('#itemId').val().toString(), function(greeting) {
			showGreeting(JSON.parse(greeting.body).content);
		});
	});
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    //starts
    $( "#connectInv" ).click(function() { connectInv(); });
});