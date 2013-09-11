$(document).ready(function() {
	var counter = 0;
	var result = "";

	$("#bt").click(function() {
		
		if (counter >0){
			result += "<br>";
			result += ""+counter+") Result on question <b>"+$("h3").text()+"</b>: ";
		}
		$(this).val('next');
		// console.log(result);
		addResult();
		test();
		counter++;
		console.log(counter);
		if (counter == 6) {
			
		$("#result").html("");
//		// $("#result").html(result);
		$("#res").removeAttr('disabled');
		$("#bt").remove();
			
		} 
		//else {
//			
//		}
		console.log(result);
	});

	$("#res").click(function() {
		console.log(result);
		$("#result").html(result);
	})

	function test() {
		count = {
			count : counter
		};
		$.ajax({
			url : 'ajaxtest.html',
			data : count,
			success : function(data) {
				$('#result').html(data);
			}
		});
	}
	function addResult() {
		var question = $("h3").text();
		$(".chkbox").each(function() {
			if ($(this).is(':checked')) {
				var dat = {
					id : $(this).val(),
					
				};
				$.ajax({
					url : 'ajaxtest1.html',
					data : dat,
					success : function(data) {
						result += data + " ";
					},
					error : function() {
						alert('try again');
					}
				});
			}
		});
	}
	;
});

/*
 * window.setInterval(function () {
 * 
 * iTimeRemaining = eval(iTimeRemaining); if (iTimeRemaining == 0) {
 * $("#bt").trigger('click');
 *  } else { $("#tleft").html(iTimeRemaining - 1); } }, 1000);
 * 
 * 
 * 
 * 
 * $("#some").click(function(){ console.log('click'); var d=
 * {many:$("#ss").val()}; //var d = "info"; $.ajax({ type: "GET", url :
 * "ajaxtest1.html", data: d, success : function(data) { console.log(data);
 * alert('yes');
 *  }, error:function(){
 * 
 * alert('try again'); } }); });
 */