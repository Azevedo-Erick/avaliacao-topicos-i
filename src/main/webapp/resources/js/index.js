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

const trs = document.getElementsByTagName("tr");

function trsAddEvent(){
	for(let i = 0; i<trs.length;i++){
		trs[i].addEventListener("mouseover", ()=>{
			trs[i].style.opacity = "0.7";
		})
		trs[i].addEventListener("mouseleave", ()=>{
			trs[i].style.opacity = "1";
		})
	}
}

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

const inputs = {
	envelope:document.getElementById("envelope"),
	lock:document.getElementById("lock"),
}

inputs.envelope.addEventListener("mouseover", ()=>{
	inputs.envelope.firstElementChild.className = "fa fa-envelope-open icon";
});

inputs.envelope.addEventListener("mouseleave", ()=>{
	inputs.envelope.firstElementChild.className = "fa fa-envelope icon";
});

inputs.lock.addEventListener("mouseover", ()=>{
	inputs.lock.firstElementChild.className = "fa fa-unlock icon";
});

inputs.lock.addEventListener("mouseleave", ()=>{
	inputs.lock.firstElementChild.className = "fa fa-lock icon";
});
function onPageLoad(){
	randomGenderColor();
	trsAddEvent();
}
document.onload = onPageLoad();