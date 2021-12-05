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


function randomGenderColor(){
	let genders = document.getElementsByClassName("genero");
	const colors = [
		'#ff65f9;',
		'#ffed65',
		'#65f7ff',
		'#6eff65',
		'#ff659d',
		'#ff6565',
	]
	for(let i =0;i<genders.length;i++){
		genders[i].style.color = colors[Math.floor(Math.random()*(colors.length-0)+0)]
	}
}
document.onload = randomGenderColor();