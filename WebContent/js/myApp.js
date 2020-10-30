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
	//
	/*	var id = $(this).parent("td").parent("tr").find("td#id").data("id");
		console.log(id);
		$("tbody tr").each(function(){
			
			$(this).find("td.id-"+id).parent().remove();
			$.ajax({
		type : "POST",
		url : "myStruts/delete.action",
		data: {
			id:id
		},
		
		success : function (response){
			var id = $("#id").html();
			console.log(response+""+id);
		},
		error : function(){
			alert("Error");
		}
	});
			
		}); */
	//
	
	$("button.delete").on('click',function(){
	swal({
	  title: "voulez-vous vraiment supprimer cette personne?",
	  text: "Une fois supprimé, vous ne pourrez plus récupérer cette personne !",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
})
.then((willDelete) => {
  if (willDelete) {
	var id = $(this).parent("td").parent("tr").find("td#id").data("id");
		console.log(id);
		$("tbody tr").each(function(){
			
			$(this).find("td.id-"+id).parent().remove();
			$.ajax({
		type : "POST",
		url : "myStruts/delete.action",
		data: {
			id:id
		},
		success : function (response){
			var id = $("#id").html();
			console.log(response+""+id);
			swal("la personne a été supprimé", {
      icon: "success",
    });
		},
		error : function(){
			alert("Error");
		}
	});
			
		});
    
  } else {
    swal("vous avez annulez!");
  }
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