package com.example.interfazgmail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interfazgmail.Adapter.AdapterMensajes;
import com.example.interfazgmail.Model.Mensaje;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentTodosRecibidos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentTodosRecibidos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private List<Mensaje> ltMensajes= new ArrayList<Mensaje>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentTodosRecibidos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentTodosRecibidos.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentTodosRecibidos newInstance(String param1, String param2) {
        fragmentTodosRecibidos fragment = new fragmentTodosRecibidos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_todos_recibidos, container, false);

        //agregar datos al recyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.rcMensajes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        //agregar datos a la lista
        llenar_listaFiles();

        AdapterMensajes adapter = new AdapterMensajes(ltMensajes);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void llenar_listaFiles() {
        ltMensajes.add(new Mensaje(R.drawable.ingrid,"Ingrid Ortiz","Invitacion a colaborar en PI","Hola, utiliza este enlace para unirte","21 jul",true));
        ltMensajes.add(new Mensaje(R.drawable.jose,"Jose Cordero","Invitacion a colaborar en PI","Hola, utiliza este enlace para unirte","21 jul",true));
        ltMensajes.add(new Mensaje(R.drawable.josselyn,"Joselyn Vengara","Invitacion a colaborar en PI","Hola, utiliza este enlace para unirte","21 jul",false));
        ltMensajes.add(new Mensaje(R.drawable.suanny,"Suanny Tipselema","Tarea de redes","Hola, utiliza este enlace para unirte","21 jul",false));
        ltMensajes.add(new Mensaje(R.drawable.paola ,"Paola Morales","Invitacion a colaborar en PI","Hola, utiliza este enlace para unirte","21 jul",true));
        ltMensajes.add(new Mensaje(R.drawable.cristhian ,"Cristhian Briones","Trabajo grupal de modelos","El viernes en la tarde oomenzamos","21 jul",false));
    }
}