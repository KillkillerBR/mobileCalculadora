package br.unigran.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Boolean firstOp = true;
    Boolean repeatedEqual = true;
    Boolean repeatedPlus = true;
    Boolean repeatedMinus = true;
    Boolean repeatedMult = true;
    Boolean repeatedDiv = true;
    //0 para soma, 1 para sub, 2 para mult, 3 para div
    Integer lastOp;
    Float primeiroN = 0f;
    Float segundoN = 0f;
    Float resultado = 0f;
    Button btComa;
    Button bt0;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;
    Button btPlus;
    Button btMinus;
    Button btMult;
    Button btDiv;
    Button btEqual;
    Button btClear;
    TextView campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btComa = findViewById(R.id.btnComa);
        bt0 = findViewById(R.id.btn0);
        bt1 = findViewById(R.id.btn1);
        bt2 = findViewById(R.id.btn2);
        bt3 = findViewById(R.id.btn3);
        bt4 = findViewById(R.id.btn4);
        bt5 = findViewById(R.id.btn5);
        bt6 = findViewById(R.id.btn6);
        bt7 = findViewById(R.id.btn7);
        bt8 = findViewById(R.id.btn8);
        bt9 = findViewById(R.id.btn9);
        btPlus = findViewById(R.id.btnPlus);
        btMinus = findViewById(R.id.btnMinus);
        btMult = findViewById(R.id.btnMult);
        btDiv = findViewById(R.id.btnDiv);
        btEqual = findViewById(R.id.btnEqual);
        btClear = findViewById(R.id.btnClear);
        campo = findViewById(R.id.editTextText);
        campo.setText("");
        initNumButtons();
        initOperators();
    }

    private void initNumButtons() {
        btComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campo.setText(campo.getText()+".");
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campo.setText(campo.getText()+"0");
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                campo.setText(campo.getText()+"1");
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campo.setText(campo.getText()+"2");
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campo.setText(campo.getText()+"3");
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campo.setText(campo.getText()+"4");
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campo.setText(campo.getText()+"5");
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campo.setText(campo.getText()+"6");
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campo.setText(campo.getText()+"7");
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campo.setText(campo.getText()+"8");
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { campo.setText(campo.getText()+"9"); }
        });
    }

    private void initOperators() {

        btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOp) {
                    firstOp = false;
                }
                primeiroN = Float.parseFloat(campo.getText().toString());
                if (!repeatedPlus) {
                    primeiroN = 0f;
                    repeatedPlus = true;
                    repeatedMinus = false;
                    repeatedMult = false;
                    repeatedDiv = false;
                }
                resultado += primeiroN;
                primeiroN = 0f;
                campo.setText("");
                lastOp = 0;
                repeatedEqual = false;
            }
        });

        btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOp) {
                    firstOp = false;
                }
                primeiroN = Float.parseFloat(campo.getText().toString());
                if (!repeatedMinus) {
                    primeiroN = 0f;
                    repeatedPlus = false;
                    repeatedMinus = true;
                    repeatedMult = false;
                    repeatedDiv = false;
                }
                resultado -= primeiroN;
                primeiroN = 0f;
                campo.setText("");
                lastOp = 1;
                repeatedEqual = false;
            }
        });

        btMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOp) {
                    resultado = 1f;
                    firstOp = false;
                }
                primeiroN = Float.parseFloat(campo.getText().toString());
                if (!repeatedMult) {
                    primeiroN = 1f;
                    repeatedPlus = false;
                    repeatedMinus = false;
                    repeatedMult = true;
                    repeatedDiv = false;
                }
                resultado *= primeiroN;
                primeiroN = 1f;
                campo.setText("");
                lastOp = 2;
                repeatedEqual = false;
            }
        });

        btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOp) {
                    resultado = 1f;
                    firstOp = false;
                }
                primeiroN = Float.parseFloat(campo.getText().toString());
                if (!repeatedDiv) {
                    primeiroN = 1f;
                    repeatedPlus = false;
                    repeatedMinus = false;
                    repeatedMult = false;
                    repeatedDiv = true;
                }
                resultado /= primeiroN;
                primeiroN = 1f;
                campo.setText("");
                lastOp = 3;
                repeatedEqual = false;
            }
        });

        btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!repeatedEqual) {
                    segundoN = Float.parseFloat(campo.getText().toString());
                    repeatedEqual = true;
                }
                if (lastOp == 0) {
                    resultado += segundoN;
                    repeatedPlus = false;
                }else if (lastOp == 1) {
                    resultado -= segundoN;
                    repeatedMinus = false;
                }else if (lastOp == 2) {
                    resultado *= segundoN;
                    repeatedMinus = false;
                }else if (lastOp == 3) {
                    resultado /= segundoN;
                    repeatedMinus = false;
                }
                campo.setText(resultado.toString());
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstOp = true;
                repeatedEqual = true;
                repeatedPlus = true;
                repeatedMinus = true;
                repeatedMult = true;
                repeatedDiv = true;
                primeiroN = 0f;
                segundoN = 0f;
                resultado = 0f;
                campo.setText("");
            }
        });
    }

}