Date.prototype.getWeek = function() {
	var onejan = new Date(this.getFullYear(), 0, 1);
	return Math.ceil((((this - onejan) / 86400000) + onejan.getDay() + 1) / 7);
}
	
var weeknr = (new Date()).getWeek();
var d = (new Date()).getDay();
var day = (new Date()).getDate();
var month = (new Date()).getMonth();
var year = (new Date()).getFullYear();
$(document).ready(function(){
	$("#weeknr").html(weeknr);
});