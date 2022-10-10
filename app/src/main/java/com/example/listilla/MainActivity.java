package com.example.listilla;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Model: Record (intents=puntuació, nom)
    class Record {
        public int intents;
        public String nom;

        public Record(int _intents, String _nom ) {
            intents = _intents;
            nom = _nom;
        }
    }
    // Model = Taula de records: utilitzem ArrayList
    ArrayList<Record> records;

    // ArrayAdapter serà l'intermediari amb la ListView
    ArrayAdapter<Record> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialitzem model
        records = new ArrayList<Record>();
        // Afegim alguns exemples
        records.add(new Record(33, "Manolo"));
        records.add(new Record(12, "Pepe"));
        records.add(new Record(42, "Laura"));

        // Inicialitzem l'ArrayAdapter amb el layout pertinent
        adapter = new ArrayAdapter<Record>(this, R.layout.list_item, records) {
            @Override
            public View getView(int pos, View convertView, ViewGroup container) {
                // getView ens construeix el layout i hi "pinta" els valors de l'element en la posició pos
                if (convertView == null) {
                    // inicialitzem l'element la View amb el seu layout
                    convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
                }
                // "Pintem" valors (també quan es refresca)
                ((TextView) convertView.findViewById(R.id.nom)).setText(getItem(pos).nom);
                ((TextView) convertView.findViewById(R.id.intents)).setText(Integer.toString(getItem(pos).intents));
                return convertView;
            }

        };

        // busquem la ListView i li endollem el ArrayAdapter
        ListView lv = (ListView) findViewById(R.id.recordsView);
        lv.setAdapter(adapter);

        // botó per afegir entrades a la ListView
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] noms = new String[20];
                noms[0] = "Pablo";
                noms[1] = "Paco";
                noms[2] = "Maria";
                noms[3] = "Hector";
                noms[4] = "Carla";
                noms[5] = "Jonadab";
                noms[6] = "Joan";
                noms[7] = "Ainoa";
                noms[8] = "Maite";
                noms[9] = "Carlos";
                noms[10] = "Marcos";
                noms[11] = "Yoli";
                noms[12] = "Julia";
                noms[13] = "Carmen";
                noms[14] = "Antonio";
                noms[15] = "Pepita";
                noms[16] = "Jordi";
                noms[17] = "Rafa";
                noms[18] = "Leo";
                noms[19] = "Robert";
                for (int i = 0; i < 20; i++) {
                    int num = (int) (Math.random() * (20 - 1));
                    int user = (int) (Math.random() * (20 - 1));
                    records.add(new Record(num, noms[user]));
                }
                // notificar l'adapter dels canvis al model
                adapter.notifyDataSetChanged();
            }
        });
        Button b3 = (Button) findViewById(R.id.button);
    }
}