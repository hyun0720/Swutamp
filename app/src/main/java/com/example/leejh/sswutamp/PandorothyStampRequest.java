package com.example.leejh.sswutamp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee jh on 2017-11-25.
 */

public class PandorothyStampRequest extends StringRequest {
    final static private String URL = "http://zzcandy.cafe24.com/PandorothyPhoneserver.php";
    private Map<String, String> parameters;

    public PandorothyStampRequest(String phonenumber4, String stamps4, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("phonenumber",phonenumber4);
        parameters.put("stamps",stamps4);
    }
    public  Map<String,String> getParams(){
        return parameters;
    }

}
