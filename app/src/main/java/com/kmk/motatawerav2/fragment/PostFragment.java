package com.kmk.motatawerav2.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kmk.motatawerav2.R;
import com.kmk.motatawerav2.adapter.PostsAdapter;
import com.kmk.motatawerav2.pojo.PostsModel;
import com.kmk.motatawerav2.pojo.UsersModel;

import java.util.ArrayList;
import java.util.List;


public class PostFragment extends Fragment {
    RecyclerView recyclerView;
    List<PostsModel> postslist = new ArrayList<PostsModel>();
    PostsAdapter padapter;

    private long lastPressedTime;
    private static final int PERIOD = 2000;



    FirebaseFirestore firebaseFirestore;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);


        String id = this.getActivity().getSharedPreferences("login", Context.MODE_PRIVATE).getString("id",null);


        recyclerView = view.findViewById(R.id.post_recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        padapter = new PostsAdapter(getActivity(), postslist);

        recyclerView.setAdapter(padapter);
        //getData();
        return view;

    }


    private void SetData(PostsModel postsModel) {

        DocumentReference documentReference = firebaseFirestore.collection("Posts").document();
        postsModel.setId(documentReference.getId());
        documentReference.set(postsModel).addOnCompleteListener(task -> {
            Toast.makeText(getActivity(), "Posted Successfully", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(e -> {
            Toast.makeText(getActivity(), "Posted Failed", Toast.LENGTH_SHORT).show();
        });


    }


//
//
//    private void getData() {
//        firebaseFirestore.collection("post")
//                .addSnapshotListener((value, error) -> {
//                    if (error == null) {
//                        if (value == null) {
//                            Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
//                        } else {
//                            for (DocumentChange documentChange : value.getDocumentChanges()) {
//                                Toast.makeText(getActivity(), "datafound", Toast.LENGTH_SHORT).show();
//                                PostsModel postsModel = documentChange.getDocument().toObject(PostsModel.class);
//                                postslist.add(postsModel);
//                                padapter.notifyDataSetChanged();
//                            }
//
//                        }
//                    }
//                });
    //   }







}