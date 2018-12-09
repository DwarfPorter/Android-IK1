package ru.geekbrains.socialnetwork;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class SocnetAdapter extends RecyclerView.Adapter<SocnetAdapter.ViewHolder> {

    private SocialDataSource dataSource;
    private OnItemClickListener itemClickListener;

    public SocnetAdapter(SocialDataSource dataSource){
        this.dataSource = dataSource;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }

    @NonNull
    @Override
    public SocnetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        vh.setOnClickListener(itemClickListener);
        Log.d("SocnetAdapter", "onCreateViewHolder");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SocnetAdapter.ViewHolder viewHolder, int i) {
        Soc soc = dataSource.getSoc(i);
        viewHolder.setData(soc.getDescription(), soc.getPicture(), soc.getLike());
        Log.d("SocnetAdapter", "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return dataSource.length();
    }

    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView description;
        private ImageView image;
        private CheckBox like;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.imageView);
            like = itemView.findViewById(R.id.like);
        }

        public void setOnClickListener(final OnItemClickListener listener){
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Получаем позицию адаптера
                    int adapterPosition = getAdapterPosition();
                    // Проверяем ее на корректность
                    if (adapterPosition == RecyclerView.NO_POSITION) return;
                    listener.onItemClick(v, adapterPosition);
                }
            });
        }

        public void setData(String description, int picture, boolean like){
            getLike().setChecked(like);
            getImage().setImageResource(picture);
            getDescription().setText(description);
        }

        public CheckBox getLike() {
            return like;
        }
        public TextView getDescription() {
            return description;
        }
        public ImageView getImage() {
            return image;
        }
    }
}
