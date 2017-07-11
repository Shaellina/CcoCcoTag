/**
 * 
 */

var classmate = [
	{
		"no" : "1",
		"name" : "BG",
		"say" : "화이팅"
	},
	{
		"no" : "2",
		"name" : "JB",
		"say" : "배고파"
	},
	{
		"no" : "3",
		"name" : "HN",
		"say" : "하핳"
	},
	{
		"no" : "4",
		"name" : "JW",
		"say" : "돌아와야해"
	}
];

var items=[];
$.each(classmate, function(key, val) {
	items.push(
		'<li id="' + key + '">' + 
		val['no'] + ' : ' + 
		val['name'] + ' : ' + 
		val['say'] + '</li>');
});
$('#rcv_msg').append(items);