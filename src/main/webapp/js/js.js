
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
//		testStep();
		getQustion();
		counter++;
		if (counter == 6) {
			$("#result").html("");
			$("#showResult").removeAttr('disabled');
			$("#testButton").remove();	
		}
	});
	
//	var getColor = function(isCorrect){
//		if (isCorrect)
//			return "green";
//		return "red";
//	}

//	function testStep() {
//		count = {count : counter};
//		$.ajax({
//			type: 'POST',
//			url : 'buildQuestion',
//			data : count,
//			success : function(data) {
//				$('#result').html(data);
//			},
//			error : function() {
//				$("#result").html("Can't connect to server");
//			}
//		});
//	}
	
	function addResult() {
//		var answers = " ";
//		$(".show").children(".chkbox").each(function() {
		$(".chkbox").each(function() {
			if ($(this).is(':checked')) {
//				answers +=" "+{id : $(".show").children(".chkbox").val()};
//				answers +=$(".chkbox").val();
				
				var idValue = {id : $(this).val()};
				console.log(idValue);
				
				$.ajax({
					type: 'POST',
					url : 'addResult.html',
					data : idValue,
					success : function(data) {
						if(data){
							var obj = $.parseJSON(data.trim());
							$.each(obj , function (key, value) {
								resultTest +="<font color='"+key+"'> "+value+"</font> ";
								console.log(obj);
							});
						}
					},
					error : function() {
						alert('Try again');
					}
				});
			
			}
			
		});
//		console.log(answers);
	}

	$("#showResult").click(function() {
		$("#result").html(resultTest);
		$(this).remove();
	});
//	$scope.questions = null;
	
	function getQustion(){
		count = {count : counter};
//		var c = 1;
		var type = " ";
		$.ajax({
			url : 'buildQuestion',
			data: count,
			success : function(data) {
				if(data){
					var obj = $.parseJSON(data);
					
//					$.each(obj, function(index, element) {
//						$("#tab-content-holder").append("<div id='tab-content"+c+"'>");
						type  +="<h3>"+obj.question+"</h3>";
							$.each(obj.answers, function (key, value) {
								type +="<label> <input type='checkbox' class='chkbox' name='chk' value='"+value.id+"'>"+value.answer+"</input></label><br>";
//								type +=" <input type='checkbox' class='chkbox' name='chk' value='"+value.id+"'>"+value.answer+"</input><br>";
								$("#result").html(type);
//								
							});
//							type+="</div>";
//							$("#tab-content-holder").append();
//							$("#tab-content-holder").append(type);
//					});
					
				}
				
			},
			error : function() {
				alert('Try again');
			}
		});
	}
	
//	$("#testButton").click(function() {
//		
//		counter++;
//		console.log(counter);
//		resultTest += ""+counter+")   The answer to the question <b>"+$(".show").children('h3').text()+"</b> was:<br>";
////		answers += "";
//		
//		if(counter == 7){
//			addResult();
//			$("#tab-content-holder").html("");
//			$("#showResult").removeAttr('disabled');
//			$("#testButton").remove();
//		}
//		MenuNavigationClick(1);
//		
//        
//    });
//	
//	function MenuNavigationClick(direction) {
//        // Get current element index and toggle
//        var current = $("#tab-content-holder .show");
//        var index = current.index();
//        current.toggleClass("show");
//
//        // Move to next element and check for overflow
//        index += 1 * direction;
//        index %= $("#tab-content-holder div").length;
//
//        // Toggle next element
//        $("#tab-content-holder div:eq("+index+")").toggleClass("show");
//    }
});