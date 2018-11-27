package com.example.leejh.sswutamp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee jh on 2017-11-25.
 */

public class EtangStampRequest extends StringRequest {
    final static private String URL = "http://zzcandy.cafe24.com/EtangPhoneserver.php";
    private Map<String, String> parameters;

    public EtangStampRequest(String phonenumber3, String stamps3, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("phonenumber",phonenumber3);
        parameters.put("stamps",stamps3);
    }
    public  Map<String,String> getParams(){
        return parameters;
    }

}
