const cad = document.getElementById("cadastrar");

cad.addEventListener("mouseover",()=>{
	let element = document.querySelectorAll(".fake")
	document.getElementById("angle").className = "fa fa-angle-down";
	element.forEach((e)=>{
		
	e.style.display = "flex";
	})
})

const nav = document.getElementById("cadastro-container");

nav.addEventListener("mouseleave",()=>{
	let element = document.querySelectorAll(".fake")
	document.getElementById("angle").className = "fa fa-angle-up";
	element.forEach((e)=>{
		
	e.style.display = "none";
	})
})