package com.example.Jared.lectorlibro;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

public class AdaptadorLibros extends  RecyclerView.Adapter<AdaptadorLibros.ViewHolder> {
    private LayoutInflater inflador; //Crea Layouts a partir del XML
    protected Vector<Libro> vectorLibros; //Vector con libros a visualizar
    private Context contexto;
    private View.OnLongClickListener onLongClickListener;

    public AdaptadorLibros(Context contexto, Vector<Libro> vectorLibros) {
        inflador = (LayoutInflater) contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.vectorLibros = vectorLibros;
        this.contexto = contexto;
    }
    // Creamos el ViewHolder con las vista de un elemento sin personalizar
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos la vista desde el xml
        View v = inflador.inflate(com.example.Jared.lectorlibro.R.layout.elemento_selector, null);
        v.setOnClickListener(onClickListener);
        v.setOnLongClickListener(onLongClickListener);
        return new ViewHolder(v);
    }
    // Usando como base el ViewHolder y lo personalizamos
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Libro libro = vectorLibros.elementAt(position);

        holder.getTitulo().setText(
                libro.getTitulo()     );
        holder.getPortada().setImageResource(
                libro.getRecursoImagen()
        );
    }
    // Indicamos el número de elementos de la lista
    @Override public int getItemCount() {
        return vectorLibros.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView portada;
        private final TextView titulo;

        public ImageView getPortada() {
            return portada;
        }

        public TextView getTitulo() {
            return titulo;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            portada =
                    itemView.findViewById(R.id.portada);
            titulo = itemView.findViewById(R.id.titulo);

        }
    }

    private View.OnClickListener onClickListener;
    public void setOnItemClickListener(View.OnClickListener onClickListener) {     this.onClickListener = onClickListener; }
    public void setOnItemLongClickListener(View.OnLongClickListener
                                                   onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }
}
