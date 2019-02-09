package beangate.datta.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fram,new FragmentHome()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment=null;
            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    fragment=new FragmentHome();
                    break;
                case R.id.nav_favorite:
                    fragment=new FragmentFavorite();
                    break;
                case R.id.nav_search:
                    fragment=new FragmentSearch();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fram,fragment).commit();
            return true;
        }
    };
}
