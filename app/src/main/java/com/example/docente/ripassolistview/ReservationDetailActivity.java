package com.example.docente.ripassolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class ReservationDetailActivity extends AppCompatActivity {

    private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_detail);

        int pos = getIntent().getIntExtra(MainActivity.RESERVATION_POSITION,0);
        Reservation reservation = Reservation.sample()[pos];

        TextView time = (TextView) findViewById(R.id.orario);
        TextView createdTime = (TextView) findViewById(R.id.created);
        TextView players = (TextView) findViewById(R.id.players);
        TextView paid = (TextView) findViewById(R.id.paid);
        ImageView type = (ImageView) findViewById(R.id.type);

        time.setText(formatter.format(reservation.getStart()));
        createdTime.setText(formatter.format(reservation.getReserved()));
        players.setText(reservation.getPlayers().toString());
        paid.setText(reservation.isPayed() ? "Si":"No");
        type.setImageResource(reservation.isSingle()? R.drawable.s : R.drawable.d);

    }
}
