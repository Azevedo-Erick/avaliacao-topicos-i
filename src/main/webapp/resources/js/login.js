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