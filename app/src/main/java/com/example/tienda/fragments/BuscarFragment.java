package com.example.tienda.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda.R;
import com.example.tienda.recyclerview.AdaptadorMuestraProducto;
import com.example.tienda.recyclerview.MuestraProducto;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class BuscarFragment extends Fragment {


    private RecyclerView rcvProductos;
    private AdaptadorMuestraProducto mAdapter;
    private FirebaseFirestore mFirestore; //Comenzar a trabajar con firestore
    //private ArrayList<MuestraProducto> productos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_buscar,container,false);
        rcvProductos=v.findViewById(R.id.rcvProductos);
        //inicializar para abrir la conexion
        mFirestore=FirebaseFirestore.getInstance(); //Instanciar para comenzar a hacer querys
        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcvProductos.setLayoutManager(llm);
        //InicializarProductos();
        InicializarAdaptador();
        return v;
    }

    private void InicializarAdaptador() {
        mAdapter= new AdaptadorMuestraProducto(Consulta(),getContext());
        mAdapter.notifyDataSetChanged();
        rcvProductos.setAdapter(mAdapter);
    }
    private FirestoreRecyclerOptions Consulta()
    {
        Query  query= mFirestore.collection("Practica3");
        FirestoreRecyclerOptions<MuestraProducto> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<MuestraProducto>()
                .setQuery(query,MuestraProducto.class).build();
        return firestoreRecyclerOptions;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening(); //Para refrescar el rcv cada que se selecciona el fragment
    }
    /* Antes de implementar bases de datos remota
    private void InicializarProductos(){
        productos=new ArrayList<>();
        productos.add(new MuestraProducto("Estrena",R.drawable.zapatos,"Justo"));
        productos.add(new MuestraProducto("Dotty",R.drawable.dotty,"El nene"));
        productos.add(new MuestraProducto("Perry",R.drawable.perrito,"el neshos"));

    }*/
}
