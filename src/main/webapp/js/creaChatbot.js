function myFunction(){
	
	var node = document.createElement("div");
    var textnode = document.createTextNode("prova");
    node.appendChild(textnode);
    document.getElementById("prova").appendChild(node);
	
}