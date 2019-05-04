package com.example.kl.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kl.home.Adapter.Detail_LeaveListAdapter;
import com.example.kl.home.Adapter.LeaveListAdapter;
import com.example.kl.home.Adapter.LeaveListClassDetailAdapter;
import com.example.kl.home.Model.Leave;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

//底部假單 View

public class Fragment_LeaveListN_View extends Fragment {

    private static final String TAG = "LeaveListN_View";
    String class_id, teacher_email;
    String check_way, list_way;

    private RecyclerView mMainList;
    private FirebaseFirestore mFirestore;
    private LeaveListAdapter leaveListAdapter;
    private LeaveListClassDetailAdapter leaveListClassDetailAdapter;
    private List<Leave> leaveList;
    private Bundle arg;

    OnFragmentSelectedListener mCallback;//Fragment傳值

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        arg = getArguments();//fragment傳值
        teacher_email = arg.getString("PassTeacher_email");
        check_way = arg.getString("PassCheck_Way");
        list_way = arg.getString("PassList_Way");
        Log.d(TAG,"TEST LOG RUN Times_v " + arg.toString());


        Log.d(TAG, "TEST LV  " + teacher_email);
        Log.d(TAG, "TEST LV   " + class_id);
        Log.d(TAG, "TEST LV   " + check_way);
        Log.d(TAG, "TEST LV   " + list_way);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leavelist_recyclerview, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        leaveList = new ArrayList<>();
        leaveListAdapter = new LeaveListAdapter(view.getContext(),leaveList);
        leaveListClassDetailAdapter = new LeaveListClassDetailAdapter(view.getContext(),leaveList);

        mFirestore = FirebaseFirestore.getInstance();

        mMainList = view.findViewById(R.id.leave_list);
        mMainList.setHasFixedSize(true);
        mMainList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMainList.setAdapter(leaveListAdapter);

            mMainList.setAdapter(leaveListAdapter);
            setTeacherLeave(list_way);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnFragmentSelectedListener) context;//fragment傳值
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Mush implement OnFragmentSelectedListener ");
        }
    }

    public void setTeacherLeave(String listWay){
        leaveList.clear();
        mFirestore.collection("Leave").whereEqualTo("leave_check",listWay)
                .whereEqualTo("teacher_email",teacher_email).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot documentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {

                if(e != null){
                    Log.d(TAG,"error00" + e.getMessage());
                }

                for(DocumentChange doc : documentSnapshots.getDocumentChanges()){

                    if(doc.getType() == DocumentChange.Type.ADDED){
                        Log.d(TAG,"here" );

                        String leaveRecordId = doc.getDocument().getId();

                        Leave leave = doc.getDocument().toObject(Leave.class).withId(leaveRecordId);
                        leave.setCheckWay("底部欄");
                        Log.d(TAG,"Check Teamil : " + leave.getTeacher_email());
                        leaveList.add(leave);

                        leaveListAdapter.notifyDataSetChanged();
                    }

                }
                if(leaveList.isEmpty()){
                    Log.d(TAG,"here0" );
                    leaveListAdapter.notifyDataSetChanged();
                }
            }
        });


    }



}
