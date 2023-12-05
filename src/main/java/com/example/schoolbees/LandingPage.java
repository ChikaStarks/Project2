package com.example.schoolbees;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.mediarouter.media.RouteListingPreference;
import androidx.room.Room;

//import android.annotation.SuppressLint;
//import android.content.ClipData;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.schoolbees.DB.AppDataBase;
import com.example.schoolbees.DB.UserDao;
//import com.example.schoolbees.databinding.ActivityLandingPageBinding;
//import com.example.schoolbees.databinding.ActivityMainBinding;

//import java.util.List;

public class LandingPage extends AppCompatActivity {

//    ActivityLandingPageBinding mActivityLandingPageBinding;
    private static final String USER_ID_KEY = "com.example.schoolbees.userIdKey";
    private static final String PREFERENCES_KEY = "com.example.schoolbees.PREFERENCES_KEY";


    private Button postButton; //button4
    private Button checkButton; //button5
    private Button manageButton; //button6
    private Button logOutButton; //logout button

    private Button logOutYes; //yes button

    private Button logOutNo; //no button

    private UserDao mUserDao;

    private int mUserId = -1;

    private SharedPreferences mPreferences = null;
    private User mUser;
    private TextView mAdmin;
    private Button mAlert;

    private Button SignOutButton;

    private Button mAdminThings;

    private Menu mMenu;

    //private RouteListingPreference.Item userMenuLogout;

 //   @SuppressLint("MissingInflatedId")
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);



        getDatabase();
        checkForUser();
        addUserToPreference(mUserId);
        loginUser(mUserId);

//        mActivityLandingPageBinding = ActivityLandingPageBinding.inflate(getLayoutInflater());
//        setContentView(mActivityLandingPageBinding.getRoot());


        //removing for now
        //mAdmin = findViewById(R.id.textView_Admin);
        //mDeleteUser = findViewById(R.id.DeleteUser);



        //Implement later for other buttons
//        button2 = findViewById(R.id.button2);
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openCreateAccount();
//            }
//        });


        //Admin button visibility
        mAdmin = findViewById(R.id.textView_admin);

        if(mUser != null && mUser.getUserName().equals("admin2")) {
            mAdmin.setVisibility(View.VISIBLE);
        }else{
            mAdmin.setVisibility(View.GONE);
        }

        mAlert = findViewById(R.id.adminAlertButton);

        if(mUser != null && mUser.getUserName().equals("admin2")) {
            mAlert.setVisibility(View.VISIBLE);
        }else{
            mAlert.setVisibility(View.GONE);
        }

        mAdminThings = findViewById(R.id.AdminThingsButton);

        if(mUser != null && mUser.getUserName().equals("admin2")) {
            mAdminThings.setVisibility(View.VISIBLE);
        }else{
            mAdminThings.setVisibility(View.GONE);
        }

        //Sign out option until I fix the menu...
        SignOutButton = findViewById(R.id.SignOutOption);

        SignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.userMenuLogout) {
            logoutUser();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

//      switch (item.getItemId()) {
//            case R.id.userMenuLogout:  >>gave me an error "userMenuLogout"
//                logoutUser();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);



    private void loginUser (int userId){
        mUser = mUserDao.getUserByUserId(userId);
        addUserToPreference(userId);
        invalidateOptionsMenu();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(mUser != null){
            MenuItem item = menu.findItem(R.id.userMenuLogout);
            item.setTitle(mUser.getUserName());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    private void addUserToPreference(int userId){
        if (mPreferences == null){
            getPrefs();
        }
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(USER_ID_KEY, userId);
        editor.apply();
    }

    private void getDatabase() {
        mUserDao = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build().getUserDao();
    }


    private void checkForUser() {
        mUserId = getIntent().getIntExtra(USER_ID_KEY, -1);
        if (mUserId != -1) {
            return;
        }

        if(mPreferences == null){
            getPrefs();
        }

        //SharedPreferences preferences = this.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
        mUserId = mPreferences.getInt(USER_ID_KEY, -1);

        if (mUserId != -1) {
            return;
        }

       // openLandingPage();
        Intent intent = LoginActivity.intentFactory(this);
        startActivity(intent);

    }


    private void getPrefs() {
        mPreferences = this.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
    }



//    private void logoutUser(){
//        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
//        alertBuilder.setMessage("Logout?");
//        alertBuilder.setPositiveButton("Yes",
//                (dialog, which) -> {
//                    clearUserFromIntent();
//                    clearUserFromPref();
//                    mUserId = -1;
//                    checkForUser();
//                });
//        alertBuilder.setNegativeButton("No",
//                (dialog, which) -> {
//
//                });
//        alertBuilder.create().show();
//    }

    private void logoutUser() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        alertBuilder.setMessage(R.string.log_out);

        alertBuilder.setPositiveButton(getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clearUserFromIntent();
                        clearUserFromPref();
                        mUserId = -1;
                        checkForUser();
                    }
                });
        alertBuilder.setNegativeButton(getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        alertBuilder.create().show();
    }


    public void openMainActivity() {
        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void openCreateAccount() {
        Intent intent2 = new Intent(this, CreateAccount.class);
        startActivity(intent2);
    }

    private void clearUserFromIntent(){
        getIntent().putExtra(USER_ID_KEY, -1);
    }

    private void clearUserFromPref(){
        addUserToPreference(-1);
       Toast.makeText(this, "User cleared", Toast.LENGTH_SHORT).show();
    }


    private LoginActivity getValuesFromDisplay() {
        LoginActivity log = new LoginActivity();
        return log;
    }

    public static Intent intentFactory(Context context, int userId) {
        Intent intent = new Intent(context, LandingPage.class);
        intent.putExtra(USER_ID_KEY, userId);

        return intent;
    }

    public void openLandingPage() {
        Intent intent = new Intent(this, LandingPage.class);
        startActivity(intent);
    }

    //implement later
    //delete normal user option
//    mDeleteuser.setOnClickListener(new.View.OnClickListener(){
//
//        @Override
//        public void onClick(View v){
//            AlertDialog.Builder mAlertBuilder = new AlertDialog.Builder(LandingPage.this);
//            final AlertDialog mAlertDialog = mAlertBuilder.create();
//            mAlertBuilder.setMessage("Are you sure to delete your user?");
//
//            mAlertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    if(mUser.getIsAdmin().equals("true")){
//                        Toast.makeText(LandingPage.this, "An admin account cannot be deleted.", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(LandingPage.this, "The account has been deleted.", Toast.LENGTH_SHORT).show();
//                        Intent intent = LoginActivity.intentFactory(getApplicationContext());
//                    }
//                }
//            })
//        }
//    }

}