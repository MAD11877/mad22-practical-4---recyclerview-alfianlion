package sg.edu.np.mad.exercise_2;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MsgViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    TextView desc;

    public MsgViewHolder (View viewItem){
        super(viewItem);
        txt = viewItem.findViewById(R.id.name);
        desc = viewItem.findViewById(R.id.description);
    }
}
