package ru.example.startandroid.develop.fitnesstracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import ru.example.startandroid.develop.fitnesstracker.data.MapDao;
import ru.example.startandroid.develop.fitnesstracker.data.MapDatabase;

import ru.startandroid.develop.fitnesstracker.R;

public class InfoFragment extends Fragment {
    private TextView chronometertime;
    private TextView editTextlength;
    private TextView textViewspeed;
    public MapDatabase mapDatabase;
    public MapDao mapDao;

    public String speed;
    public String lenght;
    public long time;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        /*view = inflater.inflate(R.layout.list_item, container, false);
        chronometertime = (TextView) view.findViewById(R.id.time_history);
        editTextlength = (TextView) view.findViewById(R.id.length_history);
        textViewspeed = (TextView)view.findViewById(R.id.speed_history);

        return view;*/
        return inflater.inflate(R.layout.fragment_info, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        InfoFragmentAdapter adapter = new InfoFragmentAdapter();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        recyclerView.setAdapter(adapter);







    }
}
