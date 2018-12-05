package main.controller;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private Map<String, Object> parameters;

    public Request(){
        this.parameters = new HashMap<String, Object>();
    }

    public void put(String key, Object value){
        this.parameters.put(key, value);
    }

    public Object get(String key){
        return this.parameters.get(key);
    }

    public Object getString(String key){
        Object returnObject = get(key);
        if(returnObject != null)
            return returnObject.toString();
        return null;
    }
}
