   
function eliminar(id_usuario) {
	console.log(id_usuario);
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
				 url:"/users/"+id_usuario,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Registro eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/users";
		    	}
		    });
		  } 
		});
}

function guardarusuario(){
	
	alert("Se han guardado los cambios")
	
}

function crearusuario(){
	
	alert("Se ha creado un nuevo usuario")
	
}

   







