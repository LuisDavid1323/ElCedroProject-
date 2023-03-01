function cerrar() {
	console.log();
	swal({
		  title: "¿Esta seguro de cerrar esta sesión?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url: "@{/logout}",
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Sesión cerrada!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/login";
		    	}
		    });
		  } 
		});
}