//English
let previousTitlee = document.title

window.addEventListener('blur',() =>{
  previousTitlee = document.title
  document.title = '¡ Come back 😱!'
})

window.addEventListener('focus',() =>{
	document.title = previousTitlee
})