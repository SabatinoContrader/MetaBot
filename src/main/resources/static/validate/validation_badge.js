$(document).ready(function()  
{  

	
    $("#badge_insert").validate(  
    {  
        rules:  
        {  
        'descrizione':{  
            required: true,  
            minlength: 3  
            }, 
        
        },  
        messages:  
        {  
        'descrizione':{  
            required: "Il campo descrizione è obbligatorio!",  
            minlength: "Fai una descrizione di almeno 3 lettere!"  
            },  
        
        },
    });   
});  


$(document).ready(function()  
		{  
		$("#badge_insert").validate({  
		    rules:{  
		        'name_campo1':{  
		            metodoA: parametro,  
		            metodoB: parametro  
		            },  
		        'name_altro_campo':{  
		            metodoC: parametro  
		            }  
		    },  
		          
		    messages:{  
		        'name_campo1':{  
		            metodoA: "messaggio di errore per questo metodo.",  
		            metodoB: "messaggio di errore per questo metodo."  
		            },  
		        'name_altro_campo':{  
		            metodoC: "messaggio di errore per questo metodo."  
		            }  
		          
		    }  
		});  
		}); 
	