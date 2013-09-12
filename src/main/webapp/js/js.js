$(document).ready(function() {
	
	var counter = 0;
	var resultTest = "";

	$("#testButton").click(function() {
		if (counter > 0){
			resultTest += "<br>";
			resultTest += ""+counter+")   The answer to the question <b>"+$("h3").text()+"</b> was: ";
		}
		$(this).val('next');
		addResult();
		testStep();
		counter++;
		if (counter == 6) {
			$("#result").html("");
			$("#showResult").removeAttr('disabled');
			$("#testButton").remove();	
		}
	});

	function testStep() {
		count = {count : counter};
		$.ajax({
			type: 'POST',
			url : 'buildQuestion.html',
			data : count,
			success : function(data) {
				$('#result').html(data);
			},
			error : function() {
				$("#result").html("Can't connect to server");
			}
		});
	}
	
	function addResult() {
		$(".chkbox").each(function() {
			if ($(this).is(':checked')) {
				var idValue = {id : $(this).val()};
				$.ajax({
					type: 'POST',
					url : 'addResult.html',
					data : idValue,
					success : function(data) {
						resultTest += data;
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
});