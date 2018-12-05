$(document).ready(function()  
{  
	$.validator.addMethod("number", function(value, element) {   
		return this.optional(element) || /^[0-9]+$/i.test(value);   
		}, "Please choise a username with only 0-9.");
	
          $("#form_prenot").validate(  
    {  
        rules:  
        {  
        'iduser':{  
            required: true,  
            number: true
            },  
        'idasset':{  
            required: true,  
            number: true  
            }  
        },  
        messages:  
        {  
        'iduser':{  
            required: "Il campo iduser e' obbligatorio!",  
            number: "Scegli un iduser numerico esistente!"  
            },  
        'idasset':{  
            required: "Il campo idasset e' obbligatorio!",  
            number: "Inserisci un idasset numerico esisitente!"  
        }  
        }  
    });   
});        
$.validator.addMethod("number", function(value, element) {   
return this.optional(element) || /^[0-9]+$/i.test(value);   
}, "Please choise a username with only 0-9.");
            
            
            
            
            
            