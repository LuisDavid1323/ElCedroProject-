   
function eliminarDiseno(id_diseno) {
	console.log(id_diseno);
	swal({
		  title: "¿Esta seguro de Eliminar?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/disenos/"+id_diseno,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Diseño eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/disenos";
		    	}
		    });
		  } 
		});
}

function guardarDiseno(){
	
	alert("Se han guardado los cambios")
	
}

function crearDiseno(){
	
	alert("Se ha creado un nuevo diseño")	
	
}

   







