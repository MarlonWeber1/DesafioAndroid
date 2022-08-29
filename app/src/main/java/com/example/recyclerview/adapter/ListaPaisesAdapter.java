package com.example.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.data.CountryCovidData;

import java.util.List;

public class ListaPaisesAdapter extends RecyclerView.Adapter<ListaPaisesAdapter.ViewHolder>{

    private OnItemClickListener onItemClickListener;
    private final List<CountryCovidData> paises;
    private final Context context;

    public ListaPaisesAdapter(Context context, List<CountryCovidData> paises){
        this.paises = paises;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pais, parent, false);
        return new ViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CountryCovidData countryCovidData = paises.get(position);
        holder.vincula(countryCovidData);
    }


    @Override
    public int getItemCount() {
        return paises.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private CountryCovidData pais;
        private final TextView item_paises;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_paises = itemView.findViewById(R.id.item_pais);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.OnItemClick(pais, getAdapterPosition());
                }
            });
            }

        public void vincula(CountryCovidData pais){
            this.pais = pais;
            preencheCampos(pais);
        }

        public void preencheCampos(CountryCovidData pais){
            item_paises.setText(pais.getCountryText());
        }
    }
}

