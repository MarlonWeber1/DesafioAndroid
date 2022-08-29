package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle infos = getArguments();
        CountryCovidData dadosCovidPaises = (CountryCovidData) infos.getSerializable("12345");
        binding.secondNomepaisesFragment.setText(dadosCovidPaises.getCountryText());
        binding.fragmentUltimAtualizacaoInfo.setText(dadosCovidPaises.getLastUptade());
        binding.fragmentCasosativosInfo.setText(dadosCovidPaises.getActiveCasesText());
        binding.fragmentNovosCasosInfo.setText(dadosCovidPaises.getNewCasesText());
        binding.fragmentNovasMortesInfo.setText(dadosCovidPaises.getNewDeathsText());
        binding.fragmentTotalDeCasosInfo.setText(dadosCovidPaises.getTotalCasesText());
        binding.fragmentTotalDeMortesInfo.setText(dadosCovidPaises.getTotalDeathsText());
        binding.fragmentTotalDeRecuperadosInfo.setText(dadosCovidPaises.getTotalRecoveredText());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}