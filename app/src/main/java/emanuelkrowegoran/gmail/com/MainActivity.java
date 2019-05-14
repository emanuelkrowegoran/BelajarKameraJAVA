package emanuelkrowegoran.gmail.com;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private static final int Image_Capture_Code = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCamera = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnCamera.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent cint = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cint, Image_Capture_Code);
            }
        });
    }

    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if (requestCode == Image_Capture_Code) {
            if (resultCode == RESULT_OK) {
                Bitmap fto = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(fto);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cacelled", Toast.LENGTH_LONG).show();
            }
        }}}


