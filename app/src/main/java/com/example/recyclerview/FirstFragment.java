package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adapter.ListaPaisesAdapter;
import com.example.recyclerview.adapter.OnItemClickListener;
import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.data.GetCovidDataListFromJson;
import com.example.recyclerview.databinding.FragmentFirstBinding;

import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ListaPaisesAdapter adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<CountryCovidData> dadosCovidPaises = new GetCovidDataListFromJson().execute(getContext());

        RecyclerView listaCovidPaises = view.findViewById(R.id.lista_covid_paises_recyclerview);
        //adapter
        adapter = new ListaPaisesAdapter(getContext(), dadosCovidPaises);
        listaCovidPaises.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(CountryCovidData data, int posicao) {
                Fragment fragment = new SecondFragment();
                Bundle infos = new Bundle();
                CountryCovidData countryCovidData = dadosCovidPaises.get(posicao);
                infos.putSerializable("12345", countryCovidData);
                fragment.setArguments(infos);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, infos);
            }
        });
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}