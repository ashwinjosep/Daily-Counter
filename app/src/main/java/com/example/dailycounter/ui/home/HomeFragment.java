package com.example.dailycounter.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dailycounter.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final TextView incomingCountTextView = root.findViewById(R.id.incoming_count_text_view);
        homeViewModel.getIncomingCount().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                incomingCountTextView.setText(s);
            }
        });

        final TextView outgoingCountTextView = root.findViewById(R.id.outgoing_count_text_view);
        homeViewModel.getOutgoingCount().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                outgoingCountTextView.setText(s);
            }
        });

        //click events for incoming count
        //plus button click event
        Button incoming_plus_button = root.findViewById(R.id.button_add_incoming);
        incoming_plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //plus button clicked
                Log.d("plus button incoming", "clicked");
                homeViewModel.addIncomingCount();
                buttonVibrate();
            }
        });
        incoming_plus_button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                for (int i=0;i<5;i++)
                {
                    homeViewModel.addIncomingCount();
                }
                buttonVibrate();
                return true;
            }
        });

        //minus button click event
        Button incoming_minus_button = root.findViewById(R.id.button_subtract_incoming);
        incoming_minus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //minus button clicked
                Log.d("minus button incoming", "clicked");
                homeViewModel.subtractIncomingCount();
                buttonVibrate();
            }
        });
        incoming_minus_button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                for (int i=0;i<5;i++)
                {
                    homeViewModel.subtractIncomingCount();
                }
                buttonVibrate();
                return true;
            }
        });

        //click events for outgoing count
        //plus button click event
        Button outgoing_plus_button = root.findViewById(R.id.button_add_outgoing);
        outgoing_plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //plus button clicked
                Log.d("plus button outgoing", "clicked");
                homeViewModel.addOutgoingCount();
                buttonVibrate();
            }
        });
        outgoing_plus_button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                for (int i=0;i<5;i++)
                {
                    homeViewModel.addOutgoingCount();
                }
                buttonVibrate();
                return true;
            }
        });

        //minus button click event
        Button outgoing_minus_button = root.findViewById(R.id.button_subtract_outgoing);
        outgoing_minus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //minus button clicked
                Log.d("minus button outgoing", "clicked");
                homeViewModel.subtractOutgoingCount();
                buttonVibrate();
            }
        });
        outgoing_minus_button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                for (int i=0;i<5;i++)
                {
                    homeViewModel.subtractOutgoingCount();
                }
                buttonVibrate();
                return true;
            }
        });


        return root;
    }

    //function for haptic feedback
    private void buttonVibrate()
    {
        VibrationEffect effect = VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE);
        Vibrator vibrator = (Vibrator) this.getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(effect);
    }
}