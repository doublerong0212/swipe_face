package com.example.kl.home.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kl.home.Model.Attendance;
import com.example.kl.home.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Detail_AttendListAdapter extends RecyclerView.Adapter<Detail_AttendListAdapter.ViewHolder> {


    @NonNull


    public List<Attendance> AttendanceList;
//    private String rollcallId;
//    private String student_id;

    public Context context;

    private Detail_AttendListAdapter.transPageListener mTransPageListener;//adapter跳轉fragment
    private onClickMyButton onClickMyButton;

    public interface onClickMyButton{
        public void myButton(int id);
    }
    public void setOnClickMyButton(onClickMyButton onClickMyButton) {
        this.onClickMyButton = onClickMyButton;
    }


    public Detail_AttendListAdapter(Context context, List<Attendance> AttendanceList) {

        this.AttendanceList = AttendanceList;
        this.context = context;

    }


    @Override

    public Detail_AttendListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_detail_attendlist_item, parent, false);
        return new Detail_AttendListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Detail_AttendListAdapter.ViewHolder holder, int position) {

        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        sdFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        Date attendanceDate = AttendanceList.get(position).getAttendance_time();

//        rollcallId = AttendanceList.get(position).getRollcallId();
//        student_id = AttendanceList.get(position).getStudent_id();

        holder.textViewAttendDate.setText(sdFormat.format(attendanceDate));
        holder.textViewAttendance.setText(AttendanceList.get(position).getAttendance_status());

        holder.checkAttendBtn.setTag(position);
        holder.checkAttendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///Toast.makeText(context,"Id  :  " + rollcallId + student_id, Toast.LENGTH_SHORT).show();
                int position = (int) v.getTag();
                //Toast.makeText(v.getContext(),Integer.toString(position),Toast.LENGTH_SHORT).show();
                onClickMyButton.myButton(position);
                notifyItemChanged(position);
                mTransPageListener.onTransPageClick();
            }
        });



    }

    @Override
    public int getItemCount() {
        return AttendanceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public TextView textViewAttendDate;
        public TextView textViewAttendance;
        public Button checkAttendBtn;


        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            textViewAttendDate = (TextView) mView.findViewById(R.id.textViewAttendDate);
            textViewAttendance = (TextView) mView.findViewById(R.id.textViewAttendance);
            checkAttendBtn = (Button) mView.findViewById(R.id.checkAttendBtn);

        }
    }




    public interface transPageListener {
        public void onTransPageClick();
    }//adapter跳轉fragment並攜帶需要的資料

    public void setOnTransPageClickListener(Detail_AttendListAdapter.transPageListener transPageListener) {
        this.mTransPageListener = transPageListener;
    }//adapter跳轉fragment



}
