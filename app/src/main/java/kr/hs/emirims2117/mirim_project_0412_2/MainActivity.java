package kr.hs.emirims2117.mirim_project_0412_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        textResult=findViewById(R.id.text_result);

        

        int[] btnId={R.id.btn_plus,R.id.btn_Minus,R.id.btn_Multi,R.id.btn_Divide, R.id.btn_mod};
        Button[] btn=new Button[btnId.length];
        for(int i=0; i<btn.length; i++){
            btn[i]=findViewById(btnId[i]);
            View.OnClickListener btnListener = null;
            btn[i].setOnClickListener(btnListener);
        }
        
        View.OnClickListener btnListener =new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String edit1Str=edit1.getText().toString();
                String edit2Str=edit2.getText().toString();
                if(edit1Str.equals("")||edit2Str.equals("")){
                    Toast.makeText(getApplicationContext(),
                            "연산에 필요한 숫자가 입력되지 않았습니다",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                double num1=Double.parseDouble(edit1Str);
                double num2=Double.parseDouble(edit2Str);

                double result=0;
                switch(view.getId()){
                    case R.id.btn_plus:
                        result=num1+num2;
                        break;
                    case R.id.btn_minus:
                        result=num1-num2;
                        break;
                    case R.id.btn_multi:
                        result=num1*num2;
                        break;
                    case R.id.btn_divide:
                        result=num1/num2;
                        if(num2==0){
                            Toast.makeText(getApplicationContext(),
                                    "나누는 수는 0이면 안됩니다",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }
                        break;
                    case R.id.btn_mod:
                        if(num2==0){
                            Toast.makeText(getApplicationContext(),
                                    "나누는 수는 0이면 안됩니다",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }
                        result=num1%num2;
                        break;
                }
                textResult.setText(R.string.text_result);
                textResult.append(" "+String.format("%.2f",result));//소수점 두번째 자리

            }
        };

    }
}