package com.example.leejh.sswutamp;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.tech.NfcF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private CardView cardView1;
    private CardView cardView1_2;//카드 뒷면

    private CardView cardView2;
    private CardView cardView2_2;//카드 뒷면

    private CardView cardView3;
    private CardView cardView3_2;//카드 뒷면

    private CardView cardView4;
    private CardView cardView4_2;//카드 뒷면

    private boolean isFirstImage1 = true;
    private boolean isFirstImage2 = true;
    private boolean isFirstImage3 = true;
    private boolean isFirstImage4 = true;

    private ImageButton imagebutton1;
    private ImageButton imagebutton2;
    private ImageButton imagebutton3;
    private ImageButton imagebutton4;
    private ImageButton imagebutton5;
    private ImageButton imagebutton6;
    private ImageButton imagebutton7;
    private ImageButton imagebutton8;
    private ImageButton imagebutton9;
    private ImageButton imagebutton10;

    private ImageButton c1;
    private ImageButton c2;
    private ImageButton c3;
    private ImageButton c4;
    private ImageButton c5;
    private ImageButton c6;
    private ImageButton c7;
    private ImageButton c8;
    private ImageButton c9;
    private ImageButton c10;

    private ImageButton p1;
    private ImageButton p2;
    private ImageButton p3;
    private ImageButton p4;
    private ImageButton p5;
    private ImageButton p6;
    private ImageButton p7;
    private ImageButton p8;
    private ImageButton p9;
    private ImageButton p10;

    private ImageButton e1;
    private ImageButton e2;
    private ImageButton e3;
    private ImageButton e4;
    private ImageButton e5;
    private ImageButton e6;
    private ImageButton e7;
    private ImageButton e8;
    private ImageButton e9;
    private ImageButton e10;

    private int numgaeun;
    private int numcafedream;
    private int numetang;
    private int numpandorothy;

    private TextView countcoupon1;
    private TextView countcoupon2;
    private TextView countcoupon3;
    private TextView countcoupon4;

    //NFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFC
    TextView mTextView;
    NfcAdapter mNfcAdapter; // NFC 어댑터
    PendingIntent mPendingIntent; // 수신받은 데이터가 저장된 인텐트
    IntentFilter[] mIntentFilters; // 인텐트 필터
    String[][] mNFCTechLists;

    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.textMessage);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLo);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh main activity upon close of dialog box
                Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                startActivity(refresh);
                MainActivity.this.finish(); //
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                swipeContainer.setRefreshing(false);
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        countcoupon1 = (TextView)findViewById(R.id.countcoupon1);
        countcoupon2 = (TextView)findViewById(R.id.countcoupon2);
        countcoupon3 = (TextView)findViewById(R.id.countcoupon3);
        countcoupon4 = (TextView)findViewById(R.id.countcoupon4);

        imagebutton1 = (ImageButton)findViewById(R.id.btnr1);
        imagebutton2 = (ImageButton)findViewById(R.id.btnr2);
        imagebutton3 = (ImageButton)findViewById(R.id.btnr3);
        imagebutton4 = (ImageButton)findViewById(R.id.btnr4);
        imagebutton5 = (ImageButton)findViewById(R.id.btnr5);
        imagebutton6 = (ImageButton)findViewById(R.id.btnr6);
        imagebutton7 = (ImageButton)findViewById(R.id.btnr7);
        imagebutton8 = (ImageButton)findViewById(R.id.btnr8);
        imagebutton9 = (ImageButton)findViewById(R.id.btnr9);
        imagebutton10 = (ImageButton)findViewById(R.id.btnr10);
        imagebutton1.setEnabled(false);
        imagebutton2.setEnabled(false);
        imagebutton3.setEnabled(false);
        imagebutton4.setEnabled(false);
        imagebutton5.setEnabled(false);
        imagebutton6.setEnabled(false);
        imagebutton7.setEnabled(false);
        imagebutton8.setEnabled(false);
        imagebutton9.setEnabled(false);
        imagebutton10.setEnabled(false);

        c1 = (ImageButton)findViewById(R.id.btnr11);
        c2 = (ImageButton)findViewById(R.id.btnr12);
        c3 = (ImageButton)findViewById(R.id.btnr13);
        c4 = (ImageButton)findViewById(R.id.btnr14);
        c5 = (ImageButton)findViewById(R.id.btnr15);
        c6 = (ImageButton)findViewById(R.id.btnr16);
        c7 = (ImageButton)findViewById(R.id.btnr17);
        c8 = (ImageButton)findViewById(R.id.btnr18);
        c9 = (ImageButton)findViewById(R.id.btnr19);
        c10 = (ImageButton)findViewById(R.id.btnr20);
        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
        c4.setEnabled(false);
        c5.setEnabled(false);
        c6.setEnabled(false);
        c7.setEnabled(false);
        c8.setEnabled(false);
        c9.setEnabled(false);
        c10.setEnabled(false);

        p1 = (ImageButton)findViewById(R.id.btnr21);
        p2 = (ImageButton)findViewById(R.id.btnr22);
        p3 = (ImageButton)findViewById(R.id.btnr23);
        p4 = (ImageButton)findViewById(R.id.btnr24);
        p5 = (ImageButton)findViewById(R.id.btnr25);
        p6 = (ImageButton)findViewById(R.id.btnr26);
        p7 = (ImageButton)findViewById(R.id.btnr27);
        p8 = (ImageButton)findViewById(R.id.btnr28);
        p9 = (ImageButton)findViewById(R.id.btnr29);
        p10 = (ImageButton)findViewById(R.id.btnr30);
        p1.setEnabled(false);
        p2.setEnabled(false);
        p3.setEnabled(false);
        p4.setEnabled(false);
        p5.setEnabled(false);
        p6.setEnabled(false);
        p7.setEnabled(false);
        p8.setEnabled(false);
        p9.setEnabled(false);
        p10.setEnabled(false);

        e1 = (ImageButton)findViewById(R.id.btnr31);
        e2 = (ImageButton)findViewById(R.id.btnr32);
        e3 = (ImageButton)findViewById(R.id.btnr33);
        e4 = (ImageButton)findViewById(R.id.btnr34);
        e5 = (ImageButton)findViewById(R.id.btnr35);
        e6 = (ImageButton)findViewById(R.id.btnr36);
        e7 = (ImageButton)findViewById(R.id.btnr37);
        e8 = (ImageButton)findViewById(R.id.btnr38);
        e9 = (ImageButton)findViewById(R.id.btnr39);
        e10 = (ImageButton)findViewById(R.id.btnr40);
        e1.setEnabled(false);
        e2.setEnabled(false);
        e3.setEnabled(false);
        e4.setEnabled(false);
        e5.setEnabled(false);
        e6.setEnabled(false);
        e7.setEnabled(false);
        e8.setEnabled(false);
        e9.setEnabled(false);
        e10.setEnabled(false);




        // NFC 어댑터를 구한다
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xFFcd5c5c)); //액션바색깔
        //cd5c5c //767e92 회색 //261A17 갈색 //7291b7 청회색

        //카드선언 및 카드 뒤집기
        cardView1 = (CardView) findViewById(R.id.cardview1);
        cardView1.setCardBackgroundColor(Color.parseColor("#adbcb2"));

        cardView1_2 = (CardView) findViewById(R.id.cardview1_2);
        cardView1_2.setCardBackgroundColor(Color.parseColor("#adbcb2"));
        cardView1_2.setVisibility(View.GONE);

        cardView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isFirstImage1) {
                    applyRotation(0, 90);
                    isFirstImage1 = !isFirstImage1;
                } else {
                    applyRotation(0, -90);
                    isFirstImage1 = !isFirstImage1;
                }
            }
        });

        cardView1_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isFirstImage1) {
                    applyRotation(0, 90);
                    isFirstImage1 = !isFirstImage1;
                } else {
                    applyRotation(0, -90);
                    isFirstImage1 = !isFirstImage1;
                }
            }
        });

        cardView2 = (CardView) findViewById(R.id.cardview2);
        cardView2.setCardBackgroundColor(Color.parseColor("#e0bd91"));

        cardView2_2 = (CardView) findViewById(R.id.cardview2_2);
        cardView2_2.setCardBackgroundColor(Color.parseColor("#e0bd91"));
        cardView2_2.setVisibility(View.GONE);

        cardView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isFirstImage2) {
                    applyRotation2(0, 90);
                    isFirstImage2 = !isFirstImage2;
                } else {
                    applyRotation2(0, -90);
                    isFirstImage2 = !isFirstImage2;
                }
            }
        });

        cardView2_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isFirstImage2) {
                    applyRotation2(0, 90);
                    isFirstImage2 = !isFirstImage2;
                } else {
                    applyRotation2(0, -90);
                    isFirstImage2 = !isFirstImage2;
                }
            }
        });

        cardView3 = (CardView) findViewById(R.id.cardview3);
        cardView3.setCardBackgroundColor(Color.parseColor("#594235"));

        cardView3_2 = (CardView) findViewById(R.id.cardview3_2);
        cardView3_2.setCardBackgroundColor(Color.parseColor("#594235"));
        cardView3_2.setVisibility(View.GONE);

        cardView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isFirstImage3) {
                    applyRotation3(0, 90);
                    isFirstImage3 = !isFirstImage3;
                } else {
                    applyRotation3(0, -90);
                    isFirstImage3 = !isFirstImage3;
                }
            }
        });

        cardView3_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isFirstImage3) {
                    applyRotation3(0, 90);
                    isFirstImage3 = !isFirstImage3;
                } else {
                    applyRotation3(0, -90);
                    isFirstImage3 = !isFirstImage3;
                }
            }
        });

        cardView4 = (CardView) findViewById(R.id.cardview4);
        cardView4.setCardBackgroundColor(Color.parseColor("#c7ce8c"));

        cardView4_2 = (CardView) findViewById(R.id.cardview4_2);
        cardView4_2.setCardBackgroundColor(Color.parseColor("#c7ce8c"));
        cardView4_2.setVisibility(View.GONE);

        cardView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isFirstImage4) {
                    applyRotation4(0, 90);
                    isFirstImage4 = !isFirstImage4;
                } else {
                    applyRotation4(0, -90);
                    isFirstImage4 = !isFirstImage4;
                }
            }
        });

        cardView4_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isFirstImage4) {
                    applyRotation4(0, 90);
                    isFirstImage4 = !isFirstImage4;
                } else {
                    applyRotation4(0, -90);
                    isFirstImage4 = !isFirstImage4;
                }
            }
        });

        //NFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFCNFC
        // NFC 데이터 활성화에 필요한 인텐트를 생성
        Intent intent = new Intent(this, getClass());
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        mPendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        // NFC 데이터 활성화에 필요한 인텐트 필터를 생성
        IntentFilter iFilter = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        try {
            iFilter.addDataType("*/*");
            mIntentFilters = new IntentFilter[] { iFilter };
        } catch (Exception e) {
            mTextView.getText();
        }
        mNFCTechLists = new String[][] { new String[] { NfcF.class.getName() } };

        //사용자 핸드폰 번호 가져오기
        TelephonyManager systemService = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String PhoneNumber = systemService.getLine1Number();    //폰번호를 가져오는 겁니다..
        PhoneNumber = PhoneNumber.substring(PhoneNumber.length() - 10, PhoneNumber.length());
        PhoneNumber = "0" + PhoneNumber;

        String phonenumber = PhoneNumber.toString();
        Integer stamps = 0;

        String url1 = "http://zzcandy.cafe24.com/gaeungaeun.php?phonenumber=" + phonenumber + "&stamps=" + stamps;
        String url2 = "http://zzcandy.cafe24.com/cafedreamcafedream.php?phonenumber=" + phonenumber + "&stamps=" + stamps;
        String url3 = "http://zzcandy.cafe24.com/pandorothypandorothy.php?phonenumber=" + phonenumber + "&stamps=" + stamps;
        String url4 = "http://zzcandy.cafe24.com/etangetang.php?phonenumber=" + phonenumber + "&stamps=" + stamps;
        // AsyncTask를 통해 HttpURLConnection 수행.
        NetworkTask1 networkTask1 = new NetworkTask1(url1, null);
        networkTask1.execute();
        NetworkTask2 networkTask2 = new NetworkTask2(url2, null);
        networkTask2.execute();
        NetworkTask3 networkTask3 = new NetworkTask3(url3, null);
        networkTask3.execute();
        NetworkTask4 networkTask4 = new NetworkTask4(url4, null);
        networkTask4.execute();
    }

    public class NetworkTask1 extends AsyncTask<Void, Void, String> {

        private String url1;
        private ContentValues values;

        public NetworkTask1(String url1, ContentValues values) {

            this.url1 = url1;
            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url1, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 result를 출력한다.
            numgaeun = Integer.parseInt(result);
            countcoupon1.setText(numgaeun+"/total");
            if (numgaeun>=10) {
                ImageButton gaeun = (ImageButton) findViewById(R.id.coupon1);
                gaeun.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, GaeunServer.class); // 두번째 액티비티를 실행하기 위한 인텐트
                        startActivity(intent); // 두번째 액티비티를 실행합니다.
                    }
                });
            }else {
                ImageButton gaeun = (ImageButton) findViewById(R.id.coupon1);
                gaeun.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "쿠폰은 10개부터 사용가능합니다.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            if (numgaeun==0) {
            } if (numgaeun%10==1){
                imagebutton1.performClick();
            } if (numgaeun%10==2) {
                imagebutton1.performClick();
                imagebutton2.performClick();
            } if (numgaeun%10==3) {
                imagebutton1.performClick();
                imagebutton2.performClick();
                imagebutton3.performClick();
            } if (numgaeun%10==4) {
                imagebutton1.performClick();
                imagebutton2.performClick();
                imagebutton3.performClick();
                imagebutton4.performClick();
            } if (numgaeun%10==5) {
                imagebutton1.performClick();
                imagebutton2.performClick();
                imagebutton3.performClick();
                imagebutton4.performClick();
                imagebutton5.performClick();
            } if (numgaeun%10==6) {
                imagebutton1.performClick();
                imagebutton2.performClick();
                imagebutton3.performClick();
                imagebutton4.performClick();
                imagebutton5.performClick();
                imagebutton6.performClick();
            } if (numgaeun%10==7) {
                imagebutton1.performClick();
                imagebutton2.performClick();
                imagebutton3.performClick();
                imagebutton4.performClick();
                imagebutton5.performClick();
                imagebutton6.performClick();
                imagebutton7.performClick();
            } if (numgaeun%10==8) {
                imagebutton1.performClick();
                imagebutton2.performClick();
                imagebutton3.performClick();
                imagebutton4.performClick();
                imagebutton5.performClick();
                imagebutton6.performClick();
                imagebutton7.performClick();
                imagebutton8.performClick();
            } if (numgaeun%10==9) {
                imagebutton1.performClick();
                imagebutton2.performClick();
                imagebutton3.performClick();
                imagebutton4.performClick();
                imagebutton5.performClick();
                imagebutton6.performClick();
                imagebutton7.performClick();
                imagebutton8.performClick();
                imagebutton9.performClick();
            } if (numgaeun!=0&&numgaeun%10==0) {
                imagebutton1.performClick();
                imagebutton2.performClick();
                imagebutton3.performClick();
                imagebutton4.performClick();
                imagebutton5.performClick();
                imagebutton6.performClick();
                imagebutton7.performClick();
                imagebutton8.performClick();
                imagebutton9.performClick();
                imagebutton10.performClick();
            }
        }
    }

    public void On(View v) {
        imagebutton1.setImageResource(R.drawable.stampg);
    } public void On2(View v) {
        imagebutton2.setImageResource(R.drawable.stampg);
    }public void On3(View v) {
        imagebutton3.setImageResource(R.drawable.stampg);
    }public void On4(View v) {
        imagebutton4.setImageResource(R.drawable.stampg);
    }public void On5(View v) {
        imagebutton5.setImageResource(R.drawable.stampg);
    }public void On6(View v) {
        imagebutton6.setImageResource(R.drawable.stampg);
    }public void On7(View v) {
        imagebutton7.setImageResource(R.drawable.stampg);
    }public void On8(View v) {
        imagebutton8.setImageResource(R.drawable.stampg);
    }public void On9(View v) {
        imagebutton9.setImageResource(R.drawable.stampg);
    }public void On10(View v) {
        imagebutton10.setImageResource(R.drawable.stampg);
    }

    public class NetworkTask2 extends AsyncTask<Void, Void, String> {
        private String url2;
        private ContentValues values;

        public NetworkTask2(String url2, ContentValues values) {
            this.url2 = url2;
            this.values = values;
        }
        @Override
        protected String doInBackground(Void... params) {
            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url2, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 result를 출력한다.
            numcafedream = Integer.parseInt(result);
            countcoupon2.setText(numcafedream + "/total");
            if (numcafedream>=10) {
                ImageButton b = (ImageButton) findViewById(R.id.coupon2);
                b.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, CafedreamServer.class); // 두번째 액티비티를 실행하기 위한 인텐트
                        startActivity(intent); // 두번째 액티비티를 실행합니다.
                    }
                });
            }else {
                ImageButton b = (ImageButton) findViewById(R.id.coupon2);
                b.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "쿠폰은 10개부터 사용가능합니다.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            if (numcafedream==0) {
            } if (numcafedream%10==1){
                c1.performClick();
            } if (numcafedream%10==2) {
                c1.performClick();
                c2.performClick();
            } if (numcafedream%10==3) {
                c1.performClick();
                c2.performClick();
                c3.performClick();
            } if (numcafedream%10==4) {
                c1.performClick();
                c2.performClick();
                c3.performClick();
                c4.performClick();
            } if (numcafedream%10==5) {
                c1.performClick();
                c2.performClick();
                c3.performClick();
                c4.performClick();
                c5.performClick();
            } if (numcafedream%10==6) {
                c1.performClick();
                c2.performClick();
                c3.performClick();
                c4.performClick();
                c5.performClick();
                c6.performClick();
            } if (numcafedream%10==7) {
                c1.performClick();
                c2.performClick();
                c3.performClick();
                c4.performClick();
                c5.performClick();
                c6.performClick();
                c7.performClick();
            } if (numcafedream%10==8) {
                c1.performClick();
                c2.performClick();
                c3.performClick();
                c4.performClick();
                c5.performClick();
                c6.performClick();
                c7.performClick();
                c8.performClick();
            } if (numcafedream%10==9) {
                c1.performClick();
                c2.performClick();
                c3.performClick();
                c4.performClick();
                c5.performClick();
                c6.performClick();
                c7.performClick();
                c8.performClick();
                c9.performClick();
            } if (numcafedream!=0&&numcafedream%10==0) {
                c1.performClick();
                c2.performClick();
                c3.performClick();
                c4.performClick();
                c5.performClick();
                c6.performClick();
                c7.performClick();
                c8.performClick();
                c9.performClick();
                c10.performClick();
            }
        }
    }

    public void On11(View v) {
        c1.setImageResource(R.drawable.stampg);
    }public void On12(View v) {
        c2.setImageResource(R.drawable.stampg);
    }public void On13(View v) {
        c3.setImageResource(R.drawable.stampg);
    }public void On14(View v) {
        c4.setImageResource(R.drawable.stampg);
    }public void On15(View v) {
        c5.setImageResource(R.drawable.stampg);
    }public void On16(View v) {
        c6.setImageResource(R.drawable.stampg);
    }public void On17(View v) {
        c7.setImageResource(R.drawable.stampg);
    }public void On18(View v) {
        c8.setImageResource(R.drawable.stampg);
    }public void On19(View v) {
        c9.setImageResource(R.drawable.stampg);
    }public void On20(View v) {
        c10.setImageResource(R.drawable.stampg);
    }


    public class NetworkTask3 extends AsyncTask<Void, Void, String> {

        private String url3;
        private ContentValues values;

        public NetworkTask3(String url3, ContentValues values) {

            this.url3 = url3;
            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url3, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 result를 출력한다.
            numpandorothy = Integer.parseInt(result);
            countcoupon3.setText(numpandorothy + "/total");
            if (numpandorothy>=10) {
                ImageButton c = (ImageButton) findViewById(R.id.coupon3);
                c.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, PandorothyServer.class); // 두번째 액티비티를 실행하기 위한 인텐트
                        startActivity(intent); // 두번째 액티비티를 실행합니다.
                    }
                });
            }else {
                ImageButton c = (ImageButton) findViewById(R.id.coupon3);
                c.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "쿠폰은 10개부터 사용가능합니다.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            if (numpandorothy==0) {
            } if (numpandorothy%10==1){
                p1.performClick();
            } if (numpandorothy%10==2) {
                p1.performClick();
                p2.performClick();
            } if (numpandorothy%10==3) {
                p1.performClick();
                p2.performClick();
                p3.performClick();
            } if (numpandorothy%10==4) {
                p1.performClick();
                p2.performClick();
                p3.performClick();
                p4.performClick();
            } if (numpandorothy%10==5) {
                p1.performClick();
                p2.performClick();
                p3.performClick();
                p4.performClick();
                p5.performClick();
            } if (numpandorothy%10==6) {
                p1.performClick();
                p2.performClick();
                p3.performClick();
                p4.performClick();
                p5.performClick();
                p6.performClick();
            } if (numpandorothy%10==7) {
                p1.performClick();
                p2.performClick();
                p3.performClick();
                p4.performClick();
                p5.performClick();
                p6.performClick();
                p7.performClick();
            } if (numpandorothy%10==8) {
                p1.performClick();
                p2.performClick();
                p3.performClick();
                p4.performClick();
                p5.performClick();
                p6.performClick();
                p7.performClick();
                p8.performClick();
            } if (numpandorothy%10==9) {
                p1.performClick();
                p2.performClick();
                p3.performClick();
                p4.performClick();
                p5.performClick();
                p6.performClick();
                p7.performClick();
                p8.performClick();
                p9.performClick();
            } if (numpandorothy!=0&&numpandorothy%10==0) {
                p1.performClick();
                p2.performClick();
                p3.performClick();
                p4.performClick();
                p5.performClick();
                p6.performClick();
                p7.performClick();
                p8.performClick();
                p9.performClick();
                p10.performClick();
            }
        }
    }

    public void On21(View v) {
        p1.setImageResource(R.drawable.stampg);
    }public void On22(View v) {
        p2.setImageResource(R.drawable.stampg);
    }public void On23(View v) {
        p3.setImageResource(R.drawable.stampg);
    }public void On24(View v) {
        p4.setImageResource(R.drawable.stampg);
    }public void On25(View v) {
        p5.setImageResource(R.drawable.stampg);
    }public void On26(View v) {
        p6.setImageResource(R.drawable.stampg);
    }public void On27(View v) {
        p7.setImageResource(R.drawable.stampg);
    }public void On28(View v) {
        p8.setImageResource(R.drawable.stampg);
    }public void On29(View v) {
        p9.setImageResource(R.drawable.stampg);
    }public void On30(View v) {
        p10.setImageResource(R.drawable.stampg);
    }


    public class NetworkTask4 extends AsyncTask<Void, Void, String> {
        private String url4;
        private ContentValues values;

        public NetworkTask4(String url4, ContentValues values) {
            this.url4 = url4;
            this.values = values;
        }
        @Override
        protected String doInBackground(Void... params) {
            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url4, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 result를 출력한다.
            numetang = Integer.parseInt(result);
            countcoupon4.setText(numetang + "/total");
            if (numetang>=10) {
                ImageButton d = (ImageButton) findViewById(R.id.coupon4);
                d.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, EtangServer.class); // 두번째 액티비티를 실행하기 위한 인텐트
                        startActivity(intent); // 두번째 액티비티를 실행합니다.
                    }
                });
            }else {
                ImageButton d = (ImageButton) findViewById(R.id.coupon4);
                d.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "쿠폰은 10개부터 사용가능합니다.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            if (numetang==0) {
            } if (numetang%10==1){
                e1.performClick();
            } if (numetang%10==2) {
                e1.performClick();
                e2.performClick();
            } if (numetang%10==3) {
                e1.performClick();
                e2.performClick();
                e3.performClick();
            } if (numetang%10==4) {
                e1.performClick();
                e2.performClick();
                e3.performClick();
                e4.performClick();
            } if (numetang%10==5) {
                e1.performClick();
                e2.performClick();
                e3.performClick();
                e4.performClick();
                e5.performClick();
            } if (numetang%10==6) {
                e1.performClick();
                e2.performClick();
                e3.performClick();
                e4.performClick();
                e5.performClick();
                e6.performClick();
            } if (numetang%10==7) {
                e1.performClick();
                e2.performClick();
                e3.performClick();
                e4.performClick();
                e5.performClick();
                e6.performClick();
                e7.performClick();
            } if (numetang%10==8) {
                e1.performClick();
                e2.performClick();
                e3.performClick();
                e4.performClick();
                e5.performClick();
                e6.performClick();
                e7.performClick();
                e8.performClick();
            } if (numetang%10==9) {
                e1.performClick();
                e2.performClick();
                e3.performClick();
                e4.performClick();
                e5.performClick();
                e6.performClick();
                e7.performClick();
                e8.performClick();
                e9.performClick();
            } if (numetang!=0&&numetang%10==0) {
                e1.performClick();
                e2.performClick();
                e3.performClick();
                e4.performClick();
                e5.performClick();
                e6.performClick();
                e7.performClick();
                e8.performClick();
                e9.performClick();
                e10.performClick();
            }
        }
    }
    public void On31(View v) {
        e1.setImageResource(R.drawable.stampg);
    }public void On32(View v) {
        e2.setImageResource(R.drawable.stampg);
    }public void On33(View v) {
        e3.setImageResource(R.drawable.stampg);
    }public void On34(View v) {
        e4.setImageResource(R.drawable.stampg);
    }public void On35(View v) {
        e5.setImageResource(R.drawable.stampg);
    }public void On36(View v) {
        e6.setImageResource(R.drawable.stampg);
    }public void On37(View v) {
        e7.setImageResource(R.drawable.stampg);
    }public void On38(View v) {
        e8.setImageResource(R.drawable.stampg);
    }public void On39(View v) {
        e9.setImageResource(R.drawable.stampg);
    }public void On40(View v) {
        e10.setImageResource(R.drawable.stampg);
    }


    private void applyRotation(float start, float end) {
// Find the center of image
        final float centerX = cardView1.getWidth() / 2.0f;
        final float centerY = cardView1_2.getHeight() / 2.0f;

// Create a new 3D rotation with the supplied parameter
// The animation listener is used to trigger the next animation
        final Flip3dAnimation rotation =
                new Flip3dAnimation(start, end, centerX, centerY);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(isFirstImage1, cardView1, cardView1_2));
        if (isFirstImage1)
        {
            cardView1.startAnimation(rotation);
        } else {
            cardView1_2.startAnimation(rotation);
        }
    }

    private void applyRotation2(float start, float end) {
        final float centerX = cardView2.getWidth() / 2.0f;
        final float centerY = cardView2_2.getHeight() / 2.0f;

        final Flip3dAnimation rotation2 =
                new Flip3dAnimation(start, end, centerX, centerY);
        rotation2.setDuration(500);
        rotation2.setFillAfter(true);
        rotation2.setInterpolator(new AccelerateInterpolator());
        rotation2.setAnimationListener(new DisplayNextView(isFirstImage2, cardView2, cardView2_2));
        if (isFirstImage2) {
            cardView2.startAnimation(rotation2);
        } else {
            cardView2_2.startAnimation(rotation2);
        }
    }

    private void applyRotation3(float start, float end) {
        final float centerX = cardView3.getWidth() / 2.0f;
        final float centerY = cardView3_2.getHeight() / 2.0f;

        final Flip3dAnimation rotation3 =
                new Flip3dAnimation(start, end, centerX, centerY);
        rotation3.setDuration(500);
        rotation3.setFillAfter(true);
        rotation3.setInterpolator(new AccelerateInterpolator());
        rotation3.setAnimationListener(new DisplayNextView(isFirstImage3, cardView3, cardView3_2));
        if (isFirstImage3) {
            cardView3.startAnimation(rotation3);
        } else {
            cardView3_2.startAnimation(rotation3);
        }
    }

    private void applyRotation4(float start, float end) {
        final float centerX = cardView4.getWidth() / 2.0f;
        final float centerY = cardView4_2.getHeight() / 2.0f;

        final Flip3dAnimation rotation4 =
                new Flip3dAnimation(start, end, centerX, centerY);
        rotation4.setDuration(500);
        rotation4.setFillAfter(true);
        rotation4.setInterpolator(new AccelerateInterpolator());
        rotation4.setAnimationListener(new DisplayNextView(isFirstImage4, cardView4, cardView4_2));
        if (isFirstImage4) {
            cardView4.startAnimation(rotation4);
        } else {
            cardView4_2.startAnimation(rotation4);
        }
    }

    public void onResume() {
        super.onResume();
        // 앱이 실행될때 NFC 어댑터를 활성화 한다
        if( mNfcAdapter != null )
            mNfcAdapter.enableForegroundDispatch(this, mPendingIntent, mIntentFilters, mNFCTechLists);

        // NFC 태그 스캔으로 앱이 자동 실행되었을때
        if( NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction()) )
            // 인텐트에 포함된 정보를 분석해서 화면에 표시
            onNewIntent(getIntent());
    }

    public void onPause() {
        super.onPause();
        // 앱이 종료될때 NFC 어댑터를 비활성화 한다
        if( mNfcAdapter != null )
            mNfcAdapter.disableForegroundDispatch(this);
    }

    // NFC 태그 정보 수신 함수. 인텐트에 포함된 정보를 분석해서 화면에 표시
    @Override
    public void onNewIntent(Intent intent) {
        // 인텐트에서 액션을 추출
        String action = intent.getAction();
        // 인텐트에서 태그 정보 추출
        String tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG).toString();
        String strMsg = action + "\n\n" + tag;

        // 인텐트에서 NDEF 메시지 배열을 구한다
        Parcelable[] messages = intent.getParcelableArrayExtra(
                NfcAdapter.EXTRA_NDEF_MESSAGES);
        if(messages == null) return;

        for(int i=0; i < messages.length; i++)
            // NDEF 메시지를 화면에 출력
            showMsg((NdefMessage)messages[i]);

    }



    // NDEF 메시지를 화면에 출력
    public void showMsg(NdefMessage mMessage) {
        String strMsg = "", strRec="";
        // NDEF 메시지에서 NDEF 레코드 배열을 구한다
        NdefRecord[] recs = mMessage.getRecords();
        for (int i = 0; i < recs.length; i++) {
            // 개별 레코드 데이터를 구한다
            NdefRecord record = recs[i];
            byte[] payload = record.getPayload();
            // 레코드 데이터 종류가 텍스트 일때    => 텍스트가 a일 때로 하고시픔
            if( Arrays.equals(record.getType(), NdefRecord.RTD_TEXT) ) {
                // 버퍼 데이터를 인코딩 변환
                strRec = byteDecoding(payload);
                strRec =  strRec;
            }
            strMsg += (strRec);
            //사용자 핸드폰 번호 가져오기
            TelephonyManager systemService = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            String phoneNumber = null;
            String PhoneNumber = systemService.getLine1Number();    //폰번호를 가져온다..
            PhoneNumber = PhoneNumber.substring(PhoneNumber.length() - 10, PhoneNumber.length());
            PhoneNumber = "0" + PhoneNumber;
            final TextView PN = new TextView(MainActivity.this);
            PN.setText(PhoneNumber);

            //NFC로 쿠폰받을 때, 카페이름으로 구분해서 디비에 stamps 갯수 올리기
            switch (strRec){
                case "gaeun":
                    // NDEF 메시지를 화면에 출력
                    final String phonenumber = PN.getText().toString();

                    final int stamps = 1;

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    Toast.makeText(MainActivity.this, "쿠폰이 도착했습니다!", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.putExtra("phonenumber", phonenumber);
                                    intent.putExtra("stamps", stamps);


                                } else {
                                    Toast.makeText(MainActivity.this, "쿠폰 배달에 실패했습니다 ㅠㅠ ", Toast.LENGTH_SHORT).show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    StampRequest stampRequest = new StampRequest(phonenumber, stamps + "", responseListener);
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    queue.add(stampRequest);
                    break;

                case "cafedream":
                    // NDEF 메시지를 화면에 출력
                    final String phonenumber2 = PN.getText().toString();

                    final int stamps2 = 1;

                    Response.Listener<String> responseListener2 = new Response.Listener<String>() {
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    Toast.makeText(MainActivity.this, "쿠폰이 도착했습니다!", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.putExtra("phonenumber", phonenumber2);
                                    intent.putExtra("stamps", stamps2);

                                } else {
                                    Toast.makeText(MainActivity.this, "쿠폰 배달에 실패했습니다 ㅠㅠ ", Toast.LENGTH_SHORT).show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    CafedreamStampRequest cafedreamStampRequest = new CafedreamStampRequest(phonenumber2, stamps2 + "", responseListener2);
                    RequestQueue queue2 = Volley.newRequestQueue(MainActivity.this);
                    queue2.add(cafedreamStampRequest);
                    break;

                case "etang":
                    // NDEF 메시지를 화면에 출력
                    final String phonenumber3 = PN.getText().toString();

                    final int stamps3 = 1;

                    Response.Listener<String> responseListener3 = new Response.Listener<String>() {
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    Toast.makeText(MainActivity.this, "쿠폰이 도착했습니다!", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.putExtra("phonenumber", phonenumber3);
                                    intent.putExtra("stamps", stamps3);

                                } else {
                                    Toast.makeText(MainActivity.this, "쿠폰 배달에 실패했습니다 ㅠㅠ ", Toast.LENGTH_SHORT).show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    EtangStampRequest etangStampRequest = new EtangStampRequest(phonenumber3, stamps3 + "", responseListener3);
                    RequestQueue queue3 = Volley.newRequestQueue(MainActivity.this);
                    queue3.add(etangStampRequest);
                    break;

                case "pandorothy":
                    // NDEF 메시지를 화면에 출력
                    final String phonenumber4 = PN.getText().toString();

                    final int stamps4 = 1;

                    Response.Listener<String> responseListener4 = new Response.Listener<String>() {
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    Toast.makeText(MainActivity.this, "쿠폰이 도착했습니다!", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.putExtra("phonenumber", phonenumber4);
                                    intent.putExtra("stamps", stamps4);

                                } else {
                                    Toast.makeText(MainActivity.this, "쿠폰 배달에 실패했습니다 ㅠㅠ ", Toast.LENGTH_SHORT).show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    PandorothyStampRequest pandorothyStampRequest = new PandorothyStampRequest(phonenumber4, stamps4 + "", responseListener4);
                    RequestQueue queue4 = Volley.newRequestQueue(MainActivity.this);
                    queue4.add(pandorothyStampRequest);
                    break;
            }
        }
    }

    // 버퍼 데이터를 디코딩해서 String 으로 변환
    public String byteDecoding(byte[] buf) {
        String strText="";
        String textEncoding = ((buf[0] & 0200) == 0) ? "UTF-8" : "UTF-16";
        int langCodeLen = buf[0] & 0077;

        try {
            strText = new String(buf, langCodeLen + 1,
                    buf.length - langCodeLen - 1, textEncoding);
        } catch(Exception e) {
            Log.d("tag1", e.toString());
        }
        return strText;
    }
}