package sg.edu.rp.c346.id22035660.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    String wordClicked = "";
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonUOB);
        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error Translation");
            tvUOB.setText("Error Translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");
        menu.add(0, 2, 2, "Toggle Favorite");

        if (v == btnDBS) {
            wordClicked = "DBS";
        }
        if (v == btnOCBC) {
            wordClicked = "OCBC";

        } else if (v == btnUOB)
            wordClicked = "UOB";
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
                startActivity(intentWeb);
                return true;

            } if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18001111111"));
                startActivity(intentCall);
                return true;

            } else if (item.getItemId() == 2) {
                    isDBSFavorite = !isDBSFavorite;

                    if (isDBSFavorite) {
                        tvDBS.setTextColor(Color.RED);
                    } else {
                        tvDBS.setTextColor(Color.BLACK);
                    }

                    return true;
            }
        }

        if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);
                return true;
            } if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18003633333"));
                startActivity(intentCall);

            } else if (item.getItemId() == 2) {
                    isOCBCFavorite = !isOCBCFavorite;

                    if (isOCBCFavorite) {
                        tvOCBC.setTextColor(Color.RED);
                    } else {
                        tvOCBC.setTextColor(Color.BLACK);
                    }
                    return true;
                }
            }

            if (wordClicked.equalsIgnoreCase("uob")) {
                if (item.getItemId() == 0) {
                    Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                    startActivity(intentWeb);
                    return true;
                }
                if (item.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18002222121"));
                    startActivity(intentCall);
                    return true;

                } else if (item.getItemId() == 2) {
                    isUOBFavorite = !isUOBFavorite;

                    if (isUOBFavorite) {
                        tvUOB.setTextColor(Color.RED);
                    } else {
                        tvUOB.setTextColor(Color.BLACK);
                    }

                    return true;
                }
            }
        return super.onContextItemSelected(item);
    }
    boolean isDBSFavorite = false;
    boolean isOCBCFavorite = false;
    boolean isUOBFavorite = false;


}