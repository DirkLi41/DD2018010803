package tw.com.pcschool.dd2018010803;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView lv1;
    //String[] str = {"AAA", "BBB", "CCC", "DDD", "EEE"};
    ArrayList<Map<String, Object>> myList1 = new ArrayList<>();
    /*TextView tv1;
           TextView tv2;*/

    boolean chks[] = new boolean[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = (ListView)findViewById(R.id.listView);

        HashMap<String, Object> hm1 = new HashMap<>();
        hm1.put("city", "台北");
        hm1.put("code", "02");
        hm1.put("img", R.drawable.tp);
        myList1.add(hm1);
        HashMap<String, Object> hm2 = new HashMap<>();
        hm2.put("city", "台中");
        hm2.put("code", "04");
        hm2.put("img", R.drawable.tc);
        myList1.add(hm2);
        HashMap<String, Object> hm3 = new HashMap<>();
        hm3.put("city", "台南");
        hm3.put("code", "06");
        hm3.put("img", R.drawable.tn);
        myList1.add(hm3);
        HashMap<String, Object> hm4 = new HashMap<>();
        hm4.put("city", "高雄");
        hm4.put("code", "07");
        hm4.put("img", R.drawable.kh);
        myList1.add(hm4);
        HashMap<String, Object> hm5 = new HashMap<>();
        hm5.put("city", "台北(2)");
        hm5.put("code", "02(2)");
        hm5.put("img", R.drawable.tp);
        myList1.add(hm5);
        HashMap<String, Object> hm6 = new HashMap<>();
        hm6.put("city", "台中(2)");
        hm6.put("code", "04(2)");
        hm6.put("img", R.drawable.tc);
        myList1.add(hm6);
        HashMap<String, Object> hm7 = new HashMap<>();
        hm7.put("city", "台南(2)");
        hm7.put("code", "06(2)");
        hm7.put("img", R.drawable.tn);
        myList1.add(hm7);
        HashMap<String, Object> hm8 = new HashMap<>();
        hm8.put("city", "高雄(2)");
        hm8.put("code", "07(2)");
        hm8.put("img", R.drawable.kh);
        myList1.add(hm8);

        MyAdapter ada1 = new MyAdapter(MainActivity.this, myList1, chks);
        lv1.setAdapter(ada1);

    }

    /*public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            //return str.length;
            return myList1.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {
            //tv1.setText(str[position]);
            // return tv1;

            LayoutInflater li = LayoutInflater.from(MainActivity.this);
            View v = li.inflate(R.layout.mylayout,null);

            tv1 = v.findViewById(R.id.textView);
            tv1.setText(myList1.get(position).get("city").toString());
            tv2 = v.findViewById(R.id.textView2);
            tv2.setText(myList1.get(position).get("code").toString());
            ImageView iv1 = v.findViewById(R.id.imageView);
            iv1.setImageResource((Integer)myList1.get(position).get("img"));

            CheckBox chk = (CheckBox) v.findViewById(R.id.checkBox);
            chk.setChecked(chks[position]);
            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    chks[position] = b;
                }
            });

            return v;
        }
    }*/
    public void clickCheck(View v)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < chks.length;i++)
        {
            if(chks[i])
            {
                sb.append(myList1.get(i).get("city") + ",");
            }
        }
        Toast.makeText(MainActivity.this,sb.toString(),Toast.LENGTH_LONG).show();
    }
}
