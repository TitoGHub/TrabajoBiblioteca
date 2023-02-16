package com.example.trabajobiblioteca;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajobiblioteca.clases.libros;

import java.util.ArrayList;

public class libroVH extends RecyclerView.ViewHolder implements View.OnClickListener{

    public static final String EXTRA_OBJETO_PRODUCTO = "com.example.trabajobiblioteca.libroVH";
    public TextView ISBN;
    public TextView genero;
    public TextView autor;
    public TextView numPag;

    private libroAdapter la;



    public libroVH(@NonNull View itemView, libroAdapter libroAdapter) {
        super(itemView);
        ISBN = (TextView) itemView.findViewById(R.id.txtRvISBN);
        genero = (TextView) itemView.findViewById(R.id.txtRvGenero);
        autor = (TextView) itemView.findViewById(R.id.txtRvAutor);
        numPag = (TextView) itemView.findViewById(R.id.txtRvNumPag);

        this.la = libroAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int posicion = getLayoutPosition();
        ArrayList<libros> libros = this.la.getLibros();
        libros lb = libros.get(posicion);
        //-----------
        Intent intent = new Intent(la.getContexto(), librosDet.class);
        intent.putExtra(EXTRA_OBJETO_PRODUCTO, lb);
        la.getContexto().startActivity(intent);
    }
}
