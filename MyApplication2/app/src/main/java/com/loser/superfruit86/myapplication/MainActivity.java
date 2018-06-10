package com.loser.superfruit86.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    // --------------------- STATS OF USER --------------
    public int highScore = 0;
    public int daysNotDead = 0;
    public int daysNotDeadCycle = 0; //every 3rd iteration adds +1 to daysNotDead
    public BigDecimal netWorth = new BigDecimal("1000.00"); //starting netWorth
    public BigDecimal totalEarned = new BigDecimal("0.00");
    public int happinessLevel = 38;
    public int healthRange = 38;
    public int happinessDrain = 3;
    public int healthDrain = 3;
    public int drainVariable = 1;
    public int respawnToken = 0;
    public int hasPartner = 0; //trigger to check if user is 0 - single 1 - partner
    public int educationDrain = 1;
    public int luxuryDrain = 1;
    public int loveDrain = 1;
    public int deathCounter = 0;
    public int popupCounter1 = 1;
    public int popupCounter2 = 1;
    public int popupCounter3 = 1;
    public int cheatingCounter = 0;
    public int firstTimePlaying = 0;
    public int succMessage = 1;
    public int luxuMessage = 1;
    public int loveMessage = 1;
    public int careerMessage = 1;
    public int educMessage = 1;
    public int dayMessage = 1;
    public int hasWon = 0;
    public int taxSeason = 1;
    public int taxCollector = 0;
    public BigDecimal taxCollection = new BigDecimal("0.00");
    public int difficulty = 0;
    public int securityCounter = 0;


    // ---------------------- ATTRIBUTES OF USER -----------
    public int isHomeless = 0; //trigger to check if user is homeless 0 - not homeless 1 - homeless
    public int isSick = 0;
    //1 - Rhinovirus(cold)
    //2 - Influenza(flu)
    //3 - Strep Throat(streptococcus)
    //4 - Heart Disease
    //5 - Type 2 Diabetes
    //6 - Cancer
    public int sicknessCounter = 0;
    public int luxuryCounter = 0;
    public int luxuryCounter2 = 0; //luxury every 7 days
    public int loveCounter = 0;    //love every 14 days
    public int loveCounter2 = 0;
    public int gymCounter = 0;
    public int pShakeCounter = 0;
    public int showCounter = 0;
    public int supplementCounter = 0;
    public int medicationCounter = 0;
    public int therapyCounter = 0;
    public int barCounter = 0;
    public int tradeCounter = 0;
    public int firstTimeHealthIndicator = 0;
    public int firstTimeHappinessIndicator = 0;
    public int loveUnlock1 = 0;
    public int loveUnlock2 = 0;
    public int loveUnlock3 = 0;
    public int loveUnlock4 = 0;
    public int loveUnlock5 = 0;
    public int loveUnlock6 = 0;

    public int isEducated = 0; //trigger to check if user has 0 - no schooling 1 - took 1 class 2 - bachelors 3 - masters 4 - doctors
    public int collegeClassesTaken = 0;//5 classes needed to go to grad school
    public int gradClassesTaken = 0;//10 classes needed to get masters
    public int postGradClassesTaken = 0;//15 classes needed to get masters

    public int isEmployed = 1; //trigger to check if user is employed 0 - not employed 1 - employed
    public int jobCounter = 0;
    public int jobCycle = 0;
    public int payRate = 155;//1x

    public int job2Trigger = 0;
    public int jobCycle2 = 0;
    public int payRate2 = 225;//1.5x

    public int jobCycle3 = 0;
    public int payRate3 = 335;//2.2x

    public int jobCycle4 = 0;
    public int payRate4 = 510;//3.3x
    public int job4Trigger = 0;

    public int jobCycle5 = 0;
    public int payRate5 = 1100;//7x

    public int jobCycle6 = 0;
    public int payRate6 = 3100;//20x
    public int job6Trigger = 0;

    public int jobCycle7 = 0;
    public int payRate7 = 6400;//40x

    public int jobCycle8 = 0;
    public int payRate8 = 13000;//85x
    public int job8Trigger = 0;

    public int jobCycle9 = 0;
    public int payRate9 = 29000;//190x
    public int jobCEOTrigger = 0;
    public int jobCEOReference = 0;

    public int lotteryCycle = 0;
    public int isMarried = 0;
    public int isEngaged = 0;
    public int hasSecurity = 0;
    public int partnerKidnap = 0;

    // --------------- STOCK DATA -------------------

    public BigDecimal valueDayAgo = new BigDecimal("0.00");
    public BigDecimal valueNow = new BigDecimal("0.00");
    public BigDecimal value29DaysAgo = new BigDecimal("0.00");
    public BigDecimal value28DaysAgo = new BigDecimal("0.00");
    public BigDecimal value27DaysAgo = new BigDecimal("0.00");
    public BigDecimal value26DaysAgo = new BigDecimal("0.00");
    public BigDecimal value25DaysAgo = new BigDecimal("0.00");
    public BigDecimal value24DaysAgo = new BigDecimal("0.00");
    public BigDecimal value23DaysAgo = new BigDecimal("0.00");
    public BigDecimal value22DaysAgo = new BigDecimal("0.00");
    public BigDecimal value21DaysAgo = new BigDecimal("0.00");
    public BigDecimal value20DaysAgo = new BigDecimal("0.00");
    public BigDecimal value19DaysAgo = new BigDecimal("0.00");
    public BigDecimal value18DaysAgo = new BigDecimal("0.00");
    public BigDecimal value17DaysAgo = new BigDecimal("0.00");
    public BigDecimal value16DaysAgo = new BigDecimal("0.00");
    public BigDecimal value15DaysAgo = new BigDecimal("0.00");
    public BigDecimal value14DaysAgo = new BigDecimal("0.00");
    public BigDecimal value13DaysAgo = new BigDecimal("0.00");
    public BigDecimal value12DaysAgo = new BigDecimal("0.00");
    public BigDecimal value11DaysAgo = new BigDecimal("0.00");
    public BigDecimal value10DaysAgo = new BigDecimal("0.00");
    public BigDecimal value9DaysAgo = new BigDecimal("0.00");
    public BigDecimal value8DaysAgo = new BigDecimal("0.00");
    public BigDecimal value7DaysAgo = new BigDecimal("0.00");
    public BigDecimal value6DaysAgo = new BigDecimal("0.00");
    public BigDecimal value5DaysAgo = new BigDecimal("0.00");
    public BigDecimal value4DaysAgo = new BigDecimal("0.00");
    public BigDecimal value3DaysAgo = new BigDecimal("0.00");
    public BigDecimal value2DaysAgo = new BigDecimal("0.00");

    public BigDecimal value30DaysAgo = new BigDecimal("0.00");
    public BigDecimal value90DaysAgo = new BigDecimal("0.00");
    public BigDecimal RM_low = new BigDecimal("26.00");
    public BigDecimal RM_high = new BigDecimal("37.00");
    public Stock RM = new Stock(RM_high, RM_low, 2, 13);

    public BigDecimal IBC_low = new BigDecimal("115.00");
    public BigDecimal IBC_high = new BigDecimal("165.00");
    public Stock IBC = new Stock(IBC_high, IBC_low, 3, 148);

    public BigDecimal FWB_low = new BigDecimal("43.00");
    public BigDecimal FWB_high = new BigDecimal("55.00");
    public Stock FWB = new Stock(FWB_high, FWB_low, 1, 11);

    public BigDecimal KC_low = new BigDecimal("40.00");
    public BigDecimal KC_high = new BigDecimal("47.00");
    public Stock KC = new Stock(KC_high, KC_low, 2, 22);

    public BigDecimal ET_low = new BigDecimal("40.00");
    public BigDecimal ET_high = new BigDecimal("60.00");
    public Stock ET = new Stock(ET_high, ET_low, 1, 39);

    public BigDecimal NSX_low = new BigDecimal("70.00");
    public BigDecimal NSX_high = new BigDecimal("95.00");
    public Stock NSX = new Stock(NSX_high, NSX_low, 4, 41);

    public BigDecimal FU_low = new BigDecimal("19.00");
    public BigDecimal FU_high = new BigDecimal("30.00");
    public Stock FU = new Stock(FU_high, FU_low, 2, 164);

    public BigDecimal AP_low = new BigDecimal("94.00");
    public BigDecimal AP_high = new BigDecimal("132.00");
    public Stock AP = new Stock(AP_high, AP_low, 3, 72);

    public BigDecimal BNN_low = new BigDecimal("60.00");
    public BigDecimal BNN_high = new BigDecimal("82.00");
    public Stock BNN = new Stock(BNN_high, BNN_low, 3, 17);

    public BigDecimal MACA_low = new BigDecimal("187000.00");
    public BigDecimal MACA_high = new BigDecimal("227000.00");
    public Stock MACA = new Stock(MACA_high, MACA_low, 2, 63);

    public BigDecimal MACB_low = new BigDecimal("125.00");
    public BigDecimal MACB_high = new BigDecimal("151.00");
    public Stock MACB = new Stock(MACB_high, MACB_low, 2, 63);

    public BigDecimal MM_low = new BigDecimal("56.00");
    public BigDecimal MM_high = new BigDecimal("75.00");
    public Stock MM = new Stock(MM_high, MM_low, 1, 94);
    /*
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    public InterstitialAd mInterstitialAd;
    public InterstitialAd mInterstitialAd2;

    //Volatility 1(low-low) 2(low) 3(low-med) 4(med)

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        //editor.clear();
        //editor.apply();

        //resetVariables();
        initializeVariables();
        initializeStockVariables();
        //respawnToken++;
        setTheme(R.style.AppTheme_NoActionBar);
        //difficulty = 0;

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6612683572827982/2642709953");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd2 = new InterstitialAd(this);
        mInterstitialAd2.setAdUnitId("ca-app-pub-6612683572827982/2642709953");
        mInterstitialAd2.loadAd(new AdRequest.Builder().build());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawerLayout.se


        byte[] emojiBytes = new byte[]{(byte) 0xE2, (byte) 0x98, (byte) 0xBA};
        final String emojiAsString = new String(emojiBytes, Charset.forName("UTF-8"));
        byte[] emojiHealth = new byte[]{(byte) 0xE2, (byte) 0x9D, (byte) 0xA4};
        final String emojiHealthString = new String(emojiHealth, Charset.forName("UTF-8"));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Respawn Tokens: " + respawnToken + "     " + emojiAsString + "Drain: " +
                        "" + happinessDrain + "      " + emojiHealthString + "Drain: " + healthDrain, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);

        ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
        if (outputStocks().equals(new BigDecimal("0.00")))
            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
        else
            ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

        ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
        updateHealthAndHappiness();

        firstTimePlaying = sharedPref.getInt("firstTimePlaying", 0);
        editor.apply();


        if (firstTimePlaying != 0 && firstTimePlaying != 1)
        {
            firstTimePlaying = 0;
        }

        if (firstTimePlaying == 1) {
            if (difficulty == 0)
            {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.main_container, new DifficultyFragment());
                fragmentTransaction.commit();

                messagePrompt("Choose a difficulty.", 1200);

                if (mInterstitialAd.isLoaded())
                    mInterstitialAd.show();
                else if (mInterstitialAd2.isLoaded())
                {
                    mInterstitialAd2.show();
                }
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                mInterstitialAd2.loadAd(new AdRequest.Builder().build());
                //mAdView = (AdView) findViewById(R.id.banner_AdView);
                //AdRequest adRequest = new AdRequest.Builder().build();
                //mAdView.loadAd(adRequest);
            }
            else {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.main_container, new PhysicalFragment());
                fragmentTransaction.commit();
                messagePrompt("<Welcome back.>\n\n You have been alive for " + daysNotDead + " days.", 1200);
            }
        } else {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_container, new DifficultyFragment());
            fragmentTransaction.commit();
            messagePrompt("Choose a difficulty.\n\n(To close a message, you can click out of it, or click the Back button.)", 1200);
        }
        if (getSupportFragmentManager().executePendingTransactions()) {
            editor.putInt("firstTimePlaying", 1);
            editor.apply();
            getSupportActionBar().setTitle("Status");
        }

        //navigationView.setItemTextAppearance(5);

        //resetVariables();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int id = item.getItemId();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                navigationView = (NavigationView) findViewById(R.id.nav_view);


                if (id == R.id.nav_physical) {
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_container, new PhysicalFragment());
                    fragmentTransaction.commit();
                    if (getSupportFragmentManager().executePendingTransactions()) {
                        if (daysNotDead < 35)
                            ((TextView) findViewById(R.id.buttonAid)).setText("Seek professional help. (LOCKED)");
                        if (daysNotDead < 80)
                            ((TextView) findViewById(R.id.buttonEnhance)).setText("Enhance and modify your body. (LOCKED)");

                    }
                    //getSupportActionBar().setTitle("Physical");
                    item.setChecked(true);


                } else if (id == R.id.nav_mental) {
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_container, new MentalFragment());
                    fragmentTransaction.commit();
                    if (getSupportFragmentManager().executePendingTransactions()) {
                        if (daysNotDead < 50)
                            ((TextView) findViewById(R.id.buttonHelp)).setText("Seek professional help. (LOCKED)");
                        if (daysNotDead < 125)
                            ((TextView) findViewById(R.id.buttonDrugs)).setText("Take some narcotics. (LOCKED)");
                    }
                    //getSupportActionBar().setTitle("Mental");
                    item.setChecked(true);

                } else if (id == R.id.nav_success) {
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_container, new SuccessFragment());
                    fragmentTransaction.commit();

                    if (succMessage == 1)
                    {
                        succMessage = 0;
                        messagePrompt("TIP(!) - The Success category is largely responsible for increasing how much money you have, or Net Worth.", 1000);
                    }
                    //getSupportActionBar().setTitle("Success");
                    item.setChecked(true);


                } else if (id == R.id.nav_luxury) {
                    if (daysNotDead < 30) {
                        messagePrompt("You must survive 30 days before accessing Luxury. ", 500);
                    } else {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new LuxuryFragment());
                        fragmentTransaction.commit();
                        if (getSupportFragmentManager().executePendingTransactions()) {
                            if (luxuMessage == 1)
                            {
                                luxuMessage = 0;
                                messagePrompt("TIP(!) - The Luxury category is where you go to enjoy yourself, and propel the plot of the " +
                                        "game forward.\n\n<The last event wins the game.>", 1200);
                            }
                            if (luxuryCounter < 1)
                                ((TextView) findViewById(R.id.buttonTravelWorld)).setText("(LOCKED)");
                            if (luxuryCounter < 2)
                                ((TextView) findViewById(R.id.buttonCar)).setText("(LOCKED)");
                            if (luxuryCounter < 3)
                                ((TextView) findViewById(R.id.buttonSpace)).setText("(LOCKED)");
                            if (luxuryCounter < 4)
                                ((TextView) findViewById(R.id.buttonMansion)).setText("(LOCKED)");
                            if (luxuryCounter < 5)
                                ((TextView) findViewById(R.id.buttonYacht)).setText("(LOCKED)");
                            if (luxuryCounter < 6)
                                ((TextView) findViewById(R.id.buttonToppleGovernment)).setText("(LOCKED)");
                        }
                        //getSupportActionBar().setTitle("Luxury");
                        item.setChecked(true);

                    }

                } else if (id == R.id.nav_love) {
                    if (hasPartner == 1) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new LoveFragment());
                        fragmentTransaction.commit();
                        if (getSupportFragmentManager().executePendingTransactions()) {
                            if (canIAffordIt("2000.00") == false && loveUnlock1 == 0) {
                                loveUnlock1 = 1;
                                ((TextView) findViewById(R.id.buttonCampingDate)).setText("(LOCKED)");
                            }
                            if (canIAffordIt("10000.00") == false && loveUnlock2 == 0) {
                                loveUnlock2 = 1;
                                ((TextView) findViewById(R.id.buttonRoadTripDate)).setText("(LOCKED)");
                            }
                            if (canIAffordIt("40000.00") == false && loveUnlock3 == 0) {
                                loveUnlock3 = 1;
                                ((TextView) findViewById(R.id.buttonWineCruise)).setText("(LOCKED)");
                            }
                            if (canIAffordIt("120000.00") == false && loveUnlock4 == 0) {
                                loveUnlock4 = 1;
                                ((TextView) findViewById(R.id.buttonPrivateIsland)).setText("(LOCKED)");
                            }
                            if (canIAffordIt("250000.00") == false && loveUnlock5 == 0) {
                                loveUnlock5 = 1;
                                ((TextView) findViewById(R.id.buttonMarriage)).setText("(LOCKED)");
                            }
                            if (canIAffordIt("600000.00") == false && loveUnlock6 == 0) {
                                loveUnlock6 = 1;
                                ((TextView) findViewById(R.id.buttonFamily)).setText("(LOCKED)");
                            }
                        }
                        //getSupportActionBar().setTitle("Love");
                        item.setChecked(true);
                    } else {
                        messagePrompt("You are single.", 500);
                    }
                } else if (id == R.id.nav_about_us) {
                    if (hasWon == 0)
                    {
                        messagePrompt("You need to win the game before viewing this.", 500);
                    }
                    else {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new IdentityFragment());
                        fragmentTransaction.commit();
                        //getSupportActionBar().setTitle("Love");
                        item.setChecked(true);
                    }
                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    void initializeVariables() {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putInt("highScore", 50);

        firstTimePlaying = sharedPref.getInt("firstTimePlaying", 0);

        //Where it all begins

        daysNotDead = sharedPref.getInt("daysNotDead", 0);

        highScore = sharedPref.getInt("highScore", 0);
        daysNotDeadCycle = sharedPref.getInt("daysNotDeadCycle", 0);


        int nW = sharedPref.getInt("netWorth", -1);
        if (nW > -1)
        {
            netWorth = new BigDecimal(nW);
            netWorth = netWorth.add(new BigDecimal("0.01"));
            netWorth = netWorth.subtract(new BigDecimal("0.01"));
            editor.putInt("netWorth", -1);
            editor.putString("netWorthS", netWorth.toString());
        }
        else
        {
            String i = sharedPref.getString("netWorthS", "1000.00");
            netWorth = new BigDecimal(i);
        }

        String c = sharedPref.getString("taxCollectionS", "0.00");
        taxCollection = new BigDecimal(c);

        happinessLevel = sharedPref.getInt("happinessLevel", 38);
        healthRange = sharedPref.getInt("healthRange", 38);
        happinessDrain = sharedPref.getInt("happinessDrain", 3);
        healthDrain = sharedPref.getInt("healthDrain", 3);
        drainVariable = sharedPref.getInt("drainVariable", 1);
        respawnToken = sharedPref.getInt("respawnToken", 0);
        hasPartner = sharedPref.getInt("hasPartner", 0);
        educationDrain = sharedPref.getInt("educationDrain", 1);
        luxuryDrain = sharedPref.getInt("luxuryDrain", 1);
        loveDrain = sharedPref.getInt("loveDrain", 1);
        deathCounter = sharedPref.getInt("deathCounter", 0);
        popupCounter1 = sharedPref.getInt("popupCounter1", 1);
        popupCounter2 = sharedPref.getInt("popupCounter2", 1);
        popupCounter3 = sharedPref.getInt("popupCounter3", 1);
        cheatingCounter = sharedPref.getInt("cheatingCounter", 0);
        succMessage = sharedPref.getInt("succMessage", 1);
        luxuMessage = sharedPref.getInt("luxuMessage", 1);
        loveMessage = sharedPref.getInt("loveMessage", 1);
        careerMessage = sharedPref.getInt("careerMessage", 1);
        educMessage = sharedPref.getInt("educMessage", 1);
        dayMessage = sharedPref.getInt("dayMessage", 1);

        isHomeless = sharedPref.getInt("isHomeless", 0);
        isSick = sharedPref.getInt("isSick", 0);
        sicknessCounter = sharedPref.getInt("sicknessCounter", 0);
        luxuryCounter = sharedPref.getInt("luxuryCounter", 0);
        luxuryCounter2 = sharedPref.getInt("luxuryCounter2", 0);
        loveCounter = sharedPref.getInt("loveCounter", 0);
        loveCounter2 = sharedPref.getInt("loveCounter2", 0);
        gymCounter = sharedPref.getInt("gymCounter", 0);
        pShakeCounter = sharedPref.getInt("pShakeCounter", 0);
        showCounter = sharedPref.getInt("showCounter", 0);
        supplementCounter = sharedPref.getInt("supplementCounter", 0);
        medicationCounter = sharedPref.getInt("medicationCounter", 0);
        therapyCounter = sharedPref.getInt("therapyCounter", 0);
        barCounter = sharedPref.getInt("barCounter", 0);
        tradeCounter = sharedPref.getInt("tradeCounter", 0);

        firstTimeHealthIndicator = sharedPref.getInt("firstTimeHealthIndicator", 0);
        firstTimeHappinessIndicator = sharedPref.getInt("firstTimeHappinessIndicator", 0);
        isEducated = sharedPref.getInt("isEducated", 0);
        collegeClassesTaken = sharedPref.getInt("collegeClassesTaken", 0);
        gradClassesTaken = sharedPref.getInt("gradClassesTaken", 0);
        postGradClassesTaken = sharedPref.getInt("postGradClassesTaken", 0);
        isEmployed = sharedPref.getInt("isEmployed", 1);
        jobCounter = sharedPref.getInt("jobCounter", 0);
        jobCycle = sharedPref.getInt("jobCycle", 0);
        payRate = sharedPref.getInt("payRate", 155);
        job2Trigger = sharedPref.getInt("job2Trigger", 0);
        jobCycle2 = sharedPref.getInt("jobCycle2", 0);
        payRate2 = sharedPref.getInt("payRate2", 200);
        jobCycle3 = sharedPref.getInt("jobCycle3", 0);
        payRate3 = sharedPref.getInt("payRate3", 295);
        jobCycle4 = sharedPref.getInt("jobCycle4", 0);
        payRate4 = sharedPref.getInt("payRate4", 510);
        job4Trigger = sharedPref.getInt("job4Trigger", 0);
        jobCycle5 = sharedPref.getInt("jobCycle5", 0);
        payRate5 = sharedPref.getInt("payRate5", 1100);
        jobCycle6 = sharedPref.getInt("jobCycle6", 0);
        payRate6 = sharedPref.getInt("payRate6", 3100);
        job6Trigger = sharedPref.getInt("job6Trigger", 0);
        jobCycle7 = sharedPref.getInt("jobCycle7", 0);
        payRate7 = sharedPref.getInt("payRate7", 7500);
        jobCycle8 = sharedPref.getInt("jobCycle8", 0);
        payRate8 = sharedPref.getInt("payRate8", 13000);
        job8Trigger = sharedPref.getInt("job8Trigger", 0);
        jobCycle9 = sharedPref.getInt("jobCycle9", 0);
        payRate9 = sharedPref.getInt("payRate9", 29000);
        jobCEOTrigger = sharedPref.getInt("jobCEOTrigger", 0);
        jobCEOReference = sharedPref.getInt("jobCEOReference", 0);
        lotteryCycle = sharedPref.getInt("lotteryCycle", 0);
        isMarried = sharedPref.getInt("isMarried", 0);
        isEngaged = sharedPref.getInt("isEngaged", 0);
        loveUnlock1 = sharedPref.getInt("loveUnlock1", 0);
        loveUnlock2 = sharedPref.getInt("loveUnlock2", 0);
        loveUnlock3 = sharedPref.getInt("loveUnlock3", 0);
        loveUnlock4 = sharedPref.getInt("loveUnlock4", 0);
        loveUnlock5 = sharedPref.getInt("loveUnlock5", 0);
        loveUnlock6 = sharedPref.getInt("loveUnlock6", 0);
        hasSecurity = sharedPref.getInt("hasSecurity", 0);
        partnerKidnap = sharedPref.getInt("partnerKidnap", 0);
        cheatingCounter = sharedPref.getInt("cheatingCounter", 0);
        hasWon = sharedPref.getInt("hasWon", 0);
        difficulty = sharedPref.getInt("difficulty", 0);
        taxSeason = sharedPref.getInt("taxSeason", 1);
        taxCollector = sharedPref.getInt("taxCollector", 0);

        //TEST PURPOSES:
        /*

        netWorth = new BigDecimal("10000.00");
        happinessLevel = 300;
        healthRange = 300;
        healthDrain = healthDrain + 10;
        happinessDrain = happinessDrain + 10;
        daysNotDead = 74;
        */

        editor.apply();
    }

    void initializeStockVariables() {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        ET.value = new BigDecimal(sharedPref.getInt("ET value", ET.value.intValue()));
        NSX.value = new BigDecimal(sharedPref.getInt("NSX value", NSX.value.intValue()));
        FU.value = new BigDecimal(sharedPref.getInt("FU value", FU.value.intValue()));
        AP.value = new BigDecimal(sharedPref.getInt("AP value", AP.value.intValue()));
        BNN.value = new BigDecimal(sharedPref.getInt("BNN value", BNN.value.intValue()));
        MACA.value = new BigDecimal(sharedPref.getInt("MACA value", MACA.value.intValue()));
        MACB.value = new BigDecimal(sharedPref.getInt("MACB value", MACB.value.intValue()));
        MM.value = new BigDecimal(sharedPref.getInt("MM value", MM.value.intValue()));
        RM.value = new BigDecimal(sharedPref.getInt("RM value", RM.value.intValue()));
        IBC.value = new BigDecimal(sharedPref.getInt("IBC value", IBC.value.intValue()));
        FWB.value = new BigDecimal(sharedPref.getInt("FWB value", FWB.value.intValue()));
        ET.sharesOwned = (sharedPref.getInt("ET shares", ET.sharesOwned));
        NSX.sharesOwned = (sharedPref.getInt("NSX shares", NSX.sharesOwned));
        FU.sharesOwned = (sharedPref.getInt("FU shares", FU.sharesOwned));
        AP.sharesOwned = (sharedPref.getInt("AP shares", AP.sharesOwned));
        BNN.sharesOwned = (sharedPref.getInt("BNN shares", BNN.sharesOwned));
        MACA.sharesOwned = (sharedPref.getInt("MACA shares", MACA.sharesOwned));
        MACB.sharesOwned = (sharedPref.getInt("MACB shares", MACB.sharesOwned));
        MM.sharesOwned = (sharedPref.getInt("MM shares", MM.sharesOwned));
        RM.sharesOwned = (sharedPref.getInt("RM shares", RM.sharesOwned));
        IBC.sharesOwned = (sharedPref.getInt("IBC shares", IBC.sharesOwned));
        FWB.sharesOwned = (sharedPref.getInt("FWB shares", FWB.sharesOwned));

        ET.growth = (sharedPref.getInt("ET growth", ET.growth));
        NSX.growth = (sharedPref.getInt("NSX growth", NSX.growth));
        FU.growth = (sharedPref.getInt("FU growth", FU.growth));
        AP.growth = (sharedPref.getInt("AP growth", AP.growth));
        BNN.growth = (sharedPref.getInt("BNN growth", BNN.growth));
        MACA.growth = (sharedPref.getInt("MACA growth", MACA.growth));
        MACB.growth = (sharedPref.getInt("MACB growth", MACB.growth));
        MM.growth = (sharedPref.getInt("MM growth", MM.growth));
        RM.growth = (sharedPref.getInt("RM growth", RM.growth));
        IBC.growth = (sharedPref.getInt("IBC growth", IBC.growth));
        FWB.growth = (sharedPref.getInt("FWB growth", FWB.growth));

        ET.movingPeriod = (sharedPref.getInt("ET movingPeriod", ET.movingPeriod));
        NSX.movingPeriod = (sharedPref.getInt("NSX movingPeriod", NSX.movingPeriod));
        FU.movingPeriod = (sharedPref.getInt("FU movingPeriod", FU.movingPeriod));
        AP.movingPeriod = (sharedPref.getInt("AP movingPeriod", AP.movingPeriod));
        BNN.movingPeriod = (sharedPref.getInt("BNN movingPeriod", BNN.movingPeriod));
        MACA.movingPeriod = (sharedPref.getInt("MACA movingPeriod", MACA.movingPeriod));
        MACB.movingPeriod = (sharedPref.getInt("MACB movingPeriod", MACB.movingPeriod));
        MM.movingPeriod = (sharedPref.getInt("MM movingPeriod", MM.movingPeriod));
        RM.movingPeriod = (sharedPref.getInt("RM movingPeriod", RM.movingPeriod));
        IBC.movingPeriod = (sharedPref.getInt("IBC movingPeriod", IBC.movingPeriod));
        FWB.movingPeriod = (sharedPref.getInt("FWB movingPeriod", FWB.movingPeriod));
        
        editor.apply();
    }

    void resetVariables() {
        initializeVariables();
        int hW = hasWon;
        int hS = highScore;
        if (hS < daysNotDead)
            hS = daysNotDead;
        int fTP = firstTimePlaying;
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putInt("firstTimePlaying", fTP);
        editor.putInt("highScore", hS);
        highScore = hS;
        firstTimePlaying = fTP;
        hasWon = hW;
        editor.apply();
    }

    void updateVariables() {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("hasWon", hasWon);
        editor.putInt("difficulty", difficulty);
        editor.putInt("taxSeason", taxSeason);
        editor.putInt("taxCollector", taxCollector);
        editor.putInt("highScore", highScore);
        editor.putInt("daysNotDead", daysNotDead);
        editor.putInt("daysNotDeadCycle", daysNotDeadCycle);
        editor.putInt("happinessLevel", happinessLevel);

        String i = netWorth.toString();
        editor.putString("netWorthS", i);

        String c = taxCollection.toString();
        editor.putString("taxCollectionS", c);

        editor.putInt("healthRange", healthRange);
        editor.putInt("happinessDrain", happinessDrain);
        editor.putInt("healthDrain", healthDrain);
        editor.putInt("drainVariable", drainVariable);
        editor.putInt("respawnToken", respawnToken);
        editor.putInt("hasPartner", hasPartner);
        editor.putInt("educationDrain", educationDrain);
        editor.putInt("luxuryDrain", luxuryDrain);
        editor.putInt("loveDrain", loveDrain);
        editor.putInt("deathCounter", deathCounter);
        editor.putInt("popupCounter1", popupCounter1);
        editor.putInt("popupCounter2", popupCounter2);
        editor.putInt("popupCounter3", popupCounter3);
        editor.putInt("isHomeless", isHomeless);
        editor.putInt("isSick", isSick);
        editor.putInt("sicknessCounter", sicknessCounter);
        editor.putInt("luxuryCounter", luxuryCounter);
        editor.putInt("luxuryCounter2", luxuryCounter2);
        editor.putInt("loveCounter", loveCounter);
        editor.putInt("loveCounter2", loveCounter2);
        editor.putInt("gymCounter", gymCounter);
        editor.putInt("pShakeCounter", pShakeCounter);
        editor.putInt("showCounter", showCounter);
        editor.putInt("supplementCounter", supplementCounter);
        editor.putInt("medicationCounter", medicationCounter);
        editor.putInt("therapyCounter", therapyCounter);
        editor.putInt("barCounter", barCounter);
        editor.putInt("tradeCounter", tradeCounter);
        editor.putInt("firstTimeHealthIndicator", firstTimeHealthIndicator);
        editor.putInt("firstTimeHappinessIndicator", firstTimeHappinessIndicator);
        editor.putInt("isEducated", isEducated);
        editor.putInt("collegeClassesTaken", collegeClassesTaken);
        editor.putInt("gradClassesTaken", gradClassesTaken);
        editor.putInt("postGradClassesTaken", postGradClassesTaken);
        editor.putInt("isEmployed", isEmployed);
        editor.putInt("jobCounter", jobCounter);
        editor.putInt("jobCycle", jobCycle);
        editor.putInt("payRate", payRate);
        editor.putInt("job2Trigger", job2Trigger);
        editor.putInt("jobCycle2", jobCycle2);
        editor.putInt("payRate2", payRate2);
        editor.putInt("jobCycle3", jobCycle3);
        editor.putInt("payRate3", payRate3);
        editor.putInt("jobCycle4", jobCycle4);
        editor.putInt("payRate4", payRate4);
        editor.putInt("job4Trigger", job4Trigger);
        editor.putInt("jobCycle5", jobCycle5);
        editor.putInt("payRate5", payRate5);
        editor.putInt("jobCycle6", jobCycle6);
        editor.putInt("payRate6", payRate6);
        editor.putInt("job6Trigger", job6Trigger);
        editor.putInt("jobCycle7", jobCycle7);
        editor.putInt("payRate7", payRate7);
        editor.putInt("jobCycle8", jobCycle8);
        editor.putInt("payRate8", payRate8);
        editor.putInt("job8Trigger", job8Trigger);
        editor.putInt("jobCycle9", jobCycle9);
        editor.putInt("payRate9", payRate9);
        editor.putInt("jobCEOTrigger", jobCEOTrigger);
        editor.putInt("jobCEOReference", jobCEOReference);
        editor.putInt("lotteryCycle", lotteryCycle);
        editor.putInt("isMarried", isMarried);
        editor.putInt("isEngaged", isEngaged);
        editor.putInt("loveUnlock1", loveUnlock1);
        editor.putInt("loveUnlock2", loveUnlock2);
        editor.putInt("loveUnlock3", loveUnlock3);
        editor.putInt("loveUnlock4", loveUnlock4);
        editor.putInt("loveUnlock5", loveUnlock5);
        editor.putInt("loveUnlock6", loveUnlock6);
        editor.putInt("hasSecurity", hasSecurity);
        editor.putInt("partnerKidnap", partnerKidnap);
        editor.putInt("succMessage", succMessage);
        editor.putInt("dayMessage", dayMessage);
        editor.putInt("loveMessage", loveMessage);
        editor.putInt("luxuMessage", luxuMessage);
        editor.putInt("careerMessage", careerMessage);
        editor.putInt("cheatingCounter", cheatingCounter);

        editor.apply();
    }

    void updateStockVariables() {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("ET shares", ET.sharesOwned);
        editor.putInt("NSX shares", NSX.sharesOwned);
        editor.putInt("FU shares", FU.sharesOwned);
        editor.putInt("AP shares", AP.sharesOwned);
        editor.putInt("BNN shares", BNN.sharesOwned);
        editor.putInt("MACA shares", MACA.sharesOwned);
        editor.putInt("MACB shares", MACB.sharesOwned);
        editor.putInt("MM shares", MM.sharesOwned);
        editor.putInt("RM shares", RM.sharesOwned);
        editor.putInt("IBC shares", IBC.sharesOwned);
        editor.putInt("FWB shares", FWB.sharesOwned);
        editor.putInt("ET value", ET.value.intValue());
        editor.putInt("NSX value", NSX.value.intValue());
        editor.putInt("FU value", FU.value.intValue());
        editor.putInt("AP value", AP.value.intValue());
        editor.putInt("BNN value", BNN.value.intValue());
        editor.putInt("MACA value", MACA.value.intValue());
        editor.putInt("MACB value", MACB.value.intValue());
        editor.putInt("MM value", MM.value.intValue());
        editor.putInt("RM value", RM.value.intValue());
        editor.putInt("IBC value", IBC.value.intValue());
        editor.putInt("FWB value", FWB.value.intValue());
        editor.putInt("ET growth", ET.growth);
        editor.putInt("NSX growth", NSX.growth);
        editor.putInt("FU growth", FU.growth);
        editor.putInt("AP growth", AP.growth);
        editor.putInt("BNN growth", BNN.growth);
        editor.putInt("MACA growth", MACA.growth);
        editor.putInt("MACB growth", MACB.growth);
        editor.putInt("MM growth", MM.growth);
        editor.putInt("RM growth", RM.growth);
        editor.putInt("IBC growth", IBC.growth);
        editor.putInt("FWB growth", FWB.growth);
        editor.putInt("ET movingPeriod", ET.movingPeriod);
        editor.putInt("NSX movingPeriod", NSX.movingPeriod);
        editor.putInt("FU movingPeriod", FU.movingPeriod);
        editor.putInt("AP movingPeriod", AP.movingPeriod);
        editor.putInt("BNN movingPeriod", BNN.movingPeriod);
        editor.putInt("MACA movingPeriod", MACA.movingPeriod);
        editor.putInt("MACB movingPeriod", MACB.movingPeriod);
        editor.putInt("MM movingPeriod", MM.movingPeriod);
        editor.putInt("RM movingPeriod", RM.movingPeriod);
        editor.putInt("IBC movingPeriod", IBC.movingPeriod);
        editor.putInt("FWB movingPeriod", FWB.movingPeriod);

        String i = netWorth.toString();
        editor.putString("netWorthS", i);

        editor.apply();
    }


    // ------------- TUTORIAL ---------------------------------------------------------------


    public void functionTut1(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tut1Fragment());
        fragmentTransaction.commit();
    }

    public void functionTut2(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tut2Fragment());
        fragmentTransaction.commit();
    }

    public void functionTut3(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tut3Fragment());
        fragmentTransaction.commit();
    }

    public void functionTut4(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tut4Fragment());
        fragmentTransaction.commit();
    }

    public void functionTut5(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tut5Fragment());
        fragmentTransaction.commit();
    }

    public void functionTut6(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tut6Fragment());
        fragmentTransaction.commit();
    }
    public void functionDrawer(View view) {
        //drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.openDrawer(Gravity.LEFT);
        //drawerButton.setVisibility(View.INVISIBLE);
    }

    //------------- PHYSICAL ---------------------------------------------------------------
    // ------------ DIFFICULTY -------------------------------------------------------------

    public void functionRealistic(View view) {
        difficulty = 1;
        if (firstTimePlaying == 0)
        {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_container, new Tut1Fragment());
            fragmentTransaction.commit();
            return;
        }
        if (firstTimePlaying == 1 && daysNotDead > 0)
            messagePrompt("<Welcome back.>\n\n You have been alive for " + daysNotDead + " days.", 1200);
        if (firstTimePlaying == 1 && daysNotDead == 0)
            messagePrompt("<Welcome.>\n\n Back to square 1.", 1200);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new PhysicalFragment());
        fragmentTransaction.commit();
        if (getSupportFragmentManager().executePendingTransactions()) {
            if (daysNotDead < 35)
                ((TextView) findViewById(R.id.buttonAid)).setText("Seek professional help. (LOCKED)");
            if (daysNotDead < 80)
                ((TextView) findViewById(R.id.buttonEnhance)).setText("Enhance and modify your body. (LOCKED)");

        }
    }
    public void functionHardAsHell(View view) {
        difficulty = 2;
        healthDrain = healthDrain + 2;
        happinessDrain = happinessDrain + 2;
        healthRange = healthRange - 13;
        happinessLevel = happinessLevel - 13;
        updateHealthAndHappiness();
        if (firstTimePlaying == 0)
        {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_container, new Tut1Fragment());
            fragmentTransaction.commit();
            return;
        }
        if (firstTimePlaying == 1 && daysNotDead > 0)
            messagePrompt("<Welcome back.>\n\n You have been alive for " + daysNotDead + " days.", 1200);
        if (firstTimePlaying == 1 && daysNotDead == 0)
            messagePrompt("<Welcome back.>\n\n You like more of a challenge, I see?", 1200);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new PhysicalFragment());
        fragmentTransaction.commit();
        if (getSupportFragmentManager().executePendingTransactions()) {
            if (daysNotDead < 35)
                ((TextView) findViewById(R.id.buttonAid)).setText("Seek professional help. (LOCKED)");
            if (daysNotDead < 80)
                ((TextView) findViewById(R.id.buttonEnhance)).setText("Enhance and modify your body. (LOCKED)");

        }
    }
    public void functionEndMySuffering(View view) {
        if (hasWon != 1)
        {
            messagePrompt("You need to win the game before unlocking this difficulty.", 700);
            return;
        }
        if (respawnToken > 0)
        {
            messagePrompt("You currently have at least 1 Respawn Token in inventory.", 700);
            return;
        }
        if (firstTimePlaying == 1 && daysNotDead > 0)
        messagePrompt("<Welcome back.>\n\n You have been alive for " + daysNotDead + " days.", 1200);
        if (firstTimePlaying == 1 && daysNotDead == 0)
            messagePrompt("<Welcome back.>\n\n You must really hate yourself.", 1200);
        difficulty = 3;
        healthDrain = healthDrain + 2;
        happinessDrain = happinessDrain + 2;
        healthRange = healthRange - 13;
        happinessLevel = happinessLevel - 13;
        updateHealthAndHappiness();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new PhysicalFragment());
        fragmentTransaction.commit();
        if (getSupportFragmentManager().executePendingTransactions()) {
            if (daysNotDead < 35)
                ((TextView) findViewById(R.id.buttonAid)).setText("Seek professional help. (LOCKED)");
            if (daysNotDead < 80)
                ((TextView) findViewById(R.id.buttonEnhance)).setText("Enhance and modify your body. (LOCKED)");

        }
    }

    public void functionHealth(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new HealthFragment());
        fragmentTransaction.commit();
    }

    public void functionPhysical(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new PhysicalFragment());
        fragmentTransaction.commit();
        if (getSupportFragmentManager().executePendingTransactions()) {
            if (daysNotDead < 35)
                ((TextView) findViewById(R.id.buttonAid)).setText("Seek professional help. (LOCKED)");
            if (daysNotDead < 80)
                ((TextView) findViewById(R.id.buttonEnhance)).setText("Enhance and modify your body. (LOCKED)");

        }
    }

    public void functionAid(View view) {

        if (daysNotDead < 35)//15
        {
            messagePrompt("You need to survive 35 days before seeking professional help.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new AidFragment());
        fragmentTransaction.commit();
    }

    public void functionEnhance(View view) {
        if (daysNotDead < 80)//50
        {
            messagePrompt(" You need to survive 80 days before experimenting on your body.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new EnhanceFragment());
        fragmentTransaction.commit();
    }

    public void functionShake(View view) {
        if (canIAffordIt("35.00")) {
            pShakeCounter++;
            int temp = pShakeCounter;
            statChanges(12, -1, "35.00");

            pShakeCounter = temp;
            if (pShakeCounter > 7 && new Random().nextDouble() < 0.50) {
                healthRange = healthRange - 5;

                amIDeadYet("Protein shake poisoning.");
                messagePrompt(" You're drinking too many shakes. You're beginning to make yourself sick.", 1500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 2;

                amIDeadYet("n/a");
                messagePrompt("Don't fool yourself, this tastes disgusting.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 2;

                amIDeadYet("n/a");
                messagePrompt("You'll be fit in no time.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                healthRange = healthRange + 2;

                amIDeadYet("n/a");
                messagePrompt("It's steak in a bottle.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 2;
                healthRange = healthRange - 2;
                amIDeadYet("n/a");
                messagePrompt("I am such a fitness junkie!", 500);

                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 2;
                amIDeadYet("n/a");
                messagePrompt("And just a little pinch of Tequila...", 500);
                return;
            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionGym(View view) {

        Random rand2 = new Random();

        /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
        int rHappiness = -6 + rand2.nextInt((8 - -6) + 1);
        if (canIAffordIt("90.00")) {
            gymCounter++;
            int temp = gymCounter;
            statChanges(19, rHappiness, "90.00");
            gymCounter = temp;

            if (hasPartner == 0) {
                if (new Random().nextDouble() < 0.005) {
                    happinessLevel = happinessLevel + 20;
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("Went too hard at the gym.");
                    messagePrompt("At the gym, you meet a cute workout junkie. <Clearly, they go here more than you do.> " +
                            "\n\nYou can now go on dates with your gym partner.", 3000);
                    return;
                }
            }
            if (gymCounter > 5 && new Random().nextDouble() < 0.50) {
                healthRange = healthRange - 7;
                amIDeadYet("Went too hard at the gym.");
                messagePrompt("You've been working out too often. You're getting tired and beginning " +
                        "to injure yourself.", 2000);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 7;
                healthRange = healthRange + 4;
                amIDeadYet("Went too hard at the gym.");
                messagePrompt("The endorphins are pumping and you feel great. Today was a " +
                        "very productive workout.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 4;
                amIDeadYet("Went too hard at the gym.");
                messagePrompt("Be physically stronger than what you mentally feel.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 5;
                amIDeadYet("Went too hard at the gym.");
                messagePrompt(" A productive day at the gym always begins with a heavily filtered selfie.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 4;

                amIDeadYet("Went too hard at the gym.");
                messagePrompt("Sweat is just your fat crying.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 2;
                healthRange = healthRange + 5;
                amIDeadYet("Went too hard at the gym.");
                messagePrompt("Never skip leg day.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 2;
                healthRange = healthRange + 3;
                amIDeadYet("Went too hard at the gym.");
                messagePrompt("Look at all the people that are in better shape than you are.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 7;
                healthRange = healthRange - 9;
                amIDeadYet("Injured at the gym.");
                messagePrompt("You were careless and dropped a weight on yourself. Be careful.", 1000);
                return;
            }

            amIDeadYet("Went too hard at the gym.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionSupplements(View view) {
        if (canIAffordIt("200.00")) {
            supplementCounter++;
            int temp = supplementCounter;
            statChanges(44, -6, "200.00");
            supplementCounter = temp;

            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.0002) {
                    happinessLevel = happinessLevel + 30;
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("n/a");
                    messagePrompt(" Even though the cashier is scanning your items, they are the one you're interested in checking out"
                            + " tonight. \n\nYou are no longer single and can now go on dates with the clerk.", 2500);
                    return;
                }
            }

            if (new Random().nextDouble() < .5 && supplementCounter > 4) {
                healthRange = healthRange - 20;
                amIDeadYet("Supplement overdose.");
                messagePrompt(" You are consuming an extraneous amount of supplements. You're making yourself sick.", 1500);

                return;
            }
            if (new Random().nextDouble() < .06) {
                happinessLevel = happinessLevel - 9;
                amIDeadYet("n/a");
                messagePrompt("You must feel great about yourself.", 500);

                return;
            }

            if (new Random().nextDouble() < .06) {
                happinessLevel = happinessLevel + 8;
                amIDeadYet("n/a");
                messagePrompt("Step 1 to becoming the bodybuilder you've always dreamed of.", 500);

                return;
            }

            if (new Random().nextDouble() < .06) {
                happinessLevel = happinessLevel + 9;
                amIDeadYet("n/a");
                messagePrompt("It's organic, so it must be healthy. ", 500);

                return;
            }

            if (new Random().nextDouble() < 0.01) {
                healthRange = healthRange - 25;
                amIDeadYet("Consumed incorrect supplements.");
                messagePrompt("Unfortunately, you bought the wrong supplements today and threw your chemistry off balance" +
                        ". \n\nYour health is worsened.", 1500);
                return;

            }

            if (new Random().nextDouble() < .15) {

                happinessLevel = happinessLevel + 8;
                netWorth = netWorth.add(new BigDecimal("30.00"));
                messagePrompt("There was a 30% OFF sale today. ", 1000);
                amIDeadYet("This is an Easter Egg.");
                return;
            }

            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionChangeLifeStyle(View view) {
        if (canIAffordIt("500.00")) {
            statChanges(85, -12, "500.00");
            if (new Random().nextDouble() < .07) {

                happinessLevel = happinessLevel + 7;
                healthRange = healthRange + 7;
                amIDeadYet("Failed convictions.");
                messagePrompt("This time, it's for real!", 500);
                return;
            }
            if (new Random().nextDouble() < .07) {

                happinessLevel = happinessLevel + 11;
                healthRange = healthRange - 5;
                amIDeadYet("Failed convictions.");
                messagePrompt("I read many internet articles. I know what I'm doing.", 500);
                return;
            }
            if (new Random().nextDouble() < .07) {

                happinessLevel = happinessLevel + 15;
                healthRange = healthRange - 15;
                amIDeadYet("Failed convictions.");
                messagePrompt("New year, new me!", 500);
                return;
            }
            if (new Random().nextDouble() < .07) {
                happinessLevel = happinessLevel + 13;
                healthRange = healthRange + 4;
                amIDeadYet("Failed convictions.");
                messagePrompt("I live in a privileged financial situation so I can afford to consume an all-organic diet!", 500);

                return;
            }
            amIDeadYet("Failed convictions.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionYoga(View view) {
        if (canIAffordIt("900.00")) {
            statChanges(132, -20, "900.00");
            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.01) {
                    happinessLevel = happinessLevel + 200;
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("Going too hard in yoga class.");
                    messagePrompt("Your attractive instructor compliments your physique and notices how much hard work" +
                            " you're putting into the class. \n\nThey insist you do some sessions together outside of the classroom... in private. " +
                            "\n\nYou can now go on dates with the Yoga assistant.", 2600);
                    return;
                }
                if (new Random().nextDouble() < 0.12) {
                    happinessLevel = happinessLevel + 15;
                    healthRange = healthRange + 10;

                    amIDeadYet("Going too hard in yoga class.");
                    messagePrompt("You've been killin' it in Yoga, lately." +
                            "\n\nNamaslaye.", 500);
                    return;
                }
                if (new Random().nextDouble() < 0.12) {
                    happinessLevel = happinessLevel + 15;
                    healthRange = healthRange - 15;
                    amIDeadYet("Going too hard in yoga class.");
                    messagePrompt("Ommmm.....", 500);

                    return;
                }
                if (new Random().nextDouble() < 0.12) {
                    happinessLevel = happinessLevel + 15;
                    healthRange = healthRange - 15;
                    amIDeadYet("Going too hard in yoga class.");
                    messagePrompt("Ummmm.....", 500);
                    return;
                }
                if (new Random().nextDouble() < 0.12) {
                    happinessLevel = happinessLevel - 5;
                    healthRange = healthRange + 25;
                    amIDeadYet("Going too hard in yoga class.");
                    messagePrompt("'Let's get Chinese food. You down-dog?", 500);
                    return;
                }
            }
            amIDeadYet("Going too hard in yoga class.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionDoctor(View view) {

        if (canIAffordIt("2000.00")) {
            statChanges(242, -30, "2000.00");


            if (isSick != 0) {
                if (isSick == 1) {

                    healthDrain = healthDrain - 3;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;

                    amIDeadYet("The common cold.");
                    messagePrompt("<The doctor has diagnosed you with the Common Cold (rhinovirus).>" +
                            " \n\nYou have taken rest and now feel better.", 2000);
                    return;
                }
                if (isSick == 2) {

                    healthDrain = healthDrain - 5;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;
                    amIDeadYet("I sh** you not, the flu.");
                    messagePrompt("<The doctor has diagnosed you with the flu (Influenza).>" +
                            " \n\nYou have taken rest and now feel better.", 2000);
                    return;
                }
                if (isSick == 3) {

                    healthDrain = healthDrain - 3;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;
                    amIDeadYet("Strep throat.");
                    messagePrompt("<The doctor has diagnosed you with strep throat (streptococcus).>" +
                            " \n\nYou have taken antibiotics and now feel better.", 2000);
                    return;
                }
            } else if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel + 15;
                healthRange = healthRange + 25;
                amIDeadYet("n/a");
                messagePrompt(" After watching so many medical drama TV shows, you should be the one handing out advice.", 500);

                return;
            }

            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel - 20;
                amIDeadYet("n/a");
                messagePrompt(" If you think about it, you are one doctor visit closer to your last.", 500);

                return;

            }

            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel + 20;
                healthRange = healthRange - 30;
                amIDeadYet("n/a");
                messagePrompt("An apple a day probably won't keep the doctor away.", 500);

                return;
            }


            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel - 25;
                healthRange = healthRange - 20;
                amIDeadYet("n/a");
                messagePrompt("'Number #0937, please.' Ooo! That's you!", 500);

                return;
            }

            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel + 25;
                healthRange = healthRange - 20;
                amIDeadYet("n/a");
                messagePrompt("Wait your turn, you peasant.", 500);

                return;
            }

            if (new Random().nextDouble() < .0003) {
                happinessLevel = happinessLevel + 50;
                amIDeadYet("n/a");
                messagePrompt("<I'm half human on my mother's side.>", 2000);

                return;
            }

            if (new Random().nextDouble() < .0003) {
               happinessLevel = happinessLevel + 50;
                amIDeadYet("n/a");
                messagePrompt("<Are you any good at setting alarm clocks?>", 2000);

                return;
            }

            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionTrainer(View view) {

        if (canIAffordIt("5000.00")) {
            statChanges(501, -50, "5000.00");

            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.01) {
                    happinessLevel = happinessLevel + 400;

                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("n/a");
                    messagePrompt("Your attractive personal trainer insists that you should try some exercise outside" +
                            " the gym together... in private. \n\n<You and I both know why you're paying them.> You can" +
                            " now go on dates with your workout assistant.", 2500);
                    return;
                }
            }
            if (new Random().nextDouble() < 0.13) {
                happinessLevel = happinessLevel - 45;
                amIDeadYet("Trained too hard.");
                messagePrompt("'Pain is just weakness leaving the body.'", 500);

                return;
            }
            if (new Random().nextDouble() < 0.13) {
                happinessLevel = happinessLevel - 35;
                healthRange = healthRange - 35;
                amIDeadYet("Trained too hard.");
                messagePrompt("'No pain, no gain. Also, my check for this session is due by Friday.'", 500);
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                happinessLevel = happinessLevel + 50;
                healthRange = healthRange + 35;
                amIDeadYet("Trained too hard.");
                messagePrompt("Your only limitation is your imagination.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                happinessLevel = happinessLevel + 35;
                healthRange = healthRange + 35;
                amIDeadYet("Trained too hard.");
                messagePrompt(" It's never too late to become what you might have looked like a decade ago.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                happinessLevel = happinessLevel - 35;
                healthRange = healthRange + 45;
                amIDeadYet("Trained too hard.");
                messagePrompt(" 80% of success is showing up. If showing up also included having the right genetic framework and financial resources.", 500);

                return;
            }
            if (new Random().nextDouble() < 0.13) {
                happinessLevel = happinessLevel - 35;
                healthRange = healthRange - 20;
                amIDeadYet("Trained too hard.");
                messagePrompt("Just because you're not sick, doesn't mean you're healthy.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                happinessLevel = happinessLevel - 45;
                healthRange = healthRange - 20;
                amIDeadYet("Trained too hard.");
                messagePrompt(" I already want to take a nap. 'We haven't even started.'", 500);
                return;
            }

            amIDeadYet("Trained too hard.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionPrivateDoctor(View view) {
        if (canIAffordIt("12000.00")) {
            statChanges(1021, -100, "12000.00");
            if (isSick != 0) {
                if (isSick == 1) {

                    healthDrain = healthDrain - 3;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;

                    amIDeadYet("The common cold.");
                    messagePrompt("<The doctor has diagnosed you with the Common Cold (rhinovirus).>" +
                            " \n\nYou have taken rest and now feel better.", 2000);
                    return;
                }
                if (isSick == 2) {

                    healthDrain = healthDrain - 5;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;
                    amIDeadYet("I sh** you not, the flu.");
                    messagePrompt("<The doctor has diagnosed you with the flu (Influenza).>" +
                            " \n\nYou have taken rest and now feel better.", 2000);
                    return;
                }
                if (isSick == 3) {

                    healthDrain = healthDrain - 3;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;
                    amIDeadYet("Strep throat.");
                    messagePrompt("<The doctor has diagnosed you with strep throat (streptococcus).>" +
                            " \n\nYou have taken antibiotics and now feel better.", 2000);
                    return;
                }
            }
            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel - 40;
                healthRange = healthRange + 185;
                amIDeadYet("Irony.");
                messagePrompt("Are those hieroglyphics supposed to be English?", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel + 80;
                healthRange = healthRange + 150;
                amIDeadYet("Irony.");
                messagePrompt("Ahh. The sweet stench of upper class medical care.", 1000);
                return;
            }
            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel - 55;
                healthRange = healthRange - 70;
                amIDeadYet("Irony.");
                messagePrompt("First they kill your ills, then they kill you with bills.", 1000);

                return;
            }
            amIDeadYet("Irony.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionInjection(View view) {

        if (canIAffordIt("30000.00")) {
            statChanges(2158, -200, "30000.00");

            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel - 250;
                healthRange = healthRange + 300;
                amIDeadYet("That was a terrible idea.");
                messagePrompt("'Trust me, I'm a medical student.'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel + 250;
                healthRange = healthRange - 300;
                amIDeadYet("That was a terrible idea.");
                messagePrompt(" Obesity is not there because it runs in the family. No one runs in the family.", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel - 150;
                healthRange = healthRange - 200;
                amIDeadYet("That was a terrible idea.");
                messagePrompt("'Eenie, meenie, miney, mo. Which organ shall I poke?'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel - 250;
                healthRange = healthRange - 300;
                amIDeadYet("That was a terrible idea.");
                messagePrompt("'Which vein was it, now?'", 1000);
                return;
            } else
                amIDeadYet("That was a terrible idea.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionSteroids(View view) {
        if (canIAffordIt("75000.00")) {
            statChanges(4511, -350, "75000.00");
            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel - 100;
                healthRange = healthRange - 300;
                amIDeadYet("n/a");
                messagePrompt("'Which vein was it, now?'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel + 100;
                healthRange = healthRange + 300;
                amIDeadYet("n/a");
                messagePrompt("'On your next physical, just hire someone else to pee in a cup for you.'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel + 170;
                healthRange = healthRange - 300;
                amIDeadYet("n/a");
                messagePrompt("'It's federally approved for cattle, you'll be fine.'", 1000);

                return;
            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionExperiment(View view) {

        if (canIAffordIt("150000.00")) {
            statChanges(7574, -500, "150000.00");

            if (new Random().nextDouble() < 0.25) {
                happinessLevel = happinessLevel - 100;
                healthRange = healthRange + 400;
                amIDeadYet("You know this one was a terrible idea.");
                messagePrompt(" 'Don't worry, my expert team of biologists has already successfully implemented this procedure on mice.'\n\n" +
                        "'And nearly a majority of them survived.'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.25) {
                happinessLevel = happinessLevel - 150;
                healthRange = healthRange - 400;
                amIDeadYet("You know this one was a terrible idea.");
                messagePrompt(" 'You've got to experiment to figure out what works, ya know.'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.25) {
                happinessLevel = happinessLevel + 100;
                healthRange = healthRange - 200;
                amIDeadYet("You know this one was a terrible idea.");
                messagePrompt(" 'We recommend saying farewell to your loved ones... just as a necessary precaution.'", 1000);
                return;
            }
            amIDeadYet("You know this one was a terrible idea.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionDNA(View view) {

        if (canIAffordIt("500000.00")) {
            statChanges(21043, -1000, "500000.00");

            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel - 700;
                healthRange = healthRange - 1900;

                amIDeadYet("It'll be fun they said. Revolutionary, they said.");
                messagePrompt("'What could possibly go wrong?'", 500);
                return;
            }
            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel - 800;
                healthRange = healthRange + 500;

                amIDeadYet("It'll be fun they said. Revolutionary, they said.");
                messagePrompt(" 'It's not an experiment if you know it's going to work.'", 500);
                return;
            }
            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel + 2000;
                healthRange = healthRange + 1000;

                amIDeadYet("It'll be fun they said. Revolutionary, they said.");
                messagePrompt(" 'This is similar to how Steve Rogers became a super hero.'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel + 2000;
                healthRange = healthRange + 1000;

                amIDeadYet("It'll be fun they said. Revolutionary, they said.");
                messagePrompt(" 'Don't worry, you're rich, so our top priority is to see this go smoothly.'", 1000);
                return;
            }
            amIDeadYet("It'll be fun they said. Revolutionary, they said.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }


    //------------------ MENTAL -------------------------------------------------------------


    public void functionTime(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new TimeFragment());
        fragmentTransaction.commit();
    }

    public void functionMental(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new MentalFragment());
        fragmentTransaction.commit();
        if (getSupportFragmentManager().executePendingTransactions()) {
            if (daysNotDead < 50)
                ((TextView) findViewById(R.id.buttonHelp)).setText("Seek professional help. (LOCKED)");
            if (daysNotDead < 125)
                ((TextView) findViewById(R.id.buttonDrugs)).setText("Take some narcotics. (LOCKED)");
        }
    }

    public void functionHelp(View view) {

        if (daysNotDead < 50)//15
        {
            messagePrompt("You need to survive 50 days before seeking professional help.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new HelpFragment());
        fragmentTransaction.commit();
    }

    public void functionDrugs(View view) {
        if (daysNotDead < 125)//50
        {
            messagePrompt("You need to survive 125 days before experimenting on your body.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new DrugsFragment());
        fragmentTransaction.commit();
    }


    public void functionShow(View view) {

        Random rand1 = new Random();

        /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
        //int rHealth = -1 + rand1.nextInt((0 - -1) + 1);

        if (canIAffordIt("20.00")) {
            showCounter++;
            int temp = showCounter;
            statChanges(-1, 9, "20.00");
            showCounter = temp;
            if (showCounter > 6 && new Random().nextDouble() < 0.5) {
                //happinessLevel = happinessLevel + 1;
                healthRange = healthRange - 2;
                amIDeadYet("Couldn't get ass off the couch.");
                messagePrompt(" You've been binge-watching a lot of shows lately. Your health is starting to take a toll.", 2000);

                return;

            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 3;
                healthRange = healthRange - 1;
                amIDeadYet("Couldn't get ass off the couch.");
                messagePrompt(" There's absolutely nothing better that you could be doing with your time.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 3;
                amIDeadYet("Couldn't get ass off the couch.");
                messagePrompt("Another happy ending. Why can't the protagonist sit in misery?", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel - 2;
                healthRange = healthRange - 1;
                amIDeadYet("Couldn't get ass off the couch.");
                messagePrompt("Well, there goes another weekend. ", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                healthRange = healthRange - 2;
                amIDeadYet("Couldn't get ass off the couch.");
                messagePrompt("Sleep? Hah! Haven't heard that one in a while.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 2;
                amIDeadYet("Couldn't get ass off the couch.");
                messagePrompt("Bummer, your laptop ran out of battery.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel - 2;
                amIDeadYet("Couldn't get ass off the couch.");
                messagePrompt("You should have pirated this garbage.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 3;
                amIDeadYet("Couldn't get ass off the couch.");
                messagePrompt("So many different movies. The same actor. Do they even age?", 1000);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 5;
                healthRange = healthRange - 1;
                amIDeadYet("Couldn't get ass off the couch.");
                messagePrompt("One more episode...", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel - 2;
                healthRange = healthRange - 1;
                amIDeadYet("Couldn't get ass off the couch.");
                messagePrompt("It must get better next season.", 500);
                return;
            }

            amIDeadYet("Couldn't get ass off the couch.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionBook(View view) {
        if (canIAffordIt("60.00")) {
            statChanges(-1, 16, "60.00");
            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.0001) {
                    happinessLevel = happinessLevel + 30;
                    hasPartner = 1;
                    amIDeadYet("n/a");
                    messagePrompt("Although you're having a hard time finding a book, the librarian is interested in checking YOU out, instead"
                            + " *wink wink*. \n\nYou are no longer single and can now go on dates with the curator.", 2500);
                    loveDrain = 0;
                    return;
                }
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 4;
                healthRange = healthRange + 3;
                amIDeadYet("Couldn't handle the knowledge.");
                messagePrompt("Knowledge!", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel - 4;
                amIDeadYet("n/a");
                messagePrompt(" A Hollywood executive is already trying to make a movie adaptation.", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 3;
                healthRange = healthRange - 1;
                amIDeadYet("n/a");
                messagePrompt(" Do you think he'll still be alive to publish the next book in the series?", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel - 3;
                amIDeadYet("n/a");
                messagePrompt("Your grandma would really enjoy this one.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 7;
                healthRange = healthRange - 3;
                amIDeadYet("n/a");
                messagePrompt("One more chapter before I go to bed...", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 6;
                healthRange = healthRange + 3;
                amIDeadYet("Couldn't handle the knowledge.");
                messagePrompt("<WARNING!\n\nReading can seriously damage your ignorance.>", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 2;
                amIDeadYet("n/a");
                messagePrompt("The online reviews were really great.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 4;
                amIDeadYet("n/a");
                messagePrompt("This one's got a plot, characters, and everything.", 500);
                return;
            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionMedication(View view) {

        if (canIAffordIt("200.00")) {
            medicationCounter++;
            int temp = medicationCounter;
            statChanges(11, 28, "200.00");
            medicationCounter = temp;

            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.0003) {
                    happinessLevel = happinessLevel + 55;
                    hasPartner = 1;
                    amIDeadYet("n/a");
                    messagePrompt(" Quick, pharmacist, think fast! Do you have an inhaler? \n\nBecause YOU are taking my breath away *wink wink*. " +
                            "\n\nYou can now go on dates with the pharmacologist.", 3000);
                    loveDrain = 0;
                    return;
                }
            }

            if (new Random().nextDouble() < .50 && medicationCounter > 4) {
                healthRange = healthRange - 14;
                amIDeadYet("Medication overdose.");
                messagePrompt(" You have taken well above the recommended doses of medication. Your health is taking a toll.", 2000);

                return;
            }

            if (new Random().nextDouble() < .11) {
                happinessLevel = happinessLevel - 5;
                amIDeadYet("n/a");
                messagePrompt("Remember treatment, not prevention, is the goal.", 500);

                return;
            }
            if (new Random().nextDouble() < .11) {
               happinessLevel = happinessLevel + 8;
                amIDeadYet("n/a");
                messagePrompt(" At least the drowsiness helps to mask the chronic suffering.", 500);

                return;
            }

            if (new Random().nextDouble() < .08) {
                healthRange = healthRange - 5;
                happinessLevel = happinessLevel + 5;
                amIDeadYet("n/a");
                messagePrompt(" It's funny that half a decade ago, you would not have needed all this medication.", 500);

                return;
            }
            if (new Random().nextDouble() < 0.11) {
                happinessLevel = happinessLevel - 6;
                healthRange = healthRange + 6;
                 amIDeadYet("n/a");
                messagePrompt(" Laughter is the best medicine, until you start laughing for no reason. \n\nThen you actually need medicine.", 500);

                return;
            }

            if (new Random().nextDouble() < .03) {
                happinessLevel = happinessLevel + 25;
                amIDeadYet("Poppin' too many pills.");
                messagePrompt("Poppin', poppin' is all we know.", 1000);

                return;
            }

            if (new Random().nextDouble() < .08) {
               happinessLevel = happinessLevel + 7;
                netWorth = netWorth.add(new BigDecimal("50.00"));
                amIDeadYet("n/a");
                messagePrompt("There was a 50% OFF sale today.", 800);

                return;
            }

            if (new Random().nextDouble() < 0.07) {
                healthRange = healthRange - 15;

                amIDeadYet("Took wrong medication.");
                messagePrompt(" Unfortunately, you took the wrong medication. <You are a complete idiot.>\n\nYou " +
                        "made yourself very sick.", 2000);
                return;

            }

            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionBar(View view) {
        if (canIAffordIt("500.00")) {
            barCounter++;
            int temp = barCounter;
            statChanges(-15, 94, "500.00");
            barCounter = temp;
            if (new Random().nextDouble() < .5 && barCounter > 4) {
                healthRange = healthRange - 15;
                amIDeadYet("Alcoholism.");
                messagePrompt(" You've been visiting the bar often. Your frequent drinking is beginning to hurt your health.", 2000);

                return;
            }
            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.01) {
                    happinessLevel = happinessLevel + 55;
                    hasPartner = 1;
                    amIDeadYet("Alcoholism.");
                    messagePrompt(" You notice an attractive individual sitting next to you. <Luckily, they appear just as hopeless as you do!>\n\n After consuming a few drinks for a confidence boost, you ask them" +
                            " for their number and turns out, they think you're very cute too. " +
                            "\n\nYou can now go on dates with the drinking buddy.", 3000);
                    loveDrain = 0;
                    return;
                }
            }
            if (new Random().nextDouble() < 0.1) {
                happinessLevel = happinessLevel + 15;
                healthRange = healthRange - 5;
                amIDeadYet("Alcoholism.");
                messagePrompt("'You can't drink all day unless you start in the morning.'", 500);
                return;
            }
            if (new Random().nextDouble() < 0.1) {
               happinessLevel = happinessLevel + 15;
                healthRange = healthRange - 5;
                amIDeadYet("Alcoholism.");
                messagePrompt("'I don't drink water. Fish live in it. I'm an environmentalist.'", 500);

                return;
            }
            if (new Random().nextDouble() < 0.1) {
                if (hasPartner == 1) {
                    if ((new Random().nextDouble() < 0.40 && isMarried == 0) || (new Random().nextDouble() < 0.20 && isMarried == 1)) {
                        happinessLevel = happinessLevel + 75;
                        healthRange = healthRange - 20;
                        happinessDrain = happinessDrain + 5;
                        amIDeadYet("Alcoholism.");
                        messagePrompt(" You met a cute stranger last night and ended up getting very drunk. You were invited to spend the night at their place.\n\n" +
                                "Your clouded judgement got the best of you and you ended up sleeping with the stranger.\n\n" +
                                "<You have therefore, cheated on your current partner. The consequences of your actions are to be determined.>", 4000);

                        return;
                    }
                } else {
                    happinessLevel = happinessLevel + 45;
                    healthRange = healthRange - 10;
                    amIDeadYet("Alcoholism.");
                    messagePrompt("You met a cute stranger last night and ended up getting very drunk. You spent the night at their place.\n\n" +
                            "However, it was just a fling and the person doesn't wish to pursue any type of relationship. \n\nYou are still single.", 3000);

                    return;
                }
            }
            if (new Random().nextDouble() < 0.1) {
                happinessLevel = happinessLevel + 15;
                amIDeadYet("Alcoholism.");
                messagePrompt("You ended up meeting a new group of people and you got fairly tipsy. You had a great time throughout the night.", 2500);

                return;
            }
            if (new Random().nextDouble() < 0.1) {
                if (hasSecurity == 1)
                {
                    happinessLevel = happinessLevel - 25;
                    amIDeadYet("n/a");
                    messagePrompt("You got very intoxicated and became wreckless.\n\nThe bar keeper wanted to kick you out, but they noticed" +
                            " you had security with you.\n\nYou were nicely asked to leave.", 2500);

                    return;
                }
                if (new Random().nextDouble() < .30 && canIAffordIt("50.00") == false) {
                    happinessLevel = happinessLevel - 50;
                    healthRange = healthRange - 20;
                   amIDeadYet("Mugged by gangsters.");
                    messagePrompt("You got very intoxicated and became wreckless. You were kicked out of the bar.\n\nYou did not have enough " +
                            "money for a taxi, so you were forced to walk home. \n\nAs you were stumbling back, you were mugged and beaten by thugs." +
                            " Your health is hurt and you need to be more careful next time.", 3500);

                    return;
                } else if (canIAffordIt("50.00") == false) {
                    happinessLevel = happinessLevel - 25;
                    healthRange = healthRange - 8;
                   amIDeadYet("Alcoholism.");
                    messagePrompt("You got very intoxicated and became wreckless. You were kicked out of the bar.\n\nYou did not have enough " +
                            "money for a taxi, so you were forced to walk home. \n\nFortunately, you made it home safely but" +
                            " you need to be more careful next time.", 3500);

                    return;
                } else {
                    happinessLevel = happinessLevel - 15;
                    healthRange = healthRange - 8;
                   amIDeadYet("Alcoholism.");
                    messagePrompt("You got very intoxicated and became wreckless. You were kicked out of the bar.\n\nFortunately, you did have " +
                            "enough money for a taxi, so you did not have to walk home. \n\nYou made it home safely but" +
                            " you need to be more careful next time.", 3500);

                    return;
                }
            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionGroupTherapy(View view) {
        if (canIAffordIt("1200.00")) {
            statChanges(-14, 176, "1200.00");
            if (new Random().nextDouble() < 0.13) {
                messagePrompt(" 'So everyone's just here to talk about our problems all day, right?'", 1000);
                happinessLevel = happinessLevel + 20;
            } else
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'Shut up, Allen. Let Jenny speak her mind.'", 1000);
                happinessLevel = happinessLevel + 15;
            } else
            if (new Random().nextDouble() < 0.13) {
                messagePrompt(" 'I'm very shy, you know, could you just skip me?'\n'Well, I'm not completely" +
                        " shy, but I'm definitely more shy than average.'\n'I just can't seem to open up to people. Well " +
                        "it all began in my childhood...'", 1200);
                happinessLevel = happinessLevel - 15;
            } else
            if (new Random().nextDouble() < 0.13) {
                messagePrompt(" 'Oh, don't feel bad sweetie. It's not your fault that your head isn't wired correctly.'", 1000);
                happinessLevel = happinessLevel + 15;
            } else
            if (new Random().nextDouble() < 0.13) {
                messagePrompt(" 'I've never told anyone this before, but my dog enjoys it when I use my hand and...'", 1000);
                happinessLevel = happinessLevel - 15;
            } else
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'We have a newcomer here today, please welcome...'", 1000);
                happinessLevel = happinessLevel + 15;
            }
            amIDeadYet("Irony.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionTherapy(View view) {
        if (canIAffordIt("3000.00")) {
            statChanges(18, 345, "3000.00");


            if (hasPartner == 0) {
                if (new Random().nextDouble() < 0.0001) {
                    happinessLevel = happinessLevel + 60;

                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("n/a");
                    messagePrompt("Your therapist is growing an attachment to you. You seize the opportunity and ask them" +
                            " out. \n\n<They replied yes, unfortunately.>\n\n You can now " +
                            "go on dates with your mental counselor.", 3500);
                    return;
                }
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel - 40;
                amIDeadYet("Therapy did not help much, huh.");
                messagePrompt("'Mhm, that's very interesting. How does that make you feel?'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
               happinessLevel = happinessLevel + 30;
                amIDeadYet("Therapy did not help much, huh.");
                messagePrompt("'Let's get in touch with your inner child.'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel - 25;
                amIDeadYet("Therapy did not help much, huh.");
                messagePrompt("'It is when therapy seems futile that it is most effective.'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel - 35;
                amIDeadYet("Therapy did not help much, huh.");
                messagePrompt(" 'I'm sorry, that's all we have time for today. Time is money. Well, my time, your money.'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 35;
                amIDeadYet("Therapy did not help much, huh.");
                messagePrompt("'Do you know what is the definition of insanity?'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 50;
                amIDeadYet("Therapy did not help much, huh.");
                messagePrompt("'Maybe life isn't for everyone.'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel - 40;
                amIDeadYet("Therapy did not help much, huh.");
                messagePrompt("'Think of your head as an unsafe neighborhood; don't go inside it alone.'", 1200);

                return;

            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel - 35;
                amIDeadYet("Therapy did not help much, huh.");
                messagePrompt("'How do you think we can better bottle up those negative emotions?'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 35;
                amIDeadYet("Therapy did not help much, huh.");
                messagePrompt("'You may need to seek actual medical attention.'", 1200);

                return;
            }

            if (new Random().nextDouble() < .002) {
                happinessLevel = happinessLevel + 85;

                amIDeadYet("Therapy did not help much, huh.");
                messagePrompt("'Doc, I've got this strange feeling that I'm inside of a game.'\n\n<Haha.>", 2200);

                return;
            }

            amIDeadYet("Therapy did not help much, huh.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionMotivator(View view) {
        if (canIAffordIt("8000.00")) {
            statChanges(0, 782, "8000.00");
            if (hasPartner == 0) {
                if (new Random().nextDouble() < 0.001) {
                    happinessLevel = happinessLevel + 120;
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("n/a");
                    messagePrompt("You're falling in love with your mentor and you asked them for their" +
                            " number.\n\n You can now go on dates with your guru. ", 2500);
                    return;
                }
            }

            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel + 120;
                messagePrompt(" Early to bed, and early to rise, deems a young man useless and sleep deprived. ", 1200);
                healthRange = healthRange + 100;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.16) {
                happinessLevel = happinessLevel + 120;
                messagePrompt(" It is a cliche that most cliches are true, but then like most cliches, that cliche is untrue.", 1200);
                healthRange = healthRange - 50;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.17) {
                //happinessLevel = happinessLevel + 120;
                messagePrompt(" One day, someone will walk into your life and make you hate yourself more than you already do. You need" +
                        " to marry that person.", 1200);
                happinessLevel = happinessLevel - 300;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.18) {
                //happinessLevel = happinessLevel + 120;
                messagePrompt("Money is the root of all evil.", 1200);
                happinessLevel = happinessLevel - 300;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.19) {
                //happinessLevel = happinessLevel + 120;
                messagePrompt("You are a fruit loop in a world of cheerios.", 1200);
                happinessLevel = happinessLevel + 300;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel + 200;
                messagePrompt("A secret is something you tell everybody to tell nobody.", 1200);
                //happinessLevel = happinessLevel - 300;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel + 200;
                messagePrompt("A clever person solves a problem. A wise person avoids it.", 1200);
                //happinessLevel = happinessLevel - 300;
                amIDeadYet("n/a");
                return;
            }

            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionBodyguard(View view) {
        if (securityCounter > 180)
        {
            messagePrompt("Your agency does not allow an extension of policy past 90 days.\n\nYou can re-hire after " + (securityCounter/3) + " days, or extend after " + ((securityCounter - 180)/3) + " days.", 1000);
            return;
        }
        if (canIAffordIt("25000.00")) {
            statChanges(60, 1898, "25000.00");
            //hasSecurity++;
            securityCounter = securityCounter + 90;

            if (securityCounter <= 90 && securityCounter == 0)
                messagePrompt("You have hired security. Your contract will last for 30 days.\n\n" +
                        "You can extend your contract for up to 90 days, or rehire upon expiration.", 3000);
            else
                    messagePrompt("You have extended your contract to " + (securityCounter/3) + " days.", 1200);

            amIDeadYet("You cannot hire bodyguards for your mind.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionOpiates(View view) {
        if (canIAffordIt("45000.00")) {
            statChanges(-210, 3390, "45000.00");


            if (new Random().nextDouble() < .15) {
                messagePrompt("'What could possibly go wrong?'", 1200);
                happinessLevel = happinessLevel - 200;
                healthRange = healthRange - 70;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I feel like I'm floating.\n\nOh wait, that's my blood pressure.'", 1200);
                healthRange = healthRange - 90;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I can taste the sound waves as they course through the air.'", 1200);
                healthRange = healthRange + 80;
                happinessLevel = happinessLevel + 150;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I don't even see how this could be addicting. Addiction is for losers.'", 1200);
                healthRange = healthRange - 80;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }
                amIDeadYet("Drugs are bad, m'kay?");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionHeroin(View view) {
        if (canIAffordIt("90000.00")) {
            statChanges(-500, 6910, "90000.00");


            if (new Random().nextDouble() < .15) {
                messagePrompt("'Don't do drugs because if you do drugs you'll go to prison, and drugs are really expensive in prison.'", 1200);
                happinessLevel = happinessLevel + 300;
                healthRange = healthRange - 200;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'This is normal behaviour. This is very normal behaviour.'", 1200);
                happinessLevel = happinessLevel + 300;
                healthRange = healthRange - 150;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I can taste the sound waves as they course through the air.'", 1200);
                happinessLevel = happinessLevel + 350;
                healthRange = healthRange + 150;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I don't do cocaine, but it smells amazing.'", 1200);
                happinessLevel = happinessLevel + 250;
                healthRange = healthRange - 125;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("<You have successfully become emotionally constipated. You just don't give a crap, anymore.>", 1200);
                happinessLevel = happinessLevel + 200;
                healthRange = healthRange + 100;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }
            amIDeadYet("Drugs are bad, m'kay?");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionExperimentalDrugs(View view) {
        if (canIAffordIt("200000.00")) {
            statChanges(-1000, 15134, "200000.00");


            if (new Random().nextDouble() < .15) {
                messagePrompt("'If God dropped acid, would he see people?'", 1200);
                happinessLevel = happinessLevel + 400;
                healthRange = healthRange - 300;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'This is normal behaviour. This is very normal behaviour.'", 1200);
                happinessLevel = happinessLevel - 450;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I can taste the sound waves as they course through the air.'", 1200);
                happinessLevel = happinessLevel + 800;
                healthRange = healthRange - 300;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt(" 'It sort of looks like artificial sweetener.'", 1200);
                happinessLevel = happinessLevel + 400;
                healthRange = healthRange + 300;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt(" <You have successfully become emotionally constipated. You just don't give a crap, anymore.>", 1200);
                happinessLevel = happinessLevel + 500;
                healthRange = healthRange + 350;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }
            amIDeadYet("Drugs are bad, m'kay?");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionPill(View view) {
        if (canIAffordIt("500000.00")) {
            statChanges(-3000, 38335, "500000.00");
            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.001) {
                    happinessLevel = happinessLevel + 1500;
                    messagePrompt("During your visit in the private lab, you come across a very" +
                            " attractive biologist.\n\nThey notice you, and you notice them. <Clearly, you're wealthy enough for this treatment, so the stranger knows you're loaded.> \n\nYou can now go on dates with the researcher. ", 3000);
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("Drugs are bad, m'kay?");
                    return;
                }
                if (new Random().nextDouble() < 0.23) {
                    healthRange = healthRange + 900;
                    messagePrompt("<Reality is for people who cannot handle drugs.>", 1200);
                    amIDeadYet("Drugs are bad, m'kay?");
                    return;
                }
                if (new Random().nextDouble() < 0.23) {
                    healthRange = healthRange + 900;
                    messagePrompt("<Mr. Cooper approves.>", 1200);
                    amIDeadYet("Drugs are bad, m'kay?");
                    return;
                }
            }
            amIDeadYet("Drugs are bad, m'kay?");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();

        } else
            messagePrompt("You cannot afford that.", 500);
    }


    // ---------------------- SUCCESS --------------------------------------------------------

    public void functionSaveRespawnTokens2(View view) {
        if (daysNotDead > highScore) {
            int rT = respawnToken;
            messagePrompt(" You killed yourself after surviving " + daysNotDead + " days. A Respawn Token has been granted towards your next life." +
                    " \n\n(NEW) HIGHSCORE: " + daysNotDead + " ", 4000);
            highScore = daysNotDead;
            deathCounter = 0;
            resetStats();
            respawnToken = rT;
            updateVariables();
            ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
            if (outputStocks().equals(new BigDecimal("0.00")))
            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
            else
                ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");
            ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
            updateHealthAndHappiness();

        } else {
            int rT = respawnToken;
            messagePrompt(" You killed yourself after surviving " + daysNotDead + " days. A Respawn Token has been granted towards your next life." +
                    "  \n\nHIGHSCORE: " + highScore, 4000);
            deathCounter = 0;
            resetStats();
            respawnToken = rT;
            updateVariables();
            ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
            else
                ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

            ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
            updateHealthAndHappiness();

        }
    }

    public void functionSaveRespawnTokens(View view) {
        if (difficulty == 3)
        {
            messagePrompt("You can't kill yourself because of the difficulty you chose.", 500);
        }
        if (respawnToken == 2) {
            messagePrompt(" You can only kill yourself if you have no more than 1 Respawn Token.", 500);
            return;
        }
        if (respawnToken == 0) {
            messagePrompt(" You must acquire a Respawn Token before you can end your life.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new RespawnFragment());
        fragmentTransaction.commit();

    }

    public void functionSuccess(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new SuccessFragment());
        fragmentTransaction.commit();

        if (succMessage == 1)
        {
            succMessage = 0;
            messagePrompt(" TIP(!) - The Success category is largely responsible for increasing how much money you have, or Net Worth.", 1200);

        }
    }

    public void functionEducation(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new EducationFragment());
        fragmentTransaction.commit();

        if (educMessage == 1)
        {
            educMessage = 0;
            messagePrompt(" TIP(!) - Taking a certain amount of college classes gives you a Degree.\n\nA college Degree allows you to get higher-paying jobs.", 1500);
        }
    }

    public void functionLottery(View view) {
        if (lotteryCycle >= 10) {
            messagePrompt(" Your local law prohibits you from purchasing more than 10 lottery" +
                    " tickets at a time.", 500);
            return;
        }

        if (canIAffordIt("5.00")) {

            lotteryCycle++;
            int temp = lotteryCycle;
            if (new Random().nextDouble() < 0.00005) {
                messagePrompt(" You won the jackpot. Congratulations!\n\n<I guess karma does have a way of favoring already well-off individuals.>\n\n You are rewarded $1,000,000 " +
                        "(after taxes, this sum becomes $661,290.30).", 3500);
                happinessLevel = happinessLevel + 5000;
                statChanges(healthDrain / -2, happinessDrain / -2, "-661285.30");
                amIDeadYet("I don't know you could've fu**ed this up.");
            } else if (new Random().nextDouble() < 0.05) {
                messagePrompt("You scratched out your ticket and...\n" +
                        "\nYou won $30!", 1100);
                happinessLevel = happinessLevel + 30;
                statChanges(healthDrain / -2, happinessDrain / -2, "-25.00");
                amIDeadYet("n/a");
            } else if (new Random().nextDouble() < 0.01) {
                messagePrompt("You scratched out your ticket and...\n" +
                        "\nYou won $100!", 1100);
                happinessLevel = happinessLevel + 70;
                statChanges(healthDrain / -2, happinessDrain / -2, "-95.00");
                amIDeadYet("n/a");
            }
            else if (lotteryCycle > 5 && new Random().nextDouble() < 0.25){
                messagePrompt("Would you look at that?\n\n<Nothing again. You're wasting your time.>", 900);
                statChanges(healthDrain / -2, happinessDrain / -2, "5.00");
                amIDeadYet("n/a");
            } else {
                messagePrompt("You scratched out your ticket and...\n\n<Nothing.>", 500);
                statChanges(healthDrain / -2, happinessDrain / -2, "5.00");
                amIDeadYet("n/a");
            }

            String s = "Days Without Dying: " + daysNotDead;
            ((TextView) findViewById(R.id.textView2)).setText(s); //updates the value to UI


            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
            else
                ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");


            lotteryCycle = temp;
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }


    public void functionCareers(View view) {

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new CareersFragment());
        fragmentTransaction.commit();
        if (getSupportFragmentManager().executePendingTransactions()) {
            if (isEducated < 2)
                ((TextView) findViewById(R.id.buttonCareers2)).setText("Mid level. (LOCKED)");
            if (isEducated < 4)
                ((TextView) findViewById(R.id.buttonCareers3)).setText("Top level. (LOCKED)");
        }
    }

    // ----------------------- STOCKS --------------------------------

    public void functionStockAnalysis(View view) {
        if (canIAffordIt("750.00")) {
            netWorth = netWorth.subtract(new BigDecimal("750.00"));
            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
            else
                ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

            statChanges(healthRange / 2, happinessLevel / 2, "0.00");
            //amIDeadYet("n/a");
            //updates the net worth value to UI
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new StockAnalysisFragment());
            fragmentTransaction.commit();
            amIDeadYet("n/a");
            updateVariables();
        } else {
            messagePrompt("You cannot afford this.", 500);
        }
    }

    public void functionTradingReport(View view) {
        if (canIAffordIt("7500.00")) {
            netWorth = netWorth.subtract(new BigDecimal("7500.00"));
            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
            else
                ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

            if (new Random().nextDouble() < .15 && daysNotDead > 250 && netWorth.compareTo(new BigDecimal("50000.00")) <= 0)
            {
                messagePrompt("You have been tracked and found to be getting insider trading. Insider trading is illegal.\n\nYou have received a fine of $50,000.", 3500);
                netWorth = netWorth.subtract(new BigDecimal("50000"));
            }
            statChanges(healthRange / 2, happinessLevel / 2, "0.00");
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new StockInsiderFragment());
            fragmentTransaction.commit();
            amIDeadYet("n/a");
            updateVariables();
        } else {
            messagePrompt("You cannot afford this.", 500);
        }

    }

    public void functionStocks(View view) {

        if (daysNotDead < 75)//75
        {
            messagePrompt(" You must survive 75 days before trading stocks. ", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new TradeFragment());
        fragmentTransaction.commit();

        if (getSupportFragmentManager().executePendingTransactions()) {

            valueNow = outputStocks();
            ((TextView) findViewById(R.id.textView9)).setText("$" + valueNow.toString() + "     ");

            BigDecimal percentChange = new BigDecimal("0.00");
            if (valueDayAgo.compareTo(new BigDecimal("0.00")) != 0) {
                percentChange = (valueNow.subtract(valueDayAgo));
                if (valueNow.compareTo(new BigDecimal("0.00")) == 0)
                    percentChange = new BigDecimal("0.00");
                else
                    percentChange = percentChange.divide(valueNow, 4, RoundingMode.HALF_UP);
                BigDecimal oneHundred = new BigDecimal("100");
                percentChange = percentChange.multiply(oneHundred, new MathContext(2));
            }
            if (valueDayAgo.compareTo(new BigDecimal("0.00")) == 0) {
                ((TextView) findViewById(R.id.textView12)).setText("+" + percentChange + "%                         ");
                ((TextView) findViewById(R.id.textView11)).setText("N/A        ");
            } else if (valueNow.subtract(valueDayAgo).compareTo(new BigDecimal("0.00")) == -1) {
                ((TextView) findViewById(R.id.textView12)).setText("" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView11)).setText(valueNow.subtract(valueDayAgo).toString() + "        ");

            } else {
                ((TextView) findViewById(R.id.textView12)).setText("+" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView11)).setText("+" + valueNow.subtract(valueDayAgo).toString() + "        ");
            }

            percentChange = new BigDecimal("0.00");
            if (value3DaysAgo.compareTo(new BigDecimal("0.00")) != 0) {
                percentChange = (valueNow.subtract(value3DaysAgo));
                if (valueNow.compareTo(new BigDecimal("0.00")) == 0)
                    percentChange = new BigDecimal("0.00");
                else
                    percentChange = percentChange.divide(valueNow, 4, RoundingMode.HALF_UP);
                BigDecimal oneHundred = new BigDecimal("100");
                percentChange = percentChange.multiply(oneHundred, new MathContext(2));
            }
            if (value3DaysAgo.compareTo(new BigDecimal("0.00")) == 0) {
                ((TextView) findViewById(R.id.textView14)).setText("+" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView15)).setText("N/A        ");
            } else if (valueNow.subtract(value3DaysAgo).compareTo(new BigDecimal("0.00")) < 0) {
                ((TextView) findViewById(R.id.textView14)).setText("" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView15)).setText(valueNow.subtract(value3DaysAgo).toString() + "       ");

            } else {
                ((TextView) findViewById(R.id.textView14)).setText("+" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView15)).setText("+" + valueNow.subtract(value3DaysAgo).toString() + "        ");
            }

            percentChange = new BigDecimal("0.00");
            if (value7DaysAgo.compareTo(new BigDecimal("0.00")) != 0) {
                percentChange = (valueNow.subtract(value7DaysAgo));
                if (valueNow.compareTo(new BigDecimal("0.00")) == 0)
                    percentChange = new BigDecimal("0.00");
                else
                    percentChange = percentChange.divide(valueNow, 4, RoundingMode.HALF_UP);
                BigDecimal oneHundred = new BigDecimal("100");
                percentChange = percentChange.multiply(oneHundred, new MathContext(2));
            }
            if (value7DaysAgo.compareTo(new BigDecimal("0.00")) == 0) {
                ((TextView) findViewById(R.id.textView18)).setText("+" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView17)).setText("N/A        ");
            } else if (valueNow.subtract(value7DaysAgo).compareTo(new BigDecimal("0.00")) < 0) {
                ((TextView) findViewById(R.id.textView18)).setText("" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView17)).setText(valueNow.subtract(value7DaysAgo).toString() + "       ");

            } else {
                ((TextView) findViewById(R.id.textView18)).setText("+" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView17)).setText("+" + valueNow.subtract(value7DaysAgo).toString() + "        ");
            }
            percentChange = new BigDecimal("0.00");
            if (value15DaysAgo.compareTo(new BigDecimal("0.00")) != 0) {
                percentChange = (valueNow.subtract(value15DaysAgo));
                if (valueNow.compareTo(new BigDecimal("0.00")) == 0)
                    percentChange = new BigDecimal("0.00");
                else
                    percentChange = percentChange.divide(valueNow, 4, RoundingMode.HALF_UP);
                BigDecimal oneHundred = new BigDecimal("100");
                percentChange = percentChange.multiply(oneHundred, new MathContext(2));
            }
            if (value15DaysAgo.compareTo(new BigDecimal("0.00")) == 0) {
                ((TextView) findViewById(R.id.textView21)).setText("+" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView20)).setText("N/A        ");
            } else if (valueNow.subtract(value15DaysAgo).compareTo(new BigDecimal("0.00")) < 0) {
                ((TextView) findViewById(R.id.textView21)).setText("" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView20)).setText(valueNow.subtract(value15DaysAgo).toString() + "       ");

            } else {
                ((TextView) findViewById(R.id.textView21)).setText("+" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView20)).setText("+" + valueNow.subtract(value15DaysAgo).toString() + "        ");
            }
            percentChange = new BigDecimal("0.00");
            if (value30DaysAgo.compareTo(new BigDecimal("0.00")) != 0) {
                percentChange = (valueNow.subtract(value30DaysAgo));
                if (valueNow.compareTo(new BigDecimal("0.00")) == 0)
                    percentChange = new BigDecimal("0.00");
                else
                    percentChange = percentChange.divide(valueNow, 4, RoundingMode.HALF_UP);
                BigDecimal oneHundred = new BigDecimal("100");
                percentChange = percentChange.multiply(oneHundred, new MathContext(2));
            }
            if (value30DaysAgo.compareTo(new BigDecimal("0.00")) == 0) {
                ((TextView) findViewById(R.id.textView24)).setText("+" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView23)).setText("N/A        ");
            } else if (valueNow.subtract(value30DaysAgo).compareTo(new BigDecimal("0.00")) < 0) {
                ((TextView) findViewById(R.id.textView24)).setText("" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView23)).setText(valueNow.subtract(value30DaysAgo).toString() + "       ");

            } else {
                ((TextView) findViewById(R.id.textView24)).setText("+" + percentChange + "%                          ");
                ((TextView) findViewById(R.id.textView23)).setText("+" + valueNow.subtract(value30DaysAgo).toString() + "        ");
            }

        }
    }

    public BigDecimal dividedBy(BigDecimal a, BigDecimal b) {
        BigDecimal percentChange = new BigDecimal("0.00");
        if (b.compareTo(new BigDecimal("0.00")) != 0) {
            percentChange = (a.subtract(b));
            percentChange = percentChange.divide(b, 4, RoundingMode.HALF_UP);
            BigDecimal oneHundred = new BigDecimal("100");
            percentChange = percentChange.multiply(oneHundred, new MathContext(3));

        }
        return percentChange;
    }

    public void functionBuyStocks(View view) {

        //statChanges(healthRange / 2, happinessLevel / 2, "0.00");
        //((TextView) findViewById(R.id.textView4)).setText(nW); //updates the net worth value to UI
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new StocksFragment());
        fragmentTransaction.commit();

        if (getSupportFragmentManager().executePendingTransactions()) {
            ((TextView) findViewById(R.id.APDayvalue)).setText("(" + dividedBy((AP.value), AP.value2).toString() + "%)   $" + AP.value2.toString() + "       ");
            ((TextView) findViewById(R.id.APWeekvalue)).setText("(" + dividedBy((AP.value), AP.value7).toString() + "%)   $" + AP.value7.toString() + "       ");
            ((TextView) findViewById(R.id.BNNDayvalue)).setText("(" + dividedBy((BNN.value), BNN.value2).toString() + "%)   $" + BNN.value2.toString() + "       ");
            ((TextView) findViewById(R.id.BNNWeekvalue)).setText("(" + dividedBy((BNN.value), BNN.value7).toString() + "%)   $" + BNN.value7.toString() + "       ");
            ((TextView) findViewById(R.id.FUDayvalue)).setText("(" + dividedBy((FU.value), FU.value2).toString() + "%)   $" + FU.value2.toString() + "       ");
            ((TextView) findViewById(R.id.FUWeekvalue)).setText("(" + dividedBy((FU.value), FU.value7).toString() + "%)   $" + FU.value7.toString() + "       ");
            ((TextView) findViewById(R.id.FWBDayvalue)).setText("(" + dividedBy((FWB.value), FWB.value2).toString() + "%)   $" + FWB.value2.toString() + "       ");
            ((TextView) findViewById(R.id.FWBWeekvalue)).setText("(" + dividedBy((FWB.value), FWB.value7).toString() + "%)   $" + FWB.value7.toString() + "       ");
            ((TextView) findViewById(R.id.ETDayvalue)).setText("(" + dividedBy((ET.value), ET.value2).toString() + "%)   $" + ET.value2.toString() + "       ");
            ((TextView) findViewById(R.id.ETWeekvalue)).setText("(" + dividedBy((ET.value), ET.value7).toString() + "%)   $" + ET.value7.toString() + "       ");
            ((TextView) findViewById(R.id.IBCDayvalue)).setText("(" + dividedBy((IBC.value), IBC.value2).toString() + "%)   $" + IBC.value2.toString() + "       ");
            ((TextView) findViewById(R.id.IBCWeekvalue)).setText("(" + dividedBy((IBC.value), IBC.value7).toString() + "%)   $" + IBC.value7.toString() + "       ");
            ((TextView) findViewById(R.id.KCDayvalue)).setText("(" + dividedBy((KC.value), KC.value2).toString() + "%)   $" + KC.value2.toString() + "       ");
            ((TextView) findViewById(R.id.KCWeekvalue)).setText("(" + dividedBy((KC.value), KC.value7).toString() + "%)   $" + KC.value7.toString() + "       ");
            ((TextView) findViewById(R.id.MACADayvalue)).setText("(" + dividedBy((MACA.value), MACA.value2).toString() + "%)   $" + MACA.value2.toString() + "       ");
            ((TextView) findViewById(R.id.MACAWeekvalue)).setText("(" + dividedBy((MACA.value), MACA.value7).toString() + "%)   $" + MACA.value7.toString() + "       ");
            ((TextView) findViewById(R.id.MACBDayvalue)).setText("(" + dividedBy((MACB.value), MACB.value2).toString() + "%)   $" + MACB.value2.toString() + "       ");
            ((TextView) findViewById(R.id.MACBWeekvalue)).setText("(" + dividedBy((MACB.value), MACB.value7).toString() + "%)   $" + MACB.value7.toString() + "       ");
            ((TextView) findViewById(R.id.MMDayvalue)).setText("(" + dividedBy((MM.value), MM.value2).toString() + "%)   $" + MM.value2.toString() + "       ");
            ((TextView) findViewById(R.id.MMWeekvalue)).setText("(" + dividedBy((MM.value), MM.value7).toString() + "%)   $" + MM.value7.toString() + "       ");
            ((TextView) findViewById(R.id.NSXDayvalue)).setText("(" + dividedBy((NSX.value), NSX.value2).toString() + "%)   $" + NSX.value2.toString() + "       ");
            ((TextView) findViewById(R.id.NSXWeekvalue)).setText("(" + dividedBy((NSX.value), NSX.value7).toString() + "%)   $" + NSX.value7.toString() + "       ");
            ((TextView) findViewById(R.id.RMDayvalue)).setText("(" + dividedBy((RM.value), RM.value2).toString() + "%)   $" + RM.value2.toString() + "       ");
            ((TextView) findViewById(R.id.RMWeekvalue)).setText("(" + dividedBy((RM.value), RM.value7).toString() + "%)   $" + RM.value7.toString() + "       ");
            Button button = (Button) findViewById(R.id.buttonStockAP);
            button.setText(" AP - Acquaintance Pages                           $" + AP.value.toString());
            button = (Button) findViewById(R.id.buttonStockBNN);
            button.setText(" BNN - Biased News Network                       $" + BNN.value.toString());
            button = (Button) findViewById(R.id.buttonStockFU);
            button.setText(" FU - Fracking United Trust                        $" + FU.value.toString());
            button = (Button) findViewById(R.id.buttonStockFWB);
            button.setText(" FWB - Fair Weather Bank                             $" + FWB.value.toString());
            button = (Button) findViewById(R.id.buttonStockET);
            button.setText(" ET - Enterprise Connected                         $" + ET.value.toString());
            button = (Button) findViewById(R.id.buttonStockIBC);
            button.setText(" IBC - International Business Corp        $" + IBC.value.toString());
            button = (Button) findViewById(R.id.buttonStockKC);
            button.setText(" KC - King Cola                                                   $" + KC.value.toString());
            button = (Button) findViewById(R.id.buttonStockMACA);
            button.setText(" MAC.A - Money Arc Central A         $" + MACA.value.toString());
            button = (Button) findViewById(R.id.buttonStockMACB);
            button.setText(" MAC.B - Money Arc Central B                $" + MACB.value.toString());
            button = (Button) findViewById(R.id.buttonStockMM);
            button.setText(" MM - Monopoly Mart                                   $" + MM.value.toString());
            button = (Button) findViewById(R.id.buttonStockNSX);
            button.setText(" NSX - National Service Agency               $" + NSX.value.toString());
            button = (Button) findViewById(R.id.buttonStockRM);
            button.setText(" RM - Relative Motors                                   $" + RM.value.toString());
            ((TextView) findViewById(R.id.APAssetvalue)).setText("(" + AP.sharesOwned + ")     $" + AP.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.BNNAssetvalue)).setText("(" + BNN.sharesOwned + ")     $" + BNN.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.FUAssetvalue)).setText("(" + FU.sharesOwned + ")     $" + FU.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.FWBAssetvalue)).setText("(" + FWB.sharesOwned + ")     $" + FWB.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.ETAssetvalue)).setText("(" + ET.sharesOwned + ")     $" + ET.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.IBCAssetvalue)).setText("(" + IBC.sharesOwned + ")     $" + IBC.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.KCAssetvalue)).setText("(" + KC.sharesOwned + ")     $" + KC.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.MACAAssetvalue)).setText("(" + MACA.sharesOwned + ")     $" + MACA.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.MACBAssetvalue)).setText("(" + MACB.sharesOwned + ")     $" + MACB.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.MMAssetvalue)).setText("(" + MM.sharesOwned + ")     $" + MM.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.NSXAssetvalue)).setText("(" + NSX.sharesOwned + ")     $" + NSX.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.RMAssetvalue)).setText("(" + RM.sharesOwned + ")     $" + RM.outputAssets().toString() + "       ");

            amIDeadYet("n/a");
        }

    }

    public void functionSellStocks(View view) {

        //statChanges(healthRange / 2, happinessLevel / 2, "0.00");
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Stocks2Fragment());
        fragmentTransaction.commit();


        if (getSupportFragmentManager().executePendingTransactions()) {

            ((TextView) findViewById(R.id.APDayvalue)).setText("(" + dividedBy((AP.value), AP.value2).toString() + "%)   $" + AP.value2.toString() + "       ");
            ((TextView) findViewById(R.id.APWeekvalue)).setText("(" + dividedBy((AP.value), AP.value7).toString() + "%)   $" + AP.value7.toString() + "       ");
            ((TextView) findViewById(R.id.BNNDayvalue)).setText("(" + dividedBy((BNN.value), BNN.value2).toString() + "%)   $" + BNN.value2.toString() + "       ");
            ((TextView) findViewById(R.id.BNNWeekvalue)).setText("(" + dividedBy((BNN.value), BNN.value7).toString() + "%)   $" + BNN.value7.toString() + "       ");
            ((TextView) findViewById(R.id.FUDayvalue)).setText("(" + dividedBy((FU.value), FU.value2).toString() + "%)   $" + FU.value2.toString() + "       ");
            ((TextView) findViewById(R.id.FUWeekvalue)).setText("(" + dividedBy((FU.value), FU.value7).toString() + "%)   $" + FU.value7.toString() + "       ");
            ((TextView) findViewById(R.id.FWBDayvalue)).setText("(" + dividedBy((FWB.value), FWB.value2).toString() + "%)   $" + FWB.value2.toString() + "       ");
            ((TextView) findViewById(R.id.FWBWeekvalue)).setText("(" + dividedBy((FWB.value), FWB.value7).toString() + "%)   $" + FWB.value7.toString() + "       ");
            ((TextView) findViewById(R.id.ETDayvalue)).setText("(" + dividedBy((ET.value), ET.value2).toString() + "%)   $" + ET.value2.toString() + "       ");
            ((TextView) findViewById(R.id.ETWeekvalue)).setText("(" + dividedBy((ET.value), ET.value7).toString() + "%)   $" + ET.value7.toString() + "       ");
            ((TextView) findViewById(R.id.IBCDayvalue)).setText("(" + dividedBy((IBC.value), IBC.value2).toString() + "%)   $" + IBC.value2.toString() + "       ");
            ((TextView) findViewById(R.id.IBCWeekvalue)).setText("(" + dividedBy((IBC.value), IBC.value7).toString() + "%)   $" + IBC.value7.toString() + "       ");
            ((TextView) findViewById(R.id.KCDayvalue)).setText("(" + dividedBy((KC.value), KC.value2).toString() + "%)   $" + KC.value2.toString() + "       ");
            ((TextView) findViewById(R.id.KCWeekvalue)).setText("(" + dividedBy((KC.value), KC.value7).toString() + "%)   $" + KC.value7.toString() + "       ");
            ((TextView) findViewById(R.id.MACADayvalue)).setText("(" + dividedBy((MACA.value), MACA.value2).toString() + "%)   $" + MACA.value2.toString() + "       ");
            ((TextView) findViewById(R.id.MACAWeekvalue)).setText("(" + dividedBy((MACA.value), MACA.value7).toString() + "%)   $" + MACA.value7.toString() + "       ");
            ((TextView) findViewById(R.id.MACBDayvalue)).setText("(" + dividedBy((MACB.value), MACB.value2).toString() + "%)   $" + MACB.value2.toString() + "       ");
            ((TextView) findViewById(R.id.MACBWeekvalue)).setText("(" + dividedBy((MACB.value), MACB.value7).toString() + "%)   $" + MACB.value7.toString() + "       ");
            ((TextView) findViewById(R.id.MMDayvalue)).setText("(" + dividedBy((MM.value), MM.value2).toString() + "%)   $" + MM.value2.toString() + "       ");
            ((TextView) findViewById(R.id.MMWeekvalue)).setText("(" + dividedBy((MM.value), MM.value7).toString() + "%)   $" + MM.value7.toString() + "       ");
            ((TextView) findViewById(R.id.NSXDayvalue)).setText("(" + dividedBy((NSX.value), NSX.value2).toString() + "%)   $" + NSX.value2.toString() + "       ");
            ((TextView) findViewById(R.id.NSXWeekvalue)).setText("(" + dividedBy((NSX.value), NSX.value7).toString() + "%)   $" + NSX.value7.toString() + "       ");
            ((TextView) findViewById(R.id.RMDayvalue)).setText("(" + dividedBy((RM.value), RM.value2).toString() + "%)   $" + RM.value2.toString() + "       ");
            ((TextView) findViewById(R.id.RMWeekvalue)).setText("(" + dividedBy((RM.value), RM.value7).toString() + "%)   $" + RM.value7.toString() + "       ");

            Button button = (Button) findViewById(R.id.buttonStockAPsell);
            button.setText(" AP - Acquaintance Pages                           $" + AP.value.toString());
            button = (Button) findViewById(R.id.buttonStockBNNsell);
            button.setText(" BNN - Biased News Network                       $" + BNN.value.toString());
            button = (Button) findViewById(R.id.buttonStockFUsell);
            button.setText(" FU - Fracking United Trust                        $" + FU.value.toString());
            button = (Button) findViewById(R.id.buttonStockFWBsell);
            button.setText(" FWB - Fair Weather Bank                             $" + FWB.value.toString());
            button = (Button) findViewById(R.id.buttonStockETsell);
            button.setText(" ET - Enterprise Connected                         $" + ET.value.toString());
            button = (Button) findViewById(R.id.buttonStockIBCsell);
            button.setText(" IBC - International Business Corp        $" + IBC.value.toString());
            button = (Button) findViewById(R.id.buttonStockKCsell);
            button.setText(" KC - King Cola                                                   $" + KC.value.toString());
            button = (Button) findViewById(R.id.buttonStockMACAsell);
            button.setText(" MAC.A - Money Arc Central A         $" + MACA.value.toString());
            button = (Button) findViewById(R.id.buttonStockMACBsell);
            button.setText(" MAC.B - Money Arc Central B                $" + MACB.value.toString());
            button = (Button) findViewById(R.id.buttonStockMMsell);
            button.setText(" MM - Monopoly Mart                                   $" + MM.value.toString());
            button = (Button) findViewById(R.id.buttonStockNSXsell);
            button.setText(" NSX - National Service Agency               $" + NSX.value.toString());
            button = (Button) findViewById(R.id.buttonStockRMsell);
            button.setText(" RM - Relative Motors                                   $" + RM.value.toString());
            ((TextView) findViewById(R.id.APAssetvalue)).setText("(" + AP.sharesOwned + ")     $" + AP.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.BNNAssetvalue)).setText("(" + BNN.sharesOwned + ")     $" + BNN.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.FUAssetvalue)).setText("(" + FU.sharesOwned + ")     $" + FU.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.FWBAssetvalue)).setText("(" + FWB.sharesOwned + ")     $" + FWB.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.ETAssetvalue)).setText("(" + ET.sharesOwned + ")     $" + ET.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.IBCAssetvalue)).setText("(" + IBC.sharesOwned + ")     $" + IBC.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.KCAssetvalue)).setText("(" + KC.sharesOwned + ")     $" + KC.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.MACAAssetvalue)).setText("(" + MACA.sharesOwned + ")     $" + MACA.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.MACBAssetvalue)).setText("(" + MACB.sharesOwned + ")     $" + MACB.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.MMAssetvalue)).setText("(" + MM.sharesOwned + ")     $" + MM.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.NSXAssetvalue)).setText("(" + NSX.sharesOwned + ")     $" + NSX.outputAssets().toString() + "       ");
            ((TextView) findViewById(R.id.RMAssetvalue)).setText("(" + RM.sharesOwned + ")     $" + RM.outputAssets().toString() + "       ");
            amIDeadYet("n/a");
        }
    }

    public void functionStockAP(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }

        AP.buyShares(1);
        ((TextView) findViewById(R.id.APAssetvalue)).setText("(" + AP.sharesOwned + ")     $" + AP.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockAPsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        AP.sellShares(1);
        ((TextView) findViewById(R.id.APAssetvalue)).setText("(" + AP.sharesOwned + ")     $" + AP.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockBNN(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        BNN.buyShares(1);
        ((TextView) findViewById(R.id.BNNAssetvalue)).setText("(" + BNN.sharesOwned + ")     $" + BNN.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockBNNsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        BNN.sellShares(1);
        ((TextView) findViewById(R.id.BNNAssetvalue)).setText("(" + BNN.sharesOwned + ")     $" + BNN.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFU(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FU.buyShares(1);
        ((TextView) findViewById(R.id.FUAssetvalue)).setText("(" + FU.sharesOwned + ")     $" + FU.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFUsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FU.sellShares(1);
        ((TextView) findViewById(R.id.FUAssetvalue)).setText("(" + FU.sharesOwned + ")     $" + FU.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFWB(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FWB.buyShares(1);
        ((TextView) findViewById(R.id.FWBAssetvalue)).setText("(" + FWB.sharesOwned + ")     $" + FWB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFWBsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FWB.sellShares(1);
        ((TextView) findViewById(R.id.FWBAssetvalue)).setText("(" + FWB.sharesOwned + ")     $" + FWB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockET(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        ET.buyShares(1);
        ((TextView) findViewById(R.id.ETAssetvalue)).setText("(" + ET.sharesOwned + ")     $" + ET.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockETsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        ET.sellShares(1);
        ((TextView) findViewById(R.id.ETAssetvalue)).setText("(" + ET.sharesOwned + ")     $" + ET.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockIBC(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        IBC.buyShares(1);
        ((TextView) findViewById(R.id.IBCAssetvalue)).setText("(" + IBC.sharesOwned + ")     $" + IBC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockIBCsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        IBC.sellShares(1);
        ((TextView) findViewById(R.id.IBCAssetvalue)).setText("(" + IBC.sharesOwned + ")     $" + IBC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockKC(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        KC.buyShares(1);
        ((TextView) findViewById(R.id.KCAssetvalue)).setText("(" + KC.sharesOwned + ")     $" + KC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockKCsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        KC.sellShares(1);
        ((TextView) findViewById(R.id.KCAssetvalue)).setText("(" + KC.sharesOwned + ")     $" + KC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACA(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACA.buyShares(1);
        ((TextView) findViewById(R.id.MACAAssetvalue)).setText("(" + MACA.sharesOwned + ")     $" + MACA.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACAsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACA.sellShares(1);
        ((TextView) findViewById(R.id.MACAAssetvalue)).setText("(" + MACA.sharesOwned + ")     $" + MACA.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACB(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACB.buyShares(1);
        ((TextView) findViewById(R.id.MACBAssetvalue)).setText("(" + MACB.sharesOwned + ")     $" + MACB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACBsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACB.sellShares(1);
        ((TextView) findViewById(R.id.MACBAssetvalue)).setText("(" + MACB.sharesOwned + ")     $" + MACB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMM(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MM.buyShares(1);
        ((TextView) findViewById(R.id.MMAssetvalue)).setText("(" + MM.sharesOwned + ")     $" + MM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMMsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MM.sellShares(1);
        ((TextView) findViewById(R.id.MMAssetvalue)).setText("(" + MM.sharesOwned + ")     $" + MM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockNSX(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        NSX.buyShares(1);
        ((TextView) findViewById(R.id.NSXAssetvalue)).setText("(" + NSX.sharesOwned + ")     $" + NSX.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockNSXsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        NSX.sellShares(1);
        ((TextView) findViewById(R.id.NSXAssetvalue)).setText("(" + NSX.sharesOwned + ")     $" + NSX.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockRM(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        RM.buyShares(1);
        ((TextView) findViewById(R.id.RMAssetvalue)).setText("(" + RM.sharesOwned + ")     $" + RM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockRMsell(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        RM.sellShares(1);
        ((TextView) findViewById(R.id.RMAssetvalue)).setText("(" + RM.sharesOwned + ")     $" + RM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockAP5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        AP.buyShares(5);
        ((TextView) findViewById(R.id.APAssetvalue)).setText("(" + AP.sharesOwned + ")     $" + AP.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockAP25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        AP.buyShares(50);
        ((TextView) findViewById(R.id.APAssetvalue)).setText("(" + AP.sharesOwned + ")     $" + AP.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockBNN5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        BNN.buyShares(5);
        ((TextView) findViewById(R.id.BNNAssetvalue)).setText("(" + BNN.sharesOwned + ")     $" + BNN.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockBNN25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        BNN.buyShares(50);
        ((TextView) findViewById(R.id.BNNAssetvalue)).setText("(" + BNN.sharesOwned + ")     $" + BNN.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFU5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FU.buyShares(5);
        ((TextView) findViewById(R.id.FUAssetvalue)).setText("(" + FU.sharesOwned + ")     $" + FU.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFU25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FU.buyShares(50);
        ((TextView) findViewById(R.id.FUAssetvalue)).setText("(" + FU.sharesOwned + ")     $" + FU.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFWB5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FWB.buyShares(5);
        ((TextView) findViewById(R.id.FWBAssetvalue)).setText("(" + FWB.sharesOwned + ")     $" + FWB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFWB25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FWB.buyShares(50);
        ((TextView) findViewById(R.id.FWBAssetvalue)).setText("(" + FWB.sharesOwned + ")     $" + FWB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockET5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        ET.buyShares(5);
        ((TextView) findViewById(R.id.ETAssetvalue)).setText("(" + ET.sharesOwned + ")     $" + ET.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockET25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        ET.buyShares(50);
        ((TextView) findViewById(R.id.ETAssetvalue)).setText("(" + ET.sharesOwned + ")     $" + ET.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockIBC5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        IBC.buyShares(5);
        ((TextView) findViewById(R.id.IBCAssetvalue)).setText("(" + IBC.sharesOwned + ")     $" + IBC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockIBC25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        IBC.buyShares(50);
        ((TextView) findViewById(R.id.IBCAssetvalue)).setText("(" + IBC.sharesOwned + ")     $" + IBC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockKC5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        KC.buyShares(5);
        ((TextView) findViewById(R.id.KCAssetvalue)).setText("(" + KC.sharesOwned + ")     $" + KC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockKC25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        KC.buyShares(50);
        ((TextView) findViewById(R.id.KCAssetvalue)).setText("(" + KC.sharesOwned + ")     $" + KC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACA5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACA.buyShares(5);
        ((TextView) findViewById(R.id.MACAAssetvalue)).setText("(" + MACA.sharesOwned + ")     $" + MACA.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACA25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACA.buyShares(50);
        ((TextView) findViewById(R.id.MACAAssetvalue)).setText("(" + MACA.sharesOwned + ")     $" + MACA.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACB5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACB.buyShares(5);
        ((TextView) findViewById(R.id.MACBAssetvalue)).setText("(" + MACB.sharesOwned + ")     $" + MACB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACB25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACB.buyShares(50);
        ((TextView) findViewById(R.id.MACBAssetvalue)).setText("(" + MACB.sharesOwned + ")     $" + MACB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMM5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MM.buyShares(5);
        ((TextView) findViewById(R.id.MMAssetvalue)).setText("(" + MM.sharesOwned + ")     $" + MM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMM25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MM.buyShares(50);
        ((TextView) findViewById(R.id.MMAssetvalue)).setText("(" + MM.sharesOwned + ")     $" + MM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockNSX5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        NSX.buyShares(5);
        ((TextView) findViewById(R.id.NSXAssetvalue)).setText("(" + NSX.sharesOwned + ")     $" + NSX.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockNSX25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        NSX.buyShares(50);
        ((TextView) findViewById(R.id.NSXAssetvalue)).setText("(" + NSX.sharesOwned + ")     $" + NSX.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockRM5B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        RM.buyShares(5);
        ((TextView) findViewById(R.id.RMAssetvalue)).setText("(" + RM.sharesOwned + ")     $" + RM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockRM25B(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        RM.buyShares(50);
        ((TextView) findViewById(R.id.RMAssetvalue)).setText("(" + RM.sharesOwned + ")     $" + RM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockAP5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        AP.sellShares(5);
        ((TextView) findViewById(R.id.APAssetvalue)).setText("(" + AP.sharesOwned + ")     $" + AP.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockAP25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        AP.sellShares(50);
        ((TextView) findViewById(R.id.APAssetvalue)).setText("(" + AP.sharesOwned + ")     $" + AP.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockBNN5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        BNN.sellShares(5);
        ((TextView) findViewById(R.id.BNNAssetvalue)).setText("(" + BNN.sharesOwned + ")     $" + BNN.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockBNN25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        BNN.sellShares(50);
        ((TextView) findViewById(R.id.BNNAssetvalue)).setText("(" + BNN.sharesOwned + ")     $" + BNN.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFU5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FU.sellShares(5);
        ((TextView) findViewById(R.id.FUAssetvalue)).setText("(" + FU.sharesOwned + ")     $" + FU.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFU25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FU.sellShares(50);
        ((TextView) findViewById(R.id.FUAssetvalue)).setText("(" + FU.sharesOwned + ")     $" + FU.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFWB5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FWB.sellShares(5);
        ((TextView) findViewById(R.id.FWBAssetvalue)).setText("(" + FWB.sharesOwned + ")     $" + FWB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockFWB25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        FWB.sellShares(50);
        ((TextView) findViewById(R.id.FWBAssetvalue)).setText("(" + FWB.sharesOwned + ")     $" + FWB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockET5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        ET.sellShares(5);
        ((TextView) findViewById(R.id.ETAssetvalue)).setText("(" + ET.sharesOwned + ")     $" + ET.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockET25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        ET.sellShares(50);
        ((TextView) findViewById(R.id.ETAssetvalue)).setText("(" + ET.sharesOwned + ")     $" + ET.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockIBC5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        IBC.sellShares(5);
        ((TextView) findViewById(R.id.IBCAssetvalue)).setText("(" + IBC.sharesOwned + ")     $" + IBC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockIBC25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        IBC.sellShares(50);
        ((TextView) findViewById(R.id.IBCAssetvalue)).setText("(" + IBC.sharesOwned + ")     $" + IBC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockKC5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        KC.sellShares(5);
        ((TextView) findViewById(R.id.KCAssetvalue)).setText("(" + KC.sharesOwned + ")     $" + KC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockKC25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        KC.sellShares(50);
        ((TextView) findViewById(R.id.KCAssetvalue)).setText("(" + KC.sharesOwned + ")     $" + KC.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACA5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACA.sellShares(5);
        ((TextView) findViewById(R.id.MACAAssetvalue)).setText("(" + MACA.sharesOwned + ")     $" + MACA.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACA25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACA.sellShares(50);
        ((TextView) findViewById(R.id.MACAAssetvalue)).setText("(" + MACA.sharesOwned + ")     $" + MACA.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACB5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACB.sellShares(5);
        ((TextView) findViewById(R.id.MACBAssetvalue)).setText("(" + MACB.sharesOwned + ")     $" + MACB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMACB25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MACB.sellShares(50);
        ((TextView) findViewById(R.id.MACBAssetvalue)).setText("(" + MACB.sharesOwned + ")     $" + MACB.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMM5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MM.sellShares(5);
        ((TextView) findViewById(R.id.MMAssetvalue)).setText("(" + MM.sharesOwned + ")     $" + MM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockMM25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        MM.sellShares(50);
        ((TextView) findViewById(R.id.MMAssetvalue)).setText("(" + MM.sharesOwned + ")     $" + MM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockNSX5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        NSX.sellShares(5);
        ((TextView) findViewById(R.id.NSXAssetvalue)).setText("(" + NSX.sharesOwned + ")     $" + NSX.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockNSX25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        NSX.sellShares(50);
        ((TextView) findViewById(R.id.NSXAssetvalue)).setText("(" + NSX.sharesOwned + ")     $" + NSX.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockRM5S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        RM.sellShares(5);
        ((TextView) findViewById(R.id.RMAssetvalue)).setText("(" + RM.sharesOwned + ")     $" + RM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockRM25S(View view) {

        if (tradeCounter >= 15)
        {
            messagePrompt("You have reached your day trading limit and are at risk for temporary suspension.\n\nYou can trade again, tomorrow.", 700);
            return;
        }


        RM.sellShares(50);
        ((TextView) findViewById(R.id.RMAssetvalue)).setText("(" + RM.sharesOwned + ")     $" + RM.outputAssets().toString() + "       ");
        valueNow = outputStocks();
        tradeCounter++;
    }

    public void functionStockAnalysisAP(View view) {

        messagePrompt("<<< Stock: AP - Acquaintance Pages >>>\n" +
                "Online software development firm that specializes in social networking services.\n\n" + AP.analysisReport(), 2000);
    }

    public void functionStockAnalysisBNN(View view) {

        messagePrompt("<<< Stock: BNN - Biased News Network >>>\n" +
                "Most popular mainstream news and television channel that is owned by lobbyists.\n\n" + BNN.analysisReport(), 2000);
    }

    public void functionStockAnalysisFU(View view) {

        messagePrompt("<<< Stock: FU - Fracking United >>>\n" +
                "Online software development firm that specializes in social networking services.\n\n" + FU.analysisReport(), 2000);
    }

    public void functionStockAnalysisFWB(View view) {

        messagePrompt("<<< Stock: FWB - Fair Weather Bank >>>\n" +
                "International banking and financial services company that has locations all across the globe.\n\n" + FWB.analysisReport(), 2000);
    }

    public void functionStockAnalysisET(View view) {

        messagePrompt("<<< Stock: ET - Enterprise Connected >>>\n" +
                "Telecommunications network that specializes in 'high-speed' internet and hopefully, some mobile coverage.\n\n" + ET.analysisReport(), 2000);
    }

    public void functionStockAnalysisIBC(View view) {

        messagePrompt("<<< Stock: IBC - International Business Corp. >>>\n" +
                "Computer hardware company that specializes in advancing electronic technologies, just before any one else does.\n\n" + IBC.analysisReport(), 2000);
    }

    public void functionStockAnalysisKC(View view) {

        messagePrompt("<<< Stock: KC - King Cola Inc. >>>\n" +
                "Multinational beverage company that specializes in carbonated sodas and obesity.\n\n" + KC.analysisReport(), 2000);
    }

    public void functionStockAnalysisMACA(View view) {

        messagePrompt("<<< Stock: MAC.A - Money Arc Central >>>\n" +
                "Class A stock of a multinational estate and asset management agency.\n\n" + MACA.analysisReport(), 2000);
    }

    public void functionStockAnalysisMACB(View view) {

        messagePrompt("<<< Stock: MAC.B - Money Arc Central >>>\n" +
                "Class B stock of a multinational estate and asset management agency.\n\n" + MACB.analysisReport(), 2000);
    }

    public void functionStockAnalysisMM(View view) {

        messagePrompt("<<< Stock: MM - Monopoly Mart >>>\n" +
                "National chain of supermarkets infamously known for its terrible wages and lackluster customer service.\n\n" + MM.analysisReport(), 2000);
    }

    public void functionStockAnalysisNSX(View view) {

        messagePrompt("<<< Stock: NSX - National Service Energy >>>\n" +
                "Energy and natural gas corporation that vows to convince the public it is looking for a brighter future.\n\n" + NSX.analysisReport(), 2000);
    }

    public void functionStockAnalysisRM(View view) {

        messagePrompt("<<< Stock: RM - Relative Motors >>>\n" +
                "International corporation that designs, manufactures, and distributes vehicles of questionable origins.\n\n" + RM.analysisReport(), 2000);
    }

    public void functionStockAnalysis2NSX(View view) {

        messagePrompt("<<< Stock: NSX - National Service Energy >>>\n" +
                "\n" + NSX.insiderReport(), 2000);
    }

    public void functionStockAnalysis2AP(View view) {

        messagePrompt("<<< Stock: AP - Acquaintance Pages >>>\n" +
                "\n" + AP.insiderReport(), 2000);
    }

    public void functionStockAnalysis2BNN(View view) {

        messagePrompt("<<< Stock: BNN - Biased News Network >>>\n" +
                "\n" + BNN.insiderReport(), 2000);
    }

    public void functionStockAnalysis2FU(View view) {

        messagePrompt("<<< Stock: FU - Fracking United >>>\n" +
                "\n" + FU.insiderReport(), 2000);
    }

    public void functionStockAnalysis2FWB(View view) {

        messagePrompt("<<< Stock: FWB - Fair Weather Bank >>>\n" +
                "\n" + FWB.insiderReport(), 2000);
    }

    public void functionStockAnalysis2ET(View view) {

        messagePrompt("<<< Stock: ET - Enterprise Connected >>>\n" +
                "\n" + ET.insiderReport(), 2000);
    }

    public void functionStockAnalysis2IBC(View view) {

        messagePrompt("<<< Stock: IBC - International Business Corp. >>>\n" +
                "\n" + IBC.insiderReport(), 2000);
    }

    public void functionStockAnalysis2KC(View view) {

        messagePrompt("<<< Stock: KC - King Cola Inc. >>>\n" +
                "\n" + KC.insiderReport(), 2000);
    }

    public void functionStockAnalysis2MACA(View view) {

        messagePrompt("<<< Stock: MAC.A - Money Arc Central >>>\n" +
                "\n" + MACA.insiderReport(), 2000);
    }

    public void functionStockAnalysis2MACB(View view) {

        messagePrompt("<<< Stock: MAC.B - Money Arc Central >>>\n" +
                "\n" + MACB.insiderReport(), 2000);
    }

    public void functionStockAnalysis2MM(View view) {

        messagePrompt("<<< Stock: MM - Monopoly Mart >>>\n" +
                "\n" + MM.insiderReport(), 2000);
    }

    public void functionStockAnalysis2RM(View view) {

        messagePrompt("<<< Stock: RM - Relative Motors >>>\n" +
                "\n" + RM.insiderReport(), 2000);
    }

    //----------------------------------  CAREERS ---------------------------------------------------------------
    public void functionCareers1(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Careers1Fragment());
        fragmentTransaction.commit();

        if (careerMessage == 1)
        {
            careerMessage = 0;
            messagePrompt(" TIP(!) - Jobs are displayed with relative pay rates.\n\nFor ex. (X2.2$) means a job pays x2.2 as much as" +
                    " the starting pay.", 1500);
        }
    }

    public void functionCareers2(View view) {
        if (isEducated < 2)
        {
            messagePrompt("You don't have a Bachelor's Degree.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Careers2Fragment());
        fragmentTransaction.commit();
    }

    public void functionCareers3(View view) {
        if (isEducated < 4)
        {
            messagePrompt("You don't have a Doctorate Degree.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Careers3Fragment());
        fragmentTransaction.commit();
    }


    public void functionSalesJob(View view) {
        if (isEducated >= 2) {
            messagePrompt(" You have a higher tiered job now, and cannot do this peasant work anymore.", 500);
            return;
        }
        jobCycle++;
        jobCounter++;
        int temp = jobCounter;

        statChanges(-4, -6, "-" + Integer.toString(payRate));
        totalEarned = totalEarned.add(new BigDecimal(Integer.toString(payRate)));

        jobCounter = temp;

        if (jobCycle % 15 == 0 && jobCycle != 30) {
            payRate = payRate + 10;
            messagePrompt(" You have been given a raise and will now earn $10 more than before. ", 2000);
            happinessLevel = happinessLevel + 15;
            amIDeadYet("n/a");
            return;
        }

        if (jobCycle >= 30 && job2Trigger == 0 && isEducated >= 1) {
            job2Trigger = 1;
            messagePrompt(" Your position has been promoted. You can now work as a manager. ", 2000);
            happinessLevel = happinessLevel + 30;
            amIDeadYet("n/a");
            return;
        }

        if (jobCounter > 9 && new Random().nextDouble() < 0.35) {
            messagePrompt(" You've been at work for more than three days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthRange = healthRange - 15;
            amIDeadYet("n/a");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.0005) {
                happinessLevel = happinessLevel + 25;
                messagePrompt("During break time, you asked one of your cute employees for their" +
                        " number. \n\n<Wow, they actually gave it to you.>\n\nYou are no longer single and can now go on dates with your co-worker.", 2000);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("n/a");
                return;
            }
        }
        if (new Random().nextDouble() < 0.02) {
            messagePrompt("I promise, I don't hate myself that much.", 500);
            happinessLevel = happinessLevel - 2;
            amIDeadYet("n/a");
            return;
        }
        if (new Random().nextDouble() < 0.02) {
            messagePrompt(" I could probably fit in a few more minutes into this break.", 500);
            happinessLevel = happinessLevel + 2;
            amIDeadYet("n/a");
            return;
        }
        if (new Random().nextDouble() < 0.02) {
            messagePrompt(" 'This doesn't have a barcode, that means it's free right?'", 500);
            happinessLevel = happinessLevel + 2;
            amIDeadYet("n/a");
            return;
        }
        if (new Random().nextDouble() < 0.02) {
            messagePrompt(" 'How are you doing today?' *ignored* 'Well, I'll go screw myself then.'", 500);
            happinessLevel = happinessLevel - 2;
            amIDeadYet("n/a");
            return;
        }

        amIDeadYet("n/a");
        if (amIDead() == false && daysNotDead % 7 != 0)
            amIOkayYet();
    }

    public void functionOfficeManagerJob(View view) {
        if (job4Trigger == 1) {
            messagePrompt(" You have a higher tiered job now, and cannot do this peasant work anymore.", 500);
            return;
        }
        if (job2Trigger == 0 && isEducated < 2) {
            messagePrompt("You have not been promoted to manager yet.", 500);
            return;
        }
        if (isEducated == 0) {
            messagePrompt("You need to be in school before working as a manager.", 500);
            return;
        }

        jobCycle2++;
        statChanges(-5, -6, "-" + Integer.toString(payRate2));
        totalEarned = totalEarned.add(new BigDecimal(Integer.toString(payRate2)));

        if (jobCycle2 % 25 == 0) {
            payRate2 = payRate2 + 20;
            messagePrompt("Good job. You have been given a raise and will now earn $20 more than before. ", 2000);
            happinessLevel = happinessLevel + 25;
            amIDeadYet("n/a");
            return;
        }
        if (jobCounter > 9 && new Random().nextDouble() < 0.35) {
            messagePrompt(" You've been at work for more than three days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthRange = healthRange - 25;
            amIDeadYet("n/a");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.00010) {
                happinessLevel = happinessLevel + 30;
                messagePrompt("You got the courage to ask one of your hot co-workers for " +
                        "their number. \n\nYou can now go on dates with your co-worker.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.015) {
                messagePrompt("'This coffee is too cold. Go make another.'", 500);
                happinessLevel = happinessLevel - 3;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.015) {
                messagePrompt("'Just ping me an email, I'll probably get back to it ASAP.'", 500);
                happinessLevel = happinessLevel + 3;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.015) {
                messagePrompt("'If you want to survive here, you need to do more with less.'", 500);
                happinessLevel = happinessLevel + 3;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.015) {
                messagePrompt("'Mhm... yeah. I love the idea.' \n\n'But let's continue this discussion after my lunch, okay?'", 500);
                happinessLevel = happinessLevel - 3;
                amIDeadYet("n/a");
                return;
            }
        }
        amIDeadYet("n/a");
        if (amIDead() == false && daysNotDead % 7 != 0)
            amIOkayYet();

    }

    public void functionInformationOfficerJob(View view) {
        if (isEducated >= 3) {
            messagePrompt(" You have a higher tiered job now, and cannot do this peasant work anymore.", 500);
            return;
        }
        if (isEducated < 2) {
            messagePrompt("This job requires a Bachelor's Degree.", 500);
            return;
        }

        jobCycle3++;
        Random rand2 = new Random();
        Random rand1 = new Random();
        /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
        int rHappiness = -14 + rand2.nextInt((-12 - -14) + 1);
        int rHealth = -10 + rand1.nextInt((-8 - -10) + 1);
        statChanges(rHealth, rHappiness, "-" + Integer.toString(payRate3));
        totalEarned = totalEarned.add(new BigDecimal(Integer.toString(payRate3)));

        if (jobCycle3 % 30 == 0) {
            payRate3 = payRate3 + 40;
            messagePrompt(" Great work. You have been given a raise and will now earn $40 more than before. ", 2000);
            happinessLevel = happinessLevel + 40;
            amIDeadYet("n/a");
            return;
        }
        if (jobCycle3 == 45) {
            job4Trigger = 1;
            messagePrompt(" Congratulations! Your position has been promoted and you can now work as the Regional Manager. ", 2500);
            happinessLevel = happinessLevel + 80;
            amIDeadYet("n/a");
            return;
        }
        if (jobCounter > 9 && new Random().nextDouble() < 0.35) {
            messagePrompt(" You've been at work for more than three days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthRange = healthRange - 35;
            amIDeadYet("n/a");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.00040) {
                happinessLevel = happinessLevel + 60;
                messagePrompt("You asked one of your hot office workers for their number. \n\nYou can now go on dates " +
                        "with your co-worker.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("n/a");
                return;
            }
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'We are not going to let our IT division dictate how this company is run!'", 500);
            happinessLevel = happinessLevel - 5;
            amIDeadYet("n/a");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'Hard work never killed anybody, but why take a chance?.'", 500);
            happinessLevel = happinessLevel + 5;
            amIDeadYet("n/a");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'No one has ever got fired around here by using THIS type of hardware.'", 500);
            happinessLevel = happinessLevel + 5;
            amIDeadYet("n/a");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'It feels like I am working with dinosaurs.'", 500);
            happinessLevel = happinessLevel - 5;
            amIDeadYet("n/a");
            return;
        }
        amIDeadYet("n/a");
        if (amIDead() == false && daysNotDead % 7 != 0)
            amIOkayYet();

    }

    public void functionRegionalManagerJob(View view) {
        if (job6Trigger == 1) {
            messagePrompt("You have a higher tiered job now, and cannot do this peasant work anymore.", 500);
            return;
        }
        if (isEducated < 2) {
            messagePrompt("This job requires a Bachelor's Degree.", 500);
            return;
        }
        if (job4Trigger == 0 && isEducated < 3) {
            messagePrompt("You have not been promoted to Regional Manager yet.", 500);
            return;
        }

        jobCycle4++;
        Random rand2 = new Random();
        Random rand1 = new Random();
        /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
        int rHappiness = -23 + rand2.nextInt((-19 - -23) + 1);
        int rHealth = -16 + rand1.nextInt((-14 - -16) + 1);
        statChanges(rHealth, rHappiness, "-" + Integer.toString(payRate4));
        totalEarned = totalEarned.add(new BigDecimal(Integer.toString(payRate4)));

        if (jobCycle4 % 35 == 0) {
            payRate4 = payRate4 + 65;
            messagePrompt("Nice job. You have been given a raise and will now earn $65 more than before. ", 2000);
            happinessLevel = happinessLevel + 55;
            amIDeadYet("n/a");
            return;
        }
        if (jobCounter > 9 && new Random().nextDouble() < 0.35) {
            messagePrompt("You've been at work for more than three days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthRange = healthRange - 45;
            amIDeadYet("n/a");
            return;
        }
        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.0004) {
                happinessLevel = happinessLevel + 80;
                messagePrompt("You asked one of your hot office workers for their number. \n\nYou can now go on dates " +
                        "with your co-worker.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("n/a");
                return;
            }
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'If you want to get far in this job, you need to think OUTSIDE the box.'", 500);
            happinessLevel = happinessLevel - 5;
            amIDeadYet("n/a");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'Don't worry, this is surely a win-win situation.'", 500);
            happinessLevel = happinessLevel + 5;
            amIDeadYet("n/a");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'Let's hit the ground running.'", 500);
            happinessLevel = happinessLevel + 5;
            amIDeadYet("n/a");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'We need to PUSH the envelope here.'", 500);
            happinessLevel = happinessLevel - 5;
            amIDeadYet("n/a");
            return;
        }
        amIDeadYet("n/a");
        if (amIDead() == false && daysNotDead % 7 != 0)
            amIOkayYet();

    }

    public void functionJuniorConsultantJob(View view) {
        if (isEducated >= 4) {
            messagePrompt("You have a higher tiered job now, and cannot do this peasant work anymore.", 500);
            return;
        }
        if (isEducated < 3) {
            messagePrompt("This job requires a Master's Degree.", 500);
            return;
        }

        jobCycle5++;
        Random rand2 = new Random();
        Random rand1 = new Random();
        /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
        int rHappiness = -37 + rand2.nextInt((-31 - -37) + 1);
        int rHealth = -21 + rand1.nextInt((-17 - -21) + 1);
        statChanges(rHealth, rHappiness, "-" + Integer.toString(payRate5));
        totalEarned = totalEarned.add(new BigDecimal(Integer.toString(payRate5)));

        if (jobCycle5 % 40 == 0) {
            payRate5 = payRate5 + 90;
            messagePrompt(" Excellent work. You have been given a raise and will now earn $90 more than before. ", 2000);
            happinessLevel = happinessLevel + 90;
            amIDeadYet("n/a");
            return;
        }
        if (jobCycle5 == 60) {
            messagePrompt(" Congratulations! You have been promoted to the Senior Executive position.", 2500);
            happinessLevel = happinessLevel + 180;
            job6Trigger = 1;
            return;
        }
        if (jobCounter > 9 && new Random().nextDouble() < 0.35) {
            messagePrompt("You've been at work for more than three days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthRange = healthRange - 55;
            amIDeadYet("n/a");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.00040) {
                happinessLevel = happinessLevel + 140;
                messagePrompt("You asked one of your hot office workers for their number. \n\nYou can now go on dates " +
                        "with your co-worker.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("n/a");
                return;
            }
        }
        amIDeadYet("n/a");
        if (amIDead() == false && daysNotDead % 7 != 0)
            amIOkayYet();

    }

    public void functionSeniorExecutiveJob(View view) {
        if (isEducated < 3) {
            messagePrompt("This job requires a Master's Degree.", 500);
            return;
        }
        if (job6Trigger == 0) {
            messagePrompt("You have not been promoted to Senior Executive yet.", 500);
            return;
        }

        jobCycle6++;
        Random rand2 = new Random();
        Random rand1 = new Random();
        /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
        int rHappiness = -68 + rand2.nextInt((-60 - -68) + 1);
        int rHealth = -36 + rand1.nextInt((-32 - -36) + 1);
        statChanges(rHealth, rHappiness, "-" + Integer.toString(payRate6));
        totalEarned = totalEarned.add(new BigDecimal(Integer.toString(payRate6)));

        if (jobCycle6 % 40 == 0) {
            payRate6 = payRate6 + 150;
            messagePrompt(" Exquisite work. You have been given a raise and will now earn $150 more than before. ", 2000);
            happinessLevel = happinessLevel + 140;
            amIDeadYet("n/a");
            return;
        }
        if (jobCounter > 15 && new Random().nextDouble() < 0.35) {
            messagePrompt("You've been at work for more than five days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthRange = healthRange - 65;
            amIDeadYet("n/a");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.0050) {
                happinessLevel = happinessLevel + 160;
                messagePrompt("You asked one of your sexy interns for " +
                        "their number. \n\nYou can now go on dates with your personal assistant.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("n/a");
                return;
            }
        }
        amIDeadYet("n/a");
        if (amIDead() == false && daysNotDead % 7 != 0)
            amIOkayYet();

    }

    public void functionBoardDirectorsJob(View view) {
        if (isEducated < 4) {
            messagePrompt("This job requires a Doctorate Degree.", 500);
            return;
        }

        jobCycle7++;
        Random rand2 = new Random();
        Random rand1 = new Random();
        /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
        int rHappiness = -106 + rand2.nextInt((-98 - -106) + 1);
        int rHealth = -61 + rand1.nextInt((-57 - -61) + 1);
        statChanges(rHealth, rHappiness, "-" + Integer.toString(payRate7));
        totalEarned = totalEarned.add(new BigDecimal(Integer.toString(payRate7)));

        if (jobCycle7 % 40 == 0) {
            payRate7 = payRate7 + 240;
            messagePrompt(" Exquisite work. You have been given a raise and will now earn $240 more than before. ", 2000);
            happinessLevel = happinessLevel + 230;
            amIDeadYet("n/a");
            return;
        }
        if (jobCycle7 == 100) {
            messagePrompt(" Congratulations! You have been promoted to the Chief Operating Officer position.", 3000);
            happinessLevel = happinessLevel + 460;
            job8Trigger = 1;
            return;
        }
        if (jobCounter > 21 && new Random().nextDouble() < 0.35) {
            messagePrompt("You've been working for more than a week now. \n\nYour health is weakening and you need some rest.", 2000);
            healthRange = healthRange - 95;
            amIDeadYet("n/a");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.0050) {
                happinessLevel = happinessLevel + 230;
                messagePrompt(" You asked one of your sexy interns for " +
                        "their number. \n\nYou can now go on dates with your personal assistant.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("n/a");
                return;
            }
        }
        amIDeadYet("n/a");
        if (amIDead() == false && daysNotDead % 7 != 0)
            amIOkayYet();

    }

    public void functionChiefOperatingOfficerJob(View view) {
        if (isEducated < 4) {
            messagePrompt("This job requires a Doctorate Degree.", 500);
            return;
        }
        if (job8Trigger == 0) {
            messagePrompt("You have not been promoted to Chief Operating Officer yet.", 500);
            return;
        }

        jobCycle8++;
        Random rand2 = new Random();
        Random rand1 = new Random();
        /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
        int rHappiness = -165 + rand2.nextInt((-155 - -165) + 1);
        int rHealth = -93 + rand1.nextInt((-87 - -93) + 1);
        statChanges(rHealth, rHappiness, "-" + Integer.toString(payRate8));
        totalEarned = totalEarned.add(new BigDecimal(Integer.toString(payRate8)));

        if (jobCycle8 % 40 == 0) {
            payRate8 = payRate8 + 330;
            messagePrompt("Exquisite work. You have been given a raise and will now earn $330 more than before. ", 2000);
            happinessLevel = happinessLevel + 350;
            amIDeadYet("n/a");
            return;
        }
        if (jobCycle8 == 140) {
            messagePrompt("Congratulations! The Chief Executive Officer has resigned, and has left the company to you. You are now the CEO.", 4000);
            happinessLevel = happinessLevel + 1000;
            jobCEOTrigger = 1;
            return;
        }
        if (jobCounter > 21 && new Random().nextDouble() < 0.35) {
            messagePrompt("You've been working for more than a week now. Your health is weakening and you need some rest.", 2000);
            healthRange = healthRange - 140;
            amIDeadYet("n/a");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.0050) {
                happinessLevel = happinessLevel + 300;
                messagePrompt("You asked one of your sexy interns for " +
                        "their number. \n\nYou can now go on dates with your personal assistant.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("n/a");
                return;
            }
        }
        amIDeadYet("n/a");
        if (amIDead() == false && daysNotDead % 7 != 0)
            amIOkayYet();

    }

    public void functionCEOJob(View view) {
        if (jobCEOTrigger == 0) {
            messagePrompt("You are not the CEO of this company.", 500);
            return;
        }

        jobCycle9++;
        Random rand2 = new Random();
        Random rand1 = new Random();
        /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
        int rHappiness = -240 + rand2.nextInt((-230 - -240) + 1);
        int rHealth = -158 + rand1.nextInt((-132 - -158) + 1);
        statChanges(rHealth, rHappiness, "-" + Integer.toString(payRate9));
        totalEarned = totalEarned.add(new BigDecimal(Integer.toString(payRate9)));

        if (jobCycle9 % 45 == 0) {
            payRate9 = payRate9 + 500;
            messagePrompt(" You raised your own salary and will now earn $500 more than before. ", 2500);
            happinessLevel = happinessLevel + 800;
            amIDeadYet("n/a");
            return;
        }

        if (hasPartner == 0) {

            if (new Random().nextDouble() < 0.001) {
                happinessLevel = happinessLevel + 290;
                messagePrompt("The new intern looked awfully attractive with those glasses today" +
                        ". \n\nYou can now go on dates with your personal assistant.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("n/a");
                return;
            }
        }
        amIDeadYet("n/a");
        if (amIDead() == false && daysNotDead % 7 != 0)
            amIOkayYet();

    }

    public void functionCollege(View view) {

        if (daysNotDead < 15) {
            messagePrompt("You must survive 15 days before attempting school.", 500);
            return;
        }

        if (collegeClassesTaken >= 8) {
            messagePrompt(" You have already received your Bachelor's Degree. ", 500);
            return;
        }

        if (canIAffordIt("400.00")) {
            Random rand2 = new Random();
            Random rand1 = new Random();
            educationDrain = 0;
            isEducated = 1;

            /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
            int rHappiness = -25 + rand2.nextInt((5 - -25) + 1);
            int rHealth = -13 + rand1.nextInt((2 - -13) + 1);
            statChanges(rHealth, rHappiness, "400.00");

            if (hasPartner == 0 && collegeClassesTaken < 7) {

                if (new Random().nextDouble() < 0.04) {
                    happinessLevel = happinessLevel + 60;
                    messagePrompt("You've been paired up to work on a project with a classmate you find attractive.\n\n After working with each other, " +
                            "you find they are into you, too. How pleasant?\n\n You are no longer single and can now go on dates with your classmate.", 3000);
                    hasPartner = 1;
                    loveDrain = 0;
                    collegeClassesTaken++;
                    amIDeadYet("n/a");
                    return;
                }
            }

            if (new Random().nextDouble() < 0.12 && collegeClassesTaken < 7) {
                happinessLevel = happinessLevel - 4;
                healthRange = healthRange - 2;
                collegeClassesTaken++;
                messagePrompt(" Is your butt filled with novocaine, or have you been sitting down for too long?\n\n" + (8 - collegeClassesTaken) + "" +
                        " more classes to receive your Bachelor's Degree.", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && collegeClassesTaken < 7) {
                happinessLevel = happinessLevel + 7;
                collegeClassesTaken++;
                messagePrompt(" Damn, parking spots are getting harder to steal as the year goes on...\n\n" + (8 - collegeClassesTaken) + "" +
                        " more classes to receive your Bachelor's Degree.", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && collegeClassesTaken < 7) {
                happinessLevel = happinessLevel + 8;
                collegeClassesTaken++;
                messagePrompt(" 'Let's see, microwave pizza versus cheesy ramen noodles?'\n\n" + (8 - collegeClassesTaken) + "" +
                        " more classes to receive your Bachelor's Degree.", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && collegeClassesTaken < 7) {
                happinessLevel = happinessLevel + 11;
                healthRange = healthRange - 5;
                collegeClassesTaken++;
                messagePrompt(" You got into a fight with someone from class. <This isn't high school, tone it down, okay?>\n\n" + (8 - collegeClassesTaken) + "" +
                        " more classes to receive your Bachelor's Degree.", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && collegeClassesTaken < 7) {
                happinessLevel = happinessLevel + 9;
                collegeClassesTaken++;
                messagePrompt(" The moment your professor releases you early is when you truly start believing in God.\n\n" + (8 - collegeClassesTaken) + "" +
                        " more classes to receive your Bachelor's Degree.", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && collegeClassesTaken < 7) {
                happinessLevel = happinessLevel - 4;
                collegeClassesTaken++;
                messagePrompt(" Surprise pop quiz, plebs.\n\n" + (8 - collegeClassesTaken) + " more classes " +
                        "to receive your Master's Degree. ", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && collegeClassesTaken < 7) {
                happinessLevel = happinessLevel - 4;
                collegeClassesTaken++;
                messagePrompt(" If stress burned calories, you would be a supermodel.\n\n" + (8 - collegeClassesTaken) + " more classes " +
                        "to receive your Master's Degree. ", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && collegeClassesTaken < 7) {
                happinessLevel = happinessLevel + 8;
                collegeClassesTaken++;
                messagePrompt(" Cry on your textbook, put your head down, and then learn everything through osmosis.\n\n" + (8 - collegeClassesTaken) + " more classes " +
                        "to receive your Master's Degree. ", 1000);
                amIDeadYet("n/a");
                return;
            }


            collegeClassesTaken++;
            if (collegeClassesTaken == 8) {
                messagePrompt(" Congratulations! You have graduated from school and "
                        + "received your Bachelor's Degree.\n\n<'A different life is ahead of you...', or something like that.>\n\nNew job opportunities are now available.", 2000);
                isEducated++;//promotes user to grad school status, allows some job openings
                happinessLevel = happinessLevel + 130;
                amIDeadYet("n/a");
            } else {
                if (amIDead())
                    amIDeadYet("n/a");
                messagePrompt("You need " + (8 - collegeClassesTaken) + " more classes " +
                        "to receive your Bachelor's Degree. ", 1000);
            }
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionGradSchool(View view) {

        if (daysNotDead < 50) {
            messagePrompt("You must survive 50 days before attempting graduate school.", 500);
            return;
        }

        if (isEducated < 2) {
            messagePrompt("You must have completed undergraduate school to begin graduate school.", 500);
            return;
        }

        if (gradClassesTaken >= 10) {
            messagePrompt("You have already received your Master's Degree.", 500);
            return;
        }

        if (canIAffordIt("700.00")) {
            Random rand2 = new Random();
            Random rand1 = new Random();
            educationDrain = 0;

            /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
            int rHappiness = -30 + rand2.nextInt((12 - -30) + 1);
            int rHealth = -15 + rand1.nextInt((7 - -15) + 1);
            statChanges(rHealth, rHappiness, "700.00");
            if (hasPartner == 0 && gradClassesTaken < 9) {

                if (new Random().nextDouble() < 0.04) {
                    happinessLevel = happinessLevel + 140;
                    messagePrompt("You've been taking a class with a very attractive professor. In, fact that's probably the only " +
                            "reason you didn't drop it yet. They invite you over for coffee to discuss 'homework'.\n\n You are no longer single and can now go on dates with your teacher.", 3000);
                    hasPartner = 1;
                    loveDrain = 0;
                    gradClassesTaken++;
                    amIDeadYet("n/a");
                    return;
                }
            }
            if (new Random().nextDouble() < 0.12 && gradClassesTaken < 9) {
                happinessLevel = happinessLevel - 20;
                gradClassesTaken++;
                messagePrompt(" Surprise pop quiz, plebs.\n\n" + (10 - gradClassesTaken) + " more classes " +
                        "to receive your Master's Degree. ", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && gradClassesTaken < 9) {
                happinessLevel = happinessLevel + 12;
                gradClassesTaken++;
                messagePrompt(" If stress burned calories, you would be a supermodel.\n\n" + (10 - gradClassesTaken) + " more classes " +
                        "to receive your Master's Degree. ", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && gradClassesTaken < 9) {
                happinessLevel = happinessLevel + 7;
                gradClassesTaken++;
                messagePrompt(" Cry on your textbook, put your head down, and then learn everything through osmosis.\n\n" + (10 - gradClassesTaken) + " more classes " +
                        "to receive your Master's Degree. ", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && gradClassesTaken < 9) {
                happinessLevel = happinessLevel - 8;
                healthRange = healthRange - 5;
                gradClassesTaken++;
                messagePrompt(" It's a shame your cabinet is getting filled up with all the student loan debt letters.\n\n" + (10 - gradClassesTaken) + "" +
                        " more classes to receive your Bachelor's Degree.", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && gradClassesTaken < 9) {
                happinessLevel = happinessLevel + 14;
                gradClassesTaken++;
                messagePrompt(" Damn, it seems more and more of your friends know what they're doing with their lives...\n\n" + (10 - gradClassesTaken) + "" +
                        " more classes to receive your Bachelor's Degree.", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && gradClassesTaken < 9) {
                happinessLevel = happinessLevel + 16;
                gradClassesTaken++;
                messagePrompt(" 'Let's see, instant hot chocolate versus expensive energy drinks?'\n\n" + (10 - gradClassesTaken) + "" +
                        " more classes to receive your Bachelor's Degree.", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && gradClassesTaken < 9) {
                happinessLevel = happinessLevel + 22;
                healthRange = healthRange - 10;
                gradClassesTaken++;
                messagePrompt(" The melancholic realization that you actually need to be an adult is coming closer.\n\n" + (10 - gradClassesTaken) + "" +
                        " more classes to receive your Bachelor's Degree.", 1000);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && gradClassesTaken < 9) {
                happinessLevel = happinessLevel + 18;
                gradClassesTaken++;
                messagePrompt(" The moment your professor releases you early is when you truly start believing in God.\n\n" + (10 - gradClassesTaken) + "" +
                        " more classes to receive your Bachelor's Degree.", 1000);
                amIDeadYet("n/a");
                return;
            }


            gradClassesTaken++;
            if (gradClassesTaken == 10) {
                messagePrompt("Congratulations! You have graduated from school and "
                        + "received your Master's Degree.\n\n<You have reached a point in life most homo sapiens deem 'successful', I think.>\n\n" +
                        "New job opportunities are available to you.", 3000);
                isEducated++;//promotes user to master's status, all jobs available
                happinessLevel = happinessLevel + 400;
                updateHealthAndHappiness();
            } else {
                messagePrompt("You need " + (10 - gradClassesTaken) + " more classes " +
                        "to receive your Master's Degree. ", 1000);
            }
            amIDeadYet("n/a");
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionPostGradSchool(View view) {

        if (daysNotDead < 100) {
            messagePrompt("You must survive 100 days before attempting post-graduate school.", 500);
            return;
        }
        if (isEducated < 3) {
            messagePrompt("You must have completed graduate school to begin post-graduate school.", 500);
            return;
        }

        if (postGradClassesTaken >= 15) {
            messagePrompt("You have already received your Doctor's Degree.", 500);
            return;
        }

        if (canIAffordIt("1000.00")) {
            Random rand2 = new Random();
            Random rand1 = new Random();
            educationDrain = 0;

            /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
            int rHappiness = -40 + rand2.nextInt((15 - -40) + 1);
            int rHealth = -45 + rand1.nextInt((7 - -45) + 1);
            statChanges(rHealth, rHappiness, "1000.00");
            if (hasPartner == 0 && postGradClassesTaken < 14) {

                if (new Random().nextDouble() < 0.04) {
                    happinessLevel = happinessLevel + 120;
                    messagePrompt("You've been paired up to do a major assignment with some you like from school. Turns out they like " +
                            "you too. How pleasant?\n\n You are no longer single and can now go on dates with your classmate.\n\n" + (10 - gradClassesTaken) + "" +
                            " more classes to receive your Doctorate's Degree.", 3000);
                    hasPartner = 1;
                    loveDrain = 0;
                    postGradClassesTaken++;
                    amIDeadYet("n/a");
                    return;
                }
            }
            if (new Random().nextDouble() < 0.12 && postGradClassesTaken < 14) {
                happinessLevel = happinessLevel - 10;
                postGradClassesTaken++;
                messagePrompt(" Surprise pop quiz, plebs.\n\n" + (15 - postGradClassesTaken) + " more classes " +
                        "to receive your Doctorate's Degree. ", 500);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && postGradClassesTaken < 14) {
                happinessLevel = happinessLevel + 6;
                postGradClassesTaken++;
                messagePrompt(" If stress burned calories, you would be a supermodel.\n\n" + (15 - postGradClassesTaken) + " more classes " +
                        "to receive your Doctorate's Degree. ", 500);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.12 && postGradClassesTaken < 14) {
                happinessLevel = happinessLevel + 3;
                postGradClassesTaken++;
                messagePrompt(" Put your head down, cry on your textbook, and then absorb information through osmosis.\n\n" + (15 - postGradClassesTaken) + " more classes " +
                        "to receive your Doctorate's Degree. ", 500);
                amIDeadYet("n/a");
                return;
            }


            postGradClassesTaken++;
            if (postGradClassesTaken == 15) {
                messagePrompt(" Congratulations! You have graduated from school and "
                        + "received your Doctorate's Degree.\n\n <You are now in the top quadrant of the intellectual populace. I, personally, salute you.>\n\n" +
                        "New job opportunities are available to you.", 3000);
                isEducated++;//promotes user to master's status, all jobs available
                happinessLevel = happinessLevel + 100;
                updateHealthAndHappiness();
            } else {
                messagePrompt("You need " + (15 - postGradClassesTaken) + " more classes " +
                        "to receive your Doctorate's Degree. ", 500);
            }
            amIDeadYet("n/a");
        } else
            messagePrompt("You cannot afford that.", 500);
    }


    // ---------------------------- LUXURY ---------------------------------------------------

    public void functionNightclub(View view) {
        if (luxuryCounter2 < 21) {
            messagePrompt("You need to wait " + ((21 - luxuryCounter2) / 3) + " days before taking your luxury time.", 500);
            return;
        }

        if (canIAffordIt("600.00")) {
            statChanges(-20, 129, "600.00");
            luxuryDrain = 0;
            luxuryCounter2 = 0;
            if (luxuryCounter == 0)
                luxuryCounter++;

            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.15) {
                    happinessLevel = happinessLevel + 90;
                    messagePrompt("You got really wasted and ended up making out with a cutie in the bathroom.\n\n" +
                            " You are no longer single and can now go on dates with your clubmate.", 2500);
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("Alcoholism.");
                    return;
                }
            }

            if (new Random().nextDouble() < 0.2) {
                happinessLevel = happinessLevel + 30;
                messagePrompt(" You got very tipsy and ended up meeting a new group of friends. You partied " +
                        "throughout the night and had a blast.", 2500);
                amIDeadYet("Alcoholism.");
                return;
            }

            if (new Random().nextDouble() < 0.1) {
                healthRange = healthRange - 15;
                messagePrompt("You drank too much and ended up vomiting. Your health is " +
                        "hurt.", 2000);
                amIDeadYet("Alcoholism.");
                return;
            }

            if (new Random().nextDouble() < 0.05) {
                happinessLevel = happinessLevel - 30;
                messagePrompt("'Why don't my parents appreciate me for who I am?'", 1200);
                amIDeadYet("Alcoholism.");
                return;
            }

            if (new Random().nextDouble() < 0.05) {
                happinessLevel = happinessLevel + 10;
                messagePrompt(" 'Hey, DJ. Can you play this mediocre pop track I heard on the radio two weeks ago?'", 1400);
                amIDeadYet("Alcoholism.");
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 10;
                messagePrompt(" 'I love to watch movies and drink expensive coffee. I am SO anti-social. By the WAY, can I buy you a drink?'", 1500);
                amIDeadYet("Alcoholism.");
                return;
            }

            if (new Random().nextDouble() < 0.05) {
                if (hasSecurity == 1)
                {
                    messagePrompt(" As you were stumbling back home drunk, you were mugged by a petty criminal.\n\n" +
                            "What the thug did not see, however, is that you are constantly followed by your hired security.\n\n" +
                            "They beat up the punk and threw him in a dumpster.", 3000);
                    happinessLevel = happinessLevel + 25;
                    amIDeadYet("n/a");
                    return;
                }
                else
                if (canIAffordIt("300.00")) //if the user can afford the function
                {
                    happinessLevel = happinessLevel - 25;
                    netWorth = netWorth.subtract(new BigDecimal("300.00"));
                    messagePrompt(" As you were stumbling back home drunk, you were mugged by a petty " +
                            "criminal who stole $300.\n\n<Unfortunately, they did not hurt you.>", 2500);
                    amIDeadYet("n/a");
                    return;

                } else {
                    healthRange = healthRange - 35;
                    happinessLevel = happinessLevel - 15;
                    netWorth = netWorth.subtract(netWorth);
                    messagePrompt(" As you were stumbling back home drunk, you were mugged by a petty " +
                            "criminal. \n\nSad to say, you did not have a lot of money on you, so " +
                            "they roughed you up instead. \n\n<Your health took a 'beating'>.", 3500);
                    amIDeadYet("Beaten up by a thug.");

                    return;
                }
            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionVegas(View view) {

        if (luxuryCounter < 1) {
            messagePrompt("You need to go party at a club before taking on Las Vegas.", 500);
            return;
        }

        if (luxuryCounter2 < 21) {
            messagePrompt("You need to wait " + ((21 - luxuryCounter2) / 3) + " days before taking time your luxury time.", 500);
            return;
        }

        if (canIAffordIt("10000.00") == true) {
            if (luxuryCounter == 1)
                luxuryCounter++;
            statChanges(-150, 1717, "10000.00");
            luxuryDrain = 0;
            luxuryCounter2 = 0;

            if (new Random().nextDouble() < 0.2 && isEducated == 2 && jobCEOReference == 0) {
                messagePrompt("You were gambling at the casino and merely by chance, you meet Jeffrey Smith, one of the" +
                        " top senior executives from the " +
                        "company you work for. \n\nYou make acquaintances with your newfound connection and " +
                        "they became impressed by your business foresight.\n\nThe company council could be notified about you.", 500);
                jobCEOReference = 1;
                happinessLevel = happinessLevel + 400;
                amIDeadYet("Whatever goes in Vegas, stays in Vegas.");
                return;
            }
            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.15) {
                    happinessLevel = happinessLevel + 500;
                    messagePrompt("You ended up meeting a very attractive individual at the VIP Lounge and took " +
                            "a few too many drinks. \n\n<Alcohol does wonders, so you make out at the top of the skyline" +
                            " under the moonlight.>\n\n" +
                            " You are no longer single and can now go on dates with the wild love interest.", 3000);
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("I don't know how you could've fu**ed this up.");
                    return;
                }
            }

            if (new Random().nextDouble() < 0.14) {
                happinessLevel = happinessLevel + 200;

                messagePrompt("You got very tipsy and ended up partying with a newly met group of strangers. You gambled " +
                        "throughout the night and had a blast.", 2500);
                amIDeadYet("Whatever goes in Vegas, stays in Vegas.");
                return;
            }

            if (new Random().nextDouble() < 0.09) {
                healthRange = healthRange - 100;
                happinessLevel = happinessLevel - 200;
                messagePrompt(" You drank too much and ended up vomiting all over the card dealer. \n\nYour health is " +
                        "hurt and you were kicked out of the casino.", 2000);
                amIDeadYet("Whatever goes in Vegas, stays in Vegas.");
                return;
            }

            if (new Random().nextDouble() < 0.09) {
                happinessLevel = happinessLevel + 100;
                messagePrompt(" 'I'm actually 1/27th Cherokee, do I get a discount at this casino?'", 1300);
                amIDeadYet("Whatever goes in Vegas, stays in Vegas.");
                return;
            }

            if (new Random().nextDouble() < 0.04) {
                if (hasSecurity == 1)
                {
                    messagePrompt(" As you were stumbling back to your hotel suite, you were mugged by a " +
                            "mafioso.\n\nWhat he did not see is that you are constantly followed by your hired security.\n\n" +
                            "They beat him up and threw him in a dumpster.", 3000);
                    happinessLevel = happinessLevel + 200;
                    amIDeadYet("n/a");
                    return;
                }
                else
                if (canIAffordIt("1000.00")) //if the user can afford the function
                {
                    happinessLevel = happinessLevel - 85;
                    netWorth = netWorth.subtract(new BigDecimal("1000.00"));
                    messagePrompt(" As you were stumbling back to your hotel suite, you were mugged by a " +
                            "mafioso.\n\n<You coughed up $1000 and, unfortunately, did not suffer any injuries.>", 2500);
                    amIDeadYet("n/a");

                    return;

                } else {
                    healthRange = healthRange - 95;
                    happinessLevel = happinessLevel - 75;
                    netWorth = netWorth.subtract(netWorth);
                    messagePrompt(" As you were stumbling back to your hotel suite, you were mugged by a mafioso. \n\nUnfortunately, you did not have a lot of money on you, so " +
                            "they beat you up instead. \n\n<You should probably get some security, next time.>", 3500);
                    amIDeadYet("Beaten by the mafia.");

                    return;
                }
            }

            if (new Random().nextDouble() < 0.08) {
                messagePrompt(" You played Poker throughout the night and gambled like a mad man. Your poker face" +
                        " is impeccable. " +
                        "\n\nYou won the $25,000 jackpot!", 3500);
                netWorth = netWorth.add(new BigDecimal("25000.00"));
                happinessLevel = happinessLevel + 300;
                amIDeadYet("Your heart gave out after winning.");
                return;

            }

            if (new Random().nextDouble() < 0.05) {
                if (canIAffordIt("10000.00") == false) //if the user cannot afford the function
                {
                    if (hasSecurity == 1)
                    {
                        happinessLevel = happinessLevel - 100;
                        messagePrompt(" You played Poker throughout the night and gambled like a mad man.\n\n You lost " +
                                "$10,000, but you couldn't pay up, so the casino was getting ready to kick you out.\n\nHowever, you had your hired security with you and" +
                                " you were nicely asked to leave, despite losing them so much money.", 3000);
                        amIDeadYet("n/a");
                        return;
                    }
                    else {
                        healthRange = healthRange - 95;
                        happinessLevel = happinessLevel - 175;
                        netWorth = netWorth.subtract(netWorth);

                        messagePrompt(" You played Poker throughout the night and gambled like a mad man.\n\n You lost " +
                                "$10,000 and you were thrown out of the casino.\n\n<You couldn't pay up properly, so the private security took whatever you had" +
                                " and beat you up for the rest.>", 3000);
                        amIDeadYet("Jumped by casino staff.");
                        return;
                    }
                } else {
                    if (hasSecurity == 1)
                    {
                        happinessLevel = happinessLevel - 190;
                        messagePrompt(" You played Poker throughout the night and gambled like a mad man.\n\n Although you lost " +
                                "$10,000, you didn't want to pay up, so the casino was getting ready to kick you out.\n\nNonetheless, you had your hired security with you and" +
                                " you were nicely asked to leave, despite losing them so much money.", 3000);
                        amIDeadYet("n/a");
                        return;
                    }
                    else {
                        healthRange = healthRange - 20;
                        happinessLevel = happinessLevel - 600;
                        netWorth = netWorth.subtract(new BigDecimal("10000.00"));

                        messagePrompt(" You played Poker throughout the night and gambled like a mad man.\n\n You lost " +
                                "over $10,000 and you were thrown out of the casino.\n\n<Unfortunately, you actually had enough Net Worth so no further " +
                                "consequence occurred. And I was getting excited too.>", 3500);
                        amIDeadYet("Lost too much money.");
                        return;
                    }

                }
            }

            amIDeadYet("Whatever goes to Vegas, stays in Vegas.");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionTravelWorld(View view) {
        if (luxuryCounter < 1) {
            messagePrompt("(LOCKED)", 500);
            return;
        }
        if (luxuryCounter < 2) {
            messagePrompt("You need to party in Las Vegas before traveling.", 500);
            return;
        }

        if (luxuryCounter2 < 21) {
            messagePrompt("You need to wait " + ((21 - luxuryCounter2) / 3) + " days before taking time some luxury time.", 500);
            return;
        }

        if (canIAffordIt("45000.00")) {
            if (luxuryCounter == 2)
                luxuryCounter++;
            luxuryCounter2 = 0;
            luxuryDrain = 0;
            statChanges(150, 5132, "45000.00");
            if (new Random().nextDouble() < .15) {
                if (hasSecurity == 1)
                {
                    messagePrompt(" Crazy events have unfolded.\n\nWhile sightseeing in the city, you were kidnapped by a drug cartel.\n\nFortunately, you" +
                            " had your hired security by your side, and the cartel members were not risking a gun fight.\n\nThey fled the scene.", 3500);
                    happinessLevel = happinessLevel - 400;
                    amIDeadYet("Had a heart attack.");
                    return;
                }
                else
                if (canIAffordIt("20000.00") == false && hasPartner == 1 && partnerKidnap == 0) {
                    messagePrompt(" Crazy events have unfolded. \n\nWhile sightseeing in the city, your partner was kidnapped by a drug cartel. They are " +
                            "looking for a $20,000 settlement." +
                            "\n\n<Their deal is simple. Obtain $20,000 in the next 10 days or your partner will be killed. Good luck.>", 3500);
                    happinessLevel = happinessLevel - 3500;
                    healthRange = healthRange - 50;
                    partnerKidnap = daysNotDead + 11;
                    amIDeadYet("Had a heart attack.");
                    return;
                } else
                if (canIAffordIt("20000.00") == false)
                {
                    messagePrompt(" Crazy events have unfolded. \n" +
                            "\n" +
                            "While sightseeing in the city, you were kidnapped by bandits.\n\nThey took all your money" +
                            " and beat you up, badly.", 2500);
                    happinessLevel = happinessLevel - 1000;
                    healthRange = healthRange - 600;
                    netWorth = netWorth.subtract(netWorth);
                    amIDeadYet("Kidnapped by the Cartel.");
                    return;
                }
                if (canIAffordIt("20000.00") == true)
                {
                    messagePrompt(" Crazy events have unfolded. \n" +
                            "\n" +
                            "While sightseeing in the city, you were kidnapped by bandits.\n\nThey took a lot of your money" +
                            " but luckily, you're fairly wealthy so you weren't harmed.", 2500);
                    happinessLevel = happinessLevel - 600;
                    if (netWorth.intValue()/2 > 20000)
                    netWorth = netWorth.divide(new BigDecimal("2.00"));
                    else
                    netWorth = netWorth.subtract(new BigDecimal("20000.00"));
                    amIDeadYet("Lost too much money.");
                    return;
                }
            }

                if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 300;
                healthRange = healthRange - 55;
                messagePrompt("'Nope, not done yet.'\n\n'Still a few pages left in my passport.'", 500);
                amIDeadYet("Got lost and died.");
                return;
            }
            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 300;
                healthRange = healthRange - 55;
                messagePrompt("'The hotel maids are so sweet.'\n\n'It's almost as if their lives depend on it!'", 500);
                amIDeadYet("Got lost and died.");
                return;
            }
            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 300;
                healthRange = healthRange - 55;
                messagePrompt("'Living in these exotic, dirt poor villages would be so peaceful.'\n\n'Just need to let my social media know all about it.'", 500);
                amIDeadYet("Got lost and died.");
                return;
            }
            amIDeadYet("Got lost and died.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionCar(View view) {
        if (luxuryCounter < 2) {
            messagePrompt("(LOCKED)", 500);
            return;
        }
        if (luxuryCounter < 3) {
            messagePrompt("You need to travel around the world before purchasing a luxury vehicle.", 500);
            return;
        }

        if (luxuryCounter2 < 21) {
            messagePrompt(" You need to wait " + ((21 - luxuryCounter2) / 3) + " days before taking time some luxury time.", 500);
            return;
        }

        if (canIAffordIt("120000.00")) {
            int firstTime = 0;
            if (luxuryCounter == 3) {
                luxuryCounter++;
                firstTime = 1;
            }
            luxuryCounter2 = 0;
            luxuryDrain = 0;
            statChanges(-200, 11469, "120000.00");

            if (new Random().nextDouble() < 0.4 && isEducated == 2 && jobCEOReference == 0) {
                messagePrompt(" As you were admiring the expensive vehicles, you come across Mr. Winston, the chief" +
                        " executive for the security division in the " +
                        "company you work for. \n\nYou make acquaintances with your newfound connection and " +
                        "they are noticeably impressed with your aptitude for business and clandestinity.", 5000);
                jobCEOReference = 1;
                happinessLevel = happinessLevel + 1400;
                amIDeadYet("n/a");
                return;
            }
            else if (new Random().nextDouble() == .20 && hasSecurity == 0)
            {
                if (firstTime == 1)
                {
                    messagePrompt("You purchased your first luxury car: a shiny and sleek black model, perfect for racing.\n\n" +
                            "However! (!) Complications arose.\n\nYour expensive car has been hijacked by a band of high class" +
                            " criminals. With no hired security and the car show " +
                            "concluding that shipping is not their responsibility, your car will forever be lost.", 4000);
                    happinessLevel = happinessLevel - 9500;
                    luxuryCounter = 3;
                    return;
                }
                else
                {
                    messagePrompt("You purchased another luxury car to add to your impressive collection.\n\n" +
                            "However! (!) Complications arose.\n\nYour expensive car has been hijacked by a band of high class" +
                            " criminals. With no hired security and the car show " +
                            "concluding that shipping is not their responsibility, your car will forever be lost.", 4000);
                }
            }
            else if (firstTime == 1)
            {
                if (hasSecurity == 1)
                messagePrompt("Rows of well-dressed upperclassmen encircled the expensive car show.\n\nYou " +
                        "purchased your first luxury car: a shiny and sleek black model, perfect for racing.\n\nYour hired security makes sure" +
                        " the car is brought to you safely and without complications.", 3500);
                else
                    messagePrompt("Rows of well-dressed upperclassmen encircled the expensive car show.\n\nYou " +
                            "purchased your first luxury car: a shiny and sleek black model, perfect for racing.", 3500);
            }
            else
            {
                if (hasSecurity == 1)
                messagePrompt("You purchase another expensive vehicle. Why not add even more luxury cars to your arsenal?\n\n" +
                        "Your hired security ensures that the car is brought to you safely and without complications.", 3500);
                else
                    messagePrompt("You purchase another expensive vehicle. Why not add even more luxury cars to your arsenal?", 2500);

            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionSpace(View view) {
        if (luxuryCounter < 3) {
            messagePrompt("(LOCKED)", 500);
            return;
        }
        if (luxuryCounter < 4) {
            messagePrompt(" You need to purchase an expensive automobile before going into the cosmos.", 500);
            return;
        }

        if (luxuryCounter2 < 21) {
            messagePrompt(" You need to wait " + ((21 - luxuryCounter2) / 3) + " days before taking time some luxury time.", 500);
            return;
        }

        if (canIAffordIt("400000.00") == false) {
            messagePrompt("You cannot afford that.", 500);
            return;
        }

        if (luxuryCounter == 4)
            luxuryCounter++;

        luxuryCounter2 = 0;
        statChanges(-450, 30501, "400000.00");

        if (new Random().nextDouble() < 0.30 && isEducated == 2 && jobCEOReference == 0) {

            messagePrompt(" You were drinking some cocktails at the bar and merely by chance, you meet Mr. Ricardo, " +
                    "a senior executive, from the " +
                    "company you work for.\n\n You make acquaintances with your new-found connection and " +
                    "they tell you they're impressed with your business foresight. \n\nMaybe, he'll tell the CEO about you.", 7000);
            jobCEOReference = 1;
            happinessLevel = happinessLevel + 3000;
            amIDeadYet("The shuttle crashed.");
            return;
        }
        if (new Random().nextDouble() < .08) {
            happinessLevel = happinessLevel + 500;
            healthRange = healthRange - 100;
            messagePrompt("'Now, if you look to your right here we can see remnants of the flying space junk that orbits the planet.'\n\n'It is our annual tradition to add more junk onto that pile.'", 1200);
            amIDeadYet("The shuttle crashed.");
            return;
        }
        if (new Random().nextDouble() < .08) {
            happinessLevel = happinessLevel + 500;
            healthRange = healthRange - 100;
            messagePrompt("'If our Sun were to spontaneously explode, it would take 8 minutes for its effects to reach us!'\n\n'That gives us plenty of time to check on our virtual crop farms.'", 1200);
            amIDeadYet("The shuttle crashed.");
            return;
        }
        amIDeadYet("The shuttle crashed.");
        if (amIDead() == false && daysNotDead % 7 != 0)
            amIOkayYet();
    }

    public void functionMansion(View view) {
        if (luxuryCounter < 4) {
            messagePrompt("(LOCKED)", 500);
            return;
        }
        if (luxuryCounter < 5) {
            messagePrompt("You need to take a trip on your favorite rocket ship before purchasing a mansion.", 500);
            return;
        }

        if (isMarried == 0) {
            messagePrompt("You must be married before purchasing a mansion.", 500);
            return;
        }

        if (luxuryCounter2 < 21) {
            messagePrompt("You need to wait " + ((21 - luxuryCounter2) / 3) + " days before taking time some luxury time.", 500);
            return;
        }

        if (canIAffordIt("1250000.00")) {
            if (luxuryCounter == 5)
                luxuryCounter++;
            luxuryCounter2 = 0;
            luxuryDrain = 0;
            statChanges(-800, 75928, "1250000.00");
            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel - 500;
                healthRange = healthRange - 100;
                messagePrompt("'Wow, this mansion dates back to the 16th century.'\n\n<Doesn't that make you want to foolishly investigate " +
                        "its strange noises?>", 1200);
                amIDeadYet("Your mansion collapsed.");
                return;
            }
            amIDeadYet("Your mansion collapsed.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionYacht(View view) {
        if (luxuryCounter < 5) {
            messagePrompt("(LOCKED)", 500);
            return;
        }
        if (luxuryCounter < 6) {
            messagePrompt("You need to own a mansion before buying out an ocean yacht.", 500);
            return;
        }

        if (luxuryCounter2 < 21) {
            messagePrompt(" You need to wait " + ((21 - luxuryCounter2) / 3) + " days before taking time some luxury time.", 500);
            return;
        }

        if (canIAffordIt("3000000.00")) {
            if (luxuryCounter == 6)
                luxuryCounter++;
            luxuryCounter2 = 0;
            luxuryDrain = 0;
            statChanges(-1500, 145746, "3000000.00");
            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel + 700;
                healthRange = healthRange - 300;
                messagePrompt("'You're on a boat. You're on a boat.'\n\n<Everybody, look at you, 'cause you're sailing on a boat.>", 1200);
                amIDeadYet("Got lost in the Bermuda Triangle.");
                return;
            }
            amIDeadYet("Got lost in the Bermuda Triangle.");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionToppleGovernment(View view) {
        if (luxuryCounter < 6) {
            messagePrompt("(LOCKED)", 500);
            return;
        }
        if (luxuryCounter < 7) {
            messagePrompt(" You need to sail a class yacht before plotting a shift of power.", 500);
            return;
        }

        if (luxuryCounter2 < 21) {
            messagePrompt(" You need to wait " + ((21 - luxuryCounter2) / 3) + " days before taking time some luxury time.", 500);
            return;
        }

        if (canIAffordIt("8000000.00")) {
            if (luxuryCounter == 7)
                luxuryCounter++;
            luxuryCounter2 = 0;
            luxuryDrain = 0;
            statChanges(-3500, 311225, "8000000.00");
            if (new Random().nextDouble() < .13) {
                happinessLevel = happinessLevel + 700;
                healthRange = healthRange - 300;
                messagePrompt("'It's my money and I'm using it for my own gains. I don't see the harm.'", 1200);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < .13) {
                happinessLevel = happinessLevel + 700;
                healthRange = healthRange - 300;
                messagePrompt("<'You're not corrupting the government. You are offering generous donations for their hard work.'>", 1200);
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < .13) {
                happinessLevel = happinessLevel + 700;
                healthRange = healthRange - 300;
                messagePrompt("'It's survival of the fittest. I'm just trying to survive by not suffocating in lobbyist contributions.'", 1200);
                amIDeadYet("n/a");
                return;
            }
            else if (hasSecurity == 0)
            {
                deathCounter = 3;
                happinessLevel = 0;
                healthRange = 0;
                messagePrompt("Well, I have good news and bad news.\n\nGood news: Your plan came to fruition.\n\nBad news: You have been " +
                        "captured by guerilla rebels. Since you did not have hired security, you were assassinated.", 3000);
                amIDeadYet("Didn't have protection.");
                return;
            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0)
                amIOkayYet();
        } else
            messagePrompt("You cannot afford that.", 500);
    }


    public void functionWinTheGame(View view) {
        if (luxuryCounter < 7) {
            messagePrompt("(LOCKED)", 500);
            return;
        }
        if (luxuryCounter < 8) {
            messagePrompt(" You need to commit political bribery before winning the game.", 500);
            return;
        }

        if (luxuryCounter2 < 21) {
            messagePrompt("You need to wait " + ((21 - luxuryCounter2) / 3) + " days before winning the game.", 500);
            return;
        }

        if (canIAffordIt("15000000.00") == false) {
            messagePrompt("<You cannot afford to win the game. Yet.>", 500);
            return;
        }

        hasWon = 1;
        statChanges(healthDrain, happinessDrain, "0.00");
        if (daysNotDead > highScore) {
            highScore = daysNotDead;
            messagePrompt(" <Oh my 'Me'. You did it. You actually did it. You f***ing beat my game.> \n\n<Congratulations, you are a God amongst humankind. I am literally in tears. What are you going to do with your life, now?>\n\n (NEW) HIGHSCORE: " + highScore, 8000);
        } else
            messagePrompt(" <Oh my 'Me'. Way to f***ing beat my game... again. You must feel accomplished.> \n\n<Congratulations... yadda yadda yadda... What are you going to do with your life, now?>\n" +
                    "\n HIGHSCORE: " + highScore, 8000);

        resetStats();
        return;

    }


    // ----------------------------------- LOVE ---------------------------------

    public void functionDinerDate(View view) {
        if (hasPartner == 0)
        {
            messagePrompt("You are single.", 500);
            return;
        }
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before going on another date.", 500);
            return;
        }

        if (canIAffordIt("350.00")) {
            loveCounter2 = 0;
            statChanges(10, 55, "350.00");
            loveDrain = 0;
            loveCounter = 0;

            if (new Random().nextDouble() < 0.07 && isMarried == 0 && isEngaged == 0) {
                messagePrompt(" The date went terribly. \n\nThe food sucked and your partner thought you weren't the perfect " +
                        "individual that the movies painted a picture of. \n\nYou've been dumped.", 3500);
                //healthDrain = healthDrain + 3;
                happinessLevel = happinessLevel - 50;
                hasPartner = 0;
                isEngaged = 0;
                isMarried = 0;
                amIDeadYet("Your partner dumped you.");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I don't have a dirty mind, I have a sexy imagination.'", 1400);
                happinessLevel = happinessLevel + 4;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I'm actually a very nice person, until you piss me off'", 1400);
                happinessLevel = happinessLevel - 2;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I'm sorry for what I said when I was hungry.'", 1400);
                happinessLevel = happinessLevel + 2;
                amIDeadYet("n/a");
                return;
            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt("You cannot afford that.", 500);
    }

    public void functionRestaurantDate(View view) {
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before going on another date.", 500);
            return;
        }
        if (hasPartner == 0)
        {
            messagePrompt("You are single.", 500);
            return;
        }

        if (canIAffordIt("2000.00")) {
            loveCounter = 0;
            loveCounter2 = 0;
            statChanges(30, 276, "2000.00");
            loveDrain = 0;
            if (new Random().nextDouble() < 0.07 && isMarried == 0 && isEngaged == 0) {
                messagePrompt(" The date went terribly. \n\nThe food sucked and your partner thought you weren't the perfect " +
                        "individual that the movies painted a picture of. \n\nYou've been dumped.", 3500);
                //healthDrain = healthDrain + 3;
                happinessLevel = happinessLevel - 250;
                hasPartner = 0;
                isEngaged = 0;
                isMarried = 0;
                amIDeadYet("Your partner dumped you.");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I don't have a dirty mind, I have a sexy imagination.'", 2500);
                happinessLevel = happinessLevel + 7;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I'm actually a very nice person, until you piss me off'", 2500);
                happinessLevel = happinessLevel - 4;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I'm sorry for what I said when I was hungry.'", 2500);
                happinessLevel = happinessLevel + 3;
                amIDeadYet("n/a");
                return;
            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt("You cannot afford that.", 500);

    }

    public void functionCampingDate(View view) {
        if (loveCounter < 42) {
            messagePrompt("You need to wait " + ((44 - loveCounter) / 3) + " days before going on another date.", 500);
            return;
        }

        if (canIAffordIt("10000.00")) {
            loveCounter = 0;
            loveCounter2 = 0;
            statChanges(120, 1142, "10000.00");
            loveDrain = 0;
            if (new Random().nextDouble() < 0.05 && isMarried == 0 && isEngaged == 0) {
                messagePrompt("The date went terribly. \n\nYou got into an argument and your partner stormed out" +
                        "of your tent. \n\n<A wild grizzly bear then attacked your partner. They died.>\n\n You've been dumped.", 5000);
                healthDrain = healthDrain - 5;
                happinessLevel = happinessLevel - 1500;
                hasPartner = 0;
                isEngaged = 0;
                isMarried = 0;
                amIDeadYet("Your partner dumped you.");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I don't have a dirty mind, I have a sexy imagination.'", 1300);
                happinessLevel = happinessLevel + 20;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I'm actually a very nice person, until you piss me off'", 1300);
                happinessLevel = happinessLevel - 10;
                amIDeadYet("n/a");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I'm sorry for what I said when I was hungry.'", 1300);
                happinessLevel = happinessLevel + 8;
                amIDeadYet("n/a");
                return;
            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt("You cannot afford that.", 500);

    }

    public void functionRoadTripDate(View view) {
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before going on another date.", 500);
            return;
        }

        if (canIAffordIt("40000.00")) {
            loveCounter2 = 0;
            statChanges(200, 3964, "40000.00");
            loveCounter = 0;
            loveDrain = 0;
            messagePrompt("What a romantic way to get kidnapped.", 1200);
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt("You cannot afford that.", 500);

    }

    public void functionWineCruise(View view) {
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before going on another date.", 500);
            return;
        }

        if (canIAffordIt("120000.00")) {
            loveCounter2 = 0;
            statChanges(450, 9855, "120000.00");
            loveCounter = 0;
            loveDrain = 0;
            messagePrompt("If the wine hasn't lived through World War II, it's not ripe enough.", 1200);
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt("You cannot afford that.", 500);

    }

    public void functionPrivateIsland(View view) {
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before going on another date.", 500);
            return;
        }

        if (canIAffordIt("250000.00")) {
            loveCounter2 = 0;
            statChanges(-300, 18011, "250000.00");
            loveCounter = 0;
            loveDrain = 0;
            if (new Random().nextDouble() < 0.15 && isEngaged == 0) {
                isEngaged = 1;
                messagePrompt("You've been waiting for the magic moment. As the sunset slowly started to " +
                        "creep in, and the sky fades into a pinkish hue,\n\n You pull out" +
                        " a ring and say, 'Marry me!'. Your partners overcomes the shock, replies 'Yes!' and" +
                        " you kiss under the moonlit dawn.\n\nYou are now engaged.", 3500);
                happinessLevel = happinessLevel + 5000;
                healthRange = healthRange + 300;
                amIDeadYet("n/a");
                return;
            } else if (new Random().nextDouble() < 0.15 && hasSecurity == 0)
            {
                messagePrompt("A series of unfortunate events have occurred.\n\nUnfortunately, the private island " +
                        "for which you rented out has not been thoroughly checked, and as it turns out, there lives a serial killer " +
                        "in a quiet cabin deep in the forest.\n\nYou did not have hired security with you, and your partner was murdered." +
                        "Luckily, you got away in time.", 5000);
                happinessLevel = happinessLevel - 14000;
                healthRange = healthRange - 250;
                hasPartner = 0;
                isMarried = 0;
                isEngaged = 0;
                amIDeadYet("n/a");
                return;
            }
            else
            {
                messagePrompt("It's like Lord of the Flies but less boys, and more whiskey.", 1200);
            }
            amIDeadYet("n/a");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt("You cannot afford that.", 500);

    }

    public void functionMarriage(View view) {
        if (isEngaged == 0) {
            messagePrompt(" You need to be engaged with your partner prior to marrying them.", 500);
            return;
        }
        if (isMarried == 1) {
            messagePrompt("You're already married, you buffoon.", 500);
            return;
        }
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before executing such a feat.", 500);
            return;
        }

        if (canIAffordIt("600000.00") == true) {
            loveCounter2 = 0;
            isMarried = 1;
            loveDrain = 0;
            statChanges(-700, 35268, "600000.00");
            messagePrompt(" <Why would you set your life up for failure?> \n\nYou are now married, congratulations!\n\nYour Happiness drain increases.", 3000);

            amIDeadYet("Heart attack from realizing what you have just done.");

            happinessDrain = happinessDrain + 75;
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else {
            messagePrompt("You cannot afford marriage at this time.", 500);
        }

    }

    public void functionFamily(View view) {
        if (isMarried != 1) {
            messagePrompt("You aren't married yet, you buffoon.", 500);
            return;
        }
        if (luxuryCounter < 6)
        {
            messagePrompt("You need to own a mansion before starting a family.", 700);
            return;
        }
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before pursuing a family.", 500);
            return;
        }

        if (canIAffordIt("1500000.00") == true) {
            int firstTime = 0;
            if (luxuryCounter == 6)
            {
                luxuryCounter++;
                firstTime = 1;
            }
            loveCounter2 = 0;
            loveDrain = 0;
            statChanges(-2200, 74527, "1500000.00");
            amIDeadYet("Heart attack from realizing what you have just done.");
            if (firstTime == 1) {
                messagePrompt(" <Children are the rotten fruit of this planet.>\n\n<Oh well, it's your problem now.>\n\nYour Health drain increases.", 2000);
                healthDrain = healthDrain + 150;
            }
            else
            {
                messagePrompt(" <Geez, even more kids.>\n\n <Stop overpopulating the planet you swine.>", 2000);
            }
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else {
            messagePrompt("You cannot afford marriage at this time.", 500);
        }

    }


//--------------------------------------- M I S C. ---------------------------------------

    //This function checks to see if the user is cheating
    public Boolean cheatingChecker() {

        if (cheatingCounter == 15 || cheatingCounter == 30 || cheatingCounter == 45) {
            return true;
        } else return false;
    }

    //This function gets called when the user is found to be cheating
    public void cheatingResult(int day) {
        if (cheatingCounter == 15) {
            if (day == 1) {
                messagePrompt(" <Be careful coming so close to death. Do not abuse the system I have set up for you.>\n\n<Consider yourself warned.>\n\n" +
                        "You have 16 hours left to live.", 3000);
                //netWorth.subtract(new BigDecimal("500.00"));
                return;
            } else {
                messagePrompt(" <Be careful coming so close to death. Do not abuse the system I have set up for you.>\n\n<Consider yourself warned.>\n\n" +
                        "You have 8 hours left to live. This is your last chance.", 3500);
                //netWorth.subtract(new BigDecimal("500.00"));
                return;
            }
        }
        if (cheatingCounter == 30) {
            if (day == 1) {
                if (canIAffordIt("1000.00")) {
                    messagePrompt(" <You play me for a fool? Do not meddle with death, peasant.>\n\n<I have taken 1000$ from your Net Worth.>\n\n" +
                            "You have 16 hours left to live.", 3000);
                    netWorth = netWorth.subtract(new BigDecimal("1000.00"));
                    return;
                } else {
                    messagePrompt(" <You play me for a fool? Do not meddle with death, peasant.>\n\n<I have taken 100 from your Health.>\n\n" +
                            "You have 16 hours left to live.", 3000);
                    healthRange = healthRange - 100;
                    if (healthRange < -5)
                        healthRange = -5;
                    return;
                }
            } else {
                if (canIAffordIt("1000.00")) {
                    messagePrompt(" <You play me for a fool? Do not meddle with death, peasant.>\n\n<I have taken 1000$ from your Net Worth.>\n\n" +
                            "You have 8 hours left to live. This is your last chance.", 3500);
                    netWorth = netWorth.subtract(new BigDecimal("1000.00"));
                    return;
                } else {
                    messagePrompt(" <You play me for a fool? Do not meddle with death, peasant.>\n\n<I have taken 100 from your Health.>\n\n" +
                            "You have 8 hours left to live. This is your last chance.", 3500);
                    healthRange = healthRange - 100;
                    if (healthRange < -5)
                        healthRange = -5;
                    return;
                }
            }
        }
        if (cheatingCounter == 45) {
            if (day == 1) {
                if (isEducated == 1) {
                    messagePrompt(" <Again, you dance with me in a tango of fates. You forget that I am the one in control of fate, not you.>\n\n<Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree.>\n\n" +
                            "You have 16 hours left to live.", 3500);
                    collegeClassesTaken = collegeClassesTaken - 2;
                    return;
                }
                if (isEducated == 2) {
                    messagePrompt(" <Again, you dance with me in a tango of fates. You forget that I am the one in control, not you.>\n\n<Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree.>\n\n" +
                            "You have 16 hours left to live.", 3500);
                    gradClassesTaken = gradClassesTaken - 2;
                    return;
                }
                if (isEducated == 3) {
                    messagePrompt(" <Again, you dance with me in a tango of fates. You forget that I am the one in control, not you.>\n\n<Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree.>\n\n" +
                            "You have 16 hours left to live.", 3500);
                    postGradClassesTaken = postGradClassesTaken - 2;
                    return;
                }
            } else {
                if (isEducated == 1) {
                    messagePrompt(" <Again, you dance with me in a tango of fates. You forget that I am the one in control, not you.>\n\n<Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree.>\n\n" +
                            "You have 8 hours left to live. This is your last chance.", 3500);
                    collegeClassesTaken = collegeClassesTaken - 2;
                    return;
                }
                if (isEducated == 2) {
                    messagePrompt(" <Again, you dance with me in a tango of fates. You forget that I am the one in control, not you.>\n\n<Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree.>\n\n" +
                            "You have 8 hours left to live. This is your last chance.", 3500);
                    gradClassesTaken = gradClassesTaken - 2;
                    return;
                }
                if (isEducated == 3) {
                    messagePrompt(" <Again, you dance with me in a tango of fates. You forget that I am the one in control, not you.>\n\n<Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree.>\n\n" +
                            "You have 8 hours left to live. This is your last chance.", 3500);
                    postGradClassesTaken = postGradClassesTaken - 2;
                    return;
                }
            }
        }
    }

    //This function checks if the user is dead yet

    public void amIDeadYet(String reason) {
        netWorth = netWorth.add(new BigDecimal("0.00"));
        if (difficulty <= 1) {
            if (daysNotDead > 280) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 30;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 30;
                }
            } else if (daysNotDead > 266) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 30;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 30;
                }
            } else if (daysNotDead > 252) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 24;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 24;
                }
            } else if (daysNotDead > 224) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 16;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 16;
                }
            } else if (daysNotDead > 210) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 16;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 16;
                }
            } else if (daysNotDead > 182) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 14;

                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 14;
                }
            } else if (daysNotDead > 154) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 12;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 12;
                }
            } else if (daysNotDead > 126) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 10;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 10;
                }
            } else if (daysNotDead > 112) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 7;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 7;
                }
            } else if (daysNotDead > 98) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 7;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 7;
                }
            } else if (daysNotDead > 84) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 5;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 5;
                }
            } else if (daysNotDead > 70) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 4;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 4;
                }
            } else if (daysNotDead > 56) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 3;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 3;
                }
            } else if (daysNotDead > 42) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 3;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 3;
                }
            } else if (daysNotDead > 28) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 3;

                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 3;
                }
            } else if (daysNotDead > 14) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 2;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 2;
                }
            } else {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 1;

                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 1;
                }
            }
        }
        if (difficulty == 3 || difficulty == 2)
        {
            if (daysNotDead > 266) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 37;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 37;
                }
            } else if (daysNotDead > 238) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 37;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 37;
                }
            } else if (daysNotDead > 224) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 37;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 37;
                }
            } else if (daysNotDead > 210) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 34;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 34;
                }
            } else if (daysNotDead > 182) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 32;

                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 32;
                }
            } else if (daysNotDead > 168) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 26;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 26;
                }
            } else if (daysNotDead > 154) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 22;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 22;
                }
            } else if (daysNotDead > 140) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 18;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 18;
                }
            } else if (daysNotDead > 126) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 16;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 16;
                }
            } else if (daysNotDead > 112) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 14;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 14;
                }
            } else if (daysNotDead > 98) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 12;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 12;
                }
            } else if (daysNotDead > 84) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 9;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 9;
                }
            } else if (daysNotDead > 70) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 7;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 7;
                }
            } else if (daysNotDead > 56) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 5;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 5;
                }
            } else if (daysNotDead > 42) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 4;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 4;
                }
            } else if (daysNotDead > 28) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 3;

                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 3;
                }
            } else if (daysNotDead > 14) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 2;
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 2;
                }
            } else {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    happinessDrain = happinessDrain + 1;

                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 1;
                }
            }
        }
        int dM = 0;

        if (amIDead() == true) {
            if (healthRange < -5)
                healthRange = -5;
            if (happinessLevel < -5)
                happinessLevel = -5;
            deathCounter++;
            if (deathCounter == 1) {
                messagePrompt("You have one day left to live.", 600);
            } else if (deathCounter == 2) {
                cheatingCounter++;
                if (cheatingChecker()) {
                    cheatingResult(1);
                } else
                    messagePrompt("You have 16 hours left to live.", 701);
            } else if (deathCounter == 3) {
                cheatingCounter++;
                if (cheatingChecker()) {
                    cheatingResult(2);
                } else
                        messagePrompt("You have 8 hours left to live. \n\n<This is your last chance.>", 1200);
            } else if (deathCounter > 3) {
                if (respawnToken == 0) {
                    if (reason.equals("n/a"))
                    {
                        if (healthRange < 0 && happinessLevel < 0)
                            reason = new String("Chronic suffering and poor health.");
                        else if (healthRange < 0)
                            reason = new String("Poor health.");
                        else
                            reason = new String("Chronic depression.");
                    }
                    if (daysNotDead > highScore) {
                        messagePrompt(" You killed yourself after surviving " + daysNotDead + " days. But hey, it's the longest you've lived thus far." +
                                " \n\nReason: " + reason + "\n\n(NEW) HIGHSCORE: " + daysNotDead + " ", 2500);
                        dM = 1;
                        highScore = daysNotDead;
                        deathCounter = 0;
                        resetStats();
                        ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();

                    } else if (daysNotDead > 100) {
                        messagePrompt(" You killed yourself after surviving " + daysNotDead + " days. You're definitely getting a grip on life, but you just need a bit more practice." +
                                " \n\nReason: " + reason + "\n\nHIGHSCORE: " + highScore, 2500);
                        dM = 1;
                        deathCounter = 0;
                        resetStats();
                        ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();

                    } else if (daysNotDead > 50) {
                        messagePrompt(" You killed yourself after surviving " + daysNotDead + " days. You're getting better, but I am still too much of a match for you." +
                                "  \n\nReason: " + reason + "\n\nHIGHSCORE: " + highScore, 2500);
                        dM = 1;
                        deathCounter = 0;
                        resetStats();
                        ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();

                    } else {
                        messagePrompt(" You killed yourself after surviving " + daysNotDead + " days. That was a pathetic attempt at living." +
                                "  \n\nReason: " + reason + "\n\nHIGHSCORE: " + highScore, 2500);
                        dM = 1;
                        deathCounter = 0;
                        resetStats();
                        ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();
                    }
                } else  if (difficulty != 3){
                    messagePrompt("Congratulations, you killed yourself. But by your Respawn Tokens and the" +
                            " grace of myself, you were given another chance at life. \n\nReason: " + reason + "\n\nYour health and happiness drain is halved.", 3500);
                    healthDrain = healthDrain / 2;
                    happinessDrain = happinessDrain / 2;
                    if (daysNotDead < 45 || daysNotDead > 55) {
                        if (mInterstitialAd.isLoaded())
                            mInterstitialAd.show();
                        else if (mInterstitialAd2.isLoaded()) {
                            mInterstitialAd2.show();
                        }
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        mInterstitialAd2.loadAd(new AdRequest.Builder().build());
                    }
                    if (daysNotDead > 300) {
                        happinessLevel = 755;
                        healthRange = 755;
                        ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();
                        updateVariables();
                        updateStockVariables();
                    }
                    if (daysNotDead > 200) {
                        happinessLevel = 250;
                        healthRange = 250;
                        ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();
                        updateVariables();
                        updateStockVariables();
                    } else {
                        happinessLevel = 90;
                        healthRange = 90;
                        ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();
                        updateVariables();
                        updateStockVariables();
                    }
                    deathCounter = 0;
                    respawnToken--;
                    if (respawnToken < 0)
                        respawnToken = 0;

                }
            }
        } else {
            deathCounter = 0;
        }
        if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0 && dM != 1)
            updateStatus();
        updateVariables();
        updateStockVariables();
        ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
        if (outputStocks().equals(new BigDecimal("0.00")))
            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
        else
            ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

        ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
        updateHealthAndHappiness();
    }

    public void amIOkayYet() {
        if (happinessLevel > 45 && healthRange > 45)
            popupCounter1 = 1;
        if (happinessLevel > 50)
            popupCounter3 = 1;
        if (healthRange > 50)
            popupCounter2 = 1;
        if (daysNotDead >= 30) {
            if (happinessLevel < 15 && healthRange < 15 && popupCounter1 == 1) {
                popupCounter1 = 0;
                messagePrompt(" Your health and happiness are both low. \n\nYou are both sick and depressed. ", 1000);
                return;
            } else if (healthRange < 14 && popupCounter2 == 1) {
                popupCounter2 = 0;
                if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nYour body is giving up on you.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nWell, at least your mind isn't giving up on you.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nGet off the couch and onto the treadmill.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nBut it's okay, we all have issues.", 1000);
                } else
                    messagePrompt("Your health is low. \n\nYou need some help.", 1000);
                return;
            } else if (happinessLevel < 14 && popupCounter3 == 1) {
                popupCounter3 = 0;
                if (new Random().nextDouble() < 0.30 && hasPartner == 0) {
                    messagePrompt("Your happiness is low. \n\nYou need to get a partner or something.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nBut don't worry, it can only get worse from here.", 1000);
                }
                else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nHey, you've got crippling depression!", 1000);
                }
                else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nCheer up, mate. It's just a game.", 1000);
                }
                else
                    messagePrompt("Your happiness is low. \n\nYou need to stop hating yourself.", 1000);
                return;
            }
        } else if (daysNotDead >= 45) {
            if (happinessLevel < 25 && healthRange < 25 && popupCounter1 == 1) {
                popupCounter1 = 0;
                messagePrompt(" Your health and happiness are both low. \n\nYou are both sick and depressed. ", 1000);
                return;
            } else if (healthRange < 24 && popupCounter2 == 1) {
                popupCounter2 = 0;
                if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nYour body is giving up on you.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nWell, at least your mind isn't giving up on you.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nGet off the couch and onto the treadmill.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nBut it's okay, we all have issues.", 1000);
                } else
                    messagePrompt("Your health is low. \n\nYou need some help.", 1000);
                return;
            } else if (happinessLevel < 24 && popupCounter3 == 1) {
                popupCounter3 = 0;
                if (new Random().nextDouble() < 0.30 && hasPartner == 0) {
                    messagePrompt("Your happiness is low. \n\nYou need to get a partner or something.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nBut don't worry, it can only get worse from here.", 1000);
                }
                else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nHey, you've got crippling depression!", 1000);
                }
                else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nCheer up, mate. It's just a game.", 1000);
                }
                else
                    messagePrompt("Your happiness is low. \n\nYou need to stop hating yourself.", 1000);
                return;
            }
        } else if (daysNotDead >= 75) {
            if (happinessLevel < 35 && healthRange < 35 && popupCounter1 == 1) {
                popupCounter1 = 0;
                messagePrompt(" Your health and happiness are both low. \n\nYou are both sick and depressed. ", 1000);
                return;
            } else if (healthRange < 34 && popupCounter2 == 1) {
                popupCounter2 = 0;
                if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nYour body is giving up on you.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nWell, at least your mind isn't giving up on you.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nGet off the couch and onto the treadmill.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nBut it's okay, we all have issues.", 1000);
                } else
                    messagePrompt("Your health is low. \n\nYou need some help.", 1000);
                return;
            } else if (happinessLevel < 34 && popupCounter3 == 1) {
                if (new Random().nextDouble() < 0.30 && hasPartner == 0) {
                    messagePrompt("Your happiness is low. \n\nYou need to get a partner or something.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nBut don't worry, it can only get worse from here.", 1000);
                }
                else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nHey, you've got crippling depression!", 1000);
                }
                else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nCheer up, mate. It's just a game.", 1000);
                }
                else
                    messagePrompt("Your happiness is low. \n\nYou need to stop hating yourself.", 1000);
                return;
            }
        } else {
            if (happinessLevel < 9 && healthRange < 9 && popupCounter1 == 1) {
                popupCounter1 = 0;
                messagePrompt(" Your health and happiness are both low. \n\nYou are both sick and depressed. ", 1000);
                return;
            } else if (healthRange < 8 && popupCounter2 == 1) {

                popupCounter2 = 0;
                if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nYour body is giving up on you.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nWell, at least your mind isn't giving up on you.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nGet off the couch and onto the treadmill.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your health is low. \n\nBut it's okay, we all have issues.", 1000);
                } else
                    messagePrompt("Your health is low. \n\nYou need some help.", 1000);
                return;
            } else if (happinessLevel < 8 && popupCounter3 == 1) {
                popupCounter3 = 0;
                if (new Random().nextDouble() < 0.30 && hasPartner == 0) {
                    messagePrompt("Your happiness is low. \n\nYou need to get a partner or something.", 1000);
                } else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nBut don't worry, it can only get worse from here.", 1000);
                }
                else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nHey, you've got crippling depression!", 1000);
                }
                else if (new Random().nextDouble() < 0.30) {
                    messagePrompt("Your happiness is low. \n\nCheer up, mate. It's just a game.", 1000);
                }
                else
                messagePrompt("Your happiness is low. \n\nYou need to stop hating yourself.", 1000);
                return;
            }
        }

    }

    // This function displays a message to user that reads the String message

    public void messagePrompt(String message, long delay) {

        delay = delay * (long)0.8;
        AlertDialog.Builder popupBuilder = new AlertDialog.Builder(this);
        TextView myMsg = new TextView(this);
        //TextView tv2 = (TextView)findViewById(R.id.textView2);
        Typeface OswRegular = Typeface.createFromAsset(getAssets(), "fonts/Odin Rounded - Regular.otf");
        myMsg.setTypeface(OswRegular);
        myMsg.setTextSize(25);
        //myMsg.setTitle("You killed yourself");
        myMsg.setText(message);
        myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
        popupBuilder.setView(myMsg);
        final AlertDialog dialog = popupBuilder.show();
        //dialog.setCancelable(false);
        if (delay > 0) {
            dialog.setCancelable(false);
            final Timer timer2 = new Timer();
            timer2.schedule(new TimerTask() {
                public void run() {
                    dialog.setCancelable(true);
                    timer2.cancel(); //this will cancel the timer of the system
                }
            }, delay);
        }
        //dialog.setCancelable(true);


    }

    /* This function calculates the taxes. */
    public void taxAlgorithm() {
        BigDecimal taxOfEarnings = totalEarned.multiply(new BigDecimal(".01"));
        BigDecimal taxAmount = taxOfEarnings;

        BigDecimal taxOfAssets = outputStocks().multiply(new BigDecimal(".06"));
        taxAmount = taxAmount.add(taxOfAssets);

        BigDecimal taxOfNetWorth = netWorth.multiply(new BigDecimal(".15"));
        taxAmount = taxAmount.add(taxOfNetWorth);

        taxOfEarnings = taxOfEarnings.setScale(2, RoundingMode.CEILING);
        taxOfAssets = taxOfAssets.setScale(2, RoundingMode.CEILING);
        taxOfNetWorth = taxOfNetWorth.setScale(2, RoundingMode.CEILING);
        taxAmount = taxAmount.setScale(2, RoundingMode.CEILING);

        if (taxAmount.compareTo(netWorth) >= 1)
        {
            taxCollector = 1;
            taxCollection = taxAmount.subtract(netWorth);
            taxCollection = taxCollection.setScale(2, RoundingMode.CEILING);
            messagePrompt("Unfortunately, you could not afford your taxes from your spendable Net Worth.\n\n" +
                    "<I have taken $" + netWorth.toString() + " from your account.>\n\n" +
                    "But, you are still $" + taxCollection.toString() + " in debt.\n\n<In 30 days, the tax collector will be back." +
                    " If you cannot pay up, you will go to prison (death or Respawn Token).>", 4000);
            taxCollector = 1;
            netWorth = netWorth.subtract(netWorth);
        }

        messagePrompt("<TAX SEASON DAY " + daysNotDead + ">" +
                "\n\nTotal earnings: $" + totalEarned.toString() + "  ($" + taxOfEarnings.toString() + " taxed [1.00%])" +
                "\n\nTotal Net Worth: $" + netWorth.toString() + "   ($" + taxOfNetWorth.toString() + " taxed [15.00%])" +
                "\n\nTotal assets: $" + outputStocks().toString() + "   ($" + taxOfAssets.toString() + " taxed [6.00%])" +
                "\n\n\nTotal taxes: $" + taxAmount.toString(), 5000);

        netWorth = netWorth.subtract(taxAmount);


    }

    /* This functions changes the in-game stats. HealthChange changes the health, HappinessChange
       changes the happiness level accordingly. It also updates the daysNotDeadCycle to increase
       the Days Without Dying counter since every 3 functions, 1 day is added to not being dead
       given as long as the user is not dead
       Cost is the amount of money the function costs/produces represented by a numerical value
       in String format ex. "15.00" */

    public void statChanges(int healthChange, int happinessChange, String cost) {


        if (canIAffordIt(cost) == false) //if the user cannot afford the function
        {
            messagePrompt("You cannot afford that.", 500);
            return;
        }
        BigDecimal amount = new BigDecimal(cost);
        netWorth = netWorth.subtract(amount);
        loveCounter++;
        luxuryCounter2++;
        if (hasPartner > 0)
        {
            loveCounter2++;
        }
        else
        {
            loveCounter2 = 0;
        }
        if (securityCounter > 0)
        {
            hasSecurity = 1;
            securityCounter--;
        }
        else
        hasSecurity = 0;
        gymCounter = 0;
        supplementCounter = 0;
        medicationCounter = 0;
        showCounter = 0;
        barCounter = 0;
        pShakeCounter = 0;
        jobCounter = 0;
        firstTimePlaying = 1;
        if (daysNotDead % 90 == 0 && taxSeason == 1 && daysNotDead > 0)
        {
            taxSeason = 0;
            taxAlgorithm();
        }
        if (daysNotDead % 91 == 0)
            taxSeason = 1;
        if ((daysNotDead - 30) % 90 == 0 && taxCollector == 1)
        {
            if (taxCollection.compareTo(netWorth) >= 1)
            {
                deathCounter = 4;
                amIDeadYet("Did not pay tax.");
                messagePrompt("30 days have passed. The tax collector has come.\n\n" +
                        "<Your debt is $" + taxCollection.toString() + ". But, you don't have enough Net Worth to pay.>\n\n" +
                        "<Respect the tyranny of an oppressive government. I have smited you.>", 3500);
                taxCollector = 0;

            }
            else
            {
                messagePrompt("30 days have passed. The tax collector has come.\n\n" +
                        "<Your debt is $" + taxCollection.toString() + ". Unfortunately, you did have enough Net Worth to pay.>\n\n" +
                        "<No one has to die today.>", 3500);
                netWorth = netWorth.subtract(taxCollection);
                taxCollection = taxCollection.subtract(taxCollection);
                taxCollector = 0;
            }
        }

        daysNotDeadCycle++;

        if (daysNotDeadCycle == 3) {
            daysNotDead++;
            tradeCounter = 0;
            if (daysNotDead == 25 && educationDrain == 1) {
                //messagePrompt("You have survived 25 days. You should strongly consider pursuing your education.", 1500);
            }
            if (daysNotDead == 31 && educationDrain == 1) {
                healthDrain = healthDrain + 4;
                happinessDrain = happinessDrain + 4;
            }
            if (daysNotDead == 40 && luxuryDrain == 1) {
                //messagePrompt("You have survived 40 days. You should strongly consider visiting the Luxury category.", 1500);
            }
            if (daysNotDead == 47 && luxuryDrain == 1) {
                healthDrain = healthDrain + 5;
                happinessDrain = happinessDrain + 5;
            }
            if (daysNotDead == 53 && loveDrain == 1) {
                //messagePrompt("You have survived 53 days. You should strongly consider looking for a date.", 1500);
            }
            if (daysNotDead == 62 && loveDrain == 1) {
                healthDrain = healthDrain + 5;
                happinessDrain = happinessDrain + 5;
            }
            if (daysNotDead == 50 && educationDrain == 1) {
                healthDrain = healthDrain + 8;
                happinessDrain = happinessDrain + 8;
            }
            if (daysNotDead == 55 && luxuryDrain == 1) {
                healthDrain = healthDrain + 11;
                happinessDrain = happinessDrain + 11;
            }
            if (daysNotDead == 65 && loveDrain == 1) {
                healthDrain = healthDrain + 12;
                happinessDrain = happinessDrain + 12;
            }
            if (daysNotDead == 85 && loveDrain == 1) {
                healthDrain = healthDrain + 15;
                happinessDrain = happinessDrain + 15;
            }
            daysNotDeadCycle = 0;
            //valueDayAgo = valueNow;
            updateStocks();
            updateVariables();
            updateStockVariables();
            MACB.growth = MACA.growth;
        }
        if (partnerKidnap > 0) {
            if (daysNotDead == partnerKidnap) {
                if (canIAffordIt("20000.00") == false) {
                    hasPartner = 0;
                    isEngaged = 0;
                    isMarried = 0;
                    healthRange = healthRange - 100;
                    if (healthRange < -25)
                        healthRange = -25;
                    happinessLevel = happinessLevel - 2500;
                    if (happinessLevel < -25)
                        happinessLevel = -25;
                    partnerKidnap = 0;
                    amIDeadYet("Depression from a lost loved one.");
                    messagePrompt("*ring ring* You're getting a call. *ring ring* You pick it up." +
                            "\n\n'Time's up. Where's the money?'\n\nYou didn't get the money in time. Your partner was brutally murdered by bandits.", 2500);
                    return;
                }
                else
                {
                    netWorth = netWorth.subtract(new BigDecimal("20000.00"));
                    hasPartner = 1;
                    //healthRange = healthRange + 50;
                    happinessLevel = happinessLevel + 1500;
                    partnerKidnap = 0;
                    amIDeadYet("n/a");
                    messagePrompt("*ring ring* You're getting a call. *ring ring* You pick it up." +
                            "\n\n'Time's up. Where's the money?'\n\nThe money is sent through an " +
                            "anonymous wire transfer. Your partner was released from captivity by the bandits.", 2500);
                    return;
                }
            }
        }

        healthRange = healthRange + healthChange;
        happinessLevel = happinessLevel + happinessChange;
        String s = "Days Without Dying: " + daysNotDead;
        ((TextView) findViewById(R.id.textView2)).setText(s); //updates the value to UI


        if (outputStocks().equals(new BigDecimal("0.00")))
            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
        else
            ((TextView) findViewById(R.id.textView4)).setText("Net. W.: $" + (netWorth) + " (" + outputStocks().toString() + ")");



        happinessLevel = happinessLevel - happinessDrain; //happiness drains every round
        healthRange = healthRange - healthDrain;          //health drains every round
        updateHealthAndHappiness();
        lotteryCycle = 0;

        if ((daysNotDead == 50 && daysNotDeadCycle == 0) || (daysNotDead % 50 == 0 && daysNotDead % 100 != 0 && daysNotDeadCycle == 0) && difficulty != 3) {
            if (respawnToken < 2) {
                respawnToken++;
                if (respawnToken == 1) {
                    messagePrompt(" You have earned a Respawn Token!\n\n Respawn Tokens are passively stored and automatically used if you die. Upon " +
                            "use, your Health and Happiness drains become halved.", 4000);
                    if (mInterstitialAd.isLoaded())
                        mInterstitialAd.show();
                    else if (mInterstitialAd2.isLoaded())
                    {
                        mInterstitialAd2.show();
                    }
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    mInterstitialAd2.loadAd(new AdRequest.Builder().build());
                }
                else {
                    messagePrompt(" You have earned another Respawn Token!\n\n Respawn Tokens are passively stored and automatically used if you die. Upon " +
                            "use, your Health and Happiness drains become halved.", 4000);
                    if (mInterstitialAd.isLoaded())
                        mInterstitialAd.show();
                    else if (mInterstitialAd2.isLoaded())
                    {
                        mInterstitialAd2.show();
                    }
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    mInterstitialAd2.loadAd(new AdRequest.Builder().build());
                }
                return;
            } else {
                messagePrompt("You have reached " +
                        "the maximum amount of Respawn Tokens I can give away. However, I do want to reward you for getting this far in life.\n\n" +
                        "Here's a small loan of a million dollars, instead.", 4000);
                netWorth = netWorth.add(new BigDecimal("1000000.00"));
                if (mInterstitialAd.isLoaded())
                    mInterstitialAd.show();
                else if (mInterstitialAd2.isLoaded())
                {
                    mInterstitialAd2.show();
                }
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                mInterstitialAd2.loadAd(new AdRequest.Builder().build());
                return;
            }
        }
        double chanceOfCommonCold = Math.random();
        if (chanceOfCommonCold < 0.0005 && isSick == 0 && daysNotDead > 30) {
            isSick = 1;
            healthDrain = healthDrain + 3;
            messagePrompt("Your nose is runny and you're developing a bad cough. Visiting a doctor is recommended.", 2000);
            return;
        }
        double chanceOfInfluenza = Math.random();
        if (chanceOfInfluenza < 0.0003 && isSick == 0 && daysNotDead > 30) {
            isSick = 2;
            healthDrain = healthDrain + 5;
            messagePrompt("Your nose is runny and you're developing a bad fever. Visiting a doctor is recommended.", 2000);
            return;
        }
        double chanceOfStrep = Math.random();
        if (chanceOfStrep < 0.0002 && isSick == 0 && daysNotDead > 30) {
            isSick = 3;
            healthDrain = healthDrain + 3;
            messagePrompt("Your throat is sore and you're developing a bad cough. Visiting a doctor is recommended.", 2000);
            return;
        }
        if (isSick != 0)
            sicknessCounter++;
        if (sicknessCounter % 9 == 0 & sicknessCounter != 0 && isSick != 0) {
            if (sicknessCounter % 63 != 0)
                messagePrompt("Your cough is very bad now, and you are developing chest pains.", 1500);
            healthDrain = healthDrain + 5;
            return;
        }

    }

    public void updateStatus() {
        if (daysNotDead > 126) {
            if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                messagePrompt(" You have been alive for " + daysNotDead +
                        " days now. Happiness drain increases by 20. ", 800);
            } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                messagePrompt(" You have been alive for " + daysNotDead +
                        " days now. Health drain increases by 20. ", 800);
            }
        } else if (daysNotDead > 112) {
            if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                messagePrompt(" You have been alive for " + daysNotDead +
                        " days now. Happiness drain increases by 17. ", 800);
            } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                messagePrompt(" You have been alive for " + daysNotDead +
                        " days now. Health drain increases by 17. ", 800);
            }
        } else if (daysNotDead > 98) {
            if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                messagePrompt(" You have been alive for " + daysNotDead +
                        " days now. Happiness drain increases by 14. ", 800);
            } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                healthDrain = healthDrain + 14;
                messagePrompt(" You have been alive for " + daysNotDead +
                        " days now. Health drain increases by 14. ", 800);
            }
        } else if (daysNotDead > 84) {
                if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                    messagePrompt(" You have been alive for " + daysNotDead +
                            " days now. Happiness drain increases by 11. ", 800);
                } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                    healthDrain = healthDrain + 14;
                    messagePrompt(" You have been alive for " + daysNotDead +
                            " days now. Health drain increases by 11. ", 800);
                }
        } else if (daysNotDead > 70) {
            if (daysNotDead % 84 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP(!) - Wall Street assets (stocks) are taxed at a much lower rate " +
                        "than your Net Worth. This will be important when taxes are collected every 90 days. \n\nHappiness drain increases by 8. ", 800);
            } else if (daysNotDead % 77 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP(!) - Every 90 days, taxes are collected. The amount you pay is calculated by an algorithm" +
                        " based on how much money you have made, how much Net Worth you have, and Wall Street (stock) assets which are taxed less.\n\nHealth drain increases by 8. ", 800);
            }
        } else if (daysNotDead > 56) {
            if (daysNotDead % 70 == 0 && daysNotDeadCycle == 0) {
                messagePrompt(" You have been alive for " + daysNotDead +
                        " days now. Happiness drain increases by 5. ", 800);
            } else if (daysNotDead % 63 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP(!) - You can kill yourself in the Success category to save your Respawn Tokens. If you do, you will restart " +
                                "the game back to Day 1, but start with 1 Respawn Token instead of 0. \n\nHealth drain increases by 5. ", 800);
            }
        } else if (daysNotDead > 42) {
            if (daysNotDead % 56 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP(!) - Generally, the Luxury and Love categories will have activities that are more beneficial than " +
                        "other activities of the same price. \n\nHappiness drain increases by 4. ", 800);
            } else if (daysNotDead % 49 == 0 && daysNotDeadCycle == 0) {
                //messagePrompt("TIP(!) - Generally, the Luxury and Love categories will have activities that are more beneficial than " +
                        //"other activities of the same price. \n\nHealth drain increases by 3. ", 800);
            }
        } else if (daysNotDead > 28) {
            if (daysNotDead % 42 == 0 && daysNotDeadCycle == 0) {
                if (hasPartner == 0)
                messagePrompt("TIP(!) - It would be a wise decision to go out in search of a partner, if you have not already. Everyone needs a friend.\n\n Happiness drain increases by 3. ", 1500);
                else
                    messagePrompt("TIP(!) - Nice job on getting a partner. Don't forget to go out on dates! They are more effective than most activities.\n\n Happiness drain increases by 3. ", 1500);

            } else if (daysNotDead % 35 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP(!) - Visiting the Luxury category allows you to go out and progress the story. Although, you probably can't afford most " +
                        "of it yet.\n\nHealth drain increases by 3. ", 1500);
            }
        } else if (daysNotDead > 14) {
            if (daysNotDead % 28 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP(!) - Clicking on the purple Respawn Token to the right allows you to see how much your Health and Happiness decreases by, along with the number of Respawn Tokens (if any). \n" +
                        "\nHappiness drain increases by 2. ", 1500);
            } else if (daysNotDead % 21 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP(!) - Save up your Net Worth for education. Eventually, you can learn your way to a higher-paying job. \n\nHealth drain increases by 2. ", 1500);
            }
        } else if (daysNotDead > 0) {
            if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP(!) - Once your Health or Happiness hit zero, you enter a 24 hour buffer zone or eventually, die. Use this to your advantage by accomplishing the most punishing tasks during this time.\n\nHappiness drain increases by 1. ", 1500);
            } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP(!) - A handful of inexpensive activities will be more effective than" +
                        " a few expensive ones. However, as your drains increase, this will become less effective and you will need more expensive alternatives.\n\nHealth drain increases by 1. ", 1500);
            }
        }
        if (daysNotDead > 2 && dayMessage == 1)
        {
            dayMessage = 0;
            messagePrompt("Congratulations! You have survived " + daysNotDead + " days.\n\nEvery 3 functions you complete, equates to 1 day of being alive. The days you are alive represents your score.", 1200);
        }
        if (loveCounter2 > 90)
        {
            if (hasPartner == 1 && isMarried == 0 && isEngaged == 0) {
                messagePrompt("It's been over a month since your last date. You have not been returning texts or calls.\n\n<I regret" +
                        " to inform you, but your partner has broken up with you.>\n\nYou are now single... again. Your happiness took a low" +
                        " blow.", 3500);
                hasPartner = 0;
                isEngaged = 0;
                isMarried = 0;
                happinessLevel = happinessLevel - 150;
                updateHealthAndHappiness();
            }
            else if (hasPartner == 1 && isEngaged == 1 && isMarried == 0) {
                messagePrompt("It's been over a month since your last date. You have not been returning texts or calls.\n\n<I regret" +
                        " to inform you, but your fiance has broken up with you.>\n\nYou are now single, and are no longer eligible to get married.", 3500);
                happinessLevel = happinessLevel - 400;
                hasPartner = 0;
                isEngaged = 0;
                isMarried = 0;
                updateHealthAndHappiness();
            }
            else if (isMarried == 1)
            {
                if (loveCounter2 > 180)
                {
                    messagePrompt("It's been over two months since your last date. You have not been returning texts or calls.\n\n<I regret" +
                            " to inform you, but your partner has divorced you.>\n\nYou are now single, and have lost half of your Net Worth.", 3500);
                    happinessLevel = happinessLevel - 400;
                    hasPartner = 0;
                    isEngaged = 0;
                    isMarried = 0;
                    netWorth = netWorth.divide(new BigDecimal(2));
                    updateHealthAndHappiness();
                }
            }
        }
    }

    public boolean canIAffordIt(String cost) {
        BigDecimal comparison = new BigDecimal(cost);

        if (netWorth.compareTo(comparison) < 0)
            return false;
        else
            return true;
    }

    public boolean amIDead() {
        if (happinessLevel < 0 || healthRange < 0) {
            return true;
        } else
            return false;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.loser.superfruit86.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.loser.superfruit86.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public void functionSkipTut(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new PhysicalFragment());
        fragmentTransaction.commit();
        if (getSupportFragmentManager().executePendingTransactions()) {
            if (daysNotDead < 35)
                ((TextView) findViewById(R.id.buttonAid)).setText("Seek professional help. (LOCKED)");
            if (daysNotDead < 80)
                ((TextView) findViewById(R.id.buttonEnhance)).setText("Enhance and modify your body. (LOCKED)");

        }

        messagePrompt("Open the categories menu by swiping from left to right, or by clicking on the top left icon.", 1500);

        messagePrompt("<Well, since you skipped the tutorial, I'm going to assume that you won't need " +
                "it and thus will never show it to you again.> \n\nGood luck.", 1500);
    }

    public void functionDone(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new PhysicalFragment());
        fragmentTransaction.commit();
        if (getSupportFragmentManager().executePendingTransactions()) {
            if (daysNotDead < 35)
                ((TextView) findViewById(R.id.buttonAid)).setText("Seek professional help. (LOCKED)");
            if (daysNotDead < 80)
                ((TextView) findViewById(R.id.buttonEnhance)).setText("Enhance and modify your body. (LOCKED)");

        }

        messagePrompt("Open the Category menu by swiping right from the left side, or clicking on the status bar screen.", 1500);

        messagePrompt("<Welcome to Loser. A message in brackets means that I am speaking.>\n\nYou can close windows by tapping near the corners, or the back button.", 1800);

    }

    public class Stock {
        public int movingPeriod;
        private int movingPeriodOriginal;
        public BigDecimal value;
        private int volatility;
        private BigDecimal maxValue;
        private BigDecimal minValue;
        public int growth;
        public BigDecimal movingRange;
        public int sharesOwned;
        public BigDecimal value2 = new BigDecimal("0.00");
        public BigDecimal value3 = new BigDecimal("0.00");
        public BigDecimal value4 = new BigDecimal("0.00");
        public BigDecimal value5 = new BigDecimal("0.00");
        public BigDecimal value6 = new BigDecimal("0.00");
        public BigDecimal value7 = new BigDecimal("0.00");
        public BigDecimal value8 = new BigDecimal("0.00");
        public BigDecimal value9 = new BigDecimal("0.00");
        public BigDecimal value10 = new BigDecimal("0.00");
        public BigDecimal value11 = new BigDecimal("0.00");
        public BigDecimal value12 = new BigDecimal("0.00");
        public BigDecimal value13 = new BigDecimal("0.00");
        public BigDecimal value14 = new BigDecimal("0.00");
        public BigDecimal value15 = new BigDecimal("0.00");
        public BigDecimal value16 = new BigDecimal("0.00");
        public BigDecimal value17 = new BigDecimal("0.00");
        public BigDecimal value18 = new BigDecimal("0.00");
        public BigDecimal value19 = new BigDecimal("0.00");
        public BigDecimal value20 = new BigDecimal("0.00");
        public BigDecimal value21 = new BigDecimal("0.00");
        public BigDecimal value22 = new BigDecimal("0.00");
        public BigDecimal value23 = new BigDecimal("0.00");
        public BigDecimal value24 = new BigDecimal("0.00");
        public BigDecimal value25 = new BigDecimal("0.00");
        public BigDecimal value26 = new BigDecimal("0.00");
        public BigDecimal value27 = new BigDecimal("0.00");
        public BigDecimal value28 = new BigDecimal("0.00");
        public BigDecimal value29 = new BigDecimal("0.00");
        public BigDecimal value30 = new BigDecimal("0.00");

        public String analysisReport() {
            if (volatility == 1) {
                if (growth == 1) {
                    if (new Random().nextDouble() < 0.9) {
                        return ("Volatility: Low\n" +
                                "Stock Growth: projected Positive overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    } else {
                        return ("Volatility: Low\n" +
                                "Stock Growth: projected Negative overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    }
                } else {
                    if (new Random().nextDouble() < 0.9) {
                        return ("Volatility: Low\n" +
                                "Stock Growth: projected Negative overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    } else {
                        return ("Volatility: Low\n" +
                                "Stock Growth: projected Positive overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    }
                }
            }
            if (volatility == 2) {
                if (growth == 1) {
                    if (new Random().nextDouble() < 0.9) {
                        return ("Volatility: Medium\n" +
                                "Stock Growth: projected Positive overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    } else {
                        return ("Volatility: Medium\n" +
                                "Stock Growth: projected Negative overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    }
                } else {
                    if (new Random().nextDouble() < 0.9) {
                        return ("Volatility: Medium\n" +
                                "Stock Growth: projected Negative overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    } else {
                        return ("Volatility: Medium\n" +
                                "Stock Growth: projected Positive overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    }
                }
            }
            if (volatility == 3) {
                if (growth == 1) {
                    if (new Random().nextDouble() < 0.9) {
                        return ("Volatility: High\n" +
                                "Stock Growth: projected Positive overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    } else {
                        return ("Volatility: High\n" +
                                "Stock Growth: projected Negative overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    }
                } else {
                    if (new Random().nextDouble() < 0.9) {
                        return ("Volatility: High\n" +
                                "Stock Growth: projected Negative overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    } else {
                        return ("Volatility: High\n" +
                                "Stock Growth: projected Positive overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    }
                }
            }
            if (volatility == 4) {
                if (growth == 1) {
                    if (new Random().nextDouble() < 0.9) {
                        return ("Volatility: Very High\n" +
                                "Stock Growth: projected Positive overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    } else {
                        return ("Volatility: Very High\n" +
                                "Stock Growth: projected Negative overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    }
                } else {
                    if (new Random().nextDouble() < 0.9) {
                        return ("Volatility: Very High\n" +
                                "Stock Growth: projected Negative overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    } else {
                        return ("Volatility: Very High\n" +
                                "Stock Growth: projected Positive overall\n\n" +
                                "Market capacity: $" + maxValue.toString() + "\n" +
                                "Market minimum:  $" + minValue.toString() + "\n" +
                                "Current value:   $" + value.toString() + "\n\n\n" +
                                "3 Day Change:    $" + value3.toString() + "\n" +
                                "7 Day Change:    $" + value7.toString() + "\n" +
                                "15 Day Change:   $" + value15.toString() + "\n" +
                                "30 Day Change:   $" + value30.toString());
                    }
                }
            } else
                return ("N/A");
        }

        public String insiderReport() {
            Random rand = new Random();
            int m = (movingPeriod - 2) + rand.nextInt((movingPeriod + 2) - (movingPeriod - 2)) + 1;
            if (m < 0)
                m = 0;
            Random rand2 = new Random();
            int m2 = (movingPeriodOriginal - 3) + rand2.nextInt((movingPeriodOriginal + 3) - (movingPeriodOriginal - 3)) + 1;
            if (m2 < 0)
                m2 = 1;

            if (volatility == 1) {
                if (growth == 1) {
                    return ("Volatility: Low\n" +
                            "Current Stock health: Positive\n\n" +
                            "Est. moving period: " + m + " days\n" +
                            "Est. market average: " + m2 + " days in cycle\n\n" +
                            "Current value:    $" + value.toString() + "\n" +
                            "3 Day Change:    $" + value3.toString() + "\n" +
                            "6 Day Change:    $" + value6.toString() + "\n" +
                            "10 Day Change:   $" + value10.toString() + "\n" +
                            "15 Day Change:   $" + value15.toString() + "\n" +
                            "20 Day Change:   $" + value20.toString() + "\n" +
                            "25 Day Change:   $" + value25.toString() + "\n" +
                            "30 Day Change:   $" + value30.toString());
                } else {
                    return ("Volatility: Low\n" +
                            "Current Stock health: Negative\n\n" +
                            "Est. moving period: " + m + " days\n" +
                            "Est. market average: " + m2 + " days in cycle\n\n" +
                            "Current value:    $" + value.toString() + "\n" +
                            "3 Day Change:    $" + value3.toString() + "\n" +
                            "6 Day Change:    $" + value6.toString() + "\n" +
                            "10 Day Change:   $" + value10.toString() + "\n" +
                            "15 Day Change:   $" + value15.toString() + "\n" +
                            "20 Day Change:   $" + value20.toString() + "\n" +
                            "25 Day Change:   $" + value25.toString() + "\n" +
                            "30 Day Change:   $" + value30.toString());
                }
            }
            if (volatility == 2) {
                if (growth == 1) {
                    return ("Volatility: Medium\n" +
                            "Current Stock health: Positive\n\n" +
                            "Est. moving period: " + m + " days\n" +
                            "Est. market average: " + m2 + " days in cycle\n\n" +
                            "Current value:    $" + value.toString() + "\n" +
                            "3 Day Change:    $" + value3.toString() + "\n" +
                            "6 Day Change:    $" + value6.toString() + "\n" +
                            "10 Day Change:   $" + value10.toString() + "\n" +
                            "15 Day Change:   $" + value15.toString() + "\n" +
                            "20 Day Change:   $" + value20.toString() + "\n" +
                            "25 Day Change:   $" + value25.toString() + "\n" +
                            "30 Day Change:   $" + value30.toString());
                } else {
                    return ("Volatility: Medium\n" +
                            "Current Stock health: Negative\n\n" +
                            "Est. moving period: " + m + " days\n" +
                            "Est. market average: " + m2 + " days in cycle\n\n" +
                            "Current value:    $" + value.toString() + "\n" +
                            "3 Day Change:    $" + value3.toString() + "\n" +
                            "6 Day Change:    $" + value6.toString() + "\n" +
                            "10 Day Change:   $" + value10.toString() + "\n" +
                            "15 Day Change:   $" + value15.toString() + "\n" +
                            "20 Day Change:   $" + value20.toString() + "\n" +
                            "25 Day Change:   $" + value25.toString() + "\n" +
                            "30 Day Change:   $" + value30.toString());
                }
            }
            if (volatility == 3) {
                if (growth == 1) {
                    return ("Volatility: High\n" +
                            "Current Stock health: Positive\n\n" +
                            "Est. moving period: " + m + " days\n" +
                            "Est. market average: " + m2 + " days in cycle\n\n" +
                            "Current value:    $" + value.toString() + "\n" +
                            "3 Day Change:    $" + value3.toString() + "\n" +
                            "6 Day Change:    $" + value6.toString() + "\n" +
                            "10 Day Change:   $" + value10.toString() + "\n" +
                            "15 Day Change:   $" + value15.toString() + "\n" +
                            "20 Day Change:   $" + value20.toString() + "\n" +
                            "25 Day Change:   $" + value25.toString() + "\n" +
                            "30 Day Change:   $" + value30.toString());
                } else {
                    return ("Volatility: High\n" +
                            "Current Stock health: Negative\n\n" +
                            "Est. moving period: " + m + " days\n" +
                            "Est. market average: " + m2 + " days in cycle\n\n" +
                            "Current value:    $" + value.toString() + "\n" +
                            "3 Day Change:    $" + value3.toString() + "\n" +
                            "6 Day Change:    $" + value6.toString() + "\n" +
                            "10 Day Change:   $" + value10.toString() + "\n" +
                            "15 Day Change:   $" + value15.toString() + "\n" +
                            "20 Day Change:   $" + value20.toString() + "\n" +
                            "25 Day Change:   $" + value25.toString() + "\n" +
                            "30 Day Change:   $" + value30.toString());
                }
            }
            if (volatility == 4) {
                if (growth == 1) {
                    return ("Volatility: Very High\n" +
                            "Current Stock health: Positive\n\n" +
                            "Est. moving period: " + m + " days\n" +
                            "Est. market average: " + m2 + " days in cycle\n\n" +
                            "Current value:    $" + value.toString() + "\n" +
                            "3 Day Change:    $" + value3.toString() + "\n" +
                            "6 Day Change:    $" + value6.toString() + "\n" +
                            "10 Day Change:   $" + value10.toString() + "\n" +
                            "15 Day Change:   $" + value15.toString() + "\n" +
                            "20 Day Change:   $" + value20.toString() + "\n" +
                            "25 Day Change:   $" + value25.toString() + "\n" +
                            "30 Day Change:   $" + value30.toString());
                } else {
                    return ("Volatility: Very High\n" +
                            "Current Stock health: Negative\n\n" +
                            "Est. moving period: " + m + " days\n" +
                            "Est. market average: " + m2 + " days in cycle\n\n" +
                            "Current value:    $" + value.toString() + "\n" +
                            "3 Day Change:    $" + value3.toString() + "\n" +
                            "6 Day Change:    $" + value6.toString() + "\n" +
                            "10 Day Change:   $" + value10.toString() + "\n" +
                            "15 Day Change:   $" + value15.toString() + "\n" +
                            "20 Day Change:   $" + value20.toString() + "\n" +
                            "25 Day Change:   $" + value25.toString() + "\n" +
                            "30 Day Change:   $" + value30.toString());
                }
            } else
                return ("N/A");
        }

        public Stock(BigDecimal high, BigDecimal low, int vol, int mP) {
            maxValue = high;
            minValue = low;
            volatility = vol;
            movingPeriod = mP;
            movingPeriodOriginal = mP;


            BigDecimal range = high.subtract(low);
            BigDecimal halfRange = range.multiply(new BigDecimal(".5"));
            value = low.add(range.multiply(new BigDecimal(Math.random())));
            value = value.setScale(2, RoundingMode.CEILING);

            if (value.compareTo(high.subtract(halfRange)) < 0) {
                growth = 1;
            } else {
                growth = 0;
            }
            if (new BigDecimal(mP).compareTo(new BigDecimal("0.00")) == 0)
                movingRange = new BigDecimal("0.00");
            else
                movingRange = range.divide(new BigDecimal(mP), RoundingMode.HALF_UP);
        }

        public void updateStock() {
            value30 = value29;
            value29 = value28;
            value28 = value27;
            value27 = value26;
            value26 = value25;
            value25 = value24;
            value24 = value23;
            value23 = value22;
            value22 = value21;
            value21 = value20;
            value20 = value19;
            value19 = value18;
            value18 = value17;
            value17 = value16;
            value16 = value15;
            value15 = value14;
            value14 = value13;
            value13 = value12;
            value12 = value11;
            value11 = value10;
            value10 = value9;
            value9 = value8;
            value8 = value7;
            value7 = value6;
            value6 = value5;
            value5 = value4;
            value4 = value3;
            value3 = value2;
            value2 = value;
            if (movingPeriod == 0) {
                movingPeriod = movingPeriodOriginal;
                if (growth == 1)
                    growth = 0;
                else
                    growth = 1;
            }
            BigDecimal changeBy = movingRange;
            if (volatility == 1)
                changeBy = movingRange.multiply(new BigDecimal(-1 + (new Random().nextDouble() * (1.75 - -1)))).setScale(2, RoundingMode.HALF_UP);

            if (volatility == 2)
                changeBy = movingRange.multiply(new BigDecimal(-1.5 + (new Random().nextDouble() * (2.63 - -1.5)))).setScale(2, RoundingMode.HALF_UP);

            if (volatility == 3)
                changeBy = movingRange.multiply(new BigDecimal(-2.0 + (new Random().nextDouble() * (3.5 - -2.0)))).setScale(2, RoundingMode.HALF_UP);

            if (volatility == 4)
                changeBy = movingRange.multiply(new BigDecimal(-3.0 + (new Random().nextDouble() * (5.25 - -3)))).setScale(2, RoundingMode.HALF_UP);

            if (growth == 1)
                value = value.add(changeBy);
            else
                value = value.subtract(changeBy);
            movingPeriod--;
            if (value.compareTo(maxValue) > 0) {
                maxValue = value;
            }
            if (value.compareTo(minValue) < 0) {
                minValue = value;
            }


        }

        public void buyShares(int quantity) {
            BigDecimal spendingMoney = netWorth.subtract(new BigDecimal("500.00"));
            BigDecimal stockMoney = value.multiply(new BigDecimal(quantity));
            spendingMoney = spendingMoney.subtract(stockMoney);
            if (spendingMoney.compareTo(new BigDecimal("0.00")) < 0) {
                if (quantity == 1)
                    messagePrompt("You must maintain a minimum of $500 in your account.", 500);
                else
                    messagePrompt("You cannot afford that many shares.", 500);
                return;
            }
            if (value30DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value30DaysAgo = value30DaysAgo.add(value);
            if (value29DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value29DaysAgo = value29DaysAgo.add(value);
            if (value28DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value28DaysAgo = value28DaysAgo.add(value);
            if (value27DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value27DaysAgo = value27DaysAgo.add(value);
            if (value26DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value26DaysAgo = value26DaysAgo.add(value);
            if (value25DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value25DaysAgo = value25DaysAgo.add(value);
            if (value24DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value24DaysAgo = value24DaysAgo.add(value);
            if (value23DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value23DaysAgo = value23DaysAgo.add(value);
            if (value22DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value22DaysAgo = value22DaysAgo.add(value);
            if (value21DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value21DaysAgo = value21DaysAgo.add(value);
            if (value20DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value20DaysAgo = value20DaysAgo.add(value);
            if (value19DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value19DaysAgo = value19DaysAgo.add(value);
            if (value18DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value18DaysAgo = value18DaysAgo.add(value);
            if (value17DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value17DaysAgo = value17DaysAgo.add(value);
            if (value16DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value16DaysAgo = value16DaysAgo.add(value);
            if (value15DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value15DaysAgo = value15DaysAgo.add(value);
            if (value14DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value14DaysAgo = value14DaysAgo.add(value);
            if (value13DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value13DaysAgo = value13DaysAgo.add(value);
            if (value12DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value12DaysAgo = value12DaysAgo.add(value);
            if (value11DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value11DaysAgo = value11DaysAgo.add(value);
            if (value10DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value10DaysAgo = value10DaysAgo.add(value);
            if (value9DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value9DaysAgo = value9DaysAgo.add(value);
            if (value8DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value8DaysAgo = value8DaysAgo.add(value);
            if (value7DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value7DaysAgo = value7DaysAgo.add(value);
            if (value6DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value6DaysAgo = value6DaysAgo.add(value);
            if (value5DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value5DaysAgo = value5DaysAgo.add(value);
            if (value4DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value4DaysAgo = value4DaysAgo.add(value);
            if (value3DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value3DaysAgo = value3DaysAgo.add(value);
            if (value2DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value2DaysAgo = value2DaysAgo.add(value);
            if (valueDayAgo.compareTo(new BigDecimal("0.00")) != 0)
                valueDayAgo = valueDayAgo.add(value);
            spendingMoney = spendingMoney.add(new BigDecimal("500.00"));
            netWorth = spendingMoney;
            sharesOwned = sharesOwned + quantity;
            updateStockVariables();
            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
            else
                ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

        }

        public void sellShares(int quantity) {
            //BigDecimal spendingMoney = netWorth.subtract(new BigDecimal("500.00"));
            BigDecimal stockMoney = value.multiply(new BigDecimal(quantity));
            //spendingMoney = spendingMoney.subtract(stockMoney);
            if (sharesOwned == 0) {
                messagePrompt("You do not hold any shares in this company.", 500);
                return;
            }
            if (sharesOwned < quantity) {
                messagePrompt("You do not own that many shares in this company.", 500);
                return;
            }
            if (value30DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value30DaysAgo = value30DaysAgo.subtract(value);
            if (value29DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value29DaysAgo = value29DaysAgo.subtract(value);
            if (value28DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value28DaysAgo = value28DaysAgo.subtract(value);
            if (value27DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value27DaysAgo = value27DaysAgo.subtract(value);
            if (value26DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value26DaysAgo = value26DaysAgo.subtract(value);
            if (value25DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value25DaysAgo = value25DaysAgo.subtract(value);
            if (value24DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value24DaysAgo = value24DaysAgo.subtract(value);
            if (value23DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value23DaysAgo = value23DaysAgo.subtract(value);
            if (value22DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value22DaysAgo = value22DaysAgo.subtract(value);
            if (value21DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value21DaysAgo = value21DaysAgo.subtract(value);
            if (value20DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value20DaysAgo = value20DaysAgo.subtract(value);
            if (value19DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value19DaysAgo = value19DaysAgo.subtract(value);
            if (value18DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value18DaysAgo = value18DaysAgo.subtract(value);
            if (value17DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value17DaysAgo = value17DaysAgo.subtract(value);
            if (value16DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value16DaysAgo = value16DaysAgo.subtract(value);
            if (value15DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value15DaysAgo = value15DaysAgo.subtract(value);
            if (value14DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value14DaysAgo = value14DaysAgo.subtract(value);
            if (value13DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value13DaysAgo = value13DaysAgo.subtract(value);
            if (value12DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value12DaysAgo = value12DaysAgo.subtract(value);
            if (value11DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value11DaysAgo = value11DaysAgo.subtract(value);
            if (value10DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value10DaysAgo = value10DaysAgo.subtract(value);
            if (value9DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value9DaysAgo = value9DaysAgo.subtract(value);
            if (value8DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value8DaysAgo = value8DaysAgo.subtract(value);
            if (value7DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value7DaysAgo = value7DaysAgo.subtract(value);
            if (value6DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value6DaysAgo = value6DaysAgo.subtract(value);
            if (value5DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value5DaysAgo = value5DaysAgo.subtract(value);
            if (value4DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value4DaysAgo = value4DaysAgo.subtract(value);
            if (value3DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value3DaysAgo = value3DaysAgo.subtract(value);
            if (value2DaysAgo.compareTo(new BigDecimal("0.00")) != 0)
                value2DaysAgo = value2DaysAgo.subtract(value);
            if (valueDayAgo.compareTo(new BigDecimal("0.00")) != 0)
                valueDayAgo = valueDayAgo.subtract(value);

            netWorth = netWorth.add(stockMoney);
            sharesOwned = sharesOwned - quantity;
            updateStockVariables();
            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
            else
                ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

        }

        public BigDecimal outputAssets() {
            if (sharesOwned == 0)
                return new BigDecimal("0000.00");
            else
                return (value.multiply(new BigDecimal(sharesOwned)));
        }
    }

    public void updateStocks() {
        value30DaysAgo = value29DaysAgo;
        value29DaysAgo = value28DaysAgo;
        value28DaysAgo = value27DaysAgo;
        value27DaysAgo = value26DaysAgo;
        value26DaysAgo = value25DaysAgo;
        value25DaysAgo = value24DaysAgo;
        value24DaysAgo = value23DaysAgo;
        value23DaysAgo = value22DaysAgo;
        value22DaysAgo = value21DaysAgo;
        value21DaysAgo = value20DaysAgo;
        value20DaysAgo = value19DaysAgo;
        value19DaysAgo = value18DaysAgo;
        value18DaysAgo = value17DaysAgo;
        value17DaysAgo = value16DaysAgo;
        value16DaysAgo = value15DaysAgo;
        value15DaysAgo = value14DaysAgo;
        value14DaysAgo = value13DaysAgo;
        value13DaysAgo = value12DaysAgo;
        value12DaysAgo = value11DaysAgo;
        value11DaysAgo = value10DaysAgo;
        value10DaysAgo = value9DaysAgo;
        value9DaysAgo = value8DaysAgo;
        value8DaysAgo = value7DaysAgo;
        value7DaysAgo = value6DaysAgo;
        value6DaysAgo = value5DaysAgo;
        value5DaysAgo = value4DaysAgo;
        value4DaysAgo = value3DaysAgo;
        value3DaysAgo = value2DaysAgo;
        value2DaysAgo = valueDayAgo;
        valueDayAgo = valueNow;
        RM.updateStock();
        IBC.updateStock();
        FWB.updateStock();
        KC.updateStock();
        ET.updateStock();
        NSX.updateStock();
        FU.updateStock();
        AP.updateStock();
        BNN.updateStock();
        MACA.updateStock();
        MACB.updateStock();
        MM.updateStock();
        valueNow = outputStocks();

    }

    public BigDecimal outputStocks() {
        BigDecimal assets = new BigDecimal("0000.00");
        assets = assets.add(RM.outputAssets());
        assets = assets.add(IBC.outputAssets());
        assets = assets.add(FWB.outputAssets());
        assets = assets.add(KC.outputAssets());
        assets = assets.add(NSX.outputAssets());
        assets = assets.add(FU.outputAssets());
        assets = assets.add(AP.outputAssets());
        assets = assets.add(BNN.outputAssets());
        assets = assets.add(MACA.outputAssets());
        assets = assets.add(MACB.outputAssets());
        assets = assets.add(MM.outputAssets());
        assets = assets.add(ET.outputAssets());
        return assets;
    }

    public void resetStocks() {
        valueDayAgo = new BigDecimal("0.00");
        valueNow = new BigDecimal("0.00");
        value29DaysAgo = new BigDecimal("0.00");
        value28DaysAgo = new BigDecimal("0.00");
        value27DaysAgo = new BigDecimal("0.00");
        value26DaysAgo = new BigDecimal("0.00");
        value25DaysAgo = new BigDecimal("0.00");
        value24DaysAgo = new BigDecimal("0.00");
        value23DaysAgo = new BigDecimal("0.00");
        value22DaysAgo = new BigDecimal("0.00");
        value21DaysAgo = new BigDecimal("0.00");
        value20DaysAgo = new BigDecimal("0.00");
        value19DaysAgo = new BigDecimal("0.00");
        value18DaysAgo = new BigDecimal("0.00");
        value17DaysAgo = new BigDecimal("0.00");
        value16DaysAgo = new BigDecimal("0.00");
        value15DaysAgo = new BigDecimal("0.00");
        value14DaysAgo = new BigDecimal("0.00");
        value13DaysAgo = new BigDecimal("0.00");
        value12DaysAgo = new BigDecimal("0.00");
        value11DaysAgo = new BigDecimal("0.00");
        value10DaysAgo = new BigDecimal("0.00");
        value9DaysAgo = new BigDecimal("0.00");
        value8DaysAgo = new BigDecimal("0.00");
        value7DaysAgo = new BigDecimal("0.00");
        value6DaysAgo = new BigDecimal("0.00");
        value5DaysAgo = new BigDecimal("0.00");
        value4DaysAgo = new BigDecimal("0.00");
        value3DaysAgo = new BigDecimal("0.00");
        value2DaysAgo = new BigDecimal("0.00");


        value30DaysAgo = new BigDecimal("0.00");

        value90DaysAgo = new BigDecimal("0.00");

        BigDecimal RM_low = new BigDecimal("26.00");
        BigDecimal RM_high = new BigDecimal("37.00");
        RM = new Stock(RM_high, RM_low, 2, 13);

        BigDecimal IBC_low = new BigDecimal("115.00");
        BigDecimal IBC_high = new BigDecimal("165.00");
        IBC = new Stock(IBC_high, IBC_low, 3, 148);

        BigDecimal FWB_low = new BigDecimal("43.00");
        BigDecimal FWB_high = new BigDecimal("55.00");
        FWB = new Stock(FWB_high, FWB_low, 2, 11);

        BigDecimal KC_low = new BigDecimal("40.00");
        BigDecimal KC_high = new BigDecimal("47.00");
        KC = new Stock(KC_high, KC_low, 2, 22);

        BigDecimal ET_low = new BigDecimal("40.00");
        BigDecimal ET_high = new BigDecimal("60.00");
        ET = new Stock(ET_high, ET_low, 2, 39);

        BigDecimal NSX_low = new BigDecimal("70.00");
        BigDecimal NSX_high = new BigDecimal("95.00");
        NSX = new Stock(NSX_high, NSX_low, 3, 41);

        BigDecimal FU_low = new BigDecimal("19.00");
        BigDecimal FU_high = new BigDecimal("30.00");
        FU = new Stock(FU_high, FU_low, 2, 164);

        BigDecimal AP_low = new BigDecimal("94.00");
        BigDecimal AP_high = new BigDecimal("132.00");
        AP = new Stock(AP_high, AP_low, 4, 72);

        BigDecimal BNN_low = new BigDecimal("60.00");
        BigDecimal BNN_high = new BigDecimal("82.00");
        BNN = new Stock(BNN_high, BNN_low, 3, 17);

        BigDecimal MACA_low = new BigDecimal("187000.00");
        BigDecimal MACA_high = new BigDecimal("227000.00");
        MACA = new Stock(MACA_high, MACA_low, 2, 63);

        BigDecimal MACB_low = new BigDecimal("125.00");
        BigDecimal MACB_high = new BigDecimal("151.00");
        MACB = new Stock(MACB_high, MACB_low, 2, 63);

        BigDecimal MM_low = new BigDecimal("56.00");
        BigDecimal MM_high = new BigDecimal("75.00");
        MM = new Stock(MM_high, MM_low, 3, 94);
    }
    // This function resets all the game stats, except high score

    public void resetStats() {

        // --------------------- STATS OF USER --------------
        if (mInterstitialAd.isLoaded())
            mInterstitialAd.show();
        else if (mInterstitialAd2.isLoaded())
        {
            mInterstitialAd2.show();
        }

        resetVariables();
        initializeVariables();

        succMessage = 0;
        dayMessage = 0;
        resetStocks();
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd2.loadAd(new AdRequest.Builder().build());


        ((TextView) findViewById(R.id.textView2)).setText("Days Without Dying: " + daysNotDead);
        if (outputStocks().equals(new BigDecimal("0.00")))
            ((TextView) findViewById(R.id.textView4)).setText("Net Worth: $" + (netWorth));
        else
            ((TextView) findViewById(R.id.textView4)).setText("N-W: $" + (netWorth) + " (" + outputStocks().toString() + ")");

        ((TextView) findViewById(R.id.textView10)).setText("Highscore: " + highScore);
        updateHealthAndHappiness();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new DifficultyFragment());
        fragmentTransaction.commit();

        //messagePrompt("Choose a difficulty.", 1200);

    }

    void updateHealthAndHappiness() {
        ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgress(happinessLevel);
            if (happinessLevel > 4000) {
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#ffcc99"));
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(12000);
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(12000);
                ((TextView) findViewById(R.id.happinessIndicator)).setText("*****");
            } else if (happinessLevel > 1350) {
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#ffff99"));
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(4000);
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(4000);
                ((TextView) findViewById(R.id.happinessIndicator)).setText("****");
            } else if (happinessLevel > 450) {
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#ffffcc"));
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(1350);
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(1350);
                ((TextView) findViewById(R.id.happinessIndicator)).setText("***");
            } else if (happinessLevel > 150) {
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#ccffcc"));
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(450);
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(450);
                ((TextView) findViewById(R.id.happinessIndicator)).setText("**");
            } else if (happinessLevel > 50) {
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#ccffff"));
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(150);
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(150);
                ((TextView) findViewById(R.id.happinessIndicator)).setText("*");
            } else {
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#b3d9ff"));
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(50);
                ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(50);
                ((TextView) findViewById(R.id.happinessIndicator)).setText("");
            }
        if (firstTimeHappinessIndicator == 0 && happinessLevel > 50)
        {
            firstTimeHappinessIndicator = 1;
            messagePrompt(" TIP(!) - After closing this message, notice the color of your Happiness bar changed. " +
                    "\n\nYour Happiness did not go down. Instead, you have reached the next level.", 1200);
        }
        ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgress(happinessLevel);

        ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgress(healthRange);
        if (healthRange > 4000) {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#b3ccff"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(12000);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(12000);
            ((TextView) findViewById(R.id.healthIndicator)).setText("*****");
        } else if (healthRange > 1350) {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#ccccff"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(4000);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(4000);
            ((TextView) findViewById(R.id.healthIndicator)).setText("****");
        } else if (healthRange > 450) {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#dab3ff"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(1350);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(1350);
            ((TextView) findViewById(R.id.healthIndicator)).setText("***");
        } else if (healthRange > 150) {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#ff99ff"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(450);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(450);
            ((TextView) findViewById(R.id.healthIndicator)).setText("**");
        } else if (healthRange > 50) {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#ff99cc"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(150);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(150);
            ((TextView) findViewById(R.id.healthIndicator)).setText("*");
        } else {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#ff9999"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(50);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(50);
            ((TextView) findViewById(R.id.healthIndicator)).setText("");
        }
        if (firstTimeHealthIndicator == 0 && healthRange > 50)
        {
            firstTimeHealthIndicator = 1;
            messagePrompt(" TIP(!) - After closing this message, notice the color of your Health bar changed. \n" +
                    "\n" +
                    "Your Health did not go down. Instead, you have reached the next level.", 1200);
        }
        ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgress(healthRange);
    }

    void functionHome() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new PhysicalFragment());
        fragmentTransaction.commit();
        if (getSupportFragmentManager().executePendingTransactions()) {
            if (daysNotDead < 35)
                ((TextView) findViewById(R.id.buttonAid)).setText("Seek professional help. (LOCKED)");
            if (daysNotDead < 80)
                ((TextView) findViewById(R.id.buttonEnhance)).setText("Enhance and modify your body. (LOCKED)");

        }
    }


}





