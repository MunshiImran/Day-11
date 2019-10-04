package com.example.contactapps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private List<Contact> contacts;
    private Context context;

    public ContactAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_layout,parent,false);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        final Contact contact = contacts.get(position);

        holder.nameTV.setText(contact.getName());
        holder.photoIV.setImageResource(contact.getPhoto());
        holder.phoneIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contact.getPhone().toString().trim();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+contact.getPhone()));
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ContactDetailsActivity.class);
                intent.putExtra("Name",contact.getName());
                intent.putExtra("Phone",contact.getPhone());
                intent.putExtra("Photo",String.valueOf(contact.getPhoto()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView photoIV, phoneIV;
        private TextView nameTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            phoneIV = itemView.findViewById(R.id.phoneIV);
            photoIV = itemView.findViewById(R.id.photoIV);
            nameTV = itemView.findViewById(R.id.nameTV);
        }
    }
}
