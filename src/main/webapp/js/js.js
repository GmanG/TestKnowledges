$(document).ready(function() {
	
	var counter = 0;
	var resultTest = "";

	$("#bt").click(function() {
		if (counter > 0){
			resultTest += "<br>";
			resultTest += ""+counter+") The answer to the question <b>"+$("h3").text()+"</b> was: ";
		}
		$(this).val('next');
		addResult();
		testStep();
		counter++;
		if (counter == 6) {
			$("#result").html("");
			$("#res").removeAttr('disabled');
			$("#bt").remove();	
		}
	});

	$("#res").click(function() {
		$("#result").html(resultTest);
		$(this).remove();
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
				alert('Try again');
			}
		});
	}
	
	function addResult() {
		$(".chkbox").each(function() {
			if ($(this).is(':checked')) {
				var dat = {id : $(this).val()};
				$.ajax({
					type: 'POST',
					url : 'addResult.html',
					data : dat,
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
});