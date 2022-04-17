package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.adapter.PhoneBooksAdapter;
import com.example.myapplication.model.PhoneBooks;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReadWriteFirebase extends AppCompatActivity {

    private DatabaseReference database;
    private RecyclerView recyclerViewPhoneBooks;
    private EditText textPhone, textName;
    private Button btnCreate;
    private PhoneBooksAdapter phoneBooksAdapter;
    private List<PhoneBooks> phonebookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write_firebase);

        mapping();

        createAccount();
        getListPhoneBooksRealtimeDB();

        //configurationAndShowListView();

    }

    private void mapping() {
        textName = findViewById(R.id.textName);
        textPhone = findViewById(R.id.textPhone);
        btnCreate = findViewById(R.id.btnCreate);

        recyclerViewPhoneBooks = findViewById(R.id.recyclerViewPhoneBooks);



        phonebookList = new ArrayList<>();
        phoneBooksAdapter = new PhoneBooksAdapter(phonebookList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerViewPhoneBooks.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerViewPhoneBooks.addItemDecoration(dividerItemDecoration);
        recyclerViewPhoneBooks.setAdapter(phoneBooksAdapter);
    }

    private void createAccount() {
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textPhone.length() != 0 && textName.length() != 0) {
                    database = FirebaseDatabase.getInstance().getReference("book");

                    Phonebook phonebook = new Phonebook(textName.getText().toString(), textPhone.getText().toString());
                    database.push().setValue(phonebook);

                    textName.setText("");
                    textPhone.setText("");
                } else {
                    Toast toast = Toast.makeText(ReadWriteFirebase.this, "Please Enter Name and Phone!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    private void getListPhoneBooksRealtimeDB() {
        database = FirebaseDatabase.getInstance().getReference("book");
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                phonebookList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    PhoneBooks phoneBooks = dataSnapshot.getValue(PhoneBooks.class);
                    phonebookList.add(phoneBooks);
                }
                phoneBooksAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast toast = Toast.makeText(ReadWriteFirebase.this, "Get list data faild!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public static class Phonebook {

        public String name;
        public String phone;

        // Default constructor required for calls to
        // DataSnapshot.getValue(User.class)
        public Phonebook() {
        }

        public Phonebook(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }


}