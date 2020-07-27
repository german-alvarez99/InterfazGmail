package com.example.interfazgmail.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interfazgmail.Model.Mensaje;
import com.example.interfazgmail.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterMensajes extends RecyclerView.Adapter<AdapterMensajes.ViewHolderMensaje> {

    List<Mensaje> ltmensajes = new ArrayList<Mensaje>();

    public AdapterMensajes(List<Mensaje> ltmensajes) {
        this.ltmensajes = ltmensajes;
    }

    @NonNull
    @Override
    public ViewHolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mensaje, null, false);
        return new ViewHolderMensaje(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMensaje holder, int position) {
        holder.nombre.setText(ltmensajes.get(position).getMensaje());
        holder.asunto.setText(ltmensajes.get(position).getAunto());
        holder.cuerpo.setText(ltmensajes.get(position).getCuerpo());
        holder.fecha.setText(ltmensajes.get(position).getFecha());
        holder.imagenPerfil.setImageResource(ltmensajes.get(position).getUser());
        Boolean favorito=ltmensajes.get(position).getFavorito();
        if(favorito)
            holder.imagenfavorites.setImageResource(R.drawable.favorite);
        else
            holder.imagenfavorites.setImageResource(R.drawable.star);
    }

    @Override
    public int getItemCount() {
        return ltmensajes.size();
    }

    public class ViewHolderMensaje extends RecyclerView.ViewHolder {
        CircleImageView imagenPerfil;
        ImageView imagenfavorites;
        TextView nombre, asunto, cuerpo, fecha;

        public ViewHolderMensaje(@NonNull View itemView) {
            super(itemView);
            imagenPerfil=itemView.findViewById(R.id.imgFoto);
            nombre=itemView.findViewById(R.id.txtUsuario);
            asunto=itemView.findViewById(R.id.txtAsunto);
            cuerpo=itemView.findViewById(R.id.txtCuerpo);
            fecha=itemView.findViewById(R.id.txtFecha);
            imagenfavorites=itemView.findViewById(R.id.imgfavorite);
        }
    }
}
