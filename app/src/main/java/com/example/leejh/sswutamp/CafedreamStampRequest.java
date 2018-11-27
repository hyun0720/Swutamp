package com.example.leejh.sswutamp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee jh on 2017-11-25.
 */

public class CafedreamStampRequest extends StringRequest {
    final static private String URL = "http://zzcandy.cafe24.com/CafedreamPhoneserver.php";
    private Map<String, String> parameters;

    public CafedreamStampRequest(String phonenumber2, String stamps2, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("phonenumber",phonenumber2);
        parameters.put("stamps",stamps2);



    }
    public  Map<String,String> getParams(){
        return parameters;
    }

}
