Date.prototype.getWeek = function() {
	var onejan = new Date(this.getFullYear(), 0, 1);
	return Math.ceil((((this - onejan) / 86400000) + onejan.getDay() + 1) / 7);
}
	
var weeknr = (new Date()).getWeek();
var d = (new Date()).getDay();
var day = (new Date()).getDate();
var month = (new Date()).getMonth();
var year = (new Date()).getFullYear();
var ma;
var di;
var wo;
var don;
var vr;

switch(d){
case 0:
	ma = day+1;
	di = day+2;
	wo = day+3;
	don = day+4;
	vr = day+5;
	break;
case 1:
	ma = day;
	di = day+1;
	wo = day+2;
	don = day+3;
	vr = day+4;
	break;
case 2:
	ma = day-1;
	di = day;
	wo = day+1;
	don = day+2;
	vr = day+3;
	break;
case 3:
	ma = day-2;
	di = day-1;
	wo = day;
	don = day+1;
	vr = day+2;
	break;
case 4:
	ma = day-3;
	di = day-2;
	wo = day-1;
	don = day;
	vr = day+1;
	break;
case 5:
	ma = day-4;
	di = day-3;
	wo = day-2;
	don = day-1;
	vr = day;
	break;	
case 6:
	ma = day-5;
	di = day-4;
	wo = day-3;
	don = day-2;
	vr = day-1;
	break;
}
$(document).ready(function(){
	$("#weeknr").html(weeknr);
	$('#ma').html(ma+"-"+month+"-"+year);
	$("#di").html(di+"-"+month+"-"+year);
	$("#wo").html(wo+"-"+month+"-"+year);
	$("#do").html(don+"-"+month+"-"+year);
	$("#vr").html(vr+"-"+month+"-"+year);
});