$(document).ready(function()  
{  
	
	$.validator.addMethod("phoneNumber", function(value, element) {   
	    return this.optional(element) || /^([\+?][0-9]{2}[\s]?)?[0-9]{10}$/i.test(value);   
	    }, "Please choise a username with only a-z 0-9.");  
	$.validator.addMethod("partitaIva", function(value, element) {
		console.log(value);
		return this.optional(element) || /^[0-9]+$/i.test(value);
	}, "Partita iva non valida.");
	
    $("#form_register").validate(  
    {  
        rules:  
        {  
        'username':{  
            required: true,  
            minlength: 5  
            },  
        'mail':{  
            required: true,  
            email: true
            },  
        'password':{  
            required: true,  
            minlength: 8  
            },  
        'telefono':{  
            required: true,
            phoneNumber: true
            },  
        'partitaiva':{
        	partitaIva: true,
        	minlength: 11,
        	maxlength: 11
        	}
            
        },
        messages:  
        {  
        'username':{  
            required: "<br>Il campo username e' obbligatorio!",  
            minlength: "<br>Scegli un username di almeno 5 caratteri!"  
            },  
        'mail':{  
            required: "Il campo email e' obbligatorio!",  
            email: "Inserisci un valido indirizzo email!"  
            },  
        'password':{  
            required: "Il campo password e' obbligatorio!",  
            minlength: "Inserisci una password di almeno 8 caratteri!"  
            },  
        'telefono':{  
            phoneNumber: "inserire un numero di telefono valido" 
            },
            'partitaiva':{
            	partitaIva: "il campo puo' avere solo valori numerici",
            	minlength: "Inserire almeno 11 valori!", 
            	maxlength: "inserire al massimo 11 valori!" 
            }
        }  
    });   
});  

