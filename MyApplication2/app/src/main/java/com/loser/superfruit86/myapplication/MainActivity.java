package com.loser.superfruit86.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

// TODO: Old packages? Needs updates/refactors
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;


import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

// TODO: Does ad integration work correctly anymore?
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.MobileAds;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity {

    // ------------- components ----------------
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    ActionBar actionBar;

    // ------------- UI things -----------------

    static final String daysNotDeadText = " days not dead.";

    // --------------------- STATS OF USER --------------
    public int highScore;
    public int daysNotDead;
    public int daysNotDeadCycle;
    public BigDecimal netWorth;
    public BigDecimal totalEarned;
    public int happinessLevel;
    public int healthLevel;
    public int happinessDrain;
    public int healthDrain;
    public int drainVariable;
    public int respawnToken;
    public int hasPartner; //trigger to check if user is 0 - single 1 - partner
    public int educationDrain;
    public int luxuryDrain;
    public int loveDrain;
    public int deathCounter;
    public int popupCounter1;
    public int popupCounter2;
    public int popupCounter3;
    public int cheatingCounter;
    public int returningPlayer;
    public int successMessage;
    public int luxuryMessage;
    public int loveMessage;
    public int careerMessage;
    public int educationMessage;
    public int dayMessage;
    public int hasWon;
    public int taxSeason;
    public int taxCollector;
    public BigDecimal taxCollection;
    public int difficulty;
    public int securityCounter;


    // ---------------------- ATTRIBUTES OF USER -----------
    public int isHomeless; //trigger to check if user is homeless 0 - not homeless 1 - homeless
    public int isSick;
    //1 - Rhinovirus(cold)
    //2 - Influenza(flu)
    //3 - Strep Throat(streptococcus)
    //4 - Heart Disease
    //5 - Type 2 Diabetes
    //6 - Cancer
    public int sicknessCounter;
    public int luxuryCounter;
    public int luxuryCounter2; //luxury every 7 days
    public int loveCounter;    //love every 14 days
    public int loveCounter2;
    public int gymCounter;
    public int pShakeCounter;
    public int showCounter;
    public int supplementCounter;
    public int medicationCounter;
    public int therapyCounter;
    public int barCounter;
    public int tradeCounter;
    public int firstTimeHealthIndicator;
    public int firstTimeHappinessIndicator;
    public int loveUnlock1;
    public int loveUnlock2;
    public int loveUnlock3;
    public int loveUnlock4;
    public int loveUnlock5;
    public int loveUnlock6;

    public int isEducated; //trigger to check if user has 0 - no schooling 1 - took 1 class 2 - bachelors 3 - masters 4 - doctors
    public int collegeClassesTaken;//5 classes needed to go to grad school
    public int gradClassesTaken;//10 classes needed to get masters
    public int postGradClassesTaken;//15 classes needed to get masters

    public int isEmployed; //trigger to check if user is employed 0 - not employed 1 - employed
    public int jobCounter;
    public int jobCycle;
    public int payRate;

    public int job2Trigger;
    public int jobCycle2;
    public int payRate2;

    public int jobCycle3;
    public int payRate3;

    public int jobCycle4;
    public int payRate4;
    public int job4Trigger;

    public int jobCycle5;
    public int payRate5;

    public int jobCycle6;
    public int payRate6;
    public int job6Trigger;

    public int jobCycle7;
    public int payRate7;

    public int jobCycle8;
    public int payRate8;
    public int job8Trigger;

    public int jobCycle9;
    public int payRate9;
    public int jobCEOTrigger;
    public int jobCEOReference;

    public int lotteryCycle;
    public int isMarried;
    public int isEngaged;
    public int hasSecurity;
    public int partnerKidnap;

    // --------------- STOCK DATA -------------------

    public BigDecimal valueDayAgo;
    public BigDecimal valueNow;
    public BigDecimal value29DaysAgo;
    public BigDecimal value28DaysAgo;
    public BigDecimal value27DaysAgo;
    public BigDecimal value26DaysAgo;
    public BigDecimal value25DaysAgo;
    public BigDecimal value24DaysAgo;
    public BigDecimal value23DaysAgo;
    public BigDecimal value22DaysAgo;
    public BigDecimal value21DaysAgo;
    public BigDecimal value20DaysAgo;
    public BigDecimal value19DaysAgo;
    public BigDecimal value18DaysAgo;
    public BigDecimal value17DaysAgo;
    public BigDecimal value16DaysAgo;
    public BigDecimal value15DaysAgo;
    public BigDecimal value14DaysAgo;
    public BigDecimal value13DaysAgo;
    public BigDecimal value12DaysAgo;
    public BigDecimal value11DaysAgo;
    public BigDecimal value10DaysAgo;
    public BigDecimal value9DaysAgo;
    public BigDecimal value8DaysAgo;
    public BigDecimal value7DaysAgo;
    public BigDecimal value6DaysAgo;
    public BigDecimal value5DaysAgo;
    public BigDecimal value4DaysAgo;
    public BigDecimal value3DaysAgo;
    public BigDecimal value2DaysAgo;

    public BigDecimal value30DaysAgo;
    public BigDecimal value90DaysAgo;

    public Stock RM;
    public Stock IBC;
    public Stock FWB;
    public Stock KC;
    public Stock ET;
    public Stock NSX;
    public Stock FU;
    public Stock AP;
    public Stock BNN;
    public Stock MACA;
    public Stock MACB;
    public Stock MM;
    /*
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;
//    public InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // ---------------------------- Setting variables
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        // TODO: Stock system 'valueXXXtimeago' variables could persist better across game saves
        resetStocks();

        // Uncomment to clear game data
        //editor.clear();
        //editor.apply();
        //resetVariables();

        initVariablesFromSave();
        initStockVariablesFromSave();

        // Testing purposes
        //respawnToken++;
        //difficulty = 0;

        // --------------------------- UI stuff begins

        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Ads stuff */
//        MobileAds.initialize(this, "ca-app-pub-6612683572827982~5717244235");
//        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId("ca-app-pub-6612683572827982/2716510522");
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
//        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                // Load the next interstitial.
//                mInterstitialAd.loadAd(new AdRequest.Builder().build());
//            }
//
//        });

        initActionBar();

        // ----------------------------------- Setting Respawn Tokens, Statuses & icon

        initUIStatuses();

        // ---------------------------- Game begins here!

        beginGame();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // ------------------------------- UTILITIES
    // Static because this method doesn't care about the rest of the game (or game's class)
    public static String getRandomString(String... strings) {
        if (strings.length == 0) {
            throw new IllegalArgumentException("At least one string must be provided");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(strings.length); // generates a random index
        return strings[randomIndex];
    }

    // Static because this method doesn't care about the rest of the game (or game's class)
//    public static String getNextThenRandomString(String... inputStrings) {
//        // Initialize the list if it's empty and inputStrings are provided
//        if (strings.isEmpty() && inputStrings.length > 0) {
//            for (String str : inputStrings) {
//                strings.add(str);
//            }
//        }
//
//        if (strings.isEmpty()) {
//            throw new IllegalArgumentException("At least one string must be provided");
//        }
//
//        // If we haven't cycled through all the strings yet, return them in order
//        if (!hasCycledOnce) {
//            String nextString = strings.get(currentIndex);
//            currentIndex++;
//
//            // Check if we have reached the end of the list
//            if (currentIndex == strings.size()) {
//                hasCycledOnce = true;
//                currentIndex = 0; // Reset for random selection
//            }
//            return nextString;
//        } else {
//            // Once we've cycled through all strings, select randomly
//            return strings.get(random.nextInt(strings.size()));
//        }
//    }

    // -------------------------- Normal parts of game init

    public void initActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    public void initUIStatuses() {
        byte[] emojiBytes = new byte[]{(byte) 0xE2, (byte) 0x98, (byte) 0xBA};
        final String emojiAsString = new String(emojiBytes, Charset.forName("UTF-8"));
        byte[] emojiHealth = new byte[]{(byte) 0xE2, (byte) 0x9D, (byte) 0xA4};
        final String emojiHealthString = new String(emojiHealth, Charset.forName("UTF-8"));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Snackbar.make(view, "Respawn " + respawnToken + "  |  " + emojiAsString + " drain " +
                                "" + happinessDrain + "  |  " + emojiHealthString + " drain " + healthDrain + "", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
        if (outputStocks().equals(new BigDecimal("0.00")))
            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
        else
            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

        ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
        updateHealthAndHappiness();
    }

    public void initNavigation() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int id = item.getItemId();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                navigationView = (NavigationView) findViewById(R.id.nav_view);


                if (id == R.id.nav_physical) {
                    functionPhysical(null);
                    //actionBar.setTitle("Physical");
                    item.setChecked(true);


                } else if (id == R.id.nav_mental) {
                    functionMental(null);
                    //actionBar.setTitle("Mental");
                    item.setChecked(true);

                } else if (id == R.id.nav_success) {
                    functionSuccess(null);
                    //actionBar.setTitle("Success");
                    item.setChecked(true);


                } else if (id == R.id.nav_luxury) {
                    if (daysNotDead < 30) {
                        messagePrompt("You have to survive for 30 days before you can access Luxury. ", 600);
                    } else {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new LuxuryFragment());
                        fragmentTransaction.commitNow();
                        // if (getSupportFragmentManager().executePendingTransactions()) {
                        // Ignore stupid conditional: regex, text search thing
                        if (0 == 0) {
                            if (luxuryMessage == 1)
                            {
                                luxuryMessage = 0;
                                messagePrompt("TIP (!) Luxury is where you go to enjoy yourself and propel the plot " +
                                        "forward.\n\n<< The very last button wins the game. >>", 1200);
                            }
                            if (luxuryCounter < 1)
                                ((TextView) findViewById(R.id.buttonTravelWorld)).setText("Travel across the world. (LOCKED)");
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
                        //actionBar.setTitle("Luxury");
                        item.setChecked(true);

                    }

                } else if (id == R.id.nav_love) {
                    if (hasPartner == 1) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new LoveFragment());
                        fragmentTransaction.commitNow();
                        // if (getSupportFragmentManager().executePendingTransactions()) {
                        // Ignore stupid conditional: regex, text search thing
                        if (0 == 0) {
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
                        //actionBar.setTitle("Love");
                        item.setChecked(true);
                    } else {
                        messagePrompt("<< You are single. >>", 500);
                    }
                } else if (id == R.id.nav_about_us) {

                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_container, new AboutUsFragment());
                    fragmentTransaction.commitNow();
                    //actionBar.setTitle("Love");
                    item.setChecked(true);
                } else if (id == R.id.nav_privacy) {
                    Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://app.termly.io/document/privacy-policy/a93ae13c-3a07-4bdd-b98a-705572832c3c"));
                    startActivity(browserIntent);
                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    public void setHomeTitle() {
        // if (getSupportFragmentManager().executePendingTransactions()) {
                        // Ignore stupid conditional: regex, text search thing
                        if (0 == 0) {
            SpannableString s = new SpannableString("Menu");
            s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            s.setSpan(new ShadowSpan(8.5f, 5.0f, 5.0f, Color.BLACK), 0, s.length(), 0);
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                // TODO: Move all mipmap regular assets into drawable
                actionBar.setHomeAsUpIndicator(R.mipmap.right_icon3);
                actionBar.setTitle(s);
            }
        }
    }

    public void beginGame() {
        if (returningPlayer == 1) {
            if (daysNotDead <= 0) // NEW GAME, RETURNING PLAYER
            {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new DifficultyFragment());
                fragmentTransaction.commitNow();

                messagePrompt(getRandomString("<< Let's give this another shot. >>",
                        "<< Time for a fresh start. >>", "<< Restarting from the beginning. >>",
                        "<< Here we go again. >>", "<< Resetting and ready to try once more. >>",
                        "<< Back to the basics, game on. >>", "<< New round, let's make it count. >>",
                        "<< Back to the starting line. >>", "<< Let's try this again. >>",
                        "<< Hello there. >>", "<< Hello. >>", "<< Hi. >>", "<< Hey. >>","<< Back to square one. >>"), 1200);

//                if (mInterstitialAd.isLoaded())
//                    mInterstitialAd.show();
//                else
//                {
//                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
//                }

            }
            else { // CONTINUING PREVIOUS GAME
                functionPhysical(null);
                messagePrompt(getRandomString("<< Welcome back. >>", "<< Nice to see you again. >>", "<< I missed you. >>",
                        "<< Hello again. >>", "<< Glad to see you back. >>", "<< You've returned. Interesting choice. >>",
                        "<< Couldn't stay away, could you? >>", "<< Back so soon? I'm delighted. >>", "<< Did you miss this place? >>",
                        "<< Look who's back. >>", "<< And here you are again, as expected. >>") + "\n\n You have been alive for " + daysNotDead + " days.", 1000);
            }
        } else { // FIRST TIME PLAYER, PLAYING!
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new DifficultyFragment());
            fragmentTransaction.commitNow();
            messagePrompt("<< Nice to meet you. I speak like this. >>\n\nTap outside (or your back button) to close. ", 1200);
        }

        editor.putInt("returningPlayer", 1);
        editor.apply();
        setHomeTitle();
        initNavigation();
    }

    void initVariablesFromSave() {

        //Where it all begins
        returningPlayer = sharedPref.getInt("returningPlayer", 0);
        daysNotDead = sharedPref.getInt("daysNotDead", 0);
        highScore = sharedPref.getInt("highScore", 0);
        daysNotDeadCycle = sharedPref.getInt("daysNotDeadCycle", 0);

        int nW = sharedPref.getInt("netWorth", -1);
        if (nW > -1) // TODO: This appears to be some bug case?
        {
            netWorth = new BigDecimal(nW);
            netWorth = netWorth.add(new BigDecimal("0.01"));
            netWorth = netWorth.subtract(new BigDecimal("0.01"));
            editor.putInt("netWorth", -1);
            editor.putString("netWorthS", netWorth.toString());
            editor.apply();
        }
        else
        {
            String i = sharedPref.getString("netWorthS", "1000.00");
            netWorth = new BigDecimal(i);
        }

        totalEarned = new BigDecimal(sharedPref.getInt("totalEarned", 0));

        String c = sharedPref.getString("taxCollectionS", "0.00");
        taxCollection = new BigDecimal(c);

        happinessLevel = sharedPref.getInt("happinessLevel", 38);
        healthLevel = sharedPref.getInt("healthRange", 38);
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
        successMessage = sharedPref.getInt("successMessage", 1);
        luxuryMessage = sharedPref.getInt("luxuryMessage", 1);
        loveMessage = sharedPref.getInt("loveMessage", 1);
        careerMessage = sharedPref.getInt("careerMessage", 1);
        educationMessage = sharedPref.getInt("educationMessage", 1);
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
        healthLevel = 300;
        healthDrain = healthDrain + 10;
        happinessDrain = happinessDrain + 10;
        daysNotDead = 74;
        */
    }

    void initStockVariablesFromSave() {

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
        KC.value = new BigDecimal(sharedPref.getInt("KC value", KC.value.intValue()));

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
        KC.sharesOwned = (sharedPref.getInt("KC shares", KC.sharesOwned));

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
        KC.growth = (sharedPref.getInt("KC growth", KC.growth));

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
        KC.movingPeriod = (sharedPref.getInt("KC movingPeriod", KC.movingPeriod));

        //Stock updating
        ET.value = new BigDecimal(sharedPref.getInt("ET value", ET.value.intValue())); ET.value2 = new BigDecimal(sharedPref.getInt("ET value2", ET.value2.intValue())); ET.value3 = new BigDecimal(sharedPref.getInt("ET value3", ET.value3.intValue())); ET.value4 = new BigDecimal(sharedPref.getInt("ET value4", ET.value4.intValue())); ET.value5 = new BigDecimal(sharedPref.getInt("ET value5", ET.value5.intValue())); ET.value6 = new BigDecimal(sharedPref.getInt("ET value6", ET.value6.intValue())); ET.value7 = new BigDecimal(sharedPref.getInt("ET value7", ET.value7.intValue())); ET.value8 = new BigDecimal(sharedPref.getInt("ET value8", ET.value8.intValue())); ET.value9 = new BigDecimal(sharedPref.getInt("ET value9", ET.value9.intValue())); ET.value10 = new BigDecimal(sharedPref.getInt("ET value10", ET.value10.intValue())); ET.value11 = new BigDecimal(sharedPref.getInt("ET value11", ET.value11.intValue())); ET.value12 = new BigDecimal(sharedPref.getInt("ET value12", ET.value12.intValue())); ET.value13 = new BigDecimal(sharedPref.getInt("ET value13", ET.value13.intValue())); ET.value14 = new BigDecimal(sharedPref.getInt("ET value14", ET.value14.intValue())); ET.value15 = new BigDecimal(sharedPref.getInt("ET value15", ET.value15.intValue())); ET.value16 = new BigDecimal(sharedPref.getInt("ET value16", ET.value16.intValue())); ET.value17 = new BigDecimal(sharedPref.getInt("ET value17", ET.value17.intValue())); ET.value18 = new BigDecimal(sharedPref.getInt("ET value18", ET.value18.intValue())); ET.value19 = new BigDecimal(sharedPref.getInt("ET value19", ET.value19.intValue())); ET.value20 = new BigDecimal(sharedPref.getInt("ET value20", ET.value20.intValue())); ET.value21 = new BigDecimal(sharedPref.getInt("ET value21", ET.value21.intValue())); ET.value22 = new BigDecimal(sharedPref.getInt("ET value22", ET.value22.intValue())); ET.value23 = new BigDecimal(sharedPref.getInt("ET value23", ET.value23.intValue())); ET.value24 = new BigDecimal(sharedPref.getInt("ET value24", ET.value24.intValue())); ET.value25 = new BigDecimal(sharedPref.getInt("ET value25", ET.value25.intValue())); ET.value26 = new BigDecimal(sharedPref.getInt("ET value26", ET.value26.intValue())); ET.value27 = new BigDecimal(sharedPref.getInt("ET value27", ET.value27.intValue())); ET.value28 = new BigDecimal(sharedPref.getInt("ET value28", ET.value8.intValue())); ET.value29 = new BigDecimal(sharedPref.getInt("ET value29", ET.value29.intValue())); ET.value30 = new BigDecimal(sharedPref.getInt("ET value30", ET.value30.intValue()));
        NSX.value = new BigDecimal(sharedPref.getInt("NSX value", NSX.value.intValue())); NSX.value2 = new BigDecimal(sharedPref.getInt("NSX value2", NSX.value2.intValue())); NSX.value3 = new BigDecimal(sharedPref.getInt("NSX value3", NSX.value3.intValue())); NSX.value4 = new BigDecimal(sharedPref.getInt("NSX value4", NSX.value4.intValue())); NSX.value5 = new BigDecimal(sharedPref.getInt("NSX value5", NSX.value5.intValue())); NSX.value6 = new BigDecimal(sharedPref.getInt("NSX value6", NSX.value6.intValue())); NSX.value7 = new BigDecimal(sharedPref.getInt("NSX value7", NSX.value7.intValue())); NSX.value8 = new BigDecimal(sharedPref.getInt("NSX value8", NSX.value8.intValue())); NSX.value9 = new BigDecimal(sharedPref.getInt("NSX value9", NSX.value9.intValue())); NSX.value10 = new BigDecimal(sharedPref.getInt("NSX value10", NSX.value10.intValue())); NSX.value11 = new BigDecimal(sharedPref.getInt("NSX value11", NSX.value11.intValue())); NSX.value12 = new BigDecimal(sharedPref.getInt("NSX value12", NSX.value12.intValue())); NSX.value13 = new BigDecimal(sharedPref.getInt("NSX value13", NSX.value13.intValue())); NSX.value14 = new BigDecimal(sharedPref.getInt("NSX value14", NSX.value14.intValue())); NSX.value15 = new BigDecimal(sharedPref.getInt("NSX value15", NSX.value15.intValue())); NSX.value16 = new BigDecimal(sharedPref.getInt("NSX value16", NSX.value16.intValue())); NSX.value17 = new BigDecimal(sharedPref.getInt("NSX value17", NSX.value17.intValue())); NSX.value18 = new BigDecimal(sharedPref.getInt("NSX value18", NSX.value18.intValue())); NSX.value19 = new BigDecimal(sharedPref.getInt("NSX value19", NSX.value19.intValue())); NSX.value20 = new BigDecimal(sharedPref.getInt("NSX value20", NSX.value20.intValue())); NSX.value21 = new BigDecimal(sharedPref.getInt("NSX value21", NSX.value21.intValue())); NSX.value22 = new BigDecimal(sharedPref.getInt("NSX value22", NSX.value22.intValue())); NSX.value23 = new BigDecimal(sharedPref.getInt("NSX value23", NSX.value23.intValue())); NSX.value24 = new BigDecimal(sharedPref.getInt("NSX value24", NSX.value24.intValue())); NSX.value25 = new BigDecimal(sharedPref.getInt("NSX value25", NSX.value25.intValue())); NSX.value26 = new BigDecimal(sharedPref.getInt("NSX value26", NSX.value26.intValue())); NSX.value27 = new BigDecimal(sharedPref.getInt("NSX value27", NSX.value27.intValue())); NSX.value28 = new BigDecimal(sharedPref.getInt("NSX value28", NSX.value8.intValue())); NSX.value29 = new BigDecimal(sharedPref.getInt("NSX value29", NSX.value29.intValue())); NSX.value30 = new BigDecimal(sharedPref.getInt("NSX value30", NSX.value30.intValue()));
        FU.value = new BigDecimal(sharedPref.getInt("FU value", FU.value.intValue())); FU.value2 = new BigDecimal(sharedPref.getInt("FU value2", FU.value2.intValue())); FU.value3 = new BigDecimal(sharedPref.getInt("FU value3", FU.value3.intValue())); FU.value4 = new BigDecimal(sharedPref.getInt("FU value4", FU.value4.intValue())); FU.value5 = new BigDecimal(sharedPref.getInt("FU value5", FU.value5.intValue())); FU.value6 = new BigDecimal(sharedPref.getInt("FU value6", FU.value6.intValue())); FU.value7 = new BigDecimal(sharedPref.getInt("FU value7", FU.value7.intValue())); FU.value8 = new BigDecimal(sharedPref.getInt("FU value8", FU.value8.intValue())); FU.value9 = new BigDecimal(sharedPref.getInt("FU value9", FU.value9.intValue())); FU.value10 = new BigDecimal(sharedPref.getInt("FU value10", FU.value10.intValue())); FU.value11 = new BigDecimal(sharedPref.getInt("FU value11", FU.value11.intValue())); FU.value12 = new BigDecimal(sharedPref.getInt("FU value12", FU.value12.intValue())); FU.value13 = new BigDecimal(sharedPref.getInt("FU value13", FU.value13.intValue())); FU.value14 = new BigDecimal(sharedPref.getInt("FU value14", FU.value14.intValue())); FU.value15 = new BigDecimal(sharedPref.getInt("FU value15", FU.value15.intValue())); FU.value16 = new BigDecimal(sharedPref.getInt("FU value16", FU.value16.intValue())); FU.value17 = new BigDecimal(sharedPref.getInt("FU value17", FU.value17.intValue())); FU.value18 = new BigDecimal(sharedPref.getInt("FU value18", FU.value18.intValue())); FU.value19 = new BigDecimal(sharedPref.getInt("FU value19", FU.value19.intValue())); FU.value20 = new BigDecimal(sharedPref.getInt("FU value20", FU.value20.intValue())); FU.value21 = new BigDecimal(sharedPref.getInt("FU value21", FU.value21.intValue())); FU.value22 = new BigDecimal(sharedPref.getInt("FU value22", FU.value22.intValue())); FU.value23 = new BigDecimal(sharedPref.getInt("FU value23", FU.value23.intValue())); FU.value24 = new BigDecimal(sharedPref.getInt("FU value24", FU.value24.intValue())); FU.value25 = new BigDecimal(sharedPref.getInt("FU value25", FU.value25.intValue())); FU.value26 = new BigDecimal(sharedPref.getInt("FU value26", FU.value26.intValue())); FU.value27 = new BigDecimal(sharedPref.getInt("FU value27", FU.value27.intValue())); FU.value28 = new BigDecimal(sharedPref.getInt("FU value28", FU.value8.intValue())); FU.value29 = new BigDecimal(sharedPref.getInt("FU value29", FU.value29.intValue())); FU.value30 = new BigDecimal(sharedPref.getInt("FU value30", FU.value30.intValue()));
        AP.value = new BigDecimal(sharedPref.getInt("AP value", AP.value.intValue())); AP.value2 = new BigDecimal(sharedPref.getInt("AP value2", AP.value2.intValue())); AP.value3 = new BigDecimal(sharedPref.getInt("AP value3", AP.value3.intValue())); AP.value4 = new BigDecimal(sharedPref.getInt("AP value4", AP.value4.intValue())); AP.value5 = new BigDecimal(sharedPref.getInt("AP value5", AP.value5.intValue())); AP.value6 = new BigDecimal(sharedPref.getInt("AP value6", AP.value6.intValue())); AP.value7 = new BigDecimal(sharedPref.getInt("AP value7", AP.value7.intValue())); AP.value8 = new BigDecimal(sharedPref.getInt("AP value8", AP.value8.intValue())); AP.value9 = new BigDecimal(sharedPref.getInt("AP value9", AP.value9.intValue())); AP.value10 = new BigDecimal(sharedPref.getInt("AP value10", AP.value10.intValue())); AP.value11 = new BigDecimal(sharedPref.getInt("AP value11", AP.value11.intValue())); AP.value12 = new BigDecimal(sharedPref.getInt("AP value12", AP.value12.intValue())); AP.value13 = new BigDecimal(sharedPref.getInt("AP value13", AP.value13.intValue())); AP.value14 = new BigDecimal(sharedPref.getInt("AP value14", AP.value14.intValue())); AP.value15 = new BigDecimal(sharedPref.getInt("AP value15", AP.value15.intValue())); AP.value16 = new BigDecimal(sharedPref.getInt("AP value16", AP.value16.intValue())); AP.value17 = new BigDecimal(sharedPref.getInt("AP value17", AP.value17.intValue())); AP.value18 = new BigDecimal(sharedPref.getInt("AP value18", AP.value18.intValue())); AP.value19 = new BigDecimal(sharedPref.getInt("AP value19", AP.value19.intValue())); AP.value20 = new BigDecimal(sharedPref.getInt("AP value20", AP.value20.intValue())); AP.value21 = new BigDecimal(sharedPref.getInt("AP value21", AP.value21.intValue())); AP.value22 = new BigDecimal(sharedPref.getInt("AP value22", AP.value22.intValue())); AP.value23 = new BigDecimal(sharedPref.getInt("AP value23", AP.value23.intValue())); AP.value24 = new BigDecimal(sharedPref.getInt("AP value24", AP.value24.intValue())); AP.value25 = new BigDecimal(sharedPref.getInt("AP value25", AP.value25.intValue())); AP.value26 = new BigDecimal(sharedPref.getInt("AP value26", AP.value26.intValue())); AP.value27 = new BigDecimal(sharedPref.getInt("AP value27", AP.value27.intValue())); AP.value28 = new BigDecimal(sharedPref.getInt("AP value28", AP.value8.intValue())); AP.value29 = new BigDecimal(sharedPref.getInt("AP value29", AP.value29.intValue())); AP.value30 = new BigDecimal(sharedPref.getInt("AP value30", AP.value30.intValue()));
        BNN.value = new BigDecimal(sharedPref.getInt("BNN value", BNN.value.intValue())); BNN.value2 = new BigDecimal(sharedPref.getInt("BNN value2", BNN.value2.intValue())); BNN.value3 = new BigDecimal(sharedPref.getInt("BNN value3", BNN.value3.intValue())); BNN.value4 = new BigDecimal(sharedPref.getInt("BNN value4", BNN.value4.intValue())); BNN.value5 = new BigDecimal(sharedPref.getInt("BNN value5", BNN.value5.intValue())); BNN.value6 = new BigDecimal(sharedPref.getInt("BNN value6", BNN.value6.intValue())); BNN.value7 = new BigDecimal(sharedPref.getInt("BNN value7", BNN.value7.intValue())); BNN.value8 = new BigDecimal(sharedPref.getInt("BNN value8", BNN.value8.intValue())); BNN.value9 = new BigDecimal(sharedPref.getInt("BNN value9", BNN.value9.intValue())); BNN.value10 = new BigDecimal(sharedPref.getInt("BNN value10", BNN.value10.intValue())); BNN.value11 = new BigDecimal(sharedPref.getInt("BNN value11", BNN.value11.intValue())); BNN.value12 = new BigDecimal(sharedPref.getInt("BNN value12", BNN.value12.intValue())); BNN.value13 = new BigDecimal(sharedPref.getInt("BNN value13", BNN.value13.intValue())); BNN.value14 = new BigDecimal(sharedPref.getInt("BNN value14", BNN.value14.intValue())); BNN.value15 = new BigDecimal(sharedPref.getInt("BNN value15", BNN.value15.intValue())); BNN.value16 = new BigDecimal(sharedPref.getInt("BNN value16", BNN.value16.intValue())); BNN.value17 = new BigDecimal(sharedPref.getInt("BNN value17", BNN.value17.intValue())); BNN.value18 = new BigDecimal(sharedPref.getInt("BNN value18", BNN.value18.intValue())); BNN.value19 = new BigDecimal(sharedPref.getInt("BNN value19", BNN.value19.intValue())); BNN.value20 = new BigDecimal(sharedPref.getInt("BNN value20", BNN.value20.intValue())); BNN.value21 = new BigDecimal(sharedPref.getInt("BNN value21", BNN.value21.intValue())); BNN.value22 = new BigDecimal(sharedPref.getInt("BNN value22", BNN.value22.intValue())); BNN.value23 = new BigDecimal(sharedPref.getInt("BNN value23", BNN.value23.intValue())); BNN.value24 = new BigDecimal(sharedPref.getInt("BNN value24", BNN.value24.intValue())); BNN.value25 = new BigDecimal(sharedPref.getInt("BNN value25", BNN.value25.intValue())); BNN.value26 = new BigDecimal(sharedPref.getInt("BNN value26", BNN.value26.intValue())); BNN.value27 = new BigDecimal(sharedPref.getInt("BNN value27", BNN.value27.intValue())); BNN.value28 = new BigDecimal(sharedPref.getInt("BNN value28", BNN.value8.intValue())); BNN.value29 = new BigDecimal(sharedPref.getInt("BNN value29", BNN.value29.intValue())); BNN.value30 = new BigDecimal(sharedPref.getInt("BNN value30", BNN.value30.intValue()));
        MACA.value = new BigDecimal(sharedPref.getInt("MACA value", MACA.value.intValue())); MACA.value2 = new BigDecimal(sharedPref.getInt("MACA value2", MACA.value2.intValue())); MACA.value3 = new BigDecimal(sharedPref.getInt("MACA value3", MACA.value3.intValue())); MACA.value4 = new BigDecimal(sharedPref.getInt("MACA value4", MACA.value4.intValue())); MACA.value5 = new BigDecimal(sharedPref.getInt("MACA value5", MACA.value5.intValue())); MACA.value6 = new BigDecimal(sharedPref.getInt("MACA value6", MACA.value6.intValue())); MACA.value7 = new BigDecimal(sharedPref.getInt("MACA value7", MACA.value7.intValue())); MACA.value8 = new BigDecimal(sharedPref.getInt("MACA value8", MACA.value8.intValue())); MACA.value9 = new BigDecimal(sharedPref.getInt("MACA value9", MACA.value9.intValue())); MACA.value10 = new BigDecimal(sharedPref.getInt("MACA value10", MACA.value10.intValue())); MACA.value11 = new BigDecimal(sharedPref.getInt("MACA value11", MACA.value11.intValue())); MACA.value12 = new BigDecimal(sharedPref.getInt("MACA value12", MACA.value12.intValue())); MACA.value13 = new BigDecimal(sharedPref.getInt("MACA value13", MACA.value13.intValue())); MACA.value14 = new BigDecimal(sharedPref.getInt("MACA value14", MACA.value14.intValue())); MACA.value15 = new BigDecimal(sharedPref.getInt("MACA value15", MACA.value15.intValue())); MACA.value16 = new BigDecimal(sharedPref.getInt("MACA value16", MACA.value16.intValue())); MACA.value17 = new BigDecimal(sharedPref.getInt("MACA value17", MACA.value17.intValue())); MACA.value18 = new BigDecimal(sharedPref.getInt("MACA value18", MACA.value18.intValue())); MACA.value19 = new BigDecimal(sharedPref.getInt("MACA value19", MACA.value19.intValue())); MACA.value20 = new BigDecimal(sharedPref.getInt("MACA value20", MACA.value20.intValue())); MACA.value21 = new BigDecimal(sharedPref.getInt("MACA value21", MACA.value21.intValue())); MACA.value22 = new BigDecimal(sharedPref.getInt("MACA value22", MACA.value22.intValue())); MACA.value23 = new BigDecimal(sharedPref.getInt("MACA value23", MACA.value23.intValue())); MACA.value24 = new BigDecimal(sharedPref.getInt("MACA value24", MACA.value24.intValue())); MACA.value25 = new BigDecimal(sharedPref.getInt("MACA value25", MACA.value25.intValue())); MACA.value26 = new BigDecimal(sharedPref.getInt("MACA value26", MACA.value26.intValue())); MACA.value27 = new BigDecimal(sharedPref.getInt("MACA value27", MACA.value27.intValue())); MACA.value28 = new BigDecimal(sharedPref.getInt("MACA value28", MACA.value8.intValue())); MACA.value29 = new BigDecimal(sharedPref.getInt("MACA value29", MACA.value29.intValue())); MACA.value30 = new BigDecimal(sharedPref.getInt("MACA value30", MACA.value30.intValue()));
        MACB.value = new BigDecimal(sharedPref.getInt("MACB value", MACB.value.intValue())); MACB.value2 = new BigDecimal(sharedPref.getInt("MACB value2", MACB.value2.intValue())); MACB.value3 = new BigDecimal(sharedPref.getInt("MACB value3", MACB.value3.intValue())); MACB.value4 = new BigDecimal(sharedPref.getInt("MACB value4", MACB.value4.intValue())); MACB.value5 = new BigDecimal(sharedPref.getInt("MACB value5", MACB.value5.intValue())); MACB.value6 = new BigDecimal(sharedPref.getInt("MACB value6", MACB.value6.intValue())); MACB.value7 = new BigDecimal(sharedPref.getInt("MACB value7", MACB.value7.intValue())); MACB.value8 = new BigDecimal(sharedPref.getInt("MACB value8", MACB.value8.intValue())); MACB.value9 = new BigDecimal(sharedPref.getInt("MACB value9", MACB.value9.intValue())); MACB.value10 = new BigDecimal(sharedPref.getInt("MACB value10", MACB.value10.intValue())); MACB.value11 = new BigDecimal(sharedPref.getInt("MACB value11", MACB.value11.intValue())); MACB.value12 = new BigDecimal(sharedPref.getInt("MACB value12", MACB.value12.intValue())); MACB.value13 = new BigDecimal(sharedPref.getInt("MACB value13", MACB.value13.intValue())); MACB.value14 = new BigDecimal(sharedPref.getInt("MACB value14", MACB.value14.intValue())); MACB.value15 = new BigDecimal(sharedPref.getInt("MACB value15", MACB.value15.intValue())); MACB.value16 = new BigDecimal(sharedPref.getInt("MACB value16", MACB.value16.intValue())); MACB.value17 = new BigDecimal(sharedPref.getInt("MACB value17", MACB.value17.intValue())); MACB.value18 = new BigDecimal(sharedPref.getInt("MACB value18", MACB.value18.intValue())); MACB.value19 = new BigDecimal(sharedPref.getInt("MACB value19", MACB.value19.intValue())); MACB.value20 = new BigDecimal(sharedPref.getInt("MACB value20", MACB.value20.intValue())); MACB.value21 = new BigDecimal(sharedPref.getInt("MACB value21", MACB.value21.intValue())); MACB.value22 = new BigDecimal(sharedPref.getInt("MACB value22", MACB.value22.intValue())); MACB.value23 = new BigDecimal(sharedPref.getInt("MACB value23", MACB.value23.intValue())); MACB.value24 = new BigDecimal(sharedPref.getInt("MACB value24", MACB.value24.intValue())); MACB.value25 = new BigDecimal(sharedPref.getInt("MACB value25", MACB.value25.intValue())); MACB.value26 = new BigDecimal(sharedPref.getInt("MACB value26", MACB.value26.intValue())); MACB.value27 = new BigDecimal(sharedPref.getInt("MACB value27", MACB.value27.intValue())); MACB.value28 = new BigDecimal(sharedPref.getInt("MACB value28", MACB.value8.intValue())); MACB.value29 = new BigDecimal(sharedPref.getInt("MACB value29", MACB.value29.intValue())); MACB.value30 = new BigDecimal(sharedPref.getInt("MACB value30", MACB.value30.intValue()));
        MM.value = new BigDecimal(sharedPref.getInt("MM value", MM.value.intValue())); MM.value2 = new BigDecimal(sharedPref.getInt("MM value2", MM.value2.intValue())); MM.value3 = new BigDecimal(sharedPref.getInt("MM value3", MM.value3.intValue())); MM.value4 = new BigDecimal(sharedPref.getInt("MM value4", MM.value4.intValue())); MM.value5 = new BigDecimal(sharedPref.getInt("MM value5", MM.value5.intValue())); MM.value6 = new BigDecimal(sharedPref.getInt("MM value6", MM.value6.intValue())); MM.value7 = new BigDecimal(sharedPref.getInt("MM value7", MM.value7.intValue())); MM.value8 = new BigDecimal(sharedPref.getInt("MM value8", MM.value8.intValue())); MM.value9 = new BigDecimal(sharedPref.getInt("MM value9", MM.value9.intValue())); MM.value10 = new BigDecimal(sharedPref.getInt("MM value10", MM.value10.intValue())); MM.value11 = new BigDecimal(sharedPref.getInt("MM value11", MM.value11.intValue())); MM.value12 = new BigDecimal(sharedPref.getInt("MM value12", MM.value12.intValue())); MM.value13 = new BigDecimal(sharedPref.getInt("MM value13", MM.value13.intValue())); MM.value14 = new BigDecimal(sharedPref.getInt("MM value14", MM.value14.intValue())); MM.value15 = new BigDecimal(sharedPref.getInt("MM value15", MM.value15.intValue())); MM.value16 = new BigDecimal(sharedPref.getInt("MM value16", MM.value16.intValue())); MM.value17 = new BigDecimal(sharedPref.getInt("MM value17", MM.value17.intValue())); MM.value18 = new BigDecimal(sharedPref.getInt("MM value18", MM.value18.intValue())); MM.value19 = new BigDecimal(sharedPref.getInt("MM value19", MM.value19.intValue())); MM.value20 = new BigDecimal(sharedPref.getInt("MM value20", MM.value20.intValue())); MM.value21 = new BigDecimal(sharedPref.getInt("MM value21", MM.value21.intValue())); MM.value22 = new BigDecimal(sharedPref.getInt("MM value22", MM.value22.intValue())); MM.value23 = new BigDecimal(sharedPref.getInt("MM value23", MM.value23.intValue())); MM.value24 = new BigDecimal(sharedPref.getInt("MM value24", MM.value24.intValue())); MM.value25 = new BigDecimal(sharedPref.getInt("MM value25", MM.value25.intValue())); MM.value26 = new BigDecimal(sharedPref.getInt("MM value26", MM.value26.intValue())); MM.value27 = new BigDecimal(sharedPref.getInt("MM value27", MM.value27.intValue())); MM.value28 = new BigDecimal(sharedPref.getInt("MM value28", MM.value8.intValue())); MM.value29 = new BigDecimal(sharedPref.getInt("MM value29", MM.value29.intValue())); MM.value30 = new BigDecimal(sharedPref.getInt("MM value30", MM.value30.intValue()));
        RM.value = new BigDecimal(sharedPref.getInt("RM value", RM.value.intValue())); RM.value2 = new BigDecimal(sharedPref.getInt("RM value2", RM.value2.intValue())); RM.value3 = new BigDecimal(sharedPref.getInt("RM value3", RM.value3.intValue())); RM.value4 = new BigDecimal(sharedPref.getInt("RM value4", RM.value4.intValue())); RM.value5 = new BigDecimal(sharedPref.getInt("RM value5", RM.value5.intValue())); RM.value6 = new BigDecimal(sharedPref.getInt("RM value6", RM.value6.intValue())); RM.value7 = new BigDecimal(sharedPref.getInt("RM value7", RM.value7.intValue())); RM.value8 = new BigDecimal(sharedPref.getInt("RM value8", RM.value8.intValue())); RM.value9 = new BigDecimal(sharedPref.getInt("RM value9", RM.value9.intValue())); RM.value10 = new BigDecimal(sharedPref.getInt("RM value10", RM.value10.intValue())); RM.value11 = new BigDecimal(sharedPref.getInt("RM value11", RM.value11.intValue())); RM.value12 = new BigDecimal(sharedPref.getInt("RM value12", RM.value12.intValue())); RM.value13 = new BigDecimal(sharedPref.getInt("RM value13", RM.value13.intValue())); RM.value14 = new BigDecimal(sharedPref.getInt("RM value14", RM.value14.intValue())); RM.value15 = new BigDecimal(sharedPref.getInt("RM value15", RM.value15.intValue())); RM.value16 = new BigDecimal(sharedPref.getInt("RM value16", RM.value16.intValue())); RM.value17 = new BigDecimal(sharedPref.getInt("RM value17", RM.value17.intValue())); RM.value18 = new BigDecimal(sharedPref.getInt("RM value18", RM.value18.intValue())); RM.value19 = new BigDecimal(sharedPref.getInt("RM value19", RM.value19.intValue())); RM.value20 = new BigDecimal(sharedPref.getInt("RM value20", RM.value20.intValue())); RM.value21 = new BigDecimal(sharedPref.getInt("RM value21", RM.value21.intValue())); RM.value22 = new BigDecimal(sharedPref.getInt("RM value22", RM.value22.intValue())); RM.value23 = new BigDecimal(sharedPref.getInt("RM value23", RM.value23.intValue())); RM.value24 = new BigDecimal(sharedPref.getInt("RM value24", RM.value24.intValue())); RM.value25 = new BigDecimal(sharedPref.getInt("RM value25", RM.value25.intValue())); RM.value26 = new BigDecimal(sharedPref.getInt("RM value26", RM.value26.intValue())); RM.value27 = new BigDecimal(sharedPref.getInt("RM value27", RM.value27.intValue())); RM.value28 = new BigDecimal(sharedPref.getInt("RM value28", RM.value8.intValue())); RM.value29 = new BigDecimal(sharedPref.getInt("RM value29", RM.value29.intValue())); RM.value30 = new BigDecimal(sharedPref.getInt("RM value30", RM.value30.intValue()));
        IBC.value = new BigDecimal(sharedPref.getInt("IBC value", IBC.value.intValue())); IBC.value2 = new BigDecimal(sharedPref.getInt("IBC value2", IBC.value2.intValue())); IBC.value3 = new BigDecimal(sharedPref.getInt("IBC value3", IBC.value3.intValue())); IBC.value4 = new BigDecimal(sharedPref.getInt("IBC value4", IBC.value4.intValue())); IBC.value5 = new BigDecimal(sharedPref.getInt("IBC value5", IBC.value5.intValue())); IBC.value6 = new BigDecimal(sharedPref.getInt("IBC value6", IBC.value6.intValue())); IBC.value7 = new BigDecimal(sharedPref.getInt("IBC value7", IBC.value7.intValue())); IBC.value8 = new BigDecimal(sharedPref.getInt("IBC value8", IBC.value8.intValue())); IBC.value9 = new BigDecimal(sharedPref.getInt("IBC value9", IBC.value9.intValue())); IBC.value10 = new BigDecimal(sharedPref.getInt("IBC value10", IBC.value10.intValue())); IBC.value11 = new BigDecimal(sharedPref.getInt("IBC value11", IBC.value11.intValue())); IBC.value12 = new BigDecimal(sharedPref.getInt("IBC value12", IBC.value12.intValue())); IBC.value13 = new BigDecimal(sharedPref.getInt("IBC value13", IBC.value13.intValue())); IBC.value14 = new BigDecimal(sharedPref.getInt("IBC value14", IBC.value14.intValue())); IBC.value15 = new BigDecimal(sharedPref.getInt("IBC value15", IBC.value15.intValue())); IBC.value16 = new BigDecimal(sharedPref.getInt("IBC value16", IBC.value16.intValue())); IBC.value17 = new BigDecimal(sharedPref.getInt("IBC value17", IBC.value17.intValue())); IBC.value18 = new BigDecimal(sharedPref.getInt("IBC value18", IBC.value18.intValue())); IBC.value19 = new BigDecimal(sharedPref.getInt("IBC value19", IBC.value19.intValue())); IBC.value20 = new BigDecimal(sharedPref.getInt("IBC value20", IBC.value20.intValue())); IBC.value21 = new BigDecimal(sharedPref.getInt("IBC value21", IBC.value21.intValue())); IBC.value22 = new BigDecimal(sharedPref.getInt("IBC value22", IBC.value22.intValue())); IBC.value23 = new BigDecimal(sharedPref.getInt("IBC value23", IBC.value23.intValue())); IBC.value24 = new BigDecimal(sharedPref.getInt("IBC value24", IBC.value24.intValue())); IBC.value25 = new BigDecimal(sharedPref.getInt("IBC value25", IBC.value25.intValue())); IBC.value26 = new BigDecimal(sharedPref.getInt("IBC value26", IBC.value26.intValue())); IBC.value27 = new BigDecimal(sharedPref.getInt("IBC value27", IBC.value27.intValue())); IBC.value28 = new BigDecimal(sharedPref.getInt("IBC value28", IBC.value8.intValue())); IBC.value29 = new BigDecimal(sharedPref.getInt("IBC value29", IBC.value29.intValue())); IBC.value30 = new BigDecimal(sharedPref.getInt("IBC value30", IBC.value30.intValue()));
        FWB.value = new BigDecimal(sharedPref.getInt("FWB value", FWB.value.intValue())); FWB.value2 = new BigDecimal(sharedPref.getInt("FWB value2", FWB.value2.intValue())); FWB.value3 = new BigDecimal(sharedPref.getInt("FWB value3", FWB.value3.intValue())); FWB.value4 = new BigDecimal(sharedPref.getInt("FWB value4", FWB.value4.intValue())); FWB.value5 = new BigDecimal(sharedPref.getInt("FWB value5", FWB.value5.intValue())); FWB.value6 = new BigDecimal(sharedPref.getInt("FWB value6", FWB.value6.intValue())); FWB.value7 = new BigDecimal(sharedPref.getInt("FWB value7", FWB.value7.intValue())); FWB.value8 = new BigDecimal(sharedPref.getInt("FWB value8", FWB.value8.intValue())); FWB.value9 = new BigDecimal(sharedPref.getInt("FWB value9", FWB.value9.intValue())); FWB.value10 = new BigDecimal(sharedPref.getInt("FWB value10", FWB.value10.intValue())); FWB.value11 = new BigDecimal(sharedPref.getInt("FWB value11", FWB.value11.intValue())); FWB.value12 = new BigDecimal(sharedPref.getInt("FWB value12", FWB.value12.intValue())); FWB.value13 = new BigDecimal(sharedPref.getInt("FWB value13", FWB.value13.intValue())); FWB.value14 = new BigDecimal(sharedPref.getInt("FWB value14", FWB.value14.intValue())); FWB.value15 = new BigDecimal(sharedPref.getInt("FWB value15", FWB.value15.intValue())); FWB.value16 = new BigDecimal(sharedPref.getInt("FWB value16", FWB.value16.intValue())); FWB.value17 = new BigDecimal(sharedPref.getInt("FWB value17", FWB.value17.intValue())); FWB.value18 = new BigDecimal(sharedPref.getInt("FWB value18", FWB.value18.intValue())); FWB.value19 = new BigDecimal(sharedPref.getInt("FWB value19", FWB.value19.intValue())); FWB.value20 = new BigDecimal(sharedPref.getInt("FWB value20", FWB.value20.intValue())); FWB.value21 = new BigDecimal(sharedPref.getInt("FWB value21", FWB.value21.intValue())); FWB.value22 = new BigDecimal(sharedPref.getInt("FWB value22", FWB.value22.intValue())); FWB.value23 = new BigDecimal(sharedPref.getInt("FWB value23", FWB.value23.intValue())); FWB.value24 = new BigDecimal(sharedPref.getInt("FWB value24", FWB.value24.intValue())); FWB.value25 = new BigDecimal(sharedPref.getInt("FWB value25", FWB.value25.intValue())); FWB.value26 = new BigDecimal(sharedPref.getInt("FWB value26", FWB.value26.intValue())); FWB.value27 = new BigDecimal(sharedPref.getInt("FWB value27", FWB.value27.intValue())); FWB.value28 = new BigDecimal(sharedPref.getInt("FWB value28", FWB.value8.intValue())); FWB.value29 = new BigDecimal(sharedPref.getInt("FWB value29", FWB.value29.intValue())); FWB.value30 = new BigDecimal(sharedPref.getInt("FWB value30", FWB.value30.intValue()));
        KC.value = new BigDecimal(sharedPref.getInt("KC value", KC.value.intValue())); KC.value2 = new BigDecimal(sharedPref.getInt("KC value2", KC.value2.intValue())); KC.value3 = new BigDecimal(sharedPref.getInt("KC value3", KC.value3.intValue())); KC.value4 = new BigDecimal(sharedPref.getInt("KC value4", KC.value4.intValue())); KC.value5 = new BigDecimal(sharedPref.getInt("KC value5", KC.value5.intValue())); KC.value6 = new BigDecimal(sharedPref.getInt("KC value6", KC.value6.intValue())); KC.value7 = new BigDecimal(sharedPref.getInt("KC value7", KC.value7.intValue())); KC.value8 = new BigDecimal(sharedPref.getInt("KC value8", KC.value8.intValue())); KC.value9 = new BigDecimal(sharedPref.getInt("KC value9", KC.value9.intValue())); KC.value10 = new BigDecimal(sharedPref.getInt("KC value10", KC.value10.intValue())); KC.value11 = new BigDecimal(sharedPref.getInt("KC value11", KC.value11.intValue())); KC.value12 = new BigDecimal(sharedPref.getInt("KC value12", KC.value12.intValue())); KC.value13 = new BigDecimal(sharedPref.getInt("KC value13", KC.value13.intValue())); KC.value14 = new BigDecimal(sharedPref.getInt("KC value14", KC.value14.intValue())); KC.value15 = new BigDecimal(sharedPref.getInt("KC value15", KC.value15.intValue())); KC.value16 = new BigDecimal(sharedPref.getInt("KC value16", KC.value16.intValue())); KC.value17 = new BigDecimal(sharedPref.getInt("KC value17", KC.value17.intValue())); KC.value18 = new BigDecimal(sharedPref.getInt("KC value18", KC.value18.intValue())); KC.value19 = new BigDecimal(sharedPref.getInt("KC value19", KC.value19.intValue())); KC.value20 = new BigDecimal(sharedPref.getInt("KC value20", KC.value20.intValue())); KC.value21 = new BigDecimal(sharedPref.getInt("KC value21", KC.value21.intValue())); KC.value22 = new BigDecimal(sharedPref.getInt("KC value22", KC.value22.intValue())); KC.value23 = new BigDecimal(sharedPref.getInt("KC value23", KC.value23.intValue())); KC.value24 = new BigDecimal(sharedPref.getInt("KC value24", KC.value24.intValue())); KC.value25 = new BigDecimal(sharedPref.getInt("KC value25", KC.value25.intValue())); KC.value26 = new BigDecimal(sharedPref.getInt("KC value26", KC.value26.intValue())); KC.value27 = new BigDecimal(sharedPref.getInt("KC value27", KC.value27.intValue())); KC.value28 = new BigDecimal(sharedPref.getInt("KC value28", KC.value8.intValue())); KC.value29 = new BigDecimal(sharedPref.getInt("KC value29", KC.value29.intValue())); KC.value30 = new BigDecimal(sharedPref.getInt("FWB value30", KC.value30.intValue()));

    }

    void resetVariables() {
        int hW = hasWon;
        int hS = highScore;
        if (hS < daysNotDead)
            hS = daysNotDead;
        int fTP = returningPlayer;

        initVariablesFromSave();
        editor.clear();
        //returningPlayer / highScore don't actually change (set them to itself)
        editor.putInt("returningPlayer", fTP);
        editor.putInt("highScore", hS);
        editor.putInt("hasWon", hW);
        editor.apply();
        highScore = hS;
        returningPlayer = fTP;
        hasWon = hW;
    }

    void updateVariables() {
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

        editor.putInt("totalEarned", 0);

        String c = taxCollection.toString();
        editor.putString("taxCollectionS", c);

        editor.putInt("healthRange", healthLevel);
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
        editor.putInt("successMessage", successMessage);
        editor.putInt("dayMessage", dayMessage);
        editor.putInt("loveMessage", loveMessage);
        editor.putInt("luxuryMessage", luxuryMessage);
        editor.putInt("careerMessage", careerMessage);
        editor.putInt("cheatingCounter", cheatingCounter);

        editor.apply();
    }

    void updateStockVariables() {
        //Please bear with me, the following ways are terrible ways to save data,
        //and I could have totally done it recursively but I was too lazy.

        //Saves to disk the shares owned
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

        //Saves to disk the values of each stock
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
        editor.putInt("KC value", KC.value.intValue());

        //Saves to disk the state of each stock's growth (positive or negative)
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
        editor.putInt("KC growth", KC.growth);

        //Saves to disk the state of each stock's moving period
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
        editor.putInt("KC movingPeriod", KC.movingPeriod);

        //Saves to disk the state of each stock's previous values
        editor.putInt("ET value", ET.value.intValue()); editor.putInt("ET value2", ET.value2.intValue()); editor.putInt("ET value3", ET.value3.intValue()); editor.putInt("ET value4", ET.value4.intValue()); editor.putInt("ET value5", ET.value5.intValue()); editor.putInt("ET value6", ET.value6.intValue()); editor.putInt("ET value7", ET.value7.intValue()); editor.putInt("ET value8", ET.value8.intValue()); editor.putInt("ET value9", ET.value9.intValue()); editor.putInt("ET value10", ET.value10.intValue()); editor.putInt("ET value11", ET.value11.intValue()); editor.putInt("ET value12", ET.value12.intValue()); editor.putInt("ET value13", ET.value13.intValue()); editor.putInt("ET value14", ET.value14.intValue()); editor.putInt("ET value15", ET.value15.intValue()); editor.putInt("ET value16", ET.value16.intValue()); editor.putInt("ET value17", ET.value17.intValue()); editor.putInt("ET value18", ET.value18.intValue()); editor.putInt("ET value19", ET.value19.intValue()); editor.putInt("ET value20", ET.value20.intValue()); editor.putInt("ET value21", ET.value21.intValue()); editor.putInt("ET value22", ET.value22.intValue()); editor.putInt("ET value23", ET.value23.intValue()); editor.putInt("ET value24", ET.value24.intValue()); editor.putInt("ET value25", ET.value25.intValue()); editor.putInt("ET value26", ET.value26.intValue()); editor.putInt("ET value27", ET.value27.intValue()); editor.putInt("ET value28", ET.value28.intValue()); editor.putInt("ET value29", ET.value29.intValue()); editor.putInt("ET value30", ET.value30.intValue());
        editor.putInt("NSX value", NSX.value.intValue()); editor.putInt("NSX value2", NSX.value2.intValue()); editor.putInt("NSX value3", NSX.value3.intValue()); editor.putInt("NSX value4", NSX.value4.intValue()); editor.putInt("NSX value5", NSX.value5.intValue()); editor.putInt("NSX value6", NSX.value6.intValue()); editor.putInt("NSX value7", NSX.value7.intValue()); editor.putInt("NSX value8", NSX.value8.intValue()); editor.putInt("NSX value9", NSX.value9.intValue()); editor.putInt("NSX value10", NSX.value10.intValue()); editor.putInt("NSX value11", NSX.value11.intValue()); editor.putInt("NSX value12", NSX.value12.intValue()); editor.putInt("NSX value13", NSX.value13.intValue()); editor.putInt("NSX value14", NSX.value14.intValue()); editor.putInt("NSX value15", NSX.value15.intValue()); editor.putInt("NSX value16", NSX.value16.intValue()); editor.putInt("NSX value17", NSX.value17.intValue()); editor.putInt("NSX value18", NSX.value18.intValue()); editor.putInt("NSX value19", NSX.value19.intValue()); editor.putInt("NSX value20", NSX.value20.intValue()); editor.putInt("NSX value21", NSX.value21.intValue()); editor.putInt("NSX value22", NSX.value22.intValue()); editor.putInt("NSX value23", NSX.value23.intValue()); editor.putInt("NSX value24", NSX.value24.intValue()); editor.putInt("NSX value25", NSX.value25.intValue()); editor.putInt("NSX value26", NSX.value26.intValue()); editor.putInt("NSX value27", NSX.value27.intValue()); editor.putInt("NSX value28", NSX.value28.intValue()); editor.putInt("NSX value29", NSX.value29.intValue()); editor.putInt("NSX value30", NSX.value30.intValue());
        editor.putInt("FU value", FU.value.intValue()); editor.putInt("FU value2", FU.value2.intValue()); editor.putInt("FU value3", FU.value3.intValue()); editor.putInt("FU value4", FU.value4.intValue()); editor.putInt("FU value5", FU.value5.intValue()); editor.putInt("FU value6", FU.value6.intValue()); editor.putInt("FU value7", FU.value7.intValue()); editor.putInt("FU value8", FU.value8.intValue()); editor.putInt("FU value9", FU.value9.intValue()); editor.putInt("FU value10", FU.value10.intValue()); editor.putInt("FU value11", FU.value11.intValue()); editor.putInt("FU value12", FU.value12.intValue()); editor.putInt("FU value13", FU.value13.intValue()); editor.putInt("FU value14", FU.value14.intValue()); editor.putInt("FU value15", FU.value15.intValue()); editor.putInt("FU value16", FU.value16.intValue()); editor.putInt("FU value17", FU.value17.intValue()); editor.putInt("FU value18", FU.value18.intValue()); editor.putInt("FU value19", FU.value19.intValue()); editor.putInt("FU value20", FU.value20.intValue()); editor.putInt("FU value21", FU.value21.intValue()); editor.putInt("FU value22", FU.value22.intValue()); editor.putInt("FU value23", FU.value23.intValue()); editor.putInt("FU value24", FU.value24.intValue()); editor.putInt("FU value25", FU.value25.intValue()); editor.putInt("FU value26", FU.value26.intValue()); editor.putInt("FU value27", FU.value27.intValue()); editor.putInt("FU value28", FU.value28.intValue()); editor.putInt("FU value29", FU.value29.intValue()); editor.putInt("FU value30", FU.value30.intValue());
        editor.putInt("AP value", AP.value.intValue()); editor.putInt("AP value2", AP.value2.intValue()); editor.putInt("AP value3", AP.value3.intValue()); editor.putInt("AP value4", AP.value4.intValue()); editor.putInt("AP value5", AP.value5.intValue()); editor.putInt("AP value6", AP.value6.intValue()); editor.putInt("AP value7", AP.value7.intValue()); editor.putInt("AP value8", AP.value8.intValue()); editor.putInt("AP value9", AP.value9.intValue()); editor.putInt("AP value10", AP.value10.intValue()); editor.putInt("AP value11", AP.value11.intValue()); editor.putInt("AP value12", AP.value12.intValue()); editor.putInt("AP value13", AP.value13.intValue()); editor.putInt("AP value14", AP.value14.intValue()); editor.putInt("AP value15", AP.value15.intValue()); editor.putInt("AP value16", AP.value16.intValue()); editor.putInt("AP value17", AP.value17.intValue()); editor.putInt("AP value18", AP.value18.intValue()); editor.putInt("AP value19", AP.value19.intValue()); editor.putInt("AP value20", AP.value20.intValue()); editor.putInt("AP value21", AP.value21.intValue()); editor.putInt("AP value22", AP.value22.intValue()); editor.putInt("AP value23", AP.value23.intValue()); editor.putInt("AP value24", AP.value24.intValue()); editor.putInt("AP value25", AP.value25.intValue()); editor.putInt("AP value26", AP.value26.intValue()); editor.putInt("AP value27", AP.value27.intValue()); editor.putInt("AP value28", AP.value28.intValue()); editor.putInt("AP value29", AP.value29.intValue()); editor.putInt("AP value30", AP.value30.intValue());
        editor.putInt("BNN value", BNN.value.intValue()); editor.putInt("BNN value2", BNN.value2.intValue()); editor.putInt("BNN value3", BNN.value3.intValue()); editor.putInt("BNN value4", BNN.value4.intValue()); editor.putInt("BNN value5", BNN.value5.intValue()); editor.putInt("BNN value6", BNN.value6.intValue()); editor.putInt("BNN value7", BNN.value7.intValue()); editor.putInt("BNN value8", BNN.value8.intValue()); editor.putInt("BNN value9", BNN.value9.intValue()); editor.putInt("BNN value10", BNN.value10.intValue()); editor.putInt("BNN value11", BNN.value11.intValue()); editor.putInt("BNN value12", BNN.value12.intValue()); editor.putInt("BNN value13", BNN.value13.intValue()); editor.putInt("BNN value14", BNN.value14.intValue()); editor.putInt("BNN value15", BNN.value15.intValue()); editor.putInt("BNN value16", BNN.value16.intValue()); editor.putInt("BNN value17", BNN.value17.intValue()); editor.putInt("BNN value18", BNN.value18.intValue()); editor.putInt("BNN value19", BNN.value19.intValue()); editor.putInt("BNN value20", BNN.value20.intValue()); editor.putInt("BNN value21", BNN.value21.intValue()); editor.putInt("BNN value22", BNN.value22.intValue()); editor.putInt("BNN value23", BNN.value23.intValue()); editor.putInt("BNN value24", BNN.value24.intValue()); editor.putInt("BNN value25", BNN.value25.intValue()); editor.putInt("BNN value26", BNN.value26.intValue()); editor.putInt("BNN value27", BNN.value27.intValue()); editor.putInt("BNN value28", BNN.value28.intValue()); editor.putInt("BNN value29", BNN.value29.intValue()); editor.putInt("BNN value30", BNN.value30.intValue());
        editor.putInt("MACA value", MACA.value.intValue()); editor.putInt("MACA value2", MACA.value2.intValue()); editor.putInt("MACA value3", MACA.value3.intValue()); editor.putInt("MACA value4", MACA.value4.intValue()); editor.putInt("MACA value5", MACA.value5.intValue()); editor.putInt("MACA value6", MACA.value6.intValue()); editor.putInt("MACA value7", MACA.value7.intValue()); editor.putInt("MACA value8", MACA.value8.intValue()); editor.putInt("MACA value9", MACA.value9.intValue()); editor.putInt("MACA value10", MACA.value10.intValue()); editor.putInt("MACA value11", MACA.value11.intValue()); editor.putInt("MACA value12", MACA.value12.intValue()); editor.putInt("MACA value13", MACA.value13.intValue()); editor.putInt("MACA value14", MACA.value14.intValue()); editor.putInt("MACA value15", MACA.value15.intValue()); editor.putInt("MACA value16", MACA.value16.intValue()); editor.putInt("MACA value17", MACA.value17.intValue()); editor.putInt("MACA value18", MACA.value18.intValue()); editor.putInt("MACA value19", MACA.value19.intValue()); editor.putInt("MACA value20", MACA.value20.intValue()); editor.putInt("MACA value21", MACA.value21.intValue()); editor.putInt("MACA value22", MACA.value22.intValue()); editor.putInt("MACA value23", MACA.value23.intValue()); editor.putInt("MACA value24", MACA.value24.intValue()); editor.putInt("MACA value25", MACA.value25.intValue()); editor.putInt("MACA value26", MACA.value26.intValue()); editor.putInt("MACA value27", MACA.value27.intValue()); editor.putInt("MACA value28", MACA.value28.intValue()); editor.putInt("MACA value29", MACA.value29.intValue()); editor.putInt("MACA value30", MACA.value30.intValue());
        editor.putInt("MACB value", MACB.value.intValue()); editor.putInt("MACB value2", MACB.value2.intValue()); editor.putInt("MACB value3", MACB.value3.intValue()); editor.putInt("MACB value4", MACB.value4.intValue()); editor.putInt("MACB value5", MACB.value5.intValue()); editor.putInt("MACB value6", MACB.value6.intValue()); editor.putInt("MACB value7", MACB.value7.intValue()); editor.putInt("MACB value8", MACB.value8.intValue()); editor.putInt("MACB value9", MACB.value9.intValue()); editor.putInt("MACB value10", MACB.value10.intValue()); editor.putInt("MACB value11", MACB.value11.intValue()); editor.putInt("MACB value12", MACB.value12.intValue()); editor.putInt("MACB value13", MACB.value13.intValue()); editor.putInt("MACB value14", MACB.value14.intValue()); editor.putInt("MACB value15", MACB.value15.intValue()); editor.putInt("MACB value16", MACB.value16.intValue()); editor.putInt("MACB value17", MACB.value17.intValue()); editor.putInt("MACB value18", MACB.value18.intValue()); editor.putInt("MACB value19", MACB.value19.intValue()); editor.putInt("MACB value20", MACB.value20.intValue()); editor.putInt("MACB value21", MACB.value21.intValue()); editor.putInt("MACB value22", MACB.value22.intValue()); editor.putInt("MACB value23", MACB.value23.intValue()); editor.putInt("MACB value24", MACB.value24.intValue()); editor.putInt("MACB value25", MACB.value25.intValue()); editor.putInt("MACB value26", MACB.value26.intValue()); editor.putInt("MACB value27", MACB.value27.intValue()); editor.putInt("MACB value28", MACB.value28.intValue()); editor.putInt("MACB value29", MACB.value29.intValue()); editor.putInt("MACB value30", MACB.value30.intValue());
        editor.putInt("MM value", MM.value.intValue()); editor.putInt("MM value2", MM.value2.intValue()); editor.putInt("MM value3", MM.value3.intValue()); editor.putInt("MM value4", MM.value4.intValue()); editor.putInt("MM value5", MM.value5.intValue()); editor.putInt("MM value6", MM.value6.intValue()); editor.putInt("MM value7", MM.value7.intValue()); editor.putInt("MM value8", MM.value8.intValue()); editor.putInt("MM value9", MM.value9.intValue()); editor.putInt("MM value10", MM.value10.intValue()); editor.putInt("MM value11", MM.value11.intValue()); editor.putInt("MM value12", MM.value12.intValue()); editor.putInt("MM value13", MM.value13.intValue()); editor.putInt("MM value14", MM.value14.intValue()); editor.putInt("MM value15", MM.value15.intValue()); editor.putInt("MM value16", MM.value16.intValue()); editor.putInt("MM value17", MM.value17.intValue()); editor.putInt("MM value18", MM.value18.intValue()); editor.putInt("MM value19", MM.value19.intValue()); editor.putInt("MM value20", MM.value20.intValue()); editor.putInt("MM value21", MM.value21.intValue()); editor.putInt("MM value22", MM.value22.intValue()); editor.putInt("MM value23", MM.value23.intValue()); editor.putInt("MM value24", MM.value24.intValue()); editor.putInt("MM value25", MM.value25.intValue()); editor.putInt("MM value26", MM.value26.intValue()); editor.putInt("MM value27", MM.value27.intValue()); editor.putInt("MM value28", MM.value28.intValue()); editor.putInt("MM value29", MM.value29.intValue()); editor.putInt("MM value30", MM.value30.intValue());
        editor.putInt("RM value", RM.value.intValue()); editor.putInt("RM value2", RM.value2.intValue()); editor.putInt("RM value3", RM.value3.intValue()); editor.putInt("RM value4", RM.value4.intValue()); editor.putInt("RM value5", RM.value5.intValue()); editor.putInt("RM value6", RM.value6.intValue()); editor.putInt("RM value7", RM.value7.intValue()); editor.putInt("RM value8", RM.value8.intValue()); editor.putInt("RM value9", RM.value9.intValue()); editor.putInt("RM value10", RM.value10.intValue()); editor.putInt("RM value11", RM.value11.intValue()); editor.putInt("RM value12", RM.value12.intValue()); editor.putInt("RM value13", RM.value13.intValue()); editor.putInt("RM value14", RM.value14.intValue()); editor.putInt("RM value15", RM.value15.intValue()); editor.putInt("RM value16", RM.value16.intValue()); editor.putInt("RM value17", RM.value17.intValue()); editor.putInt("RM value18", RM.value18.intValue()); editor.putInt("RM value19", RM.value19.intValue()); editor.putInt("RM value20", RM.value20.intValue()); editor.putInt("RM value21", RM.value21.intValue()); editor.putInt("RM value22", RM.value22.intValue()); editor.putInt("RM value23", RM.value23.intValue()); editor.putInt("RM value24", RM.value24.intValue()); editor.putInt("RM value25", RM.value25.intValue()); editor.putInt("RM value26", RM.value26.intValue()); editor.putInt("RM value27", RM.value27.intValue()); editor.putInt("RM value28", RM.value28.intValue()); editor.putInt("RM value29", RM.value29.intValue()); editor.putInt("RM value30", RM.value30.intValue());
        editor.putInt("IBC value", IBC.value.intValue()); editor.putInt("IBC value2", IBC.value2.intValue()); editor.putInt("IBC value3", IBC.value3.intValue()); editor.putInt("IBC value4", IBC.value4.intValue()); editor.putInt("IBC value5", IBC.value5.intValue()); editor.putInt("IBC value6", IBC.value6.intValue()); editor.putInt("IBC value7", IBC.value7.intValue()); editor.putInt("IBC value8", IBC.value8.intValue()); editor.putInt("IBC value9", IBC.value9.intValue()); editor.putInt("IBC value10", IBC.value10.intValue()); editor.putInt("IBC value11", IBC.value11.intValue()); editor.putInt("IBC value12", IBC.value12.intValue()); editor.putInt("IBC value13", IBC.value13.intValue()); editor.putInt("IBC value14", IBC.value14.intValue()); editor.putInt("IBC value15", IBC.value15.intValue()); editor.putInt("IBC value16", IBC.value16.intValue()); editor.putInt("IBC value17", IBC.value17.intValue()); editor.putInt("IBC value18", IBC.value18.intValue()); editor.putInt("IBC value19", IBC.value19.intValue()); editor.putInt("IBC value20", IBC.value20.intValue()); editor.putInt("IBC value21", IBC.value21.intValue()); editor.putInt("IBC value22", IBC.value22.intValue()); editor.putInt("IBC value23", IBC.value23.intValue()); editor.putInt("IBC value24", IBC.value24.intValue()); editor.putInt("IBC value25", IBC.value25.intValue()); editor.putInt("IBC value26", IBC.value26.intValue()); editor.putInt("IBC value27", IBC.value27.intValue()); editor.putInt("IBC value28", IBC.value28.intValue()); editor.putInt("IBC value29", IBC.value29.intValue()); editor.putInt("IBC value30", IBC.value30.intValue());
        editor.putInt("FWB value", FWB.value.intValue()); editor.putInt("FWB value2", FWB.value2.intValue()); editor.putInt("FWB value3", FWB.value3.intValue()); editor.putInt("FWB value4", FWB.value4.intValue()); editor.putInt("FWB value5", FWB.value5.intValue()); editor.putInt("FWB value6", FWB.value6.intValue()); editor.putInt("FWB value7", FWB.value7.intValue()); editor.putInt("FWB value8", FWB.value8.intValue()); editor.putInt("FWB value9", FWB.value9.intValue()); editor.putInt("FWB value10", FWB.value10.intValue()); editor.putInt("FWB value11", FWB.value11.intValue()); editor.putInt("FWB value12", FWB.value12.intValue()); editor.putInt("FWB value13", FWB.value13.intValue()); editor.putInt("FWB value14", FWB.value14.intValue()); editor.putInt("FWB value15", FWB.value15.intValue()); editor.putInt("FWB value16", FWB.value16.intValue()); editor.putInt("FWB value17", FWB.value17.intValue()); editor.putInt("FWB value18", FWB.value18.intValue()); editor.putInt("FWB value19", FWB.value19.intValue()); editor.putInt("FWB value20", FWB.value20.intValue()); editor.putInt("FWB value21", FWB.value21.intValue()); editor.putInt("FWB value22", FWB.value22.intValue()); editor.putInt("FWB value23", FWB.value23.intValue()); editor.putInt("FWB value24", FWB.value24.intValue()); editor.putInt("FWB value25", FWB.value25.intValue()); editor.putInt("FWB value26", FWB.value26.intValue()); editor.putInt("FWB value27", FWB.value27.intValue()); editor.putInt("FWB value28", FWB.value28.intValue()); editor.putInt("FWB value29", FWB.value29.intValue()); editor.putInt("FWB value30", FWB.value30.intValue());
        editor.putInt("KC value", KC.value.intValue()); editor.putInt("KC value2", KC.value2.intValue()); editor.putInt("KC value3", KC.value3.intValue()); editor.putInt("KC value4", KC.value4.intValue()); editor.putInt("KC value5", KC.value5.intValue()); editor.putInt("KC value6", KC.value6.intValue()); editor.putInt("KC value7", KC.value7.intValue()); editor.putInt("KC value8", KC.value8.intValue()); editor.putInt("KC value9", KC.value9.intValue()); editor.putInt("KC value10", KC.value10.intValue()); editor.putInt("KC value11", KC.value11.intValue()); editor.putInt("KC value12", KC.value12.intValue()); editor.putInt("KC value13", KC.value13.intValue()); editor.putInt("KC value14", KC.value14.intValue()); editor.putInt("KC value15", KC.value15.intValue()); editor.putInt("KC value16", KC.value16.intValue()); editor.putInt("KC value17", KC.value17.intValue()); editor.putInt("KC value18", KC.value18.intValue()); editor.putInt("KC value19", KC.value19.intValue()); editor.putInt("KC value20", KC.value20.intValue()); editor.putInt("KC value21", KC.value21.intValue()); editor.putInt("KC value22", KC.value22.intValue()); editor.putInt("KC value23", KC.value23.intValue()); editor.putInt("KC value24", KC.value24.intValue()); editor.putInt("KC value25", KC.value25.intValue()); editor.putInt("KC value26", KC.value26.intValue()); editor.putInt("KC value27", KC.value27.intValue()); editor.putInt("KC value28", KC.value28.intValue()); editor.putInt("KC value29", KC.value29.intValue()); editor.putInt("KC value30", KC.value30.intValue());

        String i = netWorth.toString();
        editor.putString("netWorthS", i);

        editor.apply();
    }


    // ------------- TUTORIAL ---------------------------------------------------------------


    public void functionTut1(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tutorial1Fragment());
        fragmentTransaction.commitNow();
    }

    public void functionTut2(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tutorial2Fragment());
        fragmentTransaction.commitNow();
    }

    public void functionTut3(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tutorial3Fragment());
        fragmentTransaction.commitNow();
    }

    public void functionTut4(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tutorial4Fragment());
        fragmentTransaction.commitNow();
    }

    public void functionTut5(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tutorial5Fragment());
        fragmentTransaction.commitNow();
    }

    public void functionTut6(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Tutorial6Fragment());
        fragmentTransaction.commitNow();
    }
    public void functionDrawer(View view ) {
        //drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.openDrawer(Gravity.LEFT);
        //drawerButton.setVisibility(View.INVISIBLE);
        //------------- PHYSICAL ---------------------------------------------------------------
        // ------------ DIFFICULTY -------------------------------------------------------------
    }


    public void functionRealistic(View view ) {
        difficulty = 1;

        if (returningPlayer == 0) // TODO: bugfix the tutorial
        {
            functionTut1(null);
            return;
        }

        messagePrompt(getRandomString("<< Ah, choosing the scenic route? >>", "<< Enjoy the slightly less painful adventure. >>",
                "<< A stellar first choice to begin a sea of mediocre ones. >>", "<< A mighty decision in regards to your well-being. >>",
                "<< You delay the inevitable with a less burdensome path. >>"), 1000);
        updateHealthAndHappiness();
        functionPhysical(null);
    }
    public void functionHardAsHell(View view ) {
        difficulty = 2;
        healthDrain = healthDrain + 2;
        happinessDrain = happinessDrain + 2;
        healthLevel = healthLevel - 13;
        happinessLevel = happinessLevel - 13;
        updateHealthAndHappiness();

        if (returningPlayer == 0)
        {
            functionTut1(null);
            return;
        }

        messagePrompt(getRandomString("<< Too dim-witted to choose the above, too apprehensive to choose below. >>",
                "<< Balanced as all things should be. >>", "<< Where the flames tickle but don't scorch... >>"), 1000);

        functionPhysical(null);
    }
    public void functionEndMySuffering(View view ) {
        if (hasWon != 1)
        {
            messagePrompt("You need to win the game before unlocking this difficulty.", 700);
            return;
        }
        if (respawnToken > 0)
        {
            messagePrompt("You have at least 1 Respawn Token in inventory.\n\n<< I cannot let you begin this difficulty with a spare life. Do what you will with that. >>", 1200);
            return;
        }

        difficulty = 3;
        healthDrain = healthDrain + 2;
        happinessDrain = happinessDrain + 2;
        healthLevel = healthLevel - 13;
        happinessLevel = happinessLevel - 13;
        updateHealthAndHappiness();

        messagePrompt(getRandomString("<< The time is now for divine judgement. >>", "<< My friends pause to spectate your fate. >>",
                "<< Your days are, literally, numbered. >>"), 1000);

        functionPhysical(null);
    }

    public void functionHealth(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new HealthFragment());
        fragmentTransaction.commitNow();
    }

    public void functionPhysical(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new PhysicalFragment());
        fragmentTransaction.commitNow();
        // if (getSupportFragmentManager().executePendingTransactions()) {
                        // Ignore stupid conditional: regex, text search thing
                        if (0 == 0) {
            if (daysNotDead < 35) // TODO: Explore why is if (TextView) findViewById(R.id.buttonAid) sometimes null
                if ((TextView) findViewById(R.id.buttonAid) != null)
                    ((TextView) findViewById(R.id.buttonAid)).setText("Seek professional help. (LOCKED)");
            if (daysNotDead < 80)
                if ((TextView) findViewById(R.id.buttonEnhance) != null)
                    ((TextView) findViewById(R.id.buttonEnhance)).setText("Enhance your physiology. (LOCKED)");

        }
    }

    public void functionAid(View view ) {

        if (daysNotDead < 35)//15
        {
            messagePrompt("You need to survive 35 days before seeking professional help.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new AidFragment());
        fragmentTransaction.commitNow();
    }

    public void functionEnhance(View view ) {
        if (daysNotDead < 80)//50
        {
            messagePrompt(" You need to survive 80 days before experimenting on your body.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new EnhanceFragment());
        fragmentTransaction.commitNow();
    }

    public void functionShake(View view ) {
        if (canIAffordIt("35.00")) {
            pShakeCounter++;
            int temp = pShakeCounter;
            statChanges(12, -1, "35.00");

            pShakeCounter = temp;
            if (pShakeCounter > 6 && new Random().nextDouble() < 0.50) {
                healthLevel = healthLevel - 5;

                amIDeadYet(getRandomString("Protein poisoning.", "Protein toxicity.", "Hyperproteinemia.", "Proteotoxicity.", "Aminoacidemia.", "Protein-Induced Ketosis."));
                messagePrompt(getRandomString("You are drinking too many shakes. You are beginning to make yourself sick.", "You are consuming too many. You are starting to get sick."), 1500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 2;

                amIDeadYet(getRandomString("Protein poisoning.", "Protein toxicity.", "Hyperproteinemia.", "Proteotoxicity.", "Aminoacidemia.", "Protein-Induced Ketosis."));
                messagePrompt("Don't fool yourself, this tastes disgusting.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 2;

                amIDeadYet(getRandomString("Protein poisoning.", "Protein toxicity.", "Hyperproteinemia.", "Proteotoxicity.", "Aminoacidemia.", "Protein-Induced Ketosis."));
                messagePrompt("You'll be fit in no time.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                healthLevel = healthLevel + 2;

                amIDeadYet(getRandomString("Protein poisoning.", "Protein toxicity.", "Hyperproteinemia.", "Proteotoxicity.", "Aminoacidemia.", "Protein-Induced Ketosis."));
                messagePrompt("Like steak in a bottle.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 2;
                healthLevel = healthLevel - 2;
                amIDeadYet(getRandomString("Protein poisoning.", "Protein toxicity.", "Hyperproteinemia.", "Proteotoxicity.", "Aminoacidemia.", "Protein-Induced Ketosis."));
                messagePrompt("I am a total fitness junkie! OMG", 500);

                return;
            }
            if (new Random().nextDouble() < 0.06) {
                happinessLevel = happinessLevel + 2;
                amIDeadYet(getRandomString("Protein poisoning.", "Protein toxicity.", "Hyperproteinemia.", "Proteotoxicity.", "Aminoacidemia.", "Protein-Induced Ketosis."));
                messagePrompt(getRandomString("Just a splash of Rum...", "Just a dash of Vodka...", "Just a dribble of Whiskey...", "Just a drop of Gin...", "Just a smidgen of Brandy...", "Just a speck of Bourbon..."), 500);
                return;
            }
            amIDeadYet(getRandomString("Protein poisoning.", "Protein toxicity.", "Hyperproteinemia.", "Proteotoxicity.", "Aminoacidemia.", "Protein-Induced Ketosis."));
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionGym(View view ) {

        Random rand2 = new Random();

        /* randomNum = minimum + rand.nextInt((maximum - minimum) + 1); */
        int rHappiness = -6 + rand2.nextInt((8 - -6) + 1);
        if (canIAffordIt("90.00")) {
            gymCounter++;
            int temp = gymCounter;
            statChanges(19, rHappiness, "90.00");
            gymCounter = temp;

            if (hasPartner == 0) {
                if (new Random().nextDouble() < 0.015) {
                    happinessLevel = happinessLevel + 20;
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet(getRandomString("Went too hard at the gym.", "Overexertion leading to cardiac arrest.", "Slip and fall accident with gym equipment.", "Severe dehydration during intense workout.", "Fatal accident with heavy weights.", "Electrocution from faulty gym machinery.", "Allergic reaction to the pre-workout.", "Heat stroke during high-intensity training."));
                    messagePrompt("At the gym, you meet a cute workout buddy. Weeks of awkward grins & fist bumps haven't accomplished much, but today is somehow miraculously different. \n\n<< You're welcome. >> " +
                            "\n\nYou can now go on dates with your gym partner.", 3000);
                    return;
                }
            }
            if (gymCounter > 4 && new Random().nextDouble() < 0.50) {
                healthLevel = healthLevel - 7;
                amIDeadYet(getRandomString("Went too hard at the gym.", "Overexertion leading to cardiac arrest.", "Slip and fall accident with gym equipment.", "Severe dehydration during intense workout.", "Fatal accident with heavy weights.", "Electrocution from faulty gym machinery.", "Allergic reaction to the pre-workout.", "Heat stroke during high-intensity training."));
                messagePrompt(getRandomString("Your frequent gym sessions are leading to fatigue and increasing injury risk.", "Excessive workouts are causing exhaustion and recurrent injuries.", "Constant training is taking a toll, resulting in weariness and harm to your body.", "Over-training is leading to burnout and making you more prone to injuries.", "Your relentless exercise routine is causing physical strain and recurring injuries."), 2000);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 7;
                healthLevel = healthLevel + 4;
                amIDeadYet(getRandomString("Went too hard at the gym.", "Overexertion leading to cardiac arrest.", "Slip and fall accident with gym equipment.", "Severe dehydration during intense workout.", "Fatal accident with heavy weights.", "Electrocution from faulty gym machinery.", "Allergic reaction to the pre-workout.", "Heat stroke during high-intensity training."));
                messagePrompt("The endorphins are pumping and you feel great. Today was a " +
                        "very productive workout.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 4;
                amIDeadYet(getRandomString("Went too hard at the gym.", "Overexertion leading to cardiac arrest.", "Slip and fall accident with gym equipment.", "Severe dehydration during intense workout.", "Fatal accident with heavy weights.", "Electrocution from faulty gym machinery.", "Allergic reaction to the pre-workout.", "Heat stroke during high-intensity training."));
                messagePrompt("Be physically stronger than what you mentally feel.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 5;
                amIDeadYet(getRandomString("Went too hard at the gym.", "Overexertion leading to cardiac arrest.", "Slip and fall accident with gym equipment.", "Severe dehydration during intense workout.", "Fatal accident with heavy weights.", "Electrocution from faulty gym machinery.", "Allergic reaction to the pre-workout.", "Heat stroke during high-intensity training."));
                messagePrompt(" A productive day at the gym always begins with a heavily filtered selfie.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 4;

                amIDeadYet(getRandomString("Went too hard at the gym.", "Overexertion leading to cardiac arrest.", "Slip and fall accident with gym equipment.", "Severe dehydration during intense workout.", "Fatal accident with heavy weights.", "Electrocution from faulty gym machinery.", "Allergic reaction to the pre-workout.", "Heat stroke during high-intensity training."));
                messagePrompt("Sweat is just your fat crying.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 2;
                healthLevel = healthLevel + 5;
                amIDeadYet(getRandomString("Went too hard at the gym.", "Overexertion leading to cardiac arrest.", "Slip and fall accident with gym equipment.", "Severe dehydration during intense workout.", "Fatal accident with heavy weights.", "Electrocution from faulty gym machinery.", "Allergic reaction to the pre-workout.", "Heat stroke during high-intensity training."));
                messagePrompt("Never skip leg day.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 2;
                healthLevel = healthLevel + 3;
                amIDeadYet(getRandomString("Went too hard at the gym.", "Overexertion leading to cardiac arrest.", "Slip and fall accident with gym equipment.", "Severe dehydration during intense workout.", "Fatal accident with heavy weights.", "Electrocution from faulty gym machinery.", "Allergic reaction to the pre-workout.", "Heat stroke during high-intensity training."));
                messagePrompt("Look at all the people that are in better shape than you are.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 7;
                healthLevel = healthLevel - 9;
                amIDeadYet(getRandomString("Went too hard at the gym.", "Overexertion leading to cardiac arrest.", "Slip and fall accident with gym equipment.", "Severe dehydration during intense workout.", "Fatal accident with heavy weights.", "Electrocution from faulty gym machinery.", "Allergic reaction to the pre-workout.", "Heat stroke during high-intensity training."));
                messagePrompt("You were careless and dropped a weight on yourself. Be careful.", 1000);
                return;
            }

            amIDeadYet(getRandomString("Went too hard at the gym.", "Overexertion leading to cardiac arrest.", "Slip and fall accident with gym equipment.", "Severe dehydration during intense workout.", "Fatal accident with heavy weights.", "Electrocution from faulty gym machinery.", "Allergic reaction to the pre-workout.", "Heat stroke during high-intensity training."));
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionSupplements(View view ) {
        if (canIAffordIt("200.00")) {
            supplementCounter++;
            int temp = supplementCounter;
            statChanges(44, -6, "200.00");
            supplementCounter = temp;

            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.01) {
                    happinessLevel = happinessLevel + 30;
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet(getRandomString("Choked on a tablet.", "Supplement pill overdose.", "Had a severe allergic reaction to unknown supplement.", "Excessive insoluble vitamin intake.", "Choked on a pill.", "Clogged airway by pill."));
                    messagePrompt(" Even though the cashier is scanning your items, they are the one you're interested in checking out"
                            + " tonight. \n\nYou are no longer single and can now go on dates with the clerk.", 2500);
                    return;
                }
            }

            if (new Random().nextDouble() < .5 && supplementCounter > 4) {
                healthLevel = healthLevel - 20;
                amIDeadYet(getRandomString("Choked on a tablet.", "Supplement pill overdose.", "Had a severe allergic reaction to unknown supplement.", "Excessive insoluble vitamin intake.", "Choked on a pill.", "Clogged airway by pill."));
                messagePrompt(" You are consuming an extraneous amount of supplements. You're making yourself sick.", 1500);

                return;
            }
            if (new Random().nextDouble() < .06) {
                happinessLevel = happinessLevel - 9;
                amIDeadYet(getRandomString("Choked on a tablet.", "Supplement pill overdose.", "Had a severe allergic reaction to unknown supplement.", "Excessive insoluble vitamin intake.", "Choked on a pill.", "Clogged airway by pill."));
                messagePrompt("You must feel great about yourself.", 500);

                return;
            }

            if (new Random().nextDouble() < .06) {
                happinessLevel = happinessLevel + 8;
                amIDeadYet(getRandomString("Choked on a tablet.", "Supplement pill overdose.", "Had a severe allergic reaction to unknown supplement.", "Excessive insoluble vitamin intake.", "Choked on a pill.", "Clogged airway by pill."));
                messagePrompt("Step 1 to becoming the bodybuilder you've always dreamed of.", 500);

                return;
            }

            if (new Random().nextDouble() < .06) {
                happinessLevel = happinessLevel + 9;
                amIDeadYet(getRandomString("Choked on a tablet.", "Supplement pill overdose.", "Had a severe allergic reaction to unknown supplement.", "Excessive insoluble vitamin intake.", "Choked on a pill.", "Clogged airway by pill."));
                messagePrompt("It's organic, so it must be healthy. ", 500);

                return;
            }

            if (new Random().nextDouble() < 0.01) {
                healthLevel = healthLevel - 25;
                amIDeadYet("Consumed incorrect supplements.");
                messagePrompt("Unfortunately, you bought the wrong supplements today and threw your chemistry off balance" +
                        ". \n\nYour health is worsened.", 1500);
                return;

            }

            if (new Random().nextDouble() < .15) {

                happinessLevel = happinessLevel + 8;
                netWorth = netWorth.add(new BigDecimal("30.00"));
                messagePrompt("There was a 30% OFF sale today. ", 1000);
                amIDeadYet("You just found an Easter Egg.");
                return;
            }

            amIDeadYet("n/a");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionChangeLifeStyle(View view ) {
        if (canIAffordIt("500.00")) {
            statChanges(85, -12, "500.00");
            if (new Random().nextDouble() < .07) {

                happinessLevel = happinessLevel + 7;
                healthLevel = healthLevel + 7;
                amIDeadYet("Nutrient deficiency.");
                messagePrompt("This time, it's for real!", 500);
                return;
            }
            if (new Random().nextDouble() < .07) {

                happinessLevel = happinessLevel + 11;
                healthLevel = healthLevel - 5;
                amIDeadYet("Nutrient deficiency.");
                messagePrompt("I read many internet articles. I know what I'm doing.", 500);
                return;
            }
            if (new Random().nextDouble() < .07) {

                happinessLevel = happinessLevel + 15;
                healthLevel = healthLevel - 15;
                amIDeadYet("Nutrient deficiency.");
                messagePrompt("New year, new me!", 500);
                return;
            }
            if (new Random().nextDouble() < .07) {
                happinessLevel = happinessLevel + 13;
                healthLevel = healthLevel + 4;
                amIDeadYet("Nutrient deficiency.");
                messagePrompt("I live in a privileged financial situation so I can afford to consume an all-organic diet!", 500);

                return;
            }
            amIDeadYet("Nutrient deficiency.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionYoga(View view ) {
        if (canIAffordIt("900.00")) {
            statChanges(132, -20, "900.00");
            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.03) {
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
                    healthLevel = healthLevel + 10;

                    amIDeadYet("Going too hard in yoga class.");
                    messagePrompt("You've been killin' it in Yoga, lately." +
                            "\n\nNamaste.", 500);
                    return;
                }
                if (new Random().nextDouble() < 0.12) {
                    happinessLevel = happinessLevel + 15;
                    healthLevel = healthLevel - 15;
                    amIDeadYet("Going too hard in yoga class.");
                    messagePrompt("Ommmm.....", 500);

                    return;
                }
                if (new Random().nextDouble() < 0.12) {
                    happinessLevel = happinessLevel + 15;
                    healthLevel = healthLevel - 15;
                    amIDeadYet("Going too hard in yoga class.");
                    messagePrompt("Ummmm.....", 500);
                    return;
                }
                if (new Random().nextDouble() < 0.12) {
                    happinessLevel = happinessLevel - 5;
                    healthLevel = healthLevel + 25;
                    amIDeadYet("Going too hard in yoga class.");
                    messagePrompt("You should get Chinese food after.", 500);
                    return;
                }
            }
            amIDeadYet("Going too hard in yoga class.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionDoctor(View view ) {

        if (canIAffordIt("2000.00")) {
            statChanges(242, -30, "2000.00");


            if (isSick != 0) {
                if (isSick == 1) {

                    healthDrain = healthDrain - 3;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;

                    amIDeadYet("The common cold.");
                    messagePrompt("<< The doctor has diagnosed you with the Common Cold (rhinovirus). >>" +
                            " \n\nYou have taken rest and now feel better.", 2000);
                    return;
                }
                if (isSick == 2) {

                    healthDrain = healthDrain - 5;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;
                    amIDeadYet("The flu.");
                    messagePrompt("<< The doctor has diagnosed you with the flu (Influenza). >>" +
                            " \n\nYou have taken rest and now feel better.", 2000);
                    return;
                }
                if (isSick == 3) {

                    healthDrain = healthDrain - 3;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;
                    amIDeadYet("Strep throat.");
                    messagePrompt("<< The doctor has diagnosed you with strep throat (streptococcus). >>" +
                            " \n\nYou have taken antibiotics and now feel better.", 2000);
                    return;
                }
            } else if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel + 15;
                healthLevel = healthLevel + 25;
                amIDeadYet("The wait time was too long.");
                messagePrompt(" After watching so many medical drama TV shows, you should be the one handing out advice.", 500);

                return;
            }

            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel - 20;
                amIDeadYet("The wait time was too long.");
                messagePrompt(" If you think about it, you are one doctor visit closer to your last.", 500);

                return;

            }

            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel + 20;
                healthLevel = healthLevel - 30;
                amIDeadYet("The wait time was too long.");
                messagePrompt("An apple a day probably won't keep the doctor away.", 500);

                return;
            }


            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel - 25;
                healthLevel = healthLevel - 20;
                amIDeadYet("The wait time was too long.");
                messagePrompt("'Number #0937 to the front, please.' \n\n<< Ooo! That's you! >>", 500);

                return;
            }

            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel + 25;
                healthLevel = healthLevel - 20;
                amIDeadYet("The wait time was too long.");
                messagePrompt("'Wait your turn, you peasant'.", 500);

                return;
            }

            if (new Random().nextDouble() < .0003) {
                happinessLevel = happinessLevel + 50;
                amIDeadYet("The wait time was too long.");
                messagePrompt("'I'm half homo sapien, on my mother's side.'", 2000);

                return;
            }

            if (new Random().nextDouble() < .0003) {
                happinessLevel = happinessLevel + 50;
                amIDeadYet("The wait time was too long.");
                messagePrompt("<< Are you any good at setting alarm clocks? >>", 2000);

                return;
            }

            amIDeadYet("The wait time was too long.");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionTrainer(View view ) {

        if (canIAffordIt("5000.00")) {
            statChanges(501, -50, "5000.00");

            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.04) {
                    happinessLevel = happinessLevel + 400;

                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("You overworked yourself.");
                    messagePrompt("Your attractive personal trainer insists that you should try some exercise outside" +
                            " the gym together... in private. \n\n<< You and I both know why you're paying them. >> You can" +
                            " now go on dates with your workout assistant.", 2500);
                    return;
                }
            }
            if (new Random().nextDouble() < 0.11) {
                happinessLevel = happinessLevel - 45;
                amIDeadYet("You overworked yourself.");
                messagePrompt("'Pain is just weakness leaving the body.'", 500);

                return;
            }
            if (new Random().nextDouble() < 0.11) {
                happinessLevel = happinessLevel - 35;
                healthLevel = healthLevel - 35;
                amIDeadYet("You overworked yourself.");
                messagePrompt("'No pain, no gain champ. Also, my check for this session is due by Friday.'", 500);
                return;
            }
            if (new Random().nextDouble() < 0.11) {
                happinessLevel = happinessLevel + 50;
                healthLevel = healthLevel + 35;
                amIDeadYet("You overworked yourself.");
                messagePrompt("'Your only limitation is your imagination.' \n\n'Hmm... I should copyright that.'", 500);
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                happinessLevel = happinessLevel + 35;
                healthLevel = healthLevel + 35;
                amIDeadYet("You overworked yourself.");
                messagePrompt(" It's never too late to become what you might have looked like a decade ago.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.11) {
                happinessLevel = happinessLevel - 35;
                healthLevel = healthLevel + 45;
                amIDeadYet("You overworked yourself.");
                messagePrompt("'80% of success is showing up. If showing up also included having the right body type and financial resources to afford me.'", 500);

                return;
            }
            if (new Random().nextDouble() < 0.11) {
                happinessLevel = happinessLevel - 35;
                healthLevel = healthLevel - 20;
                amIDeadYet("You overworked yourself.");
                messagePrompt("Just because you're not sick, doesn't mean you're healthy.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.11) {
                happinessLevel = happinessLevel - 45;
                healthLevel = healthLevel - 20;
                amIDeadYet("You overworked yourself.");
                messagePrompt(" This wrist workout is pretty intense.\n\n'Those are just the insurance papers.'", 500);
                return;
            }

            amIDeadYet("You overworked yourself.");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionPrivateDoctor(View view ) {
        if (canIAffordIt("12000.00")) {
            statChanges(1021, -100, "12000.00");
            if (isSick != 0) {
                if (isSick == 1) {

                    healthDrain = healthDrain - 3;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;

                    amIDeadYet("The common cold.");
                    messagePrompt("<< The doctor has diagnosed you with the Common Cold (rhinovirus). >>" +
                            " \n\nYou have taken rest and now feel better.", 2000);
                    return;
                }
                if (isSick == 2) {

                    healthDrain = healthDrain - 5;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;
                    amIDeadYet("The flu.");
                    messagePrompt("<< The doctor has diagnosed you with the flu (Influenza). >>" +
                            " \n\nYou have taken rest and now feel better.", 2000);
                    return;
                }
                if (isSick == 3) {

                    healthDrain = healthDrain - 3;
                    isSick = 0;
                    healthDrain = healthDrain - (sicknessCounter / 3);
                    sicknessCounter = 0;
                    amIDeadYet("Strep throat.");
                    messagePrompt("<< The doctor has diagnosed you with strep throat (streptococcus). >>" +
                            " \n\nYou have taken antibiotics and now feel better.", 2000);
                    return;
                }
            }
            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel - 40;
                healthLevel = healthLevel + 185;
                amIDeadYet("The doc was a radioactive alien.");
                messagePrompt("Are those hieroglyphics you wrote supposed to be English?", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel + 80;
                healthLevel = healthLevel + 150;
                amIDeadYet("The doc was a radioactive alien.");
                messagePrompt("Ahh. The sweet stench of upper class medical care.", 1000);
                return;
            }
            if (new Random().nextDouble() < .15) {
                happinessLevel = happinessLevel - 55;
                healthLevel = healthLevel - 70;
                amIDeadYet("The doc was a radioactive alien.");
                messagePrompt("First they kill your ills, then they kill you with bills.", 1000);

                return;
            }
            amIDeadYet("The doc was a radioactive alien.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionInjection(View view ) {

        if (canIAffordIt("30000.00")) {
            statChanges(2158, -200, "30000.00");

            if (new Random().nextDouble() < 0.14) {
                happinessLevel = happinessLevel - 250;
                healthLevel = healthLevel + 300;
                amIDeadYet("Why would you even try that?");
                messagePrompt("'You can trust me, I'm a medical student and we practiced this in class.'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.14) {
                happinessLevel = happinessLevel + 250;
                healthLevel = healthLevel - 300;
                amIDeadYet("Why would you even try that?");
                messagePrompt(" 'You don't have obesity because it runs in the family.'\n\n 'No one runs in the family.'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.14) {
                happinessLevel = happinessLevel - 150;
                healthLevel = healthLevel - 200;
                amIDeadYet("Why would you even try that?");
                messagePrompt("'Eenie, meenie, miney, mo. Which organ shall I poke?'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.14) {
                happinessLevel = happinessLevel - 250;
                healthLevel = healthLevel - 300;
                amIDeadYet("Why would you even try that?");
                messagePrompt("'Which vein was it, now?'", 1000);
                return;
            } else
                amIDeadYet("Why would you even try that?");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionSteroids(View view ) {
        if (canIAffordIt("75000.00")) {
            statChanges(4511, -350, "75000.00");
            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel - 100;
                healthLevel = healthLevel - 300;
                amIDeadYet("The injections were toxic.");
                messagePrompt("'Which vein was it, now?'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel + 100;
                healthLevel = healthLevel + 300;
                amIDeadYet("The injections were toxic.");
                messagePrompt("'Look son, I'm not saying these aren't natural, but hire someone else to pee in a cup for you in your next physical.'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel + 170;
                healthLevel = healthLevel - 300;
                amIDeadYet("The injections were toxic.");
                messagePrompt("'It's federally approved for cattle, you'll be fine.'", 1000);

                return;
            }
            amIDeadYet("The injections were toxic.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionExperiment(View view ) {

        if (canIAffordIt("150000.00")) {
            statChanges(7574, -500, "150000.00");

            if (new Random().nextDouble() < 0.22) {
                happinessLevel = happinessLevel - 100;
                healthLevel = healthLevel + 400;
                amIDeadYet("For science!");
                messagePrompt(" 'Don't worry, my expert team of scientists has successfully done this procedure on mice.'\n\n" +
                        "'And nearly a majority of them survived.'", 1100);
                return;
            }
            if (new Random().nextDouble() < 0.22) {
                happinessLevel = happinessLevel - 150;
                healthLevel = healthLevel - 400;
                amIDeadYet("For science!");
                messagePrompt(" 'You've got to experiment to figure out what works, ya know?'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.22) {
                happinessLevel = happinessLevel + 100;
                healthLevel = healthLevel - 200;
                amIDeadYet("For science!");
                messagePrompt(" 'We recommend saying farewell to your loved ones... just as a simple precaution.'", 1000);
                return;
            }
            amIDeadYet("For science!");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionDNA(View view ) {

        if (canIAffordIt("500000.00")) {
            statChanges(21043, -1000, "500000.00");

            if (new Random().nextDouble() < 0.16) {
                happinessLevel = happinessLevel - 700;
                healthLevel = healthLevel - 1900;

                amIDeadYet("You don't have spider powers.");
                messagePrompt("<< Sir, we cannot bio-engineer you a will to live.'", 600);
                return;
            }
            if (new Random().nextDouble() < 0.16) {
                happinessLevel = happinessLevel - 800;
                healthLevel = healthLevel + 500;

                amIDeadYet("You don't have spider powers.");
                messagePrompt(" 'It's not an experiment if you know everything will work correctly.\n\n'So yeah, it's an experiment.'", 1000);
                return;
            }
            if (new Random().nextDouble() < 0.16) {
                happinessLevel = happinessLevel + 2000;
                healthLevel = healthLevel + 1000;

                amIDeadYet("You don't have spider powers.");
                messagePrompt(" 'The next room over, they are cloning dinosaurs I hear.'", 800);
                return;
            }
            if (new Random().nextDouble() < 0.16) {
                happinessLevel = happinessLevel + 2000;
                healthLevel = healthLevel + 1000;

                amIDeadYet("You don't have spider powers.");
                messagePrompt(" 'Don't worry you are wealthy, so your safety is our top priority.'", 1000);
                return;
            }
            amIDeadYet("You don't have spider powers.");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }


    //------------------ MENTAL -------------------------------------------------------------


    public void functionTime(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new TimeFragment());
        fragmentTransaction.commitNow();
    }

    public void functionMental(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new MentalFragment());
        fragmentTransaction.commitNow();
        // if (getSupportFragmentManager().executePendingTransactions()) {
                        // Ignore stupid conditional: regex, text search thing
                        if (0 == 0) {
            if (daysNotDead < 50)
                ((TextView) findViewById(R.id.buttonHelp)).setText("Seek professional help. (LOCKED)");
            if (daysNotDead < 125)
                ((TextView) findViewById(R.id.buttonDrugs)).setText("Seek alternative medicine. (LOCKED)");
        }
    }

    public void functionHelp(View view ) {

        if (daysNotDead < 50)//15
        {
            messagePrompt("You need to have survived 50 days before seeking professional help.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new HelpFragment());
        fragmentTransaction.commitNow();
    }

    public void functionDrugs(View view ) {
        if (daysNotDead < 125)//50
        {
            messagePrompt("You need to have survived 125 days before experimenting on your body.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new DrugsFragment());
        fragmentTransaction.commitNow();
    }


    public void functionShow(View view ) {

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
                healthLevel = healthLevel - 2;
                amIDeadYet("Too sedentary of a lifestyle.");
                messagePrompt(" You've been binge-watching a lot of shows lately. Your health is starting to take a toll.", 2000);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 3;
                healthLevel = healthLevel - 1;
                amIDeadYet("Too sedentary of a lifestyle.");
                messagePrompt(" There's absolutely nothing better that you could be doing with your time.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 3;
                amIDeadYet("Too sedentary of a lifestyle.");
                messagePrompt("Another happy ending. Why can't the protagonist sit in misery?", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel - 2;
                healthLevel = healthLevel - 1;
                amIDeadYet("Too sedentary of a lifestyle.");
                messagePrompt("Well, there goes another weekend. ", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                healthLevel = healthLevel - 2;
                amIDeadYet("Too sedentary of a lifestyle.");
                messagePrompt("Sleep? Hah! Haven't heard that one in a while.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 2;
                amIDeadYet("Too sedentary of a lifestyle.");
                messagePrompt("Bummer, your laptop ran out of battery.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel - 2;
                amIDeadYet("Too sedentary of a lifestyle.");
                messagePrompt("You should have pirated this garbage instead.", 500);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 3;
                amIDeadYet("Too sedentary of a lifestyle.");
                messagePrompt("So many different movies. The same actor. Do they even age?", 1000);
                return;
            }

            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 5;
                healthLevel = healthLevel - 1;
                amIDeadYet("Too sedentary of a lifestyle.");
                messagePrompt("One more episode...", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel - 2;
                healthLevel = healthLevel - 1;
                amIDeadYet("Too sedentary of a lifestyle.");
                messagePrompt("It must get better next season.", 500);
                return;
            }

            amIDeadYet("Too sedentary of a lifestyle.");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionBook(View view ) {
        if (canIAffordIt("60.00")) {
            statChanges(-1, 16, "60.00");
            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.008) {
                    happinessLevel = happinessLevel + 30;
                    hasPartner = 1;
                    amIDeadYet("Couldn't handle all of this knowledge.");
                    messagePrompt("Although you're having a hard time finding a book, the librarian is interested in checking YOU out, instead"
                            + " *wink wink*. \n\nYou are no longer single and can now go on dates with the curator.", 2000);
                    loveDrain = 0;
                    return;
                }
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 4;
                healthLevel = healthLevel + 3;
                amIDeadYet("Couldn't handle all of this knowledge.");
                messagePrompt("Knowledge!", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel - 4;
                amIDeadYet("Couldn't handle all of this knowledge.");
                messagePrompt(" A Hollywood executive is already trying to make a movie adaptation.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel - 3;
                healthLevel = healthLevel - 1;
                amIDeadYet("Couldn't handle all of this knowledge.");
                messagePrompt(" Do you think he'll long enough to publish the next book in the series?", 600);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel - 3;
                amIDeadYet("Couldn't handle all of this knowledge.");
                messagePrompt("Your grandma would really enjoy this one.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 7;
                healthLevel = healthLevel - 3;
                amIDeadYet("Couldn't handle all of this knowledge.");
                messagePrompt("One more chapter before I go to bed...", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 6;
                healthLevel = healthLevel + 3;
                amIDeadYet("Couldn't handle all of this knowledge.");
                messagePrompt("WARNING!\n\n<< Reading can seriously damage your ignorance. >>", 600);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 2;
                amIDeadYet("Couldn't handle all of this knowledge.");
                messagePrompt("The online reviews were really great.", 500);
                return;
            }
            if (new Random().nextDouble() < 0.03) {

                happinessLevel = happinessLevel + 4;
                amIDeadYet("Couldn't handle all of this knowledge.");
                messagePrompt("This one's got a setting, plot, characters, and everything.", 500);
                return;
            }
            amIDeadYet("Couldn't handle all of this knowledge.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionMedication(View view ) {

        if (canIAffordIt("200.00")) {
            medicationCounter++;
            int temp = medicationCounter;
            statChanges(11, 28, "200.00");
            medicationCounter = temp;

            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.007) {
                    happinessLevel = happinessLevel + 55;
                    hasPartner = 1;
                    amIDeadYet("You choked on a pill.");
                    messagePrompt(" Quick, pharmacist, think fast! Do you have an inhaler? \n\nBecause YOU are taking my breath away *wink wink*. " +
                            "\n\nYou can now go on dates with the pharmacologist.", 2000);
                    loveDrain = 0;
                    return;
                }
            }

            if (new Random().nextDouble() < .50 && medicationCounter > 4) {
                healthLevel = healthLevel - 14;
                amIDeadYet("You choked on a pill.");
                messagePrompt(" You have taken well above the recommended doses of medication. Your health is taking a toll.", 1300);

                return;
            }

            if (new Random().nextDouble() < .10) {
                happinessLevel = happinessLevel - 5;
                amIDeadYet("You choked on a pill.");
                messagePrompt("Remember treatment, not prevention, is the goal.", 500);

                return;
            }
            if (new Random().nextDouble() < .10) {
                happinessLevel = happinessLevel + 8;
                amIDeadYet("You choked on a pill.");
                messagePrompt(" At least the drowsiness helps to mask the chronic suffering.", 500);

                return;
            }

            if (new Random().nextDouble() < .08) {
                healthLevel = healthLevel - 5;
                happinessLevel = happinessLevel + 5;
                amIDeadYet("You choked on a pill.");
                messagePrompt(" Half a decade ago, your doctor would have prescribed you three slaps to the face.", 500);

                return;
            }
            if (new Random().nextDouble() < 0.10) {
                happinessLevel = happinessLevel - 6;
                healthLevel = healthLevel + 6;
                amIDeadYet("You choked on a pill.");
                messagePrompt(" Laughter is the best medicine, until you start laughing for no reason. \n\nThen you actually need medicine.", 500);

                return;
            }

            if (new Random().nextDouble() < .04) {
                happinessLevel = happinessLevel + 25;
                amIDeadYet("You choked on a pill.");
                messagePrompt("Popping, popping is all we know.", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 7;
                netWorth = netWorth.add(new BigDecimal("50.00"));
                amIDeadYet("You choked on a pill.");
                messagePrompt("There was a 50% OFF sale today.", 800);

                return;
            }

            if (new Random().nextDouble() < 0.07) {
                healthLevel = healthLevel - 15;

                amIDeadYet("Took the wrong medication.");
                messagePrompt(" Unfortunately, you took the wrong medication. << I could have stopped you, but I don't intervene. >>\n\nYou " +
                        "made yourself very sick.", 2000);
                return;

            }

            amIDeadYet("Took the wrong medication.");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionBar(View view ) {
        if (canIAffordIt("500.00")) {
            barCounter++;
            int temp = barCounter;
            statChanges(-15, 94, "500.00");
            barCounter = temp;
            if (new Random().nextDouble() < .5 && barCounter > 4) {
                healthLevel = healthLevel - 15;
                amIDeadYet("Alcoholism.");
                messagePrompt(" You've been visiting the bar often. Your frequent drinking is beginning to hurt your health.", 1500);

                return;
            }
            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.06) {
                    happinessLevel = happinessLevel + 55;
                    hasPartner = 1;
                    amIDeadYet("Alcoholism.");
                    messagePrompt(" You notice an attractive individual sitting next to you. << Luckily, they appear just as hopeless as you do! >>\n\n After consuming a few drinks for a confidence boost, you ask them" +
                            " for their number and they agree to give it. " +
                            "\n\nYou can now go on dates with the drinking buddy.", 2300);
                    loveDrain = 0;
                    return;
                }
            }
            if (new Random().nextDouble() < 0.1) {
                happinessLevel = happinessLevel + 15;
                healthLevel = healthLevel - 5;
                amIDeadYet("Alcoholism.");
                messagePrompt("'You can't drink all day unless you start in the morning.'", 500);
                return;
            }
            if (new Random().nextDouble() < 0.1) {
                happinessLevel = happinessLevel + 15;
                healthLevel = healthLevel - 5;
                amIDeadYet("Alcoholism.");
                messagePrompt("'I don't drink water. Fish live in it. I'm an environmentalist.'", 500);

                return;
            }
            if (new Random().nextDouble() < 0.1) {
                if (hasPartner == 1) {
                    if ((new Random().nextDouble() < 0.40 && isMarried == 0) || (new Random().nextDouble() < 0.20 && isMarried == 1)) {
                        happinessLevel = happinessLevel + 75;
                        healthLevel = healthLevel - 20;
                        happinessDrain = happinessDrain + 5;
                        amIDeadYet("Alcoholism.");
                        messagePrompt(" You met a cute stranger last night and ended up getting very drunk. You were invited to spend the night at their place.\n\n" +
                                "Your clouded judgement got the best of you and you ended up sleeping with the stranger.\n\n" +
                                "<< You have therefore, cheated on your current partner. The consequences of your actions are to be determined. >>", 3000);

                        return;
                    }
                } else {
                    happinessLevel = happinessLevel + 45;
                    healthLevel = healthLevel - 10;
                    amIDeadYet("Alcoholism.");
                    messagePrompt("You met a cute stranger last night and ended up getting very drunk. You spent the night at their place.\n\n" +
                            "However, it was just a fling and the person doesn't wish to pursue any type of relationship. \n\nYou are still single.", 2300);

                    return;
                }
            }
            if (new Random().nextDouble() < 0.1) {
                happinessLevel = happinessLevel + 15;
                amIDeadYet("Alcoholism.");
                messagePrompt("You ended up meeting a new group of people and you got fairly tipsy. You had a great time throughout the night.", 2000);

                return;
            }
            if (new Random().nextDouble() < 0.1) {
                if (hasSecurity == 1)
                {
                    happinessLevel = happinessLevel - 25;
                    amIDeadYet("Alcoholism.");
                    messagePrompt("You got very intoxicated and became wreckless.\n\nThe bar keeper wanted to kick you out, but they noticed" +
                            " you had security with you.\n\nYou were nicely asked to leave without any trouble.", 2500);

                    return;
                }
                if (new Random().nextDouble() < .30 && canIAffordIt("50.00") == false) {
                    happinessLevel = happinessLevel - 50;
                    healthLevel = healthLevel - 20;
                    amIDeadYet("Mugged by gangsters.");
                    messagePrompt("You got very intoxicated and became wreckless. You were kicked out of the bar.\n\nYou did not have enough " +
                            "money for a taxi, so you were forced to walk home. \n\nAs you were stumbling back, you were mugged and beaten by thugs." +
                            " Your health is hurt and you need to be more careful next time.", 3000);

                    return;
                } else if (canIAffordIt("50.00") == false) {
                    happinessLevel = happinessLevel - 25;
                    healthLevel = healthLevel - 8;
                    amIDeadYet("Alcoholism.");
                    messagePrompt("You got very intoxicated and became wreckless. You were kicked out of the bar.\n\nYou did not have enough " +
                            "money for a taxi, so you were forced to walk home. \n\nFortunately, you made it home safely but" +
                            " you need to be more careful next time.", 3000);

                    return;
                } else {
                    happinessLevel = happinessLevel - 15;
                    healthLevel = healthLevel - 8;
                    amIDeadYet("Alcoholism.");
                    messagePrompt("You got very intoxicated and became wreckless. You were kicked out of the bar.\n\nFortunately, you did have " +
                            "enough money for a taxi, so you did not have to walk home. \n\nYou made it home safely but" +
                            " you need to be more careful next time.", 3000);

                    return;
                }
            }
            amIDeadYet("Alcoholism.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionGroupTherapy(View view ) {
        if (canIAffordIt("1200.00")) {
            statChanges(-14, 176, "1200.00");
            if (new Random().nextDouble() < 0.13) {
                messagePrompt(" 'So everyone's just here to talk about our problems all day, right?'", 700);
                happinessLevel = happinessLevel + 20;
            } else
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'Shut up, Allen. Let Jenny speak her mind.'", 700);
                happinessLevel = happinessLevel + 15;
            } else
            if (new Random().nextDouble() < 0.13) {
                messagePrompt(" 'I'm very shy, you know, could you just skip me?'\n'Well, I'm not completely" +
                        " shy, but I'm definitely more shy than average.'\n'I just can't seem to open up to people. Well " +
                        "it all began in my childhood...'", 800);
                happinessLevel = happinessLevel - 15;
            } else
            if (new Random().nextDouble() < 0.13) {
                messagePrompt(" 'Oh, don't feel bad sweetie. It's not your fault that your head isn't wired correctly.'", 700);
                happinessLevel = happinessLevel + 15;
            } else
            if (new Random().nextDouble() < 0.13) {
                messagePrompt(" 'I've never told anyone this before, but my dog enjoys it when I use my hand and...'", 700);
                happinessLevel = happinessLevel - 15;
            } else
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'We have a newcomer here today, please welcome...'", 700);
                happinessLevel = happinessLevel + 15;
            }
            amIDeadYet("Well that's ironic, isn't it?");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionTherapy(View view ) {
        if (canIAffordIt("3000.00")) {
            statChanges(18, 345, "3000.00");


            if (hasPartner == 0) {
                if (new Random().nextDouble() < 0.01) {
                    happinessLevel = happinessLevel + 60;

                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("Clearly they weren't very good at their job.");
                    messagePrompt("Your therapist is growing an attachment to you. You seize the opportunity and ask them" +
                            " out. \n\n<< They reluctantly agree to go out with you. >>\n\n You can now " +
                            "go on dates with your mental counselor.", 3500);
                    return;
                }
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel - 40;
                amIDeadYet("Clearly they weren't very good at their job.");
                messagePrompt("'Mhm, that's very interesting. How does that make you feel?'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 30;
                amIDeadYet("Clearly they weren't very good at their job.");
                messagePrompt("'Let's get in touch with your inner child.'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel - 25;
                amIDeadYet("Clearly they weren't very good at their job.");
                messagePrompt("'It is when therapy seems futile that it is most effective.'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel - 35;
                amIDeadYet("Clearly they weren't very good at their job.");
                messagePrompt(" 'I'm sorry, that's all we have time for today. Time is money. Well, my time, your money.'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 35;
                amIDeadYet("Clearly they weren't very good at their job.");
                messagePrompt("'Do you know what is the definition of insanity?'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 50;
                amIDeadYet("Clearly they weren't very good at their job.");
                messagePrompt("'Maybe life isn't for everyone.'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel - 40;
                amIDeadYet("Clearly they weren't very good at their job.");
                messagePrompt("'Think of your head as an unsafe neighborhood; don't go inside it alone.'", 1200);

                return;

            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel - 35;
                amIDeadYet("Clearly they weren't very good at their job.");
                messagePrompt("'How do you think we can better bottle up those negative emotions?'", 1200);

                return;
            }

            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 35;
                amIDeadYet("Clearly they weren't very good at their job.");
                messagePrompt("'You may need to seek actual medical attention.'", 1200);

                return;
            }

            if (new Random().nextDouble() < .002) {
                happinessLevel = happinessLevel + 85;

                amIDeadYet("Clearly they weren't very good at their job.");
                messagePrompt("'Doc, I've got this strange feeling that I'm inside of a game.'\n\n<< Haha. >>", 2200);

                return;
            }

            amIDeadYet("Clearly they weren't very good at their job.");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionMotivator(View view ) {
        if (canIAffordIt("8000.00")) {
            statChanges(0, 782, "8000.00");
            if (hasPartner == 0) {
                if (new Random().nextDouble() < 0.01) {
                    happinessLevel = happinessLevel + 120;
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("Clearly they weren't very good at their job.");
                    messagePrompt("You're falling in love with your mentor's wise words of wisdom and you ask them for their" +
                            " number.\n\n They agree to give it.\nYou can now go on dates with your guru. ", 2500);
                    return;
                }
            }

            if (new Random().nextDouble() < 0.15) {
                happinessLevel = happinessLevel + 120;
                messagePrompt(" Early to bed, and early to rise, deems a young man useless and sleep deprived. ", 1200);
                healthLevel = healthLevel + 100;
                amIDeadYet("Clearly they weren't very good at their job.");
                return;
            }
            if (new Random().nextDouble() < 0.16) {
                happinessLevel = happinessLevel + 120;
                messagePrompt(" It is a cliche that most cliches are true, but then like most cliches, that cliche is untrue.", 1200);
                healthLevel = healthLevel - 50;
                amIDeadYet("Clearly they weren't very good at their job.");
                return;
            }
            if (new Random().nextDouble() < 0.17) {
                //happinessLevel = happinessLevel + 120;
                messagePrompt(" One day, someone will walk into your life and make you hate yourself more than you already do. You need" +
                        " to marry that person.", 1200);
                happinessLevel = happinessLevel - 300;
                amIDeadYet("Clearly they weren't very good at their job.");
                return;
            }
            if (new Random().nextDouble() < 0.18) {
                //happinessLevel = happinessLevel + 120;
                messagePrompt("Money is the root of all evil.", 1200);
                happinessLevel = happinessLevel - 300;
                amIDeadYet("Clearly they weren't very good at their job.");
                return;
            }
            if (new Random().nextDouble() < 0.19) {
                //happinessLevel = happinessLevel + 120;
                messagePrompt("You are a fruit loop in a world of cheerios.", 1200);
                happinessLevel = happinessLevel + 300;
                amIDeadYet("Clearly they weren't very good at their job.");
                return;
            }
            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel + 200;
                messagePrompt("A secret is something you tell everybody to tell nobody.", 1200);
                //happinessLevel = happinessLevel - 300;
                amIDeadYet("Clearly they weren't very good at their job.");
                return;
            }
            if (new Random().nextDouble() < 0.20) {
                happinessLevel = happinessLevel + 200;
                messagePrompt("A clever person solves a problem. A wise person avoids it.", 1200);
                //happinessLevel = happinessLevel - 300;
                amIDeadYet("Clearly they weren't very good at their job.");
                return;
            }

            amIDeadYet("Clearly they weren't very good at their job.");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionBodyguard(View view ) {
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
                        "You can extend your contract for up to 90 days, or rehire upon expiration.", 2000);
            else
                messagePrompt("You have extended your contract to " + (securityCounter/3) + " days.", 1200);

            amIDeadYet("Bodyguards can't help you with your health.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionOpiates(View view ) {
        if (canIAffordIt("45000.00")) {
            statChanges(-210, 3390, "45000.00");


            if (new Random().nextDouble() < .15) {
                messagePrompt("'What could possibly go wrong?'\n\n<< I could just end it so easily... no one would even know. >>", 1200);
                happinessLevel = happinessLevel - 200;
                healthLevel = healthLevel - 70;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I feel like I'm rising up to the heavens!'\n\n<< That is your blood pressure. >>", 1200);
                healthLevel = healthLevel - 90;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I can taste the sound waves as they course through the air.'", 1200);
                healthLevel = healthLevel + 80;
                happinessLevel = happinessLevel + 150;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I don't even see how this could be addicting. Addiction is for losers.'", 1200);
                healthLevel = healthLevel - 80;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }
            amIDeadYet("Drugs are bad, m'kay?");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionHeroin(View view ) {
        if (canIAffordIt("90000.00")) {
            statChanges(-500, 6910, "90000.00");


            if (new Random().nextDouble() < .15) {
                messagePrompt("<< Don't do drugs because if you do drugs you'll go to prison, and drugs are really expensive in prison. >>'", 1200);
                happinessLevel = happinessLevel + 300;
                healthLevel = healthLevel - 200;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'This is normal. This is very normal. I feel normal.'", 1200);
                happinessLevel = happinessLevel + 300;
                healthLevel = healthLevel - 150;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I can taste the sound waves as they course through the air.'", 1200);
                happinessLevel = happinessLevel + 350;
                healthLevel = healthLevel + 150;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("'I don't do drugs, but they smell amazing.'", 1200);
                happinessLevel = happinessLevel + 250;
                healthLevel = healthLevel - 125;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt("<< Congratulations on successfully become emotionally constipated. >>", 1200);
                happinessLevel = happinessLevel + 200;
                healthLevel = healthLevel + 100;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }
            amIDeadYet("Drugs are bad, m'kay?");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionExperimentalDrugs(View view ) {
        if (canIAffordIt("200000.00")) {
            statChanges(-1000, 15134, "200000.00");


            if (new Random().nextDouble() < .15) {
                messagePrompt("'If God dropped acid, would he see people?'\n\n<< No. I'd see idiots. >>", 1200);
                happinessLevel = happinessLevel + 400;
                healthLevel = healthLevel - 300;
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
                healthLevel = healthLevel - 300;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt(" 'It sort of looks like artificial sweetener.'", 1200);
                happinessLevel = happinessLevel + 400;
                healthLevel = healthLevel + 300;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }

            if (new Random().nextDouble() < .15) {
                messagePrompt(" << Congratulations on successfully become emotionally constipated. >>", 1200);
                happinessLevel = happinessLevel + 500;
                healthLevel = healthLevel + 350;
                amIDeadYet("Drugs are bad, m'kay?");
                return;
            }
            amIDeadYet("Drugs are bad, m'kay?");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionPill(View view ) {
        if (canIAffordIt("500000.00")) {
            statChanges(-3000, 38335, "500000.00");
            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.09) {
                    happinessLevel = happinessLevel + 1500;
                    messagePrompt("During your visit in the private lab, you come across a very" +
                            " attractive biologist.\n\nThey notice you, and you notice them. << Clearly, you're wealthy enough for this treatment, so the stranger knows you're loaded with cash. >> \n\nYou can now go on dates with the research assistant. ", 2300);
                    hasPartner = 1;
                    loveDrain = 0;
                    amIDeadYet("You choked on the pill.");
                    return;
                }
                if (new Random().nextDouble() < 0.15) {
                    healthLevel = healthLevel + 900;
                    messagePrompt("'Reality is for people who cannot handle drugs.'\n\n<< That's not how that saying goes. >>", 1200);
                    amIDeadYet("You choked on the pill.");
                    return;
                }
                if (new Random().nextDouble() < 0.15) {
                    healthLevel = healthLevel + 900;
                    messagePrompt("<< I am judging you right now. >>", 1200);
                    amIDeadYet("You choked on the pill.");
                    return;
                }
                if (new Random().nextDouble() < 0.15) {
                    healthLevel = healthLevel + 900;
                    messagePrompt("<< Where did I go wrong with my creations? >>", 1200);
                    amIDeadYet("You choked on the pill.");
                    return;
                }
            }
            amIDeadYet("You choked on the pill.");
            amIOkayYet();

        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }


    // ---------------------- SUCCESS --------------------------------------------------------

    public void functionSaveRespawnTokens2(View view ) {
        if (daysNotDead > highScore) {
            int rT = respawnToken;
            messagePrompt(" You died after surviving " + daysNotDead + " days. A Respawn Token has been granted towards your next life." +
                    " \n\n(NEW) HIGHSCORE: " + daysNotDead + " ", 4000);
            highScore = daysNotDead;
            deathCounter = 0;
            resetStats();
            respawnToken = rT;
            updateVariables();
            ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
            else
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");
            ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
            updateHealthAndHappiness();

        } else {
            int rT = respawnToken;
            messagePrompt(" You died after surviving " + daysNotDead + " days. A Respawn Token has been granted towards your next life." +
                    "  \n\nHIGHSCORE: " + highScore, 4000);
            deathCounter = 0;
            resetStats();
            respawnToken = rT;
            updateVariables();
            ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
            else
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

            ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
            updateHealthAndHappiness();

        }
    }

    public void functionSaveRespawnTokens(View view ) {
        if (difficulty == 3)
        {
            messagePrompt("You can't reincarnate because of the difficulty you chose.", 500);
        }
        if (respawnToken == 2) { // TODO: This doesn't seem right?
            messagePrompt(" You can only reincarnate if you have no more than 1 Respawn Token.", 500);
            return;
        }
        if (respawnToken == 0) {
            messagePrompt(" You must acquire a Respawn Token before you can reincarnate.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new RespawnFragment());
        fragmentTransaction.commitNow();

    }

    public void functionSuccess(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new SuccessFragment());
        fragmentTransaction.commitNow();

        if (successMessage == 1)
        {
            successMessage = 0;
            editor.putInt("successMessage", successMessage);
            editor.apply();
            messagePrompt("TIP (!) Success is responsible for increasing your net worth.", 1000);
        }
    }

    public void functionEducation(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new EducationFragment());
        fragmentTransaction.commitNow();

        if (educationMessage == 1)
        {
            educationMessage = 0;
            editor.putInt("educationMessage", educationMessage);
            editor.apply();
            messagePrompt(" TIP (!) Taking a certain amount of college classes gives you a Degree.\n\nA college Degree allows you to get higher-paying jobs.", 1500);
        }
    }

    public void functionLottery(View view ) {
        if (lotteryCycle >= 10) {
            messagePrompt(" Your local law prohibits you from purchasing more than 10 lottery" +
                    " tickets at a time.", 500);
            return;
        }

        if (canIAffordIt("5.00")) {

            lotteryCycle++;
            int temp = lotteryCycle;
            if (new Random().nextDouble() < 0.001) {
                messagePrompt(" You won the jackpot. Congratulations!\n\n<< I'll be honest. I forget I even added this. This is incredibly rare. I'm not kidding, it's 1/10,000. >>\n\n You are rewarded $10,000,000 " +
                        "(after taxes, this sum becomes $6,612,903.50).", 30500);
                happinessLevel = happinessLevel + 5000;
                statChanges(healthDrain / -2, happinessDrain / -2, "-6612903.30");
                amIDeadYet("How did you screw this up? You won the freaking lottery.");
            } else if (new Random().nextDouble() < 0.05) {
                messagePrompt("You scratched out your ticket and...\n" +
                        "\nYou won $30!", 1100);
                happinessLevel = happinessLevel + 30;
                statChanges(healthDrain / -2, happinessDrain / -2, "-25.00");
                amIDeadYet("The poor tax (otherwise known as the lottery).");
            } else if (new Random().nextDouble() < 0.01) {
                messagePrompt("You scratched out your ticket and...\n" +
                        "\nYou won $100!", 1100);
                happinessLevel = happinessLevel + 70;
                statChanges(healthDrain / -2, happinessDrain / -2, "-95.00");
                amIDeadYet("The poor tax (otherwise known as the lottery).");
            }
            else if (lotteryCycle > 5 && new Random().nextDouble() < 0.20){
                messagePrompt("<< Nothing again. You're wasting your time. >>", 1000);
                statChanges(healthDrain / -2, happinessDrain / -2, "5.00");
                amIDeadYet("Lottery depresso.");
            } else {
                messagePrompt("You scratched out your ticket and...\n\n<< Nothing. >>", 500);
                statChanges(healthDrain / -2, happinessDrain / -2, "5.00");
                amIDeadYet("Lottery depresso.");
            }

            String s = daysNotDead + daysNotDeadText;
            ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(s); //updates the value to UI


            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
            else
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");


            lotteryCycle = temp;
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }


    public void functionCareers(View view ) {

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new CareersFragment());
        fragmentTransaction.commitNow();
        // if (getSupportFragmentManager().executePendingTransactions()) {
                        // Ignore stupid conditional: regex, text search thing
                        if (0 == 0) {
            if (isEducated < 2)
                ((TextView) findViewById(R.id.buttonCareers2)).setText("Mid level. (LOCKED)");
            if (isEducated < 4)
                ((TextView) findViewById(R.id.buttonCareers3)).setText("Top level. (LOCKED)");
        }
    }

    // ----------------------- STOCKS --------------------------------

    public void functionStockAnalysis(View view ) {
        if (canIAffordIt("750.00")) {
            netWorth = netWorth.subtract(new BigDecimal("750.00"));
            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
            else
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

            statChanges(healthLevel / 2, happinessLevel / 2, "0.00");
            //amIDeadYet("Spent too much time day trading.");
            //updates the net worth value to UI
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new StockAnalysisFragment());
            fragmentTransaction.commitNow();
            amIDeadYet("Spent too much time day trading.");
            updateVariables();
        } else {
            messagePrompt("You cannot afford this.", 500);
        }
    }

    public void functionTradingReport(View view ) {
        if (canIAffordIt("7500.00")) {
            netWorth = netWorth.subtract(new BigDecimal("7500.00"));
            if (outputStocks().equals(new BigDecimal("0.00")))
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
            else
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

            if (new Random().nextDouble() < .15 && daysNotDead > 250 && netWorth.compareTo(new BigDecimal("50000.00")) <= 0)
            {
                messagePrompt("You have been tracked and found to be getting insider trading. Insider trading is illegal.\n\nYou have received a fine of $50,000.", 3500);
                netWorth = netWorth.subtract(new BigDecimal("50000"));
            }
            statChanges(healthLevel / 2, happinessLevel / 2, "0.00");
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new StockInsiderFragment());
            fragmentTransaction.commitNow();
            amIDeadYet("Spent too much time day trading.");
            updateVariables();
        } else {
            messagePrompt("You cannot afford this.", 500);
        }

    }

    public void functionStocks(View view ) {

        if (daysNotDead < 75)//75
        {
            messagePrompt(" You must survive 75 days before trading stocks. ", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new TradeFragment());
        fragmentTransaction.commitNow();

        // if (getSupportFragmentManager().executePendingTransactions()) {
                        // Ignore stupid conditional: regex, text search thing
                        if (0 == 0) {

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

    public void functionBuyStocks(View view ) {

        //statChanges(healthLevel / 2, happinessLevel / 2, "0.00");
        //((TextView) findViewById(R.id.netWorthLabel)).setText(nW); //updates the net worth value to UI
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new StocksFragment());
        fragmentTransaction.commitNow();

        // if (getSupportFragmentManager().executePendingTransactions()) {
                        // Ignore stupid conditional: regex, text search thing
                        if (0 == 0) {
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

            amIDeadYet("Spent too much time day trading.");
        }

    }

    public void functionSellStocks(View view ) {

        //statChanges(healthLevel / 2, happinessLevel / 2, "0.00");
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Stocks2Fragment());
        fragmentTransaction.commitNow();


        // if (getSupportFragmentManager().executePendingTransactions()) {
                        // Ignore stupid conditional: regex, text search thing
                        if (0 == 0) {

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
            amIDeadYet("Spent too much time day trading.");
        }
    }

    public void functionStockAP(View view ) {

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

    public void functionStockAPsell(View view ) {

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

    public void functionStockBNN(View view ) {

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

    public void functionStockBNNsell(View view ) {

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

    public void functionStockFU(View view ) {

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

    public void functionStockFUsell(View view ) {

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

    public void functionStockFWB(View view ) {

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

    public void functionStockFWBsell(View view ) {

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

    public void functionStockET(View view ) {

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

    public void functionStockETsell(View view ) {

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

    public void functionStockIBC(View view ) {

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

    public void functionStockIBCsell(View view ) {

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

    public void functionStockKC(View view ) {

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

    public void functionStockKCsell(View view ) {

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

    public void functionStockMACA(View view ) {

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

    public void functionStockMACAsell(View view ) {

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

    public void functionStockMACB(View view ) {

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

    public void functionStockMACBsell(View view ) {

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

    public void functionStockMM(View view ) {

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

    public void functionStockMMsell(View view ) {

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

    public void functionStockNSX(View view ) {

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

    public void functionStockNSXsell(View view ) {

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

    public void functionStockRM(View view ) {

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

    public void functionStockRMsell(View view ) {

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

    public void functionStockAP5B(View view ) {

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

    public void functionStockAP25B(View view ) {

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

    public void functionStockBNN5B(View view ) {

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

    public void functionStockBNN25B(View view ) {

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

    public void functionStockFU5B(View view ) {

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

    public void functionStockFU25B(View view ) {

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

    public void functionStockFWB5B(View view ) {

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

    public void functionStockFWB25B(View view ) {

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

    public void functionStockET5B(View view ) {

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

    public void functionStockET25B(View view ) {

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

    public void functionStockIBC5B(View view ) {

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

    public void functionStockIBC25B(View view ) {

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

    public void functionStockKC5B(View view ) {

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

    public void functionStockKC25B(View view ) {

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

    public void functionStockMACA5B(View view ) {

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

    public void functionStockMACA25B(View view ) {

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

    public void functionStockMACB5B(View view ) {

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

    public void functionStockMACB25B(View view ) {

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

    public void functionStockMM5B(View view ) {

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

    public void functionStockMM25B(View view ) {

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

    public void functionStockNSX5B(View view ) {

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

    public void functionStockNSX25B(View view ) {

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

    public void functionStockRM5B(View view ) {

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

    public void functionStockRM25B(View view ) {

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

    public void functionStockAP5S(View view ) {

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

    public void functionStockAP25S(View view ) {

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

    public void functionStockBNN5S(View view ) {

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

    public void functionStockBNN25S(View view ) {

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

    public void functionStockFU5S(View view ) {

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

    public void functionStockFU25S(View view ) {

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

    public void functionStockFWB5S(View view ) {

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

    public void functionStockFWB25S(View view ) {

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

    public void functionStockET5S(View view ) {

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

    public void functionStockET25S(View view ) {

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

    public void functionStockIBC5S(View view ) {

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

    public void functionStockIBC25S(View view ) {

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

    public void functionStockKC5S(View view ) {

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

    public void functionStockKC25S(View view ) {

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

    public void functionStockMACA5S(View view ) {

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

    public void functionStockMACA25S(View view ) {

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

    public void functionStockMACB5S(View view ) {

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

    public void functionStockMACB25S(View view ) {

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

    public void functionStockMM5S(View view ) {

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

    public void functionStockMM25S(View view ) {

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

    public void functionStockNSX5S(View view ) {

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

    public void functionStockNSX25S(View view ) {

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

    public void functionStockRM5S(View view ) {

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

    public void functionStockRM25S(View view ) {

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

    public void functionStockAnalysisAP(View view ) {

        messagePrompt("<<< Stock: AP - Acquaintance Pages >>>\n" +
                "Online software development firm that specializes in social networking services.\n\n" + AP.analysisReport(), 2000);
    }

    public void functionStockAnalysisBNN(View view ) {

        messagePrompt("<<< Stock: BNN - Biased News Network >>>\n" +
                "Most popular mainstream news and television channel that is owned by lobbyists.\n\n" + BNN.analysisReport(), 2000);
    }

    public void functionStockAnalysisFU(View view ) {

        messagePrompt("<<< Stock: FU - Fracking United >>>\n" +
                "Online software development firm that specializes in social networking services.\n\n" + FU.analysisReport(), 2000);
    }

    public void functionStockAnalysisFWB(View view ) {

        messagePrompt("<<< Stock: FWB - Fair Weather Bank >>>\n" +
                "International banking and financial services company that has locations all across the globe.\n\n" + FWB.analysisReport(), 2000);
    }

    public void functionStockAnalysisET(View view ) {

        messagePrompt("<<< Stock: ET - Enterprise Connected >>>\n" +
                "Telecommunications network that specializes in 'high-speed' internet and hopefully, some mobile coverage.\n\n" + ET.analysisReport(), 2000);
    }

    public void functionStockAnalysisIBC(View view ) {

        messagePrompt("<<< Stock: IBC - International Business Corp. >>>\n" +
                "Computer hardware company that specializes in advancing electronic technologies, just before any one else does.\n\n" + IBC.analysisReport(), 2000);
    }

    public void functionStockAnalysisKC(View view ) {

        messagePrompt("<<< Stock: KC - King Cola Inc. >>>\n" +
                "Multinational beverage company that specializes in carbonated sodas and obesity.\n\n" + KC.analysisReport(), 2000);
    }

    public void functionStockAnalysisMACA(View view ) {

        messagePrompt("<<< Stock: MAC.A - Money Arc Central >>>\n" +
                "Class A stock of a multinational estate and asset management agency.\n\n" + MACA.analysisReport(), 2000);
    }

    public void functionStockAnalysisMACB(View view ) {

        messagePrompt("<<< Stock: MAC.B - Money Arc Central >>>\n" +
                "Class B stock of a multinational estate and asset management agency.\n\n" + MACB.analysisReport(), 2000);
    }

    public void functionStockAnalysisMM(View view ) {

        messagePrompt("<<< Stock: MM - Monopoly Mart >>>\n" +
                "National chain of supermarkets infamously known for its terrible wages and lackluster customer service.\n\n" + MM.analysisReport(), 2000);
    }

    public void functionStockAnalysisNSX(View view ) {

        messagePrompt("<<< Stock: NSX - National Service Energy >>>\n" +
                "Energy and natural gas corporation that vows to convince the public it is looking for a brighter future.\n\n" + NSX.analysisReport(), 2000);
    }

    public void functionStockAnalysisRM(View view ) {

        messagePrompt("<<< Stock: RM - Relative Motors >>>\n" +
                "International corporation that designs, manufactures, and distributes vehicles of questionable origins.\n\n" + RM.analysisReport(), 2000);
    }

    public void functionStockAnalysis2NSX(View view ) {

        messagePrompt("<<< Stock: NSX - National Service Energy >>>\n" +
                "\n" + NSX.insiderReport(), 2000);
    }

    public void functionStockAnalysis2AP(View view ) {

        messagePrompt("<<< Stock: AP - Acquaintance Pages >>>\n" +
                "\n" + AP.insiderReport(), 2000);
    }

    public void functionStockAnalysis2BNN(View view ) {

        messagePrompt("<<< Stock: BNN - Biased News Network >>>\n" +
                "\n" + BNN.insiderReport(), 2000);
    }

    public void functionStockAnalysis2FU(View view ) {

        messagePrompt("<<< Stock: FU - Fracking United >>>\n" +
                "\n" + FU.insiderReport(), 2000);
    }

    public void functionStockAnalysis2FWB(View view ) {

        messagePrompt("<<< Stock: FWB - Fair Weather Bank >>>\n" +
                "\n" + FWB.insiderReport(), 2000);
    }

    public void functionStockAnalysis2ET(View view ) {

        messagePrompt("<<< Stock: ET - Enterprise Connected >>>\n" +
                "\n" + ET.insiderReport(), 2000);
    }

    public void functionStockAnalysis2IBC(View view ) {

        messagePrompt("<<< Stock: IBC - International Business Corp. >>>\n" +
                "\n" + IBC.insiderReport(), 2000);
    }

    public void functionStockAnalysis2KC(View view ) {

        messagePrompt("<<< Stock: KC - King Cola Inc. >>>\n" +
                "\n" + KC.insiderReport(), 2000);
    }

    public void functionStockAnalysis2MACA(View view ) {

        messagePrompt("<<< Stock: MAC.A - Money Arc Central >>>\n" +
                "\n" + MACA.insiderReport(), 2000);
    }

    public void functionStockAnalysis2MACB(View view ) {

        messagePrompt("<<< Stock: MAC.B - Money Arc Central >>>\n" +
                "\n" + MACB.insiderReport(), 2000);
    }

    public void functionStockAnalysis2MM(View view ) {

        messagePrompt("<<< Stock: MM - Monopoly Mart >>>\n" +
                "\n" + MM.insiderReport(), 2000);
    }

    public void functionStockAnalysis2RM(View view ) {

        messagePrompt("<<< Stock: RM - Relative Motors >>>\n" +
                "\n" + RM.insiderReport(), 2000);
    }

    //----------------------------------  CAREERS ---------------------------------------------------------------
    public void functionCareers1(View view ) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Careers1Fragment());
        fragmentTransaction.commitNow();

        if (careerMessage == 1)
        {
            careerMessage = 0;
            messagePrompt(" TIP (!) Jobs are displayed with relative pay rates.\n\nFor ex. (X2.2$) means a job pays x2.2 as much as" +
                    " the starting pay.", 1500);
        }
    }

    public void functionCareers2(View view ) {
        if (isEducated < 2)
        {
            messagePrompt("You don't have a Bachelor's Degree.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Careers2Fragment());
        fragmentTransaction.commitNow();
    }

    public void functionCareers3(View view ) {
        if (isEducated < 4)
        {
            messagePrompt("You don't have a Doctorate Degree.", 500);
            return;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Careers3Fragment());
        fragmentTransaction.commitNow();
    }


    public void functionSalesJob(View view ) {
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
            amIDeadYet("Overworked yourself.");
            return;
        }

        if (jobCycle >= 30 && job2Trigger == 0 && isEducated >= 1) {
            job2Trigger = 1;
            messagePrompt(" Your position has been promoted. You can now work as a manager. ", 2000);
            happinessLevel = happinessLevel + 30;
            amIDeadYet("Overworked yourself.");
            return;
        }

        if (jobCounter > 9 && new Random().nextDouble() < 0.35) {
            messagePrompt(" You've been at work for more than three days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthLevel = healthLevel - 15;
            amIDeadYet("Overworked yourself.");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.003) {
                happinessLevel = happinessLevel + 25;
                messagePrompt("During break time, you ask one of your cute co-workers for their" +
                        " number. \n\n<< They actually gave it to you, congratulations. >>\n\nYou are no longer single and can now go on dates with your them.", 2000);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("Overworked yourself.");
                return;
            }
        }
        if (new Random().nextDouble() < 0.02) {
            messagePrompt("I promise, I don't hate myself that much.", 500);
            happinessLevel = happinessLevel - 2;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (new Random().nextDouble() < 0.02) {
            messagePrompt(" I could probably fit in a few more minutes into this break.", 500);
            happinessLevel = happinessLevel + 2;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (new Random().nextDouble() < 0.02) {
            messagePrompt(" 'This doesn't have a barcode, that means it's free right?'", 500);
            happinessLevel = happinessLevel + 2;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (new Random().nextDouble() < 0.02) {
            messagePrompt(" 'How are you doing today?' \n...\n\n'Well, I'll go screw myself then.'", 500);
            happinessLevel = happinessLevel - 2;
            amIDeadYet("Overworked yourself.");
            return;
        }

        amIDeadYet("Overworked yourself.");
        amIOkayYet();
    }

    public void functionOfficeManagerJob(View view ) {
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
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (jobCounter > 9 && new Random().nextDouble() < 0.35) {
            messagePrompt(" You've been at work for more than three days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthLevel = healthLevel - 25;
            amIDeadYet("Overworked yourself.");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.005) {
                happinessLevel = happinessLevel + 30;
                messagePrompt("You got the courage to ask one of your hot co-workers for " +
                        "their number. \n\n<< They said yes. >>\n\nYou can now go on dates with your co-worker.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("Overworked yourself.");
                return;
            }
            if (new Random().nextDouble() < 0.015) {
                messagePrompt("'This coffee is too cold. Go make another.'", 500);
                happinessLevel = happinessLevel - 3;
                amIDeadYet("Overworked yourself.");
                return;
            }
            if (new Random().nextDouble() < 0.015) {
                messagePrompt("'Just ping me an email, I'll probably get back to it ASAP.'", 500);
                happinessLevel = happinessLevel + 3;
                amIDeadYet("Overworked yourself.");
                return;
            }
            if (new Random().nextDouble() < 0.015) {
                messagePrompt("'If you want to survive here, you need to do more with less.'", 500);
                happinessLevel = happinessLevel + 3;
                amIDeadYet("Overworked yourself.");
                return;
            }
            if (new Random().nextDouble() < 0.015) {
                messagePrompt("'Mhm... yeah. I love the idea.' \n\n'But let's continue this discussion after my lunch, okay?'", 500);
                happinessLevel = happinessLevel - 3;
                amIDeadYet("Overworked yourself.");
                return;
            }
        }
        amIDeadYet("Overworked yourself.");
        amIOkayYet();

    }

    public void functionInformationOfficerJob(View view ) {
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
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (jobCycle3 == 45) {
            job4Trigger = 1;
            messagePrompt(" Congratulations! Your position has been promoted and you can now work as the Regional Manager. ", 2500);
            happinessLevel = happinessLevel + 80;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (jobCounter > 9 && new Random().nextDouble() < 0.35) {
            messagePrompt(" You've been at work for more than three days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthLevel = healthLevel - 35;
            amIDeadYet("Overworked yourself.");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.007) {
                happinessLevel = happinessLevel + 60;
                messagePrompt("You asked one of your hot office workers for their number. \n\n<< They said yes. >>\n\nYou can now go on dates " +
                        "with your co-worker.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("Overworked yourself.");
                return;
            }
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'We are not going to let our IT division dictate how this company is run!'", 500);
            happinessLevel = happinessLevel - 5;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'Hard work never killed anybody, but why take a chance?.'", 500);
            happinessLevel = happinessLevel + 5;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'No one has ever got fired around here by using THIS type of hardware.'", 500);
            happinessLevel = happinessLevel + 5;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'It feels like I am working with dinosaurs.'", 500);
            happinessLevel = happinessLevel - 5;
            amIDeadYet("Overworked yourself.");
            return;
        }
        amIDeadYet("Overworked yourself.");
        amIOkayYet();

    }

    public void functionRegionalManagerJob(View view ) {
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
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (jobCounter > 9 && new Random().nextDouble() < 0.35) {
            messagePrompt("You've been at work for more than three days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthLevel = healthLevel - 45;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.01) {
                happinessLevel = happinessLevel + 80;
                messagePrompt("You asked one of your hot office workers for a date at a nice restaurant. \n\n<< They said yes. >>\n\nYou can now go on dates " +
                        "with your co-worker.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("Overworked yourself.");
                return;
            }
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'If you want to get far in this job, you need to think OUTSIDE the box.'", 500);
            happinessLevel = happinessLevel - 5;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'Don't worry, this is surely a win-win situation.'", 500);
            happinessLevel = happinessLevel + 5;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'Let's hit the ground running.'", 500);
            happinessLevel = happinessLevel + 5;
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (new Random().nextDouble() < 0.015) {
            messagePrompt("'We need to PUSH the envelope here.'", 500);
            happinessLevel = happinessLevel - 5;
            amIDeadYet("Overworked yourself.");
            return;
        }
        amIDeadYet("Overworked yourself.");
        amIOkayYet();

    }

    public void functionJuniorConsultantJob(View view ) {
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
            amIDeadYet("Overworked yourself.");
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
            healthLevel = healthLevel - 55;
            amIDeadYet("Overworked yourself.");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.01) {
                happinessLevel = happinessLevel + 140;
                messagePrompt("You asked one of your hot office workers for a date at an expensive cuisine. \n\n<< They said yes. >>\n\nYou can now go on dates " +
                        "with your co-worker.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("Overworked yourself.");
                return;
            }
        }
        amIDeadYet("Overworked yourself.");
        amIOkayYet();

    }

    public void functionSeniorExecutiveJob(View view ) {
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
            amIDeadYet("Overworked yourself.");
            return;
        }
        if (jobCounter > 15 && new Random().nextDouble() < 0.35) {
            messagePrompt("You've been at work for more than five days now. \n\nYour health is weakening and you need some rest.", 2000);
            healthLevel = healthLevel - 65;
            amIDeadYet("Overworked yourself.");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 160;
                messagePrompt("You asked one of your sexy interns for " +
                        "their number. \n\n<< Who are they to resist a wealthy creep such as yourself? >>\n\nYou can now go on dates with your personal assistant.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("Overworked yourself.");
                return;
            }
        }
        amIDeadYet("Overworked yourself.");
        amIOkayYet();

    }

    public void functionBoardDirectorsJob(View view ) {
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
            amIDeadYet("Overworked yourself.");
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
            healthLevel = healthLevel - 95;
            amIDeadYet("Overworked yourself.");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 230;
                messagePrompt(" You asked one of your sexy interns for " +
                        "their number. \n\n<< Who are they to resist a wealthy executive like you? >>\n\nYou can now go on dates with your personal assistant.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("Overworked yourself.");
                return;
            }
        }
        amIDeadYet("Overworked yourself.");
        amIOkayYet();

    }

    public void functionChiefOperatingOfficerJob(View view ) {
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
            amIDeadYet("Overworked yourself.");
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
            healthLevel = healthLevel - 140;
            amIDeadYet("Overworked yourself.");
            return;
        }

        if (hasPartner == 0) {
            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 300;
                messagePrompt("You asked one of your sexy interns for " +
                        "their number. \n\n<< Who are they to resist a wealthy executive such as yourself? >>\n\nYou can now go on dates with your personal assistant.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("Overworked yourself.");
                return;
            }
        }
        amIDeadYet("Overworked yourself.");
        amIOkayYet();

    }

    public void functionCEOJob(View view ) {
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
            amIDeadYet("Overworked yourself.");
            return;
        }

        if (hasPartner == 0) {

            if (new Random().nextDouble() < 0.03) {
                happinessLevel = happinessLevel + 290;
                messagePrompt("The hot, young intern looked awfully attractive with those new glasses today" +
                        ". \n\n<< You run the company! They will do anything for you. >>\n\nYou can now go on dates with your personal assistant.", 2500);
                hasPartner = 1;
                loveDrain = 0;
                amIDeadYet("Overworked yourself.");
                return;
            }
        }
        amIDeadYet("Overworked yourself.");
        amIOkayYet();

    }

    public void functionCollege(View view ) {

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
                    messagePrompt("The professor has paired you up to work on a project, with a classmate you find attractive.\n\n" +
                            "<< You find they are into you, too. How pleasant? >>\n\n You are no longer single and can now go on dates with your classmate.", 2400);
                    hasPartner = 1;
                    loveDrain = 0;
                    collegeClassesTaken++;
                    amIDeadYet("n/a");
                    return;
                }
            }

            if (new Random().nextDouble() < 0.12 && collegeClassesTaken < 7) {
                happinessLevel = happinessLevel - 4;
                healthLevel = healthLevel - 2;
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
                healthLevel = healthLevel - 5;
                collegeClassesTaken++;
                messagePrompt(" You got into a fight with someone from class. << This isn't high school, tone it down, okay? >>\n\n" + (8 - collegeClassesTaken) + "" +
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
                        + "received your Bachelor's Degree.\n\n<< 'A different life is ahead of you...', or something like that. >>\n\nNew job opportunities are now available.", 2000);
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
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionGradSchool(View view ) {

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

                if (new Random().nextDouble() < 0.05) {
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
                healthLevel = healthLevel - 5;
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
                healthLevel = healthLevel - 10;
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
                        + "received your Master's Degree.\n\n<< You have reached a point in life most homo sapiens deem 'successful', I think. >>\n\n" +
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
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionPostGradSchool(View view ) {

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

                if (new Random().nextDouble() < 0.05) {
                    happinessLevel = happinessLevel + 120;
                    messagePrompt("You've been paired up to do a major assignment with some you like from grad. Turns out they like " +
                            "you too. << How pleasant? >>\n\n You are no longer single and can now go on dates with your classmate.\n\n" + (10 - gradClassesTaken) + "" +
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
                        + "received your Doctorate's Degree.\n\n << You are now in the top quadrant of the intellectual populace. I, personally, salute you. >>\n\n" +
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
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }


    // ---------------------------- LUXURY ---------------------------------------------------

    public void functionNightclub(View view ) {
        if (luxuryCounter2 < 21) {
            messagePrompt("You need to wait " + ((21 - luxuryCounter2) / 3) + " days before spending more luxury time.", 500);
            return;
        }

        if (canIAffordIt("600.00")) {
            statChanges(-20, 129, "600.00");
            luxuryDrain = 0;
            luxuryCounter2 = 0;
            if (luxuryCounter == 0)
                luxuryCounter++;

            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.12) {
                    happinessLevel = happinessLevel + 90;
                    messagePrompt("You got really wasted and ended up making out with a cutie in the bathroom.\n\n" +
                            " You are no longer single and can now go on dates with your casual clubmate.", 2500);
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
                healthLevel = healthLevel - 15;
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
                            "criminal who stole $300.\n\n<< Unfortunately, they did not hurt you. >>", 2500);
                    amIDeadYet("n/a");
                    return;

                } else {
                    healthLevel = healthLevel - 35;
                    happinessLevel = happinessLevel - 15;
                    netWorth = netWorth.subtract(netWorth);
                    messagePrompt(" As you were stumbling back home drunk, you were mugged by a petty " +
                            "criminal. \n\nSad to say, you did not have a lot of money on you, so " +
                            "they roughed you up instead. \n\n<< I could have stopped it, but I don't intervene. >>.", 3500);
                    amIDeadYet("Beaten up by a thug.");

                    return;
                }
            }
            amIDeadYet("n/a");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionVegas(View view ) {

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
                messagePrompt("You were gambling at the casino and merely by chance, you meet Corporate Sellout #36, one of the" +
                        " top senior executives from the " +
                        "company you work for! \n\nYou make acquaintances with your newfound connection and " +
                        "they are impressed by your business foresight.\n\n<< The executive board will surely take you into consideration for their next hire. >>", 3500);
                jobCEOReference = 1;
                happinessLevel = happinessLevel + 400;
                amIDeadYet("Whatever goes in Vegas, stays in Vegas.");
                return;
            }
            if (hasPartner == 0) {

                if (new Random().nextDouble() < 0.15) {
                    happinessLevel = happinessLevel + 500;
                    messagePrompt("You ended up meeting a very attractive individual at the VIP Lounge and had " +
                            "a few too many drinks. \n\n<< Alcohol does wonders, doesn't it? >> You make out at on a rooftop" +
                            " under the moonlight.\n\n" +
                            " You are no longer single and can now go on dates with the mysterious love interest.", 3000);
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
                healthLevel = healthLevel - 100;
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
                            "They beat him up and threw him in a dumpster.", 2600);
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
                            "mafioso.\n\n<< You coughed up $1000 and, unfortunately, did not suffer any injuries. >>", 2500);
                    amIDeadYet("n/a");

                    return;

                } else {
                    healthLevel = healthLevel - 95;
                    happinessLevel = happinessLevel - 75;
                    netWorth = netWorth.subtract(netWorth);
                    messagePrompt(" As you were stumbling back to your hotel suite, you were mugged by a mafioso. \n\nUnfortunately, you did not have a lot of money on you, so " +
                            "they beat you up instead. \n\n<< You should probably get some security, next time. >>", 3000);
                    amIDeadYet("Beaten by the mafia.");

                    return;
                }
            }

            if (new Random().nextDouble() < 0.08) {
                messagePrompt(" You played Poker throughout the night and gambled like a mad man. Your poker face" +
                        " is impeccable. " +
                        "\n\nYou won the $25,000 jackpot!", 2600);
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
                                " you were nicely asked to leave, despite losing them so much money.", 2600);
                        amIDeadYet("n/a");
                        return;
                    }
                    else {
                        healthLevel = healthLevel - 95;
                        happinessLevel = happinessLevel - 175;
                        netWorth = netWorth.subtract(netWorth);

                        messagePrompt(" You played Poker throughout the night and gambled like a mad man.\n\n You lost " +
                                "$10,000 and you were thrown out of the casino.\n\n<< You couldn't pay up properly, so the private security took whatever you had" +
                                " and beat you up for the rest. >>", 2600);
                        amIDeadYet("Jumped by casino staff.");
                        return;
                    }
                } else {
                    if (hasSecurity == 1)
                    {
                        happinessLevel = happinessLevel - 190;
                        messagePrompt(" You played Poker throughout the night and gambled like a mad man.\n\n Although you lost " +
                                "$10,000, you didn't want to pay up, so the casino was getting ready to kick you out.\n\nNonetheless, you had your hired security with you and" +
                                " you were nicely asked to leave, despite losing them so much money.", 2600);
                        amIDeadYet("n/a");
                        return;
                    }
                    else {
                        healthLevel = healthLevel - 20;
                        happinessLevel = happinessLevel - 600;
                        netWorth = netWorth.subtract(new BigDecimal("10000.00"));

                        messagePrompt(" You played Poker throughout the night and gambled like a mad man.\n\n You lost " +
                                "over $10,000 and you were thrown out of the casino.\n\n<< Unfortunately, you had enough money so no further " +
                                "consequence occurred. And I was getting excited too. >>", 3000);
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
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionTravelWorld(View view ) {
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
                            "\n\n<< Their deal is simple. Obtain $20,000 in the next 10 days or your partner will die. Good luck. >>", 3500);
                    happinessLevel = happinessLevel - 3500;
                    healthLevel = healthLevel - 50;
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
                    healthLevel = healthLevel - 600;
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
                healthLevel = healthLevel - 55;
                messagePrompt("'Nope, not done yet.'\n\n'Still a few pages left in my passport.'", 500);
                amIDeadYet("Got lost and died.");
                return;
            }
            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 300;
                healthLevel = healthLevel - 55;
                messagePrompt("'The hotel maids are so sweet.'\n\n'It's almost as if their financial stability depends on it.'", 500);
                amIDeadYet("Got lost and died.");
                return;
            }
            if (new Random().nextDouble() < .08) {
                happinessLevel = happinessLevel + 300;
                healthLevel = healthLevel - 55;
                messagePrompt("'Living in these exotic, dirt poor villages would be so peaceful.'\n\n'Just need to let my social media know all about it.'", 500);
                amIDeadYet("Got lost and died.");
                return;
            }
            amIDeadYet("Got lost and died.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionCar(View view ) {
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
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionSpace(View view ) {
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
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
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
            healthLevel = healthLevel - 100;
            messagePrompt("'Now, if you look to your right here we can see remnants of the flying space junk that orbits the planet.'\n\n'It is our annual tradition to add more junk onto that pile.'", 1200);
            amIDeadYet("The shuttle crashed.");
            return;
        }
        if (new Random().nextDouble() < .08) {
            happinessLevel = happinessLevel + 500;
            healthLevel = healthLevel - 100;
            messagePrompt("'If our Sun were to spontaneously explode, it would take 8 minutes for its effects to reach us!'\n\n'That gives us plenty of time to check on our virtual crop farms.'", 1200);
            amIDeadYet("The shuttle crashed.");
            return;
        }
        amIDeadYet("The shuttle crashed.");
        amIOkayYet();
    }

    public void functionMansion(View view ) {
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
                healthLevel = healthLevel - 100;
                messagePrompt("'Wow, this mansion dates back to the 16th century.'\n\n<< Doesn't that make you want to foolishly investigate " +
                        "its strange noises? >>", 1200);
                amIDeadYet("Your mansion collapsed.");
                return;
            }
            amIDeadYet("Your mansion collapsed.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionYacht(View view ) {
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
                healthLevel = healthLevel - 300;
                messagePrompt("'You're on a boat. You're on a boat.'\n\n<< Everybody, look at you, 'cause you're sailing on a boat. >>", 1200);
                amIDeadYet("Got lost in the Bermuda Triangle.");
                return;
            }
            amIDeadYet("Got lost in the Bermuda Triangle.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionToppleGovernment(View view ) {
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
            if (new Random().nextDouble() < .25) {
                happinessLevel = happinessLevel - 17000;
                healthLevel = healthLevel + 1300;
                messagePrompt("<< Nothing wrong with generously donating a couple million to a politician for a simple public speech. >>", 1200);
                amIDeadYet("Your dinner party was poisoned.");
                return;
            }
            if (new Random().nextDouble() < .25) {
                happinessLevel = happinessLevel - 17000;
                healthLevel = healthLevel + 1300;
                messagePrompt("<< Remember, you are not corrupting the government. You are offering generous donations for their hard work. >>", 1200);
                amIDeadYet("Your dinner party was poisoned.");
                return;
            }
            if (new Random().nextDouble() < .25) {
                happinessLevel = happinessLevel - 17000;
                healthLevel = healthLevel + 1300;
                messagePrompt("'It's survival of the fittest. I'm just trying to survive by not suffocating in super PAC contributions.'", 1200);
                amIDeadYet("Your dinner party was poisoned.");
                return;
            }
            if (new Random().nextDouble() < .25) {
                happinessLevel = happinessLevel - 17000;
                healthLevel = healthLevel + 1300;
                messagePrompt("'Politicians have to put food on the table too! Like caviar... and uranium...'", 1200);
                amIDeadYet("Your dinner party was poisoned.");
                return;
            }
            else if (hasSecurity == 0)
            {
                deathCounter = 3;
                happinessLevel = 0;
                healthLevel = 0;
                messagePrompt("Well, I have good news and bad news.\n\nGood news: Your plan came to fruition.\n\nBad news: You have been " +
                        "captured by guerilla rebels. Since you did not have hired security, you were assassinated.", 3000);
                amIDeadYet("Killed by rebels. Had no security.");
                return;
            }
            amIDeadYet("Your dinner party was poisoned.");
            amIOkayYet();
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }


    public void functionWinTheGame(View view ) {
        if (canIAffordIt("15000000.00") == false) {
            messagePrompt("You cannot afford to win the game.\n\n<< Yet. >>", 500);
            return;
        }
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

        hasWon = 1;
        statChanges(healthDrain, happinessDrain, "0.00");
        if (daysNotDead > highScore) {
            highScore = daysNotDead;
            messagePrompt(" << You did it. You actually did it. You f***ing beat me. >> \n\n<< If you have the time, I would highly suggest checking out the 'Purpose of Life' section to learn about the meaning of it all. >>\n\n (NEW) HIGHSCORE: " + highScore, 3500);
        } else
            messagePrompt(" << You beat me... again. I cannot believe this. >> \n\n<< Congratulations... yadda yadda yadda... What are you going to do with your life, now? >>\n" +
                    "\n HIGHSCORE: " + highScore, 3000);

        resetStats();
        return;

    }


    // ----------------------------------- LOVE ---------------------------------

    public void functionDinerDate(View view ) {
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
                amIDeadYet("Your partner poisoned you.");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I'm actually a very nice person, until you piss me off'", 1400);
                happinessLevel = happinessLevel - 2;
                amIDeadYet("Your partner poisoned you.");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I'm sorry for what I said when I was hungry.'", 1400);
                happinessLevel = happinessLevel + 2;
                amIDeadYet("Your partner poisoned you.");
                return;
            }
            amIDeadYet("Your partner poisoned you.");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
    }

    public void functionRestaurantDate(View view ) {
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
                amIDeadYet("Your partner poisoned you.");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I'm sorry for what I said when I was hungry.'", 2500);
                happinessLevel = happinessLevel + 3;
                amIDeadYet("Your partner poisoned you.");
                return;
            }
            amIDeadYet("Your partner poisoned you.");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);

    }

    public void functionCampingDate(View view ) {
        if (loveCounter < 42) {
            messagePrompt("You need to wait " + ((44 - loveCounter) / 3) + " days before going on another date.", 500);
            return;
        }

        if (canIAffordIt("10000.00")) {
            loveCounter = 0;
            loveCounter2 = 0;
            statChanges(120, 1142, "10000.00");
            loveDrain = 0;
            if (new Random().nextDouble() < 0.04 && isMarried == 0 && isEngaged == 0) {
                messagePrompt("The date went terribly. You got into an argument and your partner stormed out" +
                        "of your tent. \n\n<< A wild pack of coyotes then attacked and ate them. They died. >>\n\n You've been indirectly dumped.", 4000);
                healthDrain = healthDrain - 5;
                happinessLevel = happinessLevel - 1500;
                hasPartner = 0;
                isEngaged = 0;
                isMarried = 0;
                amIDeadYet("Your partner dumped you.");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I hope we don't get mauled by sea-bears.'", 1300);
                happinessLevel = happinessLevel + 20;
                amIDeadYet("A wild bear attack.");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I'm actually a very nice person, until you piss me off'", 1300);
                happinessLevel = happinessLevel - 10;
                amIDeadYet("A wild bear attack.");
                return;
            }
            if (new Random().nextDouble() < 0.13) {
                messagePrompt("'These mushrooms definitely seem safe for consumption...'", 1300);
                happinessLevel = happinessLevel + 8;
                amIDeadYet("Poisonous mushrooms.");
                return;
            }
            amIDeadYet("Poisonous mushrooms.");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);

    }

    public void functionRoadTripDate(View view ) {
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before going on another date.", 500);
            return;
        }

        if (canIAffordIt("40000.00")) {
            loveCounter2 = 0;
            statChanges(200, 3964, "40000.00");
            loveCounter = 0;
            loveDrain = 0;

            if (new Random().nextDouble() < 0.13) {
                messagePrompt("<< What a romantic way to get kidnapped. >>", 1200);
            } else if (new Random().nextDouble() < 0.13) {
                messagePrompt("'I hope we run into aliens.'", 1200);
            } else if (new Random().nextDouble() < 0.13) {
                messagePrompt("'Quickly! Take a picture!'", 1200);
            } else if (new Random().nextDouble() < 0.13) {
                messagePrompt("'Stop distracting me. I'm trying to enjoy the moment by taking a selfie.'", 1200);
            }
            amIDeadYet("Your vehicle rolled off a cliff and you both died.");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);

    }

    public void functionWineCruise(View view ) {
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before going on another date.", 500);
            return;
        }

        if (canIAffordIt("120000.00")) {
            loveCounter2 = 0;
            statChanges(450, 9855, "120000.00");
            loveCounter = 0;
            loveDrain = 0;
            if (new Random().nextDouble() < 0.20 && isEngaged == 0) {
                isEngaged = 1;
                messagePrompt("Slowly... you await the magic moment. As the sunset slowly started to " +
                        "creep in, and the sky fades into a pinkish hue,\n\n You pull out" +
                        " a ring and say, 'Marry me!'. Your partners overcomes the shock, replies 'Yes!' and" +
                        " doesn't realize what mistake they just made.\n\nYou are now engaged.", 3500);
                happinessLevel = happinessLevel + 5000;
                healthLevel = healthLevel + 300;
                amIDeadYet("n/a");
                return;
            }
            else if (new Random().nextDouble() < 0.13) {
                messagePrompt("If the wine hasn't lived through World War II, it's not ripe enough.", 1200);
            } else if (new Random().nextDouble() < 0.13) {
                messagePrompt("Oh yes, this one has a creamy blend and fruity bouquet...", 1200);
            } else if (new Random().nextDouble() < 0.13) {
                messagePrompt("And I call this one: The Suburban, Single Mother.", 1200);
            } else if (new Random().nextDouble() < 0.13) {
                messagePrompt("And I call this one: The Excrement of the Cobra", 1200);
            } else if (new Random().nextDouble() < 0.13) {
                messagePrompt("And I call this one: The Exploited Farmer", 1200);
            }
            amIDeadYet("Wine poisoning.");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);

    }

    public void functionPrivateIsland(View view ) {
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before going on another date.", 500);
            return;
        }

        if (canIAffordIt("250000.00")) {
            loveCounter2 = 0;
            statChanges(-300, 18011, "250000.00");
            loveCounter = 0;
            loveDrain = 0;
            if (new Random().nextDouble() < 0.25 && isEngaged == 0) {
                isEngaged = 1;
                messagePrompt("Slowly... you await the magic moment. As the sunset slowly started to " +
                        "creep in, and the sky fades into a pinkish hue,\n\n You pull out" +
                        " a ring and say, 'Marry me!'. Your partners overcomes the shock, replies 'Yes!' and" +
                        " doesn't realize what mistake they just made.\n\nYou are now engaged.", 3500);
                happinessLevel = happinessLevel + 5000;
                healthLevel = healthLevel + 300;
                amIDeadYet("Your return ship sank in the ocean.");
                return;
            } else if (new Random().nextDouble() < 0.07 && hasSecurity == 0)
            {
                messagePrompt("A series of unfortunate events have occurred. The private island " +
                        "for which you rented out has not been thoroughly checked, and as it turns out, there lives a serial killer " +
                        "in a quiet cabin deep in the forest.\n\nYou do not have security. You kick your partner in the leg to slow them down" +
                        " and you fortunately manage to get away. Your partner had to be sacrificed, unfortunately. You have been dumped.", 4000);
                happinessLevel = happinessLevel - 14000;
                healthLevel = healthLevel - 250;
                hasPartner = 0;
                isMarried = 0;
                isEngaged = 0;
                amIDeadYet("Your return ship sank in the ocean.");
                return;
            }
            else if (new Random().nextDouble() < 0.13) {

                messagePrompt("It's like Lord of the Flies but less little boys, and more whiskey.", 1200);
            }
            else if (new Random().nextDouble() < 0.13) {
                messagePrompt("Too bad we had to kick out those natives to lock this puppy down!", 1200);
            } else if (new Random().nextDouble() < 0.13) {
                messagePrompt("Look honey, the natives wish to offer us their funny-smelling essential oils.", 1200);
            } else if (new Random().nextDouble() < 0.13) {
                messagePrompt("Look honey, the natives wish to offer us their local cuisine of brightly colored frogs.", 1200);
            }
            amIDeadYet("Your return ship sank in the ocean.");
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);

    }

    public void functionMarriage(View view ) {
        if (isEngaged == 0) {
            messagePrompt(" You need to be engaged with your partner prior to marrying them.", 500);
            return;
        }
        if (isMarried == 1) {
            messagePrompt("You are already married, you buffoon.", 500);
            return;
        }
        if (loveCounter < 42) {
            messagePrompt(" You need to wait " + ((44 - loveCounter) / 3) + " days before executing a mistake of this magnitude.", 500);
            return;
        }

        if (canIAffordIt("600000.00") == true) {
            loveCounter2 = 0;
            isMarried = 1;
            loveDrain = 0;
            statChanges(-700, 35268, "600000.00");
            messagePrompt(" Today is your big day when you form a government-sanctioned bond of monogamy. You are now married, congratulations!\n\nYour Happiness drain increases after shortly coming to your senses and realizing what you have done.", 3000);

            amIDeadYet("Your partner poisons you to take your inheritance.");

            happinessDrain = happinessDrain + 75;
            if (amIDead() == false && daysNotDead % 7 != 0) {
                amIOkayYet();
            }
        } else {
            messagePrompt("You cannot afford marriage at this time.", 500);
        }

    }

    public void functionFamily(View view ) {
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
                messagePrompt(" << Children are the rotten fruit of this planet. >>\n\n<< Oh well, they are your problem now. >>\n\nYour Health drain increases after realizing the magnitude of your mistake.", 2500);
                healthDrain = healthDrain + 150;
            }
            else
            {
                messagePrompt(" << Geez, even more kids. >>\n\n << Stop overpopulating the planet with your wretched offspring. >>", 2000);
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
                messagePrompt(" <<Be careful coming so close to death. Do not abuse the system I have set up for you. >>\n\n<< Consider yourself warned. >>\n\n" +
                        "You have 16 hours left to live.", 3000);
                //netWorth.subtract(new BigDecimal("500.00"));
                return;
            } else {
                messagePrompt(" << Be careful coming so close to death. Do not abuse the system I have set up for you. >>\n\n<< Consider yourself warned. >>\n\n" +
                        "You have 8 hours left to live. This is your last chance.", 3500);
                //netWorth.subtract(new BigDecimal("500.00"));
                return;
            }
        }
        if (cheatingCounter == 30) {
            if (day == 1) {
                if (canIAffordIt("1000.00")) {
                    messagePrompt(" << You play me for a fool? Do not meddle with death, peasant. >>\n\n<< I have burned $1000. >>\n\n" +
                            "You have 16 hours left to live.", 3000);
                    netWorth = netWorth.subtract(new BigDecimal("1000.00"));
                    return;
                } else {
                    messagePrompt(" << You play me for a fool? Do not meddle with death, peasant. >>\n\n<< I have taken 100 from your Health. >>\n\n" +
                            "You have 16 hours left to live.", 3000);
                    healthLevel = healthLevel - 100;
                    if (healthLevel < -5)
                        healthLevel = -5;
                    return;
                }
            } else {
                if (canIAffordIt("1000.00")) {
                    messagePrompt(" << You play me for a fool? Do not meddle with death, peasant. >>\n\n<< I have burned $1000. >>\n\n" +
                            "You have 8 hours left to live. This is your last chance.", 3500);
                    netWorth = netWorth.subtract(new BigDecimal("1000.00"));
                    return;
                } else {
                    messagePrompt(" << You play me for a fool? Do not meddle with death, peasant. >>\n\n<< I have taken 100 from your Health. >>\n\n" +
                            "You have 8 hours left to live. This is your last chance.", 3500);
                    healthLevel = healthLevel - 100;
                    if (healthLevel < -5)
                        healthLevel = -5;
                    return;
                }
            }
        }
        if (cheatingCounter == 45) {
            if (day == 1) {
                if (isEducated == 1) {
                    messagePrompt(" << Again, you dance with me in a tango of mockery. You forget that I am the one in control of fate, not you. >>\n\n<< Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree. >>\n\n" +
                            "You have 16 hours left to live.", 3500);
                    collegeClassesTaken = collegeClassesTaken - 2;
                    return;
                }
                if (isEducated == 2) {
                    messagePrompt(" << Again, you dance with me in a tango of mockery. You forget that I am the one in control, not you. >>\n\n<< Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree. >>\n\n" +
                            "You have 16 hours left to live.", 3500);
                    gradClassesTaken = gradClassesTaken - 2;
                    return;
                }
                if (isEducated == 3) {
                    messagePrompt(" << Again, you dance with me in a tango of mockery. You forget that I am the one in control, not you. >>\n\n<< Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree. >>\n\n" +
                            "You have 16 hours left to live.", 3500);
                    postGradClassesTaken = postGradClassesTaken - 2;
                    return;
                }
            } else {
                if (isEducated == 1) {
                    messagePrompt(" << Again, you dance with me in a tango of mockery. You forget that I am the one in control, not you. >>\n\n<< Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree. >>\n\n" +
                            "You have 8 hours left to live. This is your last chance.", 3500);
                    collegeClassesTaken = collegeClassesTaken - 2;
                    return;
                }
                if (isEducated == 2) {
                    messagePrompt(" << Again, you dance with me in a tango of mockery. You forget that I am the one in control, not you. >>\n\n<< Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree. >>\n\n" +
                            "You have 8 hours left to live. This is your last chance.", 3500);
                    gradClassesTaken = gradClassesTaken - 2;
                    return;
                }
                if (isEducated == 3) {
                    messagePrompt(" << Again, you dance with me in a tango of mockery. You forget that I am the one in control, not you. >>\n\n<< Your school performance is faltering." +
                            " You have failed two classes and need to repeat those in order to continue pursuing your degree. >>\n\n" +
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
            if (healthLevel < -5)
                healthLevel = -5;
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
                    messagePrompt("You have 8 hours left to live. \n\n<< This is your last chance. >>", 1200);
            } else if (deathCounter > 3) {
                if (respawnToken == 0) {
                    if (reason.equals("n/a"))
                    {
                        if (healthLevel < 0 && happinessLevel < 0)
                            reason = new String("Chronic suffering and poor health.");
                        else if (healthLevel < 0)
                            reason = new String("Poor health.");
                        else
                            reason = new String("Chronic depression.");
                    }
                    if (daysNotDead > highScore) {
                        messagePrompt(" You died after surviving " + daysNotDead + " days. But hey, it's the longest you've survived thus far." +
                                " \n\nReason: " + reason + "\n\n(NEW) HIGHSCORE: " + daysNotDead + " ", 2500);
                        dM = 1;
                        highScore = daysNotDead;
                        deathCounter = 0;
                        resetStats();
                        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();

                    } else if (daysNotDead > 100) {
                        messagePrompt(" You died after surviving " + daysNotDead + " days. You're definitely getting a grip on this whole life thing, but you just need a bit more practice." +
                                " \n\nReason: " + reason + "\n\nHIGHSCORE: " + highScore, 2500);
                        dM = 1;
                        deathCounter = 0;
                        resetStats();
                        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();

                    } else if (daysNotDead > 50) {
                        messagePrompt(" You died after surviving " + daysNotDead + " days. You're getting better, but I am still too much of a match for you." +
                                "  \n\nReason: " + reason + "\n\nHIGHSCORE: " + highScore, 2500);
                        dM = 1;
                        deathCounter = 0;
                        resetStats();
                        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();

                    } else {
                        messagePrompt(" You died after surviving " + daysNotDead + " days. You need to try harder at living." +
                                "  \n\nReason: " + reason + "\n\nHIGHSCORE: " + highScore, 2500);
                        dM = 1;
                        deathCounter = 0;
                        resetStats();
                        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();
                    }
                } else  if (difficulty != 3){
                    messagePrompt("<< Congratulations, you died. But by your Respawn Token and the" +
                            " grace of me, you were given another chance at life. >> \n\nReason: " + reason + "\n\nYour health and happiness drain is halved.", 3500);
                    healthDrain = healthDrain / 2;
                    happinessDrain = happinessDrain / 2;
                    if (daysNotDead < 45 || daysNotDead > 55) {
//                        if (mInterstitialAd.isLoaded())
//                            mInterstitialAd.show();
//                        else {
//                            mInterstitialAd.loadAd(new AdRequest.Builder().build());
//                        }

                    }
                    if (daysNotDead > 300) {
                        happinessLevel = 755;
                        healthLevel = 755;
                        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();
                        updateVariables();
                        updateStockVariables();
                    }
                    if (daysNotDead > 200) {
                        happinessLevel = 250;
                        healthLevel = 250;
                        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
                        updateHealthAndHappiness();
                        updateVariables();
                        updateStockVariables();
                    } else {
                        happinessLevel = 90;
                        healthLevel = 90;
                        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
                        if (outputStocks().equals(new BigDecimal("0.00")))
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
                        else
                            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

                        ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
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
        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
        if (outputStocks().equals(new BigDecimal("0.00")))
            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
        else
            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

        ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
        updateHealthAndHappiness();
    }

    public void amIOkayYet() {
        if (!(amIDead() == false && daysNotDead % 7 != 0)) {
            return;
        }
        if (happinessLevel > 45 && healthLevel > 45)
            popupCounter1 = 1;
        if (happinessLevel > 50)
            popupCounter3 = 1;
        if (healthLevel > 50)
            popupCounter2 = 1;
        if (daysNotDead >= 30) {
            if (happinessLevel < 15 && healthLevel < 15 && popupCounter1 == 1) {
                popupCounter1 = 0;
                messagePrompt(" Your health and happiness are both low. \n\nYou are both sick and depressed. ", 1000);
                return;
            } else if (healthLevel < 14 && popupCounter2 == 1) {
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
            if (happinessLevel < 25 && healthLevel < 25 && popupCounter1 == 1) {
                popupCounter1 = 0;
                messagePrompt(" Your health and happiness are both low. \n\nYou are both sick and depressed. ", 1000);
                return;
            } else if (healthLevel < 24 && popupCounter2 == 1) {
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
            if (happinessLevel < 35 && healthLevel < 35 && popupCounter1 == 1) {
                popupCounter1 = 0;
                messagePrompt(" Your health and happiness are both low. \n\nYou are both sick and depressed. ", 1000);
                return;
            } else if (healthLevel < 34 && popupCounter2 == 1) {
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
            if (happinessLevel < 9 && healthLevel < 9 && popupCounter1 == 1) {
                popupCounter1 = 0;
                messagePrompt(" Your health and happiness are both low. \n\nYou are both sick and depressed. ", 1000);
                return;
            } else if (healthLevel < 8 && popupCounter2 == 1) {

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

    public void messagePrompt(String message, long delayBeforeCancelable) {

        delayBeforeCancelable = delayBeforeCancelable * (long)0.8;
        AlertDialog.Builder popupBuilder = new AlertDialog.Builder(this);
        TextView myMsg = new TextView(this);
        //TextView tv2 = (TextView)findViewById(R.id.daysSurvivedLabel);
        Typeface OswRegular = Typeface.createFromAsset(getAssets(), "fonts/Odin Rounded - Regular.otf");
        myMsg.setTypeface(OswRegular);
        myMsg.setTextSize(25);
        //myMsg.setTitle("You died");
        myMsg.setText(message);
        myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
        popupBuilder.setView(myMsg);
        final AlertDialog dialog = popupBuilder.show();
        //dialog.setCancelable(false);
        if (delayBeforeCancelable > 0) {
            dialog.setCancelable(false);
            final Timer timer2 = new Timer();
            timer2.schedule(new TimerTask() {
                public void run() {
                    dialog.setCancelable(true);
                    timer2.cancel(); //this will cancel the timer of the system
                }
            }, delayBeforeCancelable);
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
            messagePrompt("Unfortunately, you could not afford your taxes from your spendable funds.\n\n" +
                    "<< I have taken $" + netWorth.toString() + " from your account. >>\n\n" +
                    "But, you are still $" + taxCollection.toString() + " in debt.\n\n<< In 30 days, the tax collector will be back." +
                    " If you cannot pay up, you will go to prison (death or Respawn Token). >>", 3000);
            taxCollector = 1;
            netWorth = netWorth.subtract(netWorth);
        }

        messagePrompt("<< TAX SEASON DAY " + daysNotDead + " >>" +
                "\n\nTotal earnings: $" + totalEarned.toString() + "  ($" + taxOfEarnings.toString() + " taxed [1.00%])" +
                "\n\nTotal $" + netWorth.toString() + "   ($" + taxOfNetWorth.toString() + " taxed [15.00%])" +
                "\n\nTotal assets: $" + outputStocks().toString() + "   ($" + taxOfAssets.toString() + " taxed [6.00%])" +
                "\n\n\nTotal taxes: $" + taxAmount.toString(), 3000);

        netWorth = netWorth.subtract(taxAmount);

//        if (mInterstitialAd.isLoaded())
//            mInterstitialAd.show();
//        else
//        {
//            mInterstitialAd.loadAd(new AdRequest.Builder().build());
//        }


    }

    /* This functions changes the in-game stats. HealthChange changes the health, HappinessChange
       changes the happiness level accordingly. It also updates the daysNotDeadCycle to increase
       the Days Survived counter since every 3 functions, 1 day is added to not being dead
       given as long as the user is not dead
       Cost is the amount of money the function costs/produces represented by a numerical value
       in String format ex. "15.00" */

    public void statChanges(int healthChange, int happinessChange, String cost) {


        if (canIAffordIt(cost) == false) //if the user cannot afford the function
        {
            messagePrompt(getRandomString("You cannot afford that.", "You do not have enough money.", "Your balance is too low."), 500);
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
        returningPlayer = 1;
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
                        "<< Your debt is $" + taxCollection.toString() + ". But, you don't have enough funds to pay. >>\n\n" +
                        "<< Respect the tyranny of an oppressive government. I have warned you before, and now the feds have smited you. >>", 3000);
                taxCollector = 0;

            }
            else
            {
                messagePrompt("30 days have passed. The tax collector has come.\n\n" +
                        "<< Your debt is $" + taxCollection.toString() + ". Unfortunately, you had enough money to pay and " +
                        "no one has to perish today. :( >>", 3000);
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
                    healthLevel = healthLevel - 100;
                    if (healthLevel < -25)
                        healthLevel = -25;
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
                    //healthLevel = healthLevel + 50;
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

        healthLevel = healthLevel + healthChange;
        happinessLevel = happinessLevel + happinessChange;
        String s = daysNotDead + daysNotDeadText;
        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(s); //updates the value to UI


        if (outputStocks().equals(new BigDecimal("0.00")))
            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
        else
            ((TextView) findViewById(R.id.netWorthLabel)).setText("Net. W.: $" + (netWorth) + " (" + outputStocks().toString() + ")");



        happinessLevel = happinessLevel - happinessDrain; //happiness drains every round
        healthLevel = healthLevel - healthDrain;          //health drains every round
        updateHealthAndHappiness();
        lotteryCycle = 0;

        if ((daysNotDead == 50 && daysNotDeadCycle == 0) || (daysNotDead % 50 == 0 && daysNotDead % 100 != 0 && daysNotDeadCycle == 0) && difficulty != 3) {
            if (respawnToken < 2) {
                respawnToken++;
                if (respawnToken == 1) {
                    messagePrompt(" You have earned a Respawn Token!\n\n Respawn Tokens are passively stored and automatically used if you die. If " +
                            "used, your Health and Happiness drains become 1/2 as strong.", 3000);

                }
                else {
                    messagePrompt(" You have earned another Respawn Token!\n\n Respawn Tokens are passively stored and automatically used if you die. If " +
                            "used, your Health and Happiness drains become 1/2 as strong.", 2000);
//                    if (mInterstitialAd.isLoaded())
//                        mInterstitialAd.show();
//                    else
//                    {
//                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
//                    }
                }
                return;
            } else {
                messagePrompt("<< You have reached " +
                        "the maximum amount of Respawn Tokens I can give. >>\n\n << However, I want to reward you for getting this far. " +
                        "Here's a small loan of a million dollars, like I gave decades ago to one of my servants. >>", 2800);
                netWorth = netWorth.add(new BigDecimal("1000000.00"));
//                if (mInterstitialAd.isLoaded())
//                    mInterstitialAd.show();
//                else
//                {
//                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
//                }
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
                messagePrompt("TIP (!) Wall Street assets (stocks) are taxed at a much lower rate " +
                        "than your spendable funds. This will be important when taxes are collected every 90 days. \n\nHappiness drain increases by 8. ", 800);
            } else if (daysNotDead % 77 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP (!) Every 90 days, taxes are collected. The amount you pay is calculated by an algorithm" +
                        " based on how much money you have made, how much spendable funds you have, and Wall Street (stock) assets which are taxed less.\n\nHealth drain increases by 8. ", 800);
            }
        } else if (daysNotDead > 56) {
            if (daysNotDead % 70 == 0 && daysNotDeadCycle == 0) {
                messagePrompt(" You have been alive for " + daysNotDead +
                        " days now. Happiness drain increases by 5. ", 800);
            } else if (daysNotDead % 63 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP (!) You can choose reincarnation in the Success category to save your Respawn Tokens. If you do, you will restart " +
                        "the game back to Day 1, but start with 1 Respawn Token instead of 0. \n\nHealth drain increases by 5. ", 800);
            }
        } else if (daysNotDead > 42) {
            if (daysNotDead % 56 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP (!) Generally, the Luxury and Love categories will have activities that are more beneficial than " +
                        "other activities of the same price. \n\nHappiness drain increases by 4. ", 800);
            } else if (daysNotDead % 49 == 0 && daysNotDeadCycle == 0) {
                //messagePrompt("TIP (!) Generally, the Luxury and Love categories will have activities that are more beneficial than " +
                //"other activities of the same price. \n\nHealth drain increases by 3. ", 800);
            }
        } else if (daysNotDead > 28) {
            if (daysNotDead % 42 == 0 && daysNotDeadCycle == 0) {
                if (hasPartner == 0)
                    messagePrompt("TIP (!) It would be wise to go out in search of a partner. To meet someone, try to go to social places.\n\n Happiness drain increases by 3. ", 1500);
                else
                    messagePrompt("TIP (!) You have a partner so don't forget to go out on dates! They are more effective than most activities at making you happy.\n\n Happiness drain increases by 3. ", 1500);

            } else if (daysNotDead % 35 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP (!) Visiting the Luxury category allows you to go out and progress the story. Although, you probably can't afford most " +
                        "of it yet.\n\nHealth drain increases by 3. ", 1500);
            }
        } else if (daysNotDead > 14) {
            if (daysNotDead % 28 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP (!) Clicking on the purple Respawn Token to the right allows you to see how much your Health and Happiness decreases by, along with the number of Respawn Tokens (if any). \n" +
                        "\nHappiness drain increases by 2. ", 1500);
            } else if (daysNotDead % 21 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP (!) Save up your money for education. Eventually, you can learn your way to a higher-paying job. \n\nHealth drain increases by 2. ", 1500);
            }
        } else if (daysNotDead > 0) {
            if (daysNotDead % 14 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP (!) Once your Health or Happiness hit zero, you enter a 24 hour buffer zone or eventually, die. Use this to your advantage by accomplishing the most punishing tasks during this time.\n\nHappiness drain increases by 1. ", 1500);
            } else if (daysNotDead % 7 == 0 && daysNotDeadCycle == 0) {
                messagePrompt("TIP (!) A handful of inexpensive activities will be more effective than" +
                        " a few expensive ones. However, as your drains increase, this will become less effective and you will need more expensive alternatives.\n\nHealth drain increases by 1. ", 1500);
            }
        }
        if (daysNotDead > 2 && dayMessage == 1 && returningPlayer == 1)
        {
            dayMessage = 0;
            messagePrompt("Congratulations! You have survived " + daysNotDead + " days.\n\nEvery 3 events you click, equals 1 day of survival. The days you survive represent your score!", 1200);
        }
        if (loveCounter2 > 90)
        {
            if (hasPartner == 1 && isMarried == 0 && isEngaged == 0) {
                messagePrompt("It's been over a month since your last date. You have not been returning texts or calls.\n\n<< I regret" +
                        " to inform you, but your partner has broken up with you. >>\n\nYou are again single. Your happiness took a deep" +
                        " blow.", 3000);
                hasPartner = 0;
                isEngaged = 0;
                isMarried = 0;
                happinessLevel = happinessLevel - 150;
                updateHealthAndHappiness();
            }
            else if (hasPartner == 1 && isEngaged == 1 && isMarried == 0 && loveCounter2 > 180) {
                messagePrompt("It's been over two months since your last date. You have not been returning texts or calls.\n\n<< I regret" +
                        " to inform you, but your fiance has broken up with you. >>\n\nYou are now single, and are no longer eligible to get married.", 3000);
                happinessLevel = happinessLevel - 400;
                hasPartner = 0;
                isEngaged = 0;
                isMarried = 0;
                updateHealthAndHappiness();
            }
            else if (isMarried == 1)
            {
                if (loveCounter2 > 270)
                {
                    messagePrompt("It's been over three months since your last date. You have not been returning texts or calls.\n\n<< I regret" +
                            " to inform you, but your partner has divorced you. >>\n\nYou are now single, and have lost half of your spendable funds.", 3500);
                    happinessLevel = happinessLevel - 1000;
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
        if (happinessLevel < 0 || healthLevel < 0) {
            return true;
        } else
            return false;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://com.losersimulator.divergenteuropeans/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://com.losersimulator.divergenteuropeans/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
    }

    public void functionSkipTut(View view ) {
        functionPhysical(null);
        messagePrompt("<< Well, since you skipped the tutorial - I'll never show it again. >>\n\n<< After close, click anywhere on your statuses, or swipe the screen from left to right. >>", 1600);
    }

    public void functionDone(View view ) {
        functionPhysical(null);
        messagePrompt("<< After closing this message, starting from the left side of the screen, swipe from left to right to open the menu. >>\n\n<< Or click anywhere on your health. >>", 1500);
    }

    public class Stock {
        public int movingPeriod;
        private int movingPeriodOriginal;
        public BigDecimal value;
        //Volatility 1(low-low) 2(low) 3(low-med) 4(med)
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
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
            else
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

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
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
            else
                ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

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
//        if (mInterstitialAd.isLoaded())
//            mInterstitialAd.show();
//        else
//        {
//            mInterstitialAd.loadAd(new AdRequest.Builder().build());
//        }

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        resetVariables();
        initVariablesFromSave();

        // Reset helpful TIP (!) messages
        successMessage = 0;
        dayMessage = 0;
        resetStocks();


        ((TextView) findViewById(R.id.daysSurvivedLabel)).setText(daysNotDead + daysNotDeadText);
        if (outputStocks().equals(new BigDecimal("0.00")))
            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth));
        else
            ((TextView) findViewById(R.id.netWorthLabel)).setText("$" + (netWorth) + " (" + outputStocks().toString() + ")");

        ((TextView) findViewById(R.id.highScoreLabel)).setText("Highscore: " + highScore);
        updateHealthAndHappiness();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new DifficultyFragment());
        fragmentTransaction.commitNow();

        //messagePrompt("Choose a difficulty.", 1200);

    }

    void updateHealthAndHappiness() {
        ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgress(happinessLevel);
        if (happinessLevel > 4000) {
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#ffcc99"));
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(12000);
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(12000);
            ((TextView) findViewById(R.id.happinessTierSymbol)).setText("*****");
        } else if (happinessLevel > 1350) {
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#ffff99"));
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(4000);
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(4000);
            ((TextView) findViewById(R.id.happinessTierSymbol)).setText("****");
        } else if (happinessLevel > 450) {
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#ffffcc"));
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(1350);
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(1350);
            ((TextView) findViewById(R.id.happinessTierSymbol)).setText("***");
        } else if (happinessLevel > 150) {
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#ccffcc"));
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(450);
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(450);
            ((TextView) findViewById(R.id.happinessTierSymbol)).setText("**");
        } else if (happinessLevel > 50) {
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#ccffff"));
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(150);
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(150);
            ((TextView) findViewById(R.id.happinessTierSymbol)).setText("*");
        } else {
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgressColor(Color.parseColor("#b3d9ff"));
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setMax(50);
            ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setSecondaryProgress(50);
            ((TextView) findViewById(R.id.happinessTierSymbol)).setText("");
        }
        if (firstTimeHappinessIndicator == 0 && happinessLevel > 50)
        {
            firstTimeHappinessIndicator = 1;
            messagePrompt(" TIP (!) After closing this message, notice the color of your Happiness bar changed. " +
                    "\n\nYour Happiness did not go down. Instead, you have reached the next tier.", 1200);
        }
        ((RoundCornerProgressBar) findViewById(R.id.happinessBar)).setProgress(happinessLevel);

        ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgress(healthLevel);
        if (healthLevel > 4000) {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#b3ccff"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(12000);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(12000);
            ((TextView) findViewById(R.id.healthTierSymbol)).setText("*****");
        } else if (healthLevel > 1350) {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#ccccff"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(4000);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(4000);
            ((TextView) findViewById(R.id.healthTierSymbol)).setText("****");
        } else if (healthLevel > 450) {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#dab3ff"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(1350);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(1350);
            ((TextView) findViewById(R.id.healthTierSymbol)).setText("***");
        } else if (healthLevel > 150) {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#ff99ff"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(450);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(450);
            ((TextView) findViewById(R.id.healthTierSymbol)).setText("**");
        } else if (healthLevel > 50) {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#ff99cc"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(150);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(150);
            ((TextView) findViewById(R.id.healthTierSymbol)).setText("*");
        } else {
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgressColor(Color.parseColor("#ff9999"));
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setMax(50);
            ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setSecondaryProgress(50);
            ((TextView) findViewById(R.id.healthTierSymbol)).setText("");
        }
        if (firstTimeHealthIndicator == 0 && healthLevel > 50)
        {
            firstTimeHealthIndicator = 1;
            messagePrompt(" TIP (!) After closing this message, notice the color of your Health bar changed. \n" +
                    "\n" +
                    "You have filled your Health meter and are now in the second tier.", 1200);
        }
        ((RoundCornerProgressBar) findViewById(R.id.healthBar)).setProgress(healthLevel);
    }

    void functionHome() {
        functionPhysical(null);
    }
}





