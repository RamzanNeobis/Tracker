package ru.example.startandroid.develop.fitnesstracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import ru.example.startandroid.develop.fitnesstracker.data.Map;
import ru.startandroid.develop.fitnesstracker.R;

public class InfoFragmentAdapter extends ListAdapter<Map, InfoFragmentAdapter.MapHolder> {


    protected InfoFragmentAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Map> DIFF_CALLBACK = new DiffUtil.ItemCallback<Map>() {
        @Override
        public boolean areItemsTheSame(@NonNull Map oldItem, @NonNull Map newItem) {
            return oldItem.getId() == newItem.getId();
        }


        @Override
        public boolean areContentsTheSame(@NonNull Map oldItem, @NonNull Map newItem) {
            return oldItem.getSpeed().equals(newItem.getSpeed()) &&
                    oldItem.getLength().equals(newItem.getLength()) &&
                    oldItem.getTime() == newItem.getTime();
        }
    };

    @NonNull
    @Override
    public MapHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MapHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapHolder holder, int position) {
        Map currentMap = getItem(position);
        holder.speed.setText(currentMap.getSpeed());
        holder.length.setText(currentMap.getLength());
        //holder.time.

    }


    class MapHolder extends RecyclerView.ViewHolder {


        public TextView speed;
        public Chronometer time;
        public EditText length;

        public MapHolder(@NonNull View itemView) {
            super(itemView);

            speed = itemView.findViewById(R.id.speed_history);
            time = itemView.findViewById(R.id.time_history);
            length = itemView.findViewById(R.id.length_history);
        }
    }

}
