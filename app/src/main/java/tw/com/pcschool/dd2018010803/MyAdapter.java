package tw.com.pcschool.dd2018010803;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Student on 2018/1/9.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Map<String, Object>> myList1 = new ArrayList<>();
    boolean chks[];
    Context con;

    public MyAdapter(Context con, ArrayList<Map<String, Object>> myList1, boolean chks[])
    {
        this.con = con;
        this.myList1 = myList1;
        this.chks = chks;
}
    @Override
    public int getCount() {
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
    public View getView(final int position, View v, ViewGroup viewGroup) {

        ViewHolder viewholder;
        if(v == null)
        {
            LayoutInflater li = LayoutInflater.from(con);
            v = li.inflate(R.layout.mylayout,null);
            viewholder = new ViewHolder();
            viewholder.tv1 = v.findViewById(R.id.textView);
            viewholder.tv2 = v.findViewById(R.id.textView2);
            viewholder.iv1 = v.findViewById(R.id.imageView);
            viewholder.chk = (CheckBox) v.findViewById(R.id.checkBox);

            v.setTag(viewholder);
        }
        else
        {
            viewholder = (ViewHolder) v.getTag();
        }


        viewholder.tv1.setText(myList1.get(position).get("city").toString());
        viewholder.tv2.setText(myList1.get(position).get("code").toString());
        viewholder.iv1.setImageResource((Integer)myList1.get(position).get("img"));

        viewholder.chk.setOnCheckedChangeListener(null);
        viewholder.chk.setChecked(chks[position]);
        viewholder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chks[position] = b;
            }
        });

        return v;
    }
    static class ViewHolder
    {
        TextView tv1;
        TextView tv2;
        ImageView iv1;
        CheckBox chk;
    }
}
