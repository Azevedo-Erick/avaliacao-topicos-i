
const cad = document.getElementById("cadastrar");

cad.addEventListener("mouseover",()=>{
	let element = document.querySelectorAll("#cadastro-container > .fake")
	document.getElementById("angle-cad").className = "fa fa-angle-down";
	element.forEach((e)=>{
		
	e.style.display = "flex";
	})
})

const nav = document.getElementById("cadastro-container");

nav.addEventListener("mouseleave",()=>{
	let element = document.querySelectorAll("#cadastro-container > .fake")
	document.getElementById("angle-cad").className = "fa fa-angle-up";
	element.forEach((e)=>{
		
	e.style.display = "none";
	})
})


const log = document.getElementById("login-nav-container");


log.addEventListener("mouseover",()=>{
	let element = document.querySelectorAll("#login-nav-container > .fake")
	document.getElementById("angle-log").className = "fa fa-angle-down";
	element.forEach((e)=>{
		
	e.style.display = "flex";
	})
})

const logWrap = document.getElementById("login-wrapper");

logWrap.addEventListener("mouseleave",()=>{
	let element = document.querySelectorAll("#login-nav-container > .fake")
	document.getElementById("angle-log").className = "fa fa-angle-up";
	element.forEach((e)=>{
	e.style.display = "none";
	})
})