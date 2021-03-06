package com.patrick.android.hotmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private int position;

    private  String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_container, new DetailFragment())
                    .commit();
            Intent intent = getIntent();
            position = intent.getIntExtra("position", -1);


        }
    }

    public class DetailFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            ImageView imageView=(ImageView)rootView.findViewById(R.id.fragment_detail_poster);
            TextView textView_title=(TextView)rootView.findViewById(R.id.fragment_detail_textview_title);
            TextView textView_overview=(TextView)rootView.findViewById(R.id.fragment_detail_textview_overview);
            TextView  textView_rate=(TextView)rootView.findViewById(R.id.fragment_detail_textview_rate);
            TextView  textView_date=(TextView)rootView.findViewById(R.id.fragment_detail_textview_date);
            textView_title.setText(ContentFragment.getList().get(position).getTitle());
            textView_overview.setText(ContentFragment.getList().get(position).getOverview());
            String date="上映日期："+ ContentFragment.getList().get(position).getRelease_date();
            textView_date.setText(date);
            String vote="评分："+ ContentFragment.getList().get(position).getVote_average()+"/10";
            textView_rate.setText(vote);
            address=ContentFragment.getList().get(position).getPoster_Path();

            Picasso.with(getActivity()).load("http://image.tmdb.org/t/p/w780/"+address).into(imageView);
            return rootView;
        }

//                    imageView


        }
        @Override
        public void onStart() {
            super.onStart();

    }
}