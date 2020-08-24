package ru.example.startandroid.develop.fitnesstracker;

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
import ru.example.startandroid.develop.fitnesstracker.data.MapDatabase;

import java.util.List;

import ru.startandroid.develop.fitnesstracker.R;

public class HistoryAdapter extends ListAdapter<Map, HistoryAdapter.RunHolder>{
        //RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private List<Map> runs;
    private MapDatabase mapDatabase;
    private OnItemListener mOnItemListener;
    private static final String LOG_TAG = "ItemAdapter";


    /*public HistoryAdapter (List<Map> runs , OnItemListener onItemListener , MapDatabase mapDatabase , Context context )
    {
        super(DIFF_CALLBACK);

        this.runs = runs;
        this.mOnItemListener = onItemListener;
        this.mapDatabase = mapDatabase;

    }*/

    public HistoryAdapter ()
    {
        super(DIFF_CALLBACK);


    }

    private static final DiffUtil.ItemCallback<Map> DIFF_CALLBACK = new DiffUtil.ItemCallback<Map>() {
        @Override
        public boolean areItemsTheSame(@NonNull Map oldItem, @NonNull Map newItem) {
            return oldItem.getId() == newItem.getId();
        }


        @Override
        public boolean areContentsTheSame(@NonNull Map oldItem, @NonNull Map newItem) {
            return oldItem.getLength().equals(newItem.getLength()) &&
                    oldItem.getSpeed().equals(newItem.getSpeed()) &&
                    oldItem.getTime() == newItem.getTime();
        }
    };

    @NonNull
    @Override
    public RunHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RunHolder holder, int position) {
        Map currentRun = getItem(position);
        holder.speed.setText(currentRun.getSpeed());
        holder.length.setText(currentRun.getLength());


    }

    @Override
    public int getItemCount() {
        return runs != null ? runs.size() : 0;
    }

    public Map getNoteAt(int position) {
        return getItem(position);
    }

    public class RunHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView speed;
        public Chronometer time;
        public EditText length;

        OnItemListener onItemListener;

        public RunHolder(View view, OnItemListener onItemListener) {


            super(view);
            speed = view.findViewById(R.id.speed_history);
            time = view.findViewById(R.id.time_history);
            length = view.findViewById(R.id.length_history);


            this.onItemListener = onItemListener;

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public interface OnItemListener{
        void  onItemClick(int i);
    }
}
