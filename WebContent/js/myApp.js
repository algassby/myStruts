$( document ).ready(function() {
	var $sexe =$(".tbbody tr");
   
	$(".btn").on("click", function(){
	
	$.each($sexe, function(e){
		//console.log($(this))
		var td = $(this).find("#nom")[0]
		var id =$(td).data("id")
		switch(($(this).find($('#sexe-'+id))).html())
		{
			case 'Homme':
				$("td.nom-"+id).css("background-color","green");
				break;
			case 'Femme':
				$("td.nom-"+id).css("background-color","pink");
				break;
			default:
				$("td.nom-"+id).css("background-color","white");
				break;
		}
		/*
		if($(this).html()=='Homme'){
			console.log($(this).html())
			alert('bonjour')
			$("td.nom").css("background-color","green");
			alert('bonjour')
		}
		if($(this).html()=='Femme'){
			console.log($(this).html())
			//$("td.nom").css("background-color","pink");
		}
		else{
			//$("td.nom").css("background-color","white");
		} */
		
		/* if($(this).html()=='Femme'){
			$(this).css("color","pink");
		}*/
		/*else{
			$(this).css("color","black");
		}*/
	});
	});
	
	//AJax delete
	
	$(".delete").on('click',function(){
		
		
	$.ajax({
		type : "POST",
		url : "myStruts/delete.action",
		data: id,
		
		success : function bougier(data){
			var id = $("#id").html();
			console.log(data+""+id);
		},
		error : alert('error')
	});
});
	
	
});

/*function getAjax(id){
	$.ajax({
		type : "POST",
		data: id,
		url : "myStruts/delete.action",
		success : bougier,
		error : alert('error')
	});
}

function bougier(){
 var id = $("#id").html();
	console.log(id);
	}*/