
$(document).ready(function(){
	document.getElementById("event-form").addEventListener("submit", function(event) {

		event.preventDefault();
		window.alert("New event");

		$("#event_container").append(toEventItem({"name":"event 1","eventDate":" 15:30 | 2018-12-12 "})) ;
		
	});
	
	$.getJSON( "http://localhost:8080/PersonalAssistantWEB--Build/events/get7DayInterval", function( jsonArray ) {
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				$("#event_container").append(toEventItem(jsonObject)) ;
			}
		);
	});
});

function toEventItem(jsonObject)
{
	var name=jsonObject.name;
	var color="w3-green";
	var dateArr=jsonObject.eventDate.split("|")
	var content1=dateArr[0],content2=dateArr[1];
	return "<li >"+"<div>"+name+"<div class='w3-tag "+color+"' style='float:right'>"+content2+"</div>"+
	"<div class='w3-tag "+color+"' style='float:right;margin-right:10px'>"+content1+"</div>"
	+"</div>"+"</li>";
	
}
