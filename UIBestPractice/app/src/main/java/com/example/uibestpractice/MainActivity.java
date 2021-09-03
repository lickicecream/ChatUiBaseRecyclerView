package com.example.uibestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Msg>msgList=new ArrayList<>();
    Button send;
    RecyclerView recyclerView;
    MsgAdapter msgAdapter;
    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        input=(EditText)findViewById(R.id.edit_text);
        recyclerView=this.findViewById(R.id.msg_recycler_view);
        msgAdapter=new MsgAdapter(msgList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setAdapter(msgAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        send=this.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String context=input.getText().toString();
                if(!context.equals("")){
                    msgList.add(new Msg(context,Msg.TYPE_SEND));
                    msgAdapter.notifyItemInserted(msgList.size()-1);
                    recyclerView.scrollToPosition(msgList.size()-1);
                    input.setText("");
                }
            }
        });

    }

    private void initMsg(){
        Msg msg=new Msg("Hello Guy",Msg.TYPE_SEND);
        msgList.add(msg);
        msg=new Msg("yeah nigger ",Msg.TYPE_RECEIVED);
        msgList.add(msg);
        msg=new Msg("shit bro hows u doing",Msg.TYPE_SEND);
        msgList.add(msg);
        msg=new Msg("u little bitch",Msg.TYPE_RECEIVED);
        msgList.add(msg);
    }
}