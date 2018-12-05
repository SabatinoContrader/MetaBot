$(document).ready(function()  
{  
    $("#form_register").validate(  
    {  
        rules:  
        { 
        'prezzo':{  
            prezzo: "inserire un prezzo valido" 
            }  
        },
        messages:
        {
        'prezzo':{
        		required: "Il campo prezzo e' obbligatorio!",  
        		prezzo: "Inserisci un prezzo valido!" 
        		}
        }
    });   
});  

$.validator.addMethod("prezzo", function(value, element) {  
	value = value.replace(/,/, ".");
	
    return this.optional(element) || /^[0-9]+(\.[0-9]{1,2})?$/.test(value);   
    }, "Inserisci un prezzo formattato in questo modo: 0-9.0-9");