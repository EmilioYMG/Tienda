package com.example.tienda.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tienda.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

//public class AdaptadorMuestraProducto extends RecyclerView.Adapter<AdaptadorMuestraProducto.ViewHolder> {
public class AdaptadorMuestraProducto extends FirestoreRecyclerAdapter<MuestraProducto,AdaptadorMuestraProducto.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    private Context context;
    public AdaptadorMuestraProducto(@NonNull FirestoreRecyclerOptions<MuestraProducto> options,Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull MuestraProducto producto) {
        holder.txtCvTitulo.setText(producto.getNombre());
        holder.txtCvPrecio.setText("$"+ Float.toString(producto.getPrecio()));
        if(producto.isExistencia()==true)
        {
            holder.txtCvExistencia.setText("Producto en existencia");
        }else
        {
            holder.txtCvExistencia.setText("Producto agotado");
        }
        Glide.with(context).load(producto.getImagen()).into(holder.imgbCVProducto);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_producto,parent,false);
        return new ViewHolder(v);
    }

    /* Antes de la base de datos
        ArrayList<MuestraProducto> productos;
        public AdaptadorMuestraProducto(ArrayList<MuestraProducto> productos)
        {
            this.productos=productos;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //construye el viewholder
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_producto,parent,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            MuestraProducto producto=productos.get(position);
            holder.imgbCVProducto.setImageResource(producto.getImagen());
        }

        @Override
        public int getItemCount() {
            return productos.size();
        }
    */
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtCvTitulo;
        TextView txtCvPrecio;
        ImageButton imgbCVProducto;
        TextView txtCvExistencia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCvTitulo=itemView.findViewById(R.id.txtCvTitulo);
            txtCvPrecio=itemView.findViewById(R.id.txtCvPrecio);
            imgbCVProducto=itemView.findViewById(R.id.imgbCVProducto);
            txtCvExistencia=itemView.findViewById(R.id.txtCvExistencia);
        }
    }
}
