var check=document.querySelector(".form-check-input");
check.addEventListener('click',idioma);

function idioma(){
	let id=check.checked;
	if(id==true){
		location.href="indexEN";
	}else{
		location.href="index"
	}
	
}
