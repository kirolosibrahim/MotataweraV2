package com.kmk.motatawerav2.fragment;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kmk.motatawerav2.R;
import com.kmk.motatawerav2.pojo.UsersModel;


public class ProfileFragment extends Fragment {


    FirebaseFirestore db = FirebaseFirestore.getInstance();
     String user_id,Username,UserImage;
    RecyclerView recyclerView;
    ImageView im_userimage;
    TextView username;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
//
//        recyclerView = view.findViewById(R.id.UserPosts_recyclerview);
//        im_userimage = view.findViewById(R.id.UserImage);
//        username = view.findViewById(R.id.Username);
//

//
//        UsersModel usersModel = new UsersModel();
//        user_id = usersModel.getId();
//        getUserData();

//        username.setText(Username);


        return view;
    }
//
//    private void getUserData() {
//
//        db.collection("Users")
//                .document(user_id)
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        DocumentSnapshot document = task.getResult();
//                        if (document != null) {
//                            Username = (String) document.get("name");
//                           UserImage = (String) document.get("picture");
//
//
//                        } else {
//                            Toast.makeText(getActivity(), "Get Data Faild", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(getActivity(), "Get Data Faild2", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//    }
}