var particles = document.getElementById("particles");
var border = ["50%","20%"];
var colors = ["#00b1b7","#ff2c7c","#00df4a"];


function getParticles(){
    var np = document.documentElement.clientWidth / 30;
    particles.innerHTML = "";
    for (var i = 0; i < np; i++) {
        var w = document.documentElement.clientWidth;
        var h = document.documentElement.clientHeight;
        var rndw = Math.floor(Math.random() * w ) + 1;
        var rndh = Math.floor(Math.random() * h ) + 1;
        var anima = Math.floor(Math.random() * 20) + 8;
        var bdr = Math.floor(Math.random() * 2);
        var color = Math.floor(Math.random() * 3);

        var div = document.createElement("div");
        div.style.position = "absolute";
        div.style.marginLeft = rndw+"px";
        div.style.marginTop = rndh+"px";
        div.style.width = "10px";
        div.style.height = "10px";
        div.style.backgroundColor = colors[color];
        div.style.borderRadius = border[bdr];
        div.style.animation = "move "+anima+"s ease-in infinite";
        particles.appendChild(div);
    }
}

function main(event){
    getParticles();
}

window.addEventListener("resize", main);
window.addEventListener("load", main);

$(function(){
	var name=getCookie()
	console.log(name);
	document.getElementById('uname').innerHTML=name;
});
/* 获取cookie的值 */
function getCookie(){
	var arr=document.cookie.split(";");
	for(var i=0;i<arr.length;i++){
		var arr1=arr[i].split("=");
		if (arr1[0]=="name") {
			return arr1[1];
			break;
		}else{
			return null;
			break;
		}
	}
}
