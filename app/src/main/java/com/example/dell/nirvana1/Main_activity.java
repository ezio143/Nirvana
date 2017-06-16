package com.example.dell.nirvana1;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    private RecyclerView horizontal_recycler_view;
    private ArrayList<Buzz> horizontalList;
    private HorizontalAdapter horizontalAdapter;
    public static Uri currentStudentUri;
    public Intent intent;

    public Uri getCurrentStudentUri() {
        return currentStudentUri;
    }

    public void setCurrentStudentUri(Uri currentStudentUri) {
        this.currentStudentUri = currentStudentUri;
    }

    public Main_activity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        horizontal_recycler_view= (RecyclerView) findViewById(R.id.horizontal_recycler_view);
        setTitle(R.string.nirvana);
         if (savedInstanceState == null){
             intent = getIntent();
             if(intent.getData() != null) {
                 currentStudentUri = intent.getData();
                 Toast.makeText(this,new PrefManager(this).getUsername()+" Logged IN",Toast.LENGTH_SHORT).show();
             }
         }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        intent = getIntent();
        if(intent.getData() != null)
            currentStudentUri = intent.getData();

        horizontalList=new ArrayList<Buzz>();
        horizontalList.add(new Buzz("College Buzz",R.drawable.collbuzz));
        horizontalList.add(new Buzz("Your Class",R.drawable.classroom));
        horizontalList.add(new  Buzz("Festivals",R.drawable.fests));
        horizontalList.add(new Buzz("Exam's",R.drawable.exams));
       horizontalList.add(new Buzz("Notes",R.drawable.notes));
        horizontalList.add(new Buzz("Departments",R.drawable.depts));
        horizontalList.add(new Buzz("Sports",R.drawable.sports));
        horizontalList.add(new Buzz("Placements",R.drawable.placements));
        horizontalList.add(new Buzz("Discussions",R.drawable.discussions));
        horizontalList.add(new Buzz("Alumni",R.drawable.alumni));

        horizontalAdapter=new HorizontalAdapter(horizontalList);

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(Main_activity.this, LinearLayoutManager.HORIZONTAL, false);

        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);

        horizontal_recycler_view.setAdapter(horizontalAdapter);
    }


    @Override
    protected void onStart() {
        super.onStart();


    }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

        private List<Buzz> horizontalList;



        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtView;
            public ImageView imgview;
            public MyViewHolder(View view) {
                super(view);
                txtView = (TextView) view.findViewById(R.id.txtView);
                imgview = (ImageView) view.findViewById(R.id.itemImage);
            }
        }


        public HorizontalAdapter(List<Buzz> horizontalList) {
            this.horizontalList = horizontalList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horizon_homeview, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            final Buzz buzz = horizontalList.get(position);
            holder.txtView.setText(buzz.getHeadtext());
            holder.imgview.setImageResource(buzz.getImageid());

            holder.txtView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toast.makeText(Main_activity.this,holder.txtView.getText().toString(),Toast.LENGTH_SHORT).show();
                    switch(holder.txtView.getText().toString()){
                        case "College Buzz":
                            startActivity(new Intent(Main_activity.this,NotificationsActivity.class)); break;
                        case "Alumni":
                            startActivity(new Intent(Main_activity.this,NotificationsActivity.class));
                            break;
                        case "Your Class":
                            startActivity(new Intent(Main_activity.this,NotificationsActivity.class));
                            break;
                        case "Festivals":
                            startActivity(new Intent(Main_activity.this,NotificationsActivity.class));
                            break;
                        case "Exam's":
                            Toast.makeText(Main_activity.this,holder.txtView.getText().toString(),Toast.LENGTH_SHORT).show();
                            break;
                        case "Notes":
                            startActivity(new Intent(Main_activity.this,AcademicsActivity.class));
                            break;
                        case "Departments":
                            startActivity(new Intent(Main_activity.this,DepartmentActivity.class));
                            break;
                        case "Sports":
                            startActivity(new Intent(Main_activity.this,NotificationsActivity.class));
                            break;
                        case "Placements":
                            startActivity(new Intent(Main_activity.this,NotificationsActivity.class));
                            break;
                        case "Discussions":
                            startActivity(new Intent(Main_activity.this,DiscussActivity.class));
                            break;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id){

            case R.id.nav_home:
                break;
            case R.id.nav_academics:
                startActivity(new Intent(Main_activity.this,AcademicsActivity.class));
                break;
            case R.id.nav_Profile:
                    Intent i = new Intent(Main_activity.this, Profile_Activity.class);
                    i.setData(currentStudentUri);
                    startActivity(i);
                break;
            case R.id.nav_discuss:
                startActivity(new Intent(Main_activity.this,DiscussActivity.class));

                break;
            case R.id.nav_department:
                startActivity(new Intent(Main_activity.this,DepartmentActivity.class));
                break;
            case R.id.nav_activities:
                startActivity(new Intent(Main_activity.this,NotificationsActivity.class));
                break;
            case R.id.nav_Settings:
                Intent settings = new Intent(Main_activity.this,AdminActivity.class);
                startActivity(settings);
                break;
            case R.id.nav_about:
                break;
            case R.id.nav_signout:
                signout();
                break;

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void signout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm Signout?");
        builder.setPositiveButton(R.string.signout, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                clearLoginDetails();
                Intent intent = new Intent(Main_activity.this,Login_activity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void clearLoginDetails() {
        new PrefManager(this).clearLoginDetails();
    }




}
