package com.example.a18242.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    double result = 0;
  boolean flag=true;
    EditText ed;
    Button c;
    Button x ;
    Button yu;
    Button chu;
    Button b7;
    Button b8;
    Button b9;
    Button b4;
    Button b5;
    Button b6;
    Button b1;
    Button b2;
    Button b3;
    Button chen;
    Button jian;
    Button jia;
    Button b0;
    Button dot;
    Button dyu;
    String fuhao="=";//符号初始为=
    boolean fu=false;//控制累积算法
    boolean firstnumber=true;//判断第一个数字是否结束
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsq);
//        Button but1=findViewById(R.id.button2);
//        Button but2=findViewById(R.id.button3);
//        but1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TextView tv1=findViewById(R.id.editText);
//                TextView tv2=findViewById(R.id.editText);
//                int num1=Integer.parseInt(tv1.getText().toString());
//                int num2=Integer.parseInt(tv2.getText().toString());
//                String sum=Integer.toString(num1+num2);
//                Toast.makeText(MainActivity.this,sum,Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//        but2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//    }
        ed=findViewById(R.id.ed);
        c=findViewById(R.id.c);
        x =findViewById(R.id.x);dyu=findViewById(R.id.dyu);
        yu=findViewById(R.id.yu);chu=findViewById(R.id.chu);b7=findViewById(R.id.seven);
        b8=findViewById(R.id.eigth);b9=findViewById(R.id.ninth);b4=findViewById(R.id.four);
        b5=findViewById(R.id.five);b6=findViewById(R.id.six);b1=findViewById(R.id.one);
        b2=findViewById(R.id.two);b3=findViewById(R.id.three);chen=findViewById(R.id.chen);
        jia=findViewById(R.id.jia);b0=findViewById(R.id.zreo);dot=findViewById(R.id.dot);
        jian=findViewById(R.id.jian);
        ed.setFocusable(false);//不可编辑
        ed.setClickable(false);//不可点击
        dyu.setOnClickListener(this);
        dot.setOnClickListener(this);
        b0.setOnClickListener(this);
        c.setOnClickListener(this);
        x.setOnClickListener(this);
        jian.setOnClickListener(this);
        jia.setOnClickListener(this);
        chen.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        chu.setOnClickListener(this);
        yu.setOnClickListener(this);
}
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.c:
                ed.setText("");
                break;
            case  R.id.x:
                back();
                break;
            case R.id.yu:
                checked();
                fuhao="%";
                fu=false;
                break;
            case  R.id.chu:
                checked();
                fuhao="/";
                fu=false;
                break;
            case  R.id.seven:
               addnumber("7");
               break;
            case  R.id.eigth:
                addnumber("8");
                break;
            case R.id.ninth:
                addnumber("9");
                break;
            case R.id.four:
                addnumber("4");
                break;
            case R.id.five:
                addnumber("5");
                break;
            case R.id.six:
                addnumber("6");
                break;
            case R.id.one:
                addnumber("1");
                break;
            case R.id.two:
                addnumber("2");
                break;
            case  R.id.three:
                addnumber("3");
                break;
            case R.id.zreo:
                addnumber("0");
                break;
            case R.id.chen:
                checked();
                fuhao="*";
                fu=false;
                break;
            case R.id.jia:
                checked();
                fuhao="+";
                fu=false;
                break;
            case R.id.jian:
                checked();
                fuhao="-";
                fu=false;
                break;
            case R.id.dot:
                if(ed.getText().toString().indexOf(".")<0|ed.getText().toString().equals("")) {
                    if(firstnumber) {
                        ed.setText("0.");
                        firstnumber=false;
                        break;
                    }
                    addnumber(".");}
                    break;
            case R.id.dyu:
                checked();
                fuhao="=";
                fu=false;
                break;
        }}
    public void back(){//回退效果，这里就多看看就能懂意思了
        if(ed.getText().toString().indexOf(".")>0) {
            double temp=Double.parseDouble(ed.getText().toString());
            String[] a = String.valueOf(temp).split("\\.");
            String one=a[0];
           String t=a[1];
                if (t.length()<2){
                int r=(int) temp;
                ed.setText(String.valueOf(r));
                firstnumber=false;}
                else {
                    long xiao=Long.valueOf(t);
                    xiao=xiao/10;
                    ed.setText(String.valueOf(one+"."+xiao));
                    firstnumber=false;

                }

        }
            else  if (Double.parseDouble(ed.getText().toString())<10){
                ed.setText("");
            }
            else {
                double temp1=Double.parseDouble(ed.getText().toString());
                 if (temp1>10){
                    int r=(int) temp1/10;
                    double rr=(double)r;
                    ed.setText(String.valueOf(rr));
                 firstnumber=false;}}
    }
    public void addnumber(String n){
        if (!firstnumber){//判断第一个数字结束没有
            ed.append(n);
        }
        else {
            ed.setText(n);
            firstnumber=false;
            fu=true;
        }}
        public void checked(){
            if (fu){
                if (fuhao.equals("=")){
                    result= Double.parseDouble(ed.getText().toString());
                }else if (fuhao.equals("-")){
                    result-= Double.parseDouble(ed.getText().toString());
                }
                else if (fuhao.equals("+")){
                    result+= Double.parseDouble(ed.getText().toString());
                }
                else if (fuhao.equals("*")){
                    result*= Double.parseDouble(ed.getText().toString());
                }
                else if (fuhao.equals("/")){
                    result/= Double.parseDouble(ed.getText().toString());
                }
                else if (fuhao.equals("%")){
                    result%= Double.parseDouble(ed.getText().toString());
                }
            }
            ed.setText(String.valueOf(result));
            firstnumber=true;
    }
}
