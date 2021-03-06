package edu.application.yancychan.checkin.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.beans.Student;

/**
 * Created by yancychan on 17-3-28.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private Context mContent;

    private List<Student> mStudentList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        CircleImageView circleImageView;
        TextView textView;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            circleImageView = (CircleImageView) view.findViewById(R.id.student_sex);
            textView = (TextView) view.findViewById(R.id.student_id);
        }
    }

    public StudentAdapter(List<Student> studentList){
        mStudentList = studentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContent == null){
            mContent = parent.getContext();
        }
        final View view = LayoutInflater.from(mContent).inflate(R.layout.student_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {
        Student student = mStudentList.get(position);
        holder.textView.setText(new StringBuilder().append(student.getStudentId()));
        Glide.with(mContent).load(student.getGender()).into(holder.circleImageView);
        if (!student.isPresent()){
            holder.cardView.setCardBackgroundColor(Color.rgb(0xFF,0xA0,0x7A));
        }
    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }
}
