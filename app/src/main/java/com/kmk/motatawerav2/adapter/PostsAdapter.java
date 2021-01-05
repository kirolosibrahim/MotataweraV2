package com.kmk.motatawerav2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kmk.motatawerav2.R;
import com.kmk.motatawerav2.pojo.PostsModel;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private Context context;
    List<PostsModel> postslist;

    public PostsAdapter(Context context, List<PostsModel> postslist) {
        this.context = context;
        this.postslist = postslist;
    }

    @NonNull
    @Override
    public PostsAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.PostViewHolder holder, int position) {
        holder.post.setText(postslist.get(position).getBody());

        Glide.with(context).load(postslist.get(position).getMedia());


    }

    @Override
    public int getItemCount() {
        return postslist.size();
    }

    public void setList(List<PostsModel>postlist){
        this.postslist = postlist;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView namepost, timepost, post, like, comment, shere;
        ImageView imagename, imagepost;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            namepost = itemView.findViewById(R.id.name_id);
            timepost = itemView.findViewById(R.id.time_id);
            post = itemView.findViewById(R.id.post_body);
            like = itemView.findViewById(R.id.like_id_cont);
            comment = itemView.findViewById(R.id.comment_id_cont);

            imagename = itemView.findViewById(R.id.icon_id);
            imagepost = itemView.findViewById(R.id.post_image_id);


        }
    }
}
