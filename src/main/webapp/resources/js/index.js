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

function onPageLoad(){
	randomGenderColor();
	trsAddEvent();
}
document.onload = onPageLoad();


