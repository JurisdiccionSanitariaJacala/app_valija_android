package mx.gob.jurisjacala.reportesvalijassh;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import mx.gob.jurisjacala.reportesvalijassh.databinding.FragmentSecondBinding;
import mx.gob.jurisjacala.reportesvalijassh.ThirdFragment;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Fragment thirdFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        thirdFragment = new ThirdFragment();
        return binding.getRoot();
    } 

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    NavHostFragment.findNavController(thirdFragment).navigate(R.id.action_SecondFragment_to_ThirdFragment);
                } catch(Exception e) {
                    Log.e("SecondFragment","ERROR: "+e.getMessage());
                    e.printStackTrace();
                }
            }
        });

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}