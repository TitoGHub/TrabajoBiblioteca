package com.example.trabajobiblioteca;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajobiblioteca.clases.libros;

import java.util.ArrayList;

public class libroAdapter extends RecyclerView.Adapter<libroVH>{

    private Context contexto;
    private ArrayList<libros> Libros;
    private LayoutInflater inflate;


    public libroAdapter(Context contexto){
        this.contexto = contexto;
        this.Libros = Libros;
        inflate = LayoutInflater.from(contexto);
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
        this.Libros = new ArrayList<libros>();
    }

    public ArrayList<libros> getLibros() {
        return Libros;
    }

    public void setListaLibros(ArrayList<libros> Libros) {
        this.Libros = Libros;
        if(this.Libros == null){
            Log.i("Libros", "la lista libros es nulo");
        }
        else{
            for(libros lb: Libros){
                Log.i("Libro","Libro -> "+lb.getIdLibro());
            }
        }
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public libroVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflate.inflate(R.layout.librorv, parent, false);
        libroVH lvh = new libroVH(mItemView, this);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull libroVH holder, int position) {
        libros lb = this.Libros.get(position);
        holder.ISBN.setText("ISBN: "+ lb.getIdLibro());
        holder.genero.setText("Genero: "+ lb.getGenero());
        holder.autor.setText("Autor: "+ lb.getAutor());
        holder.numPag.setText("Numero paginas: "+ lb.getNumPaginas());
    }

    @Override
    public int getItemCount() {
        if(Libros != null) {
            return this.Libros.size();
        }
        else return 0;
    }
}
