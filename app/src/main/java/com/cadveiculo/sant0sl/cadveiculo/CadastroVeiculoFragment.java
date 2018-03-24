package com.cadveiculo.sant0sl.cadveiculo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cadveiculo.sant0sl.cadveiculo.Classes.Veiculo;
import com.cadveiculo.sant0sl.cadveiculo.Dao.VeiculoDao;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CadastroVeiculoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CadastroVeiculoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroVeiculoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Veiculo veiculo;

    public CadastroVeiculoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroVeiculoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroVeiculoFragment newInstance(String param1, String param2) {
        CadastroVeiculoFragment fragment = new CadastroVeiculoFragment();
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
        View view = inflater.inflate(R.layout.fragment_cadastro_veiculo, container, false);

        Button salvar = (Button)view.findViewById(R.id.btnSalvar);
        final EditText txtPlaca = (EditText)view.findViewById(R.id.txtPlaca);
        final EditText txtAno = (EditText)view.findViewById(R.id.txtAno);

        if(veiculo!=null){
            txtPlaca.setText(veiculo.getPlaca());
            txtAno.setText(veiculo.getAno().toString());
        }else{
            txtAno.setText("");
            txtPlaca.setText("");
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(veiculo==null){
                    veiculo = new Veiculo();

                    veiculo.setPlaca(txtPlaca.getText().toString());
                    veiculo.setAno(Integer.parseInt(txtAno.getText().toString()));
                }else{
                    veiculo.setPlaca(txtPlaca.getText().toString());
                    veiculo.setAno(Integer.parseInt(txtAno.getText().toString()));
                }

                new VeiculoDao().Salvar(veiculo);
                veiculo = null;

                Toast.makeText(getContext(), "Veículo Salvo com Sucesso!", Toast.LENGTH_LONG).show();
                txtAno.setText("");
                txtPlaca.setText("");
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
