$(document).ready(function() {
	
	var counter = 0;
	var resultTest = "";

	$("#testButton").click(function() {
		if (counter > 0){
			resultTest += "<br>";
			resultTest += ""+counter+")   The answer to the question <b>"+$("h3").text()+"</b> was: ";
		}
		$(this).val("next");
		addResult();
		getQustion();
		counter++;
		if (counter == 6) {
			$("#result").html("");
			$("#showResult").removeAttr('disabled');
			$("#testButton").remove();	
		}
	});
	
	function addResult() {
		$(".chkbox").each(function() {
			if ($(this).is(':checked')) {
				var idValue = {id : $(this).val()};
				$.ajax({
					type: 'POST',
					url : 'addResult.html',
					data : idValue,
					success : function(data) {
						if(data){
							var obj = $.parseJSON(data);
							$.each(obj , function (key, value) {
								resultTest +="<font color='"+key+"'> "+value+"</font> ";
							});
						}
					},
					error : function() {
						alert('Try again');
					}
				});
			}
		});
	}

	$("#showResult").click(function() {
		$("#result").html(resultTest);
		$(this).remove();
	});
	
	function getQustion(){
		count = {count : counter};
		var type = " ";
		$.ajax({
			type: 'POST',
			url : 'buildQuestion',
			data: count,
			success : function(data) {
				if(data){
					var obj = $.parseJSON(data);
					type  += "<h3>"+obj.question+"</h3>";
					$.each(obj.answers, function (key, value) {
						type +="<label> <input type='checkbox' class='chkbox' name='chk' value='"+value.id+"'>"+value.answer+"</input></label><br>";
						$("#result").html(type);
					});
				}
			},
			error : function() {
				alert('Cant connect to the server');
			}
		});
	}
});