package com.example.docente.ripassolistview;

import android.content.Context;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    public static final String RESERVATION_POSITION = "RESERVATION_POSITION";

    private class ReservationAdapter extends ArrayAdapter<Reservation> {

        private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        private Reservation[] reservations;
        public ReservationAdapter(Context context, Reservation[] reservations) {
            super(context, R.layout.reservation_list_item, reservations);
            this.reservations = reservations;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View itemView =
                    inflater.inflate(R.layout.reservation_list_item,null, true);
            TextView playerNames = (TextView) itemView.findViewById(R.id.reservationPlayers);
            TextView reservationTime = (TextView) itemView.findViewById(R.id.reservationTime);
            ImageView image = (ImageView) itemView.findViewById(R.id.reservationIcon);
            Reservation reservation = reservations[position];
            playerNames.setText(reservation.getPlayers().toString());
            reservationTime.setText(formatter.format(reservation.getStart()));
            int imageResource = reservation.isSingle() ? R.drawable.s : R.drawable.d;
            image.setImageResource(imageResource);
            return itemView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.reservationList);
        list.setAdapter(new ReservationAdapter(this,Reservation.sample()));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Intent toDetail = new Intent(MainActivity.this, ReservationDetailActivity.class);
                toDetail.putExtra(RESERVATION_POSITION, pos);
                startActivity(toDetail);
            }
        });
    }
}
