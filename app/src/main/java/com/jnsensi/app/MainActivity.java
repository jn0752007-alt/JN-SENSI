package com.jnsensi.app;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    public void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);
        layout.setPadding(24, 30, 24, 24);
        layout.setBackgroundColor(Color.rgb(20, 20, 30));

        TextView title = new TextView(this);
        title.setText("👑 JN SENSI");
        title.setTextSize(28);
        title.setTextColor(Color.WHITE);
        layout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Painel de Sensibilidade");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(18);
        layout.addView(subtitle);

        String[] nomes = {"Geral", "Ponto Vermelho", "Mira 2x", "Mira 4x", "AWM"};
        int[] valores = {190, 185, 175, 165, 50};

        for (int i = 0; i < nomes.length; i++) {
            TextView item = new TextView(this);
            item.setText(nomes[i] + ": " + valores[i]);
            item.setTextSize(20);
            item.setTextColor(Color.WHITE);
            item.setPadding(0, 20, 0, 20);
            layout.addView(item);
        }

        Button copiar = new Button(this);
        copiar.setText("COPIAR CONFIGURAÇÃO");
        layout.addView(copiar);

        copiar.setOnClickListener(v -> {
            String config = "Geral 190\\nPonto Vermelho 185\\nMira 2x 175\\nMira 4x 165\\nAWM 50";
            android.content.ClipboardManager cm =
                (android.content.ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            cm.setPrimaryClip(android.content.ClipData.newPlainText("JN SENSI", config));
            Toast.makeText(this, "Configuração copiada!", Toast.LENGTH_SHORT).show();
        });

        setContentView(layout);
    }
}
