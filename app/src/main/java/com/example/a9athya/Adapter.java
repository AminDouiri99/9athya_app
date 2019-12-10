package com.example.a9athya;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter <Adapter.kathyaViwHolder>{
    private Context mContext;
    private Cursor mCursor;
    public Adapter(Context context, Cursor cursor){
        mContext=context;
        mCursor=cursor;
    }

    public class kathyaViwHolder extends RecyclerView.ViewHolder{
        public TextView nameText;
        public TextView countText;
        public kathyaViwHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.textview_name_item);
            countText = itemView.findViewById(R.id.textview_amount_item);

        }
    }

    @NonNull
    @Override
    public kathyaViwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view =inflater.inflate(R.layout.kathya_item,parent,false);
        return new kathyaViwHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull kathyaViwHolder holder, int position) {
        if(!mCursor.moveToPosition(position)){
            return;
        }
        String name =mCursor.getString(mCursor.getColumnIndex(kathyaContract.kathyaEntry.COL_NAME));
        int amount=mCursor.getInt(mCursor.getColumnIndex(kathyaContract.kathyaEntry.COL_AMOUNT));
        long id=mCursor.getLong(mCursor.getColumnIndex(kathyaContract.kathyaEntry._ID));
        holder.nameText.setText(name);
        holder.countText.setText(String.valueOf(amount));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
    public void swapCursor(Cursor newCursor){
        if(mCursor !=null){
            mCursor.close();
        }
        mCursor=newCursor;
        if(newCursor !=null){
            notifyDataSetChanged();
        }
    }
}
