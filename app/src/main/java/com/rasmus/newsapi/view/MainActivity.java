package com.rasmus.newsapi.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.rasmus.newsapi.R;
import com.rasmus.newsapi.Utils.UtilsLoading;
import com.rasmus.newsapi.adapter.ListRecyclerAdapter;
import com.rasmus.newsapi.model.Article;
import com.rasmus.newsapi.presenter.MainActivityPresenter;
import com.rasmus.newsapi.presenter.MainActivityPresenterImpl;
import com.rasmus.newsapi.presenter.MainActivityScene;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,MainActivityScene {

    private MainActivityPresenter mainActivityPresenter;
    private ListRecyclerAdapter listRecyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @BindView(R.id.main_recycleview)
    public RecyclerView recyclerView;

    @BindView(R.id.empty_view)
    public TextView tvEmpty;

    private UtilsLoading utilsLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        utilsLoading = new UtilsLoading(this,"Loading...");
        mainActivityPresenter = new MainActivityPresenterImpl(this);
        fetchdata("General");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void fetchdata(String temp){
        utilsLoading.show();
        mainActivityPresenter.getListfromApi(temp);
        getSupportActionBar().setTitle(temp);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.business) {
            fetchdata("Business");
        } else if (id == R.id.entertainment) {
            fetchdata("Entertainment");
        } else if (id == R.id.general) {
            fetchdata("General");
        } else if (id == R.id.health) {
            fetchdata("Health");
        } else if (id == R.id.science) {
            fetchdata("Science");
        } else if (id == R.id.sports) {
            fetchdata("Sports");
        } else if (id == R.id.technology) {
            fetchdata("Technology");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void responselistsuccess(List<Article> articles) {
        utilsLoading.dismiss();

        tvEmpty.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        listRecyclerAdapter = new ListRecyclerAdapter(articles,this);
        recyclerView.setAdapter(listRecyclerAdapter);
    }

    @Override
    public void responselisterror() {
        utilsLoading.dismiss();
        tvEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }
}
