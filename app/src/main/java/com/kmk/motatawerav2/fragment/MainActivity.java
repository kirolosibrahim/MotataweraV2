package com.kmk.motatawerav2.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.kmk.motatawerav2.R;
import com.kmk.motatawerav2.fragment.PostFragment;
import com.kmk.motatawerav2.fragment.ProfileFragment;
import com.kmk.motatawerav2.pojo.UsersModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
  public String user_id;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         user_id = getIntent().getStringExtra("id");

        //FindView
        TextView title = findViewById(R.id.titlefragment);
        BottomNavigationView navView = findViewById(R.id.nav_BottomNavigationView);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //Default Fragment
        navView.setSelectedItemId(R.id.nav_post);
        //Default title
        title.setText(R.string.Postfragment);
        getResult(user_id);
        navView.setOnNavigationItemSelectedListener(v -> {


            switch (v.getItemId()) {


                case R.id.nav_post:
                    navController.navigate(R.id.post_fragment);
                    title.setText(R.string.Postfragment);
                    return true;

                case R.id.nav_chat:
                    navController.navigate(R.id.chat_fragment);
                    title.setText(R.string.Chatfragment);
                    return true;
                case R.id.nav_notification:
                    navController.navigate(R.id.notification_fragment);
                    title.setText(R.string.Notificationfragment);
                    return true;

                case R.id.nav_profile:
                    navController.navigate(R.id.profile_fragment);
                    title.setText(R.string.Profilefragment);
                    return true;

                case R.id.nav_setting:
                    navController.navigate(R.id.setting_fragment);
                    title.setText(R.string.Settingfragment);
                    return true;

            }
            return false;

        });

    }



  public void getResult(String id) {



        db.collection("Users")
                .document(id)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document != null) {
                            String name = (String) document.get("name");
                            String picture = (String) document.get("picture");
                            String gender = (String) document.get("gender");
                            String password = (String) document.get("password");
                            String Specialty = (String) document.get("Specialty");
                            String Level = (String) document.get("Level");



                            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();


                            Bundle bundle = new Bundle();

                            bundle.putString("User_name",name);
                            bundle.putString("User_picture",picture);
                            bundle.putString("User_gender",gender);
                            bundle.putString("User_password",password);
                            bundle.putString("User_Specialty",Specialty);
                            bundle.putString("User_Level",Level);


                            // set PostFragment Arguments
                            PostFragment postFragment = new PostFragment();
                            postFragment.setArguments(bundle);





                        } else {
                            Toast.makeText(this, "Get Data Faild", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Get Data Faild2", Toast.LENGTH_SHORT).show();
                    }
                });


    }
}